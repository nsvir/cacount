package fr.client.cacount.view.utils;

/**
 * Created by svirch_n on 05/03/17.
 */
public class NotificationContent {

    public String title;
    public String content;

    public NotificationContent title(String title) {
        this.title = title;
        return this;
    }

    public NotificationContent content(String content) {
        this.content = content;
        return this;
    }
}
