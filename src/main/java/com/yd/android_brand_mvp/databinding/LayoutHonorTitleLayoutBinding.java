package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutHonorTitleLayoutBinding implements ViewBinding {
    public final FrameLayout backLayout;
    public final ConstraintLayout flTitle;
    public final ImageView ivLayout;
    public final ImageView ivRight;
    private final ConstraintLayout rootView;
    public final TextView titleName;
    public final TextView tvRight;

    private LayoutHonorTitleLayoutBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.backLayout = frameLayout;
        this.flTitle = constraintLayout2;
        this.ivLayout = imageView;
        this.ivRight = imageView2;
        this.titleName = textView;
        this.tvRight = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutHonorTitleLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutHonorTitleLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_honor_title_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutHonorTitleLayoutBinding bind(View view) {
        int i = R.id.back_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.back_layout);
        if (frameLayout != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.iv_layout;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_layout);
            if (imageView != null) {
                i = R.id.ivRight;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.ivRight);
                if (imageView2 != null) {
                    i = R.id.title_Name;
                    TextView textView = (TextView) view.findViewById(R.id.title_Name);
                    if (textView != null) {
                        i = R.id.tv_right;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_right);
                        if (textView2 != null) {
                            return new LayoutHonorTitleLayoutBinding(constraintLayout, frameLayout, constraintLayout, imageView, imageView2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
