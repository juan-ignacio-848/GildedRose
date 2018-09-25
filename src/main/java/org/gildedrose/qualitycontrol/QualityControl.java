package org.gildedrose.qualitycontrol;

import org.gildedrose.Item;

public interface QualityControl {

    int MAXIMUM_ITEM_QUALITY = 50;
    int DEFAULT_QUALITY_DEGRADE = 1;
    int DEFAULT_QUALITY_INCREASE = 1;

    void updateQualityFor(Item item);
}
