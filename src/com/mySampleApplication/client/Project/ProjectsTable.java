package com.mySampleApplication.client.Project;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.events.*;


public class ProjectsTable implements EntryPoint {
    private Label label;
    Canvas canvas = new Canvas();
    public void onModuleLoad() {

        canvas.setHeight100();
        canvas.setWidth100();
        Label label = new Label();
        label.setHeight(20);
        label.setWidth(400);
        label.setContents("List of Projects");
        label.setAlign(Alignment.RIGHT);
        label.setTop(10);
        canvas.addChild(label);

        final DataSource dataSource = ProjectItemList.getInstance();

        final DynamicForm form = new DynamicForm();
        form.setIsGroup(true);
        form.setGroupTitle("Update");
        form.setNumCols(4);
        form.setDataSource(dataSource);
        form.setWidth(500);

        final ListGrid listGrid = new ListGrid();
        listGrid.setWidth(700);
        listGrid.setHeight(200);
        listGrid.setDataSource(dataSource);
        listGrid.setAutoFetchData(true);
        listGrid.addRecordClickHandler(new RecordClickHandler() {
            public void onRecordClick(RecordClickEvent event) {
                form.reset();
                form.editSelectedData(listGrid);
            }
        });
        listGrid.setTop(40);
        canvas.addChild(listGrid);
        form.setTop(250);
        canvas.addChild(form);

        IButton buttonUpdate = new IButton("Update");
        buttonUpdate.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                form.saveData();
            }
        });
        buttonUpdate.setTop(350);
        buttonUpdate.setLeft(110);
        canvas.addChild(buttonUpdate);

        Button buttonRemove = new Button("Remove");
        buttonRemove.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                listGrid.removeSelectedData();
            }
        });
        buttonRemove.setTop(350);
        buttonRemove.setLeft(220);
        canvas.addChild(buttonRemove);

        IButton buttonAdd = new IButton("Add");
        buttonAdd.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {

            }
        });
        buttonAdd.setTop(350);
        canvas.addChild(buttonAdd);
        canvas.draw();
    }


    public Canvas ReturnProjectCanvas(){
        onModuleLoad();
        return canvas;
    }

}


