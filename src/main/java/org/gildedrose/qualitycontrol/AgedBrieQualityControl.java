package org.gildedrose.qualitycontrol;

import org.gildedrose.Item;

public class AgedBrieQualityControl implements QualityControl {

    @Override
    public void updateQualityFor(Item item) {
        if (item.getQuality() < MAXIMUM_ITEM_QUALITY) {
            item.setQuality(item.getQuality() + 1);
        }

        if(item.sellIn < 0) {
            if (item.getQuality() < MAXIMUM_ITEM_QUALITY) {
                item.setQuality(item.getQuality() + 1);
            }
        }
    }

}
