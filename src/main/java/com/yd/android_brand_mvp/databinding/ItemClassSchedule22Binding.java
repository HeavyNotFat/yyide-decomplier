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
public final class ItemClassSchedule22Binding implements ViewBinding {
    public final ImageView ivImg;
    public final LinearLayout llLab;
    private final LinearLayout rootView;
    public final TextView tvName;

    private ItemClassSchedule22Binding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.ivImg = imageView;
        this.llLab = linearLayout2;
        this.tvName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemClassSchedule22Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemClassSchedule22Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_class_schedule22, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemClassSchedule22Binding bind(View view) {
        int i = R.id.iv_img;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_img);
        if (imageView != null) {
            i = R.id.ll_lab;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_lab);
            if (linearLayout != null) {
                i = R.id.tv_name;
                TextView textView = (TextView) view.findViewById(R.id.tv_name);
                if (textView != null) {
                    return new ItemClassSchedule22Binding((LinearLayout) view, imageView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
