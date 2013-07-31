package com.polinaSattarova.client.Task;


import com.polinaSattarova.client.Binder.BinderTask;

import java.util.ArrayList;

public class TaskItemList {

    public static TaskRecord[] getNewRecords(ArrayList<BinderTask> arrayListFoo) {

        TaskRecord[] taskRecordList = new TaskRecord[arrayListFoo.size()];
        Integer i = 0;
        for (BinderTask instanceTask : arrayListFoo) {
            taskRecordList[i] = (TaskConverter.convertBinderToTask(instanceTask));
            i++;
        }
        return taskRecordList;
    }
}