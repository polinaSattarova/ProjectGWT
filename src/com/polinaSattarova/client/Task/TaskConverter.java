package com.polinaSattarova.client.Task;

import com.polinaSattarova.client.Binder.BinderTask;

public class TaskConverter {


    public static TaskRecord convertBinderToTask(BinderTask instanceTask){

        TaskRecord taskRecord = new TaskRecord();
        taskRecord.setIndex(instanceTask.getId());
        taskRecord.setProjectName(instanceTask.getProject());
        taskRecord.setWorkTime(instanceTask.getTimeForWork());
        taskRecord.setNameField(instanceTask.getName());
        taskRecord.setStartDateField(instanceTask.getStartDate());
        taskRecord.setEndDateField(instanceTask.getEndDate());
        taskRecord.setStateField(instanceTask.getState());
        taskRecord.setDeveloperField(instanceTask.getDeveloper());

        return taskRecord;
    }
    public static BinderTask convertTaskToBinder(TaskRecord taskRecord){

        BinderTask instanceTask = new BinderTask();
        instanceTask.setId(taskRecord.getIndex());
        instanceTask.setProject(taskRecord.getProjectName());
        instanceTask.setName(taskRecord.getNameField());
        instanceTask.setTimeForWork(taskRecord.getWorkTime());
        instanceTask.setStartDate(taskRecord.getStartDateField());
        instanceTask.setEndDate(taskRecord.getEndDateField());
        instanceTask.setState(taskRecord.getStateField());
        instanceTask.setDeveloper(taskRecord.getDeveloperField());

        return instanceTask;
    }



}
