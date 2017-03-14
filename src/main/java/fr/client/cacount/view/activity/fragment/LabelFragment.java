package fr.client.cacount.view.activity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.*;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListAdapter;
import fr.client.cacount.Cacount;
import fr.client.cacount.R;
import fr.client.cacount.view.activity.InsertActivity;

/**
 * Created by svirch_n on 12/02/17.
 */
public class LabelFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.edit_text, container, false);
        AutoCompleteTextView editText = (AutoCompleteTextView) view.findViewById(R.id.edit_text);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager)
                getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        editText.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                ((InsertActivity)getActivity()).setLabel(textView.getText().toString());
            }
            return false;
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line,
                Cacount.getLabels(getContext()));
        editText.setAdapter(adapter);
        return view;
    }
}
