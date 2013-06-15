package com.mySampleApplication.client.Developer;

import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.widgets.Canvas;  
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.google.gwt.core.client.EntryPoint;


public class DevelopersList implements EntryPoint {
    private static Label label;
    Canvas canvas = new Canvas();
    public void onModuleLoad() {
        //RootPanel.get().clear();

        label = new Label();
        label.setContents("List of Developers");

        final ListGrid developersGrid = new ListGrid();
        developersGrid.setWidth(500);
        developersGrid.setHeight(224);
        developersGrid.setCellHeight(22);
        developersGrid.setData(DeveloperData.getRecords());

        ListGridField indexField = new ListGridField("index", "Index", 40);
        indexField.setCanEdit(false);
        ListGridField firstNameField = new ListGridField("firstName", "FirstName");
        ListGridField lastNameField = new ListGridField("lastName", "LastName");
        ListGridField middleNameField = new ListGridField("middleName", "MiddleName");
        ListGridField positionField = new ListGridField("position", "Position");


        developersGrid.setFields(indexField, firstNameField,lastNameField, middleNameField, positionField);

        developersGrid.setAutoFetchData(true);
        developersGrid.setCanEdit(true);
        developersGrid.setModalEditing(true);
        developersGrid.setEditEvent(ListGridEditEvent.CLICK);
        developersGrid.setListEndEditAction(RowEndEditAction.NEXT);
        developersGrid.setAutoSaveEdits(false);
        canvas.addChild(label);
        canvas.addChild(developersGrid);
  
        IButton editButton = new IButton("Edit New");  
        editButton.setTop(250);  
        editButton.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {
                developersGrid.startEditingNew();
            }  
        });  
        canvas.addChild(editButton);  
  
        IButton saveButton = new IButton("Save");  
        saveButton.setTop(250);  
        saveButton.setLeft(110);  
        saveButton.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {
                developersGrid.saveAllEdits();
            }  
        });  
        canvas.addChild(saveButton);  
  
        IButton discardButton = new IButton("Discard");  
        discardButton.setTop(250);  
        discardButton.setLeft(220);  
        discardButton.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {
                developersGrid.discardAllEdits();
            }  
        });  
        canvas.addChild(discardButton);

        IButton returnButton = new IButton("Return");
        returnButton.setTop(250);
        returnButton.setLeft(330);
        returnButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            }
        });
        canvas.addChild(returnButton);

        canvas.draw();

    }

    public Canvas ReturnDevelopersCanvas() {

        return canvas;
    }

}

