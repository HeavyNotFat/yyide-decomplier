package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityTitileLayout2Binding implements ViewBinding {
    public final FrameLayout backLayout;
    private final FrameLayout rootView;
    public final CheckedTextView tab1;
    public final CheckedTextView tab2;

    private ActivityTitileLayout2Binding(FrameLayout frameLayout, FrameLayout frameLayout2, CheckedTextView checkedTextView, CheckedTextView checkedTextView2) {
        this.rootView = frameLayout;
        this.backLayout = frameLayout2;
        this.tab1 = checkedTextView;
        this.tab2 = checkedTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTitileLayout2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityTitileLayout2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_titile_layout2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityTitileLayout2Binding bind(View view) {
        int i = R.id.back_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.back_layout);
        if (frameLayout != null) {
            i = R.id.tab1;
            CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.tab1);
            if (checkedTextView != null) {
                i = R.id.tab2;
                CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.tab2);
                if (checkedTextView2 != null) {
                    return new ActivityTitileLayout2Binding((FrameLayout) view, frameLayout, checkedTextView, checkedTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
