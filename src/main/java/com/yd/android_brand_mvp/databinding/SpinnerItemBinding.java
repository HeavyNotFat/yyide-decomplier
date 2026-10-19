package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class SpinnerItemBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvText;

    private SpinnerItemBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.tvText = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SpinnerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SpinnerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.spinner_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SpinnerItemBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tvText);
        if (textView != null) {
            return new SpinnerItemBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tvText)));
    }
}
