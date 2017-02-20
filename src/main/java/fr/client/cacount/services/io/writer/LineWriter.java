package fr.client.cacount.services.io.writer;

import java.io.IOException;

/**
 * Created by svirch_n on 20/02/17.
 */
public abstract class LineWriter {

    public abstract void writeLine(String line) throws IOException;

}
