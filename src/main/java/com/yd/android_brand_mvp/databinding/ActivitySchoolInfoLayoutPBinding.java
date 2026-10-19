package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivitySchoolInfoLayoutPBinding implements ViewBinding {
    public final ImageView bg;
    public final FrameLayout content;
    public final RelativeLayout rlClose;
    private final FrameLayout rootView;

    private ActivitySchoolInfoLayoutPBinding(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, RelativeLayout relativeLayout) {
        this.rootView = frameLayout;
        this.bg = imageView;
        this.content = frameLayout2;
        this.rlClose = relativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySchoolInfoLayoutPBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySchoolInfoLayoutPBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_school_info_layout_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySchoolInfoLayoutPBinding bind(View view) {
        int i = R.id.bg;
        ImageView imageView = (ImageView) view.findViewById(R.id.bg);
        if (imageView != null) {
            i = R.id.content;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
            if (frameLayout != null) {
                i = R.id.rl_close;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_close);
                if (relativeLayout != null) {
                    return new ActivitySchoolInfoLayoutPBinding((FrameLayout) view, imageView, frameLayout, relativeLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
