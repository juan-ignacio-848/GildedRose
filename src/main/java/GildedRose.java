import java.util.List;


public class GildedRose {

	private List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality()
    {
        for (Item item : items) {
            updateAn(item);
        }
    }

    private void updateAn(Item item) {
        updateQualityFor(item);

        updateSellInFor(item);

        updateQualityForExpired(item);
    }

    private void updateSellInFor(Item item) {
        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    private void updateQualityFor(Item item) {
        if (("Aged Brie".equals(item.getName()))) {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
            }
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
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
        } else if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            if (item.getQuality() > 0) {
                item.setQuality(item.getQuality() - 1);
            }
        }
    }

    private void updateQualityForExpired(Item item) {
        if (item.getSellIn() < 0) {
            if ("Aged Brie".equals(item.getName())) {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                item.setQuality(0);
            } else if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                if (item.getQuality() > 0) {
                    item.setQuality(item.getQuality() - 1);
                }
            }
        }
    }

}