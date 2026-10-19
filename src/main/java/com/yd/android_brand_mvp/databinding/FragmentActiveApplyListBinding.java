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
public final class FragmentActiveApplyListBinding implements ViewBinding {
    public final ConstraintLayout clBottom;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvNextPage;
    public final TextView tvPrevious;

    private FragmentActiveApplyListBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clBottom = constraintLayout2;
        this.recyclerView = recyclerView;
        this.tvNextPage = textView;
        this.tvPrevious = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentActiveApplyListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentActiveApplyListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_active_apply_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentActiveApplyListBinding bind(View view) {
        int i = R.id.cl_bottom;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_bottom);
        if (constraintLayout != null) {
            i = R.id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            if (recyclerView != null) {
                i = R.id.tv_next_page;
                TextView textView = (TextView) view.findViewById(R.id.tv_next_page);
                if (textView != null) {
                    i = R.id.tv_previous;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_previous);
                    if (textView2 != null) {
                        return new FragmentActiveApplyListBinding((ConstraintLayout) view, constraintLayout, recyclerView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
