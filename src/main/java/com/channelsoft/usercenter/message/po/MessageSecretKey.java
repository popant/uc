package com.channelsoft.usercenter.message.po;

import java.util.Date;

public class MessageSecretKey {
    private Integer secretkeyId;

    private Integer enterpriseId;

    private String apiKey;

    private String secretKey;

    private Date createTime;

    private Date updateTime;

    public Integer getSecretkeyId() {
        return secretkeyId;
    }

    public void setSecretkeyId(Integer secretkeyId) {
        this.secretkeyId = secretkeyId;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey == null ? null : apiKey.trim();
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey == null ? null : secretKey.trim();
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
}