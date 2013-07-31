package com.polinaSattarova.client.Project;

import com.polinaSattarova.client.Binder.BinderProject;

public class ProjectConverter {


    public static ProjectRecord convertBinderToRecord(BinderProject instanceProject){

        ProjectRecord projectRecord = new ProjectRecord();
        projectRecord.setIndex(instanceProject.getId());
        projectRecord.setProjectFullName(instanceProject.getFullName());
        projectRecord.setProjectShortName(instanceProject.getShortName());
        projectRecord.setDescription(instanceProject.getDescription());

        return projectRecord;
    }
    public static BinderProject convertRecordToBinder(ProjectRecord projectRecord){

        BinderProject instanceProject = new BinderProject();
        instanceProject.setId(projectRecord.getIndex());
        instanceProject.setFullName(projectRecord.getProjectFullName());
        instanceProject.setShortName(projectRecord.getProjectShortName());
        instanceProject.setDescription(projectRecord.getDescription());

        return instanceProject;
    }



}
