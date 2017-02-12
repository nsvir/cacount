package fr.client.cacount;

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
