package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentKb22PBinding implements ViewBinding {
    public final FrameLayout contentLayout;
    public final ListView listview;
    public final MultiStateView mu;
    private final LinearLayout rootView;

    private FragmentKb22PBinding(LinearLayout linearLayout, FrameLayout frameLayout, ListView listView, MultiStateView multiStateView) {
        this.rootView = linearLayout;
        this.contentLayout = frameLayout;
        this.listview = listView;
        this.mu = multiStateView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentKb22PBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentKb22PBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_kb_22_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentKb22PBinding bind(View view) {
        int i = R.id.content_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_layout);
        if (frameLayout != null) {
            i = R.id.listview;
            ListView listView = (ListView) view.findViewById(R.id.listview);
            if (listView != null) {
                i = R.id.mu;
                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                if (multiStateView != null) {
                    return new FragmentKb22PBinding((LinearLayout) view, frameLayout, listView, multiStateView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
