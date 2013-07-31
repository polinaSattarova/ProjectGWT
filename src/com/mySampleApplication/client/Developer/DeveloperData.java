package com.mySampleApplication.client.Developer;

/**
 * Created with IntelliJ IDEA.
 * User: Polina
 * Date: 15.06.13
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
class DeveloperData {

    private static DeveloperRecord[] records;


    public static DeveloperRecord[] getRecords() {
        if (records == null) {
            records = getNewRecords();
        }
        return records;
    }

    public static DeveloperRecord[] getNewRecords() {
        int ind = 1;
        return new DeveloperRecord[] {
                new DeveloperRecord(
                        ind++,
                        "Name1",
                        "Last1",
                        "Middle1",
                        "Position1"),
                new DeveloperRecord(
                        ind++,
                        "Name2",
                        "Last2",
                        "Middle2",
                        "Position2"),
                new DeveloperRecord(
                        ind++,
                        "Name3",
                        "Last3",
                        "Middle3",
                        "Position3"),
                new DeveloperRecord(
                        ind++,
                        "Name4",
                        "Last4",
                        "Middle4",
                        "Position4"),
                new DeveloperRecord(
                        ind++,
                        "Name5",
                        "Last5",
                        "Middle5",
                        "Position5"),
                new DeveloperRecord(
                        ind++,
                        "Name6",
                        "Last6",
                        "Middle6",
                        "Position6"),

        };
    }
}