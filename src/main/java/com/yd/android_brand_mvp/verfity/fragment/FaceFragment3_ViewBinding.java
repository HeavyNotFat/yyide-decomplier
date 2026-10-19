package com.yd.android_brand_mvp.verfity.fragment;

import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.FaceView;

/* JADX INFO: loaded from: classes4.dex */
public class FaceFragment3_ViewBinding implements Unbinder {
    private FaceFragment3 target;

    public FaceFragment3_ViewBinding(FaceFragment3 faceFragment3, View view) {
        this.target = faceFragment3;
        faceFragment3.faceView = (FaceView) Utils.findRequiredViewAsType(view, R.id.faceView, "field 'faceView'", FaceView.class);
        faceFragment3.previewView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.preview_parent, "field 'previewView'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        FaceFragment3 faceFragment3 = this.target;
        if (faceFragment3 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        faceFragment3.faceView = null;
        faceFragment3.previewView = null;
    }
}
