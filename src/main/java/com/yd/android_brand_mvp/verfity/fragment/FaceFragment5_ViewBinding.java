package com.yd.android_brand_mvp.verfity.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.FaceView;

/* JADX INFO: loaded from: classes4.dex */
public class FaceFragment5_ViewBinding implements Unbinder {
    private FaceFragment5 target;

    public FaceFragment5_ViewBinding(FaceFragment5 faceFragment5, View view) {
        this.target = faceFragment5;
        faceFragment5.previewView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.preview_parent, "field 'previewView'", LinearLayout.class);
        faceFragment5.pm = (TextView) Utils.findRequiredViewAsType(view, R.id.pm, "field 'pm'", TextView.class);
        faceFragment5.faceView = (FaceView) Utils.findRequiredViewAsType(view, R.id.faceView, "field 'faceView'", FaceView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        FaceFragment5 faceFragment5 = this.target;
        if (faceFragment5 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        faceFragment5.previewView = null;
        faceFragment5.pm = null;
        faceFragment5.faceView = null;
    }
}
