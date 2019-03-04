package cn.yznu.pca.service;

import cn.yznu.pca.model.FriendVerification;
import cn.yznu.pca.model.PermissionGroup;
import cn.yznu.pca.model.User;
import cn.yznu.pca.model.UserRelation;

import java.util.List;

/**
 * @author jiangchuan
 * @date 2019-1-21
 */
public interface FriendService {
    /**
     *  查找所有用户好友
     * @param user
     */
    List<?> selectAllMyFriend(User user);

    /**
     *  查找分组
     * @param user
     */
    List<?> selectFriendGroup(User user);

    /**
     *  查找好友分组下所有好友
     * @param user
     */
    List<UserRelation> selectMyFriend(User user,int i);

    /**
     *  添加好友方法
     * @param user ,permisssion_type ,user_two
     */
    void addFriend(User user,int user_two,int permisssionGroupId,int permisssionGroupIdTwo);

    /**
     *  通过nickName查找好友
     * @param username
     */
    List<User> selectFriendByUsername(String username);


    /**
     *  添加好友验证
     * @param note2,userIdOne,userIdTwo
     */
    void addFriendVerification(String note2,User userIdOne, User userIdTwo);


    /**
     *  通过好友验证
     * @param friendVerificationId
     */
    void passFriendVerification(int friendVerificationId);


    /**
     *  查寻已存在的好友关系
     * @param userIdOne,userIdTwo
     */
    List <UserRelation> selectExistFriend(int userIdOne,int userIdTwo);


    /**
     *  选中目的分组id
     * @param userId,permisssion_type
     */
    int selectAddFriendGroup(int userId,String permisssion_type);


    /**
     *  查寻该用户下所有验证消息
     * @param user
     */
    List <FriendVerification> selectAllFriendVerification(User user);


    /**
     *  通过permissiontype和userid确定好友分组唯一id
     * @param user
     */
    int selectPermissionGroupId(User user,String type);


    /**
     *  添加好友分组
     * @param user
     */
    boolean createFriendsGroup(User user,String groupname);

    /**
     *  检查是否已有该分组
     * @param user
     */
    boolean checkFriendsGroup(User user,String groupname);

    /**
     *  根据好友名称查找好友
     * @param nickName
     */
    List<User> searchFriends(String nickName);

    List <FriendVerification> test();

}
