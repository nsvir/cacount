package fr.client.cacount.services.account;

import fr.client.cacount.view.utils.NotificationContent;

/**
 * Created by svirch_n on 05/03/17.
 */
public class SharedAccount implements AccountInterface {

    public SharedAccount(SharedAccountPreference sharedAccountPreference) {

    }

    @Override
    public NotificationContent getNotificationContent() {
        return new NotificationContent(2).title("Shared Account title").content("oh yea!").isShared();
    }

    public void insert(String owner, String category, String label, double price) {
    }
}
