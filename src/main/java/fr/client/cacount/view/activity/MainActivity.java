package fr.client.cacount.view.activity;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.BasePermissionListener;
import com.karumi.dexter.listener.single.CompositePermissionListener;
import com.karumi.dexter.listener.single.PermissionListener;
import com.karumi.dexter.listener.single.SnackbarOnDeniedPermissionListener;
import fr.client.cacount.R;
import fr.client.cacount.view.activity.fragment.ConfigurationFragment;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        BasePermissionListener listener = new BasePermissionListener() {

            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {

                // Display the fragment as the main content.
                getFragmentManager().beginTransaction()
                        .replace(android.R.id.content, new ConfigurationFragment())
                        .commit();
                UpdateActivity.updateNotification(MainActivity.this);
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                super.onPermissionRationaleShouldBeShown(permission, token);
            }
        };
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(listener)
                .check();
    }

}
