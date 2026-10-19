package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentTimerItemPBinding implements ViewBinding {
    public final FrameLayout fitem;
    public final ImageView ivImg;
    public final LinearLayout llLab;
    private final FrameLayout rootView;
    public final TextView tvContent;
    public final TextView tvNum;

    private FragmentTimerItemPBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.fitem = frameLayout2;
        this.ivImg = imageView;
        this.llLab = linearLayout;
        this.tvContent = textView;
        this.tvNum = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTimerItemPBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTimerItemPBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_timer_item_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTimerItemPBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.iv_img;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_img);
        if (imageView != null) {
            i = R.id.ll_lab;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_lab);
            if (linearLayout != null) {
                i = R.id.tv_content;
                TextView textView = (TextView) view.findViewById(R.id.tv_content);
                if (textView != null) {
                    i = R.id.tv_num;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_num);
                    if (textView2 != null) {
                        return new FragmentTimerItemPBinding(frameLayout, frameLayout, imageView, linearLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
