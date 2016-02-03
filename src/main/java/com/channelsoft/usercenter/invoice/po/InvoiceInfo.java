package com.channelsoft.usercenter.invoice.po;

import com.channelsoft.usercenter.invoice.po.status.InvoiceAuditStatus;
import com.channelsoft.usercenter.invoice.po.status.InvoiceKindType;
import com.channelsoft.usercenter.invoice.po.status.InvoiceType;
import java.util.Date;
/**
 * 
 * <dl>
 * <dt>InvoiceInfo</dt>
 * <dd>Description:发票信息 实体类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月24日</dd>
 * </dl>
 * 
 * @author cy
 */
public class InvoiceInfo {
    private Integer invoiceId;

    private String enterpriseId;

    private InvoiceKindType invoiceKind;

    private String invoiceTitle;

    private InvoiceType invoiceType;

    private String taxRegistrationNumber;

    private String basicAccountBankName;

    private String basicAccountNumber;

    private String registerPlaceAddress;

    private String registerTel;

    private InvoiceAuditStatus auditStatus;

    private Date alterTime;

    private Date createTime;

    private Date auditPassTime;

    private String auditPerson;

    private String auditInfo;

    private byte[] businessLicence;

    private byte[] taxRegistration;

    private byte[] generalTaxQua;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public InvoiceKindType getInvoiceKind() {
        return invoiceKind;
    }

    public void setInvoiceKind(InvoiceKindType invoiceKind) {
        this.invoiceKind = invoiceKind;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public InvoiceType getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(InvoiceType invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getTaxRegistrationNumber() {
        return taxRegistrationNumber;
    }

    public void setTaxRegistrationNumber(String taxRegistrationNumber) {
        this.taxRegistrationNumber = taxRegistrationNumber == null ? null : taxRegistrationNumber.trim();
    }

    public String getBasicAccountBankName() {
        return basicAccountBankName;
    }

    public void setBasicAccountBankName(String basicAccountBankName) {
        this.basicAccountBankName = basicAccountBankName == null ? null : basicAccountBankName.trim();
    }

    public String getBasicAccountNumber() {
        return basicAccountNumber;
    }

    public void setBasicAccountNumber(String basicAccountNumber) {
        this.basicAccountNumber = basicAccountNumber == null ? null : basicAccountNumber.trim();
    }

    public String getRegisterPlaceAddress() {
        return registerPlaceAddress;
    }

    public void setRegisterPlaceAddress(String registerPlaceAddress) {
        this.registerPlaceAddress = registerPlaceAddress == null ? null : registerPlaceAddress.trim();
    }

    public String getRegisterTel() {
        return registerTel;
    }

    public void setRegisterTel(String registerTel) {
        this.registerTel = registerTel == null ? null : registerTel.trim();
    }

    public InvoiceAuditStatus getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(InvoiceAuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getAlterTime() {
        return alterTime;
    }

    public void setAlterTime(Date alterTime) {
        this.alterTime = alterTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAuditPassTime() {
        return auditPassTime;
    }

    public void setAuditPassTime(Date auditPassTime) {
        this.auditPassTime = auditPassTime;
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

    public byte[] getBusinessLicence() {
        return businessLicence;
    }

    public void setBusinessLicence(byte[] businessLicence) {
        this.businessLicence = businessLicence;
    }

    public byte[] getTaxRegistration() {
        return taxRegistration;
    }

    public void setTaxRegistration(byte[] taxRegistration) {
        this.taxRegistration = taxRegistration;
    }

    public byte[] getGeneralTaxQua() {
        return generalTaxQua;
    }

    public void setGeneralTaxQua(byte[] generalTaxQua) {
        this.generalTaxQua = generalTaxQua;
    }
}