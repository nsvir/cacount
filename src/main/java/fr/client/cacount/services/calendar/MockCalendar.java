package fr.client.cacount.services.calendar;

/**
 * Created by svirch_n on 12/02/17.
 */
public class MockCalendar extends ACalendar {

    public static final String DEFAULT_DATE = "01/01/2017";
    public static final String DEFAULT_TIME = "13:30:00";
    private final int date;

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
}
