package fr.client.cacount.services.io.reader;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by svirch_n on 12/02/17.
 */
public class BufferedLineReader extends LineReader {

    private final BufferedReader bufferedReader;

    public BufferedLineReader(BufferedReader bufferedReader) {
        super();
        this.bufferedReader = bufferedReader;
    }

    @Override
    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    @Override
    public void close() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
