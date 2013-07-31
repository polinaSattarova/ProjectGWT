package com.polinaSattarova.server.DAO;

public class InstanceProject {

    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private String shortName;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InstanceProject() {
    }

    public InstanceProject(int id, String fullName, String shortName, String description) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.description = description;
    }


}
