package com.yd.android_brand_mvp.verfity.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yyide.facepass.camera.CameraPreview;

/* JADX INFO: loaded from: classes4.dex */
public class FaceFragmentBook_ViewBinding implements Unbinder {
    private FaceFragmentBook target;

    public FaceFragmentBook_ViewBinding(FaceFragmentBook faceFragmentBook, View view) {
        this.target = faceFragmentBook;
        faceFragmentBook.camera = (CameraPreview) Utils.findRequiredViewAsType(view, R.id.camera, "field 'camera'", CameraPreview.class);
        faceFragmentBook.faceView = (FaceView) Utils.findRequiredViewAsType(view, R.id.faceView, "field 'faceView'", FaceView.class);
        faceFragmentBook.pm = (TextView) Utils.findRequiredViewAsType(view, R.id.pm, "field 'pm'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        FaceFragmentBook faceFragmentBook = this.target;
        if (faceFragmentBook == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        faceFragmentBook.camera = null;
        faceFragmentBook.faceView = null;
        faceFragmentBook.pm = null;
    }
}
