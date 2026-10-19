package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutHeadTitle2Binding implements ViewBinding {
    public final TextView ivBack;
    public final LinearLayout linearLayout2;
    public final ConstraintLayout llTitle;
    private final ConstraintLayout rootView;
    public final TextView title;
    public final TextView tvLayoutHeadSubTitle;

    private LayoutHeadTitle2Binding(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.ivBack = textView;
        this.linearLayout2 = linearLayout;
        this.llTitle = constraintLayout2;
        this.title = textView2;
        this.tvLayoutHeadSubTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutHeadTitle2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutHeadTitle2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_head_title2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutHeadTitle2Binding bind(View view) {
        int i = R.id.ivBack;
        TextView textView = (TextView) view.findViewById(R.id.ivBack);
        if (textView != null) {
            i = R.id.linearLayout2;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout2);
            if (linearLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.title;
                TextView textView2 = (TextView) view.findViewById(R.id.title);
                if (textView2 != null) {
                    i = R.id.tv_layout_head_subTitle;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_layout_head_subTitle);
                    if (textView3 != null) {
                        return new LayoutHeadTitle2Binding(constraintLayout, textView, linearLayout, constraintLayout, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
