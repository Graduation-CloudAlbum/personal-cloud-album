package cn.yznu.pca.dao;

import cn.yznu.pca.model.PermissionGroup;
import cn.yznu.pca.model.example.PermissionGroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionGroupMapper {
    int countByExample(PermissionGroupExample example);

    int deleteByExample(PermissionGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PermissionGroup record);

    int insertSelective(PermissionGroup record);

    List<PermissionGroup> selectByExample(PermissionGroupExample example);

    PermissionGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PermissionGroup record, @Param("example") PermissionGroupExample example);

    int updateByExample(@Param("record") PermissionGroup record, @Param("example") PermissionGroupExample example);

    int updateByPrimaryKeySelective(PermissionGroup record);

    int updateByPrimaryKey(PermissionGroup record);
}