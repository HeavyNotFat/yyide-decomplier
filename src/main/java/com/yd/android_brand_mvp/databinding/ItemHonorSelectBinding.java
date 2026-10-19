package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemHonorSelectBinding implements ViewBinding {
    public final ConstraintLayout clContent;
    private final ConstraintLayout rootView;
    public final TextView tvName;

    private ItemHonorSelectBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.clContent = constraintLayout2;
        this.tvName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemHonorSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemHonorSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_honor_select, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemHonorSelectBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        TextView textView = (TextView) view.findViewById(R.id.tvName);
        if (textView != null) {
            return new ItemHonorSelectBinding(constraintLayout, constraintLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tvName)));
    }
}
