package fr.client.cacount.services.calendar;

import java.math.BigDecimal;

/**
 * Created by svirch_n on 12/02/17.
 */
public class MockCalendar extends ACalendar {

    public static final String DEFAULT_DATE = "01/01/2017";
    public static final String DEFAULT_TIME = "13:30:00";
    private static final BigDecimal DEFAULT_TIME_NEXT_DAY = BigDecimal.ONE;
    private final int date;
    private BigDecimal timeToNextDay;

    public MockCalendar(int date) {
        super();
        this.date = date;
    }

    public MockCalendar() {
        date = 0;
    }

    @Override
    public int today() {
        return date;
    }

    @Override
    public String nowDate() {
        return DEFAULT_DATE;
    }

    @Override
    public String nowTime() {
        return DEFAULT_TIME;
    }

    public MockCalendar nextDay(int days) {
        this.timeToNextDay = new BigDecimal(days);
        return this;
    }

    @Override
    public BigDecimal timeToNextDay(int day) {
        return this.timeToNextDay;
    }
}
