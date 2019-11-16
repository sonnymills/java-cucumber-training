package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.app.controller.InventoryController.getItems;
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
    @Test
    public void can_update_item_quality(){
        Item item = new Item("thing",1,4);
        item.updateQuality(item.quality -1 );
        assertEquals(3,item.quality);
    }
    @Test
    public void can_update_item_sell_in(){
        Item item = new Item("thing",1,4);
        item.updateSellIn(item.sellIn -1 );
        assertEquals(0,item.sellIn);

    }

}