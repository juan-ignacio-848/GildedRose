package com.nmkip.gildedrose;

class GildedRose {
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
        updateQualityBeforeSellIn(item);

        updateSellIn(item);

        updateQualityAfterSellIn(item);
    }

    private void updateSellIn(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateQualityAfterSellIn(Item item) {
        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                increaseQualityBy1(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = 0;
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return;
            } else {
                decreaseQualityBy1(item);
            }
        }
    }

    private void updateQualityBeforeSellIn(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQualityBy1(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality < 50) {

                item.quality = item.quality + 1;

                if (item.sellIn < 11) {
                    increaseQualityBy1(item);
                }

                if (item.sellIn < 6) {
                    increaseQualityBy1(item);
                }
            }
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else {
            decreaseQualityBy1(item);
        }
    }

    private void increaseQualityBy1(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQualityBy1(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
