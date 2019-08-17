package com.bbs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUserpassIsNull() {
            addCriterion("userPass is null");
            return (Criteria) this;
        }

        public Criteria andUserpassIsNotNull() {
            addCriterion("userPass is not null");
            return (Criteria) this;
        }

        public Criteria andUserpassEqualTo(String value) {
            addCriterion("userPass =", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassNotEqualTo(String value) {
            addCriterion("userPass <>", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassGreaterThan(String value) {
            addCriterion("userPass >", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassGreaterThanOrEqualTo(String value) {
            addCriterion("userPass >=", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassLessThan(String value) {
            addCriterion("userPass <", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassLessThanOrEqualTo(String value) {
            addCriterion("userPass <=", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassLike(String value) {
            addCriterion("userPass like", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassNotLike(String value) {
            addCriterion("userPass not like", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassIn(List<String> values) {
            addCriterion("userPass in", values, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassNotIn(List<String> values) {
            addCriterion("userPass not in", values, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassBetween(String value1, String value2) {
            addCriterion("userPass between", value1, value2, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassNotBetween(String value1, String value2) {
            addCriterion("userPass not between", value1, value2, "userpass");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPicurlIsNull() {
            addCriterion("picUrl is null");
            return (Criteria) this;
        }

        public Criteria andPicurlIsNotNull() {
            addCriterion("picUrl is not null");
            return (Criteria) this;
        }

        public Criteria andPicurlEqualTo(String value) {
            addCriterion("picUrl =", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlNotEqualTo(String value) {
            addCriterion("picUrl <>", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlGreaterThan(String value) {
            addCriterion("picUrl >", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlGreaterThanOrEqualTo(String value) {
            addCriterion("picUrl >=", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlLessThan(String value) {
            addCriterion("picUrl <", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlLessThanOrEqualTo(String value) {
            addCriterion("picUrl <=", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlLike(String value) {
            addCriterion("picUrl like", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlNotLike(String value) {
            addCriterion("picUrl not like", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlIn(List<String> values) {
            addCriterion("picUrl in", values, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlNotIn(List<String> values) {
            addCriterion("picUrl not in", values, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlBetween(String value1, String value2) {
            addCriterion("picUrl between", value1, value2, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlNotBetween(String value1, String value2) {
            addCriterion("picUrl not between", value1, value2, "picurl");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(Integer value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(Integer value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(Integer value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(Integer value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(Integer value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<Integer> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<Integer> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(Integer value1, Integer value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIsNull() {
            addCriterion("lastLoginTime is null");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIsNotNull() {
            addCriterion("lastLoginTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeEqualTo(Date value) {
            addCriterion("lastLoginTime =", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotEqualTo(Date value) {
            addCriterion("lastLoginTime <>", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeGreaterThan(Date value) {
            addCriterion("lastLoginTime >", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastLoginTime >=", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeLessThan(Date value) {
            addCriterion("lastLoginTime <", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeLessThanOrEqualTo(Date value) {
            addCriterion("lastLoginTime <=", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIn(List<Date> values) {
            addCriterion("lastLoginTime in", values, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotIn(List<Date> values) {
            addCriterion("lastLoginTime not in", values, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeBetween(Date value1, Date value2) {
            addCriterion("lastLoginTime between", value1, value2, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotBetween(Date value1, Date value2) {
            addCriterion("lastLoginTime not between", value1, value2, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLoginstatusIsNull() {
            addCriterion("loginStatus is null");
            return (Criteria) this;
        }

        public Criteria andLoginstatusIsNotNull() {
            addCriterion("loginStatus is not null");
            return (Criteria) this;
        }

        public Criteria andLoginstatusEqualTo(Integer value) {
            addCriterion("loginStatus =", value, "loginstatus");
            return (Criteria) this;
        }

        public Criteria andLoginstatusNotEqualTo(Integer value) {
            addCriterion("loginStatus <>", value, "loginstatus");
            return (Criteria) this;
        }

        public Criteria andLoginstatusGreaterThan(Integer value) {
            addCriterion("loginStatus >", value, "loginstatus");
            return (Criteria) this;
        }

        public Criteria andLoginstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("loginStatus >=", value, "loginstatus");
            return (Criteria) this;
        }

        public Criteria andLoginstatusLessThan(Integer value) {
            addCriterion("loginStatus <", value, "loginstatus");
            return (Criteria) this;
        }

        public Criteria andLoginstatusLessThanOrEqualTo(Integer value) {
            addCriterion("loginStatus <=", value, "loginstatus");
            return (Criteria) this;
        }

        public Criteria andLoginstatusIn(List<Integer> values) {
            addCriterion("loginStatus in", values, "loginstatus");
            return (Criteria) this;
        }

        public Criteria andLoginstatusNotIn(List<Integer> values) {
            addCriterion("loginStatus not in", values, "loginstatus");
            return (Criteria) this;
        }

        public Criteria andLoginstatusBetween(Integer value1, Integer value2) {
            addCriterion("loginStatus between", value1, value2, "loginstatus");
            return (Criteria) this;
        }

        public Criteria andLoginstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("loginStatus not between", value1, value2, "loginstatus");
            return (Criteria) this;
        }

        public Criteria andTalkstatusIsNull() {
            addCriterion("talkStatus is null");
            return (Criteria) this;
        }

        public Criteria andTalkstatusIsNotNull() {
            addCriterion("talkStatus is not null");
            return (Criteria) this;
        }

        public Criteria andTalkstatusEqualTo(Integer value) {
            addCriterion("talkStatus =", value, "talkstatus");
            return (Criteria) this;
        }

        public Criteria andTalkstatusNotEqualTo(Integer value) {
            addCriterion("talkStatus <>", value, "talkstatus");
            return (Criteria) this;
        }

        public Criteria andTalkstatusGreaterThan(Integer value) {
            addCriterion("talkStatus >", value, "talkstatus");
            return (Criteria) this;
        }

        public Criteria andTalkstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("talkStatus >=", value, "talkstatus");
            return (Criteria) this;
        }

        public Criteria andTalkstatusLessThan(Integer value) {
            addCriterion("talkStatus <", value, "talkstatus");
            return (Criteria) this;
        }

        public Criteria andTalkstatusLessThanOrEqualTo(Integer value) {
            addCriterion("talkStatus <=", value, "talkstatus");
            return (Criteria) this;
        }

        public Criteria andTalkstatusIn(List<Integer> values) {
            addCriterion("talkStatus in", values, "talkstatus");
            return (Criteria) this;
        }

        public Criteria andTalkstatusNotIn(List<Integer> values) {
            addCriterion("talkStatus not in", values, "talkstatus");
            return (Criteria) this;
        }

        public Criteria andTalkstatusBetween(Integer value1, Integer value2) {
            addCriterion("talkStatus between", value1, value2, "talkstatus");
            return (Criteria) this;
        }

        public Criteria andTalkstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("talkStatus not between", value1, value2, "talkstatus");
            return (Criteria) this;
        }

        public Criteria andIsupdatingIsNull() {
            addCriterion("isupdating is null");
            return (Criteria) this;
        }

        public Criteria andIsupdatingIsNotNull() {
            addCriterion("isupdating is not null");
            return (Criteria) this;
        }

        public Criteria andIsupdatingEqualTo(Integer value) {
            addCriterion("isupdating =", value, "isupdating");
            return (Criteria) this;
        }

        public Criteria andIsupdatingNotEqualTo(Integer value) {
            addCriterion("isupdating <>", value, "isupdating");
            return (Criteria) this;
        }

        public Criteria andIsupdatingGreaterThan(Integer value) {
            addCriterion("isupdating >", value, "isupdating");
            return (Criteria) this;
        }

        public Criteria andIsupdatingGreaterThanOrEqualTo(Integer value) {
            addCriterion("isupdating >=", value, "isupdating");
            return (Criteria) this;
        }

        public Criteria andIsupdatingLessThan(Integer value) {
            addCriterion("isupdating <", value, "isupdating");
            return (Criteria) this;
        }

        public Criteria andIsupdatingLessThanOrEqualTo(Integer value) {
            addCriterion("isupdating <=", value, "isupdating");
            return (Criteria) this;
        }

        public Criteria andIsupdatingIn(List<Integer> values) {
            addCriterion("isupdating in", values, "isupdating");
            return (Criteria) this;
        }

        public Criteria andIsupdatingNotIn(List<Integer> values) {
            addCriterion("isupdating not in", values, "isupdating");
            return (Criteria) this;
        }

        public Criteria andIsupdatingBetween(Integer value1, Integer value2) {
            addCriterion("isupdating between", value1, value2, "isupdating");
            return (Criteria) this;
        }

        public Criteria andIsupdatingNotBetween(Integer value1, Integer value2) {
            addCriterion("isupdating not between", value1, value2, "isupdating");
            return (Criteria) this;
        }

        public Criteria andUpdatestatusIsNull() {
            addCriterion("updateStatus is null");
            return (Criteria) this;
        }

        public Criteria andUpdatestatusIsNotNull() {
            addCriterion("updateStatus is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatestatusEqualTo(Integer value) {
            addCriterion("updateStatus =", value, "updatestatus");
            return (Criteria) this;
        }

        public Criteria andUpdatestatusNotEqualTo(Integer value) {
            addCriterion("updateStatus <>", value, "updatestatus");
            return (Criteria) this;
        }

        public Criteria andUpdatestatusGreaterThan(Integer value) {
            addCriterion("updateStatus >", value, "updatestatus");
            return (Criteria) this;
        }

        public Criteria andUpdatestatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("updateStatus >=", value, "updatestatus");
            return (Criteria) this;
        }

        public Criteria andUpdatestatusLessThan(Integer value) {
            addCriterion("updateStatus <", value, "updatestatus");
            return (Criteria) this;
        }

        public Criteria andUpdatestatusLessThanOrEqualTo(Integer value) {
            addCriterion("updateStatus <=", value, "updatestatus");
            return (Criteria) this;
        }

        public Criteria andUpdatestatusIn(List<Integer> values) {
            addCriterion("updateStatus in", values, "updatestatus");
            return (Criteria) this;
        }

        public Criteria andUpdatestatusNotIn(List<Integer> values) {
            addCriterion("updateStatus not in", values, "updatestatus");
            return (Criteria) this;
        }

        public Criteria andUpdatestatusBetween(Integer value1, Integer value2) {
            addCriterion("updateStatus between", value1, value2, "updatestatus");
            return (Criteria) this;
        }

        public Criteria andUpdatestatusNotBetween(Integer value1, Integer value2) {
            addCriterion("updateStatus not between", value1, value2, "updatestatus");
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