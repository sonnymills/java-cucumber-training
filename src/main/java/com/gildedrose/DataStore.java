package com.gildedrose;

import java.util.ArrayList;
import java.util.HashMap;

public final class DataStore {
    private static DataStore dataStoreInstance;
    private static HashMap<String, Object> dataObjects;
    private DataStore(){
    }
   public static DataStore getDataStoreInstance(){
       if (dataObjects == null) {
           dataObjects = new HashMap<>();
       }
       if (dataStoreInstance == null){
           dataStoreInstance = new DataStore();
       }
       return dataStoreInstance;
   }

    public ArrayList<String> getKeys() {
        return new ArrayList<>();
    }

    public void addObject(String key, Object object) {
        dataObjects.put(key,object);
    }

    public Object getObject(String key) {
        return dataObjects.get(key);
    }
}
