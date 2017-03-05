package fr.client.cacount.view.activity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import fr.client.cacount.Cacount;
import fr.client.cacount.view.activity.InsertActivity;
import fr.client.cacount.R;

import static fr.client.cacount.Cacount.CATEGORY_LIST;

/**
 * Created by svirch_n on 11/02/17.
 */
public class CategoryFragment extends ListFragment {

    private InsertActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listview, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (InsertActivity) getActivity();
        setListAdapter(new StringBaseAdapter(getContext(), CATEGORY_LIST));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        activity.setCategory(CATEGORY_LIST[position]);
    }

    private static class StringBaseAdapter extends SimpleBaseAdapter<String> {

        public StringBaseAdapter(Context context, String[] list) {
            super(context, list);
        }

        @Override
        protected View getView(LayoutInflater layoutInflater, int i, View view, ViewGroup viewGroup, String[] list) {
            if (view == null) {
                view = layoutInflater.inflate(R.layout.text_view, viewGroup, false);
            }
            ((TextView)view.findViewById(R.id.text)).setText(list[i]);
            return view;
        }


    }

    public abstract static class SimpleBaseAdapter<T> extends BaseAdapter {

        private final T[] list;
        private final Context context;
        private LayoutInflater layoutInflater;

        public SimpleBaseAdapter(Context context, T[] list) {
            this.list = list;
            this.context = context;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return list.length;
        }

        @Override
        public T getItem(int i) {
            return list[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getView(layoutInflater, i, view, viewGroup, list);
        }

        protected abstract View getView(LayoutInflater layoutInflater, int i, View view, ViewGroup viewGroup, T[] list);
    }
}
