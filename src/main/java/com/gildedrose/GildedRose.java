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
        ListIterator<Item> itemIterator = items.listIterator();
        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.updateQuality(item.quality - 1);
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.updateQuality(item.quality + 1);
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.updateQuality(item.quality + 1);
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.updateSellIn( item.sellIn - 1);
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.updateQuality(item.quality - 1);
                            }
                        }
                    } else {
                        item.updateQuality( item.quality - item.quality);
                    }
                } else {
                    if (item.quality < 50) {
                        item.updateQuality(item.quality + 1);
                    }
                }
            }
        }
    }

    public void add_item(Item item) {
        items.add(item);
    }
}