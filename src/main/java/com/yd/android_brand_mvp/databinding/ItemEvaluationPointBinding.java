package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemEvaluationPointBinding implements ViewBinding {
    public final View line;
    private final ConstraintLayout rootView;
    public final TextView tvDate;
    public final TextView tvPoint;
    public final TextView tvTitle;
    public final TextView tvTotalPoint;

    private ItemEvaluationPointBinding(ConstraintLayout constraintLayout, View view, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.line = view;
        this.tvDate = textView;
        this.tvPoint = textView2;
        this.tvTitle = textView3;
        this.tvTotalPoint = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemEvaluationPointBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemEvaluationPointBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_evaluation_point, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemEvaluationPointBinding bind(View view) {
        int i = R.id.line;
        View viewFindViewById = view.findViewById(R.id.line);
        if (viewFindViewById != null) {
            i = R.id.tvDate;
            TextView textView = (TextView) view.findViewById(R.id.tvDate);
            if (textView != null) {
                i = R.id.tvPoint;
                TextView textView2 = (TextView) view.findViewById(R.id.tvPoint);
                if (textView2 != null) {
                    i = R.id.tvTitle;
                    TextView textView3 = (TextView) view.findViewById(R.id.tvTitle);
                    if (textView3 != null) {
                        i = R.id.tvTotalPoint;
                        TextView textView4 = (TextView) view.findViewById(R.id.tvTotalPoint);
                        if (textView4 != null) {
                            return new ItemEvaluationPointBinding((ConstraintLayout) view, viewFindViewById, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
