package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityWelcomePBinding implements ViewBinding {
    private final ImageView rootView;
    public final ImageView welcome;

    private ActivityWelcomePBinding(ImageView imageView, ImageView imageView2) {
        this.rootView = imageView;
        this.welcome = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }

    public static ActivityWelcomePBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWelcomePBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_welcome_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWelcomePBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ImageView imageView = (ImageView) view;
        return new ActivityWelcomePBinding(imageView, imageView);
    }
}
