package fr.client.cacount;

import android.content.Context;
import fr.client.cacount.services.account.AccountPreference;
import fr.client.cacount.services.account.SharedAccountPreference;
import fr.client.cacount.services.account.SingleAccountPreference;
import fr.client.cacount.services.preferencemanager.AndroidPreferenceManager;

/**
 * Created by svirch_n on 12/02/17.
 */
public class Cacount {

    public static final String[] CATEGORY_LIST = {"Alimentaire", "Transport", "Logistique", "Soirée", "Autre", "Soin/Santé"};
    private static SharedAccountPreference SHARED = null;
    private static SingleAccountPreference PRINCIPAL = null;
    public static final String TAG = "Cacount";

    public static AccountPreference[] getAccounts(Context context) {
        return new AccountPreference[]{getMainAccount(context), getSharedAccount(context)};
    }

    public static SingleAccountPreference getMainAccount(Context context) {
        if (PRINCIPAL == null) {
            PRINCIPAL = new SingleAccountPreference(new AndroidPreferenceManager(context));
        }
        return PRINCIPAL;
    }

    public static SharedAccountPreference getSharedAccount(Context context) {
        if (SHARED == null) {
            SHARED = new SharedAccountPreference(new AndroidPreferenceManager(context));
        }
        return SHARED;
    }
}
