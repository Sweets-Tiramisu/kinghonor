package com.bbs.domain;

import java.util.ArrayList;
import java.util.List;

public class ZoneExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZoneExample() {
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

        public Criteria andZoneidIsNull() {
            addCriterion("zoneId is null");
            return (Criteria) this;
        }

        public Criteria andZoneidIsNotNull() {
            addCriterion("zoneId is not null");
            return (Criteria) this;
        }

        public Criteria andZoneidEqualTo(Integer value) {
            addCriterion("zoneId =", value, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidNotEqualTo(Integer value) {
            addCriterion("zoneId <>", value, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidGreaterThan(Integer value) {
            addCriterion("zoneId >", value, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zoneId >=", value, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidLessThan(Integer value) {
            addCriterion("zoneId <", value, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidLessThanOrEqualTo(Integer value) {
            addCriterion("zoneId <=", value, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidIn(List<Integer> values) {
            addCriterion("zoneId in", values, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidNotIn(List<Integer> values) {
            addCriterion("zoneId not in", values, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidBetween(Integer value1, Integer value2) {
            addCriterion("zoneId between", value1, value2, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidNotBetween(Integer value1, Integer value2) {
            addCriterion("zoneId not between", value1, value2, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZonenameIsNull() {
            addCriterion("zoneName is null");
            return (Criteria) this;
        }

        public Criteria andZonenameIsNotNull() {
            addCriterion("zoneName is not null");
            return (Criteria) this;
        }

        public Criteria andZonenameEqualTo(String value) {
            addCriterion("zoneName =", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameNotEqualTo(String value) {
            addCriterion("zoneName <>", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameGreaterThan(String value) {
            addCriterion("zoneName >", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameGreaterThanOrEqualTo(String value) {
            addCriterion("zoneName >=", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameLessThan(String value) {
            addCriterion("zoneName <", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameLessThanOrEqualTo(String value) {
            addCriterion("zoneName <=", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameLike(String value) {
            addCriterion("zoneName like", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameNotLike(String value) {
            addCriterion("zoneName not like", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameIn(List<String> values) {
            addCriterion("zoneName in", values, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameNotIn(List<String> values) {
            addCriterion("zoneName not in", values, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameBetween(String value1, String value2) {
            addCriterion("zoneName between", value1, value2, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameNotBetween(String value1, String value2) {
            addCriterion("zoneName not between", value1, value2, "zonename");
            return (Criteria) this;
        }

        public Criteria andIsdefIsNull() {
            addCriterion("isDef is null");
            return (Criteria) this;
        }

        public Criteria andIsdefIsNotNull() {
            addCriterion("isDef is not null");
            return (Criteria) this;
        }

        public Criteria andIsdefEqualTo(Integer value) {
            addCriterion("isDef =", value, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefNotEqualTo(Integer value) {
            addCriterion("isDef <>", value, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefGreaterThan(Integer value) {
            addCriterion("isDef >", value, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefGreaterThanOrEqualTo(Integer value) {
            addCriterion("isDef >=", value, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefLessThan(Integer value) {
            addCriterion("isDef <", value, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefLessThanOrEqualTo(Integer value) {
            addCriterion("isDef <=", value, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefIn(List<Integer> values) {
            addCriterion("isDef in", values, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefNotIn(List<Integer> values) {
            addCriterion("isDef not in", values, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefBetween(Integer value1, Integer value2) {
            addCriterion("isDef between", value1, value2, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefNotBetween(Integer value1, Integer value2) {
            addCriterion("isDef not between", value1, value2, "isdef");
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