package fr.client.cacount.services.io.reader;

import java.io.IOException;

/**
 * Created by svirch_n on 12/02/17.
 */
public class MockLineReader extends LineReader {

    private String[] lines;
    int i = 0;

    MockLineReader() {
    }

    public MockLineReader(String[] lines) {
        super();
        this.lines = lines;
    }

    @Override
    public String readLine() throws IOException {
        if (i >= lines.length) {
            return null;
        }
        return lines[i++];
    }
}
