package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yyide.facepass.camera.CameraPreview;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentFace2PBinding implements ViewBinding {
    public final CameraPreview camera;
    public final FaceView faceView;
    public final TextView pm;
    public final LinearLayout previewParent;
    private final FrameLayout rootView;

    private FragmentFace2PBinding(FrameLayout frameLayout, CameraPreview cameraPreview, FaceView faceView, TextView textView, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.camera = cameraPreview;
        this.faceView = faceView;
        this.pm = textView;
        this.previewParent = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFace2PBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentFace2PBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_face2_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentFace2PBinding bind(View view) {
        int i = R.id.camera;
        CameraPreview cameraPreview = (CameraPreview) view.findViewById(R.id.camera);
        if (cameraPreview != null) {
            i = R.id.faceView;
            FaceView faceView = (FaceView) view.findViewById(R.id.faceView);
            if (faceView != null) {
                i = R.id.pm;
                TextView textView = (TextView) view.findViewById(R.id.pm);
                if (textView != null) {
                    i = R.id.preview_parent;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.preview_parent);
                    if (linearLayout != null) {
                        return new FragmentFace2PBinding((FrameLayout) view, cameraPreview, faceView, textView, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
