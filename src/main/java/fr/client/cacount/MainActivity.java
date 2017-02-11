package fr.client.cacount;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import java.util.Locale;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

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
