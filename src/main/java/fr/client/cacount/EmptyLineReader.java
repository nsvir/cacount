package fr.client.cacount;

import java.io.IOException;

/**
 * Created by svirch_n on 12/02/17.
 */
public class EmptyLineReader extends LineReader {
    @Override
    public String readLine() throws IOException {
        return null;
    }
}
