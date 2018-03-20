package com.xusihan.highschoolmanagementsystem.po;

import java.util.Date;

public class Studentstudyrecord {
    private Integer studyrecordid;

    private Integer studentid;

    private String computerlevel;

    private String englishlevel;

    private String graduateschool;

    private Date gradutetime;

    private String certificate;

    private String jobcompany;

    private String jobcourse;

    public Integer getStudyrecordid() {
        return studyrecordid;
    }

    public void setStudyrecordid(Integer studyrecordid) {
        this.studyrecordid = studyrecordid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getComputerlevel() {
        return computerlevel;
    }

    public void setComputerlevel(String computerlevel) {
        this.computerlevel = computerlevel == null ? null : computerlevel.trim();
    }

    public String getEnglishlevel() {
        return englishlevel;
    }

    public void setEnglishlevel(String englishlevel) {
        this.englishlevel = englishlevel == null ? null : englishlevel.trim();
    }

    public String getGraduateschool() {
        return graduateschool;
    }

    public void setGraduateschool(String graduateschool) {
        this.graduateschool = graduateschool == null ? null : graduateschool.trim();
    }

    public Date getGradutetime() {
        return gradutetime;
    }

    public void setGradutetime(Date gradutetime) {
        this.gradutetime = gradutetime;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
    }

    public String getJobcompany() {
        return jobcompany;
    }

    public void setJobcompany(String jobcompany) {
        this.jobcompany = jobcompany == null ? null : jobcompany.trim();
    }

    public String getJobcourse() {
        return jobcourse;
    }

    public void setJobcourse(String jobcourse) {
        this.jobcourse = jobcourse == null ? null : jobcourse.trim();
    }
}