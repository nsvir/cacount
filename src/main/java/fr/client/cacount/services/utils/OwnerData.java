package fr.client.cacount.services.utils;

import java.math.BigDecimal;

/**
 * Created by svirch_n on 07/03/17.
 */
public class OwnerData {

    public String owner;
    public BigDecimal difference;
    public BigDecimal total;

    public OwnerData(String key, BigDecimal value, BigDecimal i) {
        owner = key;
        difference = i;
        total = value;
    }
}
