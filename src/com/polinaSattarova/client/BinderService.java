package com.polinaSattarova.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.polinaSattarova.client.Binder.BinderDeveloper;
import com.polinaSattarova.client.Binder.BinderProject;
import com.polinaSattarova.client.Binder.BinderTask;

import java.util.List;

@RemoteServiceRelativePath("mdb")
public interface BinderService extends RemoteService {
    public List<BinderProject> selectAllProjects();
    public void removeProject(BinderProject fpr);
    public void updateProject(BinderProject fpr);
    public void addNewProject(BinderProject fpr);

    public List<BinderDeveloper> selectAllDevelopers();
    public void removeDeveloper(BinderDeveloper fpr);
    public void updateDeveloper(BinderDeveloper fpr);
    public void addNewDeveloper(BinderDeveloper fpr);

    public List<BinderTask> selectAllTasks();
    public void removeTask(BinderTask fpr);
    public void updateTask(BinderTask fpr);
    public void addNewTask(BinderTask fpr);
    public List<String> selectShortDevelopersList();
    public List<String> selectShortProjectsList();
}
