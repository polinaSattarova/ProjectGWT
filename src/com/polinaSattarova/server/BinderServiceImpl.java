package com.polinaSattarova.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.polinaSattarova.client.Binder.BinderTask;
import com.polinaSattarova.client.BinderService;
import com.polinaSattarova.client.Binder.BinderDeveloper;
import com.polinaSattarova.client.Binder.BinderProject;
import com.polinaSattarova.server.DAO.ConnectDB;
import com.polinaSattarova.server.DAO.InstanceDeveloper;
import com.polinaSattarova.server.DAO.InstanceProject;
import com.polinaSattarova.server.DAO.InstanceTask;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class BinderServiceImpl extends RemoteServiceServlet implements
        BinderService {
    @Override
    public List<BinderProject> selectAllProjects() {
        ConnectDB myConnect = new ConnectDB();
        ArrayList<InstanceProject> instanceProjectList = myConnect.selectAllProjects();

        ArrayList<BinderProject> projectRecordList = new ArrayList<BinderProject>(instanceProjectList.size());
        for (InstanceProject instanceProject: instanceProjectList)
        {
            projectRecordList.add(new BinderProject(instanceProject.getId(), instanceProject.getFullName(), instanceProject.getShortName(), instanceProject.getDescription()));
        }
        myConnect.close();
        return projectRecordList;

    }

    @Override
    public void removeProject(BinderProject fpr) {
        ConnectDB myConnect = new ConnectDB();
        InstanceProject instanceProject = new InstanceProject(fpr.getId(), fpr.getFullName(), fpr.getShortName(), fpr.getDescription());
        myConnect.deleteProject(instanceProject);
        myConnect.close();
    }
    @Override
    public void updateProject(BinderProject fpr) {
        ConnectDB myConnect = new ConnectDB();
        InstanceProject instanceProject = new InstanceProject(fpr.getId(), fpr.getFullName(), fpr.getShortName(), fpr.getDescription());
        myConnect.updateProject(instanceProject);
        myConnect.close();
    }
    @Override
    public void addNewProject(BinderProject fpr) {
        ConnectDB myConnect = new ConnectDB();
        InstanceProject instanceProject = new InstanceProject(fpr.getId(), fpr.getFullName(), fpr.getShortName(), fpr.getDescription());
        myConnect.editNewProject(instanceProject);
        myConnect.close();
    }

    @Override
    public List<BinderDeveloper> selectAllDevelopers() {
        ConnectDB myConnect = new ConnectDB();
        ArrayList<InstanceDeveloper> instanceDevelopersList = myConnect.selectAllDevelopers();

        ArrayList<BinderDeveloper> developerRecordList = new ArrayList<BinderDeveloper>(instanceDevelopersList.size());
        for (InstanceDeveloper instanceDeveloper: instanceDevelopersList)
        {
            developerRecordList.add(new BinderDeveloper(instanceDeveloper.getId(), instanceDeveloper.getLastName(), instanceDeveloper.getFirstName(), instanceDeveloper.getMiddleName(), instanceDeveloper.getPosition()));
        }
        myConnect.close();
        return developerRecordList;


    }

    @Override
    public void removeDeveloper(BinderDeveloper fpr) {
        ConnectDB myConnect = new ConnectDB();
        InstanceDeveloper instanceDeveloper = new InstanceDeveloper(fpr.getId(), fpr.getDeveloperLastName(), fpr.getDeveloperFirstName(), fpr.getDeveloperMiddleName(), fpr.getDeveloperPosition());
        myConnect.deleteDeveloper(instanceDeveloper);
        myConnect.close();
    }
    @Override
    public void updateDeveloper(BinderDeveloper fpr) {
        ConnectDB myConnect = new ConnectDB();
        InstanceDeveloper instanceDeveloper = new InstanceDeveloper(fpr.getId(), fpr.getDeveloperLastName(), fpr.getDeveloperFirstName(), fpr.getDeveloperMiddleName(), fpr.getDeveloperPosition());
        myConnect.updateDeveloper(instanceDeveloper);
        myConnect.close();
    }
    @Override
    public void addNewDeveloper(BinderDeveloper fpr) {
        ConnectDB myConnect = new ConnectDB();
        InstanceDeveloper instanceDeveloper = new InstanceDeveloper(fpr.getId(), fpr.getDeveloperLastName(), fpr.getDeveloperFirstName(), fpr.getDeveloperMiddleName(), fpr.getDeveloperPosition());
        myConnect.editNewDeveloper(instanceDeveloper);
        myConnect.close();
    }

    @Override
    public List<BinderTask> selectAllTasks() {
        ConnectDB myConnect = new ConnectDB();
        ArrayList<InstanceTask> instanceTasksList = myConnect.selectAllTasks();

        ArrayList<BinderTask> taskRecordList = new ArrayList<BinderTask>(instanceTasksList.size());
        for (InstanceTask instanceTask: instanceTasksList)
        {
            taskRecordList.add(new BinderTask(instanceTask.getId(), instanceTask.getProject(), instanceTask.getName(), instanceTask.getTimeForWork(), instanceTask.getStartDate(), instanceTask.getEndDate(), instanceTask.getState(), instanceTask.getDeveloper()));
        }
        myConnect.close();
        return taskRecordList;

    }

    @Override
    public void removeTask(BinderTask fpr) {
        ConnectDB myConnect = new ConnectDB();
        InstanceTask instanceTask = new InstanceTask(fpr.getId(), fpr.getProject(), fpr.getName(), fpr.getTimeForWork(), (Date)fpr.getStartDate(), (Date) fpr.getEndDate(), fpr.getState(), fpr.getDeveloper());
        myConnect.deleteTask(instanceTask);
        myConnect.close();
    }
    @Override
    public void updateTask(BinderTask fpr) {
        ConnectDB myConnect = new ConnectDB();
        InstanceTask instanceTask = new InstanceTask(fpr.getId(), fpr.getProject(), fpr.getName(), fpr.getTimeForWork(), (Date)fpr.getStartDate(), (Date) fpr.getEndDate(), fpr.getState(), fpr.getDeveloper());
        myConnect.updateTask(instanceTask);
        myConnect.close();
    }
    @Override
    public void addNewTask(BinderTask fpr) {
        ConnectDB myConnect = new ConnectDB();
        InstanceTask instanceTask = new InstanceTask(fpr.getId(), fpr.getProject(), fpr.getName(), fpr.getTimeForWork(), (Date)fpr.getStartDate(), (Date) fpr.getEndDate(), fpr.getState(), fpr.getDeveloper());
        myConnect.editNewTask(instanceTask);
        myConnect.close();
    }

    @Override
    public ArrayList<String> selectShortDevelopersList() {
        ConnectDB myConnect = new ConnectDB();
        ArrayList<String[]> shortDevelopersList = myConnect.selectShortDevelopersList();

        ArrayList<String> shortDevelopersListToString = new ArrayList<String>(shortDevelopersList.size());
        for (String[] shortList: shortDevelopersList)
        {
            shortDevelopersListToString.add(shortList[0]+" "+shortList[1]);
        }
        myConnect.close();
        return shortDevelopersListToString;


    }

    @Override
    public ArrayList<String> selectShortProjectsList() {
        ConnectDB myConnect = new ConnectDB();
        ArrayList<String> shortProjectsList = myConnect.selectShortProjectsList();
        myConnect.close();
        return shortProjectsList;
    }

}