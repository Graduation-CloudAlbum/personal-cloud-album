package cn.yznu.pca.dao;

import cn.yznu.pca.model.Image;
import cn.yznu.pca.model.example.ImageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageMapper {
    int countByExample(ImageExample example);

    int deleteByExample(ImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Image record);

    int insertSelective(Image record);

    List<Image> selectByExample(ImageExample example);

    Image selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByExample(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);

    List selectImage(@Param("status")String status,@Param("userId")Integer userId,@Param("albumId")Integer albumId);

    int getAllImageNum(Integer userId);

    int getImageNum(@Param("userId")Integer userId,@Param("albumId")Integer albumId);
}