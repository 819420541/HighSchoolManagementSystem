package com.xusihan.highschoolmanagementsystem.po;

import java.util.ArrayList;
import java.util.List;

public class CoursebooksExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CoursebooksExample() {
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

        public Criteria andCoursebookidIsNull() {
            addCriterion("CourseBookID is null");
            return (Criteria) this;
        }

        public Criteria andCoursebookidIsNotNull() {
            addCriterion("CourseBookID is not null");
            return (Criteria) this;
        }

        public Criteria andCoursebookidEqualTo(Integer value) {
            addCriterion("CourseBookID =", value, "coursebookid");
            return (Criteria) this;
        }

        public Criteria andCoursebookidNotEqualTo(Integer value) {
            addCriterion("CourseBookID <>", value, "coursebookid");
            return (Criteria) this;
        }

        public Criteria andCoursebookidGreaterThan(Integer value) {
            addCriterion("CourseBookID >", value, "coursebookid");
            return (Criteria) this;
        }

        public Criteria andCoursebookidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CourseBookID >=", value, "coursebookid");
            return (Criteria) this;
        }

        public Criteria andCoursebookidLessThan(Integer value) {
            addCriterion("CourseBookID <", value, "coursebookid");
            return (Criteria) this;
        }

        public Criteria andCoursebookidLessThanOrEqualTo(Integer value) {
            addCriterion("CourseBookID <=", value, "coursebookid");
            return (Criteria) this;
        }

        public Criteria andCoursebookidIn(List<Integer> values) {
            addCriterion("CourseBookID in", values, "coursebookid");
            return (Criteria) this;
        }

        public Criteria andCoursebookidNotIn(List<Integer> values) {
            addCriterion("CourseBookID not in", values, "coursebookid");
            return (Criteria) this;
        }

        public Criteria andCoursebookidBetween(Integer value1, Integer value2) {
            addCriterion("CourseBookID between", value1, value2, "coursebookid");
            return (Criteria) this;
        }

        public Criteria andCoursebookidNotBetween(Integer value1, Integer value2) {
            addCriterion("CourseBookID not between", value1, value2, "coursebookid");
            return (Criteria) this;
        }

        public Criteria andCoursebooknameIsNull() {
            addCriterion("CourseBookName is null");
            return (Criteria) this;
        }

        public Criteria andCoursebooknameIsNotNull() {
            addCriterion("CourseBookName is not null");
            return (Criteria) this;
        }

        public Criteria andCoursebooknameEqualTo(String value) {
            addCriterion("CourseBookName =", value, "coursebookname");
            return (Criteria) this;
        }

        public Criteria andCoursebooknameNotEqualTo(String value) {
            addCriterion("CourseBookName <>", value, "coursebookname");
            return (Criteria) this;
        }

        public Criteria andCoursebooknameGreaterThan(String value) {
            addCriterion("CourseBookName >", value, "coursebookname");
            return (Criteria) this;
        }

        public Criteria andCoursebooknameGreaterThanOrEqualTo(String value) {
            addCriterion("CourseBookName >=", value, "coursebookname");
            return (Criteria) this;
        }

        public Criteria andCoursebooknameLessThan(String value) {
            addCriterion("CourseBookName <", value, "coursebookname");
            return (Criteria) this;
        }

        public Criteria andCoursebooknameLessThanOrEqualTo(String value) {
            addCriterion("CourseBookName <=", value, "coursebookname");
            return (Criteria) this;
        }

        public Criteria andCoursebooknameLike(String value) {
            addCriterion("CourseBookName like", value, "coursebookname");
            return (Criteria) this;
        }

        public Criteria andCoursebooknameNotLike(String value) {
            addCriterion("CourseBookName not like", value, "coursebookname");
            return (Criteria) this;
        }

        public Criteria andCoursebooknameIn(List<String> values) {
            addCriterion("CourseBookName in", values, "coursebookname");
            return (Criteria) this;
        }

        public Criteria andCoursebooknameNotIn(List<String> values) {
            addCriterion("CourseBookName not in", values, "coursebookname");
            return (Criteria) this;
        }

        public Criteria andCoursebooknameBetween(String value1, String value2) {
            addCriterion("CourseBookName between", value1, value2, "coursebookname");
            return (Criteria) this;
        }

        public Criteria andCoursebooknameNotBetween(String value1, String value2) {
            addCriterion("CourseBookName not between", value1, value2, "coursebookname");
            return (Criteria) this;
        }

        public Criteria andCoursebookcodeIsNull() {
            addCriterion("CourseBookCode is null");
            return (Criteria) this;
        }

        public Criteria andCoursebookcodeIsNotNull() {
            addCriterion("CourseBookCode is not null");
            return (Criteria) this;
        }

        public Criteria andCoursebookcodeEqualTo(String value) {
            addCriterion("CourseBookCode =", value, "coursebookcode");
            return (Criteria) this;
        }

        public Criteria andCoursebookcodeNotEqualTo(String value) {
            addCriterion("CourseBookCode <>", value, "coursebookcode");
            return (Criteria) this;
        }

        public Criteria andCoursebookcodeGreaterThan(String value) {
            addCriterion("CourseBookCode >", value, "coursebookcode");
            return (Criteria) this;
        }

        public Criteria andCoursebookcodeGreaterThanOrEqualTo(String value) {
            addCriterion("CourseBookCode >=", value, "coursebookcode");
            return (Criteria) this;
        }

        public Criteria andCoursebookcodeLessThan(String value) {
            addCriterion("CourseBookCode <", value, "coursebookcode");
            return (Criteria) this;
        }

        public Criteria andCoursebookcodeLessThanOrEqualTo(String value) {
            addCriterion("CourseBookCode <=", value, "coursebookcode");
            return (Criteria) this;
        }

        public Criteria andCoursebookcodeLike(String value) {
            addCriterion("CourseBookCode like", value, "coursebookcode");
            return (Criteria) this;
        }

        public Criteria andCoursebookcodeNotLike(String value) {
            addCriterion("CourseBookCode not like", value, "coursebookcode");
            return (Criteria) this;
        }

        public Criteria andCoursebookcodeIn(List<String> values) {
            addCriterion("CourseBookCode in", values, "coursebookcode");
            return (Criteria) this;
        }

        public Criteria andCoursebookcodeNotIn(List<String> values) {
            addCriterion("CourseBookCode not in", values, "coursebookcode");
            return (Criteria) this;
        }

        public Criteria andCoursebookcodeBetween(String value1, String value2) {
            addCriterion("CourseBookCode between", value1, value2, "coursebookcode");
            return (Criteria) this;
        }

        public Criteria andCoursebookcodeNotBetween(String value1, String value2) {
            addCriterion("CourseBookCode not between", value1, value2, "coursebookcode");
            return (Criteria) this;
        }

        public Criteria andCoursebookdescIsNull() {
            addCriterion("CourseBookDesc is null");
            return (Criteria) this;
        }

        public Criteria andCoursebookdescIsNotNull() {
            addCriterion("CourseBookDesc is not null");
            return (Criteria) this;
        }

        public Criteria andCoursebookdescEqualTo(String value) {
            addCriterion("CourseBookDesc =", value, "coursebookdesc");
            return (Criteria) this;
        }

        public Criteria andCoursebookdescNotEqualTo(String value) {
            addCriterion("CourseBookDesc <>", value, "coursebookdesc");
            return (Criteria) this;
        }

        public Criteria andCoursebookdescGreaterThan(String value) {
            addCriterion("CourseBookDesc >", value, "coursebookdesc");
            return (Criteria) this;
        }

        public Criteria andCoursebookdescGreaterThanOrEqualTo(String value) {
            addCriterion("CourseBookDesc >=", value, "coursebookdesc");
            return (Criteria) this;
        }

        public Criteria andCoursebookdescLessThan(String value) {
            addCriterion("CourseBookDesc <", value, "coursebookdesc");
            return (Criteria) this;
        }

        public Criteria andCoursebookdescLessThanOrEqualTo(String value) {
            addCriterion("CourseBookDesc <=", value, "coursebookdesc");
            return (Criteria) this;
        }

        public Criteria andCoursebookdescLike(String value) {
            addCriterion("CourseBookDesc like", value, "coursebookdesc");
            return (Criteria) this;
        }

        public Criteria andCoursebookdescNotLike(String value) {
            addCriterion("CourseBookDesc not like", value, "coursebookdesc");
            return (Criteria) this;
        }

        public Criteria andCoursebookdescIn(List<String> values) {
            addCriterion("CourseBookDesc in", values, "coursebookdesc");
            return (Criteria) this;
        }

        public Criteria andCoursebookdescNotIn(List<String> values) {
            addCriterion("CourseBookDesc not in", values, "coursebookdesc");
            return (Criteria) this;
        }

        public Criteria andCoursebookdescBetween(String value1, String value2) {
            addCriterion("CourseBookDesc between", value1, value2, "coursebookdesc");
            return (Criteria) this;
        }

        public Criteria andCoursebookdescNotBetween(String value1, String value2) {
            addCriterion("CourseBookDesc not between", value1, value2, "coursebookdesc");
            return (Criteria) this;
        }

        public Criteria andTheoryperiodIsNull() {
            addCriterion("TheoryPeriod is null");
            return (Criteria) this;
        }

        public Criteria andTheoryperiodIsNotNull() {
            addCriterion("TheoryPeriod is not null");
            return (Criteria) this;
        }

        public Criteria andTheoryperiodEqualTo(Integer value) {
            addCriterion("TheoryPeriod =", value, "theoryperiod");
            return (Criteria) this;
        }

        public Criteria andTheoryperiodNotEqualTo(Integer value) {
            addCriterion("TheoryPeriod <>", value, "theoryperiod");
            return (Criteria) this;
        }

        public Criteria andTheoryperiodGreaterThan(Integer value) {
            addCriterion("TheoryPeriod >", value, "theoryperiod");
            return (Criteria) this;
        }

        public Criteria andTheoryperiodGreaterThanOrEqualTo(Integer value) {
            addCriterion("TheoryPeriod >=", value, "theoryperiod");
            return (Criteria) this;
        }

        public Criteria andTheoryperiodLessThan(Integer value) {
            addCriterion("TheoryPeriod <", value, "theoryperiod");
            return (Criteria) this;
        }

        public Criteria andTheoryperiodLessThanOrEqualTo(Integer value) {
            addCriterion("TheoryPeriod <=", value, "theoryperiod");
            return (Criteria) this;
        }

        public Criteria andTheoryperiodIn(List<Integer> values) {
            addCriterion("TheoryPeriod in", values, "theoryperiod");
            return (Criteria) this;
        }

        public Criteria andTheoryperiodNotIn(List<Integer> values) {
            addCriterion("TheoryPeriod not in", values, "theoryperiod");
            return (Criteria) this;
        }

        public Criteria andTheoryperiodBetween(Integer value1, Integer value2) {
            addCriterion("TheoryPeriod between", value1, value2, "theoryperiod");
            return (Criteria) this;
        }

        public Criteria andTheoryperiodNotBetween(Integer value1, Integer value2) {
            addCriterion("TheoryPeriod not between", value1, value2, "theoryperiod");
            return (Criteria) this;
        }

        public Criteria andPracticeperiodIsNull() {
            addCriterion("PracticePeriod is null");
            return (Criteria) this;
        }

        public Criteria andPracticeperiodIsNotNull() {
            addCriterion("PracticePeriod is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeperiodEqualTo(Integer value) {
            addCriterion("PracticePeriod =", value, "practiceperiod");
            return (Criteria) this;
        }

        public Criteria andPracticeperiodNotEqualTo(Integer value) {
            addCriterion("PracticePeriod <>", value, "practiceperiod");
            return (Criteria) this;
        }

        public Criteria andPracticeperiodGreaterThan(Integer value) {
            addCriterion("PracticePeriod >", value, "practiceperiod");
            return (Criteria) this;
        }

        public Criteria andPracticeperiodGreaterThanOrEqualTo(Integer value) {
            addCriterion("PracticePeriod >=", value, "practiceperiod");
            return (Criteria) this;
        }

        public Criteria andPracticeperiodLessThan(Integer value) {
            addCriterion("PracticePeriod <", value, "practiceperiod");
            return (Criteria) this;
        }

        public Criteria andPracticeperiodLessThanOrEqualTo(Integer value) {
            addCriterion("PracticePeriod <=", value, "practiceperiod");
            return (Criteria) this;
        }

        public Criteria andPracticeperiodIn(List<Integer> values) {
            addCriterion("PracticePeriod in", values, "practiceperiod");
            return (Criteria) this;
        }

        public Criteria andPracticeperiodNotIn(List<Integer> values) {
            addCriterion("PracticePeriod not in", values, "practiceperiod");
            return (Criteria) this;
        }

        public Criteria andPracticeperiodBetween(Integer value1, Integer value2) {
            addCriterion("PracticePeriod between", value1, value2, "practiceperiod");
            return (Criteria) this;
        }

        public Criteria andPracticeperiodNotBetween(Integer value1, Integer value2) {
            addCriterion("PracticePeriod not between", value1, value2, "practiceperiod");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIsNull() {
            addCriterion("Knowledge is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIsNotNull() {
            addCriterion("Knowledge is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeEqualTo(String value) {
            addCriterion("Knowledge =", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNotEqualTo(String value) {
            addCriterion("Knowledge <>", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeGreaterThan(String value) {
            addCriterion("Knowledge >", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeGreaterThanOrEqualTo(String value) {
            addCriterion("Knowledge >=", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeLessThan(String value) {
            addCriterion("Knowledge <", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeLessThanOrEqualTo(String value) {
            addCriterion("Knowledge <=", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeLike(String value) {
            addCriterion("Knowledge like", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNotLike(String value) {
            addCriterion("Knowledge not like", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIn(List<String> values) {
            addCriterion("Knowledge in", values, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNotIn(List<String> values) {
            addCriterion("Knowledge not in", values, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeBetween(String value1, String value2) {
            addCriterion("Knowledge between", value1, value2, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNotBetween(String value1, String value2) {
            addCriterion("Knowledge not between", value1, value2, "knowledge");
            return (Criteria) this;
        }

        public Criteria andSuggestionIsNull() {
            addCriterion("Suggestion is null");
            return (Criteria) this;
        }

        public Criteria andSuggestionIsNotNull() {
            addCriterion("Suggestion is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestionEqualTo(String value) {
            addCriterion("Suggestion =", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionNotEqualTo(String value) {
            addCriterion("Suggestion <>", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionGreaterThan(String value) {
            addCriterion("Suggestion >", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionGreaterThanOrEqualTo(String value) {
            addCriterion("Suggestion >=", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionLessThan(String value) {
            addCriterion("Suggestion <", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionLessThanOrEqualTo(String value) {
            addCriterion("Suggestion <=", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionLike(String value) {
            addCriterion("Suggestion like", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionNotLike(String value) {
            addCriterion("Suggestion not like", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionIn(List<String> values) {
            addCriterion("Suggestion in", values, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionNotIn(List<String> values) {
            addCriterion("Suggestion not in", values, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionBetween(String value1, String value2) {
            addCriterion("Suggestion between", value1, value2, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionNotBetween(String value1, String value2) {
            addCriterion("Suggestion not between", value1, value2, "suggestion");
            return (Criteria) this;
        }

        public Criteria andCoursebookstateIsNull() {
            addCriterion("CourseBookState is null");
            return (Criteria) this;
        }

        public Criteria andCoursebookstateIsNotNull() {
            addCriterion("CourseBookState is not null");
            return (Criteria) this;
        }

        public Criteria andCoursebookstateEqualTo(Integer value) {
            addCriterion("CourseBookState =", value, "coursebookstate");
            return (Criteria) this;
        }

        public Criteria andCoursebookstateNotEqualTo(Integer value) {
            addCriterion("CourseBookState <>", value, "coursebookstate");
            return (Criteria) this;
        }

        public Criteria andCoursebookstateGreaterThan(Integer value) {
            addCriterion("CourseBookState >", value, "coursebookstate");
            return (Criteria) this;
        }

        public Criteria andCoursebookstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("CourseBookState >=", value, "coursebookstate");
            return (Criteria) this;
        }

        public Criteria andCoursebookstateLessThan(Integer value) {
            addCriterion("CourseBookState <", value, "coursebookstate");
            return (Criteria) this;
        }

        public Criteria andCoursebookstateLessThanOrEqualTo(Integer value) {
            addCriterion("CourseBookState <=", value, "coursebookstate");
            return (Criteria) this;
        }

        public Criteria andCoursebookstateIn(List<Integer> values) {
            addCriterion("CourseBookState in", values, "coursebookstate");
            return (Criteria) this;
        }

        public Criteria andCoursebookstateNotIn(List<Integer> values) {
            addCriterion("CourseBookState not in", values, "coursebookstate");
            return (Criteria) this;
        }

        public Criteria andCoursebookstateBetween(Integer value1, Integer value2) {
            addCriterion("CourseBookState between", value1, value2, "coursebookstate");
            return (Criteria) this;
        }

        public Criteria andCoursebookstateNotBetween(Integer value1, Integer value2) {
            addCriterion("CourseBookState not between", value1, value2, "coursebookstate");
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