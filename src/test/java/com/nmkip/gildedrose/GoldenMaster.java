package com.nmkip.gildedrose;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class GoldenMaster {
    static final String EXPECTED_OUTPUT = "src/test/resources/out/golden_master_output.txt";
    static final String INPUT_CASES = "src/test/resources/golden_master_input.txt";

    Item[] fromFile(String uri) throws IOException {
        return Files.lines(Paths.get(uri))
                    .map(this::toItem)
                    .toArray(Item[]::new);
    }

    private Item toItem(String line) {
        String[] split = line.split(";");
        return new Item(split[0], Integer.valueOf(split[1].trim()), Integer.valueOf(split[2].trim()));
    }
}
