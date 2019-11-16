package com.gildedrose;

import cucumber.api.java.bs.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class RepositoryTest {

    @Test
    public void repository_starts_without_objects(){
        DataStore ds = DataStore.getDataStoreInstance();
        assertEquals(0,ds.getKeys().size());
    }
    @Test
    public void datastore_can_store_a_simple_string(){
        DataStore ds = DataStore.getDataStoreInstance();
        ds.addObject("thisString","wow");
        assertEquals("wow",ds.getObject("thisString"));
    }
    @Test
    public void datastore_instances_return_same_thing(){
        DataStore dsAdd = DataStore.getDataStoreInstance();
        dsAdd.addObject("thisString","wow");
        DataStore dsGet = DataStore.getDataStoreInstance();
        assertEquals("wow",dsGet.getObject("thisString"));
    }
    @Test
    public void complex_object_survives_across_instances(){
        DataStore dsAdd = DataStore.getDataStoreInstance();
        ComplexThing thing = new ComplexThing();
        dsAdd.addObject("complexThing",thing);
        thing.setName("bob");
        DataStore dsGet = DataStore.getDataStoreInstance();
        ComplexThing thingUpdated = (ComplexThing) dsGet.getObject("complexThing");
        assertEquals("bob", thingUpdated.getName());


    }
    private class ComplexThing{
        private String name;
        public List<String> data = new ArrayList<>();
        public ComplexThing(){
            data = new ArrayList<>(Arrays.asList("a","b","c"));
        }
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
    }
}
