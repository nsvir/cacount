package fr.client.cacount;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import java.util.Locale;

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
        double total = AccountFile.Instance.getTotal();
        double earnedMoney = AccountFile.Instance.getEarnedMoney();
        DefaultNotificationBuilder builder = new DefaultNotificationBuilder(context, String.format(Locale.FRANCE, "%.2f€", (earnedMoney - total), Cacount.RATIO),
                "Next day: +" + Cacount.RATIO + "€");
        builder.buildAndNotify();
    }
}
