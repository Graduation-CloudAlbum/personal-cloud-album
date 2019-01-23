package cn.yznu.pca.service;

import cn.yznu.pca.model.User;
import org.springframework.stereotype.Service;

/**
 * @author yangbaiwan
 * @date 2018-12-18
 */
public interface AlbumService {
    //int getAlbumNum(User user);

    int getAlbumNum(int userId);
}
