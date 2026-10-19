package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentYwbook46LoanLBinding implements ViewBinding {
    public final RelativeLayout bg;
    public final RecyclerView recyclerView;
    private final FrameLayout rootView;

    private FragmentYwbook46LoanLBinding(FrameLayout frameLayout, RelativeLayout relativeLayout, RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.bg = relativeLayout;
        this.recyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentYwbook46LoanLBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentYwbook46LoanLBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ywbook4_6_loan_l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentYwbook46LoanLBinding bind(View view) {
        int i = R.id.bg;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bg);
        if (relativeLayout != null) {
            i = R.id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            if (recyclerView != null) {
                return new FragmentYwbook46LoanLBinding((FrameLayout) view, relativeLayout, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
