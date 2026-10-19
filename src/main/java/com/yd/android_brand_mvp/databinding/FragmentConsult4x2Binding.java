package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentConsult4x2Binding implements ViewBinding {
    public final Banner banner;
    public final MultiStateView mu;
    private final LinearLayoutCompat rootView;
    public final LayoutHeadTitleBinding top;

    private FragmentConsult4x2Binding(LinearLayoutCompat linearLayoutCompat, Banner banner, MultiStateView multiStateView, LayoutHeadTitleBinding layoutHeadTitleBinding) {
        this.rootView = linearLayoutCompat;
        this.banner = banner;
        this.mu = multiStateView;
        this.top = layoutHeadTitleBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static FragmentConsult4x2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentConsult4x2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_consult4x2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentConsult4x2Binding bind(View view) {
        int i = R.id.banner;
        Banner banner = (Banner) view.findViewById(R.id.banner);
        if (banner != null) {
            i = R.id.mu;
            MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
            if (multiStateView != null) {
                i = R.id.top;
                View viewFindViewById = view.findViewById(R.id.top);
                if (viewFindViewById != null) {
                    return new FragmentConsult4x2Binding((LinearLayoutCompat) view, banner, multiStateView, LayoutHeadTitleBinding.bind(viewFindViewById));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
