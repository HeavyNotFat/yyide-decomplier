package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutLeaveItemBinding implements ViewBinding {
    public final LinearLayout itemLayout;
    public final TextView reason;
    private final LinearLayout rootView;
    public final TextView tvLayoutLeaveItemTime;
    public final TextView type;

    private LayoutLeaveItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.itemLayout = linearLayout2;
        this.reason = textView;
        this.tvLayoutLeaveItemTime = textView2;
        this.type = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutLeaveItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutLeaveItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_leave_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutLeaveItemBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.reason;
        TextView textView = (TextView) view.findViewById(R.id.reason);
        if (textView != null) {
            i = R.id.tv_layout_leave_item_time;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_layout_leave_item_time);
            if (textView2 != null) {
                i = R.id.type;
                TextView textView3 = (TextView) view.findViewById(R.id.type);
                if (textView3 != null) {
                    return new LayoutLeaveItemBinding(linearLayout, linearLayout, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
