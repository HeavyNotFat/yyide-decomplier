package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.StudentTaskBean;

/* JADX INFO: loaded from: classes4.dex */
public interface AssignmentView extends BaseView {
    void getTaskListSuccess(StudentTaskBean studentTaskBean);

    void getTaskListSuccessFail(String str);
}
