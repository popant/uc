package com.channelsoft.usercenter.consumable.po;

import java.math.BigDecimal;

public class ConsumableSubOrder {
    private Integer subOrderId;

    private Integer orderId;

    private Short productId;

    private Integer consumableId;

    private String consumableName;

    private Integer consumableNumber;

    private BigDecimal consumablePrice;

    private BigDecimal totalPrice;

    private Integer enterpriseId;
    
    private Long consumableResource;
    
    public Long getConsumableResource() {
		return consumableResource;
	}

	public void setConsumableResource(Long consumableResource) {
		this.consumableResource = consumableResource;
	}

	public Integer getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(Integer subOrderId) {
        this.subOrderId = subOrderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Short getProductId() {
        return productId;
    }

    public void setProductId(Short productId) {
        this.productId = productId;
    }

    public Integer getConsumableId() {
        return consumableId;
    }

    public void setConsumableId(Integer consumableId) {
        this.consumableId = consumableId;
    }

    public String getConsumableName() {
        return consumableName;
    }

    public void setConsumableName(String consumableName) {
        this.consumableName = consumableName == null ? null : consumableName.trim();
    }

    public Integer getConsumableNumber() {
        return consumableNumber;
    }

    public void setConsumableNumber(Integer consumableNumber) {
        this.consumableNumber = consumableNumber;
    }

    public BigDecimal getConsumablePrice() {
        return consumablePrice;
    }

    public void setConsumablePrice(BigDecimal consumablePrice) {
        this.consumablePrice = consumablePrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}