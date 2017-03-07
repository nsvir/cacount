package fr.client.cacount.services.account;

import fr.client.cacount.services.io.file.AccountFile;
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

    protected SingleAccount(SingleAccountPreference singleAccountPreference) throws CouldNotInitiateAccountException {
        try {
            this.singleAccountFile = new SingleAccountFile(new LineManager(singleAccountPreference.getFilename()));
        } catch (IOException | AccountFile.ParserException e) {
            throw new CouldNotInitiateAccountException(e);
        }
        this.calculator = new SingleAccountCalculator(singleAccountFile.getEntries(), singleAccountPreference);
    }

    @Override
    public NotificationContent getNotificationContent() {
        try {
            singleAccountFile.reload();
        } catch (IOException | AccountFile.ParserException e) {
            new NotificationContent(1).title("Could not Parse file");
        }
        BigDecimal total = calculator.getTotal();
        BigDecimal earnedMoney = calculator.getEarnedMoney();
        return new NotificationContent(1)
                .title(String.format(Locale.FRANCE, "%.2f€ (%.2f€)", (earnedMoney.subtract(total)), calculator.getRatio()))
                .content(String.format(Locale.FRANCE, "Total: %.2f€", total));
    }

    public void insert(String category, String label, double price) {
        singleAccountFile.insert(category, label, price);
    }
}
