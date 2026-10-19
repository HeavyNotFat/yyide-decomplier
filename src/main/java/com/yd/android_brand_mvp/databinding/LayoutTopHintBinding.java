package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutTopHintBinding implements ViewBinding {
    public final LinearLayout llTopHint;
    private final LinearLayout rootView;
    public final TextView tvTopLint;

    private LayoutTopHintBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.llTopHint = linearLayout2;
        this.tvTopLint = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutTopHintBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutTopHintBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_top_hint, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutTopHintBinding bind(View view) {
        int i = R.id.ll_top_hint;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_top_hint);
        if (linearLayout != null) {
            i = R.id.tv_top_lint;
            TextView textView = (TextView) view.findViewById(R.id.tv_top_lint);
            if (textView != null) {
                return new LayoutTopHintBinding((LinearLayout) view, linearLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
