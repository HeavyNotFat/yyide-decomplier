package com.yd.android_brand_mvp.presenter;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.VideoListBean;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.ClassPhotoView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class ClassPhotoPresenter extends BasePresenter<ClassPhotoView> {
    public ClassPhotoPresenter(ClassPhotoView classPhotoView) {
        attachView(classPhotoView);
    }

    public void getClassPhotoList(String str, String str2, String str3, int i) {
        HashMap map = new HashMap();
        if ("1".equals(str2)) {
            if (TextUtils.isEmpty(str)) {
                return;
            } else {
                map.put(CommentsHomeFragment.TYPE_CLASSESID, str);
            }
        }
        if (i > 0) {
            map.put("limitNum", Integer.valueOf(i));
        }
        map.put("kind", str2);
        map.put("type", str3);
        addSubscription(this.dingApiStores.getNewClassPhotoList(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(map))), new ApiCallback<VideoListBean>() { // from class: com.yd.android_brand_mvp.presenter.ClassPhotoPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(VideoListBean videoListBean) {
                ((ClassPhotoView) ClassPhotoPresenter.this.mvpView).getDataSuccess(videoListBean);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str4) {
                ((ClassPhotoView) ClassPhotoPresenter.this.mvpView).getFail(str4);
            }
        });
    }
}
