package fr.client.cacount.utils.log;

import fr.client.cacount.Cacount;

/**
 * Created by svirch_n on 20/02/17.
 */
public class AndroidLog extends Log {
    @Override
    public void d(String line) {
        android.util.Log.d(Cacount.TAG, line);
    }

    @Override
    public void w(String line) {
        android.util.Log.w(Cacount.TAG, line);
    }
}
