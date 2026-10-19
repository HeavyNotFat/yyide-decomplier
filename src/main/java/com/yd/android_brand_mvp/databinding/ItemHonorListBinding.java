package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemHonorListBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvName;
    public final TextView tvScore;
    public final TextView tvTime;

    private ItemHonorListBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.tvName = textView;
        this.tvScore = textView2;
        this.tvTime = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemHonorListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemHonorListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_honor_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemHonorListBinding bind(View view) {
        int i = R.id.tvName;
        TextView textView = (TextView) view.findViewById(R.id.tvName);
        if (textView != null) {
            i = R.id.tvScore;
            TextView textView2 = (TextView) view.findViewById(R.id.tvScore);
            if (textView2 != null) {
                i = R.id.tvTime;
                TextView textView3 = (TextView) view.findViewById(R.id.tvTime);
                if (textView3 != null) {
                    return new ItemHonorListBinding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
