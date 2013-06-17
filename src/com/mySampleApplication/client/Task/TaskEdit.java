package com.mySampleApplication.client.Task;

import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IntegerRangeValidator;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;


public class TaskEdit  {

   public static void AddTask(String title){
    final Window winModal = new Window();
    winModal.setWidth(500);
    winModal.setHeight(280);
    winModal.setTitle(title);
    winModal.setShowMinimizeButton(false);
    winModal.setIsModal(true);
    winModal.setShowModalMask(true);
    winModal.centerInPage();
    winModal.addCloseClickHandler(new CloseClickHandler() {
        public void onCloseClick(CloseClickEvent event) {
            winModal.destroy();
        }
    });
    DynamicForm form = new DynamicForm();
    form.setHeight100();
    form.setWidth100();
    form.setPadding(5);
    form.setLayoutAlign(VerticalAlignment.BOTTOM);

    ComboBoxItem projectNameField = new ComboBoxItem();
    projectNameField.setTitle("Project");
    projectNameField.setValueMap("1", "2", "3", "4", "5", "6");
    TextItem nameField = new TextItem();
    nameField.setTitle("Task name");

    IntegerItem workField = new IntegerItem();
    workField.setTitle("Work time");

    DateItem startDateField = new DateItem();
    startDateField.setTitle("Start date");
    startDateField.setUseTextField(true);
    DateItem endDateField = new DateItem();
    endDateField.setTitle("End date");
    endDateField.setUseTextField(true);
    ComboBoxItem stateField = new ComboBoxItem();
    stateField.setTitle("State");
    stateField.setValueMap("Not started", "In progress", "Completed", "Postponed");
    ComboBoxItem developerField = new ComboBoxItem();
    developerField.setTitle("Developer");
    developerField.setValueMap("1", "2", "3", "4", "5", "6");

    LengthRangeValidator lValidator = new LengthRangeValidator();
    lValidator.setMin(5);
    lValidator.setErrorMessage("Please enter a valid ( 5-character) value");
    nameField.setValidators(lValidator);

       IntegerRangeValidator iValidator = new IntegerRangeValidator();
       iValidator.setMin(1);
       iValidator.setMax(10000);
       iValidator.setErrorMessage("Please enter a valid (0 < work time < 10000) value");
       workField.setValidators(iValidator);

       form.setFields(projectNameField, nameField, workField, startDateField, endDateField, stateField, developerField);

    Button saveButton = new Button("Save");
    saveButton.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
            //taskGrid.removeSelectedData();
        }
    });

    saveButton.setTop(200);
    saveButton.setLeft(350);
    form.addChild(saveButton);

    winModal.addItem(form);
    winModal.show();
   }
}

