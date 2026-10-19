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
public final class FragmentEvaluationMedalBinding implements ViewBinding {
    public final View line;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final Spinner spinner;
    public final TextView tvTitle;

    private FragmentEvaluationMedalBinding(ConstraintLayout constraintLayout, View view, RecyclerView recyclerView, Spinner spinner, TextView textView) {
        this.rootView = constraintLayout;
        this.line = view;
        this.recyclerView = recyclerView;
        this.spinner = spinner;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentEvaluationMedalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentEvaluationMedalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_evaluation_medal, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentEvaluationMedalBinding bind(View view) {
        int i = R.id.line;
        View viewFindViewById = view.findViewById(R.id.line);
        if (viewFindViewById != null) {
            i = R.id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            if (recyclerView != null) {
                i = R.id.spinner;
                Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
                if (spinner != null) {
                    i = R.id.tvTitle;
                    TextView textView = (TextView) view.findViewById(R.id.tvTitle);
                    if (textView != null) {
                        return new FragmentEvaluationMedalBinding((ConstraintLayout) view, viewFindViewById, recyclerView, spinner, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
