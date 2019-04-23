package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.UserPromissionMapper;
import cn.yznu.pca.model.UserPromission;
import cn.yznu.pca.service.UserPromissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author yangbaiwan
 * @date 2019-04-23
 */
@Service
public class UserPromissionServiceImpl implements UserPromissionService {

    @Autowired
    private UserPromissionMapper userPromissionMapper;

    @Override
    public boolean deletePromission(int albumId) {

        return userPromissionMapper.deleteAllByAlbumId(albumId);
    }

    @Override
    public List<UserPromission> selectByAlbumId(Integer albumId) {
        return userPromissionMapper.selectByAlbumId(albumId);
    }
}
