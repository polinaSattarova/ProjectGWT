package com.mySampleApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.i18n.client.Constants;
import com.mySampleApplication.client.Developer.DevelopersList;
import com.mySampleApplication.client.Project.ProjectsTable;
import com.mySampleApplication.client.Task.TaskList;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
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
       private Label label;
       public void onModuleLoad() {
           TabSet tabSet = new TabSet();
           tabSet.setWidth(580);
           tabSet.setHeight(400);

           Tab smartTab1 = new Tab("Main menu ");
           Canvas tabPane1 = new Canvas();
           tabPane1.setWidth100();
           tabPane1.setHeight100();
           tabPane1.addChild(getGwtTab());
           smartTab1.setPane(tabPane1);


           tabSet.draw();
       }

    private Widget getGwtTab() {
        DecoratedTabPanel tabPanel = new DecoratedTabPanel();
        tabPanel.setWidth("750px");
        tabPanel.setAnimationEnabled(true);

        VerticalPanel pPanel = new VerticalPanel();
        pPanel.setHeight("650px");
        pPanel.setSpacing(15);
        HTML homeText = new HTML("This is List of project.");
        pPanel.add(homeText);
        Canvas canvasP = new ProjectsTable().ReturnProjectCanvas();
        pPanel.add(canvasP);

        tabPanel.add(pPanel, "Project's menu");

        VerticalPanel tPanel = new VerticalPanel();
        HTML homeText1 = new HTML("This is List of task.");

        tPanel.add(homeText1);
        Canvas canvasT = new TaskList().ReturnTaskCanvas();
        tPanel.add(canvasT);

        VerticalPanel dPanel = new VerticalPanel();
        HTML homeText2 = new HTML("This is List of developers.");
        dPanel.add(homeText2);
        Canvas canvasD = new DevelopersList().ReturnDevelopersCanvas();
        dPanel.add(canvasD);

        tabPanel.add(tPanel, "Task's menu");
        tabPanel.add(dPanel, "Developer's menu");


        tabPanel.selectTab(0);
        tabPanel.ensureDebugId("cwTabPanel");
        return tabPanel;
    }
        /*
           label = new Label();
           label.setContents("Main");
           label.setAlign(Alignment.CENTER);
           label.setOverflow(Overflow.HIDDEN);
        // Create a Vertical Panel
        VerticalPanel vPanel = new VerticalPanel();
        vPanel.setSpacing(3);
        vPanel.setSize("70px", "50px");


        vPanel.add(new Button("Projects menu   ",new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
               new ProjectsTable().onModuleLoad();
            }
        }));
           vPanel.add(new Button("Task menu", new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                  new TaskList().onModuleLoad();
            }
        }));
        vPanel.add(new Button("Developers menu", new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                new DevelopersList().onModuleLoad();
            }
        }));

        // Return the content
        vPanel.ensureDebugId("cwVerticalPanel");

        DecoratorPanel decoratorPanel = new DecoratorPanel();
        decoratorPanel.add(vPanel);

        // Add the widgets to the root panel.
           RootPanel.get().add(label);
        RootPanel.get().add(decoratorPanel);
            */

}


