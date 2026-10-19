package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityPatrolDetailBinding implements ViewBinding {
    private final NestedScrollView rootView;
    public final RecyclerView rvActivityPatrolDetail;
    public final NestedScrollView svActivityPatrolDetail;
    public final ViewPatrolBaseInfoBinding viewActivityPatrolHead;

    private ActivityPatrolDetailBinding(NestedScrollView nestedScrollView, RecyclerView recyclerView, NestedScrollView nestedScrollView2, ViewPatrolBaseInfoBinding viewPatrolBaseInfoBinding) {
        this.rootView = nestedScrollView;
        this.rvActivityPatrolDetail = recyclerView;
        this.svActivityPatrolDetail = nestedScrollView2;
        this.viewActivityPatrolHead = viewPatrolBaseInfoBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static ActivityPatrolDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityPatrolDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_patrol_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPatrolDetailBinding bind(View view) {
        int i = R.id.rv_activity_patrol_detail;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_activity_patrol_detail);
        if (recyclerView != null) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            View viewFindViewById = view.findViewById(R.id.view_activity_patrol_head);
            if (viewFindViewById != null) {
                return new ActivityPatrolDetailBinding(nestedScrollView, recyclerView, nestedScrollView, ViewPatrolBaseInfoBinding.bind(viewFindViewById));
            }
            i = R.id.view_activity_patrol_head;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
