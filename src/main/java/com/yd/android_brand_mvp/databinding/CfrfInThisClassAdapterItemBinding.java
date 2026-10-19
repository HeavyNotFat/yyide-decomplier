package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class CfrfInThisClassAdapterItemBinding implements ViewBinding {
    public final ImageView ivMedalOfHonor;
    private final LinearLayout rootView;
    public final TextView tvWeekCycle;

    private CfrfInThisClassAdapterItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.ivMedalOfHonor = imageView;
        this.tvWeekCycle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CfrfInThisClassAdapterItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CfrfInThisClassAdapterItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.cfrf_in_this_class_adapter_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CfrfInThisClassAdapterItemBinding bind(View view) {
        int i = R.id.iv_medal_of_honor;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_medal_of_honor);
        if (imageView != null) {
            i = R.id.tv_week_cycle;
            TextView textView = (TextView) view.findViewById(R.id.tv_week_cycle);
            if (textView != null) {
                return new CfrfInThisClassAdapterItemBinding((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
