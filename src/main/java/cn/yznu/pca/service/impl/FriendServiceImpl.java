package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.*;
import cn.yznu.pca.model.*;
import cn.yznu.pca.model.example.FriendVerificationExample;
import cn.yznu.pca.model.example.PermissionGroupExample;
import cn.yznu.pca.model.example.UserExample;
import cn.yznu.pca.model.example.UserRelationExample;
import cn.yznu.pca.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    PermissionGroupMapper permissionGroupMapper;

    @Autowired
    UserRelationMapper userRelationMapper;

    @Autowired
    UserPromissionMapper userPromissionMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    AlbumMapper albumMapper;

    @Autowired
    FriendVerificationMapper friendVerificationMapper;

    @Override
    public List<?> selectAllMyFriend(User user) {
        List <UserRelation> list=userRelationMapper.selectAllMyFriend(user.getId());
        return  list;
    }

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
    public List<UserRelation> selectMyFriend(User user,int i) {
        List <UserRelation> list=userRelationMapper.selectMyFriend(user.getId(),i);
        return list;
    }

    @Override
    public void addFriend(User user, int user_two,
                          int permisssionGroupId,int permisssionGroupIdTwo) {
        UserRelation userRelation=new UserRelation();
        UserRelation userRelation2=new UserRelation();
        userRelation.setUserId(user.getId());
        userRelation.setUserIdTwo(user_two);
        userRelation.setStatus("1");
        userRelation.setPermissionGroupId(permisssionGroupId);
        userRelation.setPermissionGroupIdTwo(1);
        userRelation2.setUserId(user_two);
        userRelation2.setUserIdTwo(user.getId());
        userRelation2.setStatus("1");
        userRelation2.setPermissionGroupId(permisssionGroupIdTwo);
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
        return list;
    }

    @Override
    public List<FriendVerification> selectAllSandFriendVerification(User user) {
        List <FriendVerification> list=friendVerificationMapper.selectAllSandFriendVerification(user.getId());
        return list;
    }

    @Override
    public int selectPermissionGroupId(User user,String type) {
        PermissionGroupExample permissionGroupExample=new PermissionGroupExample();
        PermissionGroupExample.Criteria criteria = permissionGroupExample.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        criteria.andPermissionTypeEqualTo(type);
        List <PermissionGroup> permissionGroup=permissionGroupMapper.selectByExample(permissionGroupExample);
        int permissionGroupId = 0;
        for(PermissionGroup s:permissionGroup){
            permissionGroupId=s.getId();
        }
        return permissionGroupId;
    }

    @Override
    public boolean createFriendsGroup(User user, String groupname) {
        PermissionGroup permissionGroup=new PermissionGroup();
        permissionGroup.setPermissionType(groupname);
        permissionGroup.setUserId(user.getId());
        permissionGroup.setStatus("0");
        permissionGroupMapper.insert(permissionGroup);
        return true;
    }

    @Override
    public boolean checkFriendsGroup(User user, String groupname) {
        PermissionGroupExample permissionGroupExample=new PermissionGroupExample();
        PermissionGroupExample.Criteria criteria = permissionGroupExample.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        criteria.andPermissionTypeEqualTo(groupname);
        List <PermissionGroup> permissionGroup=permissionGroupMapper.selectByExample(permissionGroupExample);
        if(permissionGroup.size()==0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<User> searchFriends(String nickName) {
        List <User> users=userMapper.searchFriends(nickName);
        for(User s:users){
            System.out.println("搜索条件是"+nickName);
            System.out.println("service输出的值"+s.getUserIcon());
        }
        return users;
    }

    @Override
    public boolean deleteFriendsGroup(int defaultpermissionGroupId,int permissionGroupId) {
        userRelationMapper.moveFriendsToDefault(defaultpermissionGroupId,permissionGroupId);
        permissionGroupMapper.deleteFriendGroup(permissionGroupId);
        return true;
    }

    @Override
    public boolean checkAlbumPower(int albumId) {
        List<Album> list=albumMapper.checkAlbumPower(albumId);
        String power="0";
        for(Album album:list){
             power=album.getStatus();
        }
        System.out.println("大权限的值"+power);
        if(power.equals("1")){
            System.out.println("大权现是"+"true");
            return true;
        }else {
            System.out.println("大权现是"+"false");
            return false;
        }
    }

    @Override
    public int checkFriendPower(int user_id, int friend_id, int albumId) {
        List<UserPromission> list=userPromissionMapper.checkFriendPower(user_id,friend_id,albumId);
        //为空赋值为3
        if(list.size()==0){
            System.out.println("小权现是"+"3");
            return 3;
        }
        //不为空则正常赋值
        else {
            int power=0;
            for(UserPromission userPromission:list){
                power=userPromission.getJurisdiction();
            }
            System.out.println("小权现是"+power);
            return power;

        }

    }

    @Override
    public boolean refusedfriendVerifications(int user_id, int friend_id, int friendVerifications_id) {
        friendVerificationMapper.refusedfriendVerifications(friendVerifications_id);
        userRelationMapper.deleteUserRelation(user_id,friend_id);
        userRelationMapper.deleteUserRelation(friend_id,user_id);
        return true;
    }

    @Override
    public boolean deleteFriendVerifications(int friendVerifications_id) {
        boolean a=friendVerificationMapper.deleteFriendVerifications(friendVerifications_id);
        if(a){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<FriendVerification> test(  ) {
        List<FriendVerification> fvListRefUser=friendVerificationMapper.getFvListRefUser();
        for (FriendVerification s :fvListRefUser){
        }
        return  fvListRefUser;
    }

    @Override
    public int searchFriendsGroup(User user, String groupname) {

        return permissionGroupMapper.searchFriendsGroup(user.getId(),groupname).getId();
    }

    @Override
    public boolean moveFriendToNewGroup(User user, User user1, int friendsGroupId) {
        return userRelationMapper.moveFriendsToNewGroup(user.getId(),user1.getId(),friendsGroupId);
    }

    @Override
    public boolean deleteFriends(User user, User user1) {
        return userRelationMapper.deleteUserRelation(user.getId(),user1.getId());
    }

    @Override
    public boolean acceptfriendVerifications(int user_id, int user_id_two, int friendsGroup_id,int friendVerifications_id_Two) {
        userRelationMapper.updateUserRelationStatus(user_id,user_id_two);
        userRelationMapper.updateUserRelationStatus(user_id_two,user_id);
        userRelationMapper.moveFriendsToNewGroup(user_id,user_id_two,friendsGroup_id);
        friendVerificationMapper.passfriendVerifications(friendVerifications_id_Two);
        return false;
    }

    @Override
    public int seachFriendIdByFriendVerifications(int friendVerifications_id_Two) {
        return friendVerificationMapper.seachFriendIdByFriendVerifications(friendVerifications_id_Two).getUserId();
    }

    @Override
    public int searchNewFriend(int user_id) {
        List<FriendVerification> list=friendVerificationMapper.selectAllFriendVerification(user_id);
        return list.size();
    }

}
