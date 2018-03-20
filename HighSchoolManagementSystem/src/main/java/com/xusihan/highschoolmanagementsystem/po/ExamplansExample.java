package com.xusihan.highschoolmanagementsystem.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamplansExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamplansExample() {
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

        public Criteria andExamplanidIsNull() {
            addCriterion("ExamPlanID is null");
            return (Criteria) this;
        }

        public Criteria andExamplanidIsNotNull() {
            addCriterion("ExamPlanID is not null");
            return (Criteria) this;
        }

        public Criteria andExamplanidEqualTo(Integer value) {
            addCriterion("ExamPlanID =", value, "examplanid");
            return (Criteria) this;
        }

        public Criteria andExamplanidNotEqualTo(Integer value) {
            addCriterion("ExamPlanID <>", value, "examplanid");
            return (Criteria) this;
        }

        public Criteria andExamplanidGreaterThan(Integer value) {
            addCriterion("ExamPlanID >", value, "examplanid");
            return (Criteria) this;
        }

        public Criteria andExamplanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ExamPlanID >=", value, "examplanid");
            return (Criteria) this;
        }

        public Criteria andExamplanidLessThan(Integer value) {
            addCriterion("ExamPlanID <", value, "examplanid");
            return (Criteria) this;
        }

        public Criteria andExamplanidLessThanOrEqualTo(Integer value) {
            addCriterion("ExamPlanID <=", value, "examplanid");
            return (Criteria) this;
        }

        public Criteria andExamplanidIn(List<Integer> values) {
            addCriterion("ExamPlanID in", values, "examplanid");
            return (Criteria) this;
        }

        public Criteria andExamplanidNotIn(List<Integer> values) {
            addCriterion("ExamPlanID not in", values, "examplanid");
            return (Criteria) this;
        }

        public Criteria andExamplanidBetween(Integer value1, Integer value2) {
            addCriterion("ExamPlanID between", value1, value2, "examplanid");
            return (Criteria) this;
        }

        public Criteria andExamplanidNotBetween(Integer value1, Integer value2) {
            addCriterion("ExamPlanID not between", value1, value2, "examplanid");
            return (Criteria) this;
        }

        public Criteria andExamplannameIsNull() {
            addCriterion("ExamPlanName is null");
            return (Criteria) this;
        }

        public Criteria andExamplannameIsNotNull() {
            addCriterion("ExamPlanName is not null");
            return (Criteria) this;
        }

        public Criteria andExamplannameEqualTo(String value) {
            addCriterion("ExamPlanName =", value, "examplanname");
            return (Criteria) this;
        }

        public Criteria andExamplannameNotEqualTo(String value) {
            addCriterion("ExamPlanName <>", value, "examplanname");
            return (Criteria) this;
        }

        public Criteria andExamplannameGreaterThan(String value) {
            addCriterion("ExamPlanName >", value, "examplanname");
            return (Criteria) this;
        }

        public Criteria andExamplannameGreaterThanOrEqualTo(String value) {
            addCriterion("ExamPlanName >=", value, "examplanname");
            return (Criteria) this;
        }

        public Criteria andExamplannameLessThan(String value) {
            addCriterion("ExamPlanName <", value, "examplanname");
            return (Criteria) this;
        }

        public Criteria andExamplannameLessThanOrEqualTo(String value) {
            addCriterion("ExamPlanName <=", value, "examplanname");
            return (Criteria) this;
        }

        public Criteria andExamplannameLike(String value) {
            addCriterion("ExamPlanName like", value, "examplanname");
            return (Criteria) this;
        }

        public Criteria andExamplannameNotLike(String value) {
            addCriterion("ExamPlanName not like", value, "examplanname");
            return (Criteria) this;
        }

        public Criteria andExamplannameIn(List<String> values) {
            addCriterion("ExamPlanName in", values, "examplanname");
            return (Criteria) this;
        }

        public Criteria andExamplannameNotIn(List<String> values) {
            addCriterion("ExamPlanName not in", values, "examplanname");
            return (Criteria) this;
        }

        public Criteria andExamplannameBetween(String value1, String value2) {
            addCriterion("ExamPlanName between", value1, value2, "examplanname");
            return (Criteria) this;
        }

        public Criteria andExamplannameNotBetween(String value1, String value2) {
            addCriterion("ExamPlanName not between", value1, value2, "examplanname");
            return (Criteria) this;
        }

        public Criteria andExamidIsNull() {
            addCriterion("ExamID is null");
            return (Criteria) this;
        }

        public Criteria andExamidIsNotNull() {
            addCriterion("ExamID is not null");
            return (Criteria) this;
        }

        public Criteria andExamidEqualTo(Integer value) {
            addCriterion("ExamID =", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidNotEqualTo(Integer value) {
            addCriterion("ExamID <>", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidGreaterThan(Integer value) {
            addCriterion("ExamID >", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ExamID >=", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidLessThan(Integer value) {
            addCriterion("ExamID <", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidLessThanOrEqualTo(Integer value) {
            addCriterion("ExamID <=", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidIn(List<Integer> values) {
            addCriterion("ExamID in", values, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidNotIn(List<Integer> values) {
            addCriterion("ExamID not in", values, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidBetween(Integer value1, Integer value2) {
            addCriterion("ExamID between", value1, value2, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidNotBetween(Integer value1, Integer value2) {
            addCriterion("ExamID not between", value1, value2, "examid");
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

        public Criteria andExamdateIsNull() {
            addCriterion("ExamDate is null");
            return (Criteria) this;
        }

        public Criteria andExamdateIsNotNull() {
            addCriterion("ExamDate is not null");
            return (Criteria) this;
        }

        public Criteria andExamdateEqualTo(Date value) {
            addCriterion("ExamDate =", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateNotEqualTo(Date value) {
            addCriterion("ExamDate <>", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateGreaterThan(Date value) {
            addCriterion("ExamDate >", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateGreaterThanOrEqualTo(Date value) {
            addCriterion("ExamDate >=", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateLessThan(Date value) {
            addCriterion("ExamDate <", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateLessThanOrEqualTo(Date value) {
            addCriterion("ExamDate <=", value, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateIn(List<Date> values) {
            addCriterion("ExamDate in", values, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateNotIn(List<Date> values) {
            addCriterion("ExamDate not in", values, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateBetween(Date value1, Date value2) {
            addCriterion("ExamDate between", value1, value2, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamdateNotBetween(Date value1, Date value2) {
            addCriterion("ExamDate not between", value1, value2, "examdate");
            return (Criteria) this;
        }

        public Criteria andExamstarttimeIsNull() {
            addCriterion("ExamStartTime is null");
            return (Criteria) this;
        }

        public Criteria andExamstarttimeIsNotNull() {
            addCriterion("ExamStartTime is not null");
            return (Criteria) this;
        }

        public Criteria andExamstarttimeEqualTo(String value) {
            addCriterion("ExamStartTime =", value, "examstarttime");
            return (Criteria) this;
        }

        public Criteria andExamstarttimeNotEqualTo(String value) {
            addCriterion("ExamStartTime <>", value, "examstarttime");
            return (Criteria) this;
        }

        public Criteria andExamstarttimeGreaterThan(String value) {
            addCriterion("ExamStartTime >", value, "examstarttime");
            return (Criteria) this;
        }

        public Criteria andExamstarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("ExamStartTime >=", value, "examstarttime");
            return (Criteria) this;
        }

        public Criteria andExamstarttimeLessThan(String value) {
            addCriterion("ExamStartTime <", value, "examstarttime");
            return (Criteria) this;
        }

        public Criteria andExamstarttimeLessThanOrEqualTo(String value) {
            addCriterion("ExamStartTime <=", value, "examstarttime");
            return (Criteria) this;
        }

        public Criteria andExamstarttimeLike(String value) {
            addCriterion("ExamStartTime like", value, "examstarttime");
            return (Criteria) this;
        }

        public Criteria andExamstarttimeNotLike(String value) {
            addCriterion("ExamStartTime not like", value, "examstarttime");
            return (Criteria) this;
        }

        public Criteria andExamstarttimeIn(List<String> values) {
            addCriterion("ExamStartTime in", values, "examstarttime");
            return (Criteria) this;
        }

        public Criteria andExamstarttimeNotIn(List<String> values) {
            addCriterion("ExamStartTime not in", values, "examstarttime");
            return (Criteria) this;
        }

        public Criteria andExamstarttimeBetween(String value1, String value2) {
            addCriterion("ExamStartTime between", value1, value2, "examstarttime");
            return (Criteria) this;
        }

        public Criteria andExamstarttimeNotBetween(String value1, String value2) {
            addCriterion("ExamStartTime not between", value1, value2, "examstarttime");
            return (Criteria) this;
        }

        public Criteria andExamendtimeIsNull() {
            addCriterion("ExamEndTime is null");
            return (Criteria) this;
        }

        public Criteria andExamendtimeIsNotNull() {
            addCriterion("ExamEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andExamendtimeEqualTo(String value) {
            addCriterion("ExamEndTime =", value, "examendtime");
            return (Criteria) this;
        }

        public Criteria andExamendtimeNotEqualTo(String value) {
            addCriterion("ExamEndTime <>", value, "examendtime");
            return (Criteria) this;
        }

        public Criteria andExamendtimeGreaterThan(String value) {
            addCriterion("ExamEndTime >", value, "examendtime");
            return (Criteria) this;
        }

        public Criteria andExamendtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ExamEndTime >=", value, "examendtime");
            return (Criteria) this;
        }

        public Criteria andExamendtimeLessThan(String value) {
            addCriterion("ExamEndTime <", value, "examendtime");
            return (Criteria) this;
        }

        public Criteria andExamendtimeLessThanOrEqualTo(String value) {
            addCriterion("ExamEndTime <=", value, "examendtime");
            return (Criteria) this;
        }

        public Criteria andExamendtimeLike(String value) {
            addCriterion("ExamEndTime like", value, "examendtime");
            return (Criteria) this;
        }

        public Criteria andExamendtimeNotLike(String value) {
            addCriterion("ExamEndTime not like", value, "examendtime");
            return (Criteria) this;
        }

        public Criteria andExamendtimeIn(List<String> values) {
            addCriterion("ExamEndTime in", values, "examendtime");
            return (Criteria) this;
        }

        public Criteria andExamendtimeNotIn(List<String> values) {
            addCriterion("ExamEndTime not in", values, "examendtime");
            return (Criteria) this;
        }

        public Criteria andExamendtimeBetween(String value1, String value2) {
            addCriterion("ExamEndTime between", value1, value2, "examendtime");
            return (Criteria) this;
        }

        public Criteria andExamendtimeNotBetween(String value1, String value2) {
            addCriterion("ExamEndTime not between", value1, value2, "examendtime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andExamplanstateIsNull() {
            addCriterion("ExamPlanState is null");
            return (Criteria) this;
        }

        public Criteria andExamplanstateIsNotNull() {
            addCriterion("ExamPlanState is not null");
            return (Criteria) this;
        }

        public Criteria andExamplanstateEqualTo(Integer value) {
            addCriterion("ExamPlanState =", value, "examplanstate");
            return (Criteria) this;
        }

        public Criteria andExamplanstateNotEqualTo(Integer value) {
            addCriterion("ExamPlanState <>", value, "examplanstate");
            return (Criteria) this;
        }

        public Criteria andExamplanstateGreaterThan(Integer value) {
            addCriterion("ExamPlanState >", value, "examplanstate");
            return (Criteria) this;
        }

        public Criteria andExamplanstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("ExamPlanState >=", value, "examplanstate");
            return (Criteria) this;
        }

        public Criteria andExamplanstateLessThan(Integer value) {
            addCriterion("ExamPlanState <", value, "examplanstate");
            return (Criteria) this;
        }

        public Criteria andExamplanstateLessThanOrEqualTo(Integer value) {
            addCriterion("ExamPlanState <=", value, "examplanstate");
            return (Criteria) this;
        }

        public Criteria andExamplanstateIn(List<Integer> values) {
            addCriterion("ExamPlanState in", values, "examplanstate");
            return (Criteria) this;
        }

        public Criteria andExamplanstateNotIn(List<Integer> values) {
            addCriterion("ExamPlanState not in", values, "examplanstate");
            return (Criteria) this;
        }

        public Criteria andExamplanstateBetween(Integer value1, Integer value2) {
            addCriterion("ExamPlanState between", value1, value2, "examplanstate");
            return (Criteria) this;
        }

        public Criteria andExamplanstateNotBetween(Integer value1, Integer value2) {
            addCriterion("ExamPlanState not between", value1, value2, "examplanstate");
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