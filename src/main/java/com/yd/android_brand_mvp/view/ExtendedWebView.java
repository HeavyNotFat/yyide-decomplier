package com.yd.android_brand_mvp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes4.dex */
public class ExtendedWebView extends WebView {
    public ExtendedWebView(Context context) {
        super(context);
    }

    public ExtendedWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (z) {
            findViewParentIfNeeds(this).requestDisallowInterceptTouchEvent(false);
        }
        super.onOverScrolled(i, i2, z, z2);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent viewParentFindViewParentIfNeeds;
        if (motionEvent.getAction() == 0 && (viewParentFindViewParentIfNeeds = findViewParentIfNeeds(this)) != null) {
            viewParentFindViewParentIfNeeds.requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ViewParent findViewParentIfNeeds(View view) {
        ViewParent parent = view.getParent();
        if (parent == 0) {
            return null;
        }
        if (!(parent instanceof ViewPager) && !(parent instanceof AbsListView) && !(parent instanceof ScrollView) && !(parent instanceof HorizontalScrollView) && (parent instanceof View)) {
            findViewParentIfNeeds((View) parent);
        }
        return parent;
    }
}
