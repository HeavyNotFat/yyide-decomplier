package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class VertifyFragmentBinding implements ViewBinding {
    public final ImageView imageview;
    private final FrameLayout rootView;
    public final LayoutHeadTitleBinding top;

    private VertifyFragmentBinding(FrameLayout frameLayout, ImageView imageView, LayoutHeadTitleBinding layoutHeadTitleBinding) {
        this.rootView = frameLayout;
        this.imageview = imageView;
        this.top = layoutHeadTitleBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VertifyFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VertifyFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.vertify_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static VertifyFragmentBinding bind(View view) {
        int i = R.id.imageview;
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        if (imageView != null) {
            i = R.id.top;
            View viewFindViewById = view.findViewById(R.id.top);
            if (viewFindViewById != null) {
                return new VertifyFragmentBinding((FrameLayout) view, imageView, LayoutHeadTitleBinding.bind(viewFindViewById));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
