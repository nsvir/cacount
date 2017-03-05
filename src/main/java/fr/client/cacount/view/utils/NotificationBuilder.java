package fr.client.cacount.view.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import fr.client.cacount.view.activity.InsertActivity;

/**
 * Created by svirch_n on 11/02/17.
 */
public class NotificationBuilder extends NotificationCompat.Builder {

    private final Context context;
    private Notification notification;

    public NotificationBuilder(Context context) {
        super(context);
        this.context = context;
    }

    public void addPendingIntent(Class className, Boolean isShared) {
        Intent intent = new Intent(context, className);
        if (isShared) {
            intent.putExtra(InsertActivity.IS_SHARED, true);
        }
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        this.setContentIntent(pendingIntent);
    }

    public Notification buildAndNotify(int notificatin_id) {
        notification = this.build();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificatin_id, notification);
        return notification;
    }


}
