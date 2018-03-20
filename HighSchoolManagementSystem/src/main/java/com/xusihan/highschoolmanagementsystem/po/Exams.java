package com.xusihan.highschoolmanagementsystem.po;

public class Exams {
    private Integer examid;

    private Integer examtypeid;

    private Integer schoolid;

    private Integer semesterid;

    private String examname;

    private String exammedium;

    private String remark;

    private Integer examstate;

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getExamtypeid() {
        return examtypeid;
    }

    public void setExamtypeid(Integer examtypeid) {
        this.examtypeid = examtypeid;
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public Integer getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(Integer semesterid) {
        this.semesterid = semesterid;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname == null ? null : examname.trim();
    }

    public String getExammedium() {
        return exammedium;
    }

    public void setExammedium(String exammedium) {
        this.exammedium = exammedium == null ? null : exammedium.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getExamstate() {
        return examstate;
    }

    public void setExamstate(Integer examstate) {
        this.examstate = examstate;
    }
}