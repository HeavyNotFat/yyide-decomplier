package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutError1pBinding implements ViewBinding {
    public final LinearLayout retry;
    private final LinearLayout rootView;

    private LayoutError1pBinding(LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.retry = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutError1pBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutError1pBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_error_1p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutError1pBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        LinearLayout linearLayout = (LinearLayout) view;
        return new LayoutError1pBinding(linearLayout, linearLayout);
    }
}
