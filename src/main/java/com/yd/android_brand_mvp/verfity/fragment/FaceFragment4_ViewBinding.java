package com.yd.android_brand_mvp.verfity.fragment;

import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.FaceView;

/* JADX INFO: loaded from: classes4.dex */
public class FaceFragment4_ViewBinding implements Unbinder {
    private FaceFragment4 target;

    public FaceFragment4_ViewBinding(FaceFragment4 faceFragment4, View view) {
        this.target = faceFragment4;
        faceFragment4.faceView = (FaceView) Utils.findRequiredViewAsType(view, R.id.faceView, "field 'faceView'", FaceView.class);
        faceFragment4.previewView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.preview_parent, "field 'previewView'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        FaceFragment4 faceFragment4 = this.target;
        if (faceFragment4 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        faceFragment4.faceView = null;
        faceFragment4.previewView = null;
    }
}
