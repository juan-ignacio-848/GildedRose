package com.nmkip.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CharacterizationTests {

	private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

	@Test
	public void aged_brie_sellIn_decreases_by_1_and_quality_increases_by_1_when_sellIn_is_greater_than_0() {
		Item agedBrie = new Item(AGED_BRIE, 20, 20);
		Item[] items = new Item[] {
			agedBrie
		};

		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertThat(agedBrie.sellIn, is(19));
		assertThat(agedBrie.quality, is(21));
	}

	@Test
	public void aged_brie_sellIn_decreases_by_1_and_quality_increases_by_1_when_sellIn_is_equal_to_0() {
		Item agedBrie = new Item(AGED_BRIE, 0, 20);
		Item[] items = new Item[] {
				agedBrie
		};

		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertThat(agedBrie.sellIn, is(-1));
		assertThat(agedBrie.quality, is(22));
	}

    @Test
    public void sulfuras_hand_of_ragnaros_quality_and_sellIn_remain_unchanged() {
        Item sulfurasHandOfRagnaros = new Item(SULFURAS_HAND_OF_RAGNAROS, 20, 20);
        Item[] items = new Item[] {
                sulfurasHandOfRagnaros
        };

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(sulfurasHandOfRagnaros.sellIn, is(20));
        assertThat(sulfurasHandOfRagnaros.quality, is(20));
    }

}
