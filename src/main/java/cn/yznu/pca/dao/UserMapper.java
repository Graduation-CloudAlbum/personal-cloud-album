package cn.yznu.pca.dao;

import cn.yznu.pca.model.User;
import cn.yznu.pca.model.example.UserExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    User selectUserByUserName(String username);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 检查用户名是否可用
     * @param username
     * @return list<User>
     */
    List<User> isExistUserName(String username);

    /**
     * 验证用户名、密码是否正确
     * @param username
     * @param password
     * @return user
     */
    User selectByUserNameAndPwd(@Param("username")String username,@Param("password")String password);

    boolean modifyingData(@Param("userId")int userId,@Param("nickName")String nickName,@Param("synopsis")String synopsis);

    User selectUserById(int id);

    boolean changePassword(@Param("id") int id,@Param("password") String password);

    List<User>searchFriends(@Param("nickName") String nickName);

    int updateUrl(@Param("id") int id,@Param("url") String url);

    int updateUser(User user);
}