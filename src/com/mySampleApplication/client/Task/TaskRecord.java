package com.mySampleApplication.client.Task;

import com.smartgwt.client.widgets.grid.ListGridRecord;

import java.util.Date;

class TaskRecord extends ListGridRecord {

    public TaskRecord(Integer index, String projectName, String nameField,
                      Date startDateField, Date endDateField,String stateField, String developerField) {

        setIndex(index);
        setProjectName(projectName);
        setNameField(nameField);
        setStartDateField(startDateField);
        setEndDateField(endDateField);
        setStateField(stateField);
        setDeveloperField(developerField);

    }

    public void setIndex(Integer index) {
        setAttribute("index", index);
    }

    public Integer getIndex() {
        return getAttributeAsInt("index");
    }

    public void setProjectName(String projectName) {
        setAttribute("projectName", projectName);
    }

    public String getProjectName() {
        return getAttributeAsString("projectName");
    }

    public void setNameField(String nameField) {
        setAttribute("name", nameField);
    }

    public String getNameField() {
        return getAttributeAsString("name");
    }


    public void setStartDateField(Date startDateField) {
        setAttribute("startDate", startDateField);
    }

    public Date getStartDateField() {
        return getAttributeAsDate("startDate");
    }


    public void setEndDateField(Date endDateField) {
        setAttribute("endDate", endDateField);
    }

    public Date getEndDateField() {
        return getAttributeAsDate("endDate");
    }

    public void setStateField(String stateField) {
        setAttribute("state", stateField);
    }

    public String getStateField() {
        return getAttributeAsString("state");
    }
    public void setDeveloperField(String developerField) {
        setAttribute("developer", developerField);
    }

    public String getDeveloperField() {
        return getAttributeAsString("developer");
    }


}

