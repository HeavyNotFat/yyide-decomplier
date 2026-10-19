package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class EmptyDormitoryRankingBinding implements ViewBinding {
    public final ImageView ivEmptyDormitoryRankingEmpty;
    public final View ivEmptyDormitoryRankingLogo;
    private final ConstraintLayout rootView;

    private EmptyDormitoryRankingBinding(ConstraintLayout constraintLayout, ImageView imageView, View view) {
        this.rootView = constraintLayout;
        this.ivEmptyDormitoryRankingEmpty = imageView;
        this.ivEmptyDormitoryRankingLogo = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EmptyDormitoryRankingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EmptyDormitoryRankingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.empty_dormitory_ranking, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EmptyDormitoryRankingBinding bind(View view) {
        int i = R.id.iv_empty_dormitory_ranking_empty;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_empty_dormitory_ranking_empty);
        if (imageView != null) {
            i = R.id.iv_empty_dormitory_ranking_logo;
            View viewFindViewById = view.findViewById(R.id.iv_empty_dormitory_ranking_logo);
            if (viewFindViewById != null) {
                return new EmptyDormitoryRankingBinding((ConstraintLayout) view, imageView, viewFindViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
