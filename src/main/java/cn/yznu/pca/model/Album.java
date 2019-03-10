package cn.yznu.pca.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Album implements Serializable {
    private Integer id;

    private Date createTime;

    private String status;

    private String albumName;

    private String albumType;

    private Integer userId;

    private List<RecycleBin> recycleBins;

    private static final long serialVersionUID = 1L;

    public void setRecycleBins(List<RecycleBin> recycleBins) {
        this.recycleBins = recycleBins;
    }

    public List<RecycleBin> getRecycleBins() {
        return recycleBins;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType == null ? null : albumType.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}