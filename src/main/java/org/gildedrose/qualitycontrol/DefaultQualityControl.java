package org.gildedrose.qualitycontrol;

import org.gildedrose.Item;

public class DefaultQualityControl implements QualityControl {

    protected DefaultQualityControl(){}

    @Override
    public void updateQualityFor(Item item) {
        item.setQuality(item.getQuality() - qualityDecreaseFor(item));
    }

    private int qualityDecreaseFor(Item item) {
        int defaultQualityDecrease = defaultQualityDecrease(item);
        return item.getQuality() - defaultQualityDecrease >= 0
                    ? defaultQualityDecrease
                    : item.getQuality();
    }

    private int defaultQualityDecrease(Item item) {
        if(item.sellIn < 0) {
            return QualityControl.DEFAULT_QUALITY_DECREASE * 2;
        }

        return QualityControl.DEFAULT_QUALITY_DECREASE;
    }

}
