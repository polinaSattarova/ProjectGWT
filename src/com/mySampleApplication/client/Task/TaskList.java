package com.mySampleApplication.client.Task;

import com.smartgwt.client.types.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
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

    protected boolean isTopIntro() {
        return true;
    }

    private ListGrid taskGrid;
    Canvas canvas = new Canvas();
    public void onModuleLoad() {
        //final VLayout layout = new VLayout(10);
        //layout.setAutoHeight();
        canvas.setAutoHeight();
        HLayout hLayout = new HLayout(10);
        taskGrid = createListGrid();

        IButton editShowWindow = new IButton("Edit new task");
        editShowWindow.setShowRollOver(true);
        editShowWindow.setShowDown(true);
        editShowWindow.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                AddTask();
            }
        });

        hLayout.addMember(editShowWindow);

        canvas.addChild(taskGrid);
        canvas.addChild(hLayout);

        canvas.draw();
    }
    private void AddTask()
    {
        final Window winModal = new Window();
        winModal.setWidth(500);
        winModal.setHeight(200);
        winModal.setTitle("Modal Window");
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

        TextItem projectNameField = new TextItem();
        projectNameField.setTitle("Project");
        TextItem nameField = new TextItem();
        nameField.setTitle("Task name");
        ListGrid list = new ListGrid();
        list.setValueMap("Europe", "Asia", "North America", "Australia/Oceania", "South America", "Africa");

        DateItem startDateField = new DateItem();
        startDateField.setTitle("Start date");
        startDateField.setUseTextField(true);
        DateItem endDateField = new DateItem();
        endDateField.setTitle("End date");
        endDateField.setUseTextField(true);
        TextItem stateField = new TextItem();
        stateField.setTitle("State");
        TextItem developerField = new TextItem();
        developerField.setTitle("Developer");
        form.setFields(projectNameField, nameField, startDateField, endDateField, stateField, developerField);
        winModal.addItem(form);
        winModal.show();
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


        taskGrid.setFields(indexField, projectNameField, nameField, startDateField, endDateField, stateField , developerField);

        return taskGrid;
    }
    public Canvas ReturnTaskCanvas(){
        return canvas;
    }
}