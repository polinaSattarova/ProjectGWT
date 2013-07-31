package com.polinaSattarova.client.Task;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.polinaSattarova.client.Binder.BinderTask;
import com.polinaSattarova.client.BinderService;
import com.polinaSattarova.client.BinderServiceAsync;
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

import java.util.LinkedHashMap;


public class TaskEdit {

    public static void AddTask(String title, Boolean editOrNew, String prjectNameIfEdit) {
        final Window winModal = new Window();
        winModal.setWidth(500);
        winModal.setHeight(280);
        winModal.setTitle(title);
        winModal.setShowMinimizeButton(false);
        winModal.setIsModal(true);
        winModal.setShowModalMask(true);
        winModal.getPageRight();
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


        final ComboBoxItem projectNameFieldC = new ComboBoxItem();
        projectNameFieldC.setTitle("Project");
        LinkedHashMap projectsMap = new LinkedHashMap(TaskList.shortProjectList.size());
        Integer indexP = 0;
        for (String s : TaskList.shortProjectList) {
            projectsMap.put(indexP, s);
        }
        projectNameFieldC.setValueMap(projectsMap);

        final TextItem projectNameFieldT = new TextItem();
        projectNameFieldT.setTitle("Project");
        projectNameFieldT.setValue(prjectNameIfEdit);


        final TextItem nameField = new TextItem();
        nameField.setTitle("Task name");

        final IntegerItem workField = new IntegerItem();
        workField.setTitle("Work time");

        final DateItem startDateField = new DateItem();
        startDateField.setTitle("Start date");
        startDateField.setUseTextField(true);
        final DateItem endDateField = new DateItem();
        endDateField.setTitle("End date");
        endDateField.setUseTextField(true);
        ComboBoxItem stateField = new ComboBoxItem();
        stateField.setTitle("State");
        stateField.setValueMap("NotStarted", "InProgress", "Completed", "Postponed");
        final ComboBoxItem developerField = new ComboBoxItem();
        developerField.setTitle("Developer");
        LinkedHashMap developersMap = new LinkedHashMap(TaskList.shortDeveloperList.size());
        Integer indexD = 0;
        for (String s : TaskList.shortDeveloperList) {
            developersMap.put(indexD, s);
        }
        developerField.setValueMap(developersMap);

        LengthRangeValidator lValidator = new LengthRangeValidator();
        lValidator.setMin(5);
        lValidator.setErrorMessage("Please enter a valid ( 5-character) value");
        nameField.setValidators(lValidator);

        IntegerRangeValidator iValidator = new IntegerRangeValidator();
        iValidator.setMin(1);
        iValidator.setMax(10000);
        iValidator.setErrorMessage("Please enter a valid (0 < work time < 10000) value");
        workField.setValidators(iValidator);

        if (editOrNew)
            form.setFields(projectNameFieldT, nameField, workField, startDateField, endDateField, stateField, developerField);
        else
            form.setFields(projectNameFieldC, nameField, workField, startDateField, endDateField, stateField, developerField);

        Button saveButton = new Button("Save");
        saveButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                TaskRecord newTaskRecord = new TaskRecord();
                newTaskRecord.setIndex(0);
                newTaskRecord.setProjectName(projectNameFieldC.getDisplayField());
                newTaskRecord.setNameField(nameField.getEnteredValue());
                newTaskRecord.setWorkTime(workField.getValueAsInteger());
                newTaskRecord.setStartDateField(startDateField.getValueAsDate());
                newTaskRecord.setEndDateField(endDateField.getValueAsDate());
                newTaskRecord.setDeveloperField(developerField.getDisplayField());

                BinderTask fpr = TaskConverter.convertTaskToBinder(newTaskRecord);
                editTask(fpr);

            }
        });

        saveButton.setTop(200);
        saveButton.setLeft(350);
        form.addChild(saveButton);

        winModal.addItem(form);
        winModal.show();
    }

    private static void editTask(BinderTask binderTask) {
        BinderServiceAsync projectService = (BinderServiceAsync) GWT.create(BinderService.class);

        AsyncCallback callback = new AsyncCallback() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(Object result) {
            }
        };
        projectService.addNewTask(binderTask, callback);
    }

}

