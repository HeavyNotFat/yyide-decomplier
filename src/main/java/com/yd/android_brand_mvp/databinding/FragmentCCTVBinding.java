package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentCCTVBinding implements ViewBinding {
    public final FragmentCCTV8Binding layoutCctv8;
    private final ConstraintLayout rootView;
    public final VideoView videoView1;
    public final VideoView videoView2;
    public final VideoView videoView3;
    public final VideoView videoView4;

    private FragmentCCTVBinding(ConstraintLayout constraintLayout, FragmentCCTV8Binding fragmentCCTV8Binding, VideoView videoView, VideoView videoView2, VideoView videoView3, VideoView videoView4) {
        this.rootView = constraintLayout;
        this.layoutCctv8 = fragmentCCTV8Binding;
        this.videoView1 = videoView;
        this.videoView2 = videoView2;
        this.videoView3 = videoView3;
        this.videoView4 = videoView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCCTVBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCCTVBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_c_c_t_v, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCCTVBinding bind(View view) {
        int i = R.id.layout_cctv_8;
        View viewFindViewById = view.findViewById(R.id.layout_cctv_8);
        if (viewFindViewById != null) {
            FragmentCCTV8Binding fragmentCCTV8BindingBind = FragmentCCTV8Binding.bind(viewFindViewById);
            i = R.id.videoView1;
            VideoView videoView = (VideoView) view.findViewById(R.id.videoView1);
            if (videoView != null) {
                i = R.id.videoView2;
                VideoView videoView2 = (VideoView) view.findViewById(R.id.videoView2);
                if (videoView2 != null) {
                    i = R.id.videoView3;
                    VideoView videoView3 = (VideoView) view.findViewById(R.id.videoView3);
                    if (videoView3 != null) {
                        i = R.id.videoView4;
                        VideoView videoView4 = (VideoView) view.findViewById(R.id.videoView4);
                        if (videoView4 != null) {
                            return new FragmentCCTVBinding((ConstraintLayout) view, fragmentCCTV8BindingBind, videoView, videoView2, videoView3, videoView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
