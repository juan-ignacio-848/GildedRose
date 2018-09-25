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

    private class AgedBrieQualityControl implements QualityControl {

        @Override
        public void updateQualityFor(Item item) {
            if (item.getQuality() < MAXIMUM_ITEM_QUALITY) {
                item.setQuality(item.getQuality() + 1);
            }

            if(item.sellIn < 0) {
                if (item.getQuality() < MAXIMUM_ITEM_QUALITY) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }

    }

    interface QualityControl {
        int MAXIMUM_ITEM_QUALITY = 50;

        void updateQualityFor(Item item);
    }

    private class BackStagePassesQualityControl implements QualityControl {

        private static final int FIVE_DAYS = 5;
        private static final int TEN_DAYS = 10;

        @Override
        public void updateQualityFor(Item item) {
            if (item.getQuality() < MAXIMUM_ITEM_QUALITY) {
                item.setQuality(item.getQuality() + 1);

                if (item.getSellIn() <= TEN_DAYS) {
                    if (item.getQuality() < MAXIMUM_ITEM_QUALITY) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }

                if (item.getSellIn() <= FIVE_DAYS) {
                    if (item.getQuality() < MAXIMUM_ITEM_QUALITY) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }

            if(item.sellIn < 0) {
                item.setQuality(0);
            }
        }

    }

    private class SulfurasQualityControl implements QualityControl {
        @Override
        public void updateQualityFor(Item item) {
        }

    }

    private class DefaultQualityControl implements QualityControl {
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
}