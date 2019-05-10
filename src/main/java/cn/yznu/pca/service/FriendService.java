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
     *  查寻该用户下所有收到的验证消息
     * @param user
     */
    List <FriendVerification> selectAllFriendVerification(User user);


    /**
     *  查寻该用户下所有发送的验证消息
     * @param user
     */
    List <FriendVerification> selectAllSandFriendVerification(User user);

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

    /**
     *  删除好友分组
     * @param
     */
    boolean deleteFriendsGroup(int defaultint,int permissionGroupId);


    /**
     *  搜索相册权限
     * @param albumId
     */
    boolean checkAlbumPower(int albumId);


    /**
     *  搜索好友权限
     * @param albumId,friend_id,user_id
     */
    int checkFriendPower(int user_id,int friend_id,int albumId);


    /**
     *  拒绝好友请求
     * @param friendVerifications_id,friend_id,user_id
     */
    boolean refusedfriendVerifications(int user_id,int friend_id,int friendVerifications_id);


    /**
     *  删除好友请求
     * @param friendVerifications_id
     */
    boolean deleteFriendVerifications(int friendVerifications_id);


    List <FriendVerification> test();

    /**
     *  根据分组名和用户id查找分组id
     * @param user,groupname
     */
    int searchFriendsGroup(User user,String groupname);


    /**
     *  用户id好友id修改分组
     * @param user,user1,groupname
     */
    boolean moveFriendToNewGroup(User user,User user1,int friendsGroupId);

    /**
     *  用户删除好友
     * @param user,user1
     */
    boolean deleteFriends(User user,User user1);

    /**
     *  通过用户id和好友id更新好友表状态
     * @param user_id_two,user_id
     */
    boolean acceptfriendVerifications(int user_id,int user_id_two,int friendsGroup_id,int friendVerifications_id_Two);

    /**
     *  通过用户id和好友id更新好友表状态
     * @param friendVerifications_id_Two
     */
    int seachFriendIdByFriendVerifications(int friendVerifications_id_Two);

    /**
     *  通过用户id查找未读消息
     * @param userid
     */
    int searchNewFriend(int userid);

    /**
     * 删除好友时删除好友相关权限
     * @param user 用户,user_two 好友
     * @return
     */
    boolean whenDeleteFriend(int user_id,int friend_id);
}
