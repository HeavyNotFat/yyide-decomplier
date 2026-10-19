package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityWelcomeBinding implements ViewBinding {
    private final ImageView rootView;
    public final ImageView welcome;

    private ActivityWelcomeBinding(ImageView imageView, ImageView imageView2) {
        this.rootView = imageView;
        this.welcome = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }

    public static ActivityWelcomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWelcomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_welcome, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWelcomeBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ImageView imageView = (ImageView) view;
        return new ActivityWelcomeBinding(imageView, imageView);
    }
}
