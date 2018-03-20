package com.xusihan.highschoolmanagementsystem.po;

import java.util.ArrayList;
import java.util.List;

public class ExamtypesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamtypesExample() {
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

        public Criteria andExamtypeidIsNull() {
            addCriterion("ExamTypeID is null");
            return (Criteria) this;
        }

        public Criteria andExamtypeidIsNotNull() {
            addCriterion("ExamTypeID is not null");
            return (Criteria) this;
        }

        public Criteria andExamtypeidEqualTo(Integer value) {
            addCriterion("ExamTypeID =", value, "examtypeid");
            return (Criteria) this;
        }

        public Criteria andExamtypeidNotEqualTo(Integer value) {
            addCriterion("ExamTypeID <>", value, "examtypeid");
            return (Criteria) this;
        }

        public Criteria andExamtypeidGreaterThan(Integer value) {
            addCriterion("ExamTypeID >", value, "examtypeid");
            return (Criteria) this;
        }

        public Criteria andExamtypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ExamTypeID >=", value, "examtypeid");
            return (Criteria) this;
        }

        public Criteria andExamtypeidLessThan(Integer value) {
            addCriterion("ExamTypeID <", value, "examtypeid");
            return (Criteria) this;
        }

        public Criteria andExamtypeidLessThanOrEqualTo(Integer value) {
            addCriterion("ExamTypeID <=", value, "examtypeid");
            return (Criteria) this;
        }

        public Criteria andExamtypeidIn(List<Integer> values) {
            addCriterion("ExamTypeID in", values, "examtypeid");
            return (Criteria) this;
        }

        public Criteria andExamtypeidNotIn(List<Integer> values) {
            addCriterion("ExamTypeID not in", values, "examtypeid");
            return (Criteria) this;
        }

        public Criteria andExamtypeidBetween(Integer value1, Integer value2) {
            addCriterion("ExamTypeID between", value1, value2, "examtypeid");
            return (Criteria) this;
        }

        public Criteria andExamtypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("ExamTypeID not between", value1, value2, "examtypeid");
            return (Criteria) this;
        }

        public Criteria andSchoolidIsNull() {
            addCriterion("SchoolID is null");
            return (Criteria) this;
        }

        public Criteria andSchoolidIsNotNull() {
            addCriterion("SchoolID is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolidEqualTo(Integer value) {
            addCriterion("SchoolID =", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotEqualTo(Integer value) {
            addCriterion("SchoolID <>", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidGreaterThan(Integer value) {
            addCriterion("SchoolID >", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SchoolID >=", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidLessThan(Integer value) {
            addCriterion("SchoolID <", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidLessThanOrEqualTo(Integer value) {
            addCriterion("SchoolID <=", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidIn(List<Integer> values) {
            addCriterion("SchoolID in", values, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotIn(List<Integer> values) {
            addCriterion("SchoolID not in", values, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidBetween(Integer value1, Integer value2) {
            addCriterion("SchoolID between", value1, value2, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotBetween(Integer value1, Integer value2) {
            addCriterion("SchoolID not between", value1, value2, "schoolid");
            return (Criteria) this;
        }

        public Criteria andExamtypenameIsNull() {
            addCriterion("ExamTypeName is null");
            return (Criteria) this;
        }

        public Criteria andExamtypenameIsNotNull() {
            addCriterion("ExamTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andExamtypenameEqualTo(String value) {
            addCriterion("ExamTypeName =", value, "examtypename");
            return (Criteria) this;
        }

        public Criteria andExamtypenameNotEqualTo(String value) {
            addCriterion("ExamTypeName <>", value, "examtypename");
            return (Criteria) this;
        }

        public Criteria andExamtypenameGreaterThan(String value) {
            addCriterion("ExamTypeName >", value, "examtypename");
            return (Criteria) this;
        }

        public Criteria andExamtypenameGreaterThanOrEqualTo(String value) {
            addCriterion("ExamTypeName >=", value, "examtypename");
            return (Criteria) this;
        }

        public Criteria andExamtypenameLessThan(String value) {
            addCriterion("ExamTypeName <", value, "examtypename");
            return (Criteria) this;
        }

        public Criteria andExamtypenameLessThanOrEqualTo(String value) {
            addCriterion("ExamTypeName <=", value, "examtypename");
            return (Criteria) this;
        }

        public Criteria andExamtypenameLike(String value) {
            addCriterion("ExamTypeName like", value, "examtypename");
            return (Criteria) this;
        }

        public Criteria andExamtypenameNotLike(String value) {
            addCriterion("ExamTypeName not like", value, "examtypename");
            return (Criteria) this;
        }

        public Criteria andExamtypenameIn(List<String> values) {
            addCriterion("ExamTypeName in", values, "examtypename");
            return (Criteria) this;
        }

        public Criteria andExamtypenameNotIn(List<String> values) {
            addCriterion("ExamTypeName not in", values, "examtypename");
            return (Criteria) this;
        }

        public Criteria andExamtypenameBetween(String value1, String value2) {
            addCriterion("ExamTypeName between", value1, value2, "examtypename");
            return (Criteria) this;
        }

        public Criteria andExamtypenameNotBetween(String value1, String value2) {
            addCriterion("ExamTypeName not between", value1, value2, "examtypename");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andExamtypestateIsNull() {
            addCriterion("ExamTypeState is null");
            return (Criteria) this;
        }

        public Criteria andExamtypestateIsNotNull() {
            addCriterion("ExamTypeState is not null");
            return (Criteria) this;
        }

        public Criteria andExamtypestateEqualTo(Integer value) {
            addCriterion("ExamTypeState =", value, "examtypestate");
            return (Criteria) this;
        }

        public Criteria andExamtypestateNotEqualTo(Integer value) {
            addCriterion("ExamTypeState <>", value, "examtypestate");
            return (Criteria) this;
        }

        public Criteria andExamtypestateGreaterThan(Integer value) {
            addCriterion("ExamTypeState >", value, "examtypestate");
            return (Criteria) this;
        }

        public Criteria andExamtypestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("ExamTypeState >=", value, "examtypestate");
            return (Criteria) this;
        }

        public Criteria andExamtypestateLessThan(Integer value) {
            addCriterion("ExamTypeState <", value, "examtypestate");
            return (Criteria) this;
        }

        public Criteria andExamtypestateLessThanOrEqualTo(Integer value) {
            addCriterion("ExamTypeState <=", value, "examtypestate");
            return (Criteria) this;
        }

        public Criteria andExamtypestateIn(List<Integer> values) {
            addCriterion("ExamTypeState in", values, "examtypestate");
            return (Criteria) this;
        }

        public Criteria andExamtypestateNotIn(List<Integer> values) {
            addCriterion("ExamTypeState not in", values, "examtypestate");
            return (Criteria) this;
        }

        public Criteria andExamtypestateBetween(Integer value1, Integer value2) {
            addCriterion("ExamTypeState between", value1, value2, "examtypestate");
            return (Criteria) this;
        }

        public Criteria andExamtypestateNotBetween(Integer value1, Integer value2) {
            addCriterion("ExamTypeState not between", value1, value2, "examtypestate");
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