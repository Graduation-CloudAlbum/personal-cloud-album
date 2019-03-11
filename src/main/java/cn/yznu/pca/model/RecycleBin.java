package cn.yznu.pca.model;

import java.io.Serializable;
import java.util.Date;

public class RecycleBin implements Serializable {
    private Integer id;

    private Date createTime;

    private String status;

    private Integer imageId;

    private Integer albumId;

    private Integer userId;

    private User user;

    private Album album;

    private Image image;

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

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Album getAlbum() {
        return album;
    }

    public User getUser() {
        return user;
    }

    public Image getImage() {
        return image;
    }
}