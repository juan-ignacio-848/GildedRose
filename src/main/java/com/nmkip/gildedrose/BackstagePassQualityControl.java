package com.nmkip.gildedrose;

import static java.lang.Math.*;

class BackstagePassQualityControl implements QualityControl {

    @Override
    public void updateQuality(Item item) {
        item.quality = item.sellIn < 0 ? 0 : min(item.quality + incrementFor(item), MAXIMUM_ITEM_QUALITY);
    }

    private int incrementFor(Item item) {
        if (item.sellIn < 6)
            return BASE_INCREMENT * 3;
        if (item.sellIn < 11)
            return BASE_INCREMENT * 2;
        else
            return BASE_INCREMENT;
    }
}
