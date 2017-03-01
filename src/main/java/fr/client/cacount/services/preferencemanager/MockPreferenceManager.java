package fr.client.cacount.services.preferencemanager;

import java.math.BigDecimal;

/**
 * Created by svirch_n on 01/03/17.
 */
public class MockPreferenceManager implements PreferenceManagerInterface {


    private Double ratio;

    @Override
    public BigDecimal getRatio() {
        return new BigDecimal(ratio);
    }

    public PreferenceManagerInterface ratio(double ratio) {
        this.ratio = ratio;
        return this;
    }
}
