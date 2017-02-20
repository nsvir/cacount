package fr.client.cacount.services.io;

import fr.client.cacount.services.io.LineReader;

import java.io.IOException;

/**
 * Created by svirch_n on 12/02/17.
 */
public class MockLineReader extends LineReader {

    private final String[] lines;
    int i = 0;

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
