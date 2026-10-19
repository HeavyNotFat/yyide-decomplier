package com.yd.android_brand_mvp.utils.image;

import android.content.Context;
import android.widget.ImageView;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.interfaces.OnSrcViewUpdateListener;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class XpopupUtils {
    public static void showImagePopop(Context context, ImageView imageView, List<Object> list) {
        new XPopup.Builder(context).asImageViewer(imageView, 0, list, false, false, -1, -1, -1, false, new OnSrcViewUpdateListener() { // from class: com.yd.android_brand_mvp.utils.image.XpopupUtils.1
            @Override // com.lxj.xpopup.interfaces.OnSrcViewUpdateListener
            public void onSrcViewUpdate(ImageViewerPopupView imageViewerPopupView, int i) {
            }
        }, new ImageLoader()).show();
    }

    public static BasePopupView showImagePopop(Context context, ImageView imageView, int i, List<Object> list) {
        return new XPopup.Builder(context).asImageViewer(imageView, i, list, false, false, -1, -1, -1, false, new OnSrcViewUpdateListener() { // from class: com.yd.android_brand_mvp.utils.image.XpopupUtils.2
            @Override // com.lxj.xpopup.interfaces.OnSrcViewUpdateListener
            public void onSrcViewUpdate(ImageViewerPopupView imageViewerPopupView, int i2) {
            }
        }, new ImageLoader()).show();
    }
}
