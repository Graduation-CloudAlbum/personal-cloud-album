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

}
