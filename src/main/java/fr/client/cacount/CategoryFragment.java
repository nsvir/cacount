package fr.client.cacount;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by svirch_n on 11/02/17.
 */
public class CategoryFragment extends ListFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new StringBaseAdapter(getContext(), Cacount.CATEGORY_LIST));

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
