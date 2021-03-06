package fr.client.cacount.view.utils;

/**
 * Created by svirch_n on 05/03/17.
 */
public class NotificationContent {

    public final int notificationID;
    public String title;
    public String content;
    public boolean isShared = false;

    public NotificationContent(int notificationID) {
        this.notificationID = notificationID;
    }

    public NotificationContent title(String title) {
        this.title = title;
        return this;
    }

    public NotificationContent content(String content) {
        this.content = content;
        return this;
    }

    public NotificationContent isShared() {
        isShared = true;
        return this;
    }
}
