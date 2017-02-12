package fr.client.cacount;

import android.os.Environment;

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
