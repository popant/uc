package com.channelsoft.usercenter.consumable.po;

import java.math.BigDecimal;
import java.util.Date;

public class Consumable {
    private Integer consumableId;

    private String consumableName;

    private BigDecimal consumablePrice;

    private Integer productId;

    private Short isShelf;

    private Date createTime;

    private Long consumeResource;

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

    public BigDecimal getConsumablePrice() {
        return consumablePrice;
    }

    public void setConsumablePrice(BigDecimal consumablePrice) {
        this.consumablePrice = consumablePrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Short getIsShelf() {
        return isShelf;
    }

    public void setIsShelf(Short isShelf) {
        this.isShelf = isShelf;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getConsumeResource() {
        return consumeResource;
    }

    public void setConsumeResource(Long consumeResource) {
        this.consumeResource = consumeResource;
    }
}