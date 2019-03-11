package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.RecycleBinMapper;
import cn.yznu.pca.dao.UserRelationMapper;
import cn.yznu.pca.model.RecycleBin;
import cn.yznu.pca.model.example.PermissionGroupExample;
import cn.yznu.pca.model.example.RecycleBinExample;
import cn.yznu.pca.service.RecycleBinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangbaiwan
 * @date 2019-03-04
 */
@Service
public class RecycleBinServiceImpl implements RecycleBinService {
    @Autowired
    RecycleBinMapper recycleBinMapper;
    @Override
    public List<RecycleBin> getRecycleBin(int userId) {
        List <RecycleBin> recycleBins=recycleBinMapper.selectMyRecycleBin(userId);
        return recycleBins;
    }


    @Override
    public boolean delManyRecycleBin(List list) {
        boolean recycleBins=recycleBinMapper.deleteRecycleBinByList(list);
        return recycleBins;
    }


    @Override
    public boolean recoverSomeImage(List list) {
        boolean recycleBins=recycleBinMapper.updateImageByList(list);
        return recycleBins;
    }

    @Override
    public boolean updateAlbumByList(List list) {
        boolean recycleBins=recycleBinMapper.updateAlbumByList(list);
        return recycleBins;
    }

    @Override
    public List<RecycleBin> selectAlbumByList(List list) {
        return recycleBinMapper.selectAlbumByList(list);
    }

    @Override
    public boolean deleteImageByList(List list) {
        boolean recycleBins=recycleBinMapper.deleteImageByList(list);
        return recycleBins;
    }

    @Override
    public boolean deleteAllRecycleBin(int id) {
        boolean recycleBins=recycleBinMapper.deleteAllRecycleBin(id);
        return recycleBins;
    }

    @Override
    public boolean recoverAllRecycleBin(List list) {
        boolean recycleBins=recycleBinMapper.recoverAllRecycleBin(list);
        return recycleBins;
    }


}
