package com.channelsoft.usercenter.consumable.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConsumableStatisticExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConsumableStatisticExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andConsumableMoneyIsNull() {
            addCriterion("consumable_money is null");
            return (Criteria) this;
        }

        public Criteria andConsumableMoneyIsNotNull() {
            addCriterion("consumable_money is not null");
            return (Criteria) this;
        }

        public Criteria andConsumableMoneyEqualTo(BigDecimal value) {
            addCriterion("consumable_money =", value, "consumableMoney");
            return (Criteria) this;
        }

        public Criteria andConsumableMoneyNotEqualTo(BigDecimal value) {
            addCriterion("consumable_money <>", value, "consumableMoney");
            return (Criteria) this;
        }

        public Criteria andConsumableMoneyGreaterThan(BigDecimal value) {
            addCriterion("consumable_money >", value, "consumableMoney");
            return (Criteria) this;
        }

        public Criteria andConsumableMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consumable_money >=", value, "consumableMoney");
            return (Criteria) this;
        }

        public Criteria andConsumableMoneyLessThan(BigDecimal value) {
            addCriterion("consumable_money <", value, "consumableMoney");
            return (Criteria) this;
        }

        public Criteria andConsumableMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consumable_money <=", value, "consumableMoney");
            return (Criteria) this;
        }

        public Criteria andConsumableMoneyIn(List<BigDecimal> values) {
            addCriterion("consumable_money in", values, "consumableMoney");
            return (Criteria) this;
        }

        public Criteria andConsumableMoneyNotIn(List<BigDecimal> values) {
            addCriterion("consumable_money not in", values, "consumableMoney");
            return (Criteria) this;
        }

        public Criteria andConsumableMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consumable_money between", value1, value2, "consumableMoney");
            return (Criteria) this;
        }

        public Criteria andConsumableMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consumable_money not between", value1, value2, "consumableMoney");
            return (Criteria) this;
        }

        public Criteria andConsumableResourceIsNull() {
            addCriterion("consumable_resource is null");
            return (Criteria) this;
        }

        public Criteria andConsumableResourceIsNotNull() {
            addCriterion("consumable_resource is not null");
            return (Criteria) this;
        }

        public Criteria andConsumableResourceEqualTo(Long value) {
            addCriterion("consumable_resource =", value, "consumableResource");
            return (Criteria) this;
        }

        public Criteria andConsumableResourceNotEqualTo(Long value) {
            addCriterion("consumable_resource <>", value, "consumableResource");
            return (Criteria) this;
        }

        public Criteria andConsumableResourceGreaterThan(Long value) {
            addCriterion("consumable_resource >", value, "consumableResource");
            return (Criteria) this;
        }

        public Criteria andConsumableResourceGreaterThanOrEqualTo(Long value) {
            addCriterion("consumable_resource >=", value, "consumableResource");
            return (Criteria) this;
        }

        public Criteria andConsumableResourceLessThan(Long value) {
            addCriterion("consumable_resource <", value, "consumableResource");
            return (Criteria) this;
        }

        public Criteria andConsumableResourceLessThanOrEqualTo(Long value) {
            addCriterion("consumable_resource <=", value, "consumableResource");
            return (Criteria) this;
        }

        public Criteria andConsumableResourceIn(List<Long> values) {
            addCriterion("consumable_resource in", values, "consumableResource");
            return (Criteria) this;
        }

        public Criteria andConsumableResourceNotIn(List<Long> values) {
            addCriterion("consumable_resource not in", values, "consumableResource");
            return (Criteria) this;
        }

        public Criteria andConsumableResourceBetween(Long value1, Long value2) {
            addCriterion("consumable_resource between", value1, value2, "consumableResource");
            return (Criteria) this;
        }

        public Criteria andConsumableResourceNotBetween(Long value1, Long value2) {
            addCriterion("consumable_resource not between", value1, value2, "consumableResource");
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