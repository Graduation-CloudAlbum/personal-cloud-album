package cn.yznu.pca.utils;

import java.security.MessageDigest;

/**
 * MD5加密工具类,32位小写
 * @author yangbaiwan
 * @date 2018-08-24
 */
public class MD5Util {
    /**
     * 转换为16进制
     * @param bytes
     * @return result
     */
    public static String convertByteToHexString(byte[] bytes){
        String result = "";
        for(int i=0;i<bytes.length;i++){
            //0xff表示16进制的整数
            int temp = bytes[i]&0xff;
            //转换为16进制的字符串
            String tempHex = Integer.toHexString(temp);
            if(tempHex.length()<2){
                result +="0"+tempHex;
            }else{
                result +=tempHex;
            }
        }

        return result;
    }

    /**
     * 进行MD5加密
     * @param message
     * @return temp
     */
    public static String md5Jdk(String message){
        String temp = "";
        try{
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            byte[] encodeMd5Digest = md5Digest.digest(message.getBytes());
            temp = convertByteToHexString(encodeMd5Digest);
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * @param args
     */
    //public static void main(String[] args) {
    //    // TODO Auto-generated method stub
    //    String md5Encode1 = md5Jdk("admin");
    //    String md5Encode2 = md5Jdk("admin");
    //    System.out.println(md5Encode1.equals(md5Encode2));
    //    System.out.println(md5Encode1);
    //}

}
