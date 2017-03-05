package fr.client.cacount.services.account;

import fr.client.cacount.Cacount;
import fr.client.cacount.services.calendar.ACalendar;
import fr.client.cacount.services.calendar.MockCalendar;
import fr.client.cacount.services.io.file.AccountEntry;
import fr.client.cacount.services.io.file.SingleAccountFile;
import fr.client.cacount.services.io.manager.MockLineManager;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by svirch_n on 05/03/17.
 */
public class SingleAccountCalculator {

    private final SingleAccountFile singleAccountFile;
    private final ACalendar calendar;
    private BigDecimal total;
    private BigDecimal earnedMoney;

    protected SingleAccountCalculator(SingleAccountFile singleAccountFile, ACalendar calendar) {
        this.singleAccountFile = singleAccountFile;
        this.calendar = calendar;
    }

    protected SingleAccountCalculator(MockLineManager reader, MockCalendar calendar) throws IOException, SingleAccountFile.ParserException {
        this(new SingleAccountFile(reader, calendar), calendar);
    }


    public BigDecimal getTotal() {
        total = BigDecimal.valueOf(0d);
        for (AccountEntry each : singleAccountFile.getEntries()) {
            total = total.add(BigDecimal.valueOf(each.value));
        }
        return total;
    }

    public BigDecimal getEarnedMoney() {
        return Cacount.getRatio().multiply(getToday());
    }

    public BigDecimal getToday() {
        return BigDecimal.valueOf(calendar.today());
    }

}
