package com.nmkip.gildedrose;

import static java.lang.Math.*;

class DefaultQualityControl implements QualityControl {

    @Override
    public void updateQuality(Item item) {
        item.quality = max(item.quality - decrementFor(item), MINIMUM_ITEM_QUALITY);
    }

    private int decrementFor(Item item) {
        return item.sellIn < 0 ? BASE_DECREMENT * 2 : BASE_DECREMENT;
    }
}
