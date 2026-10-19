package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class AttChildrensItemBinding implements ViewBinding {
    public final RecyclerView gv;
    private final LinearLayout rootView;

    private AttChildrensItemBinding(LinearLayout linearLayout, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.gv = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AttChildrensItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AttChildrensItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.att_childrens_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AttChildrensItemBinding bind(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.gv);
        if (recyclerView != null) {
            return new AttChildrensItemBinding((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.gv)));
    }
}
