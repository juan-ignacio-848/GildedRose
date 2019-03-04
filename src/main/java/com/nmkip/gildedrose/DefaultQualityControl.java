package com.nmkip.gildedrose;

class DefaultQualityControl extends QualityControl {
    DefaultQualityControl(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        decreaseQualityBy1(item);
        if(item.sellIn < 0)
            decreaseQualityBy1(item);
    }
}
