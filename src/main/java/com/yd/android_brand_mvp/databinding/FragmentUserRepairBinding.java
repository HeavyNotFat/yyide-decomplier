package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentUserRepairBinding implements ViewBinding {
    public final ConstraintLayout clFragmentRepairDetailNav;
    public final FrameLayout flFragmentRepairDetail;
    public final Guideline lineDivision;
    private final ConstraintLayout rootView;
    public final TextView tvFragmentRepairDetailLaunch;
    public final TextView tvFragmentRepairDetailList;

    private FragmentUserRepairBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FrameLayout frameLayout, Guideline guideline, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clFragmentRepairDetailNav = constraintLayout2;
        this.flFragmentRepairDetail = frameLayout;
        this.lineDivision = guideline;
        this.tvFragmentRepairDetailLaunch = textView;
        this.tvFragmentRepairDetailList = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUserRepairBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUserRepairBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_user_repair, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUserRepairBinding bind(View view) {
        int i = R.id.cl_fragment_repair_detail_nav;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_fragment_repair_detail_nav);
        if (constraintLayout != null) {
            i = R.id.fl_fragment_repair_detail;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_fragment_repair_detail);
            if (frameLayout != null) {
                i = R.id.line_division;
                Guideline guideline = (Guideline) view.findViewById(R.id.line_division);
                if (guideline != null) {
                    i = R.id.tv_fragment_repair_detail_launch;
                    TextView textView = (TextView) view.findViewById(R.id.tv_fragment_repair_detail_launch);
                    if (textView != null) {
                        i = R.id.tv_fragment_repair_detail_list;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_repair_detail_list);
                        if (textView2 != null) {
                            return new FragmentUserRepairBinding((ConstraintLayout) view, constraintLayout, frameLayout, guideline, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
