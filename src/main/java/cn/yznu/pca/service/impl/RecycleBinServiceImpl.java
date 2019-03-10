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
    public int deleteRecycleBin(int userId, int albumId) {
        return 0;
    }

    @Override
    public int delManyRecycleBin(int userId, int[] albumId) {
        return 0;
    }

    @Override
    public int RecoverRecycleBin(int userId, int albumId) {
        return 0;
    }

    @Override
    public int RecoverRecycleBin(int userId, int[] albumId) {
        return 0;
    }
}
