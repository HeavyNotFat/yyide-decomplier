package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.jude.rollviewpager.RollPagerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentTimerP2x21Binding implements ViewBinding {
    public final RollPagerView announRoll;
    public final MultiStateView mu;
    private final LinearLayout rootView;

    private FragmentTimerP2x21Binding(LinearLayout linearLayout, RollPagerView rollPagerView, MultiStateView multiStateView) {
        this.rootView = linearLayout;
        this.announRoll = rollPagerView;
        this.mu = multiStateView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTimerP2x21Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTimerP2x21Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_timer_p2x21, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTimerP2x21Binding bind(View view) {
        int i = R.id.announRoll;
        RollPagerView rollPagerView = (RollPagerView) view.findViewById(R.id.announRoll);
        if (rollPagerView != null) {
            i = R.id.mu;
            MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
            if (multiStateView != null) {
                return new FragmentTimerP2x21Binding((LinearLayout) view, rollPagerView, multiStateView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
