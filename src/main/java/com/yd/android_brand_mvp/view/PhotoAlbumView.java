package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.PhotoAlbumTabBean;

/* JADX INFO: loaded from: classes4.dex */
public interface PhotoAlbumView extends BaseView {
    void getDataSuccess(PhotoAlbumTabBean photoAlbumTabBean);

    void getFail(String str);
}
