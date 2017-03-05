package fr.client.cacount.view.activity.fragment;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import fr.client.cacount.Cacount;
import fr.client.cacount.R;
import fr.client.cacount.view.activity.UpdateActivity;

/**
 * Created by svirch_n on 05/03/17.
 */
public class ConfigurationFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        UpdateActivity.updateNotification(getActivity());
    }
}
