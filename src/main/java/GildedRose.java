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

    private interface QualityControl {
        void updateQualityFor(Item item);
    }

    private class AgedBrieQualityControl implements QualityControl {

        @Override
        public void updateQualityFor(Item item) {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
            }

            if(item.sellIn < 0) {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }

    }

    private class BackStagePassesQualityControl implements QualityControl {
        @Override
        public void updateQualityFor(Item item) {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);

                if (item.getSellIn() < 11) {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }

                if (item.getSellIn() < 6) {
                    if (item.getQuality() < 50) {
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