package com.xusihan.highschoolmanagementsystem.po;

public class Coursebooks {
    private Integer coursebookid;

    private String coursebookname;

    private String coursebookcode;

    private String coursebookdesc;

    private Integer theoryperiod;

    private Integer practiceperiod;

    private String knowledge;

    private String suggestion;

    private Integer coursebookstate;

    public Integer getCoursebookid() {
        return coursebookid;
    }

    public void setCoursebookid(Integer coursebookid) {
        this.coursebookid = coursebookid;
    }

    public String getCoursebookname() {
        return coursebookname;
    }

    public void setCoursebookname(String coursebookname) {
        this.coursebookname = coursebookname == null ? null : coursebookname.trim();
    }

    public String getCoursebookcode() {
        return coursebookcode;
    }

    public void setCoursebookcode(String coursebookcode) {
        this.coursebookcode = coursebookcode == null ? null : coursebookcode.trim();
    }

    public String getCoursebookdesc() {
        return coursebookdesc;
    }

    public void setCoursebookdesc(String coursebookdesc) {
        this.coursebookdesc = coursebookdesc == null ? null : coursebookdesc.trim();
    }

    public Integer getTheoryperiod() {
        return theoryperiod;
    }

    public void setTheoryperiod(Integer theoryperiod) {
        this.theoryperiod = theoryperiod;
    }

    public Integer getPracticeperiod() {
        return practiceperiod;
    }

    public void setPracticeperiod(Integer practiceperiod) {
        this.practiceperiod = practiceperiod;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge == null ? null : knowledge.trim();
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion == null ? null : suggestion.trim();
    }

    public Integer getCoursebookstate() {
        return coursebookstate;
    }

    public void setCoursebookstate(Integer coursebookstate) {
        this.coursebookstate = coursebookstate;
    }
}