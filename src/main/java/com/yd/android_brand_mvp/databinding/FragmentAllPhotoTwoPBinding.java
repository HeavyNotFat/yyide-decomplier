package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAllPhotoTwoPBinding implements ViewBinding {
    public final MultiStateView mu;
    public final RecyclerView rlList;
    private final LinearLayout rootView;

    private FragmentAllPhotoTwoPBinding(LinearLayout linearLayout, MultiStateView multiStateView, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.mu = multiStateView;
        this.rlList = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAllPhotoTwoPBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAllPhotoTwoPBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_all_photo_two_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAllPhotoTwoPBinding bind(View view) {
        int i = R.id.mu;
        MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
        if (multiStateView != null) {
            i = R.id.rl_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rl_list);
            if (recyclerView != null) {
                return new FragmentAllPhotoTwoPBinding((LinearLayout) view, multiStateView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
