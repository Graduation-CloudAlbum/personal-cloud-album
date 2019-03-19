package cn.yznu.pca.dao;

import cn.yznu.pca.model.UserSpace;
import cn.yznu.pca.model.example.UserSpaceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserSpaceMapper {
    int countByExample(UserSpaceExample example);

    int deleteByExample(UserSpaceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserSpace record);

    int insertSelective(UserSpace record);

    List<UserSpace> selectByExample(UserSpaceExample example);

    UserSpace selectByUserId(Integer id);

    int updateByExampleSelective(@Param("record") UserSpace record, @Param("example") UserSpaceExample example);

    int updateByExample(@Param("record") UserSpace record, @Param("example") UserSpaceExample example);

    int updateByPrimaryKeySelective(UserSpace record);

    int updateByUserId(@Param("userId")int userId,@Param("all")String all,@Param("used")String used,@Param("available")String available);
}