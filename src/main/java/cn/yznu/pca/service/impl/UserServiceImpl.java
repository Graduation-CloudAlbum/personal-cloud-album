package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.UserMapper;
import cn.yznu.pca.model.User;
import cn.yznu.pca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangbaiwan
 * @date 2018-09-29
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public void register(User user) {
        mapper.insertSelective(user);
    }

    @Override
    public int  isExistUserName(String username) {
        int count=(mapper.isExistUserName(username)).size();
     return count;
    }

    @Override
    public boolean modifyingData(int userId,String nickName,String synopsis) {

        return mapper.modifyingData(userId,nickName,synopsis);
    }

    @Override
    public int changeIcon(int id,String url) {
        return mapper.updateUrl(id,url);

    }

    @Override
    public boolean changePassword(int id,String password) {
        return mapper.changePassword(id,password);
    }

    @Override
    public User selectUserById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public User selectUserByUserName(String username) {
        return mapper.selectUserByUserName(username);
    }

    @Override
    public int updateUser(User user) {
        return mapper.updateUser(user);
    }

    @Override
    public User getFriendInformation(int id) {
        return mapper.getFriendInformation(id);
    }

    @Override
    public User checkLogin(String username, String password) {

        return mapper.selectByUserNameAndPwd(username, password);
    }

}
