package fr.client.cacount.services.io.file;

import fr.client.cacount.services.account.SharedEntries;
import fr.client.cacount.services.account.SharedEntry;
import fr.client.cacount.services.calendar.AndroidCalendar;
import fr.client.cacount.services.io.file.AccountFile;
import fr.client.cacount.services.io.manager.ALineManager;
import fr.client.cacount.services.utils.CSVLineCreator;
import fr.client.cacount.utils.log.AndroidLog;

import java.io.IOException;

/**
 * Created by svirch_n on 07/03/17.
 */
public class SharedAccountFile extends AccountFile {

    SharedEntries entries;

    public SharedAccountFile(ALineManager manager) throws IOException, ParserException {
        super(new AndroidLog(), manager, new AndroidCalendar());
    }

    @Override
    protected void createEntries() {
        entries = new SharedEntries();
    }

    @Override
    protected void addEntryFromLine(String[] split) {
        String date = split[0];
        String time = split[1];
        String category = split[2];
        String label = split[3];
        double price = Double.parseDouble(split[4]);
        String owner = split[5];
        SharedEntry entry = createEntry(date, time, owner, category, label, price);
        entries.add(entry);
    }

    private SharedEntry createEntry(String date, String time, String owner, String category, String label, double price) {
        SharedEntry result = new SharedEntry();
        result.date = date;
        result.time = time;
        result.owner = owner;
        result.value = price;
        result.category = category;
        result.label = label;
        return result;
    }

    @Override
    protected void clearEntries() {
        entries.clear();
    }

    public void insert(String owner, String category, String label, double price) {
        String time = calendar.nowTime();
        String date = calendar.nowDate();
        CSVLineCreator.LineCreator lineCreator = new CSVLineCreator.LineCreator()
                .date(date).time(time)
                .category(category).label(label).price(String.valueOf(price))
                .owner(owner);
        entries.add(createEntry(owner, date, time, category, label, price));
        insert(lineCreator);
    }
}
