package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentRepair22Binding implements ViewBinding {
    public final AppCompatButton btnFragmentRepair;
    public final ConstraintLayout clFragmentRepair22;
    private final ConstraintLayout rootView;
    public final LayoutHeadTitleBinding topFragmentRepair22;

    private FragmentRepair22Binding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, ConstraintLayout constraintLayout2, LayoutHeadTitleBinding layoutHeadTitleBinding) {
        this.rootView = constraintLayout;
        this.btnFragmentRepair = appCompatButton;
        this.clFragmentRepair22 = constraintLayout2;
        this.topFragmentRepair22 = layoutHeadTitleBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentRepair22Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentRepair22Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_repair22, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentRepair22Binding bind(View view) {
        AppCompatButton appCompatButton = (AppCompatButton) view.findViewById(R.id.btn_fragment_repair);
        if (appCompatButton != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            View viewFindViewById = view.findViewById(R.id.top_fragment_repair22);
            return new FragmentRepair22Binding(constraintLayout, appCompatButton, constraintLayout, viewFindViewById != null ? LayoutHeadTitleBinding.bind(viewFindViewById) : null);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.btn_fragment_repair)));
    }
}
