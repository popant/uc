package com.channelsoft.usercenter.message.po;

import java.util.Date;

public class MessageTemplateInfo {
    private Integer msgtemplateId;

    private Integer enterpriseId;

    private String messageTemplate;

    private Date createTime;

    private Date updateTime;

    private Date auditPassTime;

    private Short auditStatus;

    private String auditPerson;

    private String auditInfo;

    public Integer getMsgtemplateId() {
        return msgtemplateId;
    }

    public void setMsgtemplateId(Integer msgtemplateId) {
        this.msgtemplateId = msgtemplateId;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getMessageTemplate() {
        return messageTemplate;
    }

    public void setMessageTemplate(String messageTemplate) {
        this.messageTemplate = messageTemplate == null ? null : messageTemplate.trim();
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