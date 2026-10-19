package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class HonorActiveDetailFragmentBinding implements ViewBinding {
    public final CardView cardViewState;
    public final CollapsingToolbarLayout collapsingtoolbarlayout;
    public final ConstraintLayout constraintLayout;
    public final CoordinatorLayout coordinatorLayout;
    public final ConstraintLayout ctContent;
    public final ImageView ivCover;
    private final ConstraintLayout rootView;
    public final SlidingTabLayout slidingTabLayout;
    public final TextView tvActiveContent;
    public final TextView tvConfirm;
    public final TextView tvState;
    public final TextView tvTiem;
    public final TextView tvTitle;
    public final ViewPager viewpager;

    private HonorActiveDetailFragmentBinding(ConstraintLayout constraintLayout, CardView cardView, CollapsingToolbarLayout collapsingToolbarLayout, ConstraintLayout constraintLayout2, CoordinatorLayout coordinatorLayout, ConstraintLayout constraintLayout3, ImageView imageView, SlidingTabLayout slidingTabLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ViewPager viewPager) {
        this.rootView = constraintLayout;
        this.cardViewState = cardView;
        this.collapsingtoolbarlayout = collapsingToolbarLayout;
        this.constraintLayout = constraintLayout2;
        this.coordinatorLayout = coordinatorLayout;
        this.ctContent = constraintLayout3;
        this.ivCover = imageView;
        this.slidingTabLayout = slidingTabLayout;
        this.tvActiveContent = textView;
        this.tvConfirm = textView2;
        this.tvState = textView3;
        this.tvTiem = textView4;
        this.tvTitle = textView5;
        this.viewpager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HonorActiveDetailFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HonorActiveDetailFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.honor_active_detail_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HonorActiveDetailFragmentBinding bind(View view) {
        int i = R.id.cardViewState;
        CardView cardView = (CardView) view.findViewById(R.id.cardViewState);
        if (cardView != null) {
            i = R.id.collapsingtoolbarlayout;
            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsingtoolbarlayout);
            if (collapsingToolbarLayout != null) {
                i = R.id.constraintLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.constraintLayout);
                if (constraintLayout != null) {
                    i = R.id.coordinatorLayout;
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinatorLayout);
                    if (coordinatorLayout != null) {
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                        i = R.id.ivCover;
                        ImageView imageView = (ImageView) view.findViewById(R.id.ivCover);
                        if (imageView != null) {
                            i = R.id.slidingTabLayout;
                            SlidingTabLayout slidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.slidingTabLayout);
                            if (slidingTabLayout != null) {
                                i = R.id.tvActiveContent;
                                TextView textView = (TextView) view.findViewById(R.id.tvActiveContent);
                                if (textView != null) {
                                    i = R.id.tvConfirm;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tvConfirm);
                                    if (textView2 != null) {
                                        i = R.id.tvState;
                                        TextView textView3 = (TextView) view.findViewById(R.id.tvState);
                                        if (textView3 != null) {
                                            i = R.id.tvTiem;
                                            TextView textView4 = (TextView) view.findViewById(R.id.tvTiem);
                                            if (textView4 != null) {
                                                i = R.id.tvTitle;
                                                TextView textView5 = (TextView) view.findViewById(R.id.tvTitle);
                                                if (textView5 != null) {
                                                    i = R.id.viewpager;
                                                    ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
                                                    if (viewPager != null) {
                                                        return new HonorActiveDetailFragmentBinding(constraintLayout2, cardView, collapsingToolbarLayout, constraintLayout, coordinatorLayout, constraintLayout2, imageView, slidingTabLayout, textView, textView2, textView3, textView4, textView5, viewPager);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
