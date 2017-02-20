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
    private BufferedLineReader bufferedLineReader;
    private BufferedLineWriter bufferedLineWriter;

    public LineManager(String filename) throws IOException {
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), filename);
        //noinspection ResultOfMethodCallIgnored
        file.createNewFile();
    }

    @Override
    public LineReader createLineReaderFile() throws FileNotFoundException {
        if (bufferedLineReader != null) {
            bufferedLineReader.close();
        }
        bufferedLineReader = new BufferedLineReader(new BufferedReader(new FileReader(file)));
        return bufferedLineReader;
    }

    @Override
    public LineWriter createLineWriterFile() throws IOException {
        if (bufferedLineWriter != null) {
            bufferedLineWriter.close();
        }
        bufferedLineWriter = new BufferedLineWriter(new BufferedWriter(new FileWriter(file, true)));
        return bufferedLineWriter;
    }

    public void clearFile() {
        this.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        file.delete();
    }
}
