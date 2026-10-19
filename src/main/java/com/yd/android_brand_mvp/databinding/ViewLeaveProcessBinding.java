package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewLeaveProcessBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final RecyclerView rvViewLeaveProcess;
    public final TextView tvViewLeaveProcess;
    public final TextView tvViewLeaveProcessTip;

    private ViewLeaveProcessBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.rvViewLeaveProcess = recyclerView;
        this.tvViewLeaveProcess = textView;
        this.tvViewLeaveProcessTip = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLeaveProcessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLeaveProcessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_leave_process, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewLeaveProcessBinding bind(View view) {
        int i = R.id.rv_view_leave_process;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_view_leave_process);
        if (recyclerView != null) {
            i = R.id.tv_view_leave_process;
            TextView textView = (TextView) view.findViewById(R.id.tv_view_leave_process);
            if (textView != null) {
                i = R.id.tv_view_leave_process_tip;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_view_leave_process_tip);
                if (textView2 != null) {
                    return new ViewLeaveProcessBinding((ConstraintLayout) view, recyclerView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
