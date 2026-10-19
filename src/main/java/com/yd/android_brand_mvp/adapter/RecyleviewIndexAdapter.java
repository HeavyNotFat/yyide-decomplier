package com.yd.android_brand_mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class RecyleviewIndexAdapter extends RecyclerView.Adapter<ViewHolder> {
    int ct;
    public int index;

    public String getItem(int i) {
        return "0";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_index_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (i == this.index) {
            viewHolder.item.setChecked(true);
        } else {
            viewHolder.item.setChecked(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.ct;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckedTextView item;

        public ViewHolder(View view) {
            super(view);
            this.item = (CheckedTextView) view.findViewById(R.id.item);
        }
    }

    public void notifydata(int i) {
        this.ct = i;
        notifyDataSetChanged();
    }

    public void setPosition(int i) {
        this.index = i;
        if (i < getItemCount()) {
            notifyDataSetChanged();
        }
    }
}
