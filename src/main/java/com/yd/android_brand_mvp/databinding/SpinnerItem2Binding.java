package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class SpinnerItem2Binding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvText;

    private SpinnerItem2Binding(ConstraintLayout constraintLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.tvText = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SpinnerItem2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SpinnerItem2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.spinner_item2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SpinnerItem2Binding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tvText);
        if (textView != null) {
            return new SpinnerItem2Binding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tvText)));
    }
}
