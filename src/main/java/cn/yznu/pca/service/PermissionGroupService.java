package cn.yznu.pca.service;

import cn.yznu.pca.model.PermissionGroup;
import org.springframework.stereotype.Service;

/**
 * @author yangbaiwan
 * @date 2019-03-20
 */
public interface PermissionGroupService {
    /**
     * 创建权限关系
     * @param permissionGroup
     * @return
     */
    int insert(PermissionGroup permissionGroup);
}
