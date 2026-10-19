package com.yd.android_brand_mvp.weight;

import android.content.Context;
import android.widget.ImageView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseCenterPopup;
import com.yd.android_brand_mvp.model.GeneralBean;
import com.yd.android_brand_mvp.utils.GlideUtil;

/* JADX INFO: loaded from: classes4.dex */
public class PunchCardPopup extends BaseCenterPopup {
    GeneralBean bean;

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.punch_card_toast;
    }

    public PunchCardPopup(Context context, GeneralBean generalBean) {
        super(context);
        this.bean = generalBean;
    }

    @Override // com.yd.android_brand_mvp.base.BaseCenterPopup, com.lxj.xpopup.core.BasePopupView
    protected void onCreate() {
        super.onCreate();
        GlideUtil.loadCircleHeadImage(getContext(), "", (ImageView) findViewById(R.id.iv_img));
    }
}
