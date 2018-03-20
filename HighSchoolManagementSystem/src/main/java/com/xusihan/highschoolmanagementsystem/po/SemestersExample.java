package com.xusihan.highschoolmanagementsystem.po;

import java.util.ArrayList;
import java.util.List;

public class SemestersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SemestersExample() {
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

        public Criteria andSemesteridIsNull() {
            addCriterion("SemesterID is null");
            return (Criteria) this;
        }

        public Criteria andSemesteridIsNotNull() {
            addCriterion("SemesterID is not null");
            return (Criteria) this;
        }

        public Criteria andSemesteridEqualTo(Integer value) {
            addCriterion("SemesterID =", value, "semesterid");
            return (Criteria) this;
        }

        public Criteria andSemesteridNotEqualTo(Integer value) {
            addCriterion("SemesterID <>", value, "semesterid");
            return (Criteria) this;
        }

        public Criteria andSemesteridGreaterThan(Integer value) {
            addCriterion("SemesterID >", value, "semesterid");
            return (Criteria) this;
        }

        public Criteria andSemesteridGreaterThanOrEqualTo(Integer value) {
            addCriterion("SemesterID >=", value, "semesterid");
            return (Criteria) this;
        }

        public Criteria andSemesteridLessThan(Integer value) {
            addCriterion("SemesterID <", value, "semesterid");
            return (Criteria) this;
        }

        public Criteria andSemesteridLessThanOrEqualTo(Integer value) {
            addCriterion("SemesterID <=", value, "semesterid");
            return (Criteria) this;
        }

        public Criteria andSemesteridIn(List<Integer> values) {
            addCriterion("SemesterID in", values, "semesterid");
            return (Criteria) this;
        }

        public Criteria andSemesteridNotIn(List<Integer> values) {
            addCriterion("SemesterID not in", values, "semesterid");
            return (Criteria) this;
        }

        public Criteria andSemesteridBetween(Integer value1, Integer value2) {
            addCriterion("SemesterID between", value1, value2, "semesterid");
            return (Criteria) this;
        }

        public Criteria andSemesteridNotBetween(Integer value1, Integer value2) {
            addCriterion("SemesterID not between", value1, value2, "semesterid");
            return (Criteria) this;
        }

        public Criteria andSemesternameIsNull() {
            addCriterion("SemesterName is null");
            return (Criteria) this;
        }

        public Criteria andSemesternameIsNotNull() {
            addCriterion("SemesterName is not null");
            return (Criteria) this;
        }

        public Criteria andSemesternameEqualTo(String value) {
            addCriterion("SemesterName =", value, "semestername");
            return (Criteria) this;
        }

        public Criteria andSemesternameNotEqualTo(String value) {
            addCriterion("SemesterName <>", value, "semestername");
            return (Criteria) this;
        }

        public Criteria andSemesternameGreaterThan(String value) {
            addCriterion("SemesterName >", value, "semestername");
            return (Criteria) this;
        }

        public Criteria andSemesternameGreaterThanOrEqualTo(String value) {
            addCriterion("SemesterName >=", value, "semestername");
            return (Criteria) this;
        }

        public Criteria andSemesternameLessThan(String value) {
            addCriterion("SemesterName <", value, "semestername");
            return (Criteria) this;
        }

        public Criteria andSemesternameLessThanOrEqualTo(String value) {
            addCriterion("SemesterName <=", value, "semestername");
            return (Criteria) this;
        }

        public Criteria andSemesternameLike(String value) {
            addCriterion("SemesterName like", value, "semestername");
            return (Criteria) this;
        }

        public Criteria andSemesternameNotLike(String value) {
            addCriterion("SemesterName not like", value, "semestername");
            return (Criteria) this;
        }

        public Criteria andSemesternameIn(List<String> values) {
            addCriterion("SemesterName in", values, "semestername");
            return (Criteria) this;
        }

        public Criteria andSemesternameNotIn(List<String> values) {
            addCriterion("SemesterName not in", values, "semestername");
            return (Criteria) this;
        }

        public Criteria andSemesternameBetween(String value1, String value2) {
            addCriterion("SemesterName between", value1, value2, "semestername");
            return (Criteria) this;
        }

        public Criteria andSemesternameNotBetween(String value1, String value2) {
            addCriterion("SemesterName not between", value1, value2, "semestername");
            return (Criteria) this;
        }

        public Criteria andSemesterstateIsNull() {
            addCriterion("SemesterState is null");
            return (Criteria) this;
        }

        public Criteria andSemesterstateIsNotNull() {
            addCriterion("SemesterState is not null");
            return (Criteria) this;
        }

        public Criteria andSemesterstateEqualTo(Integer value) {
            addCriterion("SemesterState =", value, "semesterstate");
            return (Criteria) this;
        }

        public Criteria andSemesterstateNotEqualTo(Integer value) {
            addCriterion("SemesterState <>", value, "semesterstate");
            return (Criteria) this;
        }

        public Criteria andSemesterstateGreaterThan(Integer value) {
            addCriterion("SemesterState >", value, "semesterstate");
            return (Criteria) this;
        }

        public Criteria andSemesterstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("SemesterState >=", value, "semesterstate");
            return (Criteria) this;
        }

        public Criteria andSemesterstateLessThan(Integer value) {
            addCriterion("SemesterState <", value, "semesterstate");
            return (Criteria) this;
        }

        public Criteria andSemesterstateLessThanOrEqualTo(Integer value) {
            addCriterion("SemesterState <=", value, "semesterstate");
            return (Criteria) this;
        }

        public Criteria andSemesterstateIn(List<Integer> values) {
            addCriterion("SemesterState in", values, "semesterstate");
            return (Criteria) this;
        }

        public Criteria andSemesterstateNotIn(List<Integer> values) {
            addCriterion("SemesterState not in", values, "semesterstate");
            return (Criteria) this;
        }

        public Criteria andSemesterstateBetween(Integer value1, Integer value2) {
            addCriterion("SemesterState between", value1, value2, "semesterstate");
            return (Criteria) this;
        }

        public Criteria andSemesterstateNotBetween(Integer value1, Integer value2) {
            addCriterion("SemesterState not between", value1, value2, "semesterstate");
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