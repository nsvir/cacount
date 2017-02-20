package fr.client.cacount.services.calendar;

/**
 * Created by svirch_n on 12/02/17.
 */
public class MockCalendar extends ACalendar {

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
}
