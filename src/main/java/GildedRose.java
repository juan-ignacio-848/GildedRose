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
        updateQualityOf(item);

        updateSellInOf(item);

        updateExpired(item);
    }

    private void updateSellInOf(Item item) {
        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    private void updateQualityOf(Item item) {
        if (("Aged Brie".equals(item.getName()))) {
            updateAgedBrieOrBackstagePassesQuality(item);
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
            updateAgedBrieOrBackstagePassesQuality(item);
        } else if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            if (item.getQuality() > 0) {
                item.setQuality(item.getQuality() - 1);
            }
        }
    }

    private void updateExpired(Item item) {
        if (item.getSellIn() < 0) {
            if ("Aged Brie".equals(item.getName())) {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                item.setQuality(item.getQuality() - item.getQuality());
            } else if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                if (item.getQuality() > 0) {
                    item.setQuality(item.getQuality() - 1);
                }
            }
        }
    }

    private void updateAgedBrieOrBackstagePassesQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);

            if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
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
        }
    }

}