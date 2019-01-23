package cn.yznu.pca.service;

import cn.yznu.pca.model.Image;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangbaiwan
 * @date 2018-10-19
 */
public interface ImageService {
    /**
     * 获取所有照片
     * @return
     */
    List<Image> getAllImages(Integer id);

    /**
     * 上传照片
     * @param image
     * return  成功返回1，失败返回0
     */
    int upload(Image image);

    /**
     * 下载照片
     * @param image
     * return  成功返回1，失败返回0
     */
    int download(Image image);

    int getImageNum(int userId);
}
