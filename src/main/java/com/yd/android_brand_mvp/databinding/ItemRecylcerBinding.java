package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemRecylcerBinding implements ViewBinding {
    public final ImageView ivItemRecyclerAdd;
    private final ConstraintLayout rootView;
    public final RecyclerView rvItemRecycler;
    public final View viewLine;

    private ItemRecylcerBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, View view) {
        this.rootView = constraintLayout;
        this.ivItemRecyclerAdd = imageView;
        this.rvItemRecycler = recyclerView;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemRecylcerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemRecylcerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_recylcer, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemRecylcerBinding bind(View view) {
        int i = R.id.iv_item_recycler_add;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_recycler_add);
        if (imageView != null) {
            i = R.id.rv_item_recycler;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_item_recycler);
            if (recyclerView != null) {
                i = R.id.view_line;
                View viewFindViewById = view.findViewById(R.id.view_line);
                if (viewFindViewById != null) {
                    return new ItemRecylcerBinding((ConstraintLayout) view, imageView, recyclerView, viewFindViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
