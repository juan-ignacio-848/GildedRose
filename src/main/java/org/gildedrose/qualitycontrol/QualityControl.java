package org.gildedrose.qualitycontrol;

import org.gildedrose.Item;

public interface QualityControl {
    int MAXIMUM_ITEM_QUALITY = 50;

    void updateQualityFor(Item item);
}
