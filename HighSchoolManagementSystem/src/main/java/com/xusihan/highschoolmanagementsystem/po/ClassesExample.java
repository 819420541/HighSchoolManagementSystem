package com.xusihan.highschoolmanagementsystem.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ClassesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassesExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andClassnameIsNull() {
            addCriterion("ClassName is null");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNotNull() {
            addCriterion("ClassName is not null");
            return (Criteria) this;
        }

        public Criteria andClassnameEqualTo(String value) {
            addCriterion("ClassName =", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotEqualTo(String value) {
            addCriterion("ClassName <>", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThan(String value) {
            addCriterion("ClassName >", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("ClassName >=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThan(String value) {
            addCriterion("ClassName <", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThanOrEqualTo(String value) {
            addCriterion("ClassName <=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLike(String value) {
            addCriterion("ClassName like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotLike(String value) {
            addCriterion("ClassName not like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameIn(List<String> values) {
            addCriterion("ClassName in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotIn(List<String> values) {
            addCriterion("ClassName not in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameBetween(String value1, String value2) {
            addCriterion("ClassName between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotBetween(String value1, String value2) {
            addCriterion("ClassName not between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andTeacherofchargeIsNull() {
            addCriterion("TeacherOfCharge is null");
            return (Criteria) this;
        }

        public Criteria andTeacherofchargeIsNotNull() {
            addCriterion("TeacherOfCharge is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherofchargeEqualTo(String value) {
            addCriterion("TeacherOfCharge =", value, "teacherofcharge");
            return (Criteria) this;
        }

        public Criteria andTeacherofchargeNotEqualTo(String value) {
            addCriterion("TeacherOfCharge <>", value, "teacherofcharge");
            return (Criteria) this;
        }

        public Criteria andTeacherofchargeGreaterThan(String value) {
            addCriterion("TeacherOfCharge >", value, "teacherofcharge");
            return (Criteria) this;
        }

        public Criteria andTeacherofchargeGreaterThanOrEqualTo(String value) {
            addCriterion("TeacherOfCharge >=", value, "teacherofcharge");
            return (Criteria) this;
        }

        public Criteria andTeacherofchargeLessThan(String value) {
            addCriterion("TeacherOfCharge <", value, "teacherofcharge");
            return (Criteria) this;
        }

        public Criteria andTeacherofchargeLessThanOrEqualTo(String value) {
            addCriterion("TeacherOfCharge <=", value, "teacherofcharge");
            return (Criteria) this;
        }

        public Criteria andTeacherofchargeLike(String value) {
            addCriterion("TeacherOfCharge like", value, "teacherofcharge");
            return (Criteria) this;
        }

        public Criteria andTeacherofchargeNotLike(String value) {
            addCriterion("TeacherOfCharge not like", value, "teacherofcharge");
            return (Criteria) this;
        }

        public Criteria andTeacherofchargeIn(List<String> values) {
            addCriterion("TeacherOfCharge in", values, "teacherofcharge");
            return (Criteria) this;
        }

        public Criteria andTeacherofchargeNotIn(List<String> values) {
            addCriterion("TeacherOfCharge not in", values, "teacherofcharge");
            return (Criteria) this;
        }

        public Criteria andTeacherofchargeBetween(String value1, String value2) {
            addCriterion("TeacherOfCharge between", value1, value2, "teacherofcharge");
            return (Criteria) this;
        }

        public Criteria andTeacherofchargeNotBetween(String value1, String value2) {
            addCriterion("TeacherOfCharge not between", value1, value2, "teacherofcharge");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateIsNull() {
            addCriterion("EnrollmentDate is null");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateIsNotNull() {
            addCriterion("EnrollmentDate is not null");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateEqualTo(Date value) {
            addCriterionForJDBCDate("EnrollmentDate =", value, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("EnrollmentDate <>", value, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateGreaterThan(Date value) {
            addCriterionForJDBCDate("EnrollmentDate >", value, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EnrollmentDate >=", value, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateLessThan(Date value) {
            addCriterionForJDBCDate("EnrollmentDate <", value, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EnrollmentDate <=", value, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateIn(List<Date> values) {
            addCriterionForJDBCDate("EnrollmentDate in", values, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("EnrollmentDate not in", values, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EnrollmentDate between", value1, value2, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EnrollmentDate not between", value1, value2, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateIsNull() {
            addCriterion("GraduateDate is null");
            return (Criteria) this;
        }

        public Criteria andGraduatedateIsNotNull() {
            addCriterion("GraduateDate is not null");
            return (Criteria) this;
        }

        public Criteria andGraduatedateEqualTo(Date value) {
            addCriterionForJDBCDate("GraduateDate =", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("GraduateDate <>", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateGreaterThan(Date value) {
            addCriterionForJDBCDate("GraduateDate >", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("GraduateDate >=", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateLessThan(Date value) {
            addCriterionForJDBCDate("GraduateDate <", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("GraduateDate <=", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateIn(List<Date> values) {
            addCriterionForJDBCDate("GraduateDate in", values, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("GraduateDate not in", values, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("GraduateDate between", value1, value2, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("GraduateDate not between", value1, value2, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateIsNull() {
            addCriterion("isGraduate is null");
            return (Criteria) this;
        }

        public Criteria andIsgraduateIsNotNull() {
            addCriterion("isGraduate is not null");
            return (Criteria) this;
        }

        public Criteria andIsgraduateEqualTo(Boolean value) {
            addCriterion("isGraduate =", value, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateNotEqualTo(Boolean value) {
            addCriterion("isGraduate <>", value, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateGreaterThan(Boolean value) {
            addCriterion("isGraduate >", value, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isGraduate >=", value, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateLessThan(Boolean value) {
            addCriterion("isGraduate <", value, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateLessThanOrEqualTo(Boolean value) {
            addCriterion("isGraduate <=", value, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateIn(List<Boolean> values) {
            addCriterion("isGraduate in", values, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateNotIn(List<Boolean> values) {
            addCriterion("isGraduate not in", values, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateBetween(Boolean value1, Boolean value2) {
            addCriterion("isGraduate between", value1, value2, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isGraduate not between", value1, value2, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andClassstateIsNull() {
            addCriterion("ClassState is null");
            return (Criteria) this;
        }

        public Criteria andClassstateIsNotNull() {
            addCriterion("ClassState is not null");
            return (Criteria) this;
        }

        public Criteria andClassstateEqualTo(Integer value) {
            addCriterion("ClassState =", value, "classstate");
            return (Criteria) this;
        }

        public Criteria andClassstateNotEqualTo(Integer value) {
            addCriterion("ClassState <>", value, "classstate");
            return (Criteria) this;
        }

        public Criteria andClassstateGreaterThan(Integer value) {
            addCriterion("ClassState >", value, "classstate");
            return (Criteria) this;
        }

        public Criteria andClassstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("ClassState >=", value, "classstate");
            return (Criteria) this;
        }

        public Criteria andClassstateLessThan(Integer value) {
            addCriterion("ClassState <", value, "classstate");
            return (Criteria) this;
        }

        public Criteria andClassstateLessThanOrEqualTo(Integer value) {
            addCriterion("ClassState <=", value, "classstate");
            return (Criteria) this;
        }

        public Criteria andClassstateIn(List<Integer> values) {
            addCriterion("ClassState in", values, "classstate");
            return (Criteria) this;
        }

        public Criteria andClassstateNotIn(List<Integer> values) {
            addCriterion("ClassState not in", values, "classstate");
            return (Criteria) this;
        }

        public Criteria andClassstateBetween(Integer value1, Integer value2) {
            addCriterion("ClassState between", value1, value2, "classstate");
            return (Criteria) this;
        }

        public Criteria andClassstateNotBetween(Integer value1, Integer value2) {
            addCriterion("ClassState not between", value1, value2, "classstate");
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