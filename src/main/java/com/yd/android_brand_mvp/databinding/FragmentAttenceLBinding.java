package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAttenceLBinding implements ViewBinding {
    public final FrameLayout flLayout;
    public final MultiStateView mu;
    public final MultiStateView mu1;
    public final RecyclerView rlAttence;
    public final RecyclerView rlHasClock;
    private final FrameLayout rootView;
    public final TextView tvHumanFace;
    public final TextView tvSwipingCard;
    public final TextView tvTip;

    private FragmentAttenceLBinding(FrameLayout frameLayout, FrameLayout frameLayout2, MultiStateView multiStateView, MultiStateView multiStateView2, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.flLayout = frameLayout2;
        this.mu = multiStateView;
        this.mu1 = multiStateView2;
        this.rlAttence = recyclerView;
        this.rlHasClock = recyclerView2;
        this.tvHumanFace = textView;
        this.tvSwipingCard = textView2;
        this.tvTip = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAttenceLBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAttenceLBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_attence_l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAttenceLBinding bind(View view) {
        int i = R.id.fl_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_layout);
        if (frameLayout != null) {
            i = R.id.mu;
            MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
            if (multiStateView != null) {
                i = R.id.mu1;
                MultiStateView multiStateView2 = (MultiStateView) view.findViewById(R.id.mu1);
                if (multiStateView2 != null) {
                    i = R.id.rl_attence;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rl_attence);
                    if (recyclerView != null) {
                        i = R.id.rl_has_clock;
                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rl_has_clock);
                        if (recyclerView2 != null) {
                            i = R.id.tv_human_face;
                            TextView textView = (TextView) view.findViewById(R.id.tv_human_face);
                            if (textView != null) {
                                i = R.id.tv_swiping_card;
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_swiping_card);
                                if (textView2 != null) {
                                    i = R.id.tvTip;
                                    TextView textView3 = (TextView) view.findViewById(R.id.tvTip);
                                    if (textView3 != null) {
                                        return new FragmentAttenceLBinding((FrameLayout) view, frameLayout, multiStateView, multiStateView2, recyclerView, recyclerView2, textView, textView2, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
