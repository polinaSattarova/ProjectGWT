package com.polinaSattarova.client.Project;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;

public class ProjectItemList extends DataSource {

    public ProjectItemList(ProjectRecord[] items) {
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
        setTestData(items);
    }
}
