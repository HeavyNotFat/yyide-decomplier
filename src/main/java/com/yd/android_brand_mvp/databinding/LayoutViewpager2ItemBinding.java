package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.video1.SampleCoverVideo;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutViewpager2ItemBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final SampleCoverVideo videoItemPlayer;

    private LayoutViewpager2ItemBinding(FrameLayout frameLayout, SampleCoverVideo sampleCoverVideo) {
        this.rootView = frameLayout;
        this.videoItemPlayer = sampleCoverVideo;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutViewpager2ItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutViewpager2ItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_viewpager2_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutViewpager2ItemBinding bind(View view) {
        SampleCoverVideo sampleCoverVideo = (SampleCoverVideo) view.findViewById(R.id.video_item_player);
        if (sampleCoverVideo != null) {
            return new LayoutViewpager2ItemBinding((FrameLayout) view, sampleCoverVideo);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.video_item_player)));
    }
}
