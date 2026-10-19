package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityDominateShowImageBinding implements ViewBinding {
    public final ImageView ivClose;
    public final LinearLayoutCompat llVideo;
    private final ConstraintLayout rootView;
    public final ViewPager2 viewPager2;

    private ActivityDominateShowImageBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayoutCompat linearLayoutCompat, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.ivClose = imageView;
        this.llVideo = linearLayoutCompat;
        this.viewPager2 = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDominateShowImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDominateShowImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_dominate_show_image, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDominateShowImageBinding bind(View view) {
        int i = R.id.ivClose;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivClose);
        if (imageView != null) {
            i = R.id.llVideo;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.llVideo);
            if (linearLayoutCompat != null) {
                i = R.id.viewPager2;
                ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.viewPager2);
                if (viewPager2 != null) {
                    return new ActivityDominateShowImageBinding((ConstraintLayout) view, imageView, linearLayoutCompat, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
