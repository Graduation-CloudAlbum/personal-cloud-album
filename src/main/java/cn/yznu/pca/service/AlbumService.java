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
     * 根据修改时间排序
     * @param userId 用户id
     * @return
     */
    List getAlbumByTime(int userId);

    /**
     * 根据相册名排序(首字母A-Z)
     * @param userId 用户id
     * @return
     */
    List getAlbumByName(int userId);

    /**
     * 根据主题名排序(首字母A-Z)
     * @param userId 用户id
     * @return
     */
    List getAlbumByTheme(int userId);

    /**
     * 创建相册
     * @param album 相册对象
     * @return
     */
    int createAlbum(Album album);

    /**
     * 删除相册
     * @param albumId 相册id
     * @return
     */
    int deleteAlbum(int albumId,String status);

    /**
     * 修改相册
     * @param albumId 相册id
     * @return
     */
    int updateAlbum(int albumId,String albumName,String status,String theme);

    /**
     * 通过相册名查找相册
     * @param userId 用户id
     * @param albumName 相册名
     * @return
     */
    List selectAlbumByName(int userId,String albumName);
}
