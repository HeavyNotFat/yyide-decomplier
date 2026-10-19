package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemClassSchedule66Binding implements ViewBinding {
    public final ImageView ivImg;
    public final LinearLayout llLab;
    private final RelativeLayout rootView;
    public final TextView tvName;
    public final TextView tvSName;
    public final TextView tvTableTip;

    private ItemClassSchedule66Binding(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.ivImg = imageView;
        this.llLab = linearLayout;
        this.tvName = textView;
        this.tvSName = textView2;
        this.tvTableTip = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemClassSchedule66Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemClassSchedule66Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_class_schedule66, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemClassSchedule66Binding bind(View view) {
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
                        i = R.id.tv_table_tip;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_table_tip);
                        if (textView3 != null) {
                            return new ItemClassSchedule66Binding((RelativeLayout) view, imageView, linearLayout, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
