package fr.client.cacount.services.preferencemanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import fr.client.cacount.R;

import java.math.BigDecimal;

/**
 * Created by svirch_n on 01/03/17.
 */
public class AndroidPreferenceManager implements PreferenceManagerInterface {

    private final SharedPreferences preference;
    private final String ratio;

    public AndroidPreferenceManager(Context context) {
        this.preference = PreferenceManager.getDefaultSharedPreferences(context);
        ratio = context.getString(R.string.pref_ratio);
    }

    @Override
    public BigDecimal getRatio() {
        return new BigDecimal(preference.getString(ratio, "0.0"));
    }
}
