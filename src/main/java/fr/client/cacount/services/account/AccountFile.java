package fr.client.cacount.services.account;


import fr.client.cacount.services.io.ALineReaderManager;
import fr.client.cacount.Cacount;
import fr.client.cacount.services.io.LineReader;
import fr.client.cacount.services.io.LineReaderManager;
import fr.client.cacount.services.calendar.*;

import java.io.*;
import java.util.*;

/**
 * Created by svirch_n on 11/02/17.
 */
public class AccountFile {

    private static AccountFile instance;
    private LineReader lineReader;
    private Double total = null;
    private Integer day;
    protected ACalendar calendar;
    private List<AccountEntry> entries;

    public static AccountFile getInstance() {
        if (instance == null) {
            instance = new AccountFile(new LineReaderManager(), new fr.client.cacount.services.calendar.Calendar());
        }
        return instance;
    }

    protected AccountFile(ALineReaderManager lineReaderManager, ACalendar calendar) {
        this.calendar = calendar;
        try {
            lineReader = lineReaderManager.getLineReaderFile();
            parseFile(lineReader);
        } catch (IOException | ParserException e) {
            e.printStackTrace();
        }
    }

    private void parseFile(LineReader lineReader) throws IOException, ParserException {
        String line;
        entries = new ArrayList<>();
        AccountEntry entry;
        while ((line = lineReader.readLine()) != null) {
            String[] split = line.split(",");
            if (split.length != 5) {
                throw new ParserException();
            }
            entry = new AccountEntry();
            entry.date = split[0];
            entry.time = split[1];
            entry.category = split[2];
            entry.label = split[3];
            entry.value = Double.parseDouble(split[4]);
            entries.add(entry);
        }
    }

    public Map<String, Double> getCategoriesTotal() {
        HashMap<String, Double> result = new HashMap<>();
        for (AccountEntry each : entries) {
            if (result.containsKey(each.category)) {
                Double oldValue = result.get(each.category);
                result.put(each.category, oldValue + each.value);
            } else {
                result.put(each.category, each.value);
            }
        }
        return result;
    }

    public double getTotal() {
        if (total == null) {
            total = 0d;
            for (AccountEntry each : this.entries) {
                total += each.value;
            }
        }
        return total;
    }

    public double getEarnedMoney() {
        return Cacount.RATIO * getDay();
    }

    /**
     * @return Elapsed date between the first insertion and today
     */
    public int getDay() {
        if (day == null) {
            int today = calendar.today();
            day = today - getFirstInsertionDay();
        }
        return day;
    }

    private int getFirstInsertionDay() {
        if (entries.size() == 0){
            return 0;
        }
        return Integer.parseInt(entries.get(0).date.split("/")[0]);
    }

    private class ParserException extends Exception {
    }
}
