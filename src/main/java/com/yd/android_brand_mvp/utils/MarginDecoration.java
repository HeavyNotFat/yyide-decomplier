package com.yd.android_brand_mvp.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public class MarginDecoration extends RecyclerView.ItemDecoration {
    private int count;
    private int space;

    public MarginDecoration(int i, int i2) {
        this.space = i;
        this.count = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.bottom = this.space;
        if (recyclerView.getChildLayoutPosition(view) % this.count != 0) {
            rect.left = this.space;
        }
    }
}
