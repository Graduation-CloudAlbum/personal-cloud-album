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
     *  查找分组
     * @param user
     */
    List<?> selectFriendGroup(User user);

    /**
     *  查找好友分组下所有好友
     * @param user
     */
    List<UserRelation> selectMyFriend(User user);

    /**
     *  查找家人分组下所有好友
     * @param user
     */
    List<?> selectMyFamily(User user);

    /**
     *  查找同事分组下所有好友
     * @param user
     */
    List<?> selectMyColleague(User user);


    /**
     *  查找同学分组下所有好友
     * @param user
     */
    List<?> selectMyClassmate(User user);

    /**
     *  查找同学分组下所有好友
     * @param user
     */
    List<?> selectMyStranger(User user);


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



    List <FriendVerification> test();

}
