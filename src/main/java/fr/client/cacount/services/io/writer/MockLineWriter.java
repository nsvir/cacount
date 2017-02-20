package fr.client.cacount.services.io.writer;

import java.io.IOException;

/**
 * Created by svirch_n on 20/02/17.
 */
public class MockLineWriter extends LineWriter {

    private int index = 0;
    private final String[] expected;

    public MockLineWriter(String[] expected) {
        this.expected = expected;
    }

    @Override
    public void writeLine(String line) throws IOException {
        if (!expected[index].equals(line)) {
            throw new RuntimeException("Index: " + index + " Expected: " + expected[index] + " Actual: " + line);
        }
        index++;
    }

    @Override
    public void close() {

    }
}
