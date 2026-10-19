package com.yd.android_brand_mvp.weight;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseCenterPopup;
import com.yd.android_brand_mvp.utils.DisplayUtil;
import com.yd.android_brand_mvp.utils.GlideUtil;

/* JADX INFO: loaded from: classes4.dex */
public class ImageShowPopup extends BaseCenterPopup {
    ImageView ivClose;
    ImageView ivProduction;
    String url;

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.layout_image_show_popup;
    }

    public ImageShowPopup(Context context, String str) {
        super(context);
        this.url = str;
    }

    @Override // com.yd.android_brand_mvp.base.BaseCenterPopup, com.lxj.xpopup.core.BasePopupView
    protected void onCreate() {
        super.onCreate();
        this.ivClose = (ImageView) findViewById(R.id.iv_close);
        this.ivProduction = (ImageView) findViewById(R.id.iv_production);
        this.ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.weight.ImageShowPopup.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageShowPopup.this.dismiss();
            }
        });
        this.ivProduction.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.weight.ImageShowPopup.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageShowPopup.this.dismiss();
            }
        });
        GlideUtil.loadNormalImg(this.ivProduction, this.url);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getMaxHeight() {
        if (ScreenUtils.isLandscape()) {
            return DisplayUtil.dip2px(getContext(), 1080.0f);
        }
        return super.getMaxHeight();
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        if (ScreenUtils.isLandscape()) {
            return super.getMaxWidth();
        }
        return DisplayUtil.dip2px(getContext(), 1080.0f);
    }
}
