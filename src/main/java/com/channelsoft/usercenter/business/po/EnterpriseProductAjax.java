/**
 * 
 */
package com.channelsoft.usercenter.business.po;

import com.channelsoft.usercenter.business.po.status.ProductStatus;

/**
 * <dl>
 * <dt>EnterpriseProductAjax</dt>
 * <dd>Description:企业已开通产品的详细信息类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月16日</dd>
 * </dl>
 * 
 * @author cy
 */
public class EnterpriseProductAjax {
	//企业产品关联表的id
	private Integer id;
	
	private Integer productId;

    private String productName;

    private String productDesc;

    private Integer productOrder;
    
    private String enterpriseId;

    private ProductStatus status;
    
    private Integer remainCallTime;
    
    private Integer agentNum;
    
    private boolean passAudit;
    
    //申请商用 是否显示
    private Boolean commercial = false;
    //对应的连接地址
    private String commercialUrl="http://www.baidu.com";
    //充值 是否显示
    private Boolean deposit = false;
    
    private String depositUrl="http://www.baidu.com";
    //申请合同 是否显示
    private Boolean agreement = false;
    
    private String agreementUrl="http://www.baidu.com";
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Integer getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(Integer productOrder) {
		this.productOrder = productOrder;
	}
	public String getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public ProductStatus getStatus() {
		return status;
	}
	public void setStatus(ProductStatus status) {
		this.status = status;
	}
	public Integer getRemainCallTime() {
		return remainCallTime;
	}
	public void setRemainCallTime(Integer remainCallTime) {
		this.remainCallTime = remainCallTime;
	}
	public Integer getAgentNum() {
		return agentNum;
	}
	public void setAgentNum(Integer agentNum) {
		this.agentNum = agentNum;
	}
	public Boolean getCommercial() {
		return commercial;
	}
	public void setCommercial(Boolean commercial) {
		this.commercial = commercial;
	}
	public String getCommercialUrl() {
		return commercialUrl;
	}
	public void setCommercialUrl(String commercialUrl) {
		this.commercialUrl = commercialUrl;
	}
	public Boolean getDeposit() {
		return deposit;
	}
	public void setDeposit(Boolean deposit) {
		this.deposit = deposit;
	}
	public String getDepositUrl() {
		return depositUrl;
	}
	public void setDepositUrl(String depositUrl) {
		this.depositUrl = depositUrl;
	}
	public Boolean getAgreement() {
		return agreement;
	}
	public void setAgreement(Boolean agreement) {
		this.agreement = agreement;
	}
	public String getAgreementUrl() {
		return agreementUrl;
	}
	public void setAgreementUrl(String agreenmentUrl) {
		this.agreementUrl = agreenmentUrl;
	}
	public boolean isPassAudit() {
		return passAudit;
	}
	public void setPassAudit(boolean passAudit) {
		this.passAudit = passAudit;
	}

}
