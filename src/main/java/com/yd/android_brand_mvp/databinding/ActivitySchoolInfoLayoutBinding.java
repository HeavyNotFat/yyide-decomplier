package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivitySchoolInfoLayoutBinding implements ViewBinding {
    public final ImageView bg;
    public final FrameLayout content;
    private final FrameLayout rootView;

    private ActivitySchoolInfoLayoutBinding(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.bg = imageView;
        this.content = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySchoolInfoLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySchoolInfoLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_school_info_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySchoolInfoLayoutBinding bind(View view) {
        int i = R.id.bg;
        ImageView imageView = (ImageView) view.findViewById(R.id.bg);
        if (imageView != null) {
            i = R.id.content;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
            if (frameLayout != null) {
                return new ActivitySchoolInfoLayoutBinding((FrameLayout) view, imageView, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
