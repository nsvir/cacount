package fr.client.cacount.services.io.manager;

import android.os.Environment;
import fr.client.cacount.Cacount;
import fr.client.cacount.services.io.reader.BufferedLineReader;
import fr.client.cacount.services.io.reader.LineReader;
import fr.client.cacount.services.io.writer.LineWriter;
import fr.client.cacount.services.io.writer.BufferedLineWriter;

import java.io.*;

/**
 * Created by svirch_n on 12/02/17.
 */
public class LineManager implements ALineManager {

    private final File file;
    private final BufferedLineReader bufferedLineReader;
    private final BufferedLineWriter bufferedLineWriter;

    public LineManager() throws IOException {
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), Cacount.FILENAME);
        bufferedLineReader = new BufferedLineReader(new BufferedReader(new FileReader(file)));
        bufferedLineWriter = new BufferedLineWriter(new BufferedWriter(new FileWriter(file)));
    }

    @Override
    public LineReader getLineReaderFile() throws FileNotFoundException {
        return bufferedLineReader;
    }

    @Override
    public LineWriter getLineWriterFile() throws FileNotFoundException {
        return bufferedLineWriter;
    }
}
