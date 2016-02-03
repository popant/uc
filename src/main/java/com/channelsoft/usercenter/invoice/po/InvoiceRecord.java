package com.channelsoft.usercenter.invoice.po;

import com.channelsoft.usercenter.invoice.po.status.InvoiceMailStatus;
import com.channelsoft.usercenter.invoice.po.status.MailType;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * <dl>
 * <dt>InvoiceRecord</dt>
 * <dd>Description:索取发票记录实体类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月24日</dd>
 * </dl>
 * 
 * @author cy
 */
public class InvoiceRecord {
    private Integer id;

    private String enterpriseId;

    private String phoneNumber;

    private String address;

    private String postalCode;

    private String name;

    private BigDecimal invoiceMoney;

    private Integer invoiceId;

    private Date createTime;

    private Date mailTime;

    private MailType mailType;

    private String mailId;

    private Integer mailUserId;

    private InvoiceMailStatus invoiceStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode == null ? null : postalCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getInvoiceMoney() {
        return invoiceMoney;
    }

    public void setInvoiceMoney(BigDecimal invoiceMoney) {
        this.invoiceMoney = invoiceMoney;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getMailTime() {
        return mailTime;
    }

    public void setMailTime(Date mailTime) {
        this.mailTime = mailTime;
    }

    public MailType getMailType() {
        return mailType;
    }

    public void setMailType(MailType mailType) {
        this.mailType = mailType;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId == null ? null : mailId.trim();
    }

    public Integer getMailUserId() {
        return mailUserId;
    }

    public void setMailUserId(Integer mailUserId) {
        this.mailUserId = mailUserId;
    }

    public InvoiceMailStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(InvoiceMailStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
}