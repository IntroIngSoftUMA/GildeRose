package org.iis.gildedrose.objectoriented.item;

import org.iis.gildedrose.objectoriented.UpdatableItem;

public class Normal extends UpdatableItem {
    public Normal(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseQuality();
        decreaseSellIn();
        if (hasExpired()) {
            decreaseQuality();
        }
    }
}
