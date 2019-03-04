package com.nmkip.gildedrose;

abstract class QualityControl {
    protected Item item;

    QualityControl(Item item) {
        this.item = item;
    }

    static QualityControl qualityControlFor(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieQualityControl(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassQualityControl(item);
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasHandQualityControl(item);
            default:
                return new DefaultQualityControl(item);
        }
    }

    abstract void updateQuality();

    protected void increaseQualityBy1(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    protected void decreaseQualityBy1(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

}
