package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class NcMsgLayoutBinding implements ViewBinding {
    public final LinearLayout llTitle;
    public final TextView name;
    private final LinearLayout rootView;
    public final TextView time;

    private NcMsgLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.llTitle = linearLayout2;
        this.name = textView;
        this.time = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NcMsgLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NcMsgLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.nc_msg_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NcMsgLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.name;
        TextView textView = (TextView) view.findViewById(R.id.name);
        if (textView != null) {
            i = R.id.time;
            TextView textView2 = (TextView) view.findViewById(R.id.time);
            if (textView2 != null) {
                return new NcMsgLayoutBinding(linearLayout, linearLayout, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
