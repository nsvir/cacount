package fr.client.cacount.view.activity;

import android.app.Activity;
import android.os.Bundle;
import fr.client.cacount.R;
import fr.client.cacount.view.utils.UpdateAlarm;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        new UpdateAlarm(this);
        UpdateActivity.updateNotification(this);
        finish();
    }

}
