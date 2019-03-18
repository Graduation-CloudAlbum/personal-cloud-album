package cn.yznu.pca.utils;

/**
 * 图片大小转换工具类
 * @author yangbaiwan
 * @date 2018-11-07
 */
public class FormatUtil {
    public static String format(long size){
        float fsize = size;
        String fileSizeString;
        if (fsize < 1024) {
            //2f表示保留两位小数
            fileSizeString = String.format("%.2f", fsize) + "B";
        } else if (fsize < 1048576) {
            fileSizeString = String.format("%.2f", fsize/1024) + "KB";
        } else if (fsize < 1073741824) {
            fileSizeString = String.format("%.2f", fsize/1024/1024) + "MB";
        } else if (fsize < 1024 * 1024 * 1024) {
            fileSizeString = String.format("%.2f", fsize/1024/1024/1024) + "GB";
        } else {
            fileSizeString = "0B";
        }
        return fileSizeString;
    }

    /**
     * 千兆字节GB转换成B(字节)
     * @param size 要转换的数量
     * @return
     */
    public static String toByte(String size){
        String fileSizeString;
         Long val= Long.valueOf(size)*1024*1024*1024;
        fileSizeString=String.valueOf(val);

        return fileSizeString;
    }

    /**
     * 求和计算
     * @param size1 参数1
     * @param size2 参数2
     * @return
     */
    public static String add(String size1,String size2){
        String sum;
        Long num1=  Long.valueOf(size1);
        Long num2=  Long.valueOf(size2);
        sum=Long.toString(num1+num2);

        return sum;
    }

    /**
     * 求差计算
     * @param size1 参数1
     * @param size2 参数2
     * @return
     */
    public static String minus(String size1,String size2){
        String dValue;
        Long num1= Long.valueOf(size1);
        Long num2= Long.valueOf(size2);

        if (num1>num2) {
            dValue = Long.toString(num1 - num2);
        }else{
            dValue = Long.toString(num2 - num1);
        }
        return dValue;
    }

    //public static void main(String[] args) {
    //    System.out.println(FormatUtil.toByte("10"));
    //}
}
