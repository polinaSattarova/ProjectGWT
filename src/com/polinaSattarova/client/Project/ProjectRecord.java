package com.polinaSattarova.client.Project;

import com.smartgwt.client.widgets.grid.ListGridRecord;


public class ProjectRecord extends ListGridRecord {


    public ProjectRecord(int index, String fullName, String shortName, String description) {
        setIndex(index);
        setProjectFullName(fullName);
        setProjectShortName(shortName);
        setDescription(description);
    }

    public ProjectRecord() {

    }

    public void setProjectFullName(String projectFullName) {
        setAttribute("projectFullName", projectFullName);
    }

    public String getProjectFullName() {
        return getAttributeAsString("projectFullName");
    }

    public void setIndex(int index) {
        setAttribute("index", index);
    }

    public int getIndex() {
        return getAttributeAsInt("index");
    }


    public void setProjectShortName(String projectShortName) {
        setAttribute("projectShortName", projectShortName);
    }

    public String getProjectShortName() {
        return getAttributeAsString("projectShortName");
    }


    public void setDescription(String description) {
        setAttribute("description", description);
    }

    public String getDescription() {
        return getAttributeAsString("description");
    }

}


