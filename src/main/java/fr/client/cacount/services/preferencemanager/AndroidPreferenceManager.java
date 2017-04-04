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
    private final String filename;
    private final String depenses;
    private final String notification;
    private final String sharedNotification;
    private final String sharedFilename;
    private final String transferType;

    public AndroidPreferenceManager(Context context) {
        this.preference = PreferenceManager.getDefaultSharedPreferences(context);
        ratio = context.getString(R.string.pref_ratio);
        filename = context.getString(R.string.pref_filename);
        depenses = context.getString(R.string.pref_depenses);
        notification = context.getString(R.string.pref_notification);
        sharedNotification = context.getString(R.string.pref_shared_notification);
        sharedFilename = context.getString(R.string.pref_shared_filename);
        transferType = context.getString(R.string.pref_transfer_type);
    }

    @Override
    public BigDecimal getRatio() {
        return new BigDecimal(getPreferenceString(ratio, "0.0"));
    }

    public String getFilename() {
        return getPreferenceString(filename, "defaultCacount.csv");
    }

    private String getPreferenceString(String filename, String defValue) {
        String string = preference.getString(filename, defValue);
        return string == null || string.isEmpty() ? defValue : string;
    }

    public BigDecimal getDepenses() {
        return new BigDecimal(getPreferenceString(depenses, "0.0"));
    }

    public boolean getNotificationDisplayed() {
        return preference.getBoolean(notification, true);
    }

    public boolean getSharedNotificationDisplayed() {
        return false;
    }

    public String getSharedFilename() {
        return getPreferenceString(sharedFilename, "defaultSharedCacount.csv");
    }

    public String getTransferType() {
        return getPreferenceString(transferType, "DAILY");
    }
}
