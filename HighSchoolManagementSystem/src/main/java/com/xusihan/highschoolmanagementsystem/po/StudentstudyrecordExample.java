package com.xusihan.highschoolmanagementsystem.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentstudyrecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentstudyrecordExample() {
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

        public Criteria andStudyrecordidIsNull() {
            addCriterion("StudyRecordID is null");
            return (Criteria) this;
        }

        public Criteria andStudyrecordidIsNotNull() {
            addCriterion("StudyRecordID is not null");
            return (Criteria) this;
        }

        public Criteria andStudyrecordidEqualTo(Integer value) {
            addCriterion("StudyRecordID =", value, "studyrecordid");
            return (Criteria) this;
        }

        public Criteria andStudyrecordidNotEqualTo(Integer value) {
            addCriterion("StudyRecordID <>", value, "studyrecordid");
            return (Criteria) this;
        }

        public Criteria andStudyrecordidGreaterThan(Integer value) {
            addCriterion("StudyRecordID >", value, "studyrecordid");
            return (Criteria) this;
        }

        public Criteria andStudyrecordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("StudyRecordID >=", value, "studyrecordid");
            return (Criteria) this;
        }

        public Criteria andStudyrecordidLessThan(Integer value) {
            addCriterion("StudyRecordID <", value, "studyrecordid");
            return (Criteria) this;
        }

        public Criteria andStudyrecordidLessThanOrEqualTo(Integer value) {
            addCriterion("StudyRecordID <=", value, "studyrecordid");
            return (Criteria) this;
        }

        public Criteria andStudyrecordidIn(List<Integer> values) {
            addCriterion("StudyRecordID in", values, "studyrecordid");
            return (Criteria) this;
        }

        public Criteria andStudyrecordidNotIn(List<Integer> values) {
            addCriterion("StudyRecordID not in", values, "studyrecordid");
            return (Criteria) this;
        }

        public Criteria andStudyrecordidBetween(Integer value1, Integer value2) {
            addCriterion("StudyRecordID between", value1, value2, "studyrecordid");
            return (Criteria) this;
        }

        public Criteria andStudyrecordidNotBetween(Integer value1, Integer value2) {
            addCriterion("StudyRecordID not between", value1, value2, "studyrecordid");
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

        public Criteria andComputerlevelIsNull() {
            addCriterion("ComputerLevel is null");
            return (Criteria) this;
        }

        public Criteria andComputerlevelIsNotNull() {
            addCriterion("ComputerLevel is not null");
            return (Criteria) this;
        }

        public Criteria andComputerlevelEqualTo(String value) {
            addCriterion("ComputerLevel =", value, "computerlevel");
            return (Criteria) this;
        }

        public Criteria andComputerlevelNotEqualTo(String value) {
            addCriterion("ComputerLevel <>", value, "computerlevel");
            return (Criteria) this;
        }

        public Criteria andComputerlevelGreaterThan(String value) {
            addCriterion("ComputerLevel >", value, "computerlevel");
            return (Criteria) this;
        }

        public Criteria andComputerlevelGreaterThanOrEqualTo(String value) {
            addCriterion("ComputerLevel >=", value, "computerlevel");
            return (Criteria) this;
        }

        public Criteria andComputerlevelLessThan(String value) {
            addCriterion("ComputerLevel <", value, "computerlevel");
            return (Criteria) this;
        }

        public Criteria andComputerlevelLessThanOrEqualTo(String value) {
            addCriterion("ComputerLevel <=", value, "computerlevel");
            return (Criteria) this;
        }

        public Criteria andComputerlevelLike(String value) {
            addCriterion("ComputerLevel like", value, "computerlevel");
            return (Criteria) this;
        }

        public Criteria andComputerlevelNotLike(String value) {
            addCriterion("ComputerLevel not like", value, "computerlevel");
            return (Criteria) this;
        }

        public Criteria andComputerlevelIn(List<String> values) {
            addCriterion("ComputerLevel in", values, "computerlevel");
            return (Criteria) this;
        }

        public Criteria andComputerlevelNotIn(List<String> values) {
            addCriterion("ComputerLevel not in", values, "computerlevel");
            return (Criteria) this;
        }

        public Criteria andComputerlevelBetween(String value1, String value2) {
            addCriterion("ComputerLevel between", value1, value2, "computerlevel");
            return (Criteria) this;
        }

        public Criteria andComputerlevelNotBetween(String value1, String value2) {
            addCriterion("ComputerLevel not between", value1, value2, "computerlevel");
            return (Criteria) this;
        }

        public Criteria andEnglishlevelIsNull() {
            addCriterion("EnglishLevel is null");
            return (Criteria) this;
        }

        public Criteria andEnglishlevelIsNotNull() {
            addCriterion("EnglishLevel is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishlevelEqualTo(String value) {
            addCriterion("EnglishLevel =", value, "englishlevel");
            return (Criteria) this;
        }

        public Criteria andEnglishlevelNotEqualTo(String value) {
            addCriterion("EnglishLevel <>", value, "englishlevel");
            return (Criteria) this;
        }

        public Criteria andEnglishlevelGreaterThan(String value) {
            addCriterion("EnglishLevel >", value, "englishlevel");
            return (Criteria) this;
        }

        public Criteria andEnglishlevelGreaterThanOrEqualTo(String value) {
            addCriterion("EnglishLevel >=", value, "englishlevel");
            return (Criteria) this;
        }

        public Criteria andEnglishlevelLessThan(String value) {
            addCriterion("EnglishLevel <", value, "englishlevel");
            return (Criteria) this;
        }

        public Criteria andEnglishlevelLessThanOrEqualTo(String value) {
            addCriterion("EnglishLevel <=", value, "englishlevel");
            return (Criteria) this;
        }

        public Criteria andEnglishlevelLike(String value) {
            addCriterion("EnglishLevel like", value, "englishlevel");
            return (Criteria) this;
        }

        public Criteria andEnglishlevelNotLike(String value) {
            addCriterion("EnglishLevel not like", value, "englishlevel");
            return (Criteria) this;
        }

        public Criteria andEnglishlevelIn(List<String> values) {
            addCriterion("EnglishLevel in", values, "englishlevel");
            return (Criteria) this;
        }

        public Criteria andEnglishlevelNotIn(List<String> values) {
            addCriterion("EnglishLevel not in", values, "englishlevel");
            return (Criteria) this;
        }

        public Criteria andEnglishlevelBetween(String value1, String value2) {
            addCriterion("EnglishLevel between", value1, value2, "englishlevel");
            return (Criteria) this;
        }

        public Criteria andEnglishlevelNotBetween(String value1, String value2) {
            addCriterion("EnglishLevel not between", value1, value2, "englishlevel");
            return (Criteria) this;
        }

        public Criteria andGraduateschoolIsNull() {
            addCriterion("GraduateSchool is null");
            return (Criteria) this;
        }

        public Criteria andGraduateschoolIsNotNull() {
            addCriterion("GraduateSchool is not null");
            return (Criteria) this;
        }

        public Criteria andGraduateschoolEqualTo(String value) {
            addCriterion("GraduateSchool =", value, "graduateschool");
            return (Criteria) this;
        }

        public Criteria andGraduateschoolNotEqualTo(String value) {
            addCriterion("GraduateSchool <>", value, "graduateschool");
            return (Criteria) this;
        }

        public Criteria andGraduateschoolGreaterThan(String value) {
            addCriterion("GraduateSchool >", value, "graduateschool");
            return (Criteria) this;
        }

        public Criteria andGraduateschoolGreaterThanOrEqualTo(String value) {
            addCriterion("GraduateSchool >=", value, "graduateschool");
            return (Criteria) this;
        }

        public Criteria andGraduateschoolLessThan(String value) {
            addCriterion("GraduateSchool <", value, "graduateschool");
            return (Criteria) this;
        }

        public Criteria andGraduateschoolLessThanOrEqualTo(String value) {
            addCriterion("GraduateSchool <=", value, "graduateschool");
            return (Criteria) this;
        }

        public Criteria andGraduateschoolLike(String value) {
            addCriterion("GraduateSchool like", value, "graduateschool");
            return (Criteria) this;
        }

        public Criteria andGraduateschoolNotLike(String value) {
            addCriterion("GraduateSchool not like", value, "graduateschool");
            return (Criteria) this;
        }

        public Criteria andGraduateschoolIn(List<String> values) {
            addCriterion("GraduateSchool in", values, "graduateschool");
            return (Criteria) this;
        }

        public Criteria andGraduateschoolNotIn(List<String> values) {
            addCriterion("GraduateSchool not in", values, "graduateschool");
            return (Criteria) this;
        }

        public Criteria andGraduateschoolBetween(String value1, String value2) {
            addCriterion("GraduateSchool between", value1, value2, "graduateschool");
            return (Criteria) this;
        }

        public Criteria andGraduateschoolNotBetween(String value1, String value2) {
            addCriterion("GraduateSchool not between", value1, value2, "graduateschool");
            return (Criteria) this;
        }

        public Criteria andGradutetimeIsNull() {
            addCriterion("GraduteTime is null");
            return (Criteria) this;
        }

        public Criteria andGradutetimeIsNotNull() {
            addCriterion("GraduteTime is not null");
            return (Criteria) this;
        }

        public Criteria andGradutetimeEqualTo(Date value) {
            addCriterion("GraduteTime =", value, "gradutetime");
            return (Criteria) this;
        }

        public Criteria andGradutetimeNotEqualTo(Date value) {
            addCriterion("GraduteTime <>", value, "gradutetime");
            return (Criteria) this;
        }

        public Criteria andGradutetimeGreaterThan(Date value) {
            addCriterion("GraduteTime >", value, "gradutetime");
            return (Criteria) this;
        }

        public Criteria andGradutetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("GraduteTime >=", value, "gradutetime");
            return (Criteria) this;
        }

        public Criteria andGradutetimeLessThan(Date value) {
            addCriterion("GraduteTime <", value, "gradutetime");
            return (Criteria) this;
        }

        public Criteria andGradutetimeLessThanOrEqualTo(Date value) {
            addCriterion("GraduteTime <=", value, "gradutetime");
            return (Criteria) this;
        }

        public Criteria andGradutetimeIn(List<Date> values) {
            addCriterion("GraduteTime in", values, "gradutetime");
            return (Criteria) this;
        }

        public Criteria andGradutetimeNotIn(List<Date> values) {
            addCriterion("GraduteTime not in", values, "gradutetime");
            return (Criteria) this;
        }

        public Criteria andGradutetimeBetween(Date value1, Date value2) {
            addCriterion("GraduteTime between", value1, value2, "gradutetime");
            return (Criteria) this;
        }

        public Criteria andGradutetimeNotBetween(Date value1, Date value2) {
            addCriterion("GraduteTime not between", value1, value2, "gradutetime");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNull() {
            addCriterion("Certificate is null");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNotNull() {
            addCriterion("Certificate is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateEqualTo(String value) {
            addCriterion("Certificate =", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotEqualTo(String value) {
            addCriterion("Certificate <>", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThan(String value) {
            addCriterion("Certificate >", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("Certificate >=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThan(String value) {
            addCriterion("Certificate <", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThanOrEqualTo(String value) {
            addCriterion("Certificate <=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLike(String value) {
            addCriterion("Certificate like", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotLike(String value) {
            addCriterion("Certificate not like", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateIn(List<String> values) {
            addCriterion("Certificate in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotIn(List<String> values) {
            addCriterion("Certificate not in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateBetween(String value1, String value2) {
            addCriterion("Certificate between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotBetween(String value1, String value2) {
            addCriterion("Certificate not between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andJobcompanyIsNull() {
            addCriterion("JobCompany is null");
            return (Criteria) this;
        }

        public Criteria andJobcompanyIsNotNull() {
            addCriterion("JobCompany is not null");
            return (Criteria) this;
        }

        public Criteria andJobcompanyEqualTo(String value) {
            addCriterion("JobCompany =", value, "jobcompany");
            return (Criteria) this;
        }

        public Criteria andJobcompanyNotEqualTo(String value) {
            addCriterion("JobCompany <>", value, "jobcompany");
            return (Criteria) this;
        }

        public Criteria andJobcompanyGreaterThan(String value) {
            addCriterion("JobCompany >", value, "jobcompany");
            return (Criteria) this;
        }

        public Criteria andJobcompanyGreaterThanOrEqualTo(String value) {
            addCriterion("JobCompany >=", value, "jobcompany");
            return (Criteria) this;
        }

        public Criteria andJobcompanyLessThan(String value) {
            addCriterion("JobCompany <", value, "jobcompany");
            return (Criteria) this;
        }

        public Criteria andJobcompanyLessThanOrEqualTo(String value) {
            addCriterion("JobCompany <=", value, "jobcompany");
            return (Criteria) this;
        }

        public Criteria andJobcompanyLike(String value) {
            addCriterion("JobCompany like", value, "jobcompany");
            return (Criteria) this;
        }

        public Criteria andJobcompanyNotLike(String value) {
            addCriterion("JobCompany not like", value, "jobcompany");
            return (Criteria) this;
        }

        public Criteria andJobcompanyIn(List<String> values) {
            addCriterion("JobCompany in", values, "jobcompany");
            return (Criteria) this;
        }

        public Criteria andJobcompanyNotIn(List<String> values) {
            addCriterion("JobCompany not in", values, "jobcompany");
            return (Criteria) this;
        }

        public Criteria andJobcompanyBetween(String value1, String value2) {
            addCriterion("JobCompany between", value1, value2, "jobcompany");
            return (Criteria) this;
        }

        public Criteria andJobcompanyNotBetween(String value1, String value2) {
            addCriterion("JobCompany not between", value1, value2, "jobcompany");
            return (Criteria) this;
        }

        public Criteria andJobcourseIsNull() {
            addCriterion("JobCourse is null");
            return (Criteria) this;
        }

        public Criteria andJobcourseIsNotNull() {
            addCriterion("JobCourse is not null");
            return (Criteria) this;
        }

        public Criteria andJobcourseEqualTo(String value) {
            addCriterion("JobCourse =", value, "jobcourse");
            return (Criteria) this;
        }

        public Criteria andJobcourseNotEqualTo(String value) {
            addCriterion("JobCourse <>", value, "jobcourse");
            return (Criteria) this;
        }

        public Criteria andJobcourseGreaterThan(String value) {
            addCriterion("JobCourse >", value, "jobcourse");
            return (Criteria) this;
        }

        public Criteria andJobcourseGreaterThanOrEqualTo(String value) {
            addCriterion("JobCourse >=", value, "jobcourse");
            return (Criteria) this;
        }

        public Criteria andJobcourseLessThan(String value) {
            addCriterion("JobCourse <", value, "jobcourse");
            return (Criteria) this;
        }

        public Criteria andJobcourseLessThanOrEqualTo(String value) {
            addCriterion("JobCourse <=", value, "jobcourse");
            return (Criteria) this;
        }

        public Criteria andJobcourseLike(String value) {
            addCriterion("JobCourse like", value, "jobcourse");
            return (Criteria) this;
        }

        public Criteria andJobcourseNotLike(String value) {
            addCriterion("JobCourse not like", value, "jobcourse");
            return (Criteria) this;
        }

        public Criteria andJobcourseIn(List<String> values) {
            addCriterion("JobCourse in", values, "jobcourse");
            return (Criteria) this;
        }

        public Criteria andJobcourseNotIn(List<String> values) {
            addCriterion("JobCourse not in", values, "jobcourse");
            return (Criteria) this;
        }

        public Criteria andJobcourseBetween(String value1, String value2) {
            addCriterion("JobCourse between", value1, value2, "jobcourse");
            return (Criteria) this;
        }

        public Criteria andJobcourseNotBetween(String value1, String value2) {
            addCriterion("JobCourse not between", value1, value2, "jobcourse");
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