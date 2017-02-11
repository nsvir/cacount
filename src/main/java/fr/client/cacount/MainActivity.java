package fr.client.cacount;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

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
        float total = AccountFile.Instance.getTotal();
        DefaultNotificationBuilder builder = new DefaultNotificationBuilder(context, total + "€!", "Hum it's getting better");
        builder.buildAndNotify();
    }
}
