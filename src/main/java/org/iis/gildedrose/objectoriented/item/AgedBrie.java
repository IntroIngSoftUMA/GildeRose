package org.iis.gildedrose.objectoriented.item;

import org.iis.gildedrose.objectoriented.UpdatableItem;

public class AgedBrie extends UpdatableItem {
  public AgedBrie(int sellIn, int quality) {
    super("Aged brie", sellIn, quality);
  }

  @Override
  public void update() {
    increaseQuality();
    decreaseSellIn();
    if (hasExpired()) {
      increaseQuality();
    }
  }
}
