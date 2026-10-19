package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutWeekItem5LBinding implements ViewBinding {
    public final ImageView ivDay;
    public final LinearLayout ll;
    private final LinearLayout rootView;
    public final CheckedTextView weekItem;

    private LayoutWeekItem5LBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, CheckedTextView checkedTextView) {
        this.rootView = linearLayout;
        this.ivDay = imageView;
        this.ll = linearLayout2;
        this.weekItem = checkedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutWeekItem5LBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutWeekItem5LBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_week_item5_l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutWeekItem5LBinding bind(View view) {
        int i = R.id.iv_day;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_day);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.weekItem);
            if (checkedTextView != null) {
                return new LayoutWeekItem5LBinding(linearLayout, imageView, linearLayout, checkedTextView);
            }
            i = R.id.weekItem;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
