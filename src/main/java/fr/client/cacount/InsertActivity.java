package fr.client.cacount;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

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
        Toast.makeText(this, category + ": " + label + " = " + price + "€", Toast.LENGTH_LONG).show();
        finish();
    }
}
