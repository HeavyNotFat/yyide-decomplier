package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.makeramen.roundedimageview.RoundedImageView;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class HasClockItemBinding implements ViewBinding {
    public final RoundedImageView ivHead;
    private final LinearLayout rootView;
    public final TextView tvName;
    public final TextView tvTime;

    private HasClockItemBinding(LinearLayout linearLayout, RoundedImageView roundedImageView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.ivHead = roundedImageView;
        this.tvName = textView;
        this.tvTime = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HasClockItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HasClockItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.has_clock_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HasClockItemBinding bind(View view) {
        int i = R.id.iv_head;
        RoundedImageView roundedImageView = (RoundedImageView) view.findViewById(R.id.iv_head);
        if (roundedImageView != null) {
            i = R.id.tv_name;
            TextView textView = (TextView) view.findViewById(R.id.tv_name);
            if (textView != null) {
                i = R.id.tv_time;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_time);
                if (textView2 != null) {
                    return new HasClockItemBinding((LinearLayout) view, roundedImageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
