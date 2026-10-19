package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassInfoP4x11Binding implements ViewBinding {
    public final RelativeLayout rlTab;
    private final FrameLayout rootView;
    public final TextView tvClassName;

    private FragmentClassInfoP4x11Binding(FrameLayout frameLayout, RelativeLayout relativeLayout, TextView textView) {
        this.rootView = frameLayout;
        this.rlTab = relativeLayout;
        this.tvClassName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassInfoP4x11Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassInfoP4x11Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_info_p4x1_1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassInfoP4x11Binding bind(View view) {
        int i = R.id.rl_tab;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_tab);
        if (relativeLayout != null) {
            i = R.id.tv_class_name;
            TextView textView = (TextView) view.findViewById(R.id.tv_class_name);
            if (textView != null) {
                return new FragmentClassInfoP4x11Binding((FrameLayout) view, relativeLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
