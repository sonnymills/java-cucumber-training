package com.gildedrose;

import java.util.*;

public class GildedRose {
    public ArrayList<Item> items = new ArrayList<>();

    public GildedRose(ArrayList<Item> items) {
        this.items = items;
    }

    // this constructor is here so that tests can inject
    // items for testing after instantiation
    public GildedRose(){}

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseItemQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQualityForBackstagePasses(item);
        } else {
            decreaseItemQuality(item);
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.updateSellIn( item.sellIn - 1);
        }

        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                increaseItemQuality(item);increaseItemQuality(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.updateQuality(0);
            } else {
                decreaseItemQuality(item);
            }
        }
    }

    private void increaseQualityForBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 11) {
                    increaseItemQuality(item);
                }

                if (item.sellIn < 6) {
                    increaseItemQuality(item);
                }
            }
        }
    }

    private void decreaseItemQuality(Item item) {
        if (item.quality > 0) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.updateQuality(item.quality - 1);
            }
        }
    }

    private void increaseItemQuality(Item item) {
        if (item.quality < 50) {
            item.updateQuality(item.quality + 1);
        }
    }

    public void add_item(Item item) {
        items.add(item);
    }

    public String getTodaysDate() {
        DataStore ds = DataStore.getDataStoreInstance();
        return ds.getToday().toString();
    }

}