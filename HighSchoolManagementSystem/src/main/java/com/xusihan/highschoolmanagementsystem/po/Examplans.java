package com.xusihan.highschoolmanagementsystem.po;

import java.util.Date;

public class Examplans {
    private Integer examplanid;

    private String examplanname;

    private Integer examid;

    private Integer classid;

    private Date examdate;

    private String examstarttime;

    private String examendtime;

    private String remark;

    private Integer examplanstate;

    public Integer getExamplanid() {
        return examplanid;
    }

    public void setExamplanid(Integer examplanid) {
        this.examplanid = examplanid;
    }

    public String getExamplanname() {
        return examplanname;
    }

    public void setExamplanname(String examplanname) {
        this.examplanname = examplanname == null ? null : examplanname.trim();
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Date getExamdate() {
        return examdate;
    }

    public void setExamdate(Date examdate) {
        this.examdate = examdate;
    }

    public String getExamstarttime() {
        return examstarttime;
    }

    public void setExamstarttime(String examstarttime) {
        this.examstarttime = examstarttime == null ? null : examstarttime.trim();
    }

    public String getExamendtime() {
        return examendtime;
    }

    public void setExamendtime(String examendtime) {
        this.examendtime = examendtime == null ? null : examendtime.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getExamplanstate() {
        return examplanstate;
    }

    public void setExamplanstate(Integer examplanstate) {
        this.examplanstate = examplanstate;
    }
}