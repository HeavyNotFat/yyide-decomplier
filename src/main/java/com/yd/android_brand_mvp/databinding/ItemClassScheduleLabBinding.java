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
public final class ItemClassScheduleLabBinding implements ViewBinding {
    public final ImageView ivImg;
    public final LinearLayout llLab;
    private final LinearLayout rootView;
    public final TextView tvName;
    public final TextView tvSName;

    private ItemClassScheduleLabBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.ivImg = imageView;
        this.llLab = linearLayout2;
        this.tvName = textView;
        this.tvSName = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemClassScheduleLabBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemClassScheduleLabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_class_schedule_lab, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemClassScheduleLabBinding bind(View view) {
        int i = R.id.iv_img;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_img);
        if (imageView != null) {
            i = R.id.ll_lab;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_lab);
            if (linearLayout != null) {
                i = R.id.tv_name;
                TextView textView = (TextView) view.findViewById(R.id.tv_name);
                if (textView != null) {
                    i = R.id.tv_s_name;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_s_name);
                    if (textView2 != null) {
                        return new ItemClassScheduleLabBinding((LinearLayout) view, imageView, linearLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
