package com.bbs.domain;

import java.util.ArrayList;
import java.util.List;

public class UpvoteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UpvoteExample() {
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

        public Criteria andUpvoteusernameIsNull() {
            addCriterion("upvoteUserName is null");
            return (Criteria) this;
        }

        public Criteria andUpvoteusernameIsNotNull() {
            addCriterion("upvoteUserName is not null");
            return (Criteria) this;
        }

        public Criteria andUpvoteusernameEqualTo(String value) {
            addCriterion("upvoteUserName =", value, "upvoteusername");
            return (Criteria) this;
        }

        public Criteria andUpvoteusernameNotEqualTo(String value) {
            addCriterion("upvoteUserName <>", value, "upvoteusername");
            return (Criteria) this;
        }

        public Criteria andUpvoteusernameGreaterThan(String value) {
            addCriterion("upvoteUserName >", value, "upvoteusername");
            return (Criteria) this;
        }

        public Criteria andUpvoteusernameGreaterThanOrEqualTo(String value) {
            addCriterion("upvoteUserName >=", value, "upvoteusername");
            return (Criteria) this;
        }

        public Criteria andUpvoteusernameLessThan(String value) {
            addCriterion("upvoteUserName <", value, "upvoteusername");
            return (Criteria) this;
        }

        public Criteria andUpvoteusernameLessThanOrEqualTo(String value) {
            addCriterion("upvoteUserName <=", value, "upvoteusername");
            return (Criteria) this;
        }

        public Criteria andUpvoteusernameLike(String value) {
            addCriterion("upvoteUserName like", value, "upvoteusername");
            return (Criteria) this;
        }

        public Criteria andUpvoteusernameNotLike(String value) {
            addCriterion("upvoteUserName not like", value, "upvoteusername");
            return (Criteria) this;
        }

        public Criteria andUpvoteusernameIn(List<String> values) {
            addCriterion("upvoteUserName in", values, "upvoteusername");
            return (Criteria) this;
        }

        public Criteria andUpvoteusernameNotIn(List<String> values) {
            addCriterion("upvoteUserName not in", values, "upvoteusername");
            return (Criteria) this;
        }

        public Criteria andUpvoteusernameBetween(String value1, String value2) {
            addCriterion("upvoteUserName between", value1, value2, "upvoteusername");
            return (Criteria) this;
        }

        public Criteria andUpvoteusernameNotBetween(String value1, String value2) {
            addCriterion("upvoteUserName not between", value1, value2, "upvoteusername");
            return (Criteria) this;
        }

        public Criteria andUpvotearticleidIsNull() {
            addCriterion("upvoteArticleId is null");
            return (Criteria) this;
        }

        public Criteria andUpvotearticleidIsNotNull() {
            addCriterion("upvoteArticleId is not null");
            return (Criteria) this;
        }

        public Criteria andUpvotearticleidEqualTo(Integer value) {
            addCriterion("upvoteArticleId =", value, "upvotearticleid");
            return (Criteria) this;
        }

        public Criteria andUpvotearticleidNotEqualTo(Integer value) {
            addCriterion("upvoteArticleId <>", value, "upvotearticleid");
            return (Criteria) this;
        }

        public Criteria andUpvotearticleidGreaterThan(Integer value) {
            addCriterion("upvoteArticleId >", value, "upvotearticleid");
            return (Criteria) this;
        }

        public Criteria andUpvotearticleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("upvoteArticleId >=", value, "upvotearticleid");
            return (Criteria) this;
        }

        public Criteria andUpvotearticleidLessThan(Integer value) {
            addCriterion("upvoteArticleId <", value, "upvotearticleid");
            return (Criteria) this;
        }

        public Criteria andUpvotearticleidLessThanOrEqualTo(Integer value) {
            addCriterion("upvoteArticleId <=", value, "upvotearticleid");
            return (Criteria) this;
        }

        public Criteria andUpvotearticleidIn(List<Integer> values) {
            addCriterion("upvoteArticleId in", values, "upvotearticleid");
            return (Criteria) this;
        }

        public Criteria andUpvotearticleidNotIn(List<Integer> values) {
            addCriterion("upvoteArticleId not in", values, "upvotearticleid");
            return (Criteria) this;
        }

        public Criteria andUpvotearticleidBetween(Integer value1, Integer value2) {
            addCriterion("upvoteArticleId between", value1, value2, "upvotearticleid");
            return (Criteria) this;
        }

        public Criteria andUpvotearticleidNotBetween(Integer value1, Integer value2) {
            addCriterion("upvoteArticleId not between", value1, value2, "upvotearticleid");
            return (Criteria) this;
        }

        public Criteria andIsupvoteIsNull() {
            addCriterion("isUpvote is null");
            return (Criteria) this;
        }

        public Criteria andIsupvoteIsNotNull() {
            addCriterion("isUpvote is not null");
            return (Criteria) this;
        }

        public Criteria andIsupvoteEqualTo(Integer value) {
            addCriterion("isUpvote =", value, "isupvote");
            return (Criteria) this;
        }

        public Criteria andIsupvoteNotEqualTo(Integer value) {
            addCriterion("isUpvote <>", value, "isupvote");
            return (Criteria) this;
        }

        public Criteria andIsupvoteGreaterThan(Integer value) {
            addCriterion("isUpvote >", value, "isupvote");
            return (Criteria) this;
        }

        public Criteria andIsupvoteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isUpvote >=", value, "isupvote");
            return (Criteria) this;
        }

        public Criteria andIsupvoteLessThan(Integer value) {
            addCriterion("isUpvote <", value, "isupvote");
            return (Criteria) this;
        }

        public Criteria andIsupvoteLessThanOrEqualTo(Integer value) {
            addCriterion("isUpvote <=", value, "isupvote");
            return (Criteria) this;
        }

        public Criteria andIsupvoteIn(List<Integer> values) {
            addCriterion("isUpvote in", values, "isupvote");
            return (Criteria) this;
        }

        public Criteria andIsupvoteNotIn(List<Integer> values) {
            addCriterion("isUpvote not in", values, "isupvote");
            return (Criteria) this;
        }

        public Criteria andIsupvoteBetween(Integer value1, Integer value2) {
            addCriterion("isUpvote between", value1, value2, "isupvote");
            return (Criteria) this;
        }

        public Criteria andIsupvoteNotBetween(Integer value1, Integer value2) {
            addCriterion("isUpvote not between", value1, value2, "isupvote");
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