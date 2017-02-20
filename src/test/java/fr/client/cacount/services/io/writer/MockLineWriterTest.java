package fr.client.cacount.services.io.writer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by svirch_n on 20/02/17.
 */
public class MockLineWriterTest {
    @Test
    public void writeLine() throws Exception {
        String line1 = "expected this";
        String line2 = "expected that";
        MockLineWriter mockLineWriter = new MockLineWriter(new String[]{line1, line2});
        mockLineWriter.writeLine(line1);
        mockLineWriter.writeLine(line2);
    }

    @Test (expected = RuntimeException.class)
    public void writeLineFailed() throws Exception {
        String line1 = "expected this";
        String line2 = "expected that";
        MockLineWriter mockLineWriter = new MockLineWriter(new String[]{line1, line2});
        mockLineWriter.writeLine(line2);
        mockLineWriter.writeLine(line1);
    }

}