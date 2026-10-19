package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogLayoutListBinding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;

    private DialogLayoutListBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.recyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogLayoutListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogLayoutListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_layout_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogLayoutListBinding bind(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        if (recyclerView != null) {
            return new DialogLayoutListBinding((ConstraintLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.recyclerView)));
    }
}
