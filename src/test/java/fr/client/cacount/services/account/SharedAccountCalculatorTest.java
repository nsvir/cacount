package fr.client.cacount.services.account;

import android.util.ArrayMap;
import fr.client.cacount.services.utils.OwnerData;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by svirch_n on 07/03/17.
 */
public class SharedAccountCalculatorTest {
    @Test
    public void getOwners() throws Exception {
        SharedAccountCalculator sharedAccountCalculator = new SharedAccountCalculator(new SharedEntries(new SharedEntry[]{
                (SharedEntry) new SharedEntry().owner("Nicolas").price(10),
                (SharedEntry) new SharedEntry().owner("Nicolas").price(10),
                (SharedEntry) new SharedEntry().owner("Marion").price(30),
                (SharedEntry) new SharedEntry().owner("Marion").price(-10),
                (SharedEntry) new SharedEntry().owner("Nicolas").price(-20),
        }));
        OwnerData lower = sharedAccountCalculator.getLower();
        assertEquals("Nicolas", lower.owner);
        assertEquals(0.0, lower.total.doubleValue(), 0.001);
        assertEquals(20.0, lower.difference.doubleValue(), 0.001);
    }
}