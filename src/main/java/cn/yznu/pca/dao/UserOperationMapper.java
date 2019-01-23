package cn.yznu.pca.dao;

import cn.yznu.pca.model.UserOperation;
import cn.yznu.pca.model.example.UserOperationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserOperationMapper {
    int countByExample(UserOperationExample example);

    int deleteByExample(UserOperationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserOperation record);

    int insertSelective(UserOperation record);

    List<UserOperation> selectByExample(UserOperationExample example);

    UserOperation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserOperation record, @Param("example") UserOperationExample example);

    int updateByExample(@Param("record") UserOperation record, @Param("example") UserOperationExample example);

    int updateByPrimaryKeySelective(UserOperation record);

    int updateByPrimaryKey(UserOperation record);
}