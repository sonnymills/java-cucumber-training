package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class GildedRoseTest {

    @Test
    public void gildrose_update_does_not_cause_concurrency_error() {
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
    @Test
    public void the_application_understands_time(){
        GildedRose app = new GildedRose();
        String today = LocalDate.now().toString();
        assertEquals(today, app.getTodaysDate());
    }
    @Test
    public void the_application_can_be_set_to_a_future_date(){
        GildedRose app = new GildedRose();
        LocalDate today = LocalDate.now();
        assertEquals(today.toString(), app.getTodaysDate());
        Long oneDay = Long.valueOf(1);
        LocalDate tomorrow = today.plusDays(oneDay);
        app.setCurrentDate(tomorrow);
        assertEquals(tomorrow.toString(),app.getTodaysDate());
    }

}
