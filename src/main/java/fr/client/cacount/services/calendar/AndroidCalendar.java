package fr.client.cacount.services.calendar;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created by svirch_n on 12/02/17.
 */
public class AndroidCalendar extends ACalendar {

    protected java.util.Calendar instance;

    public AndroidCalendar() {
        this.instance = java.util.Calendar.getInstance();
    }

    @Override
    public int today() {
        return instance.get(java.util.Calendar.DATE);
    }

    @Override
    public String nowDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        return simpleDateFormat.format(instance.getTime());
    }

    @Override
    public String nowTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.FRANCE);
        return simpleDateFormat.format(instance.getTime());
    }

    @Override
    public BigDecimal timeToNextDay(int day) {
        Calendar nextDay = (Calendar) instance.clone();
        nextDay.set(Calendar.DAY_OF_WEEK, day);
        long daysBetween = daysBetween(nextDay, instance);
        return new BigDecimal(daysBetween == 0 ? 7 : daysBetween);
    }

    public static long daysBetween(Calendar startDate, Calendar endDate) {
        long end = endDate.getTimeInMillis();
        long start = startDate.getTimeInMillis();
        return TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
    }

    /**
     * used in unit test
     * @param instance date
     */
    void setInstance(java.util.Calendar instance) {
        this.instance = instance;
    }
}
