package com.nmkip.gildedrose;

class QualityControlFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";

    QualityControl qualityControlFor(Item item) {
        if (AGED_BRIE.equals(item.name)) {
            return new AgedBrieQualityControl();
        } else if (BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(item.name)) {
            return new BackstagePassQualityControl();
        } else if (SULFURAS_HAND_OF_RAGNAROS.equals(item.name)) {
            return new SulfurasHandQualityControl();
        } else if (item.name.startsWith(CONJURED))
            return new ConjuredItemQualityControl();
        else {
            return new DefaultQualityControl();
        }

    }
}
