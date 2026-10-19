package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class Wlkz2_2L_ViewBinding implements Unbinder {
    private Wlkz2_2L target;

    public Wlkz2_2L_ViewBinding(Wlkz2_2L wlkz2_2L, View view) {
        this.target = wlkz2_2L;
        wlkz2_2L.door = (CheckedTextView) Utils.findRequiredViewAsType(view, R.id.door, "field 'door'", CheckedTextView.class);
        wlkz2_2L.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        wlkz2_2L.content = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.flContent, "field 'content'", ConstraintLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        Wlkz2_2L wlkz2_2L = this.target;
        if (wlkz2_2L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        wlkz2_2L.door = null;
        wlkz2_2L.title = null;
        wlkz2_2L.content = null;
    }
}
