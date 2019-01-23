package cn.yznu.pca.service;

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
}
