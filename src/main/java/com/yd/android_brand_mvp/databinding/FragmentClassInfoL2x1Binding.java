package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassInfoL2x1Binding implements ViewBinding {
    public final TextView className;
    public final FrameLayout content;
    private final FrameLayout rootView;

    private FragmentClassInfoL2x1Binding(FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.className = textView;
        this.content = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassInfoL2x1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassInfoL2x1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_info_l2x1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassInfoL2x1Binding bind(View view) {
        int i = R.id.className;
        TextView textView = (TextView) view.findViewById(R.id.className);
        if (textView != null) {
            i = R.id.content;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
            if (frameLayout != null) {
                return new FragmentClassInfoL2x1Binding((FrameLayout) view, textView, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
