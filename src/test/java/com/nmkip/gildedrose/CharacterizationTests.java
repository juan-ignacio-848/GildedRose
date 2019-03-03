package com.nmkip.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CharacterizationTests {

	public static final String AGED_BRIE = "Aged Brie";

	@Test
	public void aged_brie_quality_increases_by_1_while_sellIn_decreases_by_1() {
		Item agedBrie = new Item(AGED_BRIE, 20, 20);
		Item[] items = new Item[] {
			agedBrie
		};

		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertThat(agedBrie.quality, is(21));
		assertThat(agedBrie.sellIn, is(19));
	}

}
