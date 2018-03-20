package com.xusihan.highschoolmanagementsystem.po;

public class Projects {
    private Integer projectid;

    private String projectname;

    private Integer projectperiod;

    private Integer codemeasure;

    private String projectlevel;

    private String projectdesc;

    private String difficulty;

    private String target;

    private String technique;

    private String projectdatabase;

    private String conditions;

    private String features;

    private String skilldifficulty;

    private String skillkeynote;

    private String suggestion;

    private Integer projectstate;

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public Integer getProjectperiod() {
        return projectperiod;
    }

    public void setProjectperiod(Integer projectperiod) {
        this.projectperiod = projectperiod;
    }

    public Integer getCodemeasure() {
        return codemeasure;
    }

    public void setCodemeasure(Integer codemeasure) {
        this.codemeasure = codemeasure;
    }

    public String getProjectlevel() {
        return projectlevel;
    }

    public void setProjectlevel(String projectlevel) {
        this.projectlevel = projectlevel == null ? null : projectlevel.trim();
    }

    public String getProjectdesc() {
        return projectdesc;
    }

    public void setProjectdesc(String projectdesc) {
        this.projectdesc = projectdesc == null ? null : projectdesc.trim();
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty == null ? null : difficulty.trim();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique == null ? null : technique.trim();
    }

    public String getProjectdatabase() {
        return projectdatabase;
    }

    public void setProjectdatabase(String projectdatabase) {
        this.projectdatabase = projectdatabase == null ? null : projectdatabase.trim();
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions == null ? null : conditions.trim();
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features == null ? null : features.trim();
    }

    public String getSkilldifficulty() {
        return skilldifficulty;
    }

    public void setSkilldifficulty(String skilldifficulty) {
        this.skilldifficulty = skilldifficulty == null ? null : skilldifficulty.trim();
    }

    public String getSkillkeynote() {
        return skillkeynote;
    }

    public void setSkillkeynote(String skillkeynote) {
        this.skillkeynote = skillkeynote == null ? null : skillkeynote.trim();
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion == null ? null : suggestion.trim();
    }

    public Integer getProjectstate() {
        return projectstate;
    }

    public void setProjectstate(Integer projectstate) {
        this.projectstate = projectstate;
    }
}