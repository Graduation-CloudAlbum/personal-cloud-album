package cn.yznu.pca.dao;

import cn.yznu.pca.model.Album;
import cn.yznu.pca.model.example.AlbumExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumMapper {
    int countByExample(AlbumExample example);

    int deleteByExample(AlbumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Album record);

    int insertSelective(Album record);

    List<Album> selectByExample(AlbumExample example);

    Album selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByExample(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(Album record);

    int countAlbum(Integer userId);

    List selectAlbumInfo(Integer userId);

    List selectAlbumByTime(Integer userId);

    List selectAlbumByAlbumName(Integer userId);

    List selectAlbumTheme(Integer userId);

    List selectAlbumByName(@Param("userId")int userId,@Param("albumName")String albumName);

    int updateById(@Param("status")String status,@Param("albumId")int albumId);

    int updateAlbum(@Param("albumId")int albumId,@Param("albumName")String albumName,@Param("status")String status,@Param("albumId")String theme);

    List checkAlbumPower(Integer album_id);
}