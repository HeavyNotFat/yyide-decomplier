package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentWlkz22lBinding implements ViewBinding {
    public final CheckedTextView door;
    public final ConstraintLayout flContent;
    private final ConstraintLayout rootView;

    private FragmentWlkz22lBinding(ConstraintLayout constraintLayout, CheckedTextView checkedTextView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.door = checkedTextView;
        this.flContent = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentWlkz22lBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentWlkz22lBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_wlkz_2_2l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentWlkz22lBinding bind(View view) {
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.door);
        if (checkedTextView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new FragmentWlkz22lBinding(constraintLayout, checkedTextView, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.door)));
    }
}
