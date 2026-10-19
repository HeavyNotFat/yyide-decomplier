package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class AssignmentNullBinding implements ViewBinding {
    private final LinearLayout rootView;

    private AssignmentNullBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AssignmentNullBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AssignmentNullBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.assignment_null, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AssignmentNullBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new AssignmentNullBinding((LinearLayout) view);
    }
}
