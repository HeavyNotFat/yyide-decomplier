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
public final class ActivityPatrolEditBinding implements ViewBinding {
    public final TextView btnActivityPatrolEdit;
    public final ConstraintLayout clActivityPatrolEditBtn;
    public final LinearLayout llActivityPatrolEditContainer;
    private final ConstraintLayout rootView;
    public final NestedScrollView svActivityPatrolEdit;
    public final ViewPatrolBaseInfoBinding viewActivityPatrolHead;

    private ActivityPatrolEditBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, LinearLayout linearLayout, NestedScrollView nestedScrollView, ViewPatrolBaseInfoBinding viewPatrolBaseInfoBinding) {
        this.rootView = constraintLayout;
        this.btnActivityPatrolEdit = textView;
        this.clActivityPatrolEditBtn = constraintLayout2;
        this.llActivityPatrolEditContainer = linearLayout;
        this.svActivityPatrolEdit = nestedScrollView;
        this.viewActivityPatrolHead = viewPatrolBaseInfoBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPatrolEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityPatrolEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_patrol_edit, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPatrolEditBinding bind(View view) {
        int i = R.id.btn_activity_patrol_edit;
        TextView textView = (TextView) view.findViewById(R.id.btn_activity_patrol_edit);
        if (textView != null) {
            i = R.id.cl_activity_patrol_edit_btn;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_activity_patrol_edit_btn);
            if (constraintLayout != null) {
                i = R.id.ll_activity_patrol_edit_container;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_activity_patrol_edit_container);
                if (linearLayout != null) {
                    i = R.id.sv_activity_patrol_edit;
                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.sv_activity_patrol_edit);
                    if (nestedScrollView != null) {
                        i = R.id.view_activity_patrol_head;
                        View viewFindViewById = view.findViewById(R.id.view_activity_patrol_head);
                        if (viewFindViewById != null) {
                            return new ActivityPatrolEditBinding((ConstraintLayout) view, textView, constraintLayout, linearLayout, nestedScrollView, ViewPatrolBaseInfoBinding.bind(viewFindViewById));
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
