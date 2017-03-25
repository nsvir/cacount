package fr.client.cacount.services.account;

import fr.client.cacount.services.calendar.MockCalendar;
import fr.client.cacount.services.io.file.AccountFile;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by svirch_n on 25/03/17.
 */
public class SingleDailyAccountCalculator extends SingleAccountCalculator {
    public SingleDailyAccountCalculator(SingleEntries entries, SingleAccountPreference singleAccountPreference) {
        super(entries, singleAccountPreference);
    }

    public SingleDailyAccountCalculator(SingleEntries singleEntries, MockCalendar calendar, BigDecimal ratio) throws IOException, AccountFile.ParserException {
        super(singleEntries, calendar, ratio);
    }

    public SingleDailyAccountCalculator(SingleEntries singleEntries, MockCalendar mockCalendar) throws IOException, AccountFile.ParserException {
        super(singleEntries, mockCalendar);
    }

    @Override
    public BigDecimal getEarnedMoney() {
        return getRatio().multiply(getToday());
    }
}
