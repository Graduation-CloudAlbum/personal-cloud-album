package cn.yznu.pca.utils;

import java.math.BigInteger;
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
    public static String Onumber( ) {


        String orderNo = (sdf.format(new Date()));
        //生成
        //Integer orderNo =Integer.parseInt(sdf.format(new Date()));
        return orderNo;
    }

    /**
     * 生成注册用的随机激活码
     * @return
     */
    public static String randomNum( ) {


        String randnum = String.valueOf((int)(Math.random()*(9999-1000+1))+1000);


        return randnum;
    }

    public static String resetPass(){
        String str = "";
        char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Random random = new Random();
        for (int i = 0; i <8; i++){
            char num = ch[random.nextInt(ch.length)];
            str += num;
        }
        return str;
    }

    public static void main(String[] args) {
        //System.out.println(Onumber());
        System.out.println(resetPass());
    }
}
