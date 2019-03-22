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


    public static String randomNum( ) {


        String randnum = String.valueOf((int)(Math.random()*(9999-1000+1))+1000);


        return randnum;
    }
    public static void main(String[] args) {
        System.out.println(Onumber());

    }
}
