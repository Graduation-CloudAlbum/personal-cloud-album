package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.PermissionGroupMapper;
import cn.yznu.pca.model.PermissionGroup;
import cn.yznu.pca.service.PermissionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangbaiwan
 * @date 2019-03-20
 */
@Service
public class PermissionGroupServiceImpl implements PermissionGroupService {
    @Autowired
    private PermissionGroupMapper permissionGroupMapper;

    @Override
    public int insert(PermissionGroup permissionGroup) {
        return permissionGroupMapper.insert(permissionGroup);
    }
}
