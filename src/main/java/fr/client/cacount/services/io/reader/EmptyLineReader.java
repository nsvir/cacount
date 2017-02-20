package fr.client.cacount.services.io.reader;

import java.io.IOException;

/**
 * Created by svirch_n on 12/02/17.
 */
public class EmptyLineReader extends MockLineReader {

    @Override
    public String readLine() throws IOException {
        return null;
    }

}
