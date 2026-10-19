package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityPhotoBinding implements ViewBinding {
    public final ConstraintLayout constraintlayout;
    public final ImageView ivBack;
    private final ConstraintLayout rootView;
    public final SlidingTabLayout tablayout;
    public final TextView tvTitle;
    public final View view;
    public final ViewPager viewpager;

    private ActivityPhotoBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, SlidingTabLayout slidingTabLayout, TextView textView, View view, ViewPager viewPager) {
        this.rootView = constraintLayout;
        this.constraintlayout = constraintLayout2;
        this.ivBack = imageView;
        this.tablayout = slidingTabLayout;
        this.tvTitle = textView;
        this.view = view;
        this.viewpager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPhotoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityPhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_photo, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPhotoBinding bind(View view) {
        int i = R.id.constraintlayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.constraintlayout);
        if (constraintLayout != null) {
            i = R.id.iv_back;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
            if (imageView != null) {
                i = R.id.tablayout;
                SlidingTabLayout slidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.tablayout);
                if (slidingTabLayout != null) {
                    i = R.id.tv_title;
                    TextView textView = (TextView) view.findViewById(R.id.tv_title);
                    if (textView != null) {
                        i = R.id.view;
                        View viewFindViewById = view.findViewById(R.id.view);
                        if (viewFindViewById != null) {
                            i = R.id.viewpager;
                            ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
                            if (viewPager != null) {
                                return new ActivityPhotoBinding((ConstraintLayout) view, constraintLayout, imageView, slidingTabLayout, textView, viewFindViewById, viewPager);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
