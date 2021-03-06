package cn.yznu.pca.dao;

import cn.yznu.pca.model.FriendVerification;
import cn.yznu.pca.model.User;
import cn.yznu.pca.model.example.FriendVerificationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendVerificationMapper {
    int countByExample(FriendVerificationExample example);

    int deleteByExample(FriendVerificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FriendVerification record);

    int insertSelective(FriendVerification record);

    List<FriendVerification> selectByExample(FriendVerificationExample example);

    FriendVerification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FriendVerification record, @Param("example") FriendVerificationExample example);

    int updateByExample(@Param("record") FriendVerification record, @Param("example") FriendVerificationExample example);

    int updateByPrimaryKeySelective(FriendVerification record);

    int updateByPrimaryKey(FriendVerification record);

    List<FriendVerification>getFvListRefUser();

    List<FriendVerification>selectAllFriendVerification(int userid);

    List<FriendVerification>selectAllSandFriendVerification(int userid);

    boolean refusedfriendVerifications(int id);

    boolean deleteFriendVerifications(int id);

    boolean passfriendVerifications(int id);

    FriendVerification seachFriendIdByFriendVerifications(int id);



}