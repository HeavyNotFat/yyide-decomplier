package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentRepair21Binding implements ViewBinding {
    public final AppCompatButton btnFragmentRepair;
    public final ConstraintLayout clFragmentRepair;
    private final ConstraintLayout rootView;

    private FragmentRepair21Binding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.btnFragmentRepair = appCompatButton;
        this.clFragmentRepair = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentRepair21Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentRepair21Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_repair21, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentRepair21Binding bind(View view) {
        AppCompatButton appCompatButton = (AppCompatButton) view.findViewById(R.id.btn_fragment_repair);
        if (appCompatButton != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new FragmentRepair21Binding(constraintLayout, appCompatButton, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.btn_fragment_repair)));
    }
}
