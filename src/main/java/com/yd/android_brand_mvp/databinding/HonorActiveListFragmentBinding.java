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
public final class HonorActiveListFragmentBinding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvNext;
    public final TextView tvPageNumber;
    public final TextView tvUpPage;

    private HonorActiveListFragmentBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.recyclerView = recyclerView;
        this.tvNext = textView;
        this.tvPageNumber = textView2;
        this.tvUpPage = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HonorActiveListFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HonorActiveListFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.honor_active_list_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HonorActiveListFragmentBinding bind(View view) {
        int i = R.id.recyclerView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        if (recyclerView != null) {
            i = R.id.tvNext;
            TextView textView = (TextView) view.findViewById(R.id.tvNext);
            if (textView != null) {
                i = R.id.tvPageNumber;
                TextView textView2 = (TextView) view.findViewById(R.id.tvPageNumber);
                if (textView2 != null) {
                    i = R.id.tvUpPage;
                    TextView textView3 = (TextView) view.findViewById(R.id.tvUpPage);
                    if (textView3 != null) {
                        return new HonorActiveListFragmentBinding((ConstraintLayout) view, recyclerView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
