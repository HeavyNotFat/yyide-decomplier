package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class TimerItemPBinding implements ViewBinding {
    public final FrameLayout flBg;
    private final FrameLayout rootView;
    public final TextView tvContent;
    public final TextView tvNum;

    private TimerItemPBinding(FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.flBg = frameLayout2;
        this.tvContent = textView;
        this.tvNum = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TimerItemPBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TimerItemPBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.timer_item_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TimerItemPBinding bind(View view) {
        int i = R.id.fl_bg;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_bg);
        if (frameLayout != null) {
            i = R.id.tv_content;
            TextView textView = (TextView) view.findViewById(R.id.tv_content);
            if (textView != null) {
                i = R.id.tv_num;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_num);
                if (textView2 != null) {
                    return new TimerItemPBinding((FrameLayout) view, frameLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
