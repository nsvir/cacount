package fr.client.cacount.services.calendar;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by svirch_n on 25/03/17.
 */
public class AndroidCalendarTest {
    @Test
    public void timeToNextDay() throws Exception {
        AndroidCalendar androidCalendar = new AndroidCalendar();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(Calendar.WEEK_OF_MONTH, 0);
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        androidCalendar.instance = gregorianCalendar;
        assertEquals(7, androidCalendar.timeToNextDay(Calendar.MONDAY).intValue());
        assertEquals(1, androidCalendar.timeToNextDay(Calendar.TUESDAY).intValue());
    }

    @Test
    public void daysBetween() throws Exception {

    }

}