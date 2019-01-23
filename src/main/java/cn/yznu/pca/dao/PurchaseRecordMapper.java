package cn.yznu.pca.dao;

import cn.yznu.pca.model.PurchaseRecord;
import cn.yznu.pca.model.example.PurchaseRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseRecordMapper {
    int countByExample(PurchaseRecordExample example);

    int deleteByExample(PurchaseRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseRecord record);

    int insertSelective(PurchaseRecord record);

    List<PurchaseRecord> selectByExample(PurchaseRecordExample example);

    PurchaseRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PurchaseRecord record, @Param("example") PurchaseRecordExample example);

    int updateByExample(@Param("record") PurchaseRecord record, @Param("example") PurchaseRecordExample example);

    int updateByPrimaryKeySelective(PurchaseRecord record);

    int updateByPrimaryKey(PurchaseRecord record);
}