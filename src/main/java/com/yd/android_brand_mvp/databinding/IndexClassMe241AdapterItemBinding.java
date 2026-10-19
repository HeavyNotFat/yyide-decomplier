package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class IndexClassMe241AdapterItemBinding implements ViewBinding {
    public final ImageView ivMedalOfHonor;
    private final LinearLayout rootView;

    private IndexClassMe241AdapterItemBinding(LinearLayout linearLayout, ImageView imageView) {
        this.rootView = linearLayout;
        this.ivMedalOfHonor = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IndexClassMe241AdapterItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static IndexClassMe241AdapterItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.index_class_me_241_adapter_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IndexClassMe241AdapterItemBinding bind(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_medal_of_honor);
        if (imageView != null) {
            return new IndexClassMe241AdapterItemBinding((LinearLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.iv_medal_of_honor)));
    }
}
