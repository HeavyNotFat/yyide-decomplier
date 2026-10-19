package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentEvaluationBinding implements ViewBinding {
    public final ConstraintLayout clContent;
    public final View ivBack;
    public final ConstraintLayout lltop;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final Spinner spinner;
    public final TextView title;
    public final TextView tvSelect;

    private FragmentEvaluationBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view, ConstraintLayout constraintLayout3, RecyclerView recyclerView, Spinner spinner, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clContent = constraintLayout2;
        this.ivBack = view;
        this.lltop = constraintLayout3;
        this.recyclerView = recyclerView;
        this.spinner = spinner;
        this.title = textView;
        this.tvSelect = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentEvaluationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentEvaluationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_evaluation, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentEvaluationBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.ivBack;
        View viewFindViewById = view.findViewById(R.id.ivBack);
        if (viewFindViewById != null) {
            i = R.id.lltop;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.lltop);
            if (constraintLayout2 != null) {
                i = R.id.recyclerView;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                if (recyclerView != null) {
                    i = R.id.spinner;
                    Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
                    if (spinner != null) {
                        i = R.id.title;
                        TextView textView = (TextView) view.findViewById(R.id.title);
                        if (textView != null) {
                            i = R.id.tvSelect;
                            TextView textView2 = (TextView) view.findViewById(R.id.tvSelect);
                            if (textView2 != null) {
                                return new FragmentEvaluationBinding(constraintLayout, constraintLayout, viewFindViewById, constraintLayout2, recyclerView, spinner, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
