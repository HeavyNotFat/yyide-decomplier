package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yyide.facepass.camera.CameraPreview;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentFaceBinding implements ViewBinding {
    public final CameraPreview camera;
    public final FaceView faceView;
    public final TextView pm;
    private final FrameLayout rootView;

    private FragmentFaceBinding(FrameLayout frameLayout, CameraPreview cameraPreview, FaceView faceView, TextView textView) {
        this.rootView = frameLayout;
        this.camera = cameraPreview;
        this.faceView = faceView;
        this.pm = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFaceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentFaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_face, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentFaceBinding bind(View view) {
        int i = R.id.camera;
        CameraPreview cameraPreview = (CameraPreview) view.findViewById(R.id.camera);
        if (cameraPreview != null) {
            i = R.id.faceView;
            FaceView faceView = (FaceView) view.findViewById(R.id.faceView);
            if (faceView != null) {
                i = R.id.pm;
                TextView textView = (TextView) view.findViewById(R.id.pm);
                if (textView != null) {
                    return new FragmentFaceBinding((FrameLayout) view, cameraPreview, faceView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
