package com.polinaSattarova.client.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.polinaSattarova.client.BinderService;
import com.polinaSattarova.client.BinderServiceAsync;
import com.polinaSattarova.client.Task.TaskEdit;
import com.polinaSattarova.client.Binder.BinderProject;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;

import static com.polinaSattarova.client.Project.ProjectConverter.convertRecordToBinder;

public class ProjectEditWindow {

    public static void ProjectEdit(String title) {
        final Window winModal = new Window();
        winModal.setWidth(450);
        winModal.setHeight(200);
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
        final DynamicForm form = new DynamicForm();
        form.setHeight100();
        form.setWidth100();
        form.setPadding(5);
        form.setLayoutAlign(VerticalAlignment.BOTTOM);

        final TextItem fullNameField = new TextItem();
        fullNameField.setTitle("Full Name");
        final TextItem shortNameField = new TextItem();
        shortNameField.setTitle("Short Name");
        final TextItem descriptionField = new TextItem();
        descriptionField.setTitle("Description");

        ComboBoxItem listOfTask = new ComboBoxItem();
        listOfTask.setTitle("List of task");
        listOfTask.setValueMap();
        listOfTask.setVisible(false);

        LengthRangeValidator lValidator = new LengthRangeValidator();
        lValidator.setMin(5);
        lValidator.setErrorMessage("Please enter a valid ( 5-character) value");

        fullNameField.setValidators(lValidator);
        shortNameField.setValidators(lValidator);
        descriptionField.setValidators(lValidator);

        form.setFields(fullNameField, shortNameField, descriptionField, listOfTask);

        IButton editTaskButton = new IButton("Add task");
        editTaskButton.setShowRollOver(true);
        editTaskButton.setShowDown(true);
        editTaskButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                TaskEdit.AddTask("Add task to project", true, "tre");
            }
        });
        editTaskButton.setTop(100);

        form.addChild(editTaskButton);

        final Button saveButton = new Button("Save");
        saveButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ProjectRecord pr = new ProjectRecord();
                pr.setIndex(1);
                pr.setProjectFullName(fullNameField.toString());
                pr.setProjectShortName(shortNameField.toString());
                pr.setDescription(descriptionField.toString());
                BinderProject fpr = convertRecordToBinder(pr);
                addNewProject(fpr);
            }
        });

        saveButton.setTop(100);
        saveButton.setLeft(150);
        form.addChild(saveButton);

        winModal.addItem(form);
        winModal.show();
    }

    private static void addNewProject(BinderProject fooProject) {
        BinderServiceAsync projectService = (BinderServiceAsync) GWT.create(BinderService.class);

        AsyncCallback callback = new AsyncCallback() {

            @Override
            public void onFailure(Throwable caught) {

            }

            @Override
            public void onSuccess(Object result) {

            }

        };
        projectService.addNewProject(fooProject, callback);
    }
}
