package fr.client.cacount.services.account;

import fr.client.cacount.Cacount;
import fr.client.cacount.services.calendar.ACalendar;
import fr.client.cacount.services.calendar.AndroidCalendar;
import fr.client.cacount.services.io.file.SingleAccountFile;
import fr.client.cacount.services.io.manager.LineManager;
import fr.client.cacount.view.utils.NotificationContent;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Locale;

/**
 * Created by svirch_n on 05/03/17.
 */
public class SingleAccount implements AccountInterface {

    private final SingleAccountCalculator calculator;
    private final SingleAccountFile singleAccountFile;

    protected SingleAccount(AccountPreference accountPreference) throws CouldNotInitiateAccountException {
        try {
            this.singleAccountFile = new SingleAccountFile(new LineManager(accountPreference.filename));
        } catch (IOException | SingleAccountFile.ParserException e) {
            throw new CouldNotInitiateAccountException(e);
        }
        this.calculator = new SingleAccountCalculator(singleAccountFile.getEntries(), accountPreference.ratio);
    }

    @Override
    public NotificationContent getNotificationContent() {
        try {
            singleAccountFile.reload();
        } catch (IOException | SingleAccountFile.ParserException e) {
            new NotificationContent().title("Could not Parse file");
        }
        BigDecimal total = calculator.getTotal();
        BigDecimal earnedMoney = calculator.getEarnedMoney();
        return new NotificationContent()
                .title(String.format(Locale.FRANCE, "%.2f€ (%.2f€)", (earnedMoney.subtract(total)), calculator.getRatio()))
                .content(String.format(Locale.FRANCE, "Total: %.2f€", total));
    }

    public void insert(String category, String label, double price) {
        singleAccountFile.insert(category, label, price);
    }
}
