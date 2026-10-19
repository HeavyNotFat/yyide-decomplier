package com.yd.android_brand_mvp.verfity.fragment;

import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.FaceView;

/* JADX INFO: loaded from: classes4.dex */
public class FaceFragment2_ViewBinding implements Unbinder {
    private FaceFragment2 target;

    public FaceFragment2_ViewBinding(FaceFragment2 faceFragment2, View view) {
        this.target = faceFragment2;
        faceFragment2.faceView = (FaceView) Utils.findRequiredViewAsType(view, R.id.faceView, "field 'faceView'", FaceView.class);
        faceFragment2.previewView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.preview_parent, "field 'previewView'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        FaceFragment2 faceFragment2 = this.target;
        if (faceFragment2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        faceFragment2.faceView = null;
        faceFragment2.previewView = null;
    }
}
