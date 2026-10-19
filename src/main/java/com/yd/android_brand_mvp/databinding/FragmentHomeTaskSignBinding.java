package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHomeTaskSignBinding implements ViewBinding {
    public final Banner bannerHomeTask;
    public final ConstraintLayout clContent;
    private final ConstraintLayout rootView;
    public final ItemImageHomeNullLayoutBinding viewEmpty;

    private FragmentHomeTaskSignBinding(ConstraintLayout constraintLayout, Banner banner, ConstraintLayout constraintLayout2, ItemImageHomeNullLayoutBinding itemImageHomeNullLayoutBinding) {
        this.rootView = constraintLayout;
        this.bannerHomeTask = banner;
        this.clContent = constraintLayout2;
        this.viewEmpty = itemImageHomeNullLayoutBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeTaskSignBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHomeTaskSignBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_home_task_sign, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomeTaskSignBinding bind(View view) {
        int i = R.id.banner_home_task;
        Banner banner = (Banner) view.findViewById(R.id.banner_home_task);
        if (banner != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            View viewFindViewById = view.findViewById(R.id.view_empty);
            if (viewFindViewById != null) {
                return new FragmentHomeTaskSignBinding(constraintLayout, banner, constraintLayout, ItemImageHomeNullLayoutBinding.bind(viewFindViewById));
            }
            i = R.id.view_empty;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
