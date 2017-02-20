package fr.client.cacount.services.io.manager;

import fr.client.cacount.services.io.reader.LineReader;
import fr.client.cacount.services.io.writer.LineWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by svirch_n on 12/02/17.
 */
public interface ALineManager {
    LineReader createLineReaderFile() throws FileNotFoundException;
    LineWriter createLineWriterFile() throws IOException;
}
