package com.xusihan.highschoolmanagementsystem.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActionsExample() {
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

        public Criteria andActionidIsNull() {
            addCriterion("ActionId is null");
            return (Criteria) this;
        }

        public Criteria andActionidIsNotNull() {
            addCriterion("ActionId is not null");
            return (Criteria) this;
        }

        public Criteria andActionidEqualTo(Integer value) {
            addCriterion("ActionId =", value, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidNotEqualTo(Integer value) {
            addCriterion("ActionId <>", value, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidGreaterThan(Integer value) {
            addCriterion("ActionId >", value, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ActionId >=", value, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidLessThan(Integer value) {
            addCriterion("ActionId <", value, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidLessThanOrEqualTo(Integer value) {
            addCriterion("ActionId <=", value, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidIn(List<Integer> values) {
            addCriterion("ActionId in", values, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidNotIn(List<Integer> values) {
            addCriterion("ActionId not in", values, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidBetween(Integer value1, Integer value2) {
            addCriterion("ActionId between", value1, value2, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidNotBetween(Integer value1, Integer value2) {
            addCriterion("ActionId not between", value1, value2, "actionid");
            return (Criteria) this;
        }

        public Criteria andClassidIsNull() {
            addCriterion("ClassID is null");
            return (Criteria) this;
        }

        public Criteria andClassidIsNotNull() {
            addCriterion("ClassID is not null");
            return (Criteria) this;
        }

        public Criteria andClassidEqualTo(Integer value) {
            addCriterion("ClassID =", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotEqualTo(Integer value) {
            addCriterion("ClassID <>", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThan(Integer value) {
            addCriterion("ClassID >", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ClassID >=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThan(Integer value) {
            addCriterion("ClassID <", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThanOrEqualTo(Integer value) {
            addCriterion("ClassID <=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidIn(List<Integer> values) {
            addCriterion("ClassID in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotIn(List<Integer> values) {
            addCriterion("ClassID not in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidBetween(Integer value1, Integer value2) {
            addCriterion("ClassID between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotBetween(Integer value1, Integer value2) {
            addCriterion("ClassID not between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andActionnameIsNull() {
            addCriterion("ActionName is null");
            return (Criteria) this;
        }

        public Criteria andActionnameIsNotNull() {
            addCriterion("ActionName is not null");
            return (Criteria) this;
        }

        public Criteria andActionnameEqualTo(String value) {
            addCriterion("ActionName =", value, "actionname");
            return (Criteria) this;
        }

        public Criteria andActionnameNotEqualTo(String value) {
            addCriterion("ActionName <>", value, "actionname");
            return (Criteria) this;
        }

        public Criteria andActionnameGreaterThan(String value) {
            addCriterion("ActionName >", value, "actionname");
            return (Criteria) this;
        }

        public Criteria andActionnameGreaterThanOrEqualTo(String value) {
            addCriterion("ActionName >=", value, "actionname");
            return (Criteria) this;
        }

        public Criteria andActionnameLessThan(String value) {
            addCriterion("ActionName <", value, "actionname");
            return (Criteria) this;
        }

        public Criteria andActionnameLessThanOrEqualTo(String value) {
            addCriterion("ActionName <=", value, "actionname");
            return (Criteria) this;
        }

        public Criteria andActionnameLike(String value) {
            addCriterion("ActionName like", value, "actionname");
            return (Criteria) this;
        }

        public Criteria andActionnameNotLike(String value) {
            addCriterion("ActionName not like", value, "actionname");
            return (Criteria) this;
        }

        public Criteria andActionnameIn(List<String> values) {
            addCriterion("ActionName in", values, "actionname");
            return (Criteria) this;
        }

        public Criteria andActionnameNotIn(List<String> values) {
            addCriterion("ActionName not in", values, "actionname");
            return (Criteria) this;
        }

        public Criteria andActionnameBetween(String value1, String value2) {
            addCriterion("ActionName between", value1, value2, "actionname");
            return (Criteria) this;
        }

        public Criteria andActionnameNotBetween(String value1, String value2) {
            addCriterion("ActionName not between", value1, value2, "actionname");
            return (Criteria) this;
        }

        public Criteria andActiondateIsNull() {
            addCriterion("ActionDate is null");
            return (Criteria) this;
        }

        public Criteria andActiondateIsNotNull() {
            addCriterion("ActionDate is not null");
            return (Criteria) this;
        }

        public Criteria andActiondateEqualTo(Date value) {
            addCriterion("ActionDate =", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateNotEqualTo(Date value) {
            addCriterion("ActionDate <>", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateGreaterThan(Date value) {
            addCriterion("ActionDate >", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateGreaterThanOrEqualTo(Date value) {
            addCriterion("ActionDate >=", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateLessThan(Date value) {
            addCriterion("ActionDate <", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateLessThanOrEqualTo(Date value) {
            addCriterion("ActionDate <=", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateIn(List<Date> values) {
            addCriterion("ActionDate in", values, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateNotIn(List<Date> values) {
            addCriterion("ActionDate not in", values, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateBetween(Date value1, Date value2) {
            addCriterion("ActionDate between", value1, value2, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateNotBetween(Date value1, Date value2) {
            addCriterion("ActionDate not between", value1, value2, "actiondate");
            return (Criteria) this;
        }

        public Criteria andBegintimeIsNull() {
            addCriterion("BeginTime is null");
            return (Criteria) this;
        }

        public Criteria andBegintimeIsNotNull() {
            addCriterion("BeginTime is not null");
            return (Criteria) this;
        }

        public Criteria andBegintimeEqualTo(String value) {
            addCriterion("BeginTime =", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotEqualTo(String value) {
            addCriterion("BeginTime <>", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeGreaterThan(String value) {
            addCriterion("BeginTime >", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeGreaterThanOrEqualTo(String value) {
            addCriterion("BeginTime >=", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLessThan(String value) {
            addCriterion("BeginTime <", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLessThanOrEqualTo(String value) {
            addCriterion("BeginTime <=", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLike(String value) {
            addCriterion("BeginTime like", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotLike(String value) {
            addCriterion("BeginTime not like", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeIn(List<String> values) {
            addCriterion("BeginTime in", values, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotIn(List<String> values) {
            addCriterion("BeginTime not in", values, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeBetween(String value1, String value2) {
            addCriterion("BeginTime between", value1, value2, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotBetween(String value1, String value2) {
            addCriterion("BeginTime not between", value1, value2, "begintime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("EndTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("EndTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(String value) {
            addCriterion("EndTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(String value) {
            addCriterion("EndTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(String value) {
            addCriterion("EndTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("EndTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(String value) {
            addCriterion("EndTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(String value) {
            addCriterion("EndTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLike(String value) {
            addCriterion("EndTime like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotLike(String value) {
            addCriterion("EndTime not like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<String> values) {
            addCriterion("EndTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<String> values) {
            addCriterion("EndTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(String value1, String value2) {
            addCriterion("EndTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(String value1, String value2) {
            addCriterion("EndTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andPurposeIsNull() {
            addCriterion("Purpose is null");
            return (Criteria) this;
        }

        public Criteria andPurposeIsNotNull() {
            addCriterion("Purpose is not null");
            return (Criteria) this;
        }

        public Criteria andPurposeEqualTo(String value) {
            addCriterion("Purpose =", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotEqualTo(String value) {
            addCriterion("Purpose <>", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThan(String value) {
            addCriterion("Purpose >", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("Purpose >=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThan(String value) {
            addCriterion("Purpose <", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThanOrEqualTo(String value) {
            addCriterion("Purpose <=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLike(String value) {
            addCriterion("Purpose like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotLike(String value) {
            addCriterion("Purpose not like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeIn(List<String> values) {
            addCriterion("Purpose in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotIn(List<String> values) {
            addCriterion("Purpose not in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeBetween(String value1, String value2) {
            addCriterion("Purpose between", value1, value2, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotBetween(String value1, String value2) {
            addCriterion("Purpose not between", value1, value2, "purpose");
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