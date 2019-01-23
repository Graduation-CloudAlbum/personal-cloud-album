package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.AlbumMapper;
import cn.yznu.pca.model.User;
import cn.yznu.pca.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangbaiwan
 * @date 2018-12-18
 */
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumMapper mapper;
    @Override
    public int getAlbumNum(int userId) {

        return mapper.countAlbum(userId);
    }
}
