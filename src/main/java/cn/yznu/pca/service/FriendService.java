package cn.yznu.pca.service;

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
    void addFriend(User user,int user_two,int permisssion_type);

    /**
     *  通过nickName查找好友
     * @param username
     */
    List<User> selectFriendByUsername(String username);


    /**
     *  添加好友验证
     * @param note2,userIdOne,userIdTwo
     */
    void addFriendVerification(String note2,int userIdOne,int userIdTwo);


    /**
     *  通过好友验证
     * @param userIdOne,userIdTwo
     */
    void passFriendVerification(int userIdOne,int userIdTwo);


    /**
     *  查寻已存在的好友关系
     * @param userIdOne,userIdTwo
     */
    List <UserRelation> selectExistFriend(int userIdOne,int userIdTwo);
}
