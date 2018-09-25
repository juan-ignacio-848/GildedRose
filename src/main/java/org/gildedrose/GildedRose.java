package org.gildedrose;

import org.gildedrose.qualitycontrol.*;

import java.util.List;

public class GildedRose {

	private List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality()
    {
        for (Item item : items) {
            QualityControl qualityControl = createQualityControlFor(item);
            updateSellInFor(item);
            qualityControl.updateQualityFor(item);
        }
    }

    // TODO: Factory
    private QualityControl createQualityControlFor(Item item) {
        if("Aged Brie".equals(item.getName())) {
            return new AgedBrieQualityControl();
        }

        if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
            return new BackStagePassesQualityControl();
        }

        if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            return new SulfurasQualityControl();
        }

        return new DefaultQualityControl();
    }

    private void updateSellInFor(Item item) {
        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

}