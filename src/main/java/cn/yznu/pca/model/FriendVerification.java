package cn.yznu.pca.model;

import java.io.Serializable;
import java.util.Date;

public class FriendVerification implements Serializable {
    private Integer id;

    private Date cteateTime;

    private String status;

    private Integer userId;

    private User user;

    private Integer friendId;

    private User friend;

    private String note;

    private Integer state;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCteateTime() {
        return cteateTime;
    }

    public void setCteateTime(Date cteateTime) {
        this.cteateTime = cteateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public User getUser() {
        return user;
    }

    public User getFriend() {
        return friend;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }



}