package fr.client.cacount.services.calendar;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by svirch_n on 20/02/17.
 */
public class CalendarTest {

    public static final int YEAR = 2017;
    public static final int MONTH = 10;
    public static final int DATE = 11;
    public static final int HOUR_OF_DAY = 13;
    public static final int MINUTE = 30;
    public static final int SECOND = 10;

    @Test
    public void nowDate() throws Exception {
        Calendar calendar = getCalendar();
        String expectedDate = DATE + "/" + MONTH + "/" + YEAR;
        assertEquals(expectedDate, calendar.nowDate());
    }

    public static Calendar getCalendar() {
        Calendar calendar = new Calendar();
        java.util.Calendar instance = java.util.Calendar.getInstance();
        instance.set(YEAR, MONTH - 1, DATE, HOUR_OF_DAY, MINUTE, SECOND);
        calendar.setInstance(instance);
        return calendar;
    }

    @Test
    public void nowTime() throws Exception {
        Calendar calendar = getCalendar();
        String expectedTime = HOUR_OF_DAY + ":" + MINUTE + ":" + SECOND;
        assertEquals(expectedTime, calendar.nowTime());
    }

}