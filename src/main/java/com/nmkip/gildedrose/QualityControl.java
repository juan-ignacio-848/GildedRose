package com.nmkip.gildedrose;

interface QualityControl {
    int MINIMUM_ITEM_QUALITY = 0;
    int MAXIMUM_ITEM_QUALITY = 50;
    int BASE_INCREMENT = 1;
    int BASE_DECREMENT = 1;

    void updateQuality(Item item);
}
