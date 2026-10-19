package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentBaseLeaveBinding implements ViewBinding {
    public final CheckedTextView btn1;
    public final CheckedTextView btn2;
    public final FrameLayout content;
    private final LinearLayout rootView;

    private FragmentBaseLeaveBinding(LinearLayout linearLayout, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.btn1 = checkedTextView;
        this.btn2 = checkedTextView2;
        this.content = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBaseLeaveBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBaseLeaveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_base_leave, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentBaseLeaveBinding bind(View view) {
        int i = R.id.btn1;
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.btn1);
        if (checkedTextView != null) {
            i = R.id.btn2;
            CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.btn2);
            if (checkedTextView2 != null) {
                i = R.id.content;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
                if (frameLayout != null) {
                    return new FragmentBaseLeaveBinding((LinearLayout) view, checkedTextView, checkedTextView2, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
