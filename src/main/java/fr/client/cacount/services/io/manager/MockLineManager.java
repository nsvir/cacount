package fr.client.cacount.services.io.manager;

import fr.client.cacount.services.io.reader.EmptyLineReader;
import fr.client.cacount.services.io.reader.MockLineReader;
import fr.client.cacount.services.io.reader.LineReader;
import fr.client.cacount.services.io.writer.LineWriter;
import fr.client.cacount.services.io.writer.MockLineWriter;

import java.io.FileNotFoundException;

/**
 * Created by svirch_n on 12/02/17.
 */
public class MockLineManager implements ALineManager {

    private MockLineReader mockLineReader;
    private MockLineWriter mockLineWriter;

    public MockLineManager() {
        this.mockLineReader = new EmptyLineReader();
    }

    public MockLineManager reader(String[] lines) {
        this.mockLineReader = new MockLineReader(lines);
        return this;
    }

    public MockLineManager writer(String[] lines) {
        this.mockLineWriter = new MockLineWriter(lines);
        return this;
    }

    @Override
    public LineReader getLineReaderFile() throws FileNotFoundException {
        return mockLineReader;
    }

    @Override
    public LineWriter getLineWriterFile() throws FileNotFoundException {
        return mockLineWriter;
    }
}
