package fr.client.cacount.services.account;

import fr.client.cacount.services.calendar.ACalendar;
import fr.client.cacount.services.calendar.AndroidCalendar;
import fr.client.cacount.services.calendar.MockCalendar;
import fr.client.cacount.services.io.file.AccountFile;
import fr.client.cacount.services.io.file.SingleEntry;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by svirch_n on 05/03/17.
 */
public abstract class SingleAccountCalculator {

    private final SingleEntries singleAccountFile;
    protected ACalendar calendar;
    private BigDecimal total;
    private SingleAccountPreference singleAccountPreference;


    protected SingleAccountCalculator(SingleEntries singleEntries, SingleAccountPreference singleAccountPreference) {
        this.singleAccountFile = singleEntries;
        this.calendar = new AndroidCalendar();
        this.singleAccountPreference = singleAccountPreference;
    }

    protected SingleAccountCalculator(SingleEntries singleEntries, MockCalendar calendar, BigDecimal ratio) throws IOException, AccountFile.ParserException {
        this(singleEntries, new MockSingleAccountPreference().ratio(ratio).depenses(BigDecimal.valueOf(0.0)));
        this.calendar = calendar;
    }

    public SingleAccountCalculator(SingleEntries singleEntries, MockCalendar mockCalendar) throws IOException, AccountFile.ParserException {
        this(singleEntries, mockCalendar, BigDecimal.ZERO);
    }

    public BigDecimal getTotal() {
        total = singleAccountPreference.getDepenses();
        for (SingleEntry each : singleAccountFile.getEntries()) {
            total = total.add(BigDecimal.valueOf(each.value));
        }
        return total;
    }

    public abstract BigDecimal getEarnedMoney();

    public BigDecimal getToday() {
        return BigDecimal.valueOf(calendar.today());
    }

    public BigDecimal getRatio() {
        return singleAccountPreference.getRatio();
    }
}
