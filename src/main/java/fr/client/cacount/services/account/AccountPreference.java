package fr.client.cacount.services.account;

import java.math.BigDecimal;

/**
 * Created by svirch_n on 05/03/17.
 */
public class AccountPreference {

    public final String filename;
    public final BigDecimal ratio;

    public AccountPreference(String filename) {
        this(filename, BigDecimal.ZERO);
    }

    public AccountPreference(String filename, BigDecimal ratio) {
        this.filename = filename;
        this.ratio = ratio;
    }

    public SingleAccount createInstance() throws AccountInterface.CouldNotInitiateAccountException {
        return new SingleAccount(this);
    }
}
