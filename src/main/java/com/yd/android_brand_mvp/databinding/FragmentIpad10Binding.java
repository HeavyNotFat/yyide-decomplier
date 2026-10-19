package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentIpad10Binding implements ViewBinding {
    public final ConstraintLayout constraintLayout;
    public final ConstraintLayout constraintLayout2;
    public final ConstraintLayout constraintLayout3;
    private final ConstraintLayout rootView;

    private FragmentIpad10Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4) {
        this.rootView = constraintLayout;
        this.constraintLayout = constraintLayout2;
        this.constraintLayout2 = constraintLayout3;
        this.constraintLayout3 = constraintLayout4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentIpad10Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentIpad10Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ipad_10_, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentIpad10Binding bind(View view) {
        int i = R.id.constraintLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.constraintLayout);
        if (constraintLayout != null) {
            i = R.id.constraintLayout2;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.constraintLayout2);
            if (constraintLayout2 != null) {
                i = R.id.constraintLayout3;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.constraintLayout3);
                if (constraintLayout3 != null) {
                    return new FragmentIpad10Binding((ConstraintLayout) view, constraintLayout, constraintLayout2, constraintLayout3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
