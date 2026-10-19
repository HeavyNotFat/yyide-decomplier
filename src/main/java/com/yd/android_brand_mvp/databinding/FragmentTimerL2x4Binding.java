package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentTimerL2x4Binding implements ViewBinding {
    public final Banner announRoll;
    public final LinearLayout layoutContent;
    public final MultiStateView mu;
    private final ConstraintLayout rootView;
    public final TextView textView11;
    public final TextView title;

    private FragmentTimerL2x4Binding(ConstraintLayout constraintLayout, Banner banner, LinearLayout linearLayout, MultiStateView multiStateView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.announRoll = banner;
        this.layoutContent = linearLayout;
        this.mu = multiStateView;
        this.textView11 = textView;
        this.title = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTimerL2x4Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTimerL2x4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_timer_l2x4, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTimerL2x4Binding bind(View view) {
        int i = R.id.announRoll;
        Banner banner = (Banner) view.findViewById(R.id.announRoll);
        if (banner != null) {
            i = R.id.layout_content;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_content);
            if (linearLayout != null) {
                i = R.id.mu;
                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                if (multiStateView != null) {
                    i = R.id.textView11;
                    TextView textView = (TextView) view.findViewById(R.id.textView11);
                    if (textView != null) {
                        i = R.id.title;
                        TextView textView2 = (TextView) view.findViewById(R.id.title);
                        if (textView2 != null) {
                            return new FragmentTimerL2x4Binding((ConstraintLayout) view, banner, linearLayout, multiStateView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
