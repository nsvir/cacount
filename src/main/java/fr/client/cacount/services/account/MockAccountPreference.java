package fr.client.cacount.services.account;

import fr.client.cacount.services.preferencemanager.AndroidPreferenceManager;

import java.math.BigDecimal;

/**
 * Created by svirch_n on 05/03/17.
 */
public class MockAccountPreference extends AccountPreference {

    private BigDecimal ratio;
    private BigDecimal depenses;

    public MockAccountPreference() {
        super(null);
    }

    public MockAccountPreference ratio(BigDecimal ratio) {
        this.ratio = ratio;
        return this;
    }

    @Override
    public BigDecimal getRatio() {
        return ratio;
    }

    public AccountPreference depenses(BigDecimal bigDecimal) {
        depenses = bigDecimal;
        return this;
    }

    @Override
    public BigDecimal getDepenses() {
        return depenses;
    }
}
