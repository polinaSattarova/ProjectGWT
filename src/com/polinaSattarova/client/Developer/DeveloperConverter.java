package com.polinaSattarova.client.Developer;

import com.polinaSattarova.client.Binder.BinderDeveloper;

public class DeveloperConverter {


    public static DeveloperRecord convertBinderToDeveloper(BinderDeveloper instanceDeveloper){

        DeveloperRecord developerRecord = new DeveloperRecord();
        developerRecord.setIndex(instanceDeveloper.getId());
        developerRecord.setLastName(instanceDeveloper.getDeveloperLastName());
        developerRecord.setFirstName(instanceDeveloper.getDeveloperFirstName());
        developerRecord.setMiddleName(instanceDeveloper.getDeveloperMiddleName());
        developerRecord.setPosition(instanceDeveloper.getDeveloperPosition());

        return developerRecord;
    }
    public static BinderDeveloper convertDeveloperToBinder(DeveloperRecord developerRecord){

        BinderDeveloper instanceDeveloper = new BinderDeveloper();
        instanceDeveloper.setId(developerRecord.getIndex());
        instanceDeveloper.setDeveloperLastName(developerRecord.getLastName());
        instanceDeveloper.setDeveloperFirstName(developerRecord.getFirstName());
        instanceDeveloper.setDeveloperMiddleName(developerRecord.getMiddleName());
        instanceDeveloper.setDeveloperPosition(developerRecord.getPosition());

        return instanceDeveloper;
    }



}
