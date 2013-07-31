package com.mySampleApplication.client.Task;

import java.util.Date;

class TaskData {

    private static TaskRecord[] records;


    public static TaskRecord[] getRecords() {
        if (records == null) {
            records = getNewRecords();
        }
        return records;
    }

    public static TaskRecord[] getNewRecords() {
        int ind = 1;
        return new TaskRecord[] {
                new TaskRecord(
                        ind++,
                        "project1",
                        "task1",
                        new Date(2013, 6, 4),
                        new Date(3013, 6, 6),
                        "state1",
                        "developer1") ,
                new TaskRecord(
                        ind++,
                        "project2",
                        "task2",
                        new Date(2013, 6, 4),
                        new Date(3013, 6, 6),
                        "state2",
                        "developer2") ,
                new TaskRecord(
                        ind++,
                        "project3",
                        "task3",
                        new Date(2013, 6, 4),
                        new Date(3013, 6, 6),
                        "state3",
                        "developer3") ,
                new TaskRecord(
                        ind++,
                        "project4",
                        "task4",
                        new Date(2013, 6, 4),
                        new Date(3013, 6, 6),
                        "state4",
                        "developer4") ,

        };
    }
}

