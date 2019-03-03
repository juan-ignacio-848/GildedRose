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
        updateSellIn(item);

        updateQuality(item);
    }

    private void updateQuality(Item item) {
        switch (item.name) {
            case "Aged Brie":
                increaseQualityBy1(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.quality < 50) {

                    item.quality = item.quality + 1;

                    if (item.sellIn < 11) {
                        increaseQualityBy1(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQualityBy1(item);
                    }
                }
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                decreaseQualityBy1(item);
                break;
        }

        if (item.sellIn < 0) {
            switch (item.name) {
                case "Aged Brie":
                    increaseQualityBy1(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    item.quality = 0;
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    decreaseQualityBy1(item);
                    break;
            }
        }
    }

    private void updateSellIn(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else {
            item.sellIn = item.sellIn - 1;
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
