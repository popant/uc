package com.channelsoft.usercenter.message.po;

import java.util.Date;

public class MessageSignatureInfo {
    private Integer msgsignatureId;

    private Integer enterpriseId;

    private String messageSignature;

    private Date createTime;

    private Date updateTime;

    private Date auditPassTime;

    private Short auditStatus;

    private String auditPerson;

    private String auditInfo;

    public Integer getMsgsignatureId() {
        return msgsignatureId;
    }

    public void setMsgsignatureId(Integer msgsignatureId) {
        this.msgsignatureId = msgsignatureId;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getMessageSignature() {
        return messageSignature;
    }

    public void setMessageSignature(String messageSignature) {
        this.messageSignature = messageSignature == null ? null : messageSignature.trim();
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

    public Date getAuditPassTime() {
        return auditPassTime;
    }

    public void setAuditPassTime(Date auditPassTime) {
        this.auditPassTime = auditPassTime;
    }

    public Short getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Short auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditPerson() {
        return auditPerson;
    }

    public void setAuditPerson(String auditPerson) {
        this.auditPerson = auditPerson == null ? null : auditPerson.trim();
    }

    public String getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(String auditInfo) {
        this.auditInfo = auditInfo == null ? null : auditInfo.trim();
    }
}