package cn.yznu.pca.controller;

import cn.yznu.pca.model.PurchaseRecord;
import cn.yznu.pca.model.User;
import cn.yznu.pca.model.UserSpace;
import cn.yznu.pca.service.PurchaseRecordService;
import cn.yznu.pca.service.UserSpaceService;
import cn.yznu.pca.utils.*;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.Product;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author yangbaiwan
 * @date 2019-03-11
 */
@Controller
@RequestMapping("/alipay")
public class AlipayController {

    final static Logger log = LoggerFactory.getLogger(AlipayController.class);

    @Autowired
    private PurchaseRecordService purchaseRecordService;

    @Autowired
    private UserSpaceService userSpaceService;

    @Autowired
    private Sid sid;

    /**
     * 进入确认页面
     * @param meal 选择的套餐服务
     * @return
     * @throws Exception
     */
    @RequestMapping("/goConfirm/{meal}")
    public ModelAndView goConfirm(@PathVariable("meal")String meal, HttpServletRequest request) throws Exception {
        //@Param("productName")String productName, @Param("payment")String payment,
        System.out.println("选择的套餐是:"+meal);
        int meal1=10;
        int meal2=35;
        int meal3=50;
        String productName="";
        int payment=0;

        if (Integer.parseInt(meal)==meal1){
             productName="黄金套餐(包含10个G的额外使用空间)";
             payment=10;
        }else if(Integer.parseInt(meal)==meal2) {
             productName="铂金套餐(包含50个G的额外使用空间)";
             payment = 35;

        }else if (Integer.parseInt(meal)==meal3){
             productName="钻石套餐(包含100个G的额外使用空间)";
             payment=50;
        }else {
            productName="自定义购买额外使用空间";
            payment=50;
        }
        //request.getSession().setAttribute("productName",productName);
        //request.getSession().setAttribute("payment",payment);
        ModelAndView mv = new ModelAndView("goConfirm");
        mv.addObject("productName", productName);
        mv.addObject("payment", payment);
        System.out.println("商品名是："+productName);
        System.out.println("价格是："+payment);
        return mv;
    }

    /**
     * 分段提交
     * 	第一段：创建订单，保存订单
     * @param order
     * @return
     * @throws Exception
     */
    //@RequestMapping("/createOrder")
    //@ResponseBody
    //public String createOrder(@Param("productName")String productName, @Param("payment")String payment,PurchaseRecord pcr,HttpServletRequest request) throws Exception {
    //    User user= (User) request.getSession().getAttribute("user");
    //    int userId=user.getId();
    //    //String payment=(String) request.getSession().getAttribute("payment");
    //    String orderId = Sid.Onumber();
    //    pcr.setUserId(userId);
    //    pcr.setId(orderId);
    //    pcr.setCreateTime(new Date());
    //    pcr.setProductName(productName);
    //    pcr.setPayment(payment);
    //    pcr.setStatus(OrderStatusEnum.WAIT_PAY.key);
    //    purchaseRecordService.saveOrder(pcr);
    //
    //    return orderId;
    //}

    @RequestMapping("/createOrder")
    public ModelAndView createOrder(@Param("productName")String productName, @Param("payment")String payment,PurchaseRecord order,HttpServletRequest request) throws Exception {
        User user= (User) request.getSession().getAttribute("user");
            int userId=user.getId();
        String orderId = Sid.Onumber();
        productName=new String(request.getParameter("productName").getBytes("ISO-8859-1"),"utf-8") ;
        order.setId(orderId);
        order.setUserId(userId);
        order.setStatus(OrderStatusEnum.WAIT_PAY.key);
        order.setProductName(productName);
        order.setPayment(payment);
        purchaseRecordService.saveOrder(order);

        ModelAndView mv = new ModelAndView("goPay");
        mv.addObject("order", order);

        return mv;
    }
    /**
     * 分段提交
     * 	第二段,创建订单，准备付款
     * @param orderId
     * @return
     * @throws Exception
     */
    @RequestMapping("/goPay/{orderId}")
    public ModelAndView goPay(@PathVariable("orderId") String orderId) throws Exception {
        System.out.println("goPay接收到的订单id是："+orderId);
        PurchaseRecord order = purchaseRecordService.getOrderById(orderId);
        System.out.println(orderId);
        System.out.println("********开始创建订单*********");
        System.out.println("订单编号是："+order.getId());
        System.out.println("商品是："+order.getProductName());
        System.out.println("金额是："+order.getPayment());
        ModelAndView mv = new ModelAndView("goPay");
        mv.addObject("order", order);
        return mv;
    }

    /**
     *
     * @Description: 前往支付宝第三方网关进行支付
     */
    @RequestMapping(value = "/goAlipay", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String goAlipay(@Param("orderId") String orderId, HttpServletRequest request, HttpServletRequest response) throws Exception {
        System.out.println("orderId是:"+orderId);
        PurchaseRecord order = purchaseRecordService.getOrderById(orderId);

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no =orderId;
        //付款金额，必填
        String total_amount = String.valueOf(Float.valueOf(order.getPayment()));
        //订单名称，必填
        String subject = order.getProductName();
        //商品描述，可空
        String body = "用户订购商品：" +order.getProductName();

        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "1c";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        return result;
    }

    /**
     * @Description: 支付宝同步通知页面
     */
    @RequestMapping(value = "/alipayReturnNotice")
    public ModelAndView alipayReturnNotice(HttpServletRequest request, HttpServletRequest response) throws Exception {

        log.info("支付成功, 进入同步通知接口...");

        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);

        ModelAndView mv = new ModelAndView("myAlbum");
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

            // 修改订单状态，改为 支付成功，已付款
            purchaseRecordService.updateOrderStatus(out_trade_no, trade_no, total_amount);

            PurchaseRecord order = purchaseRecordService.getOrderById(out_trade_no);


            //支付成功后开始扩容空间
            User user= (User) request.getSession().getAttribute("user");
            //获取扩容前的空间使用情况
            UserSpace userSpace=userSpaceService.getSpace(user.getId());
            //总空间
            String all=userSpace.getAllSpace();
            //已用空间
            String used=userSpace.getUsedSpace();
            //扩容的空间
            String num= StrUtil.strToNumber(order.getProductName());
            String expand=FormatUtil.toByte(num);
            System.out.println("-------expand大小是："+expand);
            /**
             * 新总空间=旧的总空间+扩容空间
             * 新的可用空间=新的总空间-已使用空间
             */
            //计算新的总空间
            String allNew=FormatUtil.add(expand,all);
            System.out.println("-------新的总空间是："+allNew);
            //计算新的可用空间
            String availableNew=FormatUtil.minus(allNew,used);
            //更新用户空间信息
           userSpaceService.updateSpace(user.getId(),allNew,used,availableNew);


            log.info("********************** 支付成功(支付宝同步通知) **********************");
            log.info("* 订单号: {}", out_trade_no);
            log.info("* 支付宝交易号: {}", trade_no);
            log.info("* 实付金额: {}", total_amount);
            log.info("* 购买产品: {}", order.getProductName());
            log.info("***************************************************************");


            mv.addObject("out_trade_no", out_trade_no);
            mv.addObject("trade_no", trade_no);
            mv.addObject("total_amount", total_amount);
            mv.addObject("productName", order.getProductName());

        }else {
            log.info("支付, 验签失败...");
        }

        return mv;
    }
    /**
     *
     * @Description: 支付宝异步 通知页面
     */
    @RequestMapping("/alipayNotifyNotice")
    @ResponseBody
    public String alipayNotifyNotice(HttpServletRequest request, HttpServletRequest response) throws Exception {

        log.info("支付成功, 进入异步通知接口...");

        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
//			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——

		/* 实际验证过程建议商户务必添加以下校验：
		1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
		2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
		3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
		4、验证app_id是否为该商户本身。
		*/
        if (signVerified) {//验证成功
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            if (trade_status.equals("TRADE_FINISHED")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意： 尚自习的订单没有退款功能, 这个条件判断是进不来的, 所以此处不必写代码
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
            } else if (trade_status.equals("TRADE_SUCCESS")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //付款完成后，支付宝系统发送该交易状态通知

                // 修改订单状态，改为 支付成功，已付款
                purchaseRecordService.updateOrderStatus(out_trade_no, trade_status, total_amount);

                PurchaseRecord order = purchaseRecordService.getOrderById(out_trade_no);

                log.info("********************** 支付成功(支付宝异步通知) **********************");
                log.info("* 订单号: {}", out_trade_no);
                log.info("* 交易状态: {}", trade_status);
                log.info("* 实付金额: {}", total_amount);
                log.info("* 购买产品: {}", order.getProductName());
                log.info("***************************************************************");
            }
            log.info("支付成功...");

        } else {//验证失败
            log.info("支付, 验签失败...");
        }

        return "success";
    }
}
