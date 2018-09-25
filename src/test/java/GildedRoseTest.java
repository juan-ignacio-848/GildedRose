import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GildedRoseTest {

    private List<Item> items;
    private GildedRose gildedRose;

    @Before
    public void setUp() {
        items = new ArrayList<Item>();
        gildedRose = new GildedRose(items);
    }

    @Test
    public void should_increase_quality_of_aged_brie_when_sell_in_greater_than_0() {
        Item item = addItem(new Item("Aged Brie", 2, 0));

        gildedRose.updateQuality();

        assertThat(item.quality, is(1));
    }

    @Test
    public void should_increase_quality_by_2_of_aged_brie_when_sell_in_less_than_1() {
        Item item = addItem(new Item("Aged Brie", 0, 0));

        gildedRose.updateQuality();

        assertThat(item.quality, is(2));
    }

    @Test
    public void should_not_change_sulfuras_quality() {
        Item item = addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));

        gildedRose.updateQuality();

        assertThat(item.quality, is(80));
    }

    @Test
    public void should_not_change_sulfuras_sell_in() {
        Item item = addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 20));

        gildedRose.updateQuality();

        assertThat(item.sellIn, is(0));
    }

    @Test
    public void should_increase_quality_of_backstage_passes_when_sell_in_greater_than_10() {
        Item item = addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20));

        gildedRose.updateQuality();

        assertThat(item.quality, is(21));
    }

    @Test
    public void should_increase_quality_by_2_of_backstage_passes_when_sell_in_between_7_and_10() {
        Item item = addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 7, 20));

        gildedRose.updateQuality();

        assertThat(item.quality, is(22));
    }

    @Test
    public void should_increase_quality_by_3_of_backstage_passes_when_sell_in_between_1_and_5() {
        Item item = addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20));

        gildedRose.updateQuality();

        assertThat(item.quality, is(23));
    }

    @Test
    public void should_decrease_quality_to_0_of_backstage_passes_when_sell_in_less_than_1() {
        Item item = addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));

        gildedRose.updateQuality();

        assertThat(item.quality, is(0));
    }

    @Test
    public void should_not_increase_quality_of_an_item_if_it_is_50() {
        Item item = addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50));

        gildedRose.updateQuality();

        assertThat(item.quality, is(50));
    }

    @Test
    public void should_decrease_quality_of_normal_items_when_sell_in_greater_than_0() {
        Item item = addItem(new Item("+5 Dexterity Vest", 1, 50));

        gildedRose.updateQuality();

        assertThat(item.quality, is(49));
    }

    @Test
    public void should_decrease_quality_by_2_of_normal_items_when_sell_in_less_than_1() {
        Item item = addItem(new Item("+5 Dexterity Vest", 0, 50));

        gildedRose.updateQuality();

        assertThat(item.quality, is(48));
    }

    private Item addItem(Item item) {
        items.add(item);
        return item;
    }
}
