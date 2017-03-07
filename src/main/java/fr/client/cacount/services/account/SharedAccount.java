package fr.client.cacount.services.account;

import android.content.SharedPreferences;
import fr.client.cacount.services.io.file.AccountFile;
import fr.client.cacount.services.io.file.SharedAccountFile;
import fr.client.cacount.services.io.manager.LineManager;
import fr.client.cacount.services.utils.OwnerData;
import fr.client.cacount.view.utils.NotificationContent;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by svirch_n on 05/03/17.
 */
public class SharedAccount implements AccountInterface {

    private final SharedAccountFile sharedAccountFile;
    private final SharedAccountCalculator calculator;

    public SharedAccount(SharedAccountPreference sharedAccountPreference) throws CouldNotInitiateAccountException {
        try {
            sharedAccountFile = new SharedAccountFile(new LineManager(sharedAccountPreference.getFilename()));
        } catch (IOException | AccountFile.ParserException e) {
            throw new CouldNotInitiateAccountException(e);
        }
        calculator = new SharedAccountCalculator(sharedAccountFile.getEntries());
    }

    @Override
    public NotificationContent getNotificationContent() {
        try {
            update();
        } catch (IOException | AccountFile.ParserException e) {
            e.printStackTrace();
        }
        NotificationContent result = new NotificationContent(1);
        OwnerData lower = null;
        try {
            lower = calculator.getLower();
            result.content(String.format(Locale.FRANCE, "%s: %.2f€", lower.owner, lower.difference.doubleValue()));
            result.content(String.format(Locale.FRANCE, "%s: %.2f€", lower.owner, lower.difference.doubleValue()));
        } catch (SharedAccountCalculator.NoOwnerException e) {
            result.content("Not using shared account");
        }
        return result;
    }

    private void update() throws IOException, AccountFile.ParserException {
        sharedAccountFile.reload();
    }

    public void insert(String owner, String category, String label, double price) {
        sharedAccountFile.insert(owner, category, label, price);
    }
}
