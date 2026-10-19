package com.yd.android_brand_mvp.adapter.custom;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.custom.CustomListBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomListAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/custom/CustomListAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/yd/android_brand_mvp/model/custom/CustomListBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomListAdapter extends BaseMultiItemQuickAdapter<CustomListBean, BaseViewHolder> {
    public CustomListAdapter() {
        super(null, 1, null);
        addItemType(0, R.layout.item_custom_recycler_one);
        addItemType(1, R.layout.item_custom_recycler_two);
        addItemType(2, R.layout.item_custom_recycler_one_iv);
        addItemType(3, R.layout.item_custom_recycler_two_iv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, CustomListBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ((TextView) holder.getView(R.id.tv_item_custom_recycler)).setText(item.getContent());
    }
}
