package fr.client.cacount.services.io.manager;

import fr.client.cacount.services.io.reader.LineReader;
import fr.client.cacount.services.io.writer.LineWriter;

import java.io.FileNotFoundException;

/**
 * Created by svirch_n on 12/02/17.
 */
public interface ALineManager {
    LineReader getLineReaderFile() throws FileNotFoundException;
    LineWriter getLineWriterFile() throws FileNotFoundException;
}
