package fr.client.cacount.services.calendar;

/**
 * Created by svirch_n on 12/02/17.
 */
public class Calendar extends ACalendar {

    @Override
    public int today() {
        java.util.Calendar instance = java.util.Calendar.getInstance();
        return instance.get(java.util.Calendar.DATE);
    }
}
