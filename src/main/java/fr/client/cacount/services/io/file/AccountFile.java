package fr.client.cacount.services.io.file;

import fr.client.cacount.services.calendar.ACalendar;
import fr.client.cacount.services.io.manager.ALineManager;
import fr.client.cacount.services.io.reader.LineReader;
import fr.client.cacount.services.io.writer.LineWriter;
import fr.client.cacount.services.utils.CSVLineCreator;
import fr.client.cacount.utils.log.Log;
import fr.client.cacount.utils.log.MockLog;

import java.io.IOException;

/**
 * Created by svirch_n on 07/03/17.
 */
public abstract class AccountFile {
    protected final ALineManager manager;
    protected LineWriter lineWriterFile;
    protected Log log = new MockLog();
    protected ACalendar calendar;
    private LineReader lineReader;

    public AccountFile(Log log, ALineManager manager, ACalendar calendar) throws IOException, ParserException {
        this.log = log;
        this.manager = manager;
        this.calendar = calendar;
        createEntries();
        load();
    }

    protected abstract void createEntries();

    protected void insert(CSVLineCreator.LineCreator lineCreator) {
        String line = lineCreator.toString();
        try {
            lineWriterFile.writeLine(line);
            log.d("Inserted: " + line);
        } catch (IOException e) {
            e.printStackTrace();
            log.w("Could not insert: " + line);
        }
    }

    protected void load() throws IOException, ParserException {
        lineReader = manager.createLineReaderFile();
        parseFile(lineReader);
        lineWriterFile = manager.createLineWriterFile();
    }

    private void parseFile(LineReader lineReader) throws IOException, ParserException {
        String line;
        clearEntries();
        while ((line = lineReader.readLine()) != null) {
            String[] split = line.split(",");
            try {
                addEntryFromLine(split);
            } catch (Exception e) {
                throw new ParserException();
            }
        }
    }

    protected abstract void addEntryFromLine(String[] split);

    protected abstract void clearEntries();

    public void reload() throws IOException, ParserException {
        load();
    }

    public abstract String[] getLabels();


    public class ParserException extends Exception {
    }
}
