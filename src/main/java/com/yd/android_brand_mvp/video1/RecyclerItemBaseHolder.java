package com.yd.android_brand_mvp.video1;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public class RecyclerItemBaseHolder extends RecyclerView.ViewHolder {
    RecyclerView.Adapter recyclerBaseAdapter;

    public RecyclerItemBaseHolder(View view) {
        super(view);
    }

    public RecyclerView.Adapter getRecyclerBaseAdapter() {
        return this.recyclerBaseAdapter;
    }

    public void setRecyclerBaseAdapter(RecyclerView.Adapter adapter) {
        this.recyclerBaseAdapter = adapter;
    }
}
