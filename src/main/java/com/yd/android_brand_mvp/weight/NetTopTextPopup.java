package com.yd.android_brand_mvp.weight;

import android.content.Context;
import android.widget.TextView;
import com.lxj.xpopup.core.PositionPopupView;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class NetTopTextPopup extends PositionPopupView {
    String hint;

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.layout_nettoptext_popup;
    }

    public NetTopTextPopup(Context context, String str) {
        super(context);
        this.hint = str;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void onCreate() {
        super.onCreate();
        ((TextView) findViewById(R.id.tv_text)).setText(this.hint);
    }
}
