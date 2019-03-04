package com.nmkip.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CharacterizationTests {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String JUST_A_NORMAL_ITEM = "Just a normal item";
    private GildedRose gildedRose;

    @Before
    public void setUp() {
        gildedRose = new GildedRose(new SellInControl(), new QualityControlFactory());
    }

    @Test
    public void aged_brie_sellIn_decreases_by_1_and_quality_increases_by_1_when_sellIn_is_greater_than_0() {
        int sellIn = 20;
        int quality = 20;
        Item agedBrie = new Item(AGED_BRIE, sellIn, quality);
        Item[] items = new Item[]{agedBrie};

        gildedRose.updateQuality(items);

        assertThat(agedBrie.sellIn, is(sellIn - 1));
        assertThat(agedBrie.quality, is(quality + 1));
    }

    @Test
    public void aged_brie_sellIn_decreases_by_1_and_quality_increases_by_1_when_sellIn_is_less_or_equal_to_0() {
        int sellIn = -1;
        int quality = 20;
        Item agedBrie = new Item(AGED_BRIE, sellIn, quality);
        Item[] items = new Item[]{agedBrie};

        gildedRose.updateQuality(items);

        assertThat(agedBrie.sellIn, is(sellIn - 1));
        assertThat(agedBrie.quality, is(quality + 2));
    }

    @Test
    public void aged_brie_quality_can_increase_up_to_50() {
        int sellIn = 20;
        int quality = 50;
        Item agedBrie = new Item(AGED_BRIE, sellIn, quality);
        Item[] items = new Item[]{agedBrie};

        gildedRose.updateQuality(items);

        assertThat(agedBrie.sellIn, is(sellIn - 1));
        assertThat(agedBrie.quality, is(quality));
    }

    @Test
    public void sulfuras_hand_of_ragnaros_quality_and_sellIn_remain_unchanged() {
        int sellIn = 20;
        int quality = 20;
        Item sulfurasHandOfRagnaros = new Item(SULFURAS_HAND_OF_RAGNAROS, sellIn, quality);
        Item[] items = new Item[]{sulfurasHandOfRagnaros};

        gildedRose.updateQuality(items);

        assertThat(sulfurasHandOfRagnaros.sellIn, is(sellIn));
        assertThat(sulfurasHandOfRagnaros.quality, is(quality));
    }

    @Test
    public void backstage_passes_sellIn_decreases_by_1_and_quality_increases_by_1_when_sellIn_greater_than_11() {
        Item backstagePasses = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 30, 25);
        Item[] items = new Item[]{backstagePasses};

        gildedRose.updateQuality(items);

        assertThat(backstagePasses.sellIn, is(29));
        assertThat(backstagePasses.quality, is(26));
    }

    @Test
    public void backstage_passes_sellIn_decreases_by_1_and_quality_increases_by_2_when_sellIn_less_than_11() {
        int sellIn = 10;
        int quality = 25;
        Item backstagePasses = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, sellIn, quality);
        Item[] items = new Item[]{backstagePasses};

        gildedRose.updateQuality(items);

        assertThat(backstagePasses.sellIn, is(sellIn - 1));
        assertThat(backstagePasses.quality, is(quality + 2));
    }

    @Test
    public void backstage_passes_sellIn_decreases_by_1_and_quality_increases_by_3_when_sellIn_less_than_6() {
        int sellIn = 5;
        int quality = 25;
        Item backstagePasses = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, sellIn, quality);
        Item[] items = new Item[]{backstagePasses};

        gildedRose.updateQuality(items);

        assertThat(backstagePasses.sellIn, is(sellIn - 1));
        assertThat(backstagePasses.quality, is(quality + 3));
    }

    @Test
    public void backstage_passes_sellIn_decreases_by_1_and_quality_drops_to_0_when_sellIn_is_less_or_equal_to_0() {
        int sellIn = -1;
        Item backstagePasses = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, sellIn, 25);
        Item[] items = new Item[]{backstagePasses};

        gildedRose.updateQuality(items);

        assertThat(backstagePasses.sellIn, is(sellIn - 1));
        assertThat(backstagePasses.quality, is(0));
    }

    @Test
    public void backstage_passes_quality_can_increase_up_to_50() {
        int sellIn = 24;
        int quality = 50;
        Item backstagePasses = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, sellIn, quality);
        Item[] items = new Item[]{backstagePasses};

        gildedRose.updateQuality(items);

        assertThat(backstagePasses.sellIn, is(sellIn - 1));
        assertThat(backstagePasses.quality, is(quality));
    }

    @Test
    public void normal_item_sellIn_decreases_by_1_and_quality_decreases_by_1_when_sellIn_is_greater_than_0() {
        int sellIn = 5;
        int quality = 25;
        Item normalItem = new Item(JUST_A_NORMAL_ITEM, sellIn, quality);
        Item[] items = new Item[]{normalItem};

        gildedRose.updateQuality(items);

        assertThat(normalItem.sellIn, is(sellIn - 1));
        assertThat(normalItem.quality, is(quality - 1));
    }

    @Test
    public void normal_item_sellIn_decreases_by_1_and_quality_decreases_by_2_when_sellIn_is_less_or_equal_to_0() {
        int sellIn = -1;
        int quality = 25;
        Item normalItem = new Item(JUST_A_NORMAL_ITEM, sellIn, quality);
        Item[] items = new Item[]{normalItem};

        gildedRose.updateQuality(items);

        assertThat(normalItem.sellIn, is(sellIn - 1));
        assertThat(normalItem.quality, is(quality - 2));
    }

    @Test
    public void conjured_items_sellIn_decreases_by_1_and_quality_decreases_by_2_when_sellIn_is_greater_than_0() {
        int sellIn = 5;
        int quality = 25;
        Item conjuredItem = new Item("Conjured Boot", sellIn, quality);
        Item[] items = new Item[]{conjuredItem};

        gildedRose.updateQuality(items);

        assertThat(conjuredItem.sellIn, is(sellIn - 1));
        assertThat(conjuredItem.quality, is(quality - 2));
    }

    @Test
    public void conjured_items_sellIn_decreases_by_1_and_quality_decreases_by_2_when_sellIn_is_less_or_equal_than_0() {
        int sellIn = -2;
        int quality = 25;
        Item conjuredItem = new Item("Conjured Boot", sellIn, quality);
        Item[] items = new Item[]{conjuredItem};

        gildedRose.updateQuality(items);

        assertThat(conjuredItem.sellIn, is(sellIn - 1));
        assertThat(conjuredItem.quality, is(quality - 4));
    }
}
