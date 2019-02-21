package cn.yznu.pca.model;

import java.io.Serializable;
import java.util.Date;

public class UserRelation implements Serializable {
    private Integer id;

    private Date createTime;

    private String status;

    private Integer userId;

    private Integer userIdTwo;

    private Integer permissionGroupId;

    private Integer permissionGroupIdTwo;

    private User user;

    private User friend;

    public void setUser(User user) {
        this.user = user;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public User getUser() {
        return user;
    }

    public User getFriend() {
        return friend;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserIdTwo() {
        return userIdTwo;
    }

    public void setUserIdTwo(Integer userIdTwo) {
        this.userIdTwo = userIdTwo;
    }

    public Integer getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(Integer permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    public Integer getPermissionGroupIdTwo() {
        return permissionGroupIdTwo;
    }

    public void setPermissionGroupIdTwo(Integer permissionGroupIdTwo) {
        this.permissionGroupIdTwo = permissionGroupIdTwo;
    }

}