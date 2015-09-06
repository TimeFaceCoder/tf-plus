package com.github.rayboot.tf_plus.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.rayboot.tf_plus.R;

import co.dift.ui.SwipeToAction;

/**
 * Created by rayboot on 15/8/24.
 */
public class GroupSelectTimeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_select_time, parent, false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    /** References to the views for each data item **/
    public class BookViewHolder extends SwipeToAction.ViewHolder<String> {
        public BookViewHolder(View v) {
            super(v);

        }
    }
}
