package cn.yznu.pca.service;

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
    List getRecycleBin(int userId);

    /**
     * 单个删除回收站里的相册
     * @param userId 用户id
     * @param albumId 相册id
     * @return
     */
    int deleteRecycleBin(int userId,int albumId);

    /**
     * 批量删除回收站里的相册
     * @param userId 用户id
     * @param albumId 相册id
     * @return
     */
    int delManyRecycleBin(int userId,int[] albumId);

    /**
     * 还原回收站到相册
     * @param userId 用户id
     * @param albumId 相册id
     * @return
     */
    int RecoverRecycleBin(int userId,int albumId);

    /**
     * 批量还原回收站到相册
     * @param userId 用户id
     * @param albumId 相册id
     * @return
     */
    int RecoverRecycleBin(int userId,int[] albumId);
}
