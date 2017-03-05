package fr.client.cacount.services.account;

import fr.client.cacount.view.utils.NotificationContent;

/**
 * Created by svirch_n on 05/03/17.
 */
public class SharedAccount implements AccountInterface {

    @Override
    public NotificationContent getNotificationContent() {
        return new NotificationContent(2).title("Shared Account title").content("oh yea!").isShared();
    }

}
