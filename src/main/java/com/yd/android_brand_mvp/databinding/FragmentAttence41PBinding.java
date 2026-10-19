package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAttence41PBinding implements ViewBinding {
    public final LinearLayout content;
    public final LayoutHeadTitleBinding inTitle;
    public final MultiStateView mu;
    public final RecyclerView rlAttence;
    private final FrameLayout rootView;
    public final TextView tvAtt;

    private FragmentAttence41PBinding(FrameLayout frameLayout, LinearLayout linearLayout, LayoutHeadTitleBinding layoutHeadTitleBinding, MultiStateView multiStateView, RecyclerView recyclerView, TextView textView) {
        this.rootView = frameLayout;
        this.content = linearLayout;
        this.inTitle = layoutHeadTitleBinding;
        this.mu = multiStateView;
        this.rlAttence = recyclerView;
        this.tvAtt = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAttence41PBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAttence41PBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_attence_4_1_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAttence41PBinding bind(View view) {
        int i = R.id.content;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content);
        if (linearLayout != null) {
            i = R.id.in_title;
            View viewFindViewById = view.findViewById(R.id.in_title);
            if (viewFindViewById != null) {
                LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                i = R.id.mu;
                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                if (multiStateView != null) {
                    i = R.id.rl_attence;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rl_attence);
                    if (recyclerView != null) {
                        i = R.id.tv_att;
                        TextView textView = (TextView) view.findViewById(R.id.tv_att);
                        if (textView != null) {
                            return new FragmentAttence41PBinding((FrameLayout) view, linearLayout, layoutHeadTitleBindingBind, multiStateView, recyclerView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
