package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yyide.facepass.camera.CameraPreview;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentVerifyFaceBinding implements ViewBinding {
    public final CameraPreview cameraFragmentVerifyFace;
    public final FaceView faceViewFragmentVerifyFace;
    private final ConstraintLayout rootView;

    private FragmentVerifyFaceBinding(ConstraintLayout constraintLayout, CameraPreview cameraPreview, FaceView faceView) {
        this.rootView = constraintLayout;
        this.cameraFragmentVerifyFace = cameraPreview;
        this.faceViewFragmentVerifyFace = faceView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentVerifyFaceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentVerifyFaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_verify_face, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentVerifyFaceBinding bind(View view) {
        int i = R.id.camera_fragment_verify_face;
        CameraPreview cameraPreview = (CameraPreview) view.findViewById(R.id.camera_fragment_verify_face);
        if (cameraPreview != null) {
            i = R.id.faceView_fragment_verify_face;
            FaceView faceView = (FaceView) view.findViewById(R.id.faceView_fragment_verify_face);
            if (faceView != null) {
                return new FragmentVerifyFaceBinding((ConstraintLayout) view, cameraPreview, faceView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
