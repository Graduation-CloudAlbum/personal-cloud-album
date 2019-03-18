package cn.yznu.pca.dao;

import cn.yznu.pca.model.UserPromission;
import cn.yznu.pca.model.example.UserPromissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPromissionMapper {
    int countByExample(UserPromissionExample example);

    int deleteByExample(UserPromissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPromission record);

    int insertSelective(UserPromission record);

    List<UserPromission> selectByExample(UserPromissionExample example);

    UserPromission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserPromission record, @Param("example") UserPromissionExample example);

    int updateByExample(@Param("record") UserPromission record, @Param("example") UserPromissionExample example);

    int updateByPrimaryKeySelective(UserPromission record);

    int updateByPrimaryKey(UserPromission record);

    List checkFriendPower(@Param("user_id")int user_id,@Param("friend_id")int friend_id,@Param("album_id")int album_id);
}