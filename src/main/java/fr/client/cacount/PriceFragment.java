package fr.client.cacount;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by svirch_n on 12/02/17.
 */
public class PriceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.edit_price, container, false);
        EditText editText = (EditText) view.findViewById(R.id.edit_text);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager)
                getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        editText.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                ((InsertActivity)getActivity()).setPrice(Double.parseDouble(textView.getText().toString()));
            }
            return false;
        });

        return view;
    }
}
