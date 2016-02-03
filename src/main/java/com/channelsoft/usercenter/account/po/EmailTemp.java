package com.channelsoft.usercenter.account.po;

import java.util.Date;

public class EmailTemp {
    private Integer id;

    private Integer enterpriseId;

    private String email;

    private Date createTime;

    private Date updateTime;

    private Short bindingStatus;

    private String md5Key;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getBindingStatus() {
        return bindingStatus;
    }

    public void setBindingStatus(Short bindingStatus) {
        this.bindingStatus = bindingStatus;
    }

    public String getMd5Key() {
        return md5Key;
    }

    public void setMd5Key(String md5Key) {
        this.md5Key = md5Key == null ? null : md5Key.trim();
    }
}