package fr.client.cacount.services.account;

import java.math.BigDecimal;

/**
 * Created by svirch_n on 05/03/17.
 */
public class MockSingleAccountPreference extends SingleAccountPreference {

    private BigDecimal ratio;
    private BigDecimal depenses;

    public MockSingleAccountPreference() {
        super(null);
    }

    public MockSingleAccountPreference ratio(BigDecimal ratio) {
        this.ratio = ratio;
        return this;
    }

    @Override
    public BigDecimal getRatio() {
        return ratio;
    }

    public SingleAccountPreference depenses(BigDecimal bigDecimal) {
        depenses = bigDecimal;
        return this;
    }

    @Override
    public BigDecimal getDepenses() {
        return depenses;
    }
}
