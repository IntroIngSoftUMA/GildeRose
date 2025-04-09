package org.iis.gildedrose.objectoriented;

public abstract class UpdatableItem extends Item {
  public UpdatableItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public abstract void update();

  protected void increaseQuality() {
    if (quality < 50) {
      quality = quality + 1;
    }
  }

  protected void decreaseSellIn() {
    sellIn = sellIn - 1;
  }

  protected boolean hasExpired() {
    return sellIn < 0;
  }

  protected void decreaseQuality() {
    if (quality > 0) {
      quality = quality - 1;
    }
  }
}
