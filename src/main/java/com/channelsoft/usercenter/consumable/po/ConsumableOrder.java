package com.channelsoft.usercenter.consumable.po;

import java.math.BigDecimal;
import java.util.Date;

public class ConsumableOrder {
    private Integer orderId;

    private Integer productId;

    private BigDecimal totlePrice;

    private Short orderStatus;

    private Date payTime;

    private Date createTime;

    private Integer enterpriseId;

    private Long totalResource;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public Short getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Short orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getTotalResource() {
        return totalResource;
    }

    public void setTotalResource(Long totalResource) {
        this.totalResource = totalResource;
    }
}