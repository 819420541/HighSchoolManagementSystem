package com.xusihan.highschoolmanagementsystem.po;

import java.util.ArrayList;
import java.util.List;

public class ProjectsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectsExample() {
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

        public Criteria andProjectidIsNull() {
            addCriterion("ProjectID is null");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNotNull() {
            addCriterion("ProjectID is not null");
            return (Criteria) this;
        }

        public Criteria andProjectidEqualTo(Integer value) {
            addCriterion("ProjectID =", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotEqualTo(Integer value) {
            addCriterion("ProjectID <>", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThan(Integer value) {
            addCriterion("ProjectID >", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ProjectID >=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThan(Integer value) {
            addCriterion("ProjectID <", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThanOrEqualTo(Integer value) {
            addCriterion("ProjectID <=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidIn(List<Integer> values) {
            addCriterion("ProjectID in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotIn(List<Integer> values) {
            addCriterion("ProjectID not in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidBetween(Integer value1, Integer value2) {
            addCriterion("ProjectID between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotBetween(Integer value1, Integer value2) {
            addCriterion("ProjectID not between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectnameIsNull() {
            addCriterion("ProjectName is null");
            return (Criteria) this;
        }

        public Criteria andProjectnameIsNotNull() {
            addCriterion("ProjectName is not null");
            return (Criteria) this;
        }

        public Criteria andProjectnameEqualTo(String value) {
            addCriterion("ProjectName =", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotEqualTo(String value) {
            addCriterion("ProjectName <>", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThan(String value) {
            addCriterion("ProjectName >", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThanOrEqualTo(String value) {
            addCriterion("ProjectName >=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThan(String value) {
            addCriterion("ProjectName <", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThanOrEqualTo(String value) {
            addCriterion("ProjectName <=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLike(String value) {
            addCriterion("ProjectName like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotLike(String value) {
            addCriterion("ProjectName not like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameIn(List<String> values) {
            addCriterion("ProjectName in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotIn(List<String> values) {
            addCriterion("ProjectName not in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameBetween(String value1, String value2) {
            addCriterion("ProjectName between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotBetween(String value1, String value2) {
            addCriterion("ProjectName not between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectperiodIsNull() {
            addCriterion("ProjectPeriod is null");
            return (Criteria) this;
        }

        public Criteria andProjectperiodIsNotNull() {
            addCriterion("ProjectPeriod is not null");
            return (Criteria) this;
        }

        public Criteria andProjectperiodEqualTo(Integer value) {
            addCriterion("ProjectPeriod =", value, "projectperiod");
            return (Criteria) this;
        }

        public Criteria andProjectperiodNotEqualTo(Integer value) {
            addCriterion("ProjectPeriod <>", value, "projectperiod");
            return (Criteria) this;
        }

        public Criteria andProjectperiodGreaterThan(Integer value) {
            addCriterion("ProjectPeriod >", value, "projectperiod");
            return (Criteria) this;
        }

        public Criteria andProjectperiodGreaterThanOrEqualTo(Integer value) {
            addCriterion("ProjectPeriod >=", value, "projectperiod");
            return (Criteria) this;
        }

        public Criteria andProjectperiodLessThan(Integer value) {
            addCriterion("ProjectPeriod <", value, "projectperiod");
            return (Criteria) this;
        }

        public Criteria andProjectperiodLessThanOrEqualTo(Integer value) {
            addCriterion("ProjectPeriod <=", value, "projectperiod");
            return (Criteria) this;
        }

        public Criteria andProjectperiodIn(List<Integer> values) {
            addCriterion("ProjectPeriod in", values, "projectperiod");
            return (Criteria) this;
        }

        public Criteria andProjectperiodNotIn(List<Integer> values) {
            addCriterion("ProjectPeriod not in", values, "projectperiod");
            return (Criteria) this;
        }

        public Criteria andProjectperiodBetween(Integer value1, Integer value2) {
            addCriterion("ProjectPeriod between", value1, value2, "projectperiod");
            return (Criteria) this;
        }

        public Criteria andProjectperiodNotBetween(Integer value1, Integer value2) {
            addCriterion("ProjectPeriod not between", value1, value2, "projectperiod");
            return (Criteria) this;
        }

        public Criteria andCodemeasureIsNull() {
            addCriterion("CodeMeasure is null");
            return (Criteria) this;
        }

        public Criteria andCodemeasureIsNotNull() {
            addCriterion("CodeMeasure is not null");
            return (Criteria) this;
        }

        public Criteria andCodemeasureEqualTo(Integer value) {
            addCriterion("CodeMeasure =", value, "codemeasure");
            return (Criteria) this;
        }

        public Criteria andCodemeasureNotEqualTo(Integer value) {
            addCriterion("CodeMeasure <>", value, "codemeasure");
            return (Criteria) this;
        }

        public Criteria andCodemeasureGreaterThan(Integer value) {
            addCriterion("CodeMeasure >", value, "codemeasure");
            return (Criteria) this;
        }

        public Criteria andCodemeasureGreaterThanOrEqualTo(Integer value) {
            addCriterion("CodeMeasure >=", value, "codemeasure");
            return (Criteria) this;
        }

        public Criteria andCodemeasureLessThan(Integer value) {
            addCriterion("CodeMeasure <", value, "codemeasure");
            return (Criteria) this;
        }

        public Criteria andCodemeasureLessThanOrEqualTo(Integer value) {
            addCriterion("CodeMeasure <=", value, "codemeasure");
            return (Criteria) this;
        }

        public Criteria andCodemeasureIn(List<Integer> values) {
            addCriterion("CodeMeasure in", values, "codemeasure");
            return (Criteria) this;
        }

        public Criteria andCodemeasureNotIn(List<Integer> values) {
            addCriterion("CodeMeasure not in", values, "codemeasure");
            return (Criteria) this;
        }

        public Criteria andCodemeasureBetween(Integer value1, Integer value2) {
            addCriterion("CodeMeasure between", value1, value2, "codemeasure");
            return (Criteria) this;
        }

        public Criteria andCodemeasureNotBetween(Integer value1, Integer value2) {
            addCriterion("CodeMeasure not between", value1, value2, "codemeasure");
            return (Criteria) this;
        }

        public Criteria andProjectlevelIsNull() {
            addCriterion("ProjectLevel is null");
            return (Criteria) this;
        }

        public Criteria andProjectlevelIsNotNull() {
            addCriterion("ProjectLevel is not null");
            return (Criteria) this;
        }

        public Criteria andProjectlevelEqualTo(String value) {
            addCriterion("ProjectLevel =", value, "projectlevel");
            return (Criteria) this;
        }

        public Criteria andProjectlevelNotEqualTo(String value) {
            addCriterion("ProjectLevel <>", value, "projectlevel");
            return (Criteria) this;
        }

        public Criteria andProjectlevelGreaterThan(String value) {
            addCriterion("ProjectLevel >", value, "projectlevel");
            return (Criteria) this;
        }

        public Criteria andProjectlevelGreaterThanOrEqualTo(String value) {
            addCriterion("ProjectLevel >=", value, "projectlevel");
            return (Criteria) this;
        }

        public Criteria andProjectlevelLessThan(String value) {
            addCriterion("ProjectLevel <", value, "projectlevel");
            return (Criteria) this;
        }

        public Criteria andProjectlevelLessThanOrEqualTo(String value) {
            addCriterion("ProjectLevel <=", value, "projectlevel");
            return (Criteria) this;
        }

        public Criteria andProjectlevelLike(String value) {
            addCriterion("ProjectLevel like", value, "projectlevel");
            return (Criteria) this;
        }

        public Criteria andProjectlevelNotLike(String value) {
            addCriterion("ProjectLevel not like", value, "projectlevel");
            return (Criteria) this;
        }

        public Criteria andProjectlevelIn(List<String> values) {
            addCriterion("ProjectLevel in", values, "projectlevel");
            return (Criteria) this;
        }

        public Criteria andProjectlevelNotIn(List<String> values) {
            addCriterion("ProjectLevel not in", values, "projectlevel");
            return (Criteria) this;
        }

        public Criteria andProjectlevelBetween(String value1, String value2) {
            addCriterion("ProjectLevel between", value1, value2, "projectlevel");
            return (Criteria) this;
        }

        public Criteria andProjectlevelNotBetween(String value1, String value2) {
            addCriterion("ProjectLevel not between", value1, value2, "projectlevel");
            return (Criteria) this;
        }

        public Criteria andProjectdescIsNull() {
            addCriterion("ProjectDesc is null");
            return (Criteria) this;
        }

        public Criteria andProjectdescIsNotNull() {
            addCriterion("ProjectDesc is not null");
            return (Criteria) this;
        }

        public Criteria andProjectdescEqualTo(String value) {
            addCriterion("ProjectDesc =", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescNotEqualTo(String value) {
            addCriterion("ProjectDesc <>", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescGreaterThan(String value) {
            addCriterion("ProjectDesc >", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescGreaterThanOrEqualTo(String value) {
            addCriterion("ProjectDesc >=", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescLessThan(String value) {
            addCriterion("ProjectDesc <", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescLessThanOrEqualTo(String value) {
            addCriterion("ProjectDesc <=", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescLike(String value) {
            addCriterion("ProjectDesc like", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescNotLike(String value) {
            addCriterion("ProjectDesc not like", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescIn(List<String> values) {
            addCriterion("ProjectDesc in", values, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescNotIn(List<String> values) {
            addCriterion("ProjectDesc not in", values, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescBetween(String value1, String value2) {
            addCriterion("ProjectDesc between", value1, value2, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescNotBetween(String value1, String value2) {
            addCriterion("ProjectDesc not between", value1, value2, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNull() {
            addCriterion("Difficulty is null");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNotNull() {
            addCriterion("Difficulty is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultyEqualTo(String value) {
            addCriterion("Difficulty =", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotEqualTo(String value) {
            addCriterion("Difficulty <>", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThan(String value) {
            addCriterion("Difficulty >", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThanOrEqualTo(String value) {
            addCriterion("Difficulty >=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThan(String value) {
            addCriterion("Difficulty <", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThanOrEqualTo(String value) {
            addCriterion("Difficulty <=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLike(String value) {
            addCriterion("Difficulty like", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotLike(String value) {
            addCriterion("Difficulty not like", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyIn(List<String> values) {
            addCriterion("Difficulty in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotIn(List<String> values) {
            addCriterion("Difficulty not in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyBetween(String value1, String value2) {
            addCriterion("Difficulty between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotBetween(String value1, String value2) {
            addCriterion("Difficulty not between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andTargetIsNull() {
            addCriterion("Target is null");
            return (Criteria) this;
        }

        public Criteria andTargetIsNotNull() {
            addCriterion("Target is not null");
            return (Criteria) this;
        }

        public Criteria andTargetEqualTo(String value) {
            addCriterion("Target =", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotEqualTo(String value) {
            addCriterion("Target <>", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThan(String value) {
            addCriterion("Target >", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThanOrEqualTo(String value) {
            addCriterion("Target >=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThan(String value) {
            addCriterion("Target <", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThanOrEqualTo(String value) {
            addCriterion("Target <=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLike(String value) {
            addCriterion("Target like", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotLike(String value) {
            addCriterion("Target not like", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetIn(List<String> values) {
            addCriterion("Target in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotIn(List<String> values) {
            addCriterion("Target not in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetBetween(String value1, String value2) {
            addCriterion("Target between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotBetween(String value1, String value2) {
            addCriterion("Target not between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTechniqueIsNull() {
            addCriterion("Technique is null");
            return (Criteria) this;
        }

        public Criteria andTechniqueIsNotNull() {
            addCriterion("Technique is not null");
            return (Criteria) this;
        }

        public Criteria andTechniqueEqualTo(String value) {
            addCriterion("Technique =", value, "technique");
            return (Criteria) this;
        }

        public Criteria andTechniqueNotEqualTo(String value) {
            addCriterion("Technique <>", value, "technique");
            return (Criteria) this;
        }

        public Criteria andTechniqueGreaterThan(String value) {
            addCriterion("Technique >", value, "technique");
            return (Criteria) this;
        }

        public Criteria andTechniqueGreaterThanOrEqualTo(String value) {
            addCriterion("Technique >=", value, "technique");
            return (Criteria) this;
        }

        public Criteria andTechniqueLessThan(String value) {
            addCriterion("Technique <", value, "technique");
            return (Criteria) this;
        }

        public Criteria andTechniqueLessThanOrEqualTo(String value) {
            addCriterion("Technique <=", value, "technique");
            return (Criteria) this;
        }

        public Criteria andTechniqueLike(String value) {
            addCriterion("Technique like", value, "technique");
            return (Criteria) this;
        }

        public Criteria andTechniqueNotLike(String value) {
            addCriterion("Technique not like", value, "technique");
            return (Criteria) this;
        }

        public Criteria andTechniqueIn(List<String> values) {
            addCriterion("Technique in", values, "technique");
            return (Criteria) this;
        }

        public Criteria andTechniqueNotIn(List<String> values) {
            addCriterion("Technique not in", values, "technique");
            return (Criteria) this;
        }

        public Criteria andTechniqueBetween(String value1, String value2) {
            addCriterion("Technique between", value1, value2, "technique");
            return (Criteria) this;
        }

        public Criteria andTechniqueNotBetween(String value1, String value2) {
            addCriterion("Technique not between", value1, value2, "technique");
            return (Criteria) this;
        }

        public Criteria andProjectdatabaseIsNull() {
            addCriterion("ProjectDataBase is null");
            return (Criteria) this;
        }

        public Criteria andProjectdatabaseIsNotNull() {
            addCriterion("ProjectDataBase is not null");
            return (Criteria) this;
        }

        public Criteria andProjectdatabaseEqualTo(String value) {
            addCriterion("ProjectDataBase =", value, "projectdatabase");
            return (Criteria) this;
        }

        public Criteria andProjectdatabaseNotEqualTo(String value) {
            addCriterion("ProjectDataBase <>", value, "projectdatabase");
            return (Criteria) this;
        }

        public Criteria andProjectdatabaseGreaterThan(String value) {
            addCriterion("ProjectDataBase >", value, "projectdatabase");
            return (Criteria) this;
        }

        public Criteria andProjectdatabaseGreaterThanOrEqualTo(String value) {
            addCriterion("ProjectDataBase >=", value, "projectdatabase");
            return (Criteria) this;
        }

        public Criteria andProjectdatabaseLessThan(String value) {
            addCriterion("ProjectDataBase <", value, "projectdatabase");
            return (Criteria) this;
        }

        public Criteria andProjectdatabaseLessThanOrEqualTo(String value) {
            addCriterion("ProjectDataBase <=", value, "projectdatabase");
            return (Criteria) this;
        }

        public Criteria andProjectdatabaseLike(String value) {
            addCriterion("ProjectDataBase like", value, "projectdatabase");
            return (Criteria) this;
        }

        public Criteria andProjectdatabaseNotLike(String value) {
            addCriterion("ProjectDataBase not like", value, "projectdatabase");
            return (Criteria) this;
        }

        public Criteria andProjectdatabaseIn(List<String> values) {
            addCriterion("ProjectDataBase in", values, "projectdatabase");
            return (Criteria) this;
        }

        public Criteria andProjectdatabaseNotIn(List<String> values) {
            addCriterion("ProjectDataBase not in", values, "projectdatabase");
            return (Criteria) this;
        }

        public Criteria andProjectdatabaseBetween(String value1, String value2) {
            addCriterion("ProjectDataBase between", value1, value2, "projectdatabase");
            return (Criteria) this;
        }

        public Criteria andProjectdatabaseNotBetween(String value1, String value2) {
            addCriterion("ProjectDataBase not between", value1, value2, "projectdatabase");
            return (Criteria) this;
        }

        public Criteria andConditionsIsNull() {
            addCriterion("Conditions is null");
            return (Criteria) this;
        }

        public Criteria andConditionsIsNotNull() {
            addCriterion("Conditions is not null");
            return (Criteria) this;
        }

        public Criteria andConditionsEqualTo(String value) {
            addCriterion("Conditions =", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotEqualTo(String value) {
            addCriterion("Conditions <>", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsGreaterThan(String value) {
            addCriterion("Conditions >", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsGreaterThanOrEqualTo(String value) {
            addCriterion("Conditions >=", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsLessThan(String value) {
            addCriterion("Conditions <", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsLessThanOrEqualTo(String value) {
            addCriterion("Conditions <=", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsLike(String value) {
            addCriterion("Conditions like", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotLike(String value) {
            addCriterion("Conditions not like", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsIn(List<String> values) {
            addCriterion("Conditions in", values, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotIn(List<String> values) {
            addCriterion("Conditions not in", values, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsBetween(String value1, String value2) {
            addCriterion("Conditions between", value1, value2, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotBetween(String value1, String value2) {
            addCriterion("Conditions not between", value1, value2, "conditions");
            return (Criteria) this;
        }

        public Criteria andFeaturesIsNull() {
            addCriterion("Features is null");
            return (Criteria) this;
        }

        public Criteria andFeaturesIsNotNull() {
            addCriterion("Features is not null");
            return (Criteria) this;
        }

        public Criteria andFeaturesEqualTo(String value) {
            addCriterion("Features =", value, "features");
            return (Criteria) this;
        }

        public Criteria andFeaturesNotEqualTo(String value) {
            addCriterion("Features <>", value, "features");
            return (Criteria) this;
        }

        public Criteria andFeaturesGreaterThan(String value) {
            addCriterion("Features >", value, "features");
            return (Criteria) this;
        }

        public Criteria andFeaturesGreaterThanOrEqualTo(String value) {
            addCriterion("Features >=", value, "features");
            return (Criteria) this;
        }

        public Criteria andFeaturesLessThan(String value) {
            addCriterion("Features <", value, "features");
            return (Criteria) this;
        }

        public Criteria andFeaturesLessThanOrEqualTo(String value) {
            addCriterion("Features <=", value, "features");
            return (Criteria) this;
        }

        public Criteria andFeaturesLike(String value) {
            addCriterion("Features like", value, "features");
            return (Criteria) this;
        }

        public Criteria andFeaturesNotLike(String value) {
            addCriterion("Features not like", value, "features");
            return (Criteria) this;
        }

        public Criteria andFeaturesIn(List<String> values) {
            addCriterion("Features in", values, "features");
            return (Criteria) this;
        }

        public Criteria andFeaturesNotIn(List<String> values) {
            addCriterion("Features not in", values, "features");
            return (Criteria) this;
        }

        public Criteria andFeaturesBetween(String value1, String value2) {
            addCriterion("Features between", value1, value2, "features");
            return (Criteria) this;
        }

        public Criteria andFeaturesNotBetween(String value1, String value2) {
            addCriterion("Features not between", value1, value2, "features");
            return (Criteria) this;
        }

        public Criteria andSkilldifficultyIsNull() {
            addCriterion("SkillDifficulty is null");
            return (Criteria) this;
        }

        public Criteria andSkilldifficultyIsNotNull() {
            addCriterion("SkillDifficulty is not null");
            return (Criteria) this;
        }

        public Criteria andSkilldifficultyEqualTo(String value) {
            addCriterion("SkillDifficulty =", value, "skilldifficulty");
            return (Criteria) this;
        }

        public Criteria andSkilldifficultyNotEqualTo(String value) {
            addCriterion("SkillDifficulty <>", value, "skilldifficulty");
            return (Criteria) this;
        }

        public Criteria andSkilldifficultyGreaterThan(String value) {
            addCriterion("SkillDifficulty >", value, "skilldifficulty");
            return (Criteria) this;
        }

        public Criteria andSkilldifficultyGreaterThanOrEqualTo(String value) {
            addCriterion("SkillDifficulty >=", value, "skilldifficulty");
            return (Criteria) this;
        }

        public Criteria andSkilldifficultyLessThan(String value) {
            addCriterion("SkillDifficulty <", value, "skilldifficulty");
            return (Criteria) this;
        }

        public Criteria andSkilldifficultyLessThanOrEqualTo(String value) {
            addCriterion("SkillDifficulty <=", value, "skilldifficulty");
            return (Criteria) this;
        }

        public Criteria andSkilldifficultyLike(String value) {
            addCriterion("SkillDifficulty like", value, "skilldifficulty");
            return (Criteria) this;
        }

        public Criteria andSkilldifficultyNotLike(String value) {
            addCriterion("SkillDifficulty not like", value, "skilldifficulty");
            return (Criteria) this;
        }

        public Criteria andSkilldifficultyIn(List<String> values) {
            addCriterion("SkillDifficulty in", values, "skilldifficulty");
            return (Criteria) this;
        }

        public Criteria andSkilldifficultyNotIn(List<String> values) {
            addCriterion("SkillDifficulty not in", values, "skilldifficulty");
            return (Criteria) this;
        }

        public Criteria andSkilldifficultyBetween(String value1, String value2) {
            addCriterion("SkillDifficulty between", value1, value2, "skilldifficulty");
            return (Criteria) this;
        }

        public Criteria andSkilldifficultyNotBetween(String value1, String value2) {
            addCriterion("SkillDifficulty not between", value1, value2, "skilldifficulty");
            return (Criteria) this;
        }

        public Criteria andSkillkeynoteIsNull() {
            addCriterion("SkillKeynote is null");
            return (Criteria) this;
        }

        public Criteria andSkillkeynoteIsNotNull() {
            addCriterion("SkillKeynote is not null");
            return (Criteria) this;
        }

        public Criteria andSkillkeynoteEqualTo(String value) {
            addCriterion("SkillKeynote =", value, "skillkeynote");
            return (Criteria) this;
        }

        public Criteria andSkillkeynoteNotEqualTo(String value) {
            addCriterion("SkillKeynote <>", value, "skillkeynote");
            return (Criteria) this;
        }

        public Criteria andSkillkeynoteGreaterThan(String value) {
            addCriterion("SkillKeynote >", value, "skillkeynote");
            return (Criteria) this;
        }

        public Criteria andSkillkeynoteGreaterThanOrEqualTo(String value) {
            addCriterion("SkillKeynote >=", value, "skillkeynote");
            return (Criteria) this;
        }

        public Criteria andSkillkeynoteLessThan(String value) {
            addCriterion("SkillKeynote <", value, "skillkeynote");
            return (Criteria) this;
        }

        public Criteria andSkillkeynoteLessThanOrEqualTo(String value) {
            addCriterion("SkillKeynote <=", value, "skillkeynote");
            return (Criteria) this;
        }

        public Criteria andSkillkeynoteLike(String value) {
            addCriterion("SkillKeynote like", value, "skillkeynote");
            return (Criteria) this;
        }

        public Criteria andSkillkeynoteNotLike(String value) {
            addCriterion("SkillKeynote not like", value, "skillkeynote");
            return (Criteria) this;
        }

        public Criteria andSkillkeynoteIn(List<String> values) {
            addCriterion("SkillKeynote in", values, "skillkeynote");
            return (Criteria) this;
        }

        public Criteria andSkillkeynoteNotIn(List<String> values) {
            addCriterion("SkillKeynote not in", values, "skillkeynote");
            return (Criteria) this;
        }

        public Criteria andSkillkeynoteBetween(String value1, String value2) {
            addCriterion("SkillKeynote between", value1, value2, "skillkeynote");
            return (Criteria) this;
        }

        public Criteria andSkillkeynoteNotBetween(String value1, String value2) {
            addCriterion("SkillKeynote not between", value1, value2, "skillkeynote");
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

        public Criteria andProjectstateIsNull() {
            addCriterion("ProjectState is null");
            return (Criteria) this;
        }

        public Criteria andProjectstateIsNotNull() {
            addCriterion("ProjectState is not null");
            return (Criteria) this;
        }

        public Criteria andProjectstateEqualTo(Integer value) {
            addCriterion("ProjectState =", value, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateNotEqualTo(Integer value) {
            addCriterion("ProjectState <>", value, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateGreaterThan(Integer value) {
            addCriterion("ProjectState >", value, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("ProjectState >=", value, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateLessThan(Integer value) {
            addCriterion("ProjectState <", value, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateLessThanOrEqualTo(Integer value) {
            addCriterion("ProjectState <=", value, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateIn(List<Integer> values) {
            addCriterion("ProjectState in", values, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateNotIn(List<Integer> values) {
            addCriterion("ProjectState not in", values, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateBetween(Integer value1, Integer value2) {
            addCriterion("ProjectState between", value1, value2, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateNotBetween(Integer value1, Integer value2) {
            addCriterion("ProjectState not between", value1, value2, "projectstate");
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