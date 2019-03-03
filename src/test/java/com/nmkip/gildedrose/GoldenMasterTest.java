package com.nmkip.gildedrose;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;


public class GoldenMasterTest {

    @Test
    public void golden_master() throws IOException {
        Item[] items = fromInput();
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        persistOutput(items);
    }

    private Item[] fromInput() throws IOException {
        return Files.lines(Paths.get("src/test/resources/golden_master_input.txt"))
                    .map(this::toItem)
                    .toArray(Item[]::new);
    }

    private Item toItem(String line) {
        String[] split = line.split(";");
        return new Item(split[0], Integer.valueOf(split[1].trim()), Integer.valueOf(split[2].trim()));
    }

    private void persistOutput(Item[] items) throws IOException {
        String result = Arrays.stream(items)
                               .map(Item::toString)
                               .collect(Collectors.joining("\n"));
        Files.write(Paths.get("src/test/resources/out/golden_master_output.txt"), result.getBytes());
    }
}
