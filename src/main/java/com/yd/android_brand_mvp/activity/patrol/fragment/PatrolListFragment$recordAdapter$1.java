package com.yd.android_brand_mvp.activity.patrol.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ItemPatrolListBinding;
import com.yd.android_brand_mvp.model.patrol.PatrolListBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: PatrolListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/yd/android_brand_mvp/activity/patrol/fragment/PatrolListFragment$recordAdapter$1", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemPatrolListBinding;", "Lcom/yd/android_brand_mvp/model/patrol/PatrolListBean;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "convertPlus", "", "holder", "Lcom/yd/android_brand_mvp/base/VBViewHolder;", "item", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PatrolListFragment$recordAdapter$1 extends BaseBindingAdapter<ItemPatrolListBinding, PatrolListBean> implements LoadMoreModule {
    final /* synthetic */ PatrolListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PatrolListFragment$recordAdapter$1(PatrolListFragment patrolListFragment) {
        super(null, 1, null);
        this.this$0 = patrolListFragment;
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, PatrolListBean patrolListBean) {
        convertPlus2((VBViewHolder<ItemPatrolListBinding>) vBViewHolder, patrolListBean);
    }

    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
    public void convertPlus2(VBViewHolder<ItemPatrolListBinding> holder, PatrolListBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemPatrolListBinding itemPatrolListBinding = (ItemPatrolListBinding) holder.getBinding();
        if (itemPatrolListBinding != null) {
            PatrolListFragment patrolListFragment = this.this$0;
            if (patrolListFragment.currentSelectList != 0) {
                if (patrolListFragment.currentSelectList == 1) {
                    ImageView imageView = itemPatrolListBinding.ivItemPatrolListStatus;
                    Intrinsics.checkNotNullExpressionValue(imageView, "it.ivItemPatrolListStatus");
                    SimpleUtilsKt.show(imageView);
                    itemPatrolListBinding.tvItemPatrolListStatus.setText(item.getFinishUserName() + " (" + item.getFinishTime() + ')');
                    itemPatrolListBinding.tvItemPatrolListStatus.setTextColor(SimpleUtilsKt.asColor(R.color.black9));
                    itemPatrolListBinding.btnItemPatrolListDetail.setText("查看详情");
                    itemPatrolListBinding.btnItemPatrolListDetail.setBackground(SimpleUtilsKt.asDrawable(R.drawable.frame_purple_6747d3_r20));
                    itemPatrolListBinding.btnItemPatrolListDetail.setTextColor(SimpleUtilsKt.asColor(R.color.purple2));
                } else {
                    ImageView imageView2 = itemPatrolListBinding.ivItemPatrolListStatus;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "it.ivItemPatrolListStatus");
                    SimpleUtilsKt.remove(imageView2);
                    itemPatrolListBinding.tvItemPatrolListStatus.setText("已逾期");
                    itemPatrolListBinding.tvItemPatrolListStatus.setTextColor(SimpleUtilsKt.asColor(R.color.red_FD4F45));
                    itemPatrolListBinding.btnItemPatrolListDetail.setText("完成任务");
                    itemPatrolListBinding.btnItemPatrolListDetail.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_purple20));
                    itemPatrolListBinding.btnItemPatrolListDetail.setTextColor(SimpleUtilsKt.asColor(R.color.white));
                }
            } else {
                ImageView imageView3 = itemPatrolListBinding.ivItemPatrolListStatus;
                Intrinsics.checkNotNullExpressionValue(imageView3, "it.ivItemPatrolListStatus");
                SimpleUtilsKt.remove(imageView3);
                itemPatrolListBinding.tvItemPatrolListStatus.setText("待巡查");
                itemPatrolListBinding.tvItemPatrolListStatus.setTextColor(SimpleUtilsKt.asColor(R.color.yellow_ffc327));
                itemPatrolListBinding.btnItemPatrolListDetail.setText("完成任务");
                itemPatrolListBinding.btnItemPatrolListDetail.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_purple20));
                itemPatrolListBinding.btnItemPatrolListDetail.setTextColor(SimpleUtilsKt.asColor(R.color.white));
            }
            itemPatrolListBinding.tvItemPatrolListTitle.setText(String.valueOf(item.getProjectName()));
            itemPatrolListBinding.tvItemPatrolListTime.setText("起止时间: " + StringsKt.replace$default(item.getStartTime(), Constants.ACCEPT_TIME_SEPARATOR_SERVER, MqttTopic.TOPIC_LEVEL_SEPARATOR, false, 4, (Object) null) + " - " + StringsKt.replace$default(item.getEndTime(), Constants.ACCEPT_TIME_SEPARATOR_SERVER, MqttTopic.TOPIC_LEVEL_SEPARATOR, false, 4, (Object) null));
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public ItemPatrolListBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemPatrolListBinding itemPatrolListBindingInflate = ItemPatrolListBinding.inflate(inflater, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemPatrolListBindingInflate, "inflate(inflater, parent, false)");
        return itemPatrolListBindingInflate;
    }
}
