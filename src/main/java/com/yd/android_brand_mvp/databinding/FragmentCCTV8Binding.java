package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentCCTV8Binding implements ViewBinding {
    public final ConstraintLayout content;
    private final ConstraintLayout rootView;
    public final VideoView videoView10;
    public final VideoView videoView11;
    public final VideoView videoView12;
    public final VideoView videoView5;
    public final VideoView videoView6;
    public final VideoView videoView7;
    public final VideoView videoView8;
    public final VideoView videoView9;

    private FragmentCCTV8Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, VideoView videoView, VideoView videoView2, VideoView videoView3, VideoView videoView4, VideoView videoView5, VideoView videoView6, VideoView videoView7, VideoView videoView8) {
        this.rootView = constraintLayout;
        this.content = constraintLayout2;
        this.videoView10 = videoView;
        this.videoView11 = videoView2;
        this.videoView12 = videoView3;
        this.videoView5 = videoView4;
        this.videoView6 = videoView5;
        this.videoView7 = videoView6;
        this.videoView8 = videoView7;
        this.videoView9 = videoView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCCTV8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCCTV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_c_c_t_v_8, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCCTV8Binding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.videoView10;
        VideoView videoView = (VideoView) view.findViewById(R.id.videoView10);
        if (videoView != null) {
            i = R.id.videoView11;
            VideoView videoView2 = (VideoView) view.findViewById(R.id.videoView11);
            if (videoView2 != null) {
                i = R.id.videoView12;
                VideoView videoView3 = (VideoView) view.findViewById(R.id.videoView12);
                if (videoView3 != null) {
                    i = R.id.videoView5;
                    VideoView videoView4 = (VideoView) view.findViewById(R.id.videoView5);
                    if (videoView4 != null) {
                        i = R.id.videoView6;
                        VideoView videoView5 = (VideoView) view.findViewById(R.id.videoView6);
                        if (videoView5 != null) {
                            i = R.id.videoView7;
                            VideoView videoView6 = (VideoView) view.findViewById(R.id.videoView7);
                            if (videoView6 != null) {
                                i = R.id.videoView8;
                                VideoView videoView7 = (VideoView) view.findViewById(R.id.videoView8);
                                if (videoView7 != null) {
                                    i = R.id.videoView9;
                                    VideoView videoView8 = (VideoView) view.findViewById(R.id.videoView9);
                                    if (videoView8 != null) {
                                        return new FragmentCCTV8Binding(constraintLayout, constraintLayout, videoView, videoView2, videoView3, videoView4, videoView5, videoView6, videoView7, videoView8);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
