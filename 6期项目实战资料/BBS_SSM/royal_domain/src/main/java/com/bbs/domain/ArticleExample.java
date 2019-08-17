package com.bbs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("sendTime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendTime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("sendTime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("sendTime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("sendTime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sendTime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("sendTime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("sendTime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("sendTime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("sendTime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("sendTime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("sendTime not between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendernameIsNull() {
            addCriterion("senderName is null");
            return (Criteria) this;
        }

        public Criteria andSendernameIsNotNull() {
            addCriterion("senderName is not null");
            return (Criteria) this;
        }

        public Criteria andSendernameEqualTo(String value) {
            addCriterion("senderName =", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotEqualTo(String value) {
            addCriterion("senderName <>", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameGreaterThan(String value) {
            addCriterion("senderName >", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameGreaterThanOrEqualTo(String value) {
            addCriterion("senderName >=", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLessThan(String value) {
            addCriterion("senderName <", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLessThanOrEqualTo(String value) {
            addCriterion("senderName <=", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLike(String value) {
            addCriterion("senderName like", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotLike(String value) {
            addCriterion("senderName not like", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameIn(List<String> values) {
            addCriterion("senderName in", values, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotIn(List<String> values) {
            addCriterion("senderName not in", values, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameBetween(String value1, String value2) {
            addCriterion("senderName between", value1, value2, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotBetween(String value1, String value2) {
            addCriterion("senderName not between", value1, value2, "sendername");
            return (Criteria) this;
        }

        public Criteria andIstopIsNull() {
            addCriterion("isTop is null");
            return (Criteria) this;
        }

        public Criteria andIstopIsNotNull() {
            addCriterion("isTop is not null");
            return (Criteria) this;
        }

        public Criteria andIstopEqualTo(Integer value) {
            addCriterion("isTop =", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotEqualTo(Integer value) {
            addCriterion("isTop <>", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopGreaterThan(Integer value) {
            addCriterion("isTop >", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopGreaterThanOrEqualTo(Integer value) {
            addCriterion("isTop >=", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLessThan(Integer value) {
            addCriterion("isTop <", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLessThanOrEqualTo(Integer value) {
            addCriterion("isTop <=", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopIn(List<Integer> values) {
            addCriterion("isTop in", values, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotIn(List<Integer> values) {
            addCriterion("isTop not in", values, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopBetween(Integer value1, Integer value2) {
            addCriterion("isTop between", value1, value2, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotBetween(Integer value1, Integer value2) {
            addCriterion("isTop not between", value1, value2, "istop");
            return (Criteria) this;
        }

        public Criteria andReplycountIsNull() {
            addCriterion("replyCount is null");
            return (Criteria) this;
        }

        public Criteria andReplycountIsNotNull() {
            addCriterion("replyCount is not null");
            return (Criteria) this;
        }

        public Criteria andReplycountEqualTo(Integer value) {
            addCriterion("replyCount =", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountNotEqualTo(Integer value) {
            addCriterion("replyCount <>", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountGreaterThan(Integer value) {
            addCriterion("replyCount >", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountGreaterThanOrEqualTo(Integer value) {
            addCriterion("replyCount >=", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountLessThan(Integer value) {
            addCriterion("replyCount <", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountLessThanOrEqualTo(Integer value) {
            addCriterion("replyCount <=", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountIn(List<Integer> values) {
            addCriterion("replyCount in", values, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountNotIn(List<Integer> values) {
            addCriterion("replyCount not in", values, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountBetween(Integer value1, Integer value2) {
            addCriterion("replyCount between", value1, value2, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountNotBetween(Integer value1, Integer value2) {
            addCriterion("replyCount not between", value1, value2, "replycount");
            return (Criteria) this;
        }

        public Criteria andUpvotecountIsNull() {
            addCriterion("upvoteCount is null");
            return (Criteria) this;
        }

        public Criteria andUpvotecountIsNotNull() {
            addCriterion("upvoteCount is not null");
            return (Criteria) this;
        }

        public Criteria andUpvotecountEqualTo(Integer value) {
            addCriterion("upvoteCount =", value, "upvotecount");
            return (Criteria) this;
        }

        public Criteria andUpvotecountNotEqualTo(Integer value) {
            addCriterion("upvoteCount <>", value, "upvotecount");
            return (Criteria) this;
        }

        public Criteria andUpvotecountGreaterThan(Integer value) {
            addCriterion("upvoteCount >", value, "upvotecount");
            return (Criteria) this;
        }

        public Criteria andUpvotecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("upvoteCount >=", value, "upvotecount");
            return (Criteria) this;
        }

        public Criteria andUpvotecountLessThan(Integer value) {
            addCriterion("upvoteCount <", value, "upvotecount");
            return (Criteria) this;
        }

        public Criteria andUpvotecountLessThanOrEqualTo(Integer value) {
            addCriterion("upvoteCount <=", value, "upvotecount");
            return (Criteria) this;
        }

        public Criteria andUpvotecountIn(List<Integer> values) {
            addCriterion("upvoteCount in", values, "upvotecount");
            return (Criteria) this;
        }

        public Criteria andUpvotecountNotIn(List<Integer> values) {
            addCriterion("upvoteCount not in", values, "upvotecount");
            return (Criteria) this;
        }

        public Criteria andUpvotecountBetween(Integer value1, Integer value2) {
            addCriterion("upvoteCount between", value1, value2, "upvotecount");
            return (Criteria) this;
        }

        public Criteria andUpvotecountNotBetween(Integer value1, Integer value2) {
            addCriterion("upvoteCount not between", value1, value2, "upvotecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountIsNull() {
            addCriterion("browseCount is null");
            return (Criteria) this;
        }

        public Criteria andBrowsecountIsNotNull() {
            addCriterion("browseCount is not null");
            return (Criteria) this;
        }

        public Criteria andBrowsecountEqualTo(Integer value) {
            addCriterion("browseCount =", value, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountNotEqualTo(Integer value) {
            addCriterion("browseCount <>", value, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountGreaterThan(Integer value) {
            addCriterion("browseCount >", value, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("browseCount >=", value, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountLessThan(Integer value) {
            addCriterion("browseCount <", value, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountLessThanOrEqualTo(Integer value) {
            addCriterion("browseCount <=", value, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountIn(List<Integer> values) {
            addCriterion("browseCount in", values, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountNotIn(List<Integer> values) {
            addCriterion("browseCount not in", values, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountBetween(Integer value1, Integer value2) {
            addCriterion("browseCount between", value1, value2, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountNotBetween(Integer value1, Integer value2) {
            addCriterion("browseCount not between", value1, value2, "browsecount");
            return (Criteria) this;
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

        public Criteria andIsreportIsNull() {
            addCriterion("isReport is null");
            return (Criteria) this;
        }

        public Criteria andIsreportIsNotNull() {
            addCriterion("isReport is not null");
            return (Criteria) this;
        }

        public Criteria andIsreportEqualTo(Integer value) {
            addCriterion("isReport =", value, "isreport");
            return (Criteria) this;
        }

        public Criteria andIsreportNotEqualTo(Integer value) {
            addCriterion("isReport <>", value, "isreport");
            return (Criteria) this;
        }

        public Criteria andIsreportGreaterThan(Integer value) {
            addCriterion("isReport >", value, "isreport");
            return (Criteria) this;
        }

        public Criteria andIsreportGreaterThanOrEqualTo(Integer value) {
            addCriterion("isReport >=", value, "isreport");
            return (Criteria) this;
        }

        public Criteria andIsreportLessThan(Integer value) {
            addCriterion("isReport <", value, "isreport");
            return (Criteria) this;
        }

        public Criteria andIsreportLessThanOrEqualTo(Integer value) {
            addCriterion("isReport <=", value, "isreport");
            return (Criteria) this;
        }

        public Criteria andIsreportIn(List<Integer> values) {
            addCriterion("isReport in", values, "isreport");
            return (Criteria) this;
        }

        public Criteria andIsreportNotIn(List<Integer> values) {
            addCriterion("isReport not in", values, "isreport");
            return (Criteria) this;
        }

        public Criteria andIsreportBetween(Integer value1, Integer value2) {
            addCriterion("isReport between", value1, value2, "isreport");
            return (Criteria) this;
        }

        public Criteria andIsreportNotBetween(Integer value1, Integer value2) {
            addCriterion("isReport not between", value1, value2, "isreport");
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