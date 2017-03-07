package fr.client.cacount.services.account;

import java.io.IOException;

/**
 * Created by svirch_n on 05/03/17.
 */
public interface AccountPreference {

    AccountInterface createInstance() throws AccountInterface.CouldNotInitiateAccountException;

    boolean displayNotification();
    String getFilename();
}
