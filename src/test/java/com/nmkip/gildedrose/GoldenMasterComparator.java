package com.nmkip.gildedrose;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class GoldenMasterComparator extends GoldenMaster {

    @Test
    public void golden_master_output_should_still_be_valid() throws IOException {
        Item[] items = fromFile(INPUT_CASES);
        GildedRose gildedRose = new GildedRose(new SellInControl(), new QualityControlFactory());

        gildedRose.updateQuality(items);

        assertEquals(items, fromFile(EXPECTED_OUTPUT));
    }

}
