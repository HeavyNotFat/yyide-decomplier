package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemLocationNameBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvItemLocationName;

    private ItemLocationNameBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.tvItemLocationName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemLocationNameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemLocationNameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_location_name, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemLocationNameBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_item_location_name);
        if (textView != null) {
            return new ItemLocationNameBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_item_location_name)));
    }
}
