package cn.yznu.pca.service;

import cn.yznu.pca.model.UserPromission;

import java.util.List;

/**
 * @author yangbaiwan
 * @date 2019-04-23
 */
public interface UserPromissionService {
    boolean deletePromission(int albumId);
    List<UserPromission> selectByAlbumId(Integer albumId);
}
