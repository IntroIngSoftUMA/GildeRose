package org.iis.gildedrose.objectoriented;

class GildedRose {
  UpdatableItem[] items;

  public GildedRose(UpdatableItem[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (UpdatableItem item : items) {
      item.update();
    }
  }
}
