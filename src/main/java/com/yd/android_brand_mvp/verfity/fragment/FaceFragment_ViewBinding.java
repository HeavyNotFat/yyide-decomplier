package com.yd.android_brand_mvp.verfity.fragment;

import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.FaceView;

/* JADX INFO: loaded from: classes4.dex */
public class FaceFragment_ViewBinding implements Unbinder {
    private FaceFragment target;

    public FaceFragment_ViewBinding(FaceFragment faceFragment, View view) {
        this.target = faceFragment;
        faceFragment.faceView = (FaceView) Utils.findRequiredViewAsType(view, R.id.faceView, "field 'faceView'", FaceView.class);
        faceFragment.previewView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.preview_parent, "field 'previewView'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        FaceFragment faceFragment = this.target;
        if (faceFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        faceFragment.faceView = null;
        faceFragment.previewView = null;
    }
}
