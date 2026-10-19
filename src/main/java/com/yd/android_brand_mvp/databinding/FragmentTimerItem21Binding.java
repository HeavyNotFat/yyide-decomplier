package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentTimerItem21Binding implements ViewBinding {
    public final FrameLayout fitem;
    public final ImageView ivImg;
    private final FrameLayout rootView;
    public final TextView tvContent;
    public final TextView tvNum;

    private FragmentTimerItem21Binding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.fitem = frameLayout2;
        this.ivImg = imageView;
        this.tvContent = textView;
        this.tvNum = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTimerItem21Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTimerItem21Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_timer_item_2_1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTimerItem21Binding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.iv_img;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_img);
        if (imageView != null) {
            i = R.id.tv_content;
            TextView textView = (TextView) view.findViewById(R.id.tv_content);
            if (textView != null) {
                i = R.id.tv_num;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_num);
                if (textView2 != null) {
                    return new FragmentTimerItem21Binding(frameLayout, frameLayout, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
