package fr.client.cacount.services.io;

import java.io.FileNotFoundException;

/**
 * Created by svirch_n on 12/02/17.
 */
public interface ALineReaderManager {
    LineReader getLineReaderFile() throws FileNotFoundException;
}
