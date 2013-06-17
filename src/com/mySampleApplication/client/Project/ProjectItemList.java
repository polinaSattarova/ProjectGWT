package com.mySampleApplication.client.Project;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.widgets.form.validator.FloatPrecisionValidator;
import com.smartgwt.client.widgets.form.validator.FloatRangeValidator;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;


public class ProjectItemList extends DataSource {

    private static ProjectItemList instance = null;

    public static ProjectItemList getInstance() {
        if (instance == null) {
            instance = new ProjectItemList("supplyItemLocalDS");
        }
        return instance;
    }

    public ProjectItemList(String id) {

        setID(id);
        DataSourceIntegerField index = new DataSourceIntegerField("index", "Index");
        index.setHidden(true);
        index.setPrimaryKey(true);

        DataSourceTextField fullNameField = new DataSourceTextField("projectFullName", "Full Name", 200);
        DataSourceTextField shortNameField = new DataSourceTextField("projectShortName", "Short Name");
        DataSourceTextField descriptionField = new DataSourceTextField("description", "Description", 225);

        LengthRangeValidator lValidator = new LengthRangeValidator();
        lValidator.setMin(3);
        lValidator.setErrorMessage("Please enter a valid ( 3-character) value");

        fullNameField.setValidators(lValidator);
        shortNameField.setValidators(lValidator);
        descriptionField.setValidators(lValidator);

        setFields(index,fullNameField, shortNameField,descriptionField);

        setClientOnly(true);
        setTestData(ProjectData.getRecords());
    }
}
