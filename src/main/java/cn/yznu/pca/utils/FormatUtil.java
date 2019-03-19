package cn.yznu.pca.utils;

/**
 * 内存大小转换工具类
 * @author yangbaiwan
 * @date 2018-11-07
 */
public class FormatUtil {

    /**
     * 字节转换KB/MB/GB
     * @param size
     * @return
     */
    public static String toRise(String size){
        Long fsize = Long.valueOf(size);
        //KB
        String size1="1024";
        //MB
        String size2="1048576";
        //GB
        String size3="1073741824";
        //TB
        String size4="1099511627776";
        Long KB= Long.valueOf(size1);
        Long MB= Long.valueOf(size2);
        Long GB= Long.valueOf(size3);
        Long TB= Long.valueOf(size4);
        String fileSizeString;
         if (fsize>0&&fsize < KB) {
            //2f表示保留两位小数
            fileSizeString = String.format("%.4f", fsize.doubleValue()) + "B";
        } else if (fsize>=KB&&fsize < MB) {
            fileSizeString = String.format("%.4f", fsize.doubleValue()/1024 )+ "KB";
        } else if (fsize>=MB&&fsize < GB) {
            fileSizeString = String.format("%.4f", fsize.doubleValue()/1024/1024) + "MB";
        } else if (fsize>=GB&&fsize < TB){
            fileSizeString = String.format("%.4f", fsize.doubleValue()/1024/1024/1024) + "GB";
        }else {
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

    /**
     * 转换百分比，保留四位小数，四舍五入
     * @param size1
     * @param size2
     * @return
     */
    public static String toPercent(String size1,String size2){
        Double percent;
        Double num1= Double.valueOf(size1);
        Double num2= Double.valueOf(size2);
        if (num1>num2) {
            percent =(num2/num1);
        }else{
            percent =num1/num2 ;
        }
        return String.format("%.4f", percent);
    }

    public static void main(String[] args) {
        //System.out.println(FormatUtil.toPercent("1073741824","5055672"));
        //System.out.println(FormatUtil.toRise("1073741824"));
        //String size4="1099511627776";
        //System.out.println(Long.valueOf(size4)/1024/1024/1024);
    }
}
