package cn.yznu.pca.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * @author yangbaiwan
 * @date 2018-11-07
 */
public class DateUtil {
    public static void main(String[] args) throws ParseException {

        System.out.println(dateFormate("Fri Oct 19 22:41:58 CST 2018 "));



}
public static String dateFormate(String cstTime) throws ParseException{
    //String cstTime="Fri Oct 19 22:41:58 CST 2018 ";
    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
    Date date = sdf.parse(cstTime);
    String formatStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
   return formatStr;
}

}
