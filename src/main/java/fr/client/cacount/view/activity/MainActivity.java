package fr.client.cacount.view.activity;

import android.app.Activity;
import android.os.Bundle;
import fr.client.cacount.view.activity.fragment.ConfigurationFragment;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new ConfigurationFragment())
                .commit();
        UpdateActivity.updateNotification(this);
    }

}
