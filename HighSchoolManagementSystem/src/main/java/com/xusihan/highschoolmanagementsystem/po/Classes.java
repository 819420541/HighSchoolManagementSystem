package com.xusihan.highschoolmanagementsystem.po;

import java.util.Date;

public class Classes {
    private Integer classid;

    private Integer schoolid;

    private Integer semesterid;

    private String classname;

    private String teacherofcharge;

    private Date enrollmentdate;

    private Date graduatedate;

    private Boolean isgraduate;

    private Integer classstate;

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getTeacherofcharge() {
        return teacherofcharge;
    }

    public void setTeacherofcharge(String teacherofcharge) {
        this.teacherofcharge = teacherofcharge == null ? null : teacherofcharge.trim();
    }

    public Date getEnrollmentdate() {
        return enrollmentdate;
    }

    public void setEnrollmentdate(Date enrollmentdate) {
        this.enrollmentdate = enrollmentdate;
    }

    public Date getGraduatedate() {
        return graduatedate;
    }

    public void setGraduatedate(Date graduatedate) {
        this.graduatedate = graduatedate;
    }

    public Boolean getIsgraduate() {
        return isgraduate;
    }

    public void setIsgraduate(Boolean isgraduate) {
        this.isgraduate = isgraduate;
    }

    public Integer getClassstate() {
        return classstate;
    }

    public void setClassstate(Integer classstate) {
        this.classstate = classstate;
    }
}