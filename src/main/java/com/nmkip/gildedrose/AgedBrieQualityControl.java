package com.nmkip.gildedrose;

class AgedBrieQualityControl extends QualityControl {

    protected AgedBrieQualityControl(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        increaseQualityBy1(item);
        if(item.sellIn < 0)
            increaseQualityBy1(item);

    }
}
