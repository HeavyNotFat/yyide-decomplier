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
public final class TitleLayout2Binding implements ViewBinding {
    public final FrameLayout backLayout;
    public final ConstraintLayout clRight;
    public final ConstraintLayout flTitle;
    public final ImageView ivBack;
    public final ImageView ivEdit;
    public final ImageView ivRight;
    public final ImageView ivRightLeft;
    private final ConstraintLayout rootView;
    public final TextView titleName;
    public final TextView tvRight;

    private TitleLayout2Binding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.backLayout = frameLayout;
        this.clRight = constraintLayout2;
        this.flTitle = constraintLayout3;
        this.ivBack = imageView;
        this.ivEdit = imageView2;
        this.ivRight = imageView3;
        this.ivRightLeft = imageView4;
        this.titleName = textView;
        this.tvRight = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TitleLayout2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TitleLayout2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.title_layout2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TitleLayout2Binding bind(View view) {
        int i = R.id.back_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.back_layout);
        if (frameLayout != null) {
            i = R.id.clRight;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.clRight);
            if (constraintLayout != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                i = R.id.iv_back;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
                if (imageView != null) {
                    i = R.id.iv_edit;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_edit);
                    if (imageView2 != null) {
                        i = R.id.iv_right;
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_right);
                        if (imageView3 != null) {
                            i = R.id.ivRightLeft;
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.ivRightLeft);
                            if (imageView4 != null) {
                                i = R.id.title_Name;
                                TextView textView = (TextView) view.findViewById(R.id.title_Name);
                                if (textView != null) {
                                    i = R.id.tv_right;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_right);
                                    if (textView2 != null) {
                                        return new TitleLayout2Binding(constraintLayout2, frameLayout, constraintLayout, constraintLayout2, imageView, imageView2, imageView3, imageView4, textView, textView2);
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
