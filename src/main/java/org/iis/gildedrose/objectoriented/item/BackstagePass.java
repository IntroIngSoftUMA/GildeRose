package org.iis.gildedrose.objectoriented.item;

import org.iis.gildedrose.objectoriented.UpdatableItem;

public class BackstagePass extends UpdatableItem {
  public BackstagePass(int sellIn, int quality) {
    super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
  }

  @Override
  public void update() {
    increaseQuality();

    if (sellIn < 11) {
      increaseQuality();
    }

    if (sellIn < 6) {
      increaseQuality();
    }
    decreaseSellIn();

    if (hasExpired()) {
      quality = 0;
    }
  }
}
