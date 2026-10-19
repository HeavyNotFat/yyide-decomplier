package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class HonorSingleFragmentBinding implements ViewBinding {
    public final Group group;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvNumber;
    public final TextView tvTitle;
    public final View view;

    private HonorSingleFragmentBinding(ConstraintLayout constraintLayout, Group group, RecyclerView recyclerView, TextView textView, TextView textView2, View view) {
        this.rootView = constraintLayout;
        this.group = group;
        this.recyclerView = recyclerView;
        this.tvNumber = textView;
        this.tvTitle = textView2;
        this.view = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HonorSingleFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HonorSingleFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.honor_single_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HonorSingleFragmentBinding bind(View view) {
        int i = R.id.group;
        Group group = (Group) view.findViewById(R.id.group);
        if (group != null) {
            i = R.id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            if (recyclerView != null) {
                i = R.id.tvNumber;
                TextView textView = (TextView) view.findViewById(R.id.tvNumber);
                if (textView != null) {
                    i = R.id.tvTitle;
                    TextView textView2 = (TextView) view.findViewById(R.id.tvTitle);
                    if (textView2 != null) {
                        i = R.id.view;
                        View viewFindViewById = view.findViewById(R.id.view);
                        if (viewFindViewById != null) {
                            return new HonorSingleFragmentBinding((ConstraintLayout) view, group, recyclerView, textView, textView2, viewFindViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
