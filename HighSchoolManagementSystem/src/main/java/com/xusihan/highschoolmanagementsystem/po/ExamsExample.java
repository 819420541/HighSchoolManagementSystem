package com.xusihan.highschoolmanagementsystem.po;

import java.util.ArrayList;
import java.util.List;

public class ExamsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamsExample() {
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

        public Criteria andExamnameIsNull() {
            addCriterion("ExamName is null");
            return (Criteria) this;
        }

        public Criteria andExamnameIsNotNull() {
            addCriterion("ExamName is not null");
            return (Criteria) this;
        }

        public Criteria andExamnameEqualTo(String value) {
            addCriterion("ExamName =", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameNotEqualTo(String value) {
            addCriterion("ExamName <>", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameGreaterThan(String value) {
            addCriterion("ExamName >", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameGreaterThanOrEqualTo(String value) {
            addCriterion("ExamName >=", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameLessThan(String value) {
            addCriterion("ExamName <", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameLessThanOrEqualTo(String value) {
            addCriterion("ExamName <=", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameLike(String value) {
            addCriterion("ExamName like", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameNotLike(String value) {
            addCriterion("ExamName not like", value, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameIn(List<String> values) {
            addCriterion("ExamName in", values, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameNotIn(List<String> values) {
            addCriterion("ExamName not in", values, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameBetween(String value1, String value2) {
            addCriterion("ExamName between", value1, value2, "examname");
            return (Criteria) this;
        }

        public Criteria andExamnameNotBetween(String value1, String value2) {
            addCriterion("ExamName not between", value1, value2, "examname");
            return (Criteria) this;
        }

        public Criteria andExammediumIsNull() {
            addCriterion("ExamMedium is null");
            return (Criteria) this;
        }

        public Criteria andExammediumIsNotNull() {
            addCriterion("ExamMedium is not null");
            return (Criteria) this;
        }

        public Criteria andExammediumEqualTo(String value) {
            addCriterion("ExamMedium =", value, "exammedium");
            return (Criteria) this;
        }

        public Criteria andExammediumNotEqualTo(String value) {
            addCriterion("ExamMedium <>", value, "exammedium");
            return (Criteria) this;
        }

        public Criteria andExammediumGreaterThan(String value) {
            addCriterion("ExamMedium >", value, "exammedium");
            return (Criteria) this;
        }

        public Criteria andExammediumGreaterThanOrEqualTo(String value) {
            addCriterion("ExamMedium >=", value, "exammedium");
            return (Criteria) this;
        }

        public Criteria andExammediumLessThan(String value) {
            addCriterion("ExamMedium <", value, "exammedium");
            return (Criteria) this;
        }

        public Criteria andExammediumLessThanOrEqualTo(String value) {
            addCriterion("ExamMedium <=", value, "exammedium");
            return (Criteria) this;
        }

        public Criteria andExammediumLike(String value) {
            addCriterion("ExamMedium like", value, "exammedium");
            return (Criteria) this;
        }

        public Criteria andExammediumNotLike(String value) {
            addCriterion("ExamMedium not like", value, "exammedium");
            return (Criteria) this;
        }

        public Criteria andExammediumIn(List<String> values) {
            addCriterion("ExamMedium in", values, "exammedium");
            return (Criteria) this;
        }

        public Criteria andExammediumNotIn(List<String> values) {
            addCriterion("ExamMedium not in", values, "exammedium");
            return (Criteria) this;
        }

        public Criteria andExammediumBetween(String value1, String value2) {
            addCriterion("ExamMedium between", value1, value2, "exammedium");
            return (Criteria) this;
        }

        public Criteria andExammediumNotBetween(String value1, String value2) {
            addCriterion("ExamMedium not between", value1, value2, "exammedium");
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

        public Criteria andExamstateIsNull() {
            addCriterion("ExamState is null");
            return (Criteria) this;
        }

        public Criteria andExamstateIsNotNull() {
            addCriterion("ExamState is not null");
            return (Criteria) this;
        }

        public Criteria andExamstateEqualTo(Integer value) {
            addCriterion("ExamState =", value, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateNotEqualTo(Integer value) {
            addCriterion("ExamState <>", value, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateGreaterThan(Integer value) {
            addCriterion("ExamState >", value, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("ExamState >=", value, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateLessThan(Integer value) {
            addCriterion("ExamState <", value, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateLessThanOrEqualTo(Integer value) {
            addCriterion("ExamState <=", value, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateIn(List<Integer> values) {
            addCriterion("ExamState in", values, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateNotIn(List<Integer> values) {
            addCriterion("ExamState not in", values, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateBetween(Integer value1, Integer value2) {
            addCriterion("ExamState between", value1, value2, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateNotBetween(Integer value1, Integer value2) {
            addCriterion("ExamState not between", value1, value2, "examstate");
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