package com.yd.android_brand_mvp.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.StudentMsgBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PStudenCenterAdapter extends BaseQuickAdapter<StudentMsgBean.Data0, BaseViewHolder> {
    public PStudenCenterAdapter(int i, List list) {
        super(i, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, StudentMsgBean.Data0 data0) {
        String str;
        TextView textView = (TextView) baseViewHolder.getView(R.id.msg);
        baseViewHolder.setText(R.id.name, data0.name);
        if (data0.msgNum > 99) {
            str = "99+";
        } else {
            str = data0.msgNum + "";
        }
        baseViewHolder.setText(R.id.msg, str);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img);
        textView.setVisibility(data0.msgNum > 0 ? 0 : 8);
        GlideUtil.loadCircleImage(getContext(), data0.image, imageView);
    }
}
