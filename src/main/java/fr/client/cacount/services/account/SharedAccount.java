package fr.client.cacount.services.account;

import fr.client.cacount.services.io.file.AccountFile;
import fr.client.cacount.services.io.file.SharedAccountFile;
import fr.client.cacount.services.io.manager.LineManager;
import fr.client.cacount.view.utils.NotificationContent;

import java.io.IOException;

/**
 * Created by svirch_n on 05/03/17.
 */
public class SharedAccount implements AccountInterface {

    private final SharedAccountFile sharedAccountFile;

    public SharedAccount(SharedAccountPreference sharedAccountPreference) throws CouldNotInitiateAccountException {
        try {
            sharedAccountFile = new SharedAccountFile(new LineManager(sharedAccountPreference.getFilename()));
        } catch (IOException | AccountFile.ParserException e) {
            throw new CouldNotInitiateAccountException(e);
        }
    }

    @Override
    public NotificationContent getNotificationContent() {
        return new NotificationContent(2).title("Shared Account title").content("oh yea!").isShared();
    }

    public void insert(String owner, String category, String label, double price) {
        sharedAccountFile.insert(owner, category, label, price);
    }
}
