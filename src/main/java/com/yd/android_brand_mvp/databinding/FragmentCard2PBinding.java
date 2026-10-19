package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.CameraView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentCard2PBinding implements ViewBinding {
    public final CameraView camera;
    public final FrameLayout flCameraView;
    public final FrameLayout flCard;
    public final TextView pm;
    private final FrameLayout rootView;

    private FragmentCard2PBinding(FrameLayout frameLayout, CameraView cameraView, FrameLayout frameLayout2, FrameLayout frameLayout3, TextView textView) {
        this.rootView = frameLayout;
        this.camera = cameraView;
        this.flCameraView = frameLayout2;
        this.flCard = frameLayout3;
        this.pm = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCard2PBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCard2PBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_card2_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCard2PBinding bind(View view) {
        int i = R.id.camera;
        CameraView cameraView = (CameraView) view.findViewById(R.id.camera);
        if (cameraView != null) {
            i = R.id.fl_cameraView;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_cameraView);
            if (frameLayout != null) {
                i = R.id.fl_card;
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_card);
                if (frameLayout2 != null) {
                    i = R.id.pm;
                    TextView textView = (TextView) view.findViewById(R.id.pm);
                    if (textView != null) {
                        return new FragmentCard2PBinding((FrameLayout) view, cameraView, frameLayout, frameLayout2, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
