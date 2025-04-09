/*
 * Introducción a la Ingeniería del Software. UMA
 * Posible solución a la kata de refactorización Gilded Rose
 *
 * 20/03/2025
 * Pablo López
 */

package org.iis.gildedrose.lab4;

/* Pasos pendientes:

  1. extraer decreaseQuality(item) (similar a increaseQuality(item))
  2. evitar los caminos vacíos para SULFURAS

*/
class GildedRose {
  public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
  public static final String AGED_BRIE = "Aged Brie";
  public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
  public static final String SULFURAS = SULFURAS_HAND_OF_RAGNAROS;
  public static final int MAX_QUALITY = 50;
  public static final int MIN_QUALITY = 0;

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      updateItem(item);
    }
  }

  private static void updateItem(Item item) {
      switch (item.name) {
          case AGED_BRIE -> {
              incrementQuality(item);
              updateSellIn(item);
              if (hasExpired(item)) {
                  incrementQuality(item);
              }
          }
          case BACKSTAGE_PASS -> {
              incrementQuality(item);
              if (item.sellIn < 11) {
                  incrementQuality(item);
              }
              if (item.sellIn < 6) {
                  incrementQuality(item);
              }

              updateSellIn(item);
              if (hasExpired(item)) {
                  item.quality = 0;
              }
          }
          case SULFURAS -> {
              // Do nothing
          }
          default -> {
              updateQuality(item);
              updateSellIn(item);
              updateExpired(item);
          }
      }
  }

  private static boolean hasExpired(Item item) {
    return item.sellIn < 0;
  }

  private static void updateQuality(Item item) {
    if (item.quality > MIN_QUALITY) {
      item.quality = item.quality - 1;
    }
  }

  private static void incrementQuality(Item item) {
    if (item.quality < MAX_QUALITY) {
      item.quality = item.quality + 1;
    }
  }

  private static void updateSellIn(Item item) {
    item.sellIn = item.sellIn - 1;
  }

  private static void updateExpired(Item item) {
    if (hasExpired(item)) {
      if (item.quality > MIN_QUALITY) {
        item.quality = item.quality - 1;
      }
    }
  }
}
