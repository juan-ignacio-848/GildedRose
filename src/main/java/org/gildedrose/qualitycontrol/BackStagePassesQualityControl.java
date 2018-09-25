package org.gildedrose.qualitycontrol;

import org.gildedrose.Item;

import static java.lang.Math.min;

public class BackStagePassesQualityControl implements QualityControl {

    private static final int FIVE_DAYS = 5;
    private static final int TEN_DAYS = 10;
    private static final int NO_INCREASE = 0;

    protected BackStagePassesQualityControl(){}

    @Override
    public void updateQualityFor(Item item) {
        item.setQuality(qualityIncreaseFor(item));
    }

    private int qualityIncreaseFor(Item item) {
        final int increasedQuality = item.getQuality() + defaultQualityIncreaseFor(item);
        return item.getSellIn() >= 0 ? min(increasedQuality, MAXIMUM_ITEM_QUALITY) : NO_INCREASE;
    }

    private int defaultQualityIncreaseFor(Item item) {
        if(item.getSellIn() <= FIVE_DAYS) {
            return DEFAULT_QUALITY_INCREASE * 3;
        } else if(item.getSellIn() <= TEN_DAYS) {
            return DEFAULT_QUALITY_INCREASE * 2;
        }

        return DEFAULT_QUALITY_INCREASE;
    }

}
