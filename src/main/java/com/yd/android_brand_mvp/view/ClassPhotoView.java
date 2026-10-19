package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.VideoListBean;

/* JADX INFO: loaded from: classes4.dex */
public interface ClassPhotoView extends BaseView {
    void getDataSuccess(VideoListBean videoListBean);

    void getFail(String str);
}
