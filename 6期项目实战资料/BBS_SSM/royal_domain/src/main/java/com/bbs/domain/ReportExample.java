package com.bbs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReportExample() {
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

        public Criteria andReportidIsNull() {
            addCriterion("reportId is null");
            return (Criteria) this;
        }

        public Criteria andReportidIsNotNull() {
            addCriterion("reportId is not null");
            return (Criteria) this;
        }

        public Criteria andReportidEqualTo(Integer value) {
            addCriterion("reportId =", value, "reportid");
            return (Criteria) this;
        }

        public Criteria andReportidNotEqualTo(Integer value) {
            addCriterion("reportId <>", value, "reportid");
            return (Criteria) this;
        }

        public Criteria andReportidGreaterThan(Integer value) {
            addCriterion("reportId >", value, "reportid");
            return (Criteria) this;
        }

        public Criteria andReportidGreaterThanOrEqualTo(Integer value) {
            addCriterion("reportId >=", value, "reportid");
            return (Criteria) this;
        }

        public Criteria andReportidLessThan(Integer value) {
            addCriterion("reportId <", value, "reportid");
            return (Criteria) this;
        }

        public Criteria andReportidLessThanOrEqualTo(Integer value) {
            addCriterion("reportId <=", value, "reportid");
            return (Criteria) this;
        }

        public Criteria andReportidIn(List<Integer> values) {
            addCriterion("reportId in", values, "reportid");
            return (Criteria) this;
        }

        public Criteria andReportidNotIn(List<Integer> values) {
            addCriterion("reportId not in", values, "reportid");
            return (Criteria) this;
        }

        public Criteria andReportidBetween(Integer value1, Integer value2) {
            addCriterion("reportId between", value1, value2, "reportid");
            return (Criteria) this;
        }

        public Criteria andReportidNotBetween(Integer value1, Integer value2) {
            addCriterion("reportId not between", value1, value2, "reportid");
            return (Criteria) this;
        }

        public Criteria andReportcontentIsNull() {
            addCriterion("reportContent is null");
            return (Criteria) this;
        }

        public Criteria andReportcontentIsNotNull() {
            addCriterion("reportContent is not null");
            return (Criteria) this;
        }

        public Criteria andReportcontentEqualTo(String value) {
            addCriterion("reportContent =", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentNotEqualTo(String value) {
            addCriterion("reportContent <>", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentGreaterThan(String value) {
            addCriterion("reportContent >", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentGreaterThanOrEqualTo(String value) {
            addCriterion("reportContent >=", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentLessThan(String value) {
            addCriterion("reportContent <", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentLessThanOrEqualTo(String value) {
            addCriterion("reportContent <=", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentLike(String value) {
            addCriterion("reportContent like", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentNotLike(String value) {
            addCriterion("reportContent not like", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentIn(List<String> values) {
            addCriterion("reportContent in", values, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentNotIn(List<String> values) {
            addCriterion("reportContent not in", values, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentBetween(String value1, String value2) {
            addCriterion("reportContent between", value1, value2, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentNotBetween(String value1, String value2) {
            addCriterion("reportContent not between", value1, value2, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReporttimeIsNull() {
            addCriterion("reportTime is null");
            return (Criteria) this;
        }

        public Criteria andReporttimeIsNotNull() {
            addCriterion("reportTime is not null");
            return (Criteria) this;
        }

        public Criteria andReporttimeEqualTo(Date value) {
            addCriterion("reportTime =", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeNotEqualTo(Date value) {
            addCriterion("reportTime <>", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeGreaterThan(Date value) {
            addCriterion("reportTime >", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reportTime >=", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeLessThan(Date value) {
            addCriterion("reportTime <", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeLessThanOrEqualTo(Date value) {
            addCriterion("reportTime <=", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeIn(List<Date> values) {
            addCriterion("reportTime in", values, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeNotIn(List<Date> values) {
            addCriterion("reportTime not in", values, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeBetween(Date value1, Date value2) {
            addCriterion("reportTime between", value1, value2, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeNotBetween(Date value1, Date value2) {
            addCriterion("reportTime not between", value1, value2, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReportusernameIsNull() {
            addCriterion("reportUserName is null");
            return (Criteria) this;
        }

        public Criteria andReportusernameIsNotNull() {
            addCriterion("reportUserName is not null");
            return (Criteria) this;
        }

        public Criteria andReportusernameEqualTo(String value) {
            addCriterion("reportUserName =", value, "reportusername");
            return (Criteria) this;
        }

        public Criteria andReportusernameNotEqualTo(String value) {
            addCriterion("reportUserName <>", value, "reportusername");
            return (Criteria) this;
        }

        public Criteria andReportusernameGreaterThan(String value) {
            addCriterion("reportUserName >", value, "reportusername");
            return (Criteria) this;
        }

        public Criteria andReportusernameGreaterThanOrEqualTo(String value) {
            addCriterion("reportUserName >=", value, "reportusername");
            return (Criteria) this;
        }

        public Criteria andReportusernameLessThan(String value) {
            addCriterion("reportUserName <", value, "reportusername");
            return (Criteria) this;
        }

        public Criteria andReportusernameLessThanOrEqualTo(String value) {
            addCriterion("reportUserName <=", value, "reportusername");
            return (Criteria) this;
        }

        public Criteria andReportusernameLike(String value) {
            addCriterion("reportUserName like", value, "reportusername");
            return (Criteria) this;
        }

        public Criteria andReportusernameNotLike(String value) {
            addCriterion("reportUserName not like", value, "reportusername");
            return (Criteria) this;
        }

        public Criteria andReportusernameIn(List<String> values) {
            addCriterion("reportUserName in", values, "reportusername");
            return (Criteria) this;
        }

        public Criteria andReportusernameNotIn(List<String> values) {
            addCriterion("reportUserName not in", values, "reportusername");
            return (Criteria) this;
        }

        public Criteria andReportusernameBetween(String value1, String value2) {
            addCriterion("reportUserName between", value1, value2, "reportusername");
            return (Criteria) this;
        }

        public Criteria andReportusernameNotBetween(String value1, String value2) {
            addCriterion("reportUserName not between", value1, value2, "reportusername");
            return (Criteria) this;
        }

        public Criteria andReportstatusIsNull() {
            addCriterion("reportStatus is null");
            return (Criteria) this;
        }

        public Criteria andReportstatusIsNotNull() {
            addCriterion("reportStatus is not null");
            return (Criteria) this;
        }

        public Criteria andReportstatusEqualTo(Integer value) {
            addCriterion("reportStatus =", value, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusNotEqualTo(Integer value) {
            addCriterion("reportStatus <>", value, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusGreaterThan(Integer value) {
            addCriterion("reportStatus >", value, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("reportStatus >=", value, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusLessThan(Integer value) {
            addCriterion("reportStatus <", value, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusLessThanOrEqualTo(Integer value) {
            addCriterion("reportStatus <=", value, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusIn(List<Integer> values) {
            addCriterion("reportStatus in", values, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusNotIn(List<Integer> values) {
            addCriterion("reportStatus not in", values, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusBetween(Integer value1, Integer value2) {
            addCriterion("reportStatus between", value1, value2, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andReportstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("reportStatus not between", value1, value2, "reportstatus");
            return (Criteria) this;
        }

        public Criteria andArticleidIsNull() {
            addCriterion("articleId is null");
            return (Criteria) this;
        }

        public Criteria andArticleidIsNotNull() {
            addCriterion("articleId is not null");
            return (Criteria) this;
        }

        public Criteria andArticleidEqualTo(Integer value) {
            addCriterion("articleId =", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotEqualTo(Integer value) {
            addCriterion("articleId <>", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidGreaterThan(Integer value) {
            addCriterion("articleId >", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("articleId >=", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLessThan(Integer value) {
            addCriterion("articleId <", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLessThanOrEqualTo(Integer value) {
            addCriterion("articleId <=", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidIn(List<Integer> values) {
            addCriterion("articleId in", values, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotIn(List<Integer> values) {
            addCriterion("articleId not in", values, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidBetween(Integer value1, Integer value2) {
            addCriterion("articleId between", value1, value2, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotBetween(Integer value1, Integer value2) {
            addCriterion("articleId not between", value1, value2, "articleid");
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