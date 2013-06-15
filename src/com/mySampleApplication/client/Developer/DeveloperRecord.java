package com.mySampleApplication.client.Developer;

import com.smartgwt.client.widgets.grid.ListGridRecord;

class DeveloperRecord extends ListGridRecord {

    public DeveloperRecord(Integer index, String firstName, String lastName,
                           String middleName, String position) {

        setLastName(lastName);
        setFirstName(firstName);
        setMiddleName(middleName);
        setPosition(position);
        setIndex(index);

    }

    public void setIndex(Integer index) {
        setAttribute("index", index);
    }

    public Integer getIndex() {
        return getAttributeAsInt("index");
    }

    public void setLastName(String countryName) {
        setAttribute("lastName", countryName);
    }

    public String getLastName() {
        return getAttributeAsString("lastName");
    }

    public void setFirstName(String countryCode) {
        setAttribute("firstName", countryCode);
    }

    public String getFirstName() {
        return getAttributeAsString("firstName");
    }


    public void setMiddleName(String population) {
        setAttribute("middleName", population);
    }

    public String getMiddleName() {
        return getAttributeAsString("middleName");
    }


    public void setPosition(String independence) {
        setAttribute("position", independence);
    }

    public String getPosition() {
        return getAttributeAsString("position");
    }

}


