package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityLayoutBottomBinding implements ViewBinding {
    public final LinearLayout layout;
    private final LinearLayout rootView;
    public final ImageView xx;

    private ActivityLayoutBottomBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView) {
        this.rootView = linearLayout;
        this.layout = linearLayout2;
        this.xx = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLayoutBottomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityLayoutBottomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_layout_bottom, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityLayoutBottomBinding bind(View view) {
        int i = R.id.layout;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout);
        if (linearLayout != null) {
            i = R.id.xx;
            ImageView imageView = (ImageView) view.findViewById(R.id.xx);
            if (imageView != null) {
                return new ActivityLayoutBottomBinding((LinearLayout) view, linearLayout, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
