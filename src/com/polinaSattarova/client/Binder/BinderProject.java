package com.polinaSattarova.client.Binder;

import java.io.Serializable;


public class BinderProject implements Serializable {
    public int Id;
    public String projectFullName;
    public String projectShortName;
    public String projectDescription;

    public BinderProject(int id, String lastName, String firstName, String middleName, String position) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getFullName() {
        return projectFullName;
    }

    public void setFullName(String fullName) {
        this.projectFullName = fullName;
    }

    public String getShortName() {
        return projectShortName;
    }

    public void setShortName(String shortName) {
        this.projectShortName = shortName;
    }

    public String getDescription() {
        return projectDescription;
    }

    public void setDescription(String description) {
        this.projectDescription = description;
    }

    public BinderProject() {
    }

    public BinderProject(int id, String fullName, String shortName, String description) {
        this.Id = id;
        this.projectFullName = fullName;
        this.projectShortName = shortName;
        this.projectDescription = description;
    }


}
