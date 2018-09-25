package org.gildedrose.qualitycontrol;

import org.gildedrose.Item;

public class DefaultQualityControl implements QualityControl {

    protected DefaultQualityControl(){}

    @Override
    public void updateQualityFor(Item item) {
        item.setQuality(item.getQuality() - qualityDegradeFor(item));
    }

    private int qualityDegradeFor(Item item) {
        int defaultQualityDegrade = defaultQualityDegrade(item);
        return item.getQuality() - defaultQualityDegrade >= 0
                    ? defaultQualityDegrade
                    : item.getQuality();
    }

    private int defaultQualityDegrade(Item item) {
        if(item.sellIn < 0) {
            return QualityControl.DEFAULT_QUALITY_DEGRADE * 2;
        }

        return QualityControl.DEFAULT_QUALITY_DEGRADE;
    }

}
