package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.FriendVerificationMapper;
import cn.yznu.pca.dao.PermissionGroupMapper;
import cn.yznu.pca.dao.UserMapper;
import cn.yznu.pca.dao.UserRelationMapper;
import cn.yznu.pca.model.FriendVerification;
import cn.yznu.pca.model.PermissionGroup;
import cn.yznu.pca.model.User;
import cn.yznu.pca.model.UserRelation;
import cn.yznu.pca.model.example.PermissionGroupExample;
import cn.yznu.pca.model.example.UserExample;
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

    @Autowired
    UserMapper userMapper;

    @Autowired
    FriendVerificationMapper friendVerificationMapper;

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

    @Override
    public void addFriend(User user, int user_two,int permisssion_type) {
        UserRelation userRelation=new UserRelation();
        UserRelation userRelation2=new UserRelation();
        userRelation.setUserId(user.getId());
        userRelation.setUserIdTwo(user_two);
        userRelation.setStatus("0");
        userRelation.setPermissionGroupId(1);
        userRelation.setPermissionGroupIdTwo(1);
        userRelation2.setUserId(user_two);
        userRelation2.setUserIdTwo(user.getId());
        userRelation2.setStatus("0");
        userRelation2.setPermissionGroupId(permisssion_type);
        userRelation2.setPermissionGroupIdTwo(1);
        userRelationMapper.insert(userRelation);
        userRelationMapper.insert(userRelation2);
    }

    @Override
    public List<User> selectFriendByUsername(String username) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<User> list=userMapper.selectByExample(userExample);
        return list;
    }

    @Override
    public void addFriendVerification(String note2, int userIdOne, int userIdTwo) {
        FriendVerification friendVerification=new FriendVerification();
        friendVerification.setStatus("0");
        friendVerification.setUserId(userIdOne);
        friendVerification.setFriendId(userIdTwo);
        friendVerification.setNote(note2);
        friendVerification.setState(0);
        friendVerificationMapper.insert(friendVerification);
    }

    @Override
    public void passFriendVerification(int userIdOne, int userIdTwo) {

    }

    @Override
    public List <UserRelation> selectExistFriend(int userIdOne, int userIdTwo) {
        UserRelationExample userRelationExample=new UserRelationExample();
        UserRelationExample.Criteria criteria = userRelationExample.createCriteria();
        criteria.andUserIdEqualTo(userIdOne);
        criteria.andUserIdTwoEqualTo(userIdTwo);
        List <UserRelation> userRelationList=userRelationMapper.selectByExample(userRelationExample);
        return userRelationList;
    }

}
