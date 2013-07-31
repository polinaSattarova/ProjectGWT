package com.polinaSattarova.client.Developer;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.polinaSattarova.client.BinderService;
import com.polinaSattarova.client.BinderServiceAsync;
import com.polinaSattarova.client.Binder.BinderDeveloper;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

import java.util.ArrayList;


public class DevelopersList implements EntryPoint {
    private static Label label;
    private DeveloperRecord[] dataSource;
    Canvas canvas = new Canvas();


    public void onModuleLoad() {
        synchronized (DevelopersList.class) {
            initDataSource();
        }
    }

    public void onReady() {
        label = new Label();
        label.setContents("List of Developers");

        final ListGrid developersGrid = new ListGrid();
        developersGrid.setWidth(500);
        developersGrid.setHeight(224);
        developersGrid.setCellHeight(22);

        final ListGridField indexField = new ListGridField("index", "Index", 40);
        indexField.setCanEdit(false);
        indexField.setDefaultValue(0);
        ListGridField firstNameField = new ListGridField("firstName", "FirstName");
        ListGridField lastNameField = new ListGridField("lastName", "LastName");


        ListGridField middleNameField = new ListGridField("middleName", "MiddleName");
        ListGridField positionField = new ListGridField("position", "Position");

        LengthRangeValidator lValidator = new LengthRangeValidator();
        lValidator.setMin(5);
        lValidator.setErrorMessage("Please enter a valid ( 5-character) value");

        firstNameField.setValidators(lValidator);
        lastNameField.setValidators(lValidator);
        middleNameField.setValidators(lValidator);
        positionField.setValidators(lValidator);

        developersGrid.setFields(indexField, lastNameField, firstNameField, middleNameField, positionField);

        developersGrid.setAutoFetchData(true);
        developersGrid.setCanEdit(true);
        developersGrid.setModalEditing(true);
        developersGrid.setEditEvent(ListGridEditEvent.CLICK);
        developersGrid.setListEndEditAction(RowEndEditAction.NEXT);
        developersGrid.setAutoSaveEdits(false);

        developersGrid.setData(dataSource);
        canvas.addChild(label);
        canvas.addChild(developersGrid);

        final IButton saveButton = new IButton("Save");
        saveButton.disable();
        final IButton editButton = new IButton("Edit New");
        editButton.setTop(250);
        editButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                saveButton.enable();
                editButton.disable();
                developersGrid.startEditingNew();

            }
        });

        saveButton.setTop(250);
        saveButton.setLeft(110);
        saveButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                editButton.enable();
                saveButton.disable();
                developersGrid.saveAllEdits();
                Integer lenght = (developersGrid.getRecordList().getLength()) - 1;
               // developersGrid.updateData(developersGrid.getRecordList().get(lenght));
                developersGrid.getOriginalRecordList().get(lenght);

                DeveloperRecord d = (DeveloperRecord)developersGrid.getOriginalRecordList().get(lenght-1);

                d.getFirstName();

                BinderDeveloper fpr = DeveloperConverter.convertDeveloperToBinder(d);

                editDeveloper(fpr);


            }
        });

        IButton discardButton = new IButton("Discard");
        discardButton.setTop(250);
        discardButton.setLeft(220);
        discardButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                editButton.enable();
                saveButton.disable();
                developersGrid.discardAllEdits();
            }
        });

        canvas.addChild(editButton);
        canvas.addChild(saveButton);
        canvas.addChild(discardButton);
        canvas.addChild(createButtonUpdate(developersGrid));
        canvas.addChild(createButtonRemove(developersGrid));

        canvas.draw();

    }

    public IButton createButtonRemove(final ListGrid developersGrid) {
        IButton removeButton = new IButton("Remove");
        removeButton.setTop(250);
        removeButton.setLeft(440);
        removeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                DeveloperRecord dd = (DeveloperRecord) developersGrid.getSelectedRecord();
                BinderDeveloper fpr = DeveloperConverter.convertDeveloperToBinder(dd);
                removeDeveloper(fpr);
                developersGrid.removeSelectedData();

            }
        });
        return removeButton;
    }

    public IButton createButtonUpdate(final ListGrid developersGrid) {
        IButton removeButton = new IButton("Update");
        removeButton.setTop(250);
        removeButton.setLeft(330);
        removeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                developersGrid.saveAllEdits();
                DeveloperRecord dd = (DeveloperRecord) developersGrid.getSelectedRecord();
                BinderDeveloper fpr = DeveloperConverter.convertDeveloperToBinder(dd);
                System.out.println(fpr.getId() + " " + fpr.getDeveloperFirstName().toString());

                updateDeveloper(fpr);
            }
        });
        return removeButton;
    }


    public Canvas ReturnDevelopersCanvas() {
        onModuleLoad();
        return canvas;
    }

    private void removeDeveloper(BinderDeveloper fooDeveloper) {
        BinderServiceAsync projectService = (BinderServiceAsync) GWT.create(BinderService.class);

        AsyncCallback callback = new AsyncCallback() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(Object result) {
            }
        };
        projectService.removeDeveloper(fooDeveloper, callback);
    }

    private void updateDeveloper(BinderDeveloper fooDeveloper) {
        BinderServiceAsync projectService = (BinderServiceAsync) GWT.create(BinderService.class);

        AsyncCallback callback = new AsyncCallback() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(Object result) {
            }
        };
        projectService.updateDeveloper(fooDeveloper, callback);
    }

    private void editDeveloper(BinderDeveloper fooDeveloper) {
        BinderServiceAsync projectService = (BinderServiceAsync) GWT.create(BinderService.class);

        AsyncCallback callback = new AsyncCallback() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(Object result) {
            }
        };
        projectService.addNewDeveloper(fooDeveloper, callback);
    }

    private void initDataSource() {
        BinderServiceAsync projectService = (BinderServiceAsync) GWT.create(BinderService.class);

        AsyncCallback callback = new AsyncCallback<ArrayList<BinderDeveloper>>() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(ArrayList<BinderDeveloper> result) {
                dataSource = DeveloperItemList.getNewRecords(result);
                onReady();
            }
        };
        projectService.selectAllDevelopers(callback);
    }

}

