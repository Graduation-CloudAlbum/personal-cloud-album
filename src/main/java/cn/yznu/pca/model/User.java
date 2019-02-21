package cn.yznu.pca.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
    private Integer id;

    private Date createTime;

    private String satatus;

    private String userName;

    private String userPassword;

    private String nickName;

    private String userIcon;

    private String synopsis;

    private String userType;

    private List<FriendVerification> friendVerificationList;

    private List<UserRelation> userRelationList;

    private static final long serialVersionUID = 1L;

    public void setUserRelationList(List<UserRelation> userRelationList) {
        this.userRelationList = userRelationList;
    }

    public List<UserRelation> getUserRelationList() {
        return userRelationList;
    }

    public List<FriendVerification> getFriendVerificationList() {
        return friendVerificationList;
    }

    public void setFriendVerificationList(List<FriendVerification> friendVerificationList) {
        this.friendVerificationList = friendVerificationList;
    }

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

    public String getSatatus() {
        return satatus;
    }

    public void setSatatus(String satatus) {
        this.satatus = satatus == null ? null : satatus.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getUserIcon(){ return userIcon;}

    public void setUserIcon(String userIcon){this.userIcon = userIcon == null ? null : userIcon.trim();}

    public  String getSynopsis(){return  synopsis;}

    public void setSynopsis(String synopsis){this.synopsis = synopsis == null ? null : synopsis.trim();}

}