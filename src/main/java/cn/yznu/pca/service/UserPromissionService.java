package cn.yznu.pca.service;

import cn.yznu.pca.model.UserPromission;

import java.util.List;

/**
 * @author yangbaiwan
 * @date 2019-04-23
 */
public interface UserPromissionService {
    /**
     * 删除用户对相册的访问权限
     * @param albumId
     * @return
     */
    boolean deletePromission(int albumId);

    /**
     * 查询用户的可访问的相册
     * @param albumId
     * @return
     */
    List<UserPromission> selectByAlbumId(Integer albumId);
}
