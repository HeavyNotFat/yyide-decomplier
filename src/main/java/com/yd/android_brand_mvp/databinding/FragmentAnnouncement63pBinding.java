package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAnnouncement63pBinding implements ViewBinding {
    public final LinearLayout content;
    public final MultiStateView mu;
    private final FrameLayout rootView;

    private FragmentAnnouncement63pBinding(FrameLayout frameLayout, LinearLayout linearLayout, MultiStateView multiStateView) {
        this.rootView = frameLayout;
        this.content = linearLayout;
        this.mu = multiStateView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAnnouncement63pBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAnnouncement63pBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_announcement6_3p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAnnouncement63pBinding bind(View view) {
        int i = R.id.content;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content);
        if (linearLayout != null) {
            i = R.id.mu;
            MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
            if (multiStateView != null) {
                return new FragmentAnnouncement63pBinding((FrameLayout) view, linearLayout, multiStateView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
