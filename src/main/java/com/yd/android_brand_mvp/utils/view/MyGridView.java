package com.yd.android_brand_mvp.utils.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.blankj.utilcode.util.SizeUtils;

/* JADX INFO: loaded from: classes4.dex */
public class MyGridView extends GridView {
    public MyGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, SizeUtils.dp2px(View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE)));
    }
}
