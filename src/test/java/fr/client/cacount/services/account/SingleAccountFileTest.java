package fr.client.cacount.services.account;

import fr.client.cacount.services.calendar.MockCalendar;
import fr.client.cacount.services.io.file.SingleAccountFile;
import fr.client.cacount.services.io.file.SingleEntry;
import fr.client.cacount.services.io.manager.MockLineManager;
import fr.client.cacount.utils.log.MockLog;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.*;

/**
 * Created by svirch_n on 12/02/17.
 */
public class SingleAccountFileTest {

    public static final String ALIMENTAIRE = "Alimentaire";
    public static final String SANTÉ = "Santé";
    public static final String AUTRE = "Autre";

    @Test
    public void insert() throws Exception {
        String[] strings = {
                MockCalendar.DEFAULT_DATE + "," + MockCalendar.DEFAULT_TIME + ","
                + "CATEGORY,LABEL,3.23"
        };
        SingleAccountFile singleAccountFile = new SingleAccountFile(new MockLineManager().writer(strings), new MockCalendar(), new MockLog());
        singleAccountFile.insert("CATEGORY", "LABEL", 3.23);
    }

    /*
    @Test
    public void getCategoriesTotal() throws Exception {
        CSVLineCreator.LineCreator lineCreator = new CSVLineCreator.LineCreator();
        ArrayList<String> strings = new ArrayList<>();
        lineCreator.category(ALIMENTAIRE);
        strings.add(lineCreator.price("20").toString());
        strings.add(lineCreator.price("20.50").toString());
        strings.add(lineCreator.price("-40.34").toString());
        strings.add(lineCreator.price("12.45").toString());
        strings.add(lineCreator.price("23").toString());
        double expectedAlimentation = 35.61;
        lineCreator.category(SANTÉ);
        strings.add(lineCreator.price("20").toString());
        strings.add(lineCreator.price("-40.34").toString());
        strings.add(lineCreator.price("23").toString());
        double expectedSanté = 2.66;
        lineCreator.category(AUTRE);
        strings.add(lineCreator.price("20.18").toString());
        strings.add(lineCreator.price("-20.34").toString());
        strings.add(lineCreator.price("47.53").toString());
        double expectedAutre = 47.37;
        SingleAccountFile accountFile = new SingleAccountFile(new MockLineManager().reader(strings.toArray(new String[strings.size()])), new MockCalendar());
        for (Map.Entry<String, BigDecimal> each : accountFile.getCategoriesTotal().entrySet()) {
            switch (each.getKey()) {
                case ALIMENTAIRE:
                    assertEquals(BigDecimal.valueOf(expectedAlimentation), each.getValue());
                    break;
                case SANTÉ:
                    assertEquals(BigDecimal.valueOf(expectedSanté), each.getValue());
                    break;
                case AUTRE:
                    assertEquals(BigDecimal.valueOf(expectedAutre), each.getValue());
                    break;
                default:
                    fail(each.getKey() + " is an invalid category");
            }
        }

    }
     */

    @Test
    public void getTotal() throws Exception {
        SingleEntries entries = new SingleEntries(new SingleEntry[] {
                new SingleEntry().price(10),
                new SingleEntry().price(10.53),
                new SingleEntry().price(12),
                new SingleEntry().price(-10.60),
                new SingleEntry().price(30.254),
                new SingleEntry().price(500.9)
        });
        SingleAccountCalculator singleAccountCalculator = new SingleDailyAccountCalculator(entries, new MockCalendar(), BigDecimal.ZERO);
        assertEquals(553.084, singleAccountCalculator.getTotal().doubleValue());
    }

    @Test
    public void getTotalWithDepense() throws Exception {
        SingleAccountCalculator singleAccountCalculator = new SingleDailyAccountCalculator(
                new SingleEntries(new SingleEntry[]{new SingleEntry().price(10.50)}),
                new MockSingleAccountPreference().depenses(new BigDecimal(10)));
        assertEquals(10.50 + 10.00, singleAccountCalculator.getTotal().doubleValue());

    }

    @Test
    public void getEarnedMoneySimple() throws Exception {
        BigDecimal ratio = BigDecimal.valueOf(5);
        int days = 10;
        SingleAccountCalculator singleAccountCalculator = new SingleDailyAccountCalculator(new SingleEntries(), new MockCalendar(days), ratio);
        assertEquals(ratio.doubleValue() * days, singleAccountCalculator.getEarnedMoney().doubleValue());
    }

    @Test
    public void getEarnedMoneyFromOneDay() throws Exception {
        double expected = 10;
        SingleAccountCalculator singleAccountCalculator = new SingleDailyAccountCalculator(new SingleEntries(), new MockCalendar(1), BigDecimal.valueOf(10));
        assertEquals(expected, singleAccountCalculator.getEarnedMoney().doubleValue());

    }

    @Test
    public void getDay() throws Exception {
        int date = 10;
        SingleAccountCalculator singleAccountCalculator = new SingleDailyAccountCalculator(new SingleEntries(), new MockCalendar(date));
        assertEquals(date, singleAccountCalculator.getToday().intValue());
    }

}