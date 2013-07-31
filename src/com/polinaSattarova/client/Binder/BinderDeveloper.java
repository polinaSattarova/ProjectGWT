package com.polinaSattarova.client.Binder;

import java.io.Serializable;


public class BinderDeveloper implements Serializable {
    public int Id;
    public String developerFirstName;
    public String developerLastName;
    public String developerMiddleName;
    public String developerPosition;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getDeveloperFirstName() {
        return developerFirstName;
    }

    public void setDeveloperFirstName(String firstName) {
        this.developerFirstName = firstName;
    }

    public String getDeveloperLastName() {
        return developerLastName;
    }

    public void setDeveloperLastName(String lastName) {
        this.developerLastName = lastName;
    }

    public String getDeveloperMiddleName() {
        return developerMiddleName;
    }

    public void setDeveloperMiddleName(String middleName) {
        this.developerMiddleName = middleName;
    }

    public String getDeveloperPosition() {
        return developerPosition;
    }

    public void setDeveloperPosition(String position) {
        this.developerPosition = position;
    }

    public BinderDeveloper() {
    }

    public BinderDeveloper(int id, String lastName, String firstName, String middleName, String position) {
        this.Id = id;
        this.developerLastName = lastName;
        this.developerFirstName = firstName;
        this.developerMiddleName = middleName;
        this.developerPosition = position;
    }


}
