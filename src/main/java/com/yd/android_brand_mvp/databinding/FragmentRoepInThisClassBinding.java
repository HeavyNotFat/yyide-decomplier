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
public final class FragmentRoepInThisClassBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final RecyclerView rvThisClassRanking;
    public final TextView tvClassMoralEducationComparison;
    public final TextView tvFlowRedFlagCollectionNumber;

    private FragmentRoepInThisClassBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.rvThisClassRanking = recyclerView;
        this.tvClassMoralEducationComparison = textView;
        this.tvFlowRedFlagCollectionNumber = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentRoepInThisClassBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentRoepInThisClassBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_roep_in_this_class, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentRoepInThisClassBinding bind(View view) {
        int i = R.id.rv_this_class_ranking;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_this_class_ranking);
        if (recyclerView != null) {
            i = R.id.tv_class_moral_education_comparison;
            TextView textView = (TextView) view.findViewById(R.id.tv_class_moral_education_comparison);
            if (textView != null) {
                i = R.id.tv_flow_red_flag_collection_number;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_flow_red_flag_collection_number);
                if (textView2 != null) {
                    return new FragmentRoepInThisClassBinding((ConstraintLayout) view, recyclerView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
