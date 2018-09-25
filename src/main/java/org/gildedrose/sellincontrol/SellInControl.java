package org.gildedrose.sellincontrol;

import org.gildedrose.Item;

public class SellInControl {
    public SellInControl() {
    }

    public void updateSellInFor(Item item) {
        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }
}