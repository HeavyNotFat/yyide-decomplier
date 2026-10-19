package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHonerWallBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentHonerWall;
    public final TextView tvFragmentHonerWallNext;
    public final TextView tvFragmentHonerWallPre;

    private FragmentHonerWallBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.rvFragmentHonerWall = recyclerView;
        this.tvFragmentHonerWallNext = textView;
        this.tvFragmentHonerWallPre = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHonerWallBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHonerWallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_honer_wall, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHonerWallBinding bind(View view) {
        int i = R.id.rv_fragment_honer_wall;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_honer_wall);
        if (recyclerView != null) {
            i = R.id.tv_fragment_honer_wall_next;
            TextView textView = (TextView) view.findViewById(R.id.tv_fragment_honer_wall_next);
            if (textView != null) {
                i = R.id.tv_fragment_honer_wall_pre;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_honer_wall_pre);
                if (textView2 != null) {
                    return new FragmentHonerWallBinding((ConstraintLayout) view, recyclerView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
