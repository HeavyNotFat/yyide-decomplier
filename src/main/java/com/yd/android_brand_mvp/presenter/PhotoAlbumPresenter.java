package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.PhotoAlbumTabBean;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.PhotoAlbumView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoAlbumPresenter extends BasePresenter<PhotoAlbumView> {
    public PhotoAlbumPresenter(PhotoAlbumView photoAlbumView) {
        attachView(photoAlbumView);
    }

    public void getPhotoAlbumTablist(String str, String str2) {
        HashMap map = new HashMap();
        if ("1".equals(str2)) {
            map.put(CommentsHomeFragment.TYPE_CLASSESID, str);
        }
        map.put("kind", str2);
        addSubscription(this.dingApiStores.getPhotoAlbumTablist(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(map))), new ApiCallback<PhotoAlbumTabBean>() { // from class: com.yd.android_brand_mvp.presenter.PhotoAlbumPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(PhotoAlbumTabBean photoAlbumTabBean) {
                ((PhotoAlbumView) PhotoAlbumPresenter.this.mvpView).getDataSuccess(photoAlbumTabBean);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str3) {
                ((PhotoAlbumView) PhotoAlbumPresenter.this.mvpView).getFail(str3);
            }
        });
    }
}
