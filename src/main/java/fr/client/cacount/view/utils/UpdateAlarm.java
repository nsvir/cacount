package fr.client.cacount.view.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import fr.client.cacount.view.activity.MainActivity;
import fr.client.cacount.view.activity.UpdateActivity;

import java.util.Calendar;

/**
 * Created by svirch_n on 18/02/17.
 */
public class UpdateAlarm extends BroadcastReceiver {

    // this constructor is called by the alarm manager.
    public UpdateAlarm(){ }


    // you can use this constructor to create the alarm.
    //  Just pass in the main activity as the context,
    //  any extras you'd like to get later when triggered
    //  and the timeout
    public UpdateAlarm(Context context) {
        AlarmManager alarmMgr =
                (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, UpdateAlarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(System.currentTimeMillis());
        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);
        time.add(Calendar.DAY_OF_MONTH, 1);
        alarmMgr.set(AlarmManager.RTC, time.getTimeInMillis(), pendingIntent);
    }

    public UpdateAlarm(MainActivity context, int secondes) {
        AlarmManager alarmMgr =
                (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, UpdateAlarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(System.currentTimeMillis());
        time.add(Calendar.SECOND, secondes);
        alarmMgr.set(AlarmManager.RTC, time.getTimeInMillis(), pendingIntent);
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        UpdateActivity.updateNotification(context);
        new UpdateAlarm(context);
    }
}
