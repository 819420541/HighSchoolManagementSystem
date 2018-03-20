package com.xusihan.highschoolmanagementsystem.po;

public class Semesters {
    private Integer semesterid;

    private String semestername;

    private Integer semesterstate;

    public Integer getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(Integer semesterid) {
        this.semesterid = semesterid;
    }

    public String getSemestername() {
        return semestername;
    }

    public void setSemestername(String semestername) {
        this.semestername = semestername == null ? null : semestername.trim();
    }

    public Integer getSemesterstate() {
        return semesterstate;
    }

    public void setSemesterstate(Integer semesterstate) {
        this.semesterstate = semesterstate;
    }
}