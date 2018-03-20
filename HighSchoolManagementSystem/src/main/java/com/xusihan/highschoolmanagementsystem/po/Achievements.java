package com.xusihan.highschoolmanagementsystem.po;

public class Achievements {
    private Integer achievementid;

    private Integer examplanid;

    private Integer examid;

    private Integer studentid;

    private String result;

    public Integer getAchievementid() {
        return achievementid;
    }

    public void setAchievementid(Integer achievementid) {
        this.achievementid = achievementid;
    }

    public Integer getExamplanid() {
        return examplanid;
    }

    public void setExamplanid(Integer examplanid) {
        this.examplanid = examplanid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}