package com.yd.android_brand_mvp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes4.dex */
public class YDWebView extends WebView {
    private void init() {
    }

    public YDWebView(Context context) {
        super(context);
        init();
    }

    public YDWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public YDWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public YDWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public YDWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback, int i) {
        return dummyActionMode();
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return dummyActionMode();
    }

    public ActionMode dummyActionMode() {
        return new ActionMode() { // from class: com.yd.android_brand_mvp.widget.YDWebView.1
            @Override // android.view.ActionMode
            public void finish() {
            }

            @Override // android.view.ActionMode
            public View getCustomView() {
                return null;
            }

            @Override // android.view.ActionMode
            public Menu getMenu() {
                return null;
            }

            @Override // android.view.ActionMode
            public MenuInflater getMenuInflater() {
                return null;
            }

            @Override // android.view.ActionMode
            public CharSequence getSubtitle() {
                return null;
            }

            @Override // android.view.ActionMode
            public CharSequence getTitle() {
                return null;
            }

            @Override // android.view.ActionMode
            public void invalidate() {
            }

            @Override // android.view.ActionMode
            public void setCustomView(View view) {
            }

            @Override // android.view.ActionMode
            public void setSubtitle(int i) {
            }

            @Override // android.view.ActionMode
            public void setSubtitle(CharSequence charSequence) {
            }

            @Override // android.view.ActionMode
            public void setTitle(int i) {
            }

            @Override // android.view.ActionMode
            public void setTitle(CharSequence charSequence) {
            }
        };
    }
}
