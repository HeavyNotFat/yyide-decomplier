package com.yd.android_brand_mvp.utils.view;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private final String TAG = "GridSpaceItemDecoration";
    private int mColumnSpacing;
    private int mRowSpacing;
    private int mSpanCount;

    public GridSpaceItemDecoration(int i, int i2, int i3) {
        this.mSpanCount = i;
        this.mRowSpacing = i2;
        this.mColumnSpacing = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.mSpanCount;
        int i2 = childAdapterPosition % i;
        rect.left = (this.mColumnSpacing * i2) / i;
        int i3 = this.mColumnSpacing;
        rect.right = i3 - (((i2 + 1) * i3) / this.mSpanCount);
        Log.e("GridSpaceItemDecoration", "position:" + childAdapterPosition + "    columnIndex: " + i2 + "    left,right ->" + rect.left + Constants.ACCEPT_TIME_SEPARATOR_SP + rect.right);
        if (childAdapterPosition >= this.mSpanCount) {
            rect.top = this.mRowSpacing;
        }
    }
}
