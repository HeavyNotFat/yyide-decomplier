package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class BannerItemConsult4x2Binding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final LinearLayoutCompat rootView;

    private BannerItemConsult4x2Binding(LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView) {
        this.rootView = linearLayoutCompat;
        this.recyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static BannerItemConsult4x2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BannerItemConsult4x2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.banner_item_consult_4x2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BannerItemConsult4x2Binding bind(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        if (recyclerView != null) {
            return new BannerItemConsult4x2Binding((LinearLayoutCompat) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.recyclerView)));
    }
}
