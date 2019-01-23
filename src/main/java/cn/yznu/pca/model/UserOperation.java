package cn.yznu.pca.model;

import java.io.Serializable;
import java.util.Date;

public class UserOperation implements Serializable {
    private Integer id;

    private Date createTime;

    private String status;

    private Integer userId;

    private String operationalEvents;

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

    public String getOperationalEvents() {
        return operationalEvents;
    }

    public void setOperationalEvents(String operationalEvents) {
        this.operationalEvents = operationalEvents == null ? null : operationalEvents.trim();
    }

}