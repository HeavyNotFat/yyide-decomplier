package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ClosePopupLayoutBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView tvNoClose;
    public final TextView tvTime;

    private ClosePopupLayoutBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.tvNoClose = textView;
        this.tvTime = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ClosePopupLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ClosePopupLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.close_popup_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ClosePopupLayoutBinding bind(View view) {
        int i = R.id.tv_no_close;
        TextView textView = (TextView) view.findViewById(R.id.tv_no_close);
        if (textView != null) {
            i = R.id.tv_time;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_time);
            if (textView2 != null) {
                return new ClosePopupLayoutBinding((RelativeLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
