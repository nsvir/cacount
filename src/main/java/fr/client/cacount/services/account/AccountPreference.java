package fr.client.cacount.services.account;

/**
 * Created by svirch_n on 05/03/17.
 */
public class AccountPreference {

    public final String filename;

    public AccountPreference(String filename) {
        this.filename = filename;

    }

    public SingleAccount createInstance() throws AccountInterface.CouldNotInitiateAccountException {
        return new SingleAccount(filename);
    }
}
