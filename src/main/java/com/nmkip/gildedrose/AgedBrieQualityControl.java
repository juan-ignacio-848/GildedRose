package com.nmkip.gildedrose;

class AgedBrieQualityControl extends QualityControl {

    private static final int BASE_INCREMENT = 1;
    private static final int MAXIMUM_ITEM_QUALITY = 50;

    AgedBrieQualityControl(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        item.quality = Math.min(item.quality + increaseFor(item), MAXIMUM_ITEM_QUALITY);
    }

    private int increaseFor(Item item) {
        return item.sellIn < 0 ? BASE_INCREMENT * 2 : BASE_INCREMENT;
    }
}
