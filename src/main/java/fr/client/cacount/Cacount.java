package fr.client.cacount;

import fr.client.cacount.services.account.AccountPreference;
import fr.client.cacount.services.preferencemanager.EmptyPreferenceManager;
import fr.client.cacount.services.preferencemanager.PreferenceManagerInterface;

import java.math.BigDecimal;

/**
 * Created by svirch_n on 12/02/17.
 */
public class Cacount {

    public static final String[] CATEGORY_LIST = {"Alimentaire", "Transport", "Logistique", "Soirée", "Autre", "Soin/Santé"};
    public static final AccountPreference PRINCIPAL = new AccountPreference("Transactions.csv");
    public static final String TAG = "Cacount";
    private static PreferenceManagerInterface preferenceManager = new EmptyPreferenceManager();

    public static void setPreferenceManager(PreferenceManagerInterface preference) {
        preferenceManager = preference;
    }

    public static BigDecimal getRatio() {
        return preferenceManager.getRatio();
    }
}
