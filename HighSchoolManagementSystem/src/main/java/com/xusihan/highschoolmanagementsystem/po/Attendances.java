package com.xusihan.highschoolmanagementsystem.po;

import java.util.Date;

public class Attendances {
    private Integer attendanceid;

    private Integer studentid;

    private Integer classid;

    private Integer semesterid;

    private Integer courseid;

    private String situation;

    private Date attendancetime;

    private String attendancedesc;

    public Integer getAttendanceid() {
        return attendanceid;
    }

    public void setAttendanceid(Integer attendanceid) {
        this.attendanceid = attendanceid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(Integer semesterid) {
        this.semesterid = semesterid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation == null ? null : situation.trim();
    }

    public Date getAttendancetime() {
        return attendancetime;
    }

    public void setAttendancetime(Date attendancetime) {
        this.attendancetime = attendancetime;
    }

    public String getAttendancedesc() {
        return attendancedesc;
    }

    public void setAttendancedesc(String attendancedesc) {
        this.attendancedesc = attendancedesc == null ? null : attendancedesc.trim();
    }
}