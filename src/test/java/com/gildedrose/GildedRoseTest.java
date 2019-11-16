package com.gildedrose;

import static org.junit.Assert.*;

import cucumber.api.java.bs.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GildedRoseTest {

    @Test
    public void foo() {
        //ArrayList<Item> items = new ArrayList<>(Arrays.asList( new Item("foo", 0, 0) ));
        GildedRose app = new GildedRose();
        app.add_item(new Item("foo",0,0));
        app.updateQuality();
        assertEquals("foo", app.items.get(0).getName());
    }
    @Test
    public void items_can_be_added_after_instantiation(){
        GildedRose app = new GildedRose();
        Item item = new Item("something_fun",2,4);
        app.add_item(item);
        assertEquals(1,app.items.size());
        assertEquals("something_fun", app.items.get(0).name);
    }

}
