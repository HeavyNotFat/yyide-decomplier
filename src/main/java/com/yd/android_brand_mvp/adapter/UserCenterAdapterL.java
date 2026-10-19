package com.yd.android_brand_mvp.adapter;

import android.util.Log;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemUserCenterBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserCenterAdapterL.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/UserCenterAdapterL;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "mItemClick", "Lcom/yd/android_brand_mvp/adapter/UserCenterAdapterL$ItemClick;", "selectPosition", "convert", "", "holder", "item", "setItemClick", "ItemClick", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserCenterAdapterL extends BaseQuickAdapter<String, BaseViewHolder> {
    private ItemClick mItemClick;
    private String selectPosition;

    /* JADX INFO: compiled from: UserCenterAdapterL.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/UserCenterAdapterL$ItemClick;", "", "onItemClick", "", "position", "", "item", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ItemClick {
        void onItemClick(int position, String item);
    }

    public UserCenterAdapterL() {
        super(R.layout.item_user_center, null, 2, null);
        this.selectPosition = "课表";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(final BaseViewHolder holder, final String item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        final ItemUserCenterBinding itemUserCenterBindingBind = ItemUserCenterBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemUserCenterBindingBind, "bind(holder.itemView)");
        itemUserCenterBindingBind.check.setText(item);
        switch (item.hashCode()) {
            case -1650280233:
                if (item.equals("我的积分卡")) {
                    itemUserCenterBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab_point_card);
                }
                break;
            case 803305:
                if (item.equals("报修")) {
                    itemUserCenterBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab_repair);
                }
                break;
            case 893927:
                if (item.equals("消息")) {
                    itemUserCenterBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab3);
                }
                break;
            case 966599:
                if (item.equals("留言")) {
                    itemUserCenterBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab1);
                }
                break;
            case 1051698:
                if (item.equals("考试")) {
                    itemUserCenterBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab_exam);
                }
                break;
            case 1131312:
                if (item.equals("请假")) {
                    itemUserCenterBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab2);
                }
                break;
            case 1145898:
                if (item.equals("课表")) {
                    itemUserCenterBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab1);
                }
                break;
            case 616564054:
                if (item.equals("个人荣誉")) {
                    itemUserCenterBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab4);
                }
                break;
            case 771029748:
                if (item.equals("打卡任务")) {
                    itemUserCenterBindingBind.checkImg.setBackgroundResource(R.drawable.user_sign_task_tab4);
                }
                break;
            case 777748296:
                if (item.equals("我的勋章")) {
                    itemUserCenterBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab_medal);
                }
                break;
            case 777864155:
                if (item.equals("我的报名")) {
                    itemUserCenterBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab12);
                }
                break;
            case 778048458:
                if (item.equals("我的积分")) {
                    itemUserCenterBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab_point);
                }
                break;
        }
        itemUserCenterBindingBind.check.setChecked(Intrinsics.areEqual(this.selectPosition, item));
        itemUserCenterBindingBind.checkImg.setChecked(Intrinsics.areEqual(this.selectPosition, item));
        itemUserCenterBindingBind.line.setVisibility(Intrinsics.areEqual(this.selectPosition, item) ? 0 : 4);
        itemUserCenterBindingBind.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.adapter.-$$Lambda$UserCenterAdapterL$B-4T31_XMny8rBTbtWQ4cC-5pa8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterAdapterL.convert$lambda$0(holder, itemUserCenterBindingBind, this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(BaseViewHolder holder, ItemUserCenterBinding viewBinding, UserCenterAdapterL this$0, String item, View view) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(viewBinding, "$viewBinding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Log.d("UserComponentAdapter", "position = " + holder.getAdapterPosition());
        viewBinding.check.setChecked(true);
        viewBinding.checkImg.setChecked(true);
        this$0.selectPosition = item;
        this$0.notifyDataSetChanged();
        ItemClick itemClick = this$0.mItemClick;
        if (itemClick != null) {
            itemClick.onItemClick(holder.getAdapterPosition(), item);
        }
    }

    public final void setItemClick(ItemClick mItemClick) {
        Intrinsics.checkNotNullParameter(mItemClick, "mItemClick");
        this.mItemClick = mItemClick;
    }
}
