package cn.yznu.pca.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取字符串中的数字
 * @author yangbaiwan
 * @date 2019-03-15
 */
public class StrUtil {
    public static String strToNumber(String str){
        //String a="love23next234csdn3423javaeye";
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);

        return m.replaceAll("").trim();
    }

    //public static void main(String[] args) {
    //    System.out.println(strToNumber("购买产品: 铂金会员(包含50个G的额外使用空间)"));
    //}

}
