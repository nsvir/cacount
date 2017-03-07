package fr.client.cacount.services.io.file;


import fr.client.cacount.services.account.SingleEntries;
import fr.client.cacount.services.io.manager.MockLineManager;
import fr.client.cacount.utils.log.AndroidLog;
import fr.client.cacount.utils.log.Log;
import fr.client.cacount.services.io.manager.ALineManager;
import fr.client.cacount.services.calendar.*;
import fr.client.cacount.services.utils.CSVLineCreator;
import fr.client.cacount.utils.log.MockLog;

import java.io.*;

/**
 * Created by svirch_n on 11/02/17.
 */
public class SingleAccountFile extends AccountFile {

    private SingleEntries entries;

    public SingleAccountFile(ALineManager manager) throws IOException, ParserException {
        this(manager, new AndroidCalendar(), new AndroidLog());
    }

    public SingleAccountFile(ALineManager manager, ACalendar calendar, Log log) throws IOException, ParserException {
        super(log, manager, calendar);
    }

    public SingleAccountFile(MockLineManager reader, MockCalendar calendar) throws IOException, ParserException {
        this(reader, calendar, new MockLog());
    }

    @Override
    protected void createEntries() {
        entries = new SingleEntries();
    }

    protected void addEntryFromLine(String[] splittedLine) {
        String date = splittedLine[0];
        String time = splittedLine[1];
        String label = splittedLine[3];
        String category = splittedLine[2];
        double price = Double.parseDouble(splittedLine[4]);
        entries.add(createEntry(date, time, label, category, price));
    }

    @Override
    protected void clearEntries() {
        entries.clear();
    }

    private SingleEntry createEntry(String date, String time, String label, String category, double price) {
        SingleEntry entry;
        entry = new SingleEntry();
        entry.date = date;
        entry.time = time;
        entry.category = category;
        entry.label = label;
        entry.value = price;
        return entry;
    }

    public void insert(String category, String label, double price) {
        String time = calendar.nowTime();
        String date = calendar.nowDate();
        CSVLineCreator.LineCreator lineCreator = new CSVLineCreator.LineCreator().date(date).time(time).category(category).label(label).price(String.valueOf(price));
        entries.add(createEntry(date, time, category, label, price));
        insert(lineCreator);
    }

    public SingleEntries getEntries() {
        return entries;
    }

}
