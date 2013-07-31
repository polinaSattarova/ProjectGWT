package com.polinaSattarova.client.Developer;

import com.polinaSattarova.client.Binder.BinderDeveloper;

import java.util.ArrayList;

public class DeveloperItemList {

    public static DeveloperRecord[] getNewRecords(ArrayList<BinderDeveloper> arrayListFoo) {

        DeveloperRecord[] developerRecordList = new DeveloperRecord[arrayListFoo.size()];
        Integer i = 0;
        for (BinderDeveloper instanceDeveloper : arrayListFoo) {
            developerRecordList[i] = (DeveloperConverter.convertBinderToDeveloper(instanceDeveloper));
            i++;
        }
        return developerRecordList;
    }
}