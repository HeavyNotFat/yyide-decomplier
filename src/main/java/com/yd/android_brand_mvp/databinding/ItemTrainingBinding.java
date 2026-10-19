package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemTrainingBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvNumber;
    public final TextView tvTitle;
    public final View view;

    private ItemTrainingBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, View view) {
        this.rootView = constraintLayout;
        this.tvNumber = textView;
        this.tvTitle = textView2;
        this.view = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemTrainingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemTrainingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_training, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemTrainingBinding bind(View view) {
        int i = R.id.tvNumber;
        TextView textView = (TextView) view.findViewById(R.id.tvNumber);
        if (textView != null) {
            i = R.id.tvTitle;
            TextView textView2 = (TextView) view.findViewById(R.id.tvTitle);
            if (textView2 != null) {
                i = R.id.view;
                View viewFindViewById = view.findViewById(R.id.view);
                if (viewFindViewById != null) {
                    return new ItemTrainingBinding((ConstraintLayout) view, textView, textView2, viewFindViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
