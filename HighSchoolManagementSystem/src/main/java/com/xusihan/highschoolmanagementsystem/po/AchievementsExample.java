package com.xusihan.highschoolmanagementsystem.po;

import java.util.ArrayList;
import java.util.List;

public class AchievementsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AchievementsExample() {
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

        public Criteria andAchievementidIsNull() {
            addCriterion("AchievementID is null");
            return (Criteria) this;
        }

        public Criteria andAchievementidIsNotNull() {
            addCriterion("AchievementID is not null");
            return (Criteria) this;
        }

        public Criteria andAchievementidEqualTo(Integer value) {
            addCriterion("AchievementID =", value, "achievementid");
            return (Criteria) this;
        }

        public Criteria andAchievementidNotEqualTo(Integer value) {
            addCriterion("AchievementID <>", value, "achievementid");
            return (Criteria) this;
        }

        public Criteria andAchievementidGreaterThan(Integer value) {
            addCriterion("AchievementID >", value, "achievementid");
            return (Criteria) this;
        }

        public Criteria andAchievementidGreaterThanOrEqualTo(Integer value) {
            addCriterion("AchievementID >=", value, "achievementid");
            return (Criteria) this;
        }

        public Criteria andAchievementidLessThan(Integer value) {
            addCriterion("AchievementID <", value, "achievementid");
            return (Criteria) this;
        }

        public Criteria andAchievementidLessThanOrEqualTo(Integer value) {
            addCriterion("AchievementID <=", value, "achievementid");
            return (Criteria) this;
        }

        public Criteria andAchievementidIn(List<Integer> values) {
            addCriterion("AchievementID in", values, "achievementid");
            return (Criteria) this;
        }

        public Criteria andAchievementidNotIn(List<Integer> values) {
            addCriterion("AchievementID not in", values, "achievementid");
            return (Criteria) this;
        }

        public Criteria andAchievementidBetween(Integer value1, Integer value2) {
            addCriterion("AchievementID between", value1, value2, "achievementid");
            return (Criteria) this;
        }

        public Criteria andAchievementidNotBetween(Integer value1, Integer value2) {
            addCriterion("AchievementID not between", value1, value2, "achievementid");
            return (Criteria) this;
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

        public Criteria andStudentidIsNull() {
            addCriterion("StudentID is null");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNotNull() {
            addCriterion("StudentID is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidEqualTo(Integer value) {
            addCriterion("StudentID =", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotEqualTo(Integer value) {
            addCriterion("StudentID <>", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThan(Integer value) {
            addCriterion("StudentID >", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("StudentID >=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThan(Integer value) {
            addCriterion("StudentID <", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThanOrEqualTo(Integer value) {
            addCriterion("StudentID <=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidIn(List<Integer> values) {
            addCriterion("StudentID in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotIn(List<Integer> values) {
            addCriterion("StudentID not in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidBetween(Integer value1, Integer value2) {
            addCriterion("StudentID between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotBetween(Integer value1, Integer value2) {
            addCriterion("StudentID not between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("Result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("Result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("Result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("Result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("Result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("Result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("Result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("Result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("Result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("Result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("Result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("Result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("Result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("Result not between", value1, value2, "result");
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