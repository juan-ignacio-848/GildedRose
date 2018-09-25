package org.gildedrose;

import org.gildedrose.qualitycontrol.*;
import org.gildedrose.sellincontrol.SellInControl;

import java.util.List;

public class GildedRose {

    private final QualityControlFactory qualityControlFactory;
    private final SellInControl sellInControl;
    private List<Item> items;

    public GildedRose(List<Item> items, QualityControlFactory qualityControlFactory, SellInControl sellInControl) {
        this.qualityControlFactory = qualityControlFactory;
        this.items = items;
        this.sellInControl = sellInControl;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateSellInFor(item);
            updateQualityFor(item);
        }
    }

    private void updateQualityFor(Item item) {
        qualityControlFactory.createQualityControlFor(item).updateQualityFor(item);
    }

    private void updateSellInFor(Item item) {
        sellInControl.updateSellInFor(item);
    }

}