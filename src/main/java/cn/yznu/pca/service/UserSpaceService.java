package cn.yznu.pca.service;


import cn.yznu.pca.model.UserSpace;

/**
 * @author yangbaiwan
 * @date 2019-03-15
 */
public interface UserSpaceService {
    /**
     * 初始化用户的空间
     * @param space 初始空间
     * @return
     */
    int initSpace(UserSpace space);

    /**
     * 查询用户的空间使用情况
     * @param userId 用户id
     * @return
     */
     UserSpace getSpace(int userId);

    /**
     * 更新用户的空间使用情况
     * @param userId 用户id
     * @param intial 初始值
     * @param all 所有值
     * @param used 已用值
     * @param available 剩余可用值
     * @return
     */
    UserSpace updateSpace(int userId,String intial,String all,String used,String available);
}
