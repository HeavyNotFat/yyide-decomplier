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
public final class PopupFormLocationBinding implements ViewBinding {
    public final ImageView ivPopupFormLocation;
    private final ConstraintLayout rootView;
    public final RecyclerView rvPopupFormLocation;

    private PopupFormLocationBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.ivPopupFormLocation = imageView;
        this.rvPopupFormLocation = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PopupFormLocationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PopupFormLocationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.popup_form_location, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PopupFormLocationBinding bind(View view) {
        int i = R.id.iv_popup_form_location;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_popup_form_location);
        if (imageView != null) {
            i = R.id.rv_popup_form_location;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_popup_form_location);
            if (recyclerView != null) {
                return new PopupFormLocationBinding((ConstraintLayout) view, imageView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
