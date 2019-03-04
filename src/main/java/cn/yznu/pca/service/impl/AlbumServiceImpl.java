package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.AlbumMapper;
import cn.yznu.pca.model.Album;
import cn.yznu.pca.model.User;
import cn.yznu.pca.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public List getAlbum(int userId) {

        return mapper.selectAlbumInfo(userId);
    }

    @Override
    public int createAlbum(Album album) {
        return mapper.insert(album);
    }

    @Override
    public int deleteAlbum(int albumId,String status) {
        return mapper.updateById(status,albumId);
    }

    @Override
    public List selectAlbumByName(int userId, String albumName) {
        return mapper.selectAlbumByName(userId,albumName);
    }
}
