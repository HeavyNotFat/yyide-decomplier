package com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter;

import android.content.Context;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CycleCurrentMEModel;
import com.zhpan.bannerview.BaseBannerAdapter;
import com.zhpan.bannerview.BaseViewHolder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: TopThreeRankingScoreAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J0\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0014J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/TopThreeRankingScoreAdapter;", "Lcom/zhpan/bannerview/BaseBannerAdapter;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CycleCurrentMEModel;", "mContext", "Landroid/content/Context;", "mRanking", "", "(Landroid/content/Context;I)V", "bindData", "", "holder", "Lcom/zhpan/bannerview/BaseViewHolder;", "data", "position", "pageSize", "getLayoutId", "viewType", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TopThreeRankingScoreAdapter extends BaseBannerAdapter<CycleCurrentMEModel> {
    private final Context mContext;
    private final int mRanking;

    @Override // com.zhpan.bannerview.BaseBannerAdapter
    public int getLayoutId(int viewType) {
        return R.layout.top_three_ranking_score_adapter_item;
    }

    public TopThreeRankingScoreAdapter(Context mContext, int i) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mRanking = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhpan.bannerview.BaseBannerAdapter
    public void bindData(BaseViewHolder<CycleCurrentMEModel> holder, CycleCurrentMEModel data, int position, int pageSize) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        TextView textView = (TextView) holder.findViewById(R.id.tv_ranking_class_name);
        TextView textView2 = (TextView) holder.findViewById(R.id.tv_ranking_score);
        textView.setText(data != null ? data.getMName() : null);
        if (this.mRanking == 1) {
            textView2.setTextSize(32.0f);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.mContext.getResources().getString(R.string.score3);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.resources.getString(R.string.score3)");
        Object[] objArr = new Object[1];
        objArr[0] = data != null ? data.getMScore() : null;
        String str = String.format(string, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView2.setText(str);
    }
}
