package com.jdbc.Internjdbc.Entity;

public class Intern {
    private int pid;
    private String internname;
    private int internid;
    private String collegename;
    private int batchno;
    private String projectname;

    public Intern(int pid, String internname, int internid, String collegename, int batchno, String projectname) {
        this.pid = pid;
        this.internname = internname;
        this.internid = internid;
        this.collegename = collegename;
        this.batchno = batchno;
        this.projectname = projectname;
    }

    public Intern() {

    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getInternname() {
        return internname;
    }

    public void setInternname(String internname) {
        this.internname = internname;
    }

    public int getInternid() {
        return internid;
    }

    public void setInternid(int internid) {
        this.internid = internid;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public int getBatchno() {
        return batchno;
    }

    public void setBatchno(int batchno) {
        this.batchno = batchno;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    @Override
    public String toString() {
        return "Intern{" +
                "pid=" + pid +
                ", internname='" + internname + '\'' +
                ", internid=" + internid +
                ", collegename='" + collegename + '\'' +
                ", batchno=" + batchno +
                ", projectname='" + projectname + '\'' +
                '}';
    }
}
