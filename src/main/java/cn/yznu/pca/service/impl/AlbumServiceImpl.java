package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.AlbumMapper;
import cn.yznu.pca.dao.UserPromissionMapper;
import cn.yznu.pca.dao.UserRelationMapper;
import cn.yznu.pca.model.Album;
import cn.yznu.pca.model.PermissionGroup;
import cn.yznu.pca.model.User;
import cn.yznu.pca.model.UserPromission;
import cn.yznu.pca.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yangbaiwan
 * @date 2018-12-18
 */
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumMapper mapper;

    @Autowired
    private UserPromissionMapper userPromissionMapper;

    @Override
    public int getAlbumNum(int userId) {
        return mapper.countAlbum(userId);
    }

    @Override
    public List getAlbum(int userId) {

        return mapper.selectAlbumInfo(userId);
    }

    @Override
    public List getAlbumByTime(int userId) {
        return mapper.selectAlbumByTime(userId);
    }

    @Override
    public List getAlbumByName(int userId) {
        return mapper.selectAlbumByAlbumName(userId);
    }

    @Override
    public List getAlbumByTheme(int userId) {
        return mapper.selectAlbumTheme(userId);
    }

    @Override
    public int createAlbum(Album album){
        mapper.insert(album);
        return 1;
    }

    @Override
    public int deleteAlbum(int albumId,String status) {
        return mapper.updateById(status,albumId);
    }

    @Override
    public int updateAlbum(int albumId, String albumName,String jurisdiction, String theme) {
        return mapper.updateAlbum(albumId,albumName,jurisdiction,theme);
    }

    @Override
    public List selectAlbumByName(int userId, String albumName) {
        return mapper.selectAlbumByName(userId,albumName);
    }

    @Override
    public Album selectAlbumById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean setPerssonalPromission(int user_id, int album_id, List<Integer> friend, int jurisdiction) {
        UserPromission userPromission=new UserPromission();
        mapper.updateAlbumByZero(album_id);
        for(Integer s:friend){
            List<?> list=userPromissionMapper.checkFriendPowerIsExist(user_id,s,album_id);
            if(list.size()!=0){
                userPromissionMapper.updateUserPromission(user_id,s,album_id,jurisdiction);
            }else{
                userPromission.setStatus("0");
                userPromission.setUserId(user_id);
                userPromission.setAlbumId(album_id);
                userPromission.setFriendId(s);
                userPromission.setJurisdiction(jurisdiction);
                userPromissionMapper.insert(userPromission);
            }
        }
        return true;
    }

    @Override
    public Boolean setAlbumPrivateOrPublic(int album_id, int status) {
        if(status==1){
            mapper.updateAlbumByOne(album_id);
            userPromissionMapper.deleteAllByAlbumId(album_id);
        }else{
            mapper.updateAlbumByZero(album_id);
            userPromissionMapper.deleteAllByAlbumId(album_id);
        }
        return true;
    }
}
