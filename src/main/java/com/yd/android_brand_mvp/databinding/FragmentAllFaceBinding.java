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
public final class FragmentAllFaceBinding implements ViewBinding {
    public final FaceView faceView;
    public final LinearLayout previewView;
    private final FrameLayout rootView;

    private FragmentAllFaceBinding(FrameLayout frameLayout, FaceView faceView, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.faceView = faceView;
        this.previewView = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAllFaceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAllFaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_all_face, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAllFaceBinding bind(View view) {
        int i = R.id.faceView;
        FaceView faceView = (FaceView) view.findViewById(R.id.faceView);
        if (faceView != null) {
            i = R.id.previewView;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.previewView);
            if (linearLayout != null) {
                return new FragmentAllFaceBinding((FrameLayout) view, faceView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
