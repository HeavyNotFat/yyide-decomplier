package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.video1.SampleCoverVideo;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityAllvideoBinding implements ViewBinding {
    public final ImageView bg;
    public final TextView close;
    public final LinearLayout llRemark;
    public final SampleCoverVideo player;
    private final FrameLayout rootView;

    private ActivityAllvideoBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, LinearLayout linearLayout, SampleCoverVideo sampleCoverVideo) {
        this.rootView = frameLayout;
        this.bg = imageView;
        this.close = textView;
        this.llRemark = linearLayout;
        this.player = sampleCoverVideo;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAllvideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAllvideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_allvideo, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAllvideoBinding bind(View view) {
        int i = R.id.bg;
        ImageView imageView = (ImageView) view.findViewById(R.id.bg);
        if (imageView != null) {
            i = R.id.close;
            TextView textView = (TextView) view.findViewById(R.id.close);
            if (textView != null) {
                i = R.id.ll_remark;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_remark);
                if (linearLayout != null) {
                    i = R.id.player;
                    SampleCoverVideo sampleCoverVideo = (SampleCoverVideo) view.findViewById(R.id.player);
                    if (sampleCoverVideo != null) {
                        return new ActivityAllvideoBinding((FrameLayout) view, imageView, textView, linearLayout, sampleCoverVideo);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
