package fr.client.cacount.view.activity;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import fr.client.cacount.Cacount;
import fr.client.cacount.services.account.AccountInterface;
import fr.client.cacount.services.account.AccountPreference;
import fr.client.cacount.services.account.SingleAccountPreference;
import fr.client.cacount.view.utils.DefaultNotificationBuilder;
import fr.client.cacount.view.utils.NotificationContent;

/**
 * Created by svirch_n on 18/02/17.
 */
public class UpdateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateNotification(this);
        finish();
    }

    public static void updateNotification(Context context) {
        try {
            NotificationContent main = Cacount.getMainAccount(context).createInstance().getNotificationContent();
            NotificationContent shared = Cacount.getSharedAccount(context).createInstance().getNotificationContent();
            NotificationContent notificationBuilder = new NotificationContent(1).title(main.title).content(shared.content);
            DefaultNotificationBuilder defaultNotificationBuilder = new DefaultNotificationBuilder(context, notificationBuilder);
            defaultNotificationBuilder.buildAndNotify(notificationBuilder.notificationID);
        } catch (AccountInterface.CouldNotInitiateAccountException e) {
            e.printStackTrace();
        }
    }
}
