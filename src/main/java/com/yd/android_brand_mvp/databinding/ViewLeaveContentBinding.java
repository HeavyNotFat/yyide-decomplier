package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewLeaveContentBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvViewLeaveContentContent;
    public final TextView tvViewLeaveContentTitle;

    private ViewLeaveContentBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.tvViewLeaveContentContent = textView;
        this.tvViewLeaveContentTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLeaveContentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLeaveContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_leave_content, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewLeaveContentBinding bind(View view) {
        int i = R.id.tv_view_leave_content_content;
        TextView textView = (TextView) view.findViewById(R.id.tv_view_leave_content_content);
        if (textView != null) {
            i = R.id.tv_view_leave_content_title;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_view_leave_content_title);
            if (textView2 != null) {
                return new ViewLeaveContentBinding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
