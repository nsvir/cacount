package fr.client.cacount.services.calendar;

import java.math.BigDecimal;

/**
 * Created by svirch_n on 12/02/17.
 */
public abstract class ACalendar {
    public abstract int today();
    public abstract String nowDate();
    public abstract String nowTime();
    public abstract BigDecimal timeToNextDay(int day);
}
