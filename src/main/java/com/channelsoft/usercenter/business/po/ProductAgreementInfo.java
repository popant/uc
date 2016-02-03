package com.channelsoft.usercenter.business.po;

import java.util.Date;
/**
 * 
 * <dl>
 * <dt>ProductAgreementInfo</dt>
 * <dd>Description:合同信息实体类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月24日</dd>
 * </dl>
 * 
 * @author cy
 */
public class ProductAgreementInfo {
    private Integer agreementId;

    private String enterpriseId;

    private Integer productId;

    private String createPerson;

    private Date createTime;

    private byte[] docScan;

    private byte[] agreementDoc;

    public Integer getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Integer agreementId) {
        this.agreementId = agreementId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public byte[] getDocScan() {
        return docScan;
    }

    public void setDocScan(byte[] docScan) {
        this.docScan = docScan;
    }

    public byte[] getAgreementDoc() {
        return agreementDoc;
    }

    public void setAgreementDoc(byte[] agreementDoc) {
        this.agreementDoc = agreementDoc;
    }
}