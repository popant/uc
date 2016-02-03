package com.channelsoft.usercenter.message.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageSignatureInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageSignatureInfoExample() {
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

        public Criteria andMsgsignatureIdIsNull() {
            addCriterion("msgsignature_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgsignatureIdIsNotNull() {
            addCriterion("msgsignature_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgsignatureIdEqualTo(Integer value) {
            addCriterion("msgsignature_id =", value, "msgsignatureId");
            return (Criteria) this;
        }

        public Criteria andMsgsignatureIdNotEqualTo(Integer value) {
            addCriterion("msgsignature_id <>", value, "msgsignatureId");
            return (Criteria) this;
        }

        public Criteria andMsgsignatureIdGreaterThan(Integer value) {
            addCriterion("msgsignature_id >", value, "msgsignatureId");
            return (Criteria) this;
        }

        public Criteria andMsgsignatureIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("msgsignature_id >=", value, "msgsignatureId");
            return (Criteria) this;
        }

        public Criteria andMsgsignatureIdLessThan(Integer value) {
            addCriterion("msgsignature_id <", value, "msgsignatureId");
            return (Criteria) this;
        }

        public Criteria andMsgsignatureIdLessThanOrEqualTo(Integer value) {
            addCriterion("msgsignature_id <=", value, "msgsignatureId");
            return (Criteria) this;
        }

        public Criteria andMsgsignatureIdIn(List<Integer> values) {
            addCriterion("msgsignature_id in", values, "msgsignatureId");
            return (Criteria) this;
        }

        public Criteria andMsgsignatureIdNotIn(List<Integer> values) {
            addCriterion("msgsignature_id not in", values, "msgsignatureId");
            return (Criteria) this;
        }

        public Criteria andMsgsignatureIdBetween(Integer value1, Integer value2) {
            addCriterion("msgsignature_id between", value1, value2, "msgsignatureId");
            return (Criteria) this;
        }

        public Criteria andMsgsignatureIdNotBetween(Integer value1, Integer value2) {
            addCriterion("msgsignature_id not between", value1, value2, "msgsignatureId");
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

        public Criteria andMessageSignatureIsNull() {
            addCriterion("message_signature is null");
            return (Criteria) this;
        }

        public Criteria andMessageSignatureIsNotNull() {
            addCriterion("message_signature is not null");
            return (Criteria) this;
        }

        public Criteria andMessageSignatureEqualTo(String value) {
            addCriterion("message_signature =", value, "messageSignature");
            return (Criteria) this;
        }

        public Criteria andMessageSignatureNotEqualTo(String value) {
            addCriterion("message_signature <>", value, "messageSignature");
            return (Criteria) this;
        }

        public Criteria andMessageSignatureGreaterThan(String value) {
            addCriterion("message_signature >", value, "messageSignature");
            return (Criteria) this;
        }

        public Criteria andMessageSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("message_signature >=", value, "messageSignature");
            return (Criteria) this;
        }

        public Criteria andMessageSignatureLessThan(String value) {
            addCriterion("message_signature <", value, "messageSignature");
            return (Criteria) this;
        }

        public Criteria andMessageSignatureLessThanOrEqualTo(String value) {
            addCriterion("message_signature <=", value, "messageSignature");
            return (Criteria) this;
        }

        public Criteria andMessageSignatureLike(String value) {
            addCriterion("message_signature like", value, "messageSignature");
            return (Criteria) this;
        }

        public Criteria andMessageSignatureNotLike(String value) {
            addCriterion("message_signature not like", value, "messageSignature");
            return (Criteria) this;
        }

        public Criteria andMessageSignatureIn(List<String> values) {
            addCriterion("message_signature in", values, "messageSignature");
            return (Criteria) this;
        }

        public Criteria andMessageSignatureNotIn(List<String> values) {
            addCriterion("message_signature not in", values, "messageSignature");
            return (Criteria) this;
        }

        public Criteria andMessageSignatureBetween(String value1, String value2) {
            addCriterion("message_signature between", value1, value2, "messageSignature");
            return (Criteria) this;
        }

        public Criteria andMessageSignatureNotBetween(String value1, String value2) {
            addCriterion("message_signature not between", value1, value2, "messageSignature");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeIsNull() {
            addCriterion("audit_pass_time is null");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeIsNotNull() {
            addCriterion("audit_pass_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeEqualTo(Date value) {
            addCriterion("audit_pass_time =", value, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeNotEqualTo(Date value) {
            addCriterion("audit_pass_time <>", value, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeGreaterThan(Date value) {
            addCriterion("audit_pass_time >", value, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_pass_time >=", value, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeLessThan(Date value) {
            addCriterion("audit_pass_time <", value, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeLessThanOrEqualTo(Date value) {
            addCriterion("audit_pass_time <=", value, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeIn(List<Date> values) {
            addCriterion("audit_pass_time in", values, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeNotIn(List<Date> values) {
            addCriterion("audit_pass_time not in", values, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeBetween(Date value1, Date value2) {
            addCriterion("audit_pass_time between", value1, value2, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeNotBetween(Date value1, Date value2) {
            addCriterion("audit_pass_time not between", value1, value2, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(Short value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(Short value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(Short value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(Short value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(Short value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<Short> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<Short> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(Short value1, Short value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(Short value1, Short value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditPersonIsNull() {
            addCriterion("audit_person is null");
            return (Criteria) this;
        }

        public Criteria andAuditPersonIsNotNull() {
            addCriterion("audit_person is not null");
            return (Criteria) this;
        }

        public Criteria andAuditPersonEqualTo(String value) {
            addCriterion("audit_person =", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonNotEqualTo(String value) {
            addCriterion("audit_person <>", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonGreaterThan(String value) {
            addCriterion("audit_person >", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonGreaterThanOrEqualTo(String value) {
            addCriterion("audit_person >=", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonLessThan(String value) {
            addCriterion("audit_person <", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonLessThanOrEqualTo(String value) {
            addCriterion("audit_person <=", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonLike(String value) {
            addCriterion("audit_person like", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonNotLike(String value) {
            addCriterion("audit_person not like", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonIn(List<String> values) {
            addCriterion("audit_person in", values, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonNotIn(List<String> values) {
            addCriterion("audit_person not in", values, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonBetween(String value1, String value2) {
            addCriterion("audit_person between", value1, value2, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonNotBetween(String value1, String value2) {
            addCriterion("audit_person not between", value1, value2, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditInfoIsNull() {
            addCriterion("audit_info is null");
            return (Criteria) this;
        }

        public Criteria andAuditInfoIsNotNull() {
            addCriterion("audit_info is not null");
            return (Criteria) this;
        }

        public Criteria andAuditInfoEqualTo(String value) {
            addCriterion("audit_info =", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoNotEqualTo(String value) {
            addCriterion("audit_info <>", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoGreaterThan(String value) {
            addCriterion("audit_info >", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoGreaterThanOrEqualTo(String value) {
            addCriterion("audit_info >=", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoLessThan(String value) {
            addCriterion("audit_info <", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoLessThanOrEqualTo(String value) {
            addCriterion("audit_info <=", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoLike(String value) {
            addCriterion("audit_info like", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoNotLike(String value) {
            addCriterion("audit_info not like", value, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoIn(List<String> values) {
            addCriterion("audit_info in", values, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoNotIn(List<String> values) {
            addCriterion("audit_info not in", values, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoBetween(String value1, String value2) {
            addCriterion("audit_info between", value1, value2, "auditInfo");
            return (Criteria) this;
        }

        public Criteria andAuditInfoNotBetween(String value1, String value2) {
            addCriterion("audit_info not between", value1, value2, "auditInfo");
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