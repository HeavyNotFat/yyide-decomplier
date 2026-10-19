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
public final class FragmentAiFragment8x6Binding implements ViewBinding {
    public final ConstraintLayout constraintLayout;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView textView;
    public final TextView textView33;
    public final TextView tvSearch;

    private FragmentAiFragment8x6Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.constraintLayout = constraintLayout2;
        this.recyclerView = recyclerView;
        this.textView = textView;
        this.textView33 = textView2;
        this.tvSearch = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAiFragment8x6Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAiFragment8x6Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ai_fragment8x6, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAiFragment8x6Binding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.recyclerView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        if (recyclerView != null) {
            i = R.id.textView;
            TextView textView = (TextView) view.findViewById(R.id.textView);
            if (textView != null) {
                i = R.id.textView33;
                TextView textView2 = (TextView) view.findViewById(R.id.textView33);
                if (textView2 != null) {
                    i = R.id.tv_search;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_search);
                    if (textView3 != null) {
                        return new FragmentAiFragment8x6Binding(constraintLayout, constraintLayout, recyclerView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
