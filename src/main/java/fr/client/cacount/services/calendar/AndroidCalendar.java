package fr.client.cacount.services.calendar;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by svirch_n on 12/02/17.
 */
public class AndroidCalendar extends ACalendar {

    private java.util.Calendar instance;

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

    /**
     * used in unit test
     * @param instance date
     */
    void setInstance(java.util.Calendar instance) {
        this.instance = instance;
    }
}
