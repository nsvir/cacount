package fr.client.cacount.view.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import fr.client.cacount.Cacount;
import fr.client.cacount.services.account.AccountInterface;
import fr.client.cacount.services.account.SingleAccount;
import fr.client.cacount.services.preferencemanager.AndroidPreferenceManager;
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
            NotificationContent notificationBuilder = Cacount.getAccountPreference(context).createInstance().getNotificationContent();
            DefaultNotificationBuilder defaultNotificationBuilder = new DefaultNotificationBuilder(context, notificationBuilder);
            defaultNotificationBuilder.buildAndNotify();
        } catch (AccountInterface.CouldNotInitiateAccountException e) {
            e.printStackTrace();
        }
    }
}
