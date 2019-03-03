package com.nmkip.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CharacterizationTests {

	private static final String AGED_BRIE = "Aged Brie";

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
}
