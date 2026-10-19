package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutCenterMenuBinding implements ViewBinding {
    public final CheckedTextView check;
    public final CheckedTextView checkImg;
    private final ConstraintLayout rootView;

    private LayoutCenterMenuBinding(ConstraintLayout constraintLayout, CheckedTextView checkedTextView, CheckedTextView checkedTextView2) {
        this.rootView = constraintLayout;
        this.check = checkedTextView;
        this.checkImg = checkedTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutCenterMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutCenterMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_center_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutCenterMenuBinding bind(View view) {
        int i = R.id.check;
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.check);
        if (checkedTextView != null) {
            i = R.id.checkImg;
            CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.checkImg);
            if (checkedTextView2 != null) {
                return new LayoutCenterMenuBinding((ConstraintLayout) view, checkedTextView, checkedTextView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
