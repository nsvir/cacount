package fr.client.cacount.services.io.file;


import fr.client.cacount.services.account.SingleEntries;
import fr.client.cacount.services.io.manager.MockLineManager;
import fr.client.cacount.utils.log.AndroidLog;
import fr.client.cacount.utils.log.Log;
import fr.client.cacount.services.io.manager.ALineManager;
import fr.client.cacount.services.io.reader.LineReader;
import fr.client.cacount.services.calendar.*;
import fr.client.cacount.services.io.writer.LineWriter;
import fr.client.cacount.services.utils.CSVLineCreator;
import fr.client.cacount.utils.log.MockLog;

import java.io.*;
import java.util.*;

/**
 * Created by svirch_n on 11/02/17.
 */
public class SingleAccountFile extends AccountFile {

    private final ALineManager manager;
    private LineReader lineReader;
    protected ACalendar calendar;
    private SingleEntries entries;
    private LineWriter lineWriterFile;
    private Log log = new MockLog();

    public SingleAccountFile(ALineManager manager) throws IOException, ParserException {
        this(manager, new AndroidCalendar(), new AndroidLog());

    }

    public SingleAccountFile(ALineManager manager, ACalendar calendar, Log log) throws IOException, ParserException {
        this.calendar = calendar;
        this.manager = manager;
        this.log = log;
        this.entries = new SingleEntries();
        load();
    }

    public SingleAccountFile(MockLineManager reader, MockCalendar calendar) throws IOException, ParserException {
        this(reader, calendar, new MockLog());
    }

    private void load() throws IOException, ParserException {
        lineReader = manager.createLineReaderFile();
        parseFile(lineReader);
        lineWriterFile = manager.createLineWriterFile();
    }

    private void parseFile(LineReader lineReader) throws IOException, ParserException {
        String line;
        this.entries.clear();
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
        SingleEntry entry;
        entry = new SingleEntry();
        entry.date = date;
        entry.time = time;
        entry.category = category;
        entry.label = label;
        entry.value = price;
        entries.add(entry);
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

    public void reload() throws IOException, ParserException {
        load();
    }

    public SingleEntries getEntries() {
        return entries;
    }

    public class ParserException extends Exception {
    }
}
