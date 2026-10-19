package com.yd.android_brand_mvp.adapter.attence;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.CameraView;

/* JADX INFO: loaded from: classes4.dex */
public class CardFragment2_ViewBinding implements Unbinder {
    private CardFragment2 target;

    public CardFragment2_ViewBinding(CardFragment2 cardFragment2, View view) {
        this.target = cardFragment2;
        cardFragment2.camera = (CameraView) Utils.findRequiredViewAsType(view, R.id.camera, "field 'camera'", CameraView.class);
        cardFragment2.pm = (TextView) Utils.findRequiredViewAsType(view, R.id.pm, "field 'pm'", TextView.class);
        cardFragment2.fl_cameraView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_cameraView, "field 'fl_cameraView'", FrameLayout.class);
        cardFragment2.fl_card = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_card, "field 'fl_card'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CardFragment2 cardFragment2 = this.target;
        if (cardFragment2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        cardFragment2.camera = null;
        cardFragment2.pm = null;
        cardFragment2.fl_cameraView = null;
        cardFragment2.fl_card = null;
    }
}
