package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutCustomHeadTitleBinding implements ViewBinding {
    public final LinearLayout llTitle;
    private final LinearLayout rootView;
    public final TextView title;
    public final TextView tvWeek;

    private LayoutCustomHeadTitleBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.llTitle = linearLayout2;
        this.title = textView;
        this.tvWeek = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutCustomHeadTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutCustomHeadTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_custom_head_title, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutCustomHeadTitleBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.title;
        TextView textView = (TextView) view.findViewById(R.id.title);
        if (textView != null) {
            i = R.id.tv_week;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_week);
            if (textView2 != null) {
                return new LayoutCustomHeadTitleBinding(linearLayout, linearLayout, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
