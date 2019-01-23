package cn.yznu.pca.model;

import java.io.Serializable;
import java.util.Date;

public class UserSpace implements Serializable {
    private Integer id;

    private Date createTime;

    private String status;

    private String initialSpace;

    private String allSpace;

    private String usedSpace;

    private String availableSpace;

    private Integer userId;

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

    public String getInitialSpace() {
        return initialSpace;
    }

    public void setInitialSpace(String initialSpace) {
        this.initialSpace = initialSpace == null ? null : initialSpace.trim();
    }

    public String getAllSpace() {
        return allSpace;
    }

    public void setAllSpace(String allSpace) {
        this.allSpace = allSpace == null ? null : allSpace.trim();
    }

    public String getUsedSpace() {
        return usedSpace;
    }

    public void setUsedSpace(String usedSpace) {
        this.usedSpace = usedSpace == null ? null : usedSpace.trim();
    }

    public String getAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(String availableSpace) {
        this.availableSpace = availableSpace == null ? null : availableSpace.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}