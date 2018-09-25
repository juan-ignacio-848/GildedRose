package org.gildedrose.qualitycontrol;

import org.gildedrose.Item;

import static java.lang.Math.*;

public class AgedBrieQualityControl implements QualityControl {

    protected AgedBrieQualityControl(){}

    @Override
    public void updateQualityFor(Item item) {
        item.setQuality(min(item.getQuality() + qualityIncreaseFor(item), MAXIMUM_ITEM_QUALITY));
    }

    private int qualityIncreaseFor(Item item) {
        if(item.getSellIn() < 0) {
            return DEFAULT_QUALITY_INCREASE * 2;
        }

        return DEFAULT_QUALITY_INCREASE;
    }

}
