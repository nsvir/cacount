package fr.client.cacount.services.account;


import fr.client.cacount.utils.log.AndroidLog;
import fr.client.cacount.utils.log.Log;
import fr.client.cacount.services.io.manager.ALineManager;
import fr.client.cacount.Cacount;
import fr.client.cacount.services.io.reader.LineReader;
import fr.client.cacount.services.io.manager.LineManager;
import fr.client.cacount.services.calendar.*;
import fr.client.cacount.services.io.writer.LineWriter;
import fr.client.cacount.services.utils.CSVLineCreator;
import fr.client.cacount.utils.log.MockLog;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by svirch_n on 11/02/17.
 */
public class AccountFile {

    private static AccountFile instance;
    private final ALineManager manager;
    private LineReader lineReader;
    private BigDecimal total = null;
    private BigDecimal day;
    protected ACalendar calendar;
    private List<AccountEntry> entries;
    private LineWriter lineWriterFile;
    private Log log = new MockLog();

    public static AccountFile getInstance() {
        if (instance == null) {
            try {
                instance = new AccountFile(new LineManager(Cacount.FILENAME), new fr.client.cacount.services.calendar.Calendar());
                instance.log = new AndroidLog();
            } catch (IOException | ParserException e) {
                throw new RuntimeException("Could not manipulate file: " + Cacount.FILENAME);
            }
        }
        return instance;
    }

    protected AccountFile(ALineManager manager, ACalendar calendar) throws IOException, ParserException {
        this.calendar = calendar;
        this.manager = manager;
        load();

    }

    private void load() throws IOException, ParserException {
        lineReader = manager.createLineReaderFile();
        parseFile(lineReader);
        lineWriterFile = manager.createLineWriterFile();
    }

    private void parseFile(LineReader lineReader) throws IOException, ParserException {
        String line;
        entries = new ArrayList<>();
        while ((line = lineReader.readLine()) != null) {
            String[] split = line.split(",");
            if (split.length != 5) {
                throw new ParserException();
            }
            String date = split[0];
            String time = split[1];
            String label = split[3];
            String category = split[2];
            double price = Double.parseDouble(split[4]);
            addEntry(date, time, label, category, price);
        }
    }

    private void addEntry(String date, String time, String label, String category, double price) {
        AccountEntry entry;
        entry = new AccountEntry();
        entry.date = date;
        entry.time = time;
        entry.category = category;
        entry.label = label;
        entry.value = price;
        entries.add(entry);
    }

    public HashMap<String, BigDecimal> getCategoriesTotal() {
        HashMap<String, BigDecimal> result = new HashMap<>();
        for (AccountEntry each : entries) {
            if (result.containsKey(each.category)) {
                BigDecimal oldValue = result.get(each.category);
                BigDecimal newValue = oldValue.add(BigDecimal.valueOf(each.value));
                result.put(each.category, newValue);
            } else {
                result.put(each.category, BigDecimal.valueOf(each.value));
            }
        }
        return result;
    }

    public BigDecimal getTotal() {
        total = BigDecimal.valueOf(0d);
        for (AccountEntry each : this.entries) {
            total = total.add(BigDecimal.valueOf(each.value));
        }
        return total;
    }

    public BigDecimal getEarnedMoney() {
        return Cacount.RATIO.multiply(getDay());
    }

    /**
     * @return Elapsed date between the first insertion and today
     */
    public BigDecimal getDay() {
        return BigDecimal.valueOf(calendar.today());
    }

    public void insert(String category, String label, double price) {
        String time = calendar.nowTime();
        String date = calendar.nowDate();
        addEntry(date, time, category, label, price);
        String line = new CSVLineCreator.LineCreator().date(date).time(time).category(category).label(label).price(String.valueOf(price)).toString();
        try {
            lineWriterFile.writeLine(line);
            log.d("Inserted: " + line);
        } catch (IOException e) {
            e.printStackTrace();
            log.w("Could not insert: " + line);
        }
    }

    public void reload() {

    }

    private class ParserException extends Exception {
    }
}
