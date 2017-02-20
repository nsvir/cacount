package fr.client.cacount.services.io;

import android.os.Environment;
import fr.client.cacount.services.io.ALineReaderManager;
import fr.client.cacount.services.io.BufferedLineReader;
import fr.client.cacount.services.io.LineReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by svirch_n on 12/02/17.
 */
public class LineReaderManager implements ALineReaderManager {

    @Override
    public LineReader getLineReaderFile() throws FileNotFoundException {
        return new BufferedLineReader(new BufferedReader(new FileReader(new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "Transactions.csv"))));
    }
}
