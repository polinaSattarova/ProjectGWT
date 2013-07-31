package com.mySampleApplication.client.Task;

import com.smartgwt.client.types.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.IntegerRangeValidator;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

import com.smartgwt.client.types.ListGridFieldType;

import com.google.gwt.core.client.EntryPoint;

public class TaskList implements EntryPoint {

    private ListGrid taskGrid;
    private Label label;
    public Canvas canvas = new Canvas();

    public void onModuleLoad() {

        Label label = new Label();
        label.setHeight(20);
        label.setWidth(400);
        label.setAlign(Alignment.RIGHT);
        label.setContents("List of Tasks");
        label.setTop(10);
        canvas.addChild(label);

        canvas.setAutoHeight();
        taskGrid = createListGrid();
        taskGrid.setTop(80);
        canvas.addChild(taskGrid);
        IButton editShowWindow = new IButton("Edit new task");
        editShowWindow.setShowRollOver(true);
        editShowWindow.setShowDown(true);
        editShowWindow.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
               TaskEdit.AddTask("Edit window"); //AddTask();
            }
        });
        editShowWindow.setTop(40);
        canvas.addChild(editShowWindow);

        Button removeButton = new Button("Remove");
        removeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                taskGrid.removeSelectedData();
            }
        });
        removeButton.setTop(40);
        removeButton.setLeft(110);
        canvas.addChild(removeButton);

        canvas.draw();
    }

    private ListGrid createListGrid() {

        final ListGrid taskGrid = new ListGrid();
        taskGrid.setLeaveScrollbarGap(true);

        taskGrid.setWidth(750);
        taskGrid.setHeight(224);
        taskGrid.setData(TaskData.getRecords());
        taskGrid.setAutoFetchData(true);

        taskGrid.setShowAllRecords(true);
        taskGrid.setCanEdit(true);
        taskGrid.setEditEvent(ListGridEditEvent.CLICK);

        taskGrid.setCanAddFormulaFields(true);
        taskGrid.setCanAddSummaryFields(true);

        ListGridField indexField = new ListGridField("index", "Index", 50);
        indexField.setAlign(Alignment.CENTER);
        indexField.setType(ListGridFieldType.INTEGER);
        indexField.setCanEdit(false);

        ListGridField projectNameField = new ListGridField("projectName", "Project");
        projectNameField.setValueMap("1", "2", "3", "4", "5", "6");

        ListGridField nameField = new ListGridField("name", "Name");
        nameField.setCanEdit(true);

        ListGridField startDateField = new ListGridField("startDate", "StartDate");
        startDateField.setType(ListGridFieldType.DATE);

        ListGridField endDateField = new ListGridField("endDate", "EndDate");
        endDateField.setType(ListGridFieldType.DATE);

        ListGridField stateField = new ListGridField("state", "State");
        stateField.setValueMap("1", "2", "3", "--");

        ListGridField developerField = new ListGridField("developer", "Developer");
        developerField.setValueMap("1", "2", "3", "--");

        LengthRangeValidator lValidator = new LengthRangeValidator();
        lValidator.setMin(5);
        lValidator.setErrorMessage("Please enter a valid ( 5-character) value");

        nameField.setValidators(lValidator);

        taskGrid.setFields(indexField, projectNameField, nameField, startDateField, endDateField, stateField , developerField);

        return taskGrid;
    }
    public Canvas ReturnTaskCanvas(){
        onModuleLoad();
        return canvas;
    }
}