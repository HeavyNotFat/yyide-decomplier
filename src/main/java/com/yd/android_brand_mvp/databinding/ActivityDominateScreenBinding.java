package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityDominateScreenBinding implements ViewBinding {
    public final ImageView ivClose;
    public final ImageView ivLeft;
    public final ImageView ivRight;
    private final ConstraintLayout rootView;
    public final ViewPager2 viewPager2;

    private ActivityDominateScreenBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.ivClose = imageView;
        this.ivLeft = imageView2;
        this.ivRight = imageView3;
        this.viewPager2 = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDominateScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDominateScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_dominate_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDominateScreenBinding bind(View view) {
        int i = R.id.ivClose;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivClose);
        if (imageView != null) {
            i = R.id.ivLeft;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.ivLeft);
            if (imageView2 != null) {
                i = R.id.ivRight;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.ivRight);
                if (imageView3 != null) {
                    i = R.id.viewPager2;
                    ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.viewPager2);
                    if (viewPager2 != null) {
                        return new ActivityDominateScreenBinding((ConstraintLayout) view, imageView, imageView2, imageView3, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
