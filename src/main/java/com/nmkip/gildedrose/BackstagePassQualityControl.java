package com.nmkip.gildedrose;

class BackstagePassQualityControl extends QualityControl {
    BackstagePassQualityControl(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        if (item.quality < 50) {

            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                increaseQualityBy1(item);
            }

            if (item.sellIn < 6) {
                increaseQualityBy1(item);
            }
        }

        if(item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
