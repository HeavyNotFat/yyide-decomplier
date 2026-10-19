package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityTitileLayoutBinding implements ViewBinding {
    public final FrameLayout backLayout;
    public final TextView leftView;
    public final TextView rightView;
    private final FrameLayout rootView;
    public final TextView titleName;

    private ActivityTitileLayoutBinding(FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.backLayout = frameLayout2;
        this.leftView = textView;
        this.rightView = textView2;
        this.titleName = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTitileLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityTitileLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_titile_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityTitileLayoutBinding bind(View view) {
        int i = R.id.back_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.back_layout);
        if (frameLayout != null) {
            i = R.id.left_view;
            TextView textView = (TextView) view.findViewById(R.id.left_view);
            if (textView != null) {
                i = R.id.right_view;
                TextView textView2 = (TextView) view.findViewById(R.id.right_view);
                if (textView2 != null) {
                    i = R.id.title_Name;
                    TextView textView3 = (TextView) view.findViewById(R.id.title_Name);
                    if (textView3 != null) {
                        return new ActivityTitileLayoutBinding((FrameLayout) view, frameLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
