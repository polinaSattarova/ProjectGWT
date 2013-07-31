package com.polinaSattarova.client.Task;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.polinaSattarova.client.Binder.BinderTask;
import com.polinaSattarova.client.BinderService;
import com.polinaSattarova.client.BinderServiceAsync;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskList implements EntryPoint {

    private ListGrid taskGrid;
    private Label label;
    Canvas canvas = new Canvas();
    private TaskRecord[] dataSource;
    public static ArrayList<String> shortDeveloperList;
    public static ArrayList<String> shortProjectList;

    public void onModuleLoad() {
        synchronized (TaskList.class) {
            initDataSource();
            selectShortDevelopersList();
            selectShortProjectsList();
        }

    }

    public void onReady() {

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

        canvas.addChild(createButtonEdit());
        canvas.addChild(createButtonRemove());
        canvas.addChild(createButtonUpdate());

        canvas.draw();

    }

    public Button createButtonUpdate() {
        Button updateButton = new Button("Update");
        updateButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                taskGrid.saveAllEdits();
                TaskRecord dd = (TaskRecord) taskGrid.getSelectedRecord();
                BinderTask fpr = TaskConverter.convertTaskToBinder(dd);

                updateTask(fpr);
            }
        });
        updateButton.setTop(40);
        updateButton.setLeft(220);
        return updateButton;
    }

    public Button createButtonRemove() {
        Button removeButton = new Button("Remove");
        removeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                TaskRecord task = (TaskRecord) taskGrid.getSelectedRecord();
                BinderTask fpr = TaskConverter.convertTaskToBinder(task);
                removeDeveloper(fpr);
                taskGrid.removeSelectedData();
            }
        });
        removeButton.setTop(40);
        removeButton.setLeft(110);
        return removeButton;
    }

    public IButton createButtonEdit() {
        IButton editShowWindow = new IButton("Edit new task");
        editShowWindow.setShowRollOver(true);
        editShowWindow.setShowDown(true);
        editShowWindow.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                TaskEdit.AddTask("Edit window", false, null);
            }
        });
        editShowWindow.setTop(40);
        return editShowWindow;
    }

    public ListGrid createListGrid() {

        final ListGrid taskGrid = new ListGrid();
        taskGrid.setLeaveScrollbarGap(true);

        taskGrid.setWidth(750);
        taskGrid.setHeight(224);
        taskGrid.setData(dataSource);
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
        HashMap projectsMap = new HashMap(shortProjectList.size());
        Integer indexP = 0;
        for (String s : shortProjectList) {
            projectsMap.put(indexP, s);
        }
        projectNameField.setValueMap(projectsMap);

        ListGridField nameField = new ListGridField("name", "Name");
        nameField.setCanEdit(true);

        ListGridField startDateField = new ListGridField("startDate", "StartDate");
        startDateField.setType(ListGridFieldType.DATE);

        ListGridField endDateField = new ListGridField("endDate", "EndDate");
        endDateField.setType(ListGridFieldType.DATE);

        ListGridField stateField = new ListGridField("state", "State");
        stateField.setValueMap("Not_started", "In_progress", "Completed", "Postponed");

        ListGridField developerField = new ListGridField("developer", "Developer");
        HashMap developersMap = new HashMap(shortDeveloperList.size());
        Integer indexD = 0;
        for (String s : shortDeveloperList) {
            developersMap.put(indexD, s);
        }

        developerField.setValueMap(developersMap);

        LengthRangeValidator lValidator = new LengthRangeValidator();
        lValidator.setMin(5);
        lValidator.setErrorMessage("Please enter a valid ( 5-character) value");

        nameField.setValidators(lValidator);

        taskGrid.setFields(indexField, projectNameField, nameField, startDateField, endDateField, stateField, developerField);

        return taskGrid;
    }

    public Canvas ReturnTaskCanvas() {
        onModuleLoad();
        return canvas;
    }


    private void initDataSource() {
        BinderServiceAsync projectService = (BinderServiceAsync) GWT.create(BinderService.class);

        AsyncCallback callback = new AsyncCallback<ArrayList<BinderTask>>() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(ArrayList<BinderTask> result) {
                dataSource = TaskItemList.getNewRecords(result);
                onReady();
            }
        };
        projectService.selectAllTasks(callback);
    }

    private void selectShortDevelopersList() {
        BinderServiceAsync projectService = (BinderServiceAsync) GWT.create(BinderService.class);

        AsyncCallback callback = new AsyncCallback<ArrayList<String>>() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(ArrayList<String> result) {
                shortDeveloperList = result;

            }
        };
        projectService.selectShortDevelopersList(callback);
    }

    private void selectShortProjectsList() {
        BinderServiceAsync projectService = (BinderServiceAsync) GWT.create(BinderService.class);

        AsyncCallback callback = new AsyncCallback<ArrayList<String>>() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(ArrayList<String> result) {
                shortProjectList = result;
            }
        };
        projectService.selectShortDevelopersList(callback);
    }

    private void updateTask(BinderTask binderTask) {
        BinderServiceAsync projectService = (BinderServiceAsync) GWT.create(BinderService.class);

        AsyncCallback callback = new AsyncCallback() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(Object result) {
            }
        };
        projectService.updateTask(binderTask, callback);
    }

    private void removeDeveloper(BinderTask binderTask) {
        BinderServiceAsync projectService = (BinderServiceAsync) GWT.create(BinderService.class);

        AsyncCallback callback = new AsyncCallback() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(Object result) {
            }
        };
        projectService.removeTask(binderTask, callback);
    }
}