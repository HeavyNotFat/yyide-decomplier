package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityHonorScoreDetailBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private ActivityHonorScoreDetailBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityHonorScoreDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityHonorScoreDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_honor_score_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityHonorScoreDetailBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new ActivityHonorScoreDetailBinding((ConstraintLayout) view);
    }
}
