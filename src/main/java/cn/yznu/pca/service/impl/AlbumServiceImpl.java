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
    public int createAlbum(Album album) {
        return mapper.insert(album);
    }

    @Override
    public int deleteAlbum(int albumId,String status) {
        return mapper.updateById(status,albumId);
    }

    @Override
    public int updateAlbum(int albumId, String albumName,String status, String theme) {
        return mapper.updateAlbum(albumId,albumName,status,theme);
    }

    @Override
    public List selectAlbumByName(int userId, String albumName) {
        return mapper.selectAlbumByName(userId,albumName);
    }

    @Override
    public Boolean setPerssonalPromission(int user_id, int album_id, List<User> friend, int jurisdiction) {
        UserPromission userPromission=new UserPromission();
        for(User s:friend){
            List<?> list=userPromissionMapper.checkFriendPowerIsExist(user_id,s.getId(),album_id);
            if(list.size()!=0){
                userPromissionMapper.updateUserPromission(user_id,s.getId(),album_id,jurisdiction);
            }else{
                userPromission.setStatus("0");
                userPromission.setUserId(user_id);
                userPromission.setAlbumId(album_id);
                userPromission.setFriendId(s.getId());
                userPromission.setJurisdiction(jurisdiction);
                userPromissionMapper.insert(userPromission);
            }
        }
        return true;
    }
}
