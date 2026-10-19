package com.yd.android_brand_mvp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes4.dex */
public class ChildViewPager extends ViewPager {
    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        super.onInterceptTouchEvent(motionEvent);
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (getChildCount() <= 1) {
            super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if ((action == 0 || action == 1 || action == 2 || action == 3) && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }
}
