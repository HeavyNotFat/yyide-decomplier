package com.yd.android_brand_mvp.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.StudentWorkListBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ProductionCommentAdapter extends BaseQuickAdapter<StudentWorkListBean.DataBean.RecordsBean.WorkCommentVosBean, BaseViewHolder> {
    public ProductionCommentAdapter(int i, List list) {
        super(i, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, StudentWorkListBean.DataBean.RecordsBean.WorkCommentVosBean workCommentVosBean) {
        GlideUtil.loadCircleHeadImage(getContext(), workCommentVosBean.userImg, (ImageView) baseViewHolder.getView(R.id.iv_head_portrait));
        baseViewHolder.setText(R.id.tv_name, workCommentVosBean.name);
        baseViewHolder.setText(R.id.tv_comment, workCommentVosBean.comment);
        baseViewHolder.setText(R.id.tv_time, workCommentVosBean.createTime);
    }
}
