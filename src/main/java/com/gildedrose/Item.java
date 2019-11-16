package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
    public String getName(){
        return this.name;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQuality(int qualityValue) {
        this.quality = qualityValue;
    }

    public void updateSellIn(int sellInValue) {
        this.sellIn = sellInValue;
    }
}
