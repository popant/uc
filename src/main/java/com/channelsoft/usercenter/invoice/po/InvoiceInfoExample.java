package com.channelsoft.usercenter.invoice.po;

import com.channelsoft.usercenter.invoice.po.status.InvoiceAuditStatus;
import com.channelsoft.usercenter.invoice.po.status.InvoiceKindType;
import com.channelsoft.usercenter.invoice.po.status.InvoiceType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InvoiceInfoExample() {
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
        protected List<Criterion> invoiceKindCriteria;

        protected List<Criterion> invoiceTypeCriteria;

        protected List<Criterion> auditStatusCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            invoiceKindCriteria = new ArrayList<Criterion>();
            invoiceTypeCriteria = new ArrayList<Criterion>();
            auditStatusCriteria = new ArrayList<Criterion>();
        }

        public List<Criterion> getInvoiceKindCriteria() {
            return invoiceKindCriteria;
        }

        protected void addInvoiceKindCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            invoiceKindCriteria.add(new Criterion(condition, value, "com.channelsoft.usercenter.invoice.po.typeHandler.InvoiceKindTypeHandler"));
            allCriteria = null;
        }

        protected void addInvoiceKindCriterion(String condition, InvoiceKindType value1, InvoiceKindType value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            invoiceKindCriteria.add(new Criterion(condition, value1, value2, "com.channelsoft.usercenter.invoice.po.typeHandler.InvoiceKindTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getInvoiceTypeCriteria() {
            return invoiceTypeCriteria;
        }

        protected void addInvoiceTypeCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            invoiceTypeCriteria.add(new Criterion(condition, value, "com.channelsoft.usercenter.invoice.po.typeHandler.InvoiceTypeHandler"));
            allCriteria = null;
        }

        protected void addInvoiceTypeCriterion(String condition, InvoiceType value1, InvoiceType value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            invoiceTypeCriteria.add(new Criterion(condition, value1, value2, "com.channelsoft.usercenter.invoice.po.typeHandler.InvoiceTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getAuditStatusCriteria() {
            return auditStatusCriteria;
        }

        protected void addAuditStatusCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            auditStatusCriteria.add(new Criterion(condition, value, "com.channelsoft.usercenter.invoice.po.typeHandler.InvoiceAuditStatusHandler"));
            allCriteria = null;
        }

        protected void addAuditStatusCriterion(String condition, InvoiceAuditStatus value1, InvoiceAuditStatus value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            auditStatusCriteria.add(new Criterion(condition, value1, value2, "com.channelsoft.usercenter.invoice.po.typeHandler.InvoiceAuditStatusHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || invoiceKindCriteria.size() > 0
                || invoiceTypeCriteria.size() > 0
                || auditStatusCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(invoiceKindCriteria);
                allCriteria.addAll(invoiceTypeCriteria);
                allCriteria.addAll(auditStatusCriteria);
            }
            return allCriteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
            allCriteria = null;
        }

        public Criteria andInvoiceIdIsNull() {
            addCriterion("invoice_id is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdIsNotNull() {
            addCriterion("invoice_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdEqualTo(Integer value) {
            addCriterion("invoice_id =", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotEqualTo(Integer value) {
            addCriterion("invoice_id <>", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdGreaterThan(Integer value) {
            addCriterion("invoice_id >", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoice_id >=", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdLessThan(Integer value) {
            addCriterion("invoice_id <", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdLessThanOrEqualTo(Integer value) {
            addCriterion("invoice_id <=", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdIn(List<Integer> values) {
            addCriterion("invoice_id in", values, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotIn(List<Integer> values) {
            addCriterion("invoice_id not in", values, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdBetween(Integer value1, Integer value2) {
            addCriterion("invoice_id between", value1, value2, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("invoice_id not between", value1, value2, "invoiceId");
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

        public Criteria andEnterpriseIdEqualTo(String value) {
            addCriterion("enterprise_id =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(String value) {
            addCriterion("enterprise_id <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(String value) {
            addCriterion("enterprise_id >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_id >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(String value) {
            addCriterion("enterprise_id <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(String value) {
            addCriterion("enterprise_id <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLike(String value) {
            addCriterion("enterprise_id like", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotLike(String value) {
            addCriterion("enterprise_id not like", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<String> values) {
            addCriterion("enterprise_id in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<String> values) {
            addCriterion("enterprise_id not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(String value1, String value2) {
            addCriterion("enterprise_id between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(String value1, String value2) {
            addCriterion("enterprise_id not between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindIsNull() {
            addCriterion("invoice_kind is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindIsNotNull() {
            addCriterion("invoice_kind is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindEqualTo(InvoiceKindType value) {
            addInvoiceKindCriterion("invoice_kind =", value, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindNotEqualTo(InvoiceKindType value) {
            addInvoiceKindCriterion("invoice_kind <>", value, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindGreaterThan(InvoiceKindType value) {
            addInvoiceKindCriterion("invoice_kind >", value, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindGreaterThanOrEqualTo(InvoiceKindType value) {
            addInvoiceKindCriterion("invoice_kind >=", value, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindLessThan(InvoiceKindType value) {
            addInvoiceKindCriterion("invoice_kind <", value, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindLessThanOrEqualTo(InvoiceKindType value) {
            addInvoiceKindCriterion("invoice_kind <=", value, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindIn(List<InvoiceKindType> values) {
            addInvoiceKindCriterion("invoice_kind in", values, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindNotIn(List<InvoiceKindType> values) {
            addInvoiceKindCriterion("invoice_kind not in", values, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindBetween(InvoiceKindType value1, InvoiceKindType value2) {
            addInvoiceKindCriterion("invoice_kind between", value1, value2, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindNotBetween(InvoiceKindType value1, InvoiceKindType value2) {
            addInvoiceKindCriterion("invoice_kind not between", value1, value2, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNull() {
            addCriterion("invoice_title is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNotNull() {
            addCriterion("invoice_title is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleEqualTo(String value) {
            addCriterion("invoice_title =", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotEqualTo(String value) {
            addCriterion("invoice_title <>", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThan(String value) {
            addCriterion("invoice_title >", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_title >=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThan(String value) {
            addCriterion("invoice_title <", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThanOrEqualTo(String value) {
            addCriterion("invoice_title <=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLike(String value) {
            addCriterion("invoice_title like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotLike(String value) {
            addCriterion("invoice_title not like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIn(List<String> values) {
            addCriterion("invoice_title in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotIn(List<String> values) {
            addCriterion("invoice_title not in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleBetween(String value1, String value2) {
            addCriterion("invoice_title between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotBetween(String value1, String value2) {
            addCriterion("invoice_title not between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNull() {
            addCriterion("invoice_type is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNotNull() {
            addCriterion("invoice_type is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeEqualTo(InvoiceType value) {
            addInvoiceTypeCriterion("invoice_type =", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotEqualTo(InvoiceType value) {
            addInvoiceTypeCriterion("invoice_type <>", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThan(InvoiceType value) {
            addInvoiceTypeCriterion("invoice_type >", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThanOrEqualTo(InvoiceType value) {
            addInvoiceTypeCriterion("invoice_type >=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThan(InvoiceType value) {
            addInvoiceTypeCriterion("invoice_type <", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThanOrEqualTo(InvoiceType value) {
            addInvoiceTypeCriterion("invoice_type <=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIn(List<InvoiceType> values) {
            addInvoiceTypeCriterion("invoice_type in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotIn(List<InvoiceType> values) {
            addInvoiceTypeCriterion("invoice_type not in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeBetween(InvoiceType value1, InvoiceType value2) {
            addInvoiceTypeCriterion("invoice_type between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotBetween(InvoiceType value1, InvoiceType value2) {
            addInvoiceTypeCriterion("invoice_type not between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNumberIsNull() {
            addCriterion("tax_registration_number is null");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNumberIsNotNull() {
            addCriterion("tax_registration_number is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNumberEqualTo(String value) {
            addCriterion("tax_registration_number =", value, "taxRegistrationNumber");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNumberNotEqualTo(String value) {
            addCriterion("tax_registration_number <>", value, "taxRegistrationNumber");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNumberGreaterThan(String value) {
            addCriterion("tax_registration_number >", value, "taxRegistrationNumber");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNumberGreaterThanOrEqualTo(String value) {
            addCriterion("tax_registration_number >=", value, "taxRegistrationNumber");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNumberLessThan(String value) {
            addCriterion("tax_registration_number <", value, "taxRegistrationNumber");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNumberLessThanOrEqualTo(String value) {
            addCriterion("tax_registration_number <=", value, "taxRegistrationNumber");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNumberLike(String value) {
            addCriterion("tax_registration_number like", value, "taxRegistrationNumber");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNumberNotLike(String value) {
            addCriterion("tax_registration_number not like", value, "taxRegistrationNumber");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNumberIn(List<String> values) {
            addCriterion("tax_registration_number in", values, "taxRegistrationNumber");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNumberNotIn(List<String> values) {
            addCriterion("tax_registration_number not in", values, "taxRegistrationNumber");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNumberBetween(String value1, String value2) {
            addCriterion("tax_registration_number between", value1, value2, "taxRegistrationNumber");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNumberNotBetween(String value1, String value2) {
            addCriterion("tax_registration_number not between", value1, value2, "taxRegistrationNumber");
            return (Criteria) this;
        }

        public Criteria andBasicAccountBankNameIsNull() {
            addCriterion("basic_account_bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBasicAccountBankNameIsNotNull() {
            addCriterion("basic_account_bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBasicAccountBankNameEqualTo(String value) {
            addCriterion("basic_account_bank_name =", value, "basicAccountBankName");
            return (Criteria) this;
        }

        public Criteria andBasicAccountBankNameNotEqualTo(String value) {
            addCriterion("basic_account_bank_name <>", value, "basicAccountBankName");
            return (Criteria) this;
        }

        public Criteria andBasicAccountBankNameGreaterThan(String value) {
            addCriterion("basic_account_bank_name >", value, "basicAccountBankName");
            return (Criteria) this;
        }

        public Criteria andBasicAccountBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("basic_account_bank_name >=", value, "basicAccountBankName");
            return (Criteria) this;
        }

        public Criteria andBasicAccountBankNameLessThan(String value) {
            addCriterion("basic_account_bank_name <", value, "basicAccountBankName");
            return (Criteria) this;
        }

        public Criteria andBasicAccountBankNameLessThanOrEqualTo(String value) {
            addCriterion("basic_account_bank_name <=", value, "basicAccountBankName");
            return (Criteria) this;
        }

        public Criteria andBasicAccountBankNameLike(String value) {
            addCriterion("basic_account_bank_name like", value, "basicAccountBankName");
            return (Criteria) this;
        }

        public Criteria andBasicAccountBankNameNotLike(String value) {
            addCriterion("basic_account_bank_name not like", value, "basicAccountBankName");
            return (Criteria) this;
        }

        public Criteria andBasicAccountBankNameIn(List<String> values) {
            addCriterion("basic_account_bank_name in", values, "basicAccountBankName");
            return (Criteria) this;
        }

        public Criteria andBasicAccountBankNameNotIn(List<String> values) {
            addCriterion("basic_account_bank_name not in", values, "basicAccountBankName");
            return (Criteria) this;
        }

        public Criteria andBasicAccountBankNameBetween(String value1, String value2) {
            addCriterion("basic_account_bank_name between", value1, value2, "basicAccountBankName");
            return (Criteria) this;
        }

        public Criteria andBasicAccountBankNameNotBetween(String value1, String value2) {
            addCriterion("basic_account_bank_name not between", value1, value2, "basicAccountBankName");
            return (Criteria) this;
        }

        public Criteria andBasicAccountNumberIsNull() {
            addCriterion("basic_account_number is null");
            return (Criteria) this;
        }

        public Criteria andBasicAccountNumberIsNotNull() {
            addCriterion("basic_account_number is not null");
            return (Criteria) this;
        }

        public Criteria andBasicAccountNumberEqualTo(String value) {
            addCriterion("basic_account_number =", value, "basicAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBasicAccountNumberNotEqualTo(String value) {
            addCriterion("basic_account_number <>", value, "basicAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBasicAccountNumberGreaterThan(String value) {
            addCriterion("basic_account_number >", value, "basicAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBasicAccountNumberGreaterThanOrEqualTo(String value) {
            addCriterion("basic_account_number >=", value, "basicAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBasicAccountNumberLessThan(String value) {
            addCriterion("basic_account_number <", value, "basicAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBasicAccountNumberLessThanOrEqualTo(String value) {
            addCriterion("basic_account_number <=", value, "basicAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBasicAccountNumberLike(String value) {
            addCriterion("basic_account_number like", value, "basicAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBasicAccountNumberNotLike(String value) {
            addCriterion("basic_account_number not like", value, "basicAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBasicAccountNumberIn(List<String> values) {
            addCriterion("basic_account_number in", values, "basicAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBasicAccountNumberNotIn(List<String> values) {
            addCriterion("basic_account_number not in", values, "basicAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBasicAccountNumberBetween(String value1, String value2) {
            addCriterion("basic_account_number between", value1, value2, "basicAccountNumber");
            return (Criteria) this;
        }

        public Criteria andBasicAccountNumberNotBetween(String value1, String value2) {
            addCriterion("basic_account_number not between", value1, value2, "basicAccountNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterPlaceAddressIsNull() {
            addCriterion("register_place_address is null");
            return (Criteria) this;
        }

        public Criteria andRegisterPlaceAddressIsNotNull() {
            addCriterion("register_place_address is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterPlaceAddressEqualTo(String value) {
            addCriterion("register_place_address =", value, "registerPlaceAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterPlaceAddressNotEqualTo(String value) {
            addCriterion("register_place_address <>", value, "registerPlaceAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterPlaceAddressGreaterThan(String value) {
            addCriterion("register_place_address >", value, "registerPlaceAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterPlaceAddressGreaterThanOrEqualTo(String value) {
            addCriterion("register_place_address >=", value, "registerPlaceAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterPlaceAddressLessThan(String value) {
            addCriterion("register_place_address <", value, "registerPlaceAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterPlaceAddressLessThanOrEqualTo(String value) {
            addCriterion("register_place_address <=", value, "registerPlaceAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterPlaceAddressLike(String value) {
            addCriterion("register_place_address like", value, "registerPlaceAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterPlaceAddressNotLike(String value) {
            addCriterion("register_place_address not like", value, "registerPlaceAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterPlaceAddressIn(List<String> values) {
            addCriterion("register_place_address in", values, "registerPlaceAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterPlaceAddressNotIn(List<String> values) {
            addCriterion("register_place_address not in", values, "registerPlaceAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterPlaceAddressBetween(String value1, String value2) {
            addCriterion("register_place_address between", value1, value2, "registerPlaceAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterPlaceAddressNotBetween(String value1, String value2) {
            addCriterion("register_place_address not between", value1, value2, "registerPlaceAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterTelIsNull() {
            addCriterion("register_tel is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTelIsNotNull() {
            addCriterion("register_tel is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTelEqualTo(String value) {
            addCriterion("register_tel =", value, "registerTel");
            return (Criteria) this;
        }

        public Criteria andRegisterTelNotEqualTo(String value) {
            addCriterion("register_tel <>", value, "registerTel");
            return (Criteria) this;
        }

        public Criteria andRegisterTelGreaterThan(String value) {
            addCriterion("register_tel >", value, "registerTel");
            return (Criteria) this;
        }

        public Criteria andRegisterTelGreaterThanOrEqualTo(String value) {
            addCriterion("register_tel >=", value, "registerTel");
            return (Criteria) this;
        }

        public Criteria andRegisterTelLessThan(String value) {
            addCriterion("register_tel <", value, "registerTel");
            return (Criteria) this;
        }

        public Criteria andRegisterTelLessThanOrEqualTo(String value) {
            addCriterion("register_tel <=", value, "registerTel");
            return (Criteria) this;
        }

        public Criteria andRegisterTelLike(String value) {
            addCriterion("register_tel like", value, "registerTel");
            return (Criteria) this;
        }

        public Criteria andRegisterTelNotLike(String value) {
            addCriterion("register_tel not like", value, "registerTel");
            return (Criteria) this;
        }

        public Criteria andRegisterTelIn(List<String> values) {
            addCriterion("register_tel in", values, "registerTel");
            return (Criteria) this;
        }

        public Criteria andRegisterTelNotIn(List<String> values) {
            addCriterion("register_tel not in", values, "registerTel");
            return (Criteria) this;
        }

        public Criteria andRegisterTelBetween(String value1, String value2) {
            addCriterion("register_tel between", value1, value2, "registerTel");
            return (Criteria) this;
        }

        public Criteria andRegisterTelNotBetween(String value1, String value2) {
            addCriterion("register_tel not between", value1, value2, "registerTel");
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

        public Criteria andAuditStatusEqualTo(InvoiceAuditStatus value) {
            addAuditStatusCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(InvoiceAuditStatus value) {
            addAuditStatusCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(InvoiceAuditStatus value) {
            addAuditStatusCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(InvoiceAuditStatus value) {
            addAuditStatusCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(InvoiceAuditStatus value) {
            addAuditStatusCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(InvoiceAuditStatus value) {
            addAuditStatusCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<InvoiceAuditStatus> values) {
            addAuditStatusCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<InvoiceAuditStatus> values) {
            addAuditStatusCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(InvoiceAuditStatus value1, InvoiceAuditStatus value2) {
            addAuditStatusCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(InvoiceAuditStatus value1, InvoiceAuditStatus value2) {
            addAuditStatusCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAlterTimeIsNull() {
            addCriterion("alter_time is null");
            return (Criteria) this;
        }

        public Criteria andAlterTimeIsNotNull() {
            addCriterion("alter_time is not null");
            return (Criteria) this;
        }

        public Criteria andAlterTimeEqualTo(Date value) {
            addCriterion("alter_time =", value, "alterTime");
            return (Criteria) this;
        }

        public Criteria andAlterTimeNotEqualTo(Date value) {
            addCriterion("alter_time <>", value, "alterTime");
            return (Criteria) this;
        }

        public Criteria andAlterTimeGreaterThan(Date value) {
            addCriterion("alter_time >", value, "alterTime");
            return (Criteria) this;
        }

        public Criteria andAlterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("alter_time >=", value, "alterTime");
            return (Criteria) this;
        }

        public Criteria andAlterTimeLessThan(Date value) {
            addCriterion("alter_time <", value, "alterTime");
            return (Criteria) this;
        }

        public Criteria andAlterTimeLessThanOrEqualTo(Date value) {
            addCriterion("alter_time <=", value, "alterTime");
            return (Criteria) this;
        }

        public Criteria andAlterTimeIn(List<Date> values) {
            addCriterion("alter_time in", values, "alterTime");
            return (Criteria) this;
        }

        public Criteria andAlterTimeNotIn(List<Date> values) {
            addCriterion("alter_time not in", values, "alterTime");
            return (Criteria) this;
        }

        public Criteria andAlterTimeBetween(Date value1, Date value2) {
            addCriterion("alter_time between", value1, value2, "alterTime");
            return (Criteria) this;
        }

        public Criteria andAlterTimeNotBetween(Date value1, Date value2) {
            addCriterion("alter_time not between", value1, value2, "alterTime");
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