package com.xusihan.highschoolmanagementsystem.po;

public class Schools {
    private Integer schoolid;

    private String schoolname;

    private Integer schoolstate;

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    public Integer getSchoolstate() {
        return schoolstate;
    }

    public void setSchoolstate(Integer schoolstate) {
        this.schoolstate = schoolstate;
    }
}