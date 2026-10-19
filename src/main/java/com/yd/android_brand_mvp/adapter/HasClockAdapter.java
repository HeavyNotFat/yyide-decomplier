package com.yd.android_brand_mvp.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.db.Attendance;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class HasClockAdapter extends BaseQuickAdapter<Attendance, BaseViewHolder> {
    public HasClockAdapter(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, Attendance attendance) {
        baseViewHolder.setText(R.id.tv_name, attendance.peopleName);
        baseViewHolder.setText(R.id.tv_time, TimeUtil.stampToDate7(attendance.createdDateTime));
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_head);
        if (!TextUtils.isEmpty(attendance.iscard) && !ScreenUtils.isLandscape()) {
            imageView.setRotation(90.0f);
        } else {
            imageView.setRotation(0.0f);
        }
        if (!StringUtils.isEmpty(attendance.path) && !"cloud".equals(attendance.path.substring(0, 5))) {
            Glide.with(getContext()).load(new File(attendance.path)).into(imageView);
        } else if (!TextUtils.isEmpty(attendance.iscard) && !ScreenUtils.isLandscape()) {
            GlideUtil.loadCircleImage1(getContext(), attendance.path, imageView);
        } else {
            GlideUtil.loadCircleImage(getContext(), attendance.path, imageView);
        }
    }
}
