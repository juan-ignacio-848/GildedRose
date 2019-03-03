package com.nmkip.gildedrose;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class GoldenMasterComparator extends GoldenMaster {

    @Test
    public void golden_master_output_should_still_be_valid() throws IOException {
        Item[] items = fromFile(INPUT);
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(items, fromFile(ACCEPTED_OUTPUT));
    }

}
