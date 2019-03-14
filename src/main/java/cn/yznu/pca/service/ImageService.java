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
     * 用户在某个相册的照片
     * @param status 照片位置（非回收站）
     * @param userId 用户id
     * @param albumId 相册id
     * @return list
     */
    List getImage(String status,Integer userId, Integer albumId);

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
     * 通过照片id删除照片
     * @param imageId 照片id
     * @return
     */
    int deleteImageById(Integer[] imageId);

    /**
     * 通过相册id删除照片
     * @param albumId 照片id
     * @return
     */
    int deleteImageByAlbumId(Integer albumId);

    /**
     * 移动照片
     * @param imageId 照片id
     * @param albumId 目标相册id
     * @return
     */
    int updateImage(Integer[] imageId,int albumId);

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
     * @return 照片数量
     */
    int imageNum(int userId,int albumId);

    /**
     * 获取相册的最新的一张照片
     * @param userId 用户id
     * @param albumId 相册id
     * @return image
     */
    Image getFirstOne(int userId,int albumId);
}
