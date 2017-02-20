package fr.client.cacount.view.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import fr.client.cacount.Cacount;
import fr.client.cacount.services.account.AccountFile;
import fr.client.cacount.view.utils.DefaultNotificationBuilder;

import java.math.BigDecimal;
import java.util.Locale;

/**
 * Created by svirch_n on 18/02/17.
 */
public class UpdateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateNotification(this);
        finish();
    }

    public static void updateNotification(Context context) {
        BigDecimal total = AccountFile.getInstance().getTotal();
        BigDecimal earnedMoney = AccountFile.getInstance().getEarnedMoney();
        DefaultNotificationBuilder builder = new DefaultNotificationBuilder(context, String.format(Locale.FRANCE, "%.2f€", (earnedMoney.subtract(total)), Cacount.RATIO),
                "Next date: +" + Cacount.RATIO + "€");
        builder.buildAndNotify();
    }
}
