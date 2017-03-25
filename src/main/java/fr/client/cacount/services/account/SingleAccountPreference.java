package fr.client.cacount.services.account;

import fr.client.cacount.services.preferencemanager.AndroidPreferenceManager;

import java.math.BigDecimal;

/**
 * Created by svirch_n on 05/03/17.
 */
public class SingleAccountPreference implements AccountPreference {

    public static final String WEEKLY = "WEEKLY";
    public static final String DAILY = "DAILY";
    private final AndroidPreferenceManager androidPreferenceManager;

    public SingleAccountPreference(AndroidPreferenceManager androidPreferenceManager) {
        this.androidPreferenceManager = androidPreferenceManager;
    }

    @Override
    public SingleAccount createInstance() throws AccountInterface.CouldNotInitiateAccountException {
        return new SingleAccount(this);
    }

    @Override
    public boolean displayNotification() {
        return androidPreferenceManager.getNotificationDisplayed();
    }

    @Override
    public String getFilename() {
        return androidPreferenceManager.getFilename();
    }

    public BigDecimal getRatio() {
        return androidPreferenceManager.getRatio();
    }

    public BigDecimal getDepenses() {
        return androidPreferenceManager.getDepenses();
    }

    public String getTransferType() {
        return androidPreferenceManager.getTransferType();
    }
}
