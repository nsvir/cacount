package fr.client.cacount.services.io;

import fr.client.cacount.services.io.ALineReaderManager;
import fr.client.cacount.services.io.EmptyLineReader;
import fr.client.cacount.services.io.LineReader;
import fr.client.cacount.services.io.MockLineReader;

import java.io.FileNotFoundException;

/**
 * Created by svirch_n on 12/02/17.
 */
public class MockLineReaderManager implements ALineReaderManager {

    private LineReader bufferedReader;

    public MockLineReaderManager(LineReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public MockLineReaderManager() {
        this.bufferedReader = new EmptyLineReader();
    }

    public MockLineReaderManager(String[] lines) {
        this.bufferedReader = new MockLineReader(lines);
    }

    @Override
    public LineReader getLineReaderFile() throws FileNotFoundException {
        return bufferedReader;
    }
}
