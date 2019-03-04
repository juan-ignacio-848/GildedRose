package com.nmkip.gildedrose;

class QualityControlFactory {

    QualityControl qualityControlFor(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieQualityControl();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassQualityControl();
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasHandQualityControl();
            default:
                return new DefaultQualityControl();
        }
    }
}
