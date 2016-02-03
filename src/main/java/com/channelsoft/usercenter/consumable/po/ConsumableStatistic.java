package com.channelsoft.usercenter.consumable.po;

import java.math.BigDecimal;

public class ConsumableStatistic {
    private Integer id;

    private Integer productId;

    private Integer enterpriseId;

    private BigDecimal consumableMoney;

    private Long consumableResource;

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

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public BigDecimal getConsumableMoney() {
        return consumableMoney;
    }

    public void setConsumableMoney(BigDecimal consumableMoney) {
        this.consumableMoney = consumableMoney;
    }

    public Long getConsumableResource() {
        return consumableResource;
    }

    public void setConsumableResource(Long consumableResource) {
        this.consumableResource = consumableResource;
    }
}