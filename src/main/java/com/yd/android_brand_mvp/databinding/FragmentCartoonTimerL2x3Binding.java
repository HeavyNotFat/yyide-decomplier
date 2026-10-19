package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentCartoonTimerL2x3Binding implements ViewBinding {
    public final Banner announRoll;
    public final LinearLayout layoutContent;
    public final MultiStateView mu;
    private final LinearLayout rootView;
    public final TextView title;

    private FragmentCartoonTimerL2x3Binding(LinearLayout linearLayout, Banner banner, LinearLayout linearLayout2, MultiStateView multiStateView, TextView textView) {
        this.rootView = linearLayout;
        this.announRoll = banner;
        this.layoutContent = linearLayout2;
        this.mu = multiStateView;
        this.title = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCartoonTimerL2x3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCartoonTimerL2x3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_cartoon_timer_l2x3, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCartoonTimerL2x3Binding bind(View view) {
        int i = R.id.announRoll;
        Banner banner = (Banner) view.findViewById(R.id.announRoll);
        if (banner != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.mu;
            MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
            if (multiStateView != null) {
                i = R.id.title;
                TextView textView = (TextView) view.findViewById(R.id.title);
                if (textView != null) {
                    return new FragmentCartoonTimerL2x3Binding(linearLayout, banner, linearLayout, multiStateView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
