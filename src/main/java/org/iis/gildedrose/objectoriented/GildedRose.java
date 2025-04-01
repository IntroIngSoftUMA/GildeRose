package org.iis.gildedrose.objectoriented;

class GildedRose {
  public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  public static final String AGED_BRIE = "Aged Brie";

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      updateItemQuality(item);
    }
  }

  private void updateItemQuality(Item item) {
    switch (item.name) {
      case AGED_BRIE -> {
        increaseQuality(item);
        decreaseSellIn(item);
        if (hasExpired(item)){
          increaseQuality(item);
        }}
      case BACKSTAGE_PASS -> {
        increaseQuality(item);

        if (item.sellIn < 11) {
          increaseQuality(item);
        }

        if (item.sellIn < 6) {
          increaseQuality(item);
        }
        decreaseSellIn(item);

        if (hasExpired(item)) {
          item.quality = 0;
        }
      }
      case SULFURAS -> {
        // Do nothing
      }
      default -> {
        decreaseQuality(item);
        decreaseSellIn(item);
        if (hasExpired(item)) {
          decreaseQuality(item);
        }
      }
    }
  }

  private boolean hasExpired(Item item) {
    return item.sellIn < 0;
  }

  private void increaseQuality(Item item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;
    }
  }

  private void decreaseQuality(Item item) {
    if (item.quality > 0) {
      item.quality = item.quality - 1;
    }
  }

  private void decreaseSellIn(Item item) {
    item.sellIn = item.sellIn - 1;
  }
}
