package fr.client.cacount.services.account;

import fr.client.cacount.services.calendar.ACalendar;
import fr.client.cacount.services.calendar.AndroidCalendar;
import fr.client.cacount.services.calendar.MockCalendar;
import fr.client.cacount.services.io.file.SingleEntry;
import fr.client.cacount.services.io.file.SingleAccountFile;
import fr.client.cacount.services.io.manager.MockLineManager;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by svirch_n on 05/03/17.
 */
public class SingleAccountCalculator {

    private final SingleEntries singleAccountFile;
    private final BigDecimal ratio;
    private ACalendar calendar;
    private BigDecimal total;
    private BigDecimal earnedMoney;



    protected SingleAccountCalculator(SingleEntries singleEntries, BigDecimal ratio) {
        this.singleAccountFile = singleEntries;
        this.calendar = new AndroidCalendar();
        this.ratio = ratio;
    }

    protected SingleAccountCalculator(SingleEntries singleEntries, MockCalendar calendar, BigDecimal ratio) throws IOException, SingleAccountFile.ParserException {
        this(singleEntries, ratio);
        this.calendar = calendar;
    }

    public SingleAccountCalculator(SingleEntries singleEntries, MockCalendar mockCalendar) throws IOException, SingleAccountFile.ParserException {
        this(singleEntries, mockCalendar, BigDecimal.ZERO);
    }

    public BigDecimal getTotal() {
        total = BigDecimal.valueOf(0d);
        for (SingleEntry each : singleAccountFile.getEntries()) {
            total = total.add(BigDecimal.valueOf(each.value));
        }
        return total;
    }

    public BigDecimal getEarnedMoney() {
        return getRatio().multiply(getToday());
    }

    public BigDecimal getToday() {
        return BigDecimal.valueOf(calendar.today());
    }

    public BigDecimal getRatio() {
        return ratio;
    }
}
