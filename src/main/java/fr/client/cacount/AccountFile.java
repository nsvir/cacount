package fr.client.cacount;

import android.os.Environment;

import java.io.*;
import java.util.Calendar;

/**
 * Created by svirch_n on 11/02/17.
 */
public class AccountFile {

    public static AccountFile Instance = new AccountFile();
    private BufferedReader bufferedReader;
    private double total;
    private int day;

    public AccountFile() {
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), "Transactions.csv")));
            parseFile(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseFile(BufferedReader bufferedReader) throws IOException {
        boolean first = true;
        String line;
        total = 0;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(",");
            if (first){
                Calendar instance = Calendar.getInstance();
                int today = instance.get(Calendar.DATE);
                day = today - Integer.parseInt(split[0].split("/")[1]);
                first = false;
            }
            double number = Double.parseDouble(split[split.length - 1]);
            total += number;
        }
    }

    public double getTotal() {
        return total;
    }

    public double getEarnedMoney() {
        return Cacount.RATIO * day;
    }
}
