package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentYwbook22LoanLBinding implements ViewBinding {
    public final LinearLayout bg;
    public final LayoutHeadTitleBinding inTop;
    public final RecyclerView recyclerView;
    private final RelativeLayout rootView;

    private FragmentYwbook22LoanLBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, LayoutHeadTitleBinding layoutHeadTitleBinding, RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.bg = linearLayout;
        this.inTop = layoutHeadTitleBinding;
        this.recyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentYwbook22LoanLBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentYwbook22LoanLBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ywbook2_2_loan_l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentYwbook22LoanLBinding bind(View view) {
        int i = R.id.bg;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.bg);
        if (linearLayout != null) {
            i = R.id.in_top;
            View viewFindViewById = view.findViewById(R.id.in_top);
            if (viewFindViewById != null) {
                LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                if (recyclerView != null) {
                    return new FragmentYwbook22LoanLBinding((RelativeLayout) view, linearLayout, layoutHeadTitleBindingBind, recyclerView);
                }
                i = R.id.recyclerView;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
