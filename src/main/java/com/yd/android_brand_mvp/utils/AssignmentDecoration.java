package com.yd.android_brand_mvp.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public class AssignmentDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public AssignmentDecoration(int i) {
        this.space = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildPosition(view) != 0) {
            rect.left = this.space;
        }
        if (recyclerView.getChildPosition(view) % 3 == 0) {
            rect.left = 0;
        }
    }
}
