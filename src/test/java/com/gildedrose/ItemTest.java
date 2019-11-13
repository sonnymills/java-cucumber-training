package com.gildedrose;

import org.junit.Test;

import static gildedrose.GildedRoseController.getItems;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void an_item_can_return_its_name(){
        Item item = new Item("thing1",3,3);
        assertEquals("thing1",item.name);
    }
    @Test
    public void a_list_of_items_has_names_still(){
        Item[] items = getItems();
        assertEquals("thing1",items[0].name);
        assertEquals("thing2",items[1].name);
    }

}