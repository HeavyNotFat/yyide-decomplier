package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityWeekTitileLayoutBinding implements ViewBinding {
    public final FrameLayout backLayout;
    public final TextView rbFri;
    private final FrameLayout rootView;
    public final TextView titleName;

    private ActivityWeekTitileLayoutBinding(FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.backLayout = frameLayout2;
        this.rbFri = textView;
        this.titleName = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityWeekTitileLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWeekTitileLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_week_titile_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWeekTitileLayoutBinding bind(View view) {
        int i = R.id.back_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.back_layout);
        if (frameLayout != null) {
            i = R.id.rb_fri;
            TextView textView = (TextView) view.findViewById(R.id.rb_fri);
            if (textView != null) {
                i = R.id.title_Name;
                TextView textView2 = (TextView) view.findViewById(R.id.title_Name);
                if (textView2 != null) {
                    return new ActivityWeekTitileLayoutBinding((FrameLayout) view, frameLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
