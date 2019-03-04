package cn.yznu.pca.service.impl;

import cn.yznu.pca.service.RecycleBinService;

import java.util.List;

/**
 * @author yangbaiwan
 * @date 2019-03-04
 */
public class RecycleBinServiceImpl implements RecycleBinService {
    @Override
    public List getRecycleBin(int userId) {
        return null;
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
