package org.iis.gildedrose.refactored;

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
      updateItem(item);
    }
  }

  private void updateItem(Item item) {
    switch (item.name) {
      case SULFURAS -> {}
      case AGED_BRIE -> {
        increaseQuality(item);
        decreaseSellIn(item) ;
        if (hasExpired(item)) {
          increaseQuality(item);
        }
      }
      case BACKSTAGE_PASS -> {
        increaseQuality(item);

        if (item.sellIn < 11) {
          increaseQuality(item);
        }

        if (item.sellIn < 6) {
          increaseQuality(item);
        }
        decreaseSellIn(item) ;
        if (hasExpired(item)) {
          item.quality = 0 ;
        }
      }
      default -> {
        decreaseQuality(item);
        decreaseSellIn(item) ;
        if (hasExpired(item)) {
          decreaseQuality(item);
        }
      }
    }
  }

  private void decreaseSellIn(Item item) {
      item.sellIn = item.sellIn - 1;
  }

  private void decreaseQuality(Item item) {
    if (item.quality > 0) {
      item.quality = item.quality - 1;
    }
  }

  private void increaseQuality(Item item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;
    }
  }

  private boolean hasExpired(Item item) {
    return item.sellIn < 0;
  }
}
