package fr.client.cacount;

/**
 * Created by svirch_n on 12/02/17.
 */
public class MockCalendar extends ACalendar {

    private final int date;

    public MockCalendar(int date) {
        super();
        this.date = date;
    }

    @Override
    public int today() {
        return date;
    }
}
