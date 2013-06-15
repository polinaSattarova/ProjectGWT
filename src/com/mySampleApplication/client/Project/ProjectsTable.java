package com.mySampleApplication.client.Project;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.events.*;


public class ProjectsTable implements EntryPoint {
    private Label label;
     Canvas canvas = new Canvas();
    public void onModuleLoad() {

       // RootPanel.get().clear();
        label = new Label();
        label.setContents("List of Projects");
        Button returnButton = new Button("Return ");

       // RootPanel.get().add(label);
        //RootPanel.get().add(getViewPanel());
        //RootPanel.get().add(returnButton);
        canvas.addChild(label);
        canvas.addChild(getViewPanel());
        canvas.addChild(returnButton);
   }

    public Canvas getViewPanel() {
        Canvas canvas = new Canvas();

        final ListGrid  projectsGrid = new ListGrid();
        projectsGrid.setWidth(800);
        projectsGrid.setHeight(400);
        projectsGrid.setAlternateRecordStyles(true);
        projectsGrid.setShowAllRecords(true);


        ListGridField countryCodeField = new ListGridField("index", "Index", 40);
        countryCodeField.setType(ListGridFieldType.INTEGER);
        ListGridField nameField = new ListGridField("projectFullName", "Full Name");
        ListGridField independenceField = new ListGridField("projectShortName", "Short Name");
        ListGridField populationField = new ListGridField("description", "Description", 225);

        projectsGrid.setData(ProjectData.getRecords());
        canvas.addChild(projectsGrid);


        final DetailViewer detailViewer = new DetailViewer();
        detailViewer.setWidth(500);
        detailViewer.setTop(250);
        detailViewer.setFields(
                new DetailViewerField("index", "Index"),
                new DetailViewerField("projectFullName", "Full Name"),
                new DetailViewerField("projectShortName", "Short Name"),
                new DetailViewerField("description", "Description"));

        detailViewer.setEmptyMessage("Click a row in the grid");
        canvas.addChild(detailViewer);

        projectsGrid.addRecordClickHandler(new RecordClickHandler() {
            public void onRecordClick(RecordClickEvent event) {
                detailViewer.setData(projectsGrid.getSelection());
            }
        });

        projectsGrid.addRecordDoubleClickHandler(new RecordDoubleClickHandler() {
            public void onRecordDoubleClick(RecordDoubleClickEvent event) {
                ProjectRecord record = (ProjectRecord) event.getRecord();
                SC.say("Double-clicked project: <b>" + record.getProjectFullName() + "</b>");
            }
        });

        projectsGrid.addRowContextClickHandler(new RowContextClickHandler() {
            public void onRowContextClick(RowContextClickEvent event) {
                ProjectRecord record = (ProjectRecord)event.getRecord();
                SC.say("Context-clicked project: <b>" + record.getProjectFullName() + "</b>");

                event.cancel();
            }
        });
        canvas.draw();

        return projectsGrid;
    }

    public Canvas ReturnProjectCanvas(){
        return canvas;
    }

}


