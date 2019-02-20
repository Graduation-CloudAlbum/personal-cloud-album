package cn.yznu.pca.service;


import cn.yznu.pca.model.User;

import java.util.List;

/**
 * @author yangbaiwan
 * @date 2018-12-18
 */
public interface AlbumService {
    int getAlbumNum(int userId);

    List getAlbumInfo(int userId);
}
