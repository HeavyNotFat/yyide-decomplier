package com.yd.android_brand_mvp.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.PhotoAlbumTwoBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ShowPhotoAlbumAdapter extends BaseQuickAdapter<PhotoAlbumTwoBean.DataBean.Bean, BaseViewHolder> {
    public ShowPhotoAlbumAdapter(int i, List list) {
        super(i, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, PhotoAlbumTwoBean.DataBean.Bean bean) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.id_img);
        baseViewHolder.setText(R.id.tv_lab, bean.name);
        GlideUtil.loadRadiusImage(getContext(), bean.url, imageView, 20);
    }
}
