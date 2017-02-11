package fr.client.cacount;

import android.content.Context;
import android.support.v4.app.NotificationCompat;

/**
 * Created by svirch_n on 11/02/17.
 */
public class DefaultNotificationBuilder extends NotificationBuilder {

    public static final int PRIORITY = NotificationCompat.PRIORITY_MIN;


    public DefaultNotificationBuilder(Context context, String title, String content) {
        super(context);

        setContentTitle(title);
        setContentText(content);
        setSmallIcon(R.drawable.ic_launcher);
        setPriority(PRIORITY);
        setOngoing(true);
        addPendingIntent(InsertActivity.class);
    }


}
