package org.gildedrose.qualitycontrol;

import org.gildedrose.Item;

public class DefaultQualityControl implements QualityControl {

    protected DefaultQualityControl(){}

    @Override
    public void updateQualityFor(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }

        if (item.getSellIn() < 0) {
            if (item.getQuality() > 0) {
                item.setQuality(item.getQuality() - 1);
            }
        }
    }

}
