package com.yd.android_brand_mvp.verfity.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yyide.facepass.camera.CameraPreview;

/* JADX INFO: loaded from: classes4.dex */
public class FaceFragmentNomal_ViewBinding implements Unbinder {
    private FaceFragmentNomal target;

    public FaceFragmentNomal_ViewBinding(FaceFragmentNomal faceFragmentNomal, View view) {
        this.target = faceFragmentNomal;
        faceFragmentNomal.camera = (CameraPreview) Utils.findRequiredViewAsType(view, R.id.camera, "field 'camera'", CameraPreview.class);
        faceFragmentNomal.faceView = (FaceView) Utils.findRequiredViewAsType(view, R.id.faceView, "field 'faceView'", FaceView.class);
        faceFragmentNomal.pm = (TextView) Utils.findRequiredViewAsType(view, R.id.pm, "field 'pm'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        FaceFragmentNomal faceFragmentNomal = this.target;
        if (faceFragmentNomal == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        faceFragmentNomal.camera = null;
        faceFragmentNomal.faceView = null;
        faceFragmentNomal.pm = null;
    }
}
