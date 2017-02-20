package fr.client.cacount.services.account;

import fr.client.cacount.Cacount;
import fr.client.cacount.services.calendar.MockCalendar;
import fr.client.cacount.services.io.MockLineReaderManager;
import fr.client.cacount.services.utils.CSVLineCreator;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by svirch_n on 12/02/17.
 */
public class AccountFileTest {

    @Test
    public void getCategoriesTotal() throws Exception {

    }

    @Test
    public void getTotal() throws Exception {

    }

    @Test
    public void getEarnedMoneySimple() throws Exception {
        double ratio = 5;
        int days = 10;
        Cacount.RATIO = ratio;
        AccountFile accountFile = new AccountFile(new MockLineReaderManager(), new MockCalendar(days));
        assertEquals(ratio * days, accountFile.getEarnedMoney());
    }

    @Test
    public void getEarnedMoneySubtraction() throws Exception {
        double ratio = 5;
        int days = 10;
        int firstDay = 5;
        Cacount.RATIO = ratio;

        String[] lines = {CSVLineCreator.date(CSVLineCreator.day(firstDay))};

        AccountFile accountFile = new AccountFile(new MockLineReaderManager(lines), new MockCalendar(days));
        assertEquals(ratio * (days - firstDay), accountFile.getEarnedMoney());
    }

    @Test
    public void getDay() throws Exception {
        int date = 10;
        int insertionDate = 1;
        AccountFile accountFile = new AccountFile(new MockLineReaderManager(new String[]{"01/10/2016, 08:34:50, CATEGORY, LABEL, 13.2"}), new MockCalendar(date));
        assertEquals(date - insertionDate, accountFile.getDay());
    }

}