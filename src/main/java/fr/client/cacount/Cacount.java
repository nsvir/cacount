package fr.client.cacount;

import android.content.Context;
import fr.client.cacount.services.account.AccountPreference;
import fr.client.cacount.services.preferencemanager.AndroidPreferenceManager;
import fr.client.cacount.services.preferencemanager.EmptyPreferenceManager;
import fr.client.cacount.services.preferencemanager.PreferenceManagerInterface;

import java.math.BigDecimal;

/**
 * Created by svirch_n on 12/02/17.
 */
public class Cacount {

    public static final String[] CATEGORY_LIST = {"Alimentaire", "Transport", "Logistique", "Soirée", "Autre", "Soin/Santé"};
    private static AccountPreference PRINCIPAL = null;
    public static final String TAG = "Cacount";

    public static AccountPreference getAccountPreference(Context context) {
        if (PRINCIPAL == null) {
            AndroidPreferenceManager androidPreferenceManager = new AndroidPreferenceManager(context);
            PRINCIPAL = new AccountPreference(androidPreferenceManager.getFilename(), androidPreferenceManager.getRatio());
        }
        return PRINCIPAL;
    }
}
