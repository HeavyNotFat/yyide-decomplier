package com.yd.android_brand_mvp.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.StudentTaskBean;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AssignmentAdapter extends BaseQuickAdapter<StudentTaskBean.DataBean.WorkBean, BaseViewHolder> {
    public AssignmentAdapter(int i, List list) {
        super(i, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, StudentTaskBean.DataBean.WorkBean workBean) {
        baseViewHolder.setText(R.id.tv_subject, workBean.subjectName + "作业");
        baseViewHolder.setText(R.id.tv_time, workBean.releaseTime);
        baseViewHolder.setText(R.id.tv_content, workBean.content);
        baseViewHolder.setText(R.id.tv_create_people, "发布人:" + workBean.publisherName);
    }
}
