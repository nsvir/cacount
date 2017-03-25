package fr.client.cacount.services.account;

import fr.client.cacount.services.calendar.MockCalendar;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by svirch_n on 25/03/17.
 */
public class SingleWeeklyAccountCalculatorTest {
    @Test
    public void getEarnedMoney() throws Exception {
        MockSingleAccountPreference mockPreference = new MockSingleAccountPreference();
        mockPreference.setTransferType(SingleAccountPreference.WEEKLY);
        mockPreference.ratio(new BigDecimal(10));
        SingleWeeklyAccountCalculator singleWeeklyAccountCalculator = new SingleWeeklyAccountCalculator(new SingleEntries(), mockPreference);
        singleWeeklyAccountCalculator.calendar = new MockCalendar(3).nextDay(3);
        assertEquals(60,singleWeeklyAccountCalculator.getEarnedMoney().intValue());
    }

}