package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutDialogLeaveFinishBinding implements ViewBinding {
    public final FrameLayout backLayout;
    public final TextView close;
    public final TextView qd;
    private final LinearLayout rootView;

    private LayoutDialogLeaveFinishBinding(LinearLayout linearLayout, FrameLayout frameLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.backLayout = frameLayout;
        this.close = textView;
        this.qd = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDialogLeaveFinishBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutDialogLeaveFinishBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_dialog_leave_finish, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutDialogLeaveFinishBinding bind(View view) {
        int i = R.id.back_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.back_layout);
        if (frameLayout != null) {
            i = R.id.close;
            TextView textView = (TextView) view.findViewById(R.id.close);
            if (textView != null) {
                i = R.id.qd;
                TextView textView2 = (TextView) view.findViewById(R.id.qd);
                if (textView2 != null) {
                    return new LayoutDialogLeaveFinishBinding((LinearLayout) view, frameLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
