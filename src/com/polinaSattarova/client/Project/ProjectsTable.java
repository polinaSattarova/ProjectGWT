package com.polinaSattarova.client.Project;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.polinaSattarova.client.BinderService;
import com.polinaSattarova.client.BinderServiceAsync;
import com.polinaSattarova.client.Binder.BinderProject;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;

import java.util.ArrayList;

public class ProjectsTable implements EntryPoint {
    private Label label;
    private DynamicForm form;
    private DataSource dataSource;
    Canvas canvas = new Canvas();

    public void onModuleLoad() {
        synchronized (ProjectsTable.class)
        {
            initDataSource();
        }
    }

    public void onReady() {
        canvas.setHeight100();
        canvas.setWidth100();
        Label label = new Label();
        label.setHeight(20);
        label.setWidth(400);
        label.setContents("List of Projects");
        label.setAlign(Alignment.RIGHT);
        label.setTop(10);
        canvas.addChild(label);

        form = new DynamicForm();
        form.setIsGroup(true);
        form.setGroupTitle("Update");
        form.setNumCols(4);
        if (dataSource != null)
        form.setDataSource(dataSource);
        else {dataSource.getFields()[0].setRootValue("Have not records");
            dataSource.getFields()[1].setRootValue("Have not records");
            dataSource.getFields()[2].setRootValue("Have not records");}
        form.setWidth(500);
        form.setTop(250);
        canvas.addChild(form);
        canvas.addChild(createButtonUpdate(form));
        final ListGrid listGrid = new ListGrid();
        listGrid.setWidth(700);
        listGrid.setHeight(200);
        if (dataSource != null)
        listGrid.setDataSource(dataSource);
        else {dataSource.getFields()[0].setRootValue("Have not records");
            dataSource.getFields()[1].setRootValue("Have not records");
            dataSource.getFields()[2].setRootValue("Have not records");}
        listGrid.setAutoFetchData(true);
        listGrid.addRecordClickHandler(new RecordClickHandler() {
            public void onRecordClick(RecordClickEvent event) {
                form.reset();
                form.editSelectedData(listGrid);
            }
        });
        listGrid.setTop(40);
        canvas.addChild(listGrid);
        canvas.addChild(createButtonRemove(listGrid));
        canvas.addChild(createButtonAdd());
        canvas.draw();
    }

    public Button createButtonRemove(final ListGrid listGrid){
        Button buttonRemove = new Button("Delete");
        buttonRemove.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ProjectRecord pr = (ProjectRecord) listGrid.getSelectedRecord();
                BinderProject fpr = ProjectConverter.convertRecordToBinder(pr);
                removeData(fpr);
                listGrid.removeSelectedData();
                form.clearValues();
            }
        });
        buttonRemove.setTop(350);
        buttonRemove.setLeft(220);
        return buttonRemove;
    }

    public IButton createButtonUpdate(final DynamicForm form){
        IButton buttonUpdate = new IButton("Update");

        buttonUpdate.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ProjectRecord pr = (ProjectRecord) form.getRecordList().first();
                BinderProject fpr = ProjectConverter.convertRecordToBinder(pr);
                updateData(fpr);
                form.saveData();
            }
        });
        buttonUpdate.setTop(350);
        buttonUpdate.setLeft(110);
        return buttonUpdate;
    }

    public IButton createButtonAdd(){
        IButton buttonAdd = new IButton("Add");
        buttonAdd.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ProjectEditWindow.ProjectEdit("Add new project");
            }
        });
        buttonAdd.setTop(350);
        return buttonAdd;
    }

    public Canvas ReturnProjectCanvas(){
        onModuleLoad();
        return canvas;
    }

    private ProjectRecord[] getNewRecords(ArrayList<BinderProject> arrayListFoo) {

        ProjectRecord[] projectRecordList = new ProjectRecord[arrayListFoo.size()];
        Integer i = 0;
        for (BinderProject instanceProject : arrayListFoo) {
            projectRecordList[i] = (ProjectConverter.convertBinderToRecord(instanceProject));
            i++;
        }
        return projectRecordList;
    }

    private void initDataSource()
    {
        BinderServiceAsync projectService = (BinderServiceAsync) GWT.create(BinderService.class);

        AsyncCallback callback = new AsyncCallback<ArrayList<BinderProject>>() {

            @Override
            public void onFailure(Throwable caught) {
                System.out.println("async failure");
            }

            @Override
            public void onSuccess(ArrayList<BinderProject> result) {
                ProjectRecord[] localProjectList = getNewRecords(result);
                dataSource = new ProjectItemList(localProjectList);
                onReady();
            }
        };
        projectService.selectAllProjects(callback);
    }

    private void removeData(BinderProject fooProject)
    {
        BinderServiceAsync projectService = (BinderServiceAsync) GWT.create(BinderService.class);

        AsyncCallback callback = new AsyncCallback() {

            @Override
            public void onFailure(Throwable caught) {

            }

            @Override
            public void onSuccess(Object result) {

            }


        };
        projectService.removeProject(fooProject, callback);
    }

    private void updateData(BinderProject fooProject)
    {
        BinderServiceAsync projectService = (BinderServiceAsync) GWT.create(BinderService.class);

        AsyncCallback callback = new AsyncCallback() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(Object result) {
           }
        };
        projectService.updateProject(fooProject, callback);
    }
}


