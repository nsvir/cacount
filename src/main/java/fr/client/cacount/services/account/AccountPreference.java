package fr.client.cacount.services.account;

import fr.client.cacount.services.preferencemanager.AndroidPreferenceManager;

import java.math.BigDecimal;

/**
 * Created by svirch_n on 05/03/17.
 */
public class AccountPreference {

    private final AndroidPreferenceManager androidPreferenceManager;

    public AccountPreference(AndroidPreferenceManager androidPreferenceManager) {
        this.androidPreferenceManager = androidPreferenceManager;
    }

    public SingleAccount createInstance() throws AccountInterface.CouldNotInitiateAccountException {
        return new SingleAccount(this);
    }

    public String getFilename() {
        return androidPreferenceManager.getFilename();
    }

    public BigDecimal getRatio() {
        return androidPreferenceManager.getRatio();
    }

    public BigDecimal getDepenses() {
        return androidPreferenceManager.getDepenses();
    }
}
