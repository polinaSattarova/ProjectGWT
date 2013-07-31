package com.mySampleApplication.client.Project;

import com.smartgwt.client.widgets.grid.ListGridRecord;


class ProjectRecord extends ListGridRecord {

    public ProjectRecord( int index, String projectFullName,
                         String projectShortName, String description) {

        setProjectFullName(projectFullName);
        setIndex(index);
        setProjectShortName(projectShortName);
        setDescription(description);

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


