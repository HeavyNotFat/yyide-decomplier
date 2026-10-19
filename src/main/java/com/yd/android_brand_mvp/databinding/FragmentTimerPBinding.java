package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentTimerPBinding implements ViewBinding {
    public final ListView lvlist;
    public final MultiStateView mu;
    private final FrameLayout rootView;

    private FragmentTimerPBinding(FrameLayout frameLayout, ListView listView, MultiStateView multiStateView) {
        this.rootView = frameLayout;
        this.lvlist = listView;
        this.mu = multiStateView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTimerPBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTimerPBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_timer_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTimerPBinding bind(View view) {
        int i = R.id.lvlist;
        ListView listView = (ListView) view.findViewById(R.id.lvlist);
        if (listView != null) {
            i = R.id.mu;
            MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
            if (multiStateView != null) {
                return new FragmentTimerPBinding((FrameLayout) view, listView, multiStateView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
