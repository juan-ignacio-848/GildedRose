package com.nmkip.gildedrose;

import static java.lang.Math.*;

class AgedBrieQualityControl implements QualityControl {

    @Override
    public void updateQuality(Item item) {
        item.quality = min(item.quality + incrementFor(item), MAXIMUM_ITEM_QUALITY);
    }

    private int incrementFor(Item item) {
        return item.sellIn < 0 ? BASE_INCREMENT * 2 : BASE_INCREMENT;
    }
}
