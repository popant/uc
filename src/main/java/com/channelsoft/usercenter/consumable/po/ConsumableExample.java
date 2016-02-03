package com.channelsoft.usercenter.consumable.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsumableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConsumableExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andIsShelfIsNull() {
            addCriterion("is_shelf is null");
            return (Criteria) this;
        }

        public Criteria andIsShelfIsNotNull() {
            addCriterion("is_shelf is not null");
            return (Criteria) this;
        }

        public Criteria andIsShelfEqualTo(Short value) {
            addCriterion("is_shelf =", value, "isShelf");
            return (Criteria) this;
        }

        public Criteria andIsShelfNotEqualTo(Short value) {
            addCriterion("is_shelf <>", value, "isShelf");
            return (Criteria) this;
        }

        public Criteria andIsShelfGreaterThan(Short value) {
            addCriterion("is_shelf >", value, "isShelf");
            return (Criteria) this;
        }

        public Criteria andIsShelfGreaterThanOrEqualTo(Short value) {
            addCriterion("is_shelf >=", value, "isShelf");
            return (Criteria) this;
        }

        public Criteria andIsShelfLessThan(Short value) {
            addCriterion("is_shelf <", value, "isShelf");
            return (Criteria) this;
        }

        public Criteria andIsShelfLessThanOrEqualTo(Short value) {
            addCriterion("is_shelf <=", value, "isShelf");
            return (Criteria) this;
        }

        public Criteria andIsShelfIn(List<Short> values) {
            addCriterion("is_shelf in", values, "isShelf");
            return (Criteria) this;
        }

        public Criteria andIsShelfNotIn(List<Short> values) {
            addCriterion("is_shelf not in", values, "isShelf");
            return (Criteria) this;
        }

        public Criteria andIsShelfBetween(Short value1, Short value2) {
            addCriterion("is_shelf between", value1, value2, "isShelf");
            return (Criteria) this;
        }

        public Criteria andIsShelfNotBetween(Short value1, Short value2) {
            addCriterion("is_shelf not between", value1, value2, "isShelf");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andConsumeResourceIsNull() {
            addCriterion("consume_resource is null");
            return (Criteria) this;
        }

        public Criteria andConsumeResourceIsNotNull() {
            addCriterion("consume_resource is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeResourceEqualTo(Long value) {
            addCriterion("consume_resource =", value, "consumeResource");
            return (Criteria) this;
        }

        public Criteria andConsumeResourceNotEqualTo(Long value) {
            addCriterion("consume_resource <>", value, "consumeResource");
            return (Criteria) this;
        }

        public Criteria andConsumeResourceGreaterThan(Long value) {
            addCriterion("consume_resource >", value, "consumeResource");
            return (Criteria) this;
        }

        public Criteria andConsumeResourceGreaterThanOrEqualTo(Long value) {
            addCriterion("consume_resource >=", value, "consumeResource");
            return (Criteria) this;
        }

        public Criteria andConsumeResourceLessThan(Long value) {
            addCriterion("consume_resource <", value, "consumeResource");
            return (Criteria) this;
        }

        public Criteria andConsumeResourceLessThanOrEqualTo(Long value) {
            addCriterion("consume_resource <=", value, "consumeResource");
            return (Criteria) this;
        }

        public Criteria andConsumeResourceIn(List<Long> values) {
            addCriterion("consume_resource in", values, "consumeResource");
            return (Criteria) this;
        }

        public Criteria andConsumeResourceNotIn(List<Long> values) {
            addCriterion("consume_resource not in", values, "consumeResource");
            return (Criteria) this;
        }

        public Criteria andConsumeResourceBetween(Long value1, Long value2) {
            addCriterion("consume_resource between", value1, value2, "consumeResource");
            return (Criteria) this;
        }

        public Criteria andConsumeResourceNotBetween(Long value1, Long value2) {
            addCriterion("consume_resource not between", value1, value2, "consumeResource");
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