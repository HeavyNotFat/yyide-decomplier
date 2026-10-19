package com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CycleCurrentMEModel;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.zhpan.bannerview.BaseBannerAdapter;
import com.zhpan.bannerview.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TopThreeRankingIconAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J0\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/TopThreeRankingIconAdapter;", "Lcom/zhpan/bannerview/BaseBannerAdapter;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CycleCurrentMEModel;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bindData", "", "holder", "Lcom/zhpan/bannerview/BaseViewHolder;", "data", "position", "", "pageSize", "getLayoutId", "viewType", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TopThreeRankingIconAdapter extends BaseBannerAdapter<CycleCurrentMEModel> {
    private final Context mContext;

    @Override // com.zhpan.bannerview.BaseBannerAdapter
    public int getLayoutId(int viewType) {
        return R.layout.top_three_ranking_icon_adapter_item;
    }

    public TopThreeRankingIconAdapter(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhpan.bannerview.BaseBannerAdapter
    public void bindData(BaseViewHolder<CycleCurrentMEModel> holder, CycleCurrentMEModel data, int position, int pageSize) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        GlideUtil.loadCircleHeadImage(this.mContext, data != null ? data.getMAvatar() : null, (ImageView) holder.findViewById(R.id.iv_class_icon));
    }
}
