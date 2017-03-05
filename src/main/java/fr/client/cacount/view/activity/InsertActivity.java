package fr.client.cacount.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
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

    private String category;
    private Fragment current;
    private String label;
    private double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);
        setFragment(new CategoryFragment());
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
        this.price = price;
        try {
            Cacount.PRINCIPAL.createInstance().insert(category, label, price);
        } catch (AccountInterface.CouldNotInitiateAccountException e) {
            e.printStackTrace();
        }
        finish();
    }
}
