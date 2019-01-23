package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.PermissionGroupMapper;
import cn.yznu.pca.dao.UserRelationMapper;
import cn.yznu.pca.model.PermissionGroup;
import cn.yznu.pca.model.User;
import cn.yznu.pca.model.UserRelation;
import cn.yznu.pca.model.example.PermissionGroupExample;
import cn.yznu.pca.model.example.UserRelationExample;
import cn.yznu.pca.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    PermissionGroupMapper permissionGroupMapper;

    @Autowired
    UserRelationMapper userRelationMapper;
    @Override
    public List<?> selectFriendGroup(User user) {
        PermissionGroupExample permissionGroupExample=new PermissionGroupExample();
        PermissionGroupExample.Criteria criteria = permissionGroupExample.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        permissionGroupExample.setOrderByClause("id");
        List<?> list = permissionGroupMapper.selectByExample(permissionGroupExample);
        return list;
    }

    @Override
    public List<UserRelation> selectMyFriend(User user) {
        UserRelationExample userRelationExample=new UserRelationExample();
        UserRelationExample.Criteria criteria = userRelationExample.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        criteria.andPermissionGroupIdEqualTo(1);
        userRelationExample.setOrderByClause("id");
        List<UserRelation> list = userRelationMapper.selectByExample(userRelationExample);
        return list;
    }

    @Override
    public List<?> selectMyFamily(User user) {
        UserRelationExample userRelationExample=new UserRelationExample();
        UserRelationExample.Criteria criteria = userRelationExample.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        criteria.andPermissionGroupIdEqualTo(2);
        userRelationExample.setOrderByClause("id");
        List<?> list = userRelationMapper.selectByExample(userRelationExample);
        return list;
    }

    @Override
    public List<?> selectMyColleague(User user) {
        UserRelationExample userRelationExample=new UserRelationExample();
        UserRelationExample.Criteria criteria = userRelationExample.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        criteria.andPermissionGroupIdEqualTo(3);
        userRelationExample.setOrderByClause("id");
        List<?> list = userRelationMapper.selectByExample(userRelationExample);
        return list;
    }

    @Override
    public List<?> selectMyClassmate(User user) {
        UserRelationExample userRelationExample=new UserRelationExample();
        UserRelationExample.Criteria criteria = userRelationExample.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        criteria.andPermissionGroupIdEqualTo(4);
        userRelationExample.setOrderByClause("id");
        List<?> list = userRelationMapper.selectByExample(userRelationExample);
        return list;
    }

    @Override
    public List<?> selectMyStranger(User user) {
        UserRelationExample userRelationExample=new UserRelationExample();
        UserRelationExample.Criteria criteria = userRelationExample.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        criteria.andPermissionGroupIdEqualTo(5);
        userRelationExample.setOrderByClause("id");
        List<?> list = userRelationMapper.selectByExample(userRelationExample);
        return list;
    }
}
