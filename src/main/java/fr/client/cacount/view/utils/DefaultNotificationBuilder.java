package fr.client.cacount.view.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import fr.client.cacount.view.activity.InsertActivity;
import fr.client.cacount.R;

/**
 * Created by svirch_n on 11/02/17.
 */
public class DefaultNotificationBuilder extends NotificationBuilder {

    public static final int PRIORITY = NotificationCompat.PRIORITY_MIN;


    public DefaultNotificationBuilder(Context context, NotificationContent content) {
        super(context);

        if (content != null) {
            setContentTitle(content.title);
            if (content.content != null) {
                setContentText(content.content);
            }
        }
        setSmallIcon(R.drawable.ic_launcher);
        setPriority(PRIORITY);
        setOngoing(true);
        addPendingIntent(InsertActivity.class);
    }
}
