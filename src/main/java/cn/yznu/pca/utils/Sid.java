package cn.yznu.pca.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 订单编号生成工具类
 * 采用系统当前时间精确到毫秒+3为随机数方式生成
 * @author yangbaiwan
 * @date 2019-03-11
 */
public class Sid {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /**
     * 生成订单号
     *
     * @param
     * @return
     */
    public static int Onumber( ) {
        //三位随机数
        //为变量赋随机值100-999;
        int random=new Random().nextInt(900)+100;

        //生成
        Integer orderNo =Integer.parseInt(sdf.format(new Date()) + (1 + (int) (Math.random() * 10000)) + random);
        return orderNo;
    }
    //public static void main(String[] args) {
    //    System.out.println(Onumber());
    //}
}
