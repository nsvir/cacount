package fr.client.cacount.services.io.writer;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by svirch_n on 20/02/17.
 */
public class BufferedLineWriter extends LineWriter {

    private final BufferedWriter bufferedWriter;

    public BufferedLineWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void writeLine(String line) throws IOException {
        bufferedWriter.write(line);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    @Override
    public void close() {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
