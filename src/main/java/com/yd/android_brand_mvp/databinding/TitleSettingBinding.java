package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class TitleSettingBinding implements ViewBinding {
    public final ImageView image;
    private final ConstraintLayout rootView;

    private TitleSettingBinding(ConstraintLayout constraintLayout, ImageView imageView) {
        this.rootView = constraintLayout;
        this.image = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TitleSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TitleSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.title_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TitleSettingBinding bind(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        if (imageView != null) {
            return new TitleSettingBinding((ConstraintLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.image)));
    }
}
