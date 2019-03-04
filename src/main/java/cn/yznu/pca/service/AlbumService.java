package cn.yznu.pca.service;

import cn.yznu.pca.model.Album;

import java.util.List;

/**
 * @author yangbaiwan
 * @date 2018-12-18
 */
public interface AlbumService {
    /**
     * 获取用户相册数量
     * @param userId 用户id
     * @return
     */
    int getAlbumNum(int userId);

    /**
     * 获取用户相册内容
     * @param userId 用户id
     * @return
     */
    List getAlbum(int userId);

    /**
     * 创建相册
     * @param albumName 相册名
     * @return
     */
    int createAlbum(Album albumName);

    /**
     * 删除相册
     * @param albumId 相册id
     * @return
     */
    int deleteAlbum(int albumId,String status);

    /**
     * 通过相册名查找相册
     * @param userId 用户id
     * @param albumName 相册名
     * @return
     */
    List selectAlbumByName(int userId,String albumName);
}
