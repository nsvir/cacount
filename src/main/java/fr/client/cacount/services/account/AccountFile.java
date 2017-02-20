package fr.client.cacount.services.account;


import fr.client.cacount.services.io.manager.ALineManager;
import fr.client.cacount.Cacount;
import fr.client.cacount.services.io.reader.LineReader;
import fr.client.cacount.services.io.manager.LineManager;
import fr.client.cacount.services.calendar.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by svirch_n on 11/02/17.
 */
public class AccountFile {

    private static AccountFile instance;
    private LineReader lineReader;
    private BigDecimal total = null;
    private BigDecimal day;
    protected ACalendar calendar;
    private List<AccountEntry> entries;

    public static AccountFile getInstance() {
        if (instance == null) {
            try {
                instance = new AccountFile(new LineManager(), new fr.client.cacount.services.calendar.Calendar());
            } catch (IOException e) {
                throw new RuntimeException("Could not manipulate file: " + Cacount.FILENAME);
            }
        }
        return instance;
    }

    protected AccountFile(ALineManager lineReaderManager, ACalendar calendar) {
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
        if (total == null) {
            total = BigDecimal.valueOf(0d);
            for (AccountEntry each : this.entries) {
                total = total.add(BigDecimal.valueOf(each.value));
            }
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
        if (day == null) {
            int today = calendar.today();
            day = BigDecimal.valueOf(today).subtract(getFirstInsertionDay());
        }
        return day;
    }

    private BigDecimal getFirstInsertionDay() {
        if (entries.size() == 0){
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(Integer.parseInt(entries.get(0).date.split("/")[0]));
    }

    private class ParserException extends Exception {
    }
}
