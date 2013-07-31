package com.polinaSattarova.client.Binder;

import java.io.Serializable;

public class BinderTask implements Serializable {
    public int Id;
    public String project;
    public String name;
    public Integer timeForWork;
    public java.util.Date startDate;
    public java.util.Date endDate;
    public String state;
    public String developer;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimeForWork() {
        return timeForWork;
    }

    public void setTimeForWork(Integer timeForWork) {
        this.timeForWork = timeForWork;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public BinderTask() {
    }

    public BinderTask(int id, String project, String name, Integer timeForWork, java.util.Date startDate, java.util.Date endDate, String state, String developer) {
        this.Id = id;
        this.project = project;
        this.name = name;
        this.timeForWork = timeForWork;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.developer = developer;
    }


}
