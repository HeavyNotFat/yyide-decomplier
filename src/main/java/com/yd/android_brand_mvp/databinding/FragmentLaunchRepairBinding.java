package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentLaunchRepairBinding implements ViewBinding {
    public final TextView btnFragmentStudentApplyLeave;
    public final ConstraintLayout clFragmentStudentApplyLeaveBtn;
    public final LinearLayout llFragmentStudentApplyLeave;
    private final ConstraintLayout rootView;
    public final NestedScrollView scrollViewFragmentStudentApplyLeave;

    private FragmentLaunchRepairBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, LinearLayout linearLayout, NestedScrollView nestedScrollView) {
        this.rootView = constraintLayout;
        this.btnFragmentStudentApplyLeave = textView;
        this.clFragmentStudentApplyLeaveBtn = constraintLayout2;
        this.llFragmentStudentApplyLeave = linearLayout;
        this.scrollViewFragmentStudentApplyLeave = nestedScrollView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLaunchRepairBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentLaunchRepairBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_launch_repair, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentLaunchRepairBinding bind(View view) {
        int i = R.id.btn_fragment_student_apply_leave;
        TextView textView = (TextView) view.findViewById(R.id.btn_fragment_student_apply_leave);
        if (textView != null) {
            i = R.id.cl_fragment_student_apply_leave_btn;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_fragment_student_apply_leave_btn);
            if (constraintLayout != null) {
                i = R.id.ll_fragment_student_apply_leave;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_fragment_student_apply_leave);
                if (linearLayout != null) {
                    i = R.id.scrollView_fragment_student_apply_leave;
                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.scrollView_fragment_student_apply_leave);
                    if (nestedScrollView != null) {
                        return new FragmentLaunchRepairBinding((ConstraintLayout) view, textView, constraintLayout, linearLayout, nestedScrollView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
