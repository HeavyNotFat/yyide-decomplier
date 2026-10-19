package com.yd.android_brand_mvp.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.PhotoAlbumTwoBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoAlbumAdapter extends BaseQuickAdapter<PhotoAlbumTwoBean.DataBean, BaseViewHolder> {
    public PhotoAlbumAdapter(int i, List list) {
        super(i, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, PhotoAlbumTwoBean.DataBean dataBean) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.id_img);
        baseViewHolder.setText(R.id.tv_lab, dataBean.name);
        if (dataBean.albumDTOList != null) {
            baseViewHolder.setText(R.id.tv_count, "共" + dataBean.albumDTOList.size() + "张");
        }
        String str = null;
        if (dataBean.albumDTOList != null && dataBean.albumDTOList.size() > 0) {
            str = dataBean.albumDTOList.get(0).url;
        }
        GlideUtil.loadRadiusImage(getContext(), str, imageView, 20);
    }
}
