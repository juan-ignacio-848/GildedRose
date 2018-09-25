package org.gildedrose;

import org.gildedrose.qualitycontrol.*;

import java.util.List;

public class GildedRose {

    private final QualityControlFactory qualityControlFactory;
    private List<Item> items;

    public GildedRose(List<Item> items, QualityControlFactory qualityControlFactory) {
        this.qualityControlFactory = qualityControlFactory;
        this.items = items;
    }

    public void updateQuality()
    {
        for (Item item : items) {
            QualityControl qualityControl = qualityControlFactory.createQualityControlFor(item);
            updateSellInFor(item);
            qualityControl.updateQualityFor(item);
        }
    }

    private void updateSellInFor(Item item) {
        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

}