package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.StudentTaskBean;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.AssignmentView;
import java.util.Date;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class AssignmentPresenter extends BasePresenter<AssignmentView> {
    public AssignmentPresenter(AssignmentView assignmentView) {
        attachView(assignmentView);
    }

    public void getTaskList(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put(CommentsHomeFragment.TYPE_CLASSESID, str);
        map.put("week", str3);
        new Date(System.currentTimeMillis());
        map.put("pageNo", "1");
        map.put("pageSize", "50");
        addSubscription(this.dingApiStores.getNewTaskList(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<StudentTaskBean>() { // from class: com.yd.android_brand_mvp.presenter.AssignmentPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(StudentTaskBean studentTaskBean) {
                ((AssignmentView) AssignmentPresenter.this.mvpView).getTaskListSuccess(studentTaskBean);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str4) {
                ((AssignmentView) AssignmentPresenter.this.mvpView).getTaskListSuccessFail(str4);
            }
        });
    }
}
