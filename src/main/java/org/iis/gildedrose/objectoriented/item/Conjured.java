package org.iis.gildedrose.objectoriented.item;

import org.iis.gildedrose.objectoriented.UpdatableItem;

public class Conjured extends UpdatableItem {
    public Conjured(int sellIn, int quality) {
        super("Sulfuras", sellIn, quality);
    }

    @Override
    public void update() {
        decreaseQuality();
        decreaseSellIn();
        if (hasExpired()) {
            decreaseQuality();
        }
    }

    @Override
    protected void decreaseQuality() {
        if (quality >= 2) {
            quality = quality - 2;
        } else {
            quality = 0 ;
        }
    }
}
