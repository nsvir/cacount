package fr.client.cacount.services.account;

import java.math.BigDecimal;

/**
 * Created by svirch_n on 05/03/17.
 */
public class AccountPreference {

    public final String filename;
    public BigDecimal ratio;
    public BigDecimal depenses;

    protected AccountPreference() {
        filename = "";
    }

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

    public AccountPreference ratio(BigDecimal ratio) {
        this.ratio = ratio;
        return this;
    }

    public AccountPreference depenses(BigDecimal depenses) {
        this.depenses = depenses;
        return this;
    }
}
