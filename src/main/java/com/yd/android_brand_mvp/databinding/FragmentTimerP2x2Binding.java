package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentTimerP2x2Binding implements ViewBinding {
    public final Banner announRoll;
    public final LinearLayout layoutContent;
    public final MultiStateView mu;
    private final LinearLayout rootView;

    private FragmentTimerP2x2Binding(LinearLayout linearLayout, Banner banner, LinearLayout linearLayout2, MultiStateView multiStateView) {
        this.rootView = linearLayout;
        this.announRoll = banner;
        this.layoutContent = linearLayout2;
        this.mu = multiStateView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTimerP2x2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTimerP2x2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_timer_p2x2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTimerP2x2Binding bind(View view) {
        int i = R.id.announRoll;
        Banner banner = (Banner) view.findViewById(R.id.announRoll);
        if (banner != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
            if (multiStateView != null) {
                return new FragmentTimerP2x2Binding(linearLayout, banner, linearLayout, multiStateView);
            }
            i = R.id.mu;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
