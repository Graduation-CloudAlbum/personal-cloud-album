package cn.yznu.pca.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取字符串中的数字
 * 截取扩容服务中套餐包含的数字
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

}
