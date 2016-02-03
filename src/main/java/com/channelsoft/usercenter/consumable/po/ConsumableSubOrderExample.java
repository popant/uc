package com.channelsoft.usercenter.consumable.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConsumableSubOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConsumableSubOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSubOrderIdIsNull() {
            addCriterion("sub_order_id is null");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdIsNotNull() {
            addCriterion("sub_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdEqualTo(Integer value) {
            addCriterion("sub_order_id =", value, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdNotEqualTo(Integer value) {
            addCriterion("sub_order_id <>", value, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdGreaterThan(Integer value) {
            addCriterion("sub_order_id >", value, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_order_id >=", value, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdLessThan(Integer value) {
            addCriterion("sub_order_id <", value, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("sub_order_id <=", value, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdIn(List<Integer> values) {
            addCriterion("sub_order_id in", values, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdNotIn(List<Integer> values) {
            addCriterion("sub_order_id not in", values, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("sub_order_id between", value1, value2, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_order_id not between", value1, value2, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Short value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Short value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Short value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Short value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Short value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Short value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Short> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Short> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Short value1, Short value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Short value1, Short value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andConsumableIdIsNull() {
            addCriterion("consumable_id is null");
            return (Criteria) this;
        }

        public Criteria andConsumableIdIsNotNull() {
            addCriterion("consumable_id is not null");
            return (Criteria) this;
        }

        public Criteria andConsumableIdEqualTo(Integer value) {
            addCriterion("consumable_id =", value, "consumableId");
            return (Criteria) this;
        }

        public Criteria andConsumableIdNotEqualTo(Integer value) {
            addCriterion("consumable_id <>", value, "consumableId");
            return (Criteria) this;
        }

        public Criteria andConsumableIdGreaterThan(Integer value) {
            addCriterion("consumable_id >", value, "consumableId");
            return (Criteria) this;
        }

        public Criteria andConsumableIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("consumable_id >=", value, "consumableId");
            return (Criteria) this;
        }

        public Criteria andConsumableIdLessThan(Integer value) {
            addCriterion("consumable_id <", value, "consumableId");
            return (Criteria) this;
        }

        public Criteria andConsumableIdLessThanOrEqualTo(Integer value) {
            addCriterion("consumable_id <=", value, "consumableId");
            return (Criteria) this;
        }

        public Criteria andConsumableIdIn(List<Integer> values) {
            addCriterion("consumable_id in", values, "consumableId");
            return (Criteria) this;
        }

        public Criteria andConsumableIdNotIn(List<Integer> values) {
            addCriterion("consumable_id not in", values, "consumableId");
            return (Criteria) this;
        }

        public Criteria andConsumableIdBetween(Integer value1, Integer value2) {
            addCriterion("consumable_id between", value1, value2, "consumableId");
            return (Criteria) this;
        }

        public Criteria andConsumableIdNotBetween(Integer value1, Integer value2) {
            addCriterion("consumable_id not between", value1, value2, "consumableId");
            return (Criteria) this;
        }

        public Criteria andConsumableNameIsNull() {
            addCriterion("consumable_name is null");
            return (Criteria) this;
        }

        public Criteria andConsumableNameIsNotNull() {
            addCriterion("consumable_name is not null");
            return (Criteria) this;
        }

        public Criteria andConsumableNameEqualTo(String value) {
            addCriterion("consumable_name =", value, "consumableName");
            return (Criteria) this;
        }

        public Criteria andConsumableNameNotEqualTo(String value) {
            addCriterion("consumable_name <>", value, "consumableName");
            return (Criteria) this;
        }

        public Criteria andConsumableNameGreaterThan(String value) {
            addCriterion("consumable_name >", value, "consumableName");
            return (Criteria) this;
        }

        public Criteria andConsumableNameGreaterThanOrEqualTo(String value) {
            addCriterion("consumable_name >=", value, "consumableName");
            return (Criteria) this;
        }

        public Criteria andConsumableNameLessThan(String value) {
            addCriterion("consumable_name <", value, "consumableName");
            return (Criteria) this;
        }

        public Criteria andConsumableNameLessThanOrEqualTo(String value) {
            addCriterion("consumable_name <=", value, "consumableName");
            return (Criteria) this;
        }

        public Criteria andConsumableNameLike(String value) {
            addCriterion("consumable_name like", value, "consumableName");
            return (Criteria) this;
        }

        public Criteria andConsumableNameNotLike(String value) {
            addCriterion("consumable_name not like", value, "consumableName");
            return (Criteria) this;
        }

        public Criteria andConsumableNameIn(List<String> values) {
            addCriterion("consumable_name in", values, "consumableName");
            return (Criteria) this;
        }

        public Criteria andConsumableNameNotIn(List<String> values) {
            addCriterion("consumable_name not in", values, "consumableName");
            return (Criteria) this;
        }

        public Criteria andConsumableNameBetween(String value1, String value2) {
            addCriterion("consumable_name between", value1, value2, "consumableName");
            return (Criteria) this;
        }

        public Criteria andConsumableNameNotBetween(String value1, String value2) {
            addCriterion("consumable_name not between", value1, value2, "consumableName");
            return (Criteria) this;
        }

        public Criteria andConsumableNumberIsNull() {
            addCriterion("consumable_number is null");
            return (Criteria) this;
        }

        public Criteria andConsumableNumberIsNotNull() {
            addCriterion("consumable_number is not null");
            return (Criteria) this;
        }

        public Criteria andConsumableNumberEqualTo(Integer value) {
            addCriterion("consumable_number =", value, "consumableNumber");
            return (Criteria) this;
        }

        public Criteria andConsumableNumberNotEqualTo(Integer value) {
            addCriterion("consumable_number <>", value, "consumableNumber");
            return (Criteria) this;
        }

        public Criteria andConsumableNumberGreaterThan(Integer value) {
            addCriterion("consumable_number >", value, "consumableNumber");
            return (Criteria) this;
        }

        public Criteria andConsumableNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("consumable_number >=", value, "consumableNumber");
            return (Criteria) this;
        }

        public Criteria andConsumableNumberLessThan(Integer value) {
            addCriterion("consumable_number <", value, "consumableNumber");
            return (Criteria) this;
        }

        public Criteria andConsumableNumberLessThanOrEqualTo(Integer value) {
            addCriterion("consumable_number <=", value, "consumableNumber");
            return (Criteria) this;
        }

        public Criteria andConsumableNumberIn(List<Integer> values) {
            addCriterion("consumable_number in", values, "consumableNumber");
            return (Criteria) this;
        }

        public Criteria andConsumableNumberNotIn(List<Integer> values) {
            addCriterion("consumable_number not in", values, "consumableNumber");
            return (Criteria) this;
        }

        public Criteria andConsumableNumberBetween(Integer value1, Integer value2) {
            addCriterion("consumable_number between", value1, value2, "consumableNumber");
            return (Criteria) this;
        }

        public Criteria andConsumableNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("consumable_number not between", value1, value2, "consumableNumber");
            return (Criteria) this;
        }

        public Criteria andConsumablePriceIsNull() {
            addCriterion("consumable_price is null");
            return (Criteria) this;
        }

        public Criteria andConsumablePriceIsNotNull() {
            addCriterion("consumable_price is not null");
            return (Criteria) this;
        }

        public Criteria andConsumablePriceEqualTo(BigDecimal value) {
            addCriterion("consumable_price =", value, "consumablePrice");
            return (Criteria) this;
        }

        public Criteria andConsumablePriceNotEqualTo(BigDecimal value) {
            addCriterion("consumable_price <>", value, "consumablePrice");
            return (Criteria) this;
        }

        public Criteria andConsumablePriceGreaterThan(BigDecimal value) {
            addCriterion("consumable_price >", value, "consumablePrice");
            return (Criteria) this;
        }

        public Criteria andConsumablePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consumable_price >=", value, "consumablePrice");
            return (Criteria) this;
        }

        public Criteria andConsumablePriceLessThan(BigDecimal value) {
            addCriterion("consumable_price <", value, "consumablePrice");
            return (Criteria) this;
        }

        public Criteria andConsumablePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consumable_price <=", value, "consumablePrice");
            return (Criteria) this;
        }

        public Criteria andConsumablePriceIn(List<BigDecimal> values) {
            addCriterion("consumable_price in", values, "consumablePrice");
            return (Criteria) this;
        }

        public Criteria andConsumablePriceNotIn(List<BigDecimal> values) {
            addCriterion("consumable_price not in", values, "consumablePrice");
            return (Criteria) this;
        }

        public Criteria andConsumablePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consumable_price between", value1, value2, "consumablePrice");
            return (Criteria) this;
        }

        public Criteria andConsumablePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consumable_price not between", value1, value2, "consumablePrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNull() {
            addCriterion("enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNotNull() {
            addCriterion("enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdEqualTo(Integer value) {
            addCriterion("enterprise_id =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(Integer value) {
            addCriterion("enterprise_id <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(Integer value) {
            addCriterion("enterprise_id >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_id >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(Integer value) {
            addCriterion("enterprise_id <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_id <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<Integer> values) {
            addCriterion("enterprise_id in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<Integer> values) {
            addCriterion("enterprise_id not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_id between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_id not between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}