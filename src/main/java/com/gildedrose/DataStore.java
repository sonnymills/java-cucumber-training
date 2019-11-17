package com.gildedrose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class DataStore {
    private static DataStore dataStoreInstance;
    private static HashMap<String, Object> dataObjects;
    private DataStore(){
    }
   public static DataStore getDataStoreInstance(Boolean resetData){
       return getDataStore(resetData);
   }
    public static DataStore getDataStoreInstance(){
        return getDataStore(false);
    }

    private static DataStore getDataStore(Boolean resetData) {
        if (dataObjects == null || resetData) {
            resetDataStore();
        }
        if (dataStoreInstance == null){
            dataStoreInstance = new DataStore();
        }
        return dataStoreInstance;
    }

    public static void resetDataStore() {
        dataObjects = new HashMap<>();
    }

    public ArrayList<String> getKeys() {
        return new ArrayList<>();
    }

    public void addObject(String key, Object object) {
        dataObjects.put(key,object);
    }

    public Object getObject(String key) {
        if (!dataObjects.containsKey(key)){
        }
        return dataObjects.get(key);
    }

    public List<Object> getObjectList() {
        List<Object> objectList = new ArrayList<Object>(dataObjects.values());
        return objectList;
    }
}
