package fr.client.cacount;

import android.os.Environment;

import java.io.*;

/**
 * Created by svirch_n on 11/02/17.
 */
public class AccountFile {

    public static AccountFile Instance = new AccountFile();
    private BufferedReader bufferedReader;
    private float total;

    public AccountFile() {
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), "Transactions.csv")));
            parseFile(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseFile(BufferedReader bufferedReader) throws IOException {
        String line;
        total = 0;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(",");
            float number = Float.parseFloat(split[split.length - 1]);
            total += number;
        }
    }

    public float getTotal() {
        return total;
    }
}
