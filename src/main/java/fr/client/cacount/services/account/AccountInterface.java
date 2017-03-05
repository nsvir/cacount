package fr.client.cacount.services.account;

import fr.client.cacount.view.utils.NotificationContent;

/**
 * Created by svirch_n on 05/03/17.
 */
public interface AccountInterface {

    NotificationContent getNotificationContent();

    class CouldNotInitiateAccountException extends Exception {
        public CouldNotInitiateAccountException(Exception e) {
            super(e);
        }
    }

}
