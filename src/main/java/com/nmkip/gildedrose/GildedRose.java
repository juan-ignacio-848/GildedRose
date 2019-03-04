package com.nmkip.gildedrose;

class GildedRose {
    private final SellInControl sellInControl;
    private final QualityControlFactory qualityControlFactory;

    GildedRose(SellInControl sellInControl, QualityControlFactory qualityControlFactory) {
        this.sellInControl = sellInControl;
        this.qualityControlFactory = qualityControlFactory;
    }

    void updateQuality(Item[] items) {
        for (Item item : items) {
            updateSellInFor(item);
            updateQualityFor(item);
        }
    }

    private void updateQualityFor(Item item) {
        qualityControlFactory.qualityControlFor(item).updateQuality(item);
    }

    private void updateSellInFor(Item item) {
        sellInControl.updateSellIn(item);
    }

}
