package fr.client.cacount;

import java.io.FileNotFoundException;

/**
 * Created by svirch_n on 12/02/17.
 */
public interface ALineReaderManager {
    LineReader getLineReaderFile() throws FileNotFoundException;
}
