package com.nmkip.gildedrose;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;


public class GoldenMasterGenerator extends GoldenMaster {

    @Test
    @Ignore
    public void generate_golden_master() throws IOException {
        Item[] items = fromFile(INPUT_CASES);
        GildedRose gildedRose = new GildedRose(new SellInControl(), new QualityControlFactory());

        gildedRose.updateQuality(items);

        persistOutput(items);
    }

    private void persistOutput(Item[] items) throws IOException {
        String result = Arrays.stream(items)
                               .map(Item::toString)
                               .collect(Collectors.joining("\n"));
        Files.write(Paths.get(EXPECTED_OUTPUT), result.getBytes());
    }
}
