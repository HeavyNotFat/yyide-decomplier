package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityBaseLayoutBinding implements ViewBinding {
    public final ImageView bg;
    public final FrameLayout content;
    public final FrameLayout flTitle;
    private final FrameLayout rootView;
    public final TextView tvClose;

    private ActivityBaseLayoutBinding(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, FrameLayout frameLayout3, TextView textView) {
        this.rootView = frameLayout;
        this.bg = imageView;
        this.content = frameLayout2;
        this.flTitle = frameLayout3;
        this.tvClose = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBaseLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBaseLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_base_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBaseLayoutBinding bind(View view) {
        int i = R.id.bg;
        ImageView imageView = (ImageView) view.findViewById(R.id.bg);
        if (imageView != null) {
            i = R.id.content;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
            if (frameLayout != null) {
                i = R.id.fl_title;
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_title);
                if (frameLayout2 != null) {
                    i = R.id.tv_close;
                    TextView textView = (TextView) view.findViewById(R.id.tv_close);
                    if (textView != null) {
                        return new ActivityBaseLayoutBinding((FrameLayout) view, imageView, frameLayout, frameLayout2, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
