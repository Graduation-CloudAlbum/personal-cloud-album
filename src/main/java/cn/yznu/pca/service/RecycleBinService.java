package cn.yznu.pca.service;

import cn.yznu.pca.model.RecycleBin;

import java.util.List;

/**
 * @author yangbaiwan
 * @date 2019-03-04
 */
public interface RecycleBinService {
    /**
     * 获取用户回收站
     * @param userId 用户id
     * @return
     */
    List<RecycleBin> getRecycleBin(int userId);


    /**
     * 批量删除回收站里的相片
     * @param list 用户id
     * @return
     */
    boolean delManyRecycleBin(List list);


    /**
     * 批量还原回收站到相册
     * @param list 用户id集合
     * @return
     */
    boolean recoverSomeImage(List list);

    /**
     * 批量还原相册
     * @param list 用户id集合
     * @return
     */
    boolean updateAlbumByList(List list);

    /**
     * 根据id查询
     * @param list 用户id集合
     * @return
     */
    List<RecycleBin> selectAlbumByList(List list);

    /**
     * 批量删除相册表里的相片
     * @param list 用户id
     * @return
     */
    boolean deleteImageByList(List list);

    /**
     * 批量删除相册表里的相片
     * @param id 用户id
     * @return
     */
    boolean deleteAllRecycleBin(int id);

    /**
     * 批量删除相册表里的相片
     * @param list 用户相片
     * @return
     */
    boolean recoverAllRecycleBin(List list);

}
