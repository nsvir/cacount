package fr.client.cacount.view.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import fr.client.cacount.R;
import fr.client.cacount.view.utils.UpdateAlarm;

public class MainActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        registerComponentCallbacks(this);
        UpdateActivity.updateNotification(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
}
