package com.xusihan.highschoolmanagementsystem.po;

public class Course {
    private Integer courseid;

    private Integer schoolid;

    private Integer semesterid;

    private Integer coursebookid;

    private String coursename;

    private Integer coursestate;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
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

    public Integer getCoursebookid() {
        return coursebookid;
    }

    public void setCoursebookid(Integer coursebookid) {
        this.coursebookid = coursebookid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public Integer getCoursestate() {
        return coursestate;
    }

    public void setCoursestate(Integer coursestate) {
        this.coursestate = coursestate;
    }
}