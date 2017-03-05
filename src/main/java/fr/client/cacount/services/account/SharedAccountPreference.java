package fr.client.cacount.services.account;

import fr.client.cacount.services.preferencemanager.AndroidPreferenceManager;

/**
 * Created by svirch_n on 05/03/17.
 */
public class SharedAccountPreference implements AccountPreference {

    private final AndroidPreferenceManager androidPreferenceManager;

    public SharedAccountPreference(AndroidPreferenceManager androidPreferenceManager) {
        this.androidPreferenceManager = androidPreferenceManager;
    }

    @Override
    public SharedAccount createInstance() throws AccountInterface.CouldNotInitiateAccountException {
        return new SharedAccount();
    }

    @Override
    public boolean displayNotification() {
        return androidPreferenceManager.getSharedNotificationDisplayed();
    }

    @Override
    public String getFilename() {
        return androidPreferenceManager.getFilename();
    }
}
