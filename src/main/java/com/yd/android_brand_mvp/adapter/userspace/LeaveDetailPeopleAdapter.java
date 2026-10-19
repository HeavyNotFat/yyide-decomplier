package com.yd.android_brand_mvp.adapter.userspace;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ItemPeopleBinding;
import com.yd.android_brand_mvp.model.userspace.ArrangeUserInfoBean;
import com.yd.android_brand_mvp.model.userspace.UserInfoListItem;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LeaveDetailPeopleAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/userspace/LeaveDetailPeopleAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/yd/android_brand_mvp/model/userspace/ArrangeUserInfoBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LeaveDetailPeopleAdapter extends BaseMultiItemQuickAdapter<ArrangeUserInfoBean, BaseViewHolder> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeaveDetailPeopleAdapter(List<ArrangeUserInfoBean> data) {
        super(data);
        Intrinsics.checkNotNullParameter(data, "data");
        addItemType(1, R.layout.item_recylcer);
        addItemType(2, R.layout.item_people_with_status);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, ArrangeUserInfoBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 1) {
            RecyclerView recyclerView = (RecyclerView) holder.getView(R.id.rv_item_recycler);
            SimpleUtilsKt.remove((ImageView) holder.getView(R.id.iv_item_recycler_add));
            SimpleUtilsKt.remove(holder.getView(R.id.view_line));
            BaseBindingAdapter<ItemPeopleBinding, UserInfoListItem> baseBindingAdapter = new BaseBindingAdapter<ItemPeopleBinding, UserInfoListItem>() { // from class: com.yd.android_brand_mvp.adapter.userspace.LeaveDetailPeopleAdapter$convert$ccPeopleAdapter$1
                @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, UserInfoListItem userInfoListItem) {
                    convertPlus2((VBViewHolder<ItemPeopleBinding>) vBViewHolder, userInfoListItem);
                }

                /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                public void convertPlus2(VBViewHolder<ItemPeopleBinding> holder2, UserInfoListItem item2) {
                    Intrinsics.checkNotNullParameter(holder2, "holder");
                    Intrinsics.checkNotNullParameter(item2, "item");
                    ItemPeopleBinding itemPeopleBinding = (ItemPeopleBinding) holder2.getBinding();
                    if (itemPeopleBinding != null) {
                        itemPeopleBinding.tvItemPeopleName.setText(item2.getName());
                        GlideUtil.loadRadiusHeadImage(getContext(), item2.getAvatar(), itemPeopleBinding.ivItemPeople, SizeUtils.dp2px(5.0f));
                        if (Intrinsics.areEqual(item2.getOutcome(), ConversionUtil.conditionWithBookType)) {
                            ImageView imageView = itemPeopleBinding.ivItemPeopleTip;
                            Intrinsics.checkNotNullExpressionValue(imageView, "ccBinding.ivItemPeopleTip");
                            SimpleUtilsKt.remove(imageView);
                        } else {
                            ImageView imageView2 = itemPeopleBinding.ivItemPeopleTip;
                            Intrinsics.checkNotNullExpressionValue(imageView2, "ccBinding.ivItemPeopleTip");
                            SimpleUtilsKt.show(imageView2);
                            GlideUtil.loadImage(getContext(), R.drawable.icon_leave_ing, itemPeopleBinding.ivItemPeopleTip);
                        }
                    }
                }

                @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                public ItemPeopleBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                    Intrinsics.checkNotNullParameter(inflater, "inflater");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    ItemPeopleBinding itemPeopleBindingInflate = ItemPeopleBinding.inflate(inflater, parent, false);
                    Intrinsics.checkNotNullExpressionValue(itemPeopleBindingInflate, "inflate(inflater, parent, false)");
                    return itemPeopleBindingInflate;
                }
            };
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            recyclerView.setAdapter(baseBindingAdapter);
            baseBindingAdapter.setList(item.getArrangeUserList());
            return;
        }
        if (itemViewType != 2) {
            return;
        }
        ImageView imageView = (ImageView) holder.getView(R.id.iv_item_people_with_status);
        TextView textView = (TextView) holder.getView(R.id.tv_item_people_with_status_name);
        TextView textView2 = (TextView) holder.getView(R.id.tv_item_people_with_status_tip);
        TextView textView3 = (TextView) holder.getView(R.id.tv_item_people_with_status_time);
        TextView textView4 = (TextView) holder.getView(R.id.tv_item_people_with_status_reason);
        ImageView imageView2 = (ImageView) holder.getView(R.id.iv_item_people_with_status_tip);
        GlideUtil.loadRadiusHeadImage(getContext(), item.getArrangeUser().getAvatar(), imageView, SizeUtils.dp2px(5.0f));
        if (Intrinsics.areEqual(item.getArrangeUser().getOutcome(), "0")) {
            GlideUtil.loadImage(getContext(), R.drawable.icon_leave_refuse, imageView2);
            textView2.setText("(已拒绝)");
            textView2.setTextColor(SimpleUtilsKt.asColor(R.color.red_FD4F45));
        } else {
            GlideUtil.loadImage(getContext(), R.drawable.icon_leave_pass, imageView2);
            textView2.setText("(已同意)");
            textView2.setTextColor(SimpleUtilsKt.asColor(R.color.color_11c685));
        }
        textView.setText(item.getArrangeUser().getName());
        textView3.setText(item.getArrangeUser().getApprTime());
        textView4.setText(item.getArrangeUser().getComment());
    }
}
