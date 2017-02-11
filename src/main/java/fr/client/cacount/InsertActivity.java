package fr.client.cacount;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

/**
 * Created by svirch_n on 11/02/17.
 */
public class InsertActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ((TextView)findViewById(R.id.text)).setText("Insert!");


    }
}
