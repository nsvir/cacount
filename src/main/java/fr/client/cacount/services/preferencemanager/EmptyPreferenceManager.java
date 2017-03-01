package fr.client.cacount.services.preferencemanager;

import java.math.BigDecimal;

/**
 * Created by svirch_n on 01/03/17.
 */
public class EmptyPreferenceManager implements PreferenceManagerInterface {
    @Override
    public BigDecimal getRatio() {
        return BigDecimal.ZERO;
    }
}
