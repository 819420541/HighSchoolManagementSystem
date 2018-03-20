package com.xusihan.highschoolmanagementsystem.po;

public class Examtypes {
    private Integer examtypeid;

    private Integer schoolid;

    private String examtypename;

    private String remark;

    private Integer examtypestate;

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

    public String getExamtypename() {
        return examtypename;
    }

    public void setExamtypename(String examtypename) {
        this.examtypename = examtypename == null ? null : examtypename.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getExamtypestate() {
        return examtypestate;
    }

    public void setExamtypestate(Integer examtypestate) {
        this.examtypestate = examtypestate;
    }
}