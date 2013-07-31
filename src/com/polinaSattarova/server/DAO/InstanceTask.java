package com.polinaSattarova.server.DAO;


import java.sql.Date;

public class InstanceTask {

    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String project;

    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }

    private Integer timeForWork;

    public Integer getTimeForWork() {
        return timeForWork;
    }

    public void setTimeForWork(Integer timeForWork) {
        this.timeForWork = timeForWork;
    }

    public Date startDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String developer;

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public InstanceTask() {
    }

    public InstanceTask(int id,String project, String name, Integer timeForWork, Date startDate, Date endDate, String state, String developer) {
        this.id = id;
        this.project = project;
        this.name = name;
        this.timeForWork = timeForWork;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.developer = developer;
    }


}
