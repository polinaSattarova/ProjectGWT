package com.mySampleApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.i18n.client.Constants;
import com.mySampleApplication.client.Developer.DevelopersList;
import com.mySampleApplication.client.Project.ProjectsTable;
import com.mySampleApplication.client.Task.TaskList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.tab.Tab;

import com.smartgwt.client.widgets.tab.TabSet;

public class MySampleApplication implements EntryPoint {


    public MySampleApplication() {
        constants = null;
    }

    public static interface CwConstants extends Constants {
        String cwVerticalPanelButton();

        String cwVerticalPanelDescription();

        String cwVerticalPanelName();
    }

    public CwConstants constants;

       public void onModuleLoad() {

        VerticalPanel vPanel = new VerticalPanel();
        vPanel.setSpacing(3);


        vPanel.add(new Button("Projects menu   ",new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {

                NewWindow("Projects menu", new ProjectsTable().ReturnProjectCanvas());//new ProjectsTable().onModuleLoad();
            }
        }));
           vPanel.add(new Button("Task menu", new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                  NewWindow("Task menu", new TaskList().ReturnTaskCanvas());//new TaskList().onModuleLoad();
            }
        }));
        vPanel.add(new Button("Developers menu", new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                NewWindow("Developers menu", new DevelopersList().ReturnDevelopersCanvas());
            }
        }));

        vPanel.ensureDebugId("cwVerticalPanel");
        vPanel.setSize("100px", "50px");

           DecoratorPanel decoratorPanel = new DecoratorPanel();
           decoratorPanel.setSize("100px", "50px");
        decoratorPanel.add(vPanel);

        RootPanel.get().add(decoratorPanel);

       }
    private void NewWindow(String title, Canvas canvas){
        final Window winModal = new Window();
        winModal.setAutoSize(true);
        winModal.setTitle(title);
        winModal.setIsModal(true);
        winModal.setShowModalMask(true);
        winModal.setAutoCenter(Boolean.TRUE);
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
        form.addChild(canvas);
        winModal.addItem(form);
        winModal.show();

    }
}


