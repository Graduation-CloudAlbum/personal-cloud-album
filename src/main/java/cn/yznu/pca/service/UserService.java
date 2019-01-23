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
     * @param user
     */
     void register(User user);

    /**
     * 验证用户名是否可用
     * @param username
     * @return
     */

    int isExistUserName(String username);

    boolean modifyingData(int userId,String nickName,String synopsis);
    void changeIcon(String url);
    void changePassword(String password);
    User selectUserById(int id);
}
