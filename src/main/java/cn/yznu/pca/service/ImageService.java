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
     * 用户所有照片
     * @param id 用户id
     * @return list
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

    /**
     * 用户所有照片数量
     * @param userId 用户id
     * @return 所有照片数量
     */
    int getAllImageNum(int userId);

    /**
     * 获取用户在某个相册里的所有照片数量
     * @param userId 用户id
     * @param albumId 相册id
     * @return 照片树龄
     */
    int imageNum(int userId,int albumId);
}
