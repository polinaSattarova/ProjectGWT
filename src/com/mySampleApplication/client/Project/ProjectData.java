package com.mySampleApplication.client.Project;

class ProjectData {

    private static ProjectRecord[] records;

    public static ProjectRecord[] getRecords() {
        if (records == null) {
            records = getNewRecords();
        }
        return records;
    }

    public static ProjectRecord[] getNewRecords() {
        int ind = 1;
        return new ProjectRecord[] {
                new ProjectRecord(
                        ind++,
                        "ProjectName1",
                        "ProjectShortName1",
                        "Description1"),
                new ProjectRecord(
                        ind++,
                        "ProjectName2",
                        "ProjectShortName2",
                        "Description2"),
                new ProjectRecord(
                        ind++,
                        "ProjectName3",
                        "ProjectShortName3",
                        "Description3"),
                new ProjectRecord(
                        ind++,
                        "ProjectName4",
                        "ProjectShortName4",
                        "Description4"),
                new ProjectRecord(
                        ind++,
                        "ProjectName5",
                        "ProjectShortName5",
                        "Description5"),
                new ProjectRecord(
                        ind++,
                        "ProjectName6",
                        "ProjectShortName6",
                        "Description6"),
                new ProjectRecord(
                        ind++,
                        "ProjectName7",
                        "ProjectShortName7",
                        "Description7"),
                new ProjectRecord(
                        ind++,
                        "ProjectName8",
                        "ProjectShortName8",
                        "Description8"),};
    }
}

