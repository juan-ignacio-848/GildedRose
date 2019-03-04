package com.nmkip.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        updateSellIn(item);
        QualityControlFactory qualityControlFactory = new QualityControlFactory();
        qualityControlFactory.qualityControlFor(item).updateQuality(item);
    }

    private void updateSellIn(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else {
            item.sellIn = item.sellIn - 1;
        }
    }

}
