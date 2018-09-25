package org.gildedrose.qualitycontrol;

import org.gildedrose.Item;

public class BackStagePassesQualityControl implements QualityControl {

    private static final int FIVE_DAYS = 5;
    private static final int TEN_DAYS = 10;

    @Override
    public void updateQualityFor(Item item) {
        if (item.getQuality() < MAXIMUM_ITEM_QUALITY) {
            item.setQuality(item.getQuality() + 1);

            if (item.getSellIn() <= TEN_DAYS) {
                if (item.getQuality() < MAXIMUM_ITEM_QUALITY) {
                    item.setQuality(item.getQuality() + 1);
                }
            }

            if (item.getSellIn() <= FIVE_DAYS) {
                if (item.getQuality() < MAXIMUM_ITEM_QUALITY) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }

        if(item.sellIn < 0) {
            item.setQuality(0);
        }
    }

}
