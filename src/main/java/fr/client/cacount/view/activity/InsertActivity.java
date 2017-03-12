package fr.client.cacount.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import fr.client.cacount.Cacount;
import fr.client.cacount.services.account.AccountInterface;
import fr.client.cacount.view.activity.fragment.LabelFragment;
import fr.client.cacount.view.activity.fragment.PriceFragment;
import fr.client.cacount.R;
import fr.client.cacount.view.activity.fragment.CategoryFragment;

/**
 * Created by svirch_n on 11/02/17.
 */
public class InsertActivity extends FragmentActivity {

    public static final String IS_SHARED = "isShared";
    private String category;
    private Fragment current;
    private String label;
    private RadioGroup group;
    private CheckBox shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);
        View footer = findViewById(R.id.footer);
        group = (RadioGroup) findViewById(R.id.group);
        RadioButton me = (RadioButton) findViewById(R.id.me);
        RadioButton other = (RadioButton) findViewById(R.id.other);
        shared = (CheckBox) findViewById(R.id.shared);
        footer.setOnClickListener(view -> {
            shared.setChecked(true);
        });
        shared.setOnCheckedChangeListener((compoundButton, checked) -> {
            footer.setClickable(!checked);
            me.setClickable(checked);
            other.setClickable(checked);
            me.setEnabled(checked);
            other.setEnabled(checked);
        });
        me.setClickable(false);
        other.setClickable(false);
        CategoryFragment fragment = new CategoryFragment();
        Bundle extras = getIntent().getExtras();
        fragment.setArguments(extras);
        setFragment(fragment);
    }

    @Override
    protected void onStop() {
        super.onStop();
        UpdateActivity.updateNotification(this);
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (current == null) {
            fragmentTransaction.add(R.id.container, fragment);
        } else {
            fragmentTransaction.replace(R.id.container, fragment);
        }
        fragmentTransaction.commit();
        current = fragment;
    }


    public void setCategory(String category) {
        this.category = category;
        setFragment(new LabelFragment());
    }

    public void setLabel(String label) {
        this.label = label;
        setFragment(new PriceFragment());
    }

    public void setPrice(double price) {
        try {
            if (shared.isChecked()) {
                Cacount.getSharedAccount(getApplicationContext()).createInstance().insert(getSelection(), category, label, price);
                if (group.getCheckedRadioButtonId() == R.id.me) {
                    Cacount.getMainAccount(getApplicationContext()).createInstance().insert(category, label, price);
                }
            } else {
                Cacount.getMainAccount(getApplicationContext()).createInstance().insert(category, label, price);
            }
        } catch (AccountInterface.CouldNotInitiateAccountException e) {
            e.printStackTrace();
        }
        finish();
    }

    private String getSelection() {
        return String.valueOf(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText());
    }
}
