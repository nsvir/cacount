package fr.client.cacount;

import android.content.Context;
import fr.client.cacount.services.account.AccountPreference;
import fr.client.cacount.services.preferencemanager.AndroidPreferenceManager;

/**
 * Created by svirch_n on 12/02/17.
 */
public class Cacount {

    public static final String[] CATEGORY_LIST = {"Alimentaire", "Transport", "Logistique", "Soirée", "Autre", "Soin/Santé"};
    private static AccountPreference PRINCIPAL = null;
    public static final String TAG = "Cacount";

    public static AccountPreference getAccountPreference(Context context) {
        if (PRINCIPAL == null) {
            PRINCIPAL = new AccountPreference(new AndroidPreferenceManager(context));
        }
        return PRINCIPAL;
    }

}
