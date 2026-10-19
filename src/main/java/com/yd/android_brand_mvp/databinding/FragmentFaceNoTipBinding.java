package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.FaceView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentFaceNoTipBinding implements ViewBinding {
    public final FaceView faceView;
    public final LinearLayout previewParent;
    private final FrameLayout rootView;

    private FragmentFaceNoTipBinding(FrameLayout frameLayout, FaceView faceView, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.faceView = faceView;
        this.previewParent = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFaceNoTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentFaceNoTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_face_no_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentFaceNoTipBinding bind(View view) {
        int i = R.id.faceView;
        FaceView faceView = (FaceView) view.findViewById(R.id.faceView);
        if (faceView != null) {
            i = R.id.preview_parent;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.preview_parent);
            if (linearLayout != null) {
                return new FragmentFaceNoTipBinding((FrameLayout) view, faceView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
