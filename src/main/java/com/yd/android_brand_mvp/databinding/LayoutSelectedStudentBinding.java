package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutSelectedStudentBinding implements ViewBinding {
    public final ConstraintLayout ctSelectStudent;
    private final ConstraintLayout rootView;
    public final TextView tvOneName;
    public final TextView tvSelectDesc;
    public final TextView tvTwoName;

    private LayoutSelectedStudentBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.ctSelectStudent = constraintLayout2;
        this.tvOneName = textView;
        this.tvSelectDesc = textView2;
        this.tvTwoName = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutSelectedStudentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutSelectedStudentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_selected_student, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutSelectedStudentBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.tvOneName;
        TextView textView = (TextView) view.findViewById(R.id.tvOneName);
        if (textView != null) {
            i = R.id.tvSelectDesc;
            TextView textView2 = (TextView) view.findViewById(R.id.tvSelectDesc);
            if (textView2 != null) {
                i = R.id.tvTwoName;
                TextView textView3 = (TextView) view.findViewById(R.id.tvTwoName);
                if (textView3 != null) {
                    return new LayoutSelectedStudentBinding(constraintLayout, constraintLayout, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
