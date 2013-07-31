package com.polinaSattarova.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.polinaSattarova.client.Developer.DevelopersList;
import com.polinaSattarova.client.Project.ProjectsTable;
import com.polinaSattarova.client.Task.TaskList;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;

public class PolinaSattarova implements EntryPoint {


    public PolinaSattarova() {
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

//           menuCommandEmptyInbox();
        vPanel.add(new Button("Projects menu   ",new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {

                NewWindow("Projects menu", new ProjectsTable().ReturnProjectCanvas());
            }
        }));
           vPanel.add(new Button("Tasks menu", new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                  NewWindow("Tasks menu", new TaskList().ReturnTaskCanvas());
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


