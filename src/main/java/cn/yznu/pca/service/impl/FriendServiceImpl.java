package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.FriendVerificationMapper;
import cn.yznu.pca.dao.PermissionGroupMapper;
import cn.yznu.pca.dao.UserMapper;
import cn.yznu.pca.dao.UserRelationMapper;
import cn.yznu.pca.model.FriendVerification;
import cn.yznu.pca.model.PermissionGroup;
import cn.yznu.pca.model.User;
import cn.yznu.pca.model.UserRelation;
import cn.yznu.pca.model.example.FriendVerificationExample;
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
    public void addFriend(User user, int user_two,
                          int permisssionGroupId,int permisssionGroupIdTwo) {
        UserRelation userRelation=new UserRelation();
        UserRelation userRelation2=new UserRelation();
        userRelation.setUserId(user.getId());
        userRelation.setUserIdTwo(user_two);
        userRelation.setStatus("0");
        userRelation.setPermissionGroupId(permisssionGroupId);
        userRelation.setPermissionGroupIdTwo(1);
        userRelation2.setUserId(user_two);
        userRelation2.setUserIdTwo(user.getId());
        userRelation2.setStatus("0");
        userRelation2.setPermissionGroupId(permisssionGroupIdTwo);
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
    public void addFriendVerification(String note2, User userIdOne, User userIdTwo) {
        FriendVerification friendVerification=new FriendVerification();
        System.out.println("addFriendVerification输出测试"+userIdOne.getId());
        System.out.println("addFriendVerification2输出测试"+userIdTwo.getId());
        friendVerification.setStatus("0");
        friendVerification.setUserId(userIdOne.getId());
        friendVerification.setFriendId(userIdTwo.getId());
        friendVerification.setNote(note2);
        friendVerification.setState(0);
        friendVerificationMapper.insert(friendVerification);
    }

    @Override
    public void passFriendVerification(int friendVerificationId) {
        FriendVerification friendVerification=new FriendVerification();
        FriendVerificationExample friendVerificationExample=new FriendVerificationExample();
        FriendVerificationExample.Criteria criteria = friendVerificationExample.createCriteria();
        criteria.andIdEqualTo(friendVerificationId);
        friendVerification.setState(1);
        friendVerificationMapper.updateByExampleSelective(friendVerification,friendVerificationExample);

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

    @Override
    public int selectAddFriendGroup(int userId, String permisssion_type) {
        PermissionGroupExample permissionGroupExample=new PermissionGroupExample();
        PermissionGroupExample.Criteria criteria = permissionGroupExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andPermissionTypeEqualTo(permisssion_type);
        List <PermissionGroup> permissionGroup=permissionGroupMapper.selectByExample(permissionGroupExample);
        int permissionGroupId = 0;
        for(PermissionGroup s:permissionGroup){
            permissionGroupId=s.getId();
        }
        return permissionGroupId;
    }

    @Override
    public List<FriendVerification> selectAllFriendVerification(User user) {
        List <FriendVerification> list=friendVerificationMapper.selectAllFriendVerification(user.getId());
        for (FriendVerification s:list){
            System.out.println(s.getFriend().getId()+"Serviceimpl查询到的该用户下所有验证消息为"+s.getUser().getNickName()
                    +"请求加你为好友"+"验证消息为"+s.getNote());
        }
        return list;
    }

    @Override
    public List<FriendVerification> test(  ) {
        List<FriendVerification> fvListRefUser=friendVerificationMapper.getFvListRefUser();
        for (FriendVerification s :fvListRefUser){
            System.out.println("wwwwwwwwwwwwwww"+s.getFriend().getNickName());
        }
        return  fvListRefUser;
    }

}
