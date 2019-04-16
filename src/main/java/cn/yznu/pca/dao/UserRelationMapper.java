package cn.yznu.pca.dao;

import cn.yznu.pca.model.User;
import cn.yznu.pca.model.UserRelation;
import cn.yznu.pca.model.example.UserRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRelationMapper {
    int countByExample(UserRelationExample example);

    int deleteByExample(UserRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRelation record);

    int insertSelective(UserRelation record);

    List<UserRelation> selectByExample(UserRelationExample example);

    UserRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRelation record, @Param("example") UserRelationExample example);

    int updateByExample(@Param("record") UserRelation record, @Param("example") UserRelationExample example);

    int updateByPrimaryKeySelective(UserRelation record);

    int updateByPrimaryKey(UserRelation record);

    List<UserRelation>selectAllMyFriend(int userid);

    List<UserRelation>selectMyFriend(@Param("user_id") int user_id,@Param("permission_group_id") int permission_group_id);

    int moveFriendsToDefault(@Param("defaultpermissionGroupId") int defaultpermissionGroupId,@Param("permissionGroupId") int permissionGroupId);

    boolean deleteUserRelation(@Param("user_id") int user_id,@Param("user_id_two") int user_id_two);

    boolean moveFriendsToNewGroup(@Param("user_id") int user_id,@Param("user_id_two") int user_id_two,@Param("permission_group_id") int permission_group_id);
}