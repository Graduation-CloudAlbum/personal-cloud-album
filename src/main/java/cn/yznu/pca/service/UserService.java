package cn.yznu.pca.service;

import cn.yznu.pca.model.User;
import org.springframework.stereotype.Service;

/**
 * @author yangbaiwan
 * @date 2018-09-29
 */
public interface UserService {

    /**
     * 登录验证
     * @param username
     * @param password
     * @return user
     */
    User checkLogin(String username,String password);


    /**
     *  用户注册
     * @param user 用户
     */
     void register(User user);

    /**
     * 验证用户名是否可用
     * @param username 用户名
     * @return
     */

    int isExistUserName(String username);

    /**
     * 修改用户基本资料
     * @param userId 用户id
     * @param nickName 昵称
     * @param synopsis 简介
     * @return
     */
    boolean modifyingData(int userId,String nickName,String synopsis);

    /**
     * 更换头像
     * @param id
     * @param url
     */
    int changeIcon(int id,String url);

    /**
     * 修改密码
     * @param id 用户id
     * @param password 新密码
     * @return
     */
    boolean changePassword(int id,String password);

    /**
     * 通过id查找用户
     * @param id 用户id
     * @return
     */
    User selectUserById(int id);

    /**
     * 通过用户名查找用户
     * @param username 用户名
     * @return
     */
    User selectUserByUserName(String username);

    /**
     * 通过id查找用户
     * @param id 用户id
     * @return
     */
    int updateUser(int id);
}
