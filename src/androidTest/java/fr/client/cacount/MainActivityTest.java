package fr.client.cacount;

import android.test.ActivityInstrumentationTestCase2;
import fr.client.cacount.view.activity.MainActivity;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class fr.client.cacount.MainActivityTest \
 * fr.client.cacount.tests/android.test.InstrumentationTestRunner
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super("fr.client.cacount", MainActivity.class);
    }

}
