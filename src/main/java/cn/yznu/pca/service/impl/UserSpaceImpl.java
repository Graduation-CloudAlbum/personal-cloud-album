package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.UserSpaceMapper;
import cn.yznu.pca.model.UserSpace;
import cn.yznu.pca.service.UserSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangbaiwan
 * @date 2019-03-15
 */
@Service
public class UserSpaceImpl implements UserSpaceService {
    @Autowired
    UserSpaceMapper userSpaceMapper;

    @Override
    public int initSpace(UserSpace space) {
        return userSpaceMapper.insert(space);
    }

    @Override
    public UserSpace getSpace(int userId) {
        return userSpaceMapper.selectByUserId(userId);
    }


    @Override
    public UserSpace updateSpace(int userId, String intial, String all, String used, String available) {
        return userSpaceMapper.updateByUserId(userId,intial,all,used,available);
    }


}
