package fr.client.cacount.services.account;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by svirch_n on 25/03/17.
 */
public class SingleWeeklyAccountCalculator extends SingleAccountCalculator {
    public SingleWeeklyAccountCalculator(SingleEntries entries, SingleAccountPreference singleAccountPreference) {
        super(entries, singleAccountPreference);
    }

    @Override
    public BigDecimal getEarnedMoney() {
        return getRatio().multiply(getToday().add(getDaysToNextWeek()));
    }

    public BigDecimal getDaysToNextWeek() {
        return calendar.timeToNextDay(Calendar.MONDAY);
    }
}
