package com.xusihan.highschoolmanagementsystem.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendancesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendancesExample() {
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

        public Criteria andAttendanceidIsNull() {
            addCriterion("AttendanceID is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceidIsNotNull() {
            addCriterion("AttendanceID is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceidEqualTo(Integer value) {
            addCriterion("AttendanceID =", value, "attendanceid");
            return (Criteria) this;
        }

        public Criteria andAttendanceidNotEqualTo(Integer value) {
            addCriterion("AttendanceID <>", value, "attendanceid");
            return (Criteria) this;
        }

        public Criteria andAttendanceidGreaterThan(Integer value) {
            addCriterion("AttendanceID >", value, "attendanceid");
            return (Criteria) this;
        }

        public Criteria andAttendanceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("AttendanceID >=", value, "attendanceid");
            return (Criteria) this;
        }

        public Criteria andAttendanceidLessThan(Integer value) {
            addCriterion("AttendanceID <", value, "attendanceid");
            return (Criteria) this;
        }

        public Criteria andAttendanceidLessThanOrEqualTo(Integer value) {
            addCriterion("AttendanceID <=", value, "attendanceid");
            return (Criteria) this;
        }

        public Criteria andAttendanceidIn(List<Integer> values) {
            addCriterion("AttendanceID in", values, "attendanceid");
            return (Criteria) this;
        }

        public Criteria andAttendanceidNotIn(List<Integer> values) {
            addCriterion("AttendanceID not in", values, "attendanceid");
            return (Criteria) this;
        }

        public Criteria andAttendanceidBetween(Integer value1, Integer value2) {
            addCriterion("AttendanceID between", value1, value2, "attendanceid");
            return (Criteria) this;
        }

        public Criteria andAttendanceidNotBetween(Integer value1, Integer value2) {
            addCriterion("AttendanceID not between", value1, value2, "attendanceid");
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

        public Criteria andCourseidIsNull() {
            addCriterion("CourseID is null");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNotNull() {
            addCriterion("CourseID is not null");
            return (Criteria) this;
        }

        public Criteria andCourseidEqualTo(Integer value) {
            addCriterion("CourseID =", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotEqualTo(Integer value) {
            addCriterion("CourseID <>", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThan(Integer value) {
            addCriterion("CourseID >", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CourseID >=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThan(Integer value) {
            addCriterion("CourseID <", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThanOrEqualTo(Integer value) {
            addCriterion("CourseID <=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidIn(List<Integer> values) {
            addCriterion("CourseID in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotIn(List<Integer> values) {
            addCriterion("CourseID not in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidBetween(Integer value1, Integer value2) {
            addCriterion("CourseID between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotBetween(Integer value1, Integer value2) {
            addCriterion("CourseID not between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andSituationIsNull() {
            addCriterion("Situation is null");
            return (Criteria) this;
        }

        public Criteria andSituationIsNotNull() {
            addCriterion("Situation is not null");
            return (Criteria) this;
        }

        public Criteria andSituationEqualTo(String value) {
            addCriterion("Situation =", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotEqualTo(String value) {
            addCriterion("Situation <>", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationGreaterThan(String value) {
            addCriterion("Situation >", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationGreaterThanOrEqualTo(String value) {
            addCriterion("Situation >=", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationLessThan(String value) {
            addCriterion("Situation <", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationLessThanOrEqualTo(String value) {
            addCriterion("Situation <=", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationLike(String value) {
            addCriterion("Situation like", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotLike(String value) {
            addCriterion("Situation not like", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationIn(List<String> values) {
            addCriterion("Situation in", values, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotIn(List<String> values) {
            addCriterion("Situation not in", values, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationBetween(String value1, String value2) {
            addCriterion("Situation between", value1, value2, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotBetween(String value1, String value2) {
            addCriterion("Situation not between", value1, value2, "situation");
            return (Criteria) this;
        }

        public Criteria andAttendancetimeIsNull() {
            addCriterion("AttendanceTime is null");
            return (Criteria) this;
        }

        public Criteria andAttendancetimeIsNotNull() {
            addCriterion("AttendanceTime is not null");
            return (Criteria) this;
        }

        public Criteria andAttendancetimeEqualTo(Date value) {
            addCriterion("AttendanceTime =", value, "attendancetime");
            return (Criteria) this;
        }

        public Criteria andAttendancetimeNotEqualTo(Date value) {
            addCriterion("AttendanceTime <>", value, "attendancetime");
            return (Criteria) this;
        }

        public Criteria andAttendancetimeGreaterThan(Date value) {
            addCriterion("AttendanceTime >", value, "attendancetime");
            return (Criteria) this;
        }

        public Criteria andAttendancetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AttendanceTime >=", value, "attendancetime");
            return (Criteria) this;
        }

        public Criteria andAttendancetimeLessThan(Date value) {
            addCriterion("AttendanceTime <", value, "attendancetime");
            return (Criteria) this;
        }

        public Criteria andAttendancetimeLessThanOrEqualTo(Date value) {
            addCriterion("AttendanceTime <=", value, "attendancetime");
            return (Criteria) this;
        }

        public Criteria andAttendancetimeIn(List<Date> values) {
            addCriterion("AttendanceTime in", values, "attendancetime");
            return (Criteria) this;
        }

        public Criteria andAttendancetimeNotIn(List<Date> values) {
            addCriterion("AttendanceTime not in", values, "attendancetime");
            return (Criteria) this;
        }

        public Criteria andAttendancetimeBetween(Date value1, Date value2) {
            addCriterion("AttendanceTime between", value1, value2, "attendancetime");
            return (Criteria) this;
        }

        public Criteria andAttendancetimeNotBetween(Date value1, Date value2) {
            addCriterion("AttendanceTime not between", value1, value2, "attendancetime");
            return (Criteria) this;
        }

        public Criteria andAttendancedescIsNull() {
            addCriterion("AttendanceDesc is null");
            return (Criteria) this;
        }

        public Criteria andAttendancedescIsNotNull() {
            addCriterion("AttendanceDesc is not null");
            return (Criteria) this;
        }

        public Criteria andAttendancedescEqualTo(String value) {
            addCriterion("AttendanceDesc =", value, "attendancedesc");
            return (Criteria) this;
        }

        public Criteria andAttendancedescNotEqualTo(String value) {
            addCriterion("AttendanceDesc <>", value, "attendancedesc");
            return (Criteria) this;
        }

        public Criteria andAttendancedescGreaterThan(String value) {
            addCriterion("AttendanceDesc >", value, "attendancedesc");
            return (Criteria) this;
        }

        public Criteria andAttendancedescGreaterThanOrEqualTo(String value) {
            addCriterion("AttendanceDesc >=", value, "attendancedesc");
            return (Criteria) this;
        }

        public Criteria andAttendancedescLessThan(String value) {
            addCriterion("AttendanceDesc <", value, "attendancedesc");
            return (Criteria) this;
        }

        public Criteria andAttendancedescLessThanOrEqualTo(String value) {
            addCriterion("AttendanceDesc <=", value, "attendancedesc");
            return (Criteria) this;
        }

        public Criteria andAttendancedescLike(String value) {
            addCriterion("AttendanceDesc like", value, "attendancedesc");
            return (Criteria) this;
        }

        public Criteria andAttendancedescNotLike(String value) {
            addCriterion("AttendanceDesc not like", value, "attendancedesc");
            return (Criteria) this;
        }

        public Criteria andAttendancedescIn(List<String> values) {
            addCriterion("AttendanceDesc in", values, "attendancedesc");
            return (Criteria) this;
        }

        public Criteria andAttendancedescNotIn(List<String> values) {
            addCriterion("AttendanceDesc not in", values, "attendancedesc");
            return (Criteria) this;
        }

        public Criteria andAttendancedescBetween(String value1, String value2) {
            addCriterion("AttendanceDesc between", value1, value2, "attendancedesc");
            return (Criteria) this;
        }

        public Criteria andAttendancedescNotBetween(String value1, String value2) {
            addCriterion("AttendanceDesc not between", value1, value2, "attendancedesc");
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