package fr.client.cacount;

import junit.framework.TestCase;

/**
 * Created by svirch_n on 12/02/17.
 */
public class AccountFileTest extends TestCase {
    public void testGetCategoriesTotal() throws Exception {

    }

    public void testGetTotal() throws Exception {

    }

    public void testGetEarnedMoneySimple() throws Exception {
        int ratio = 5;
        int days = 10;
        Cacount.RATIO = ratio;
        AccountFile accountFile = new AccountFile(new MockLineReaderManager(), new MockCalendar(days));
        assertEquals(ratio * days, accountFile.getEarnedMoney());
    }

    public void testGetEarnedMoneySoustraction() throws Exception {
        int ratio = 5;
        int days = 10;
        Cacount.RATIO = ratio;

        String[] lines = {"05/"};

        AccountFile accountFile = new AccountFile(new MockLineReaderManager(lines), new MockCalendar(days));
        assertEquals(ratio * days, accountFile.getEarnedMoney());
    }

    public void testGetDay() throws Exception {
        int date = 10;
        AccountFile accountFile = new AccountFile(new MockLineReaderManager(), new MockCalendar(date));
        assertEquals(date, accountFile.getDay());
    }

}