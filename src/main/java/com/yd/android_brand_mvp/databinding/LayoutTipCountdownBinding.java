package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutTipCountdownBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvTipCountdown;
    public final TextView tvTitle;

    private LayoutTipCountdownBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.tvTipCountdown = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutTipCountdownBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutTipCountdownBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_tip_countdown, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutTipCountdownBinding bind(View view) {
        int i = R.id.tvTipCountdown;
        TextView textView = (TextView) view.findViewById(R.id.tvTipCountdown);
        if (textView != null) {
            i = R.id.tvTitle;
            TextView textView2 = (TextView) view.findViewById(R.id.tvTitle);
            if (textView2 != null) {
                return new LayoutTipCountdownBinding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
