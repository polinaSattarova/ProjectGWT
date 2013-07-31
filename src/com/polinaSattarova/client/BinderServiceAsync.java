package com.polinaSattarova.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.polinaSattarova.client.Binder.BinderDeveloper;
import com.polinaSattarova.client.Binder.BinderProject;
import com.polinaSattarova.client.Binder.BinderTask;

import java.util.List;

public interface BinderServiceAsync {

    void selectAllProjects( AsyncCallback<List<BinderProject>> async);

    void removeProject(BinderProject fpr, AsyncCallback<Void> async);

    void updateProject(BinderProject fpr, AsyncCallback<Void> async);

    void addNewProject(BinderProject fpr, AsyncCallback<Void> async);

    void selectAllDevelopers(AsyncCallback<List<BinderDeveloper>> async);

    void removeDeveloper(BinderDeveloper fpr, AsyncCallback<Void> async);

    void updateDeveloper(BinderDeveloper fpr, AsyncCallback<Void> async);

    void addNewDeveloper(BinderDeveloper fpr, AsyncCallback<Void> async);


    void selectAllTasks(AsyncCallback<List<BinderTask>> async);

    void removeTask(BinderTask fpr, AsyncCallback<Void> async);

    void updateTask(BinderTask fpr, AsyncCallback<Void> async);

    void addNewTask(BinderTask fpr, AsyncCallback<Void> async);

    void selectShortDevelopersList(AsyncCallback<List<String>> async);

    void selectShortProjectsList(AsyncCallback<List<String>> async);
}
