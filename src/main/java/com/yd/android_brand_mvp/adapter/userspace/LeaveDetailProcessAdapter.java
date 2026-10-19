package com.yd.android_brand_mvp.adapter.userspace;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ItemLeaveDetailProcessBinding;
import com.yd.android_brand_mvp.databinding.ItemPeopleBinding;
import com.yd.android_brand_mvp.model.userspace.ArrangeUserInfoBean;
import com.yd.android_brand_mvp.model.userspace.FlowElementListItem;
import com.yd.android_brand_mvp.model.userspace.UserInfoListItem;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TransUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* JADX INFO: compiled from: LeaveDetailProcessAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/userspace/LeaveDetailProcessAdapter;", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemLeaveDetailProcessBinding;", "Lcom/yd/android_brand_mvp/model/userspace/FlowElementListItem;", "()V", "convertPlus", "", "holder", "Lcom/yd/android_brand_mvp/base/VBViewHolder;", "item", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LeaveDetailProcessAdapter extends BaseBindingAdapter<ItemLeaveDetailProcessBinding, FlowElementListItem> {
    public LeaveDetailProcessAdapter() {
        super(null, 1, null);
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, FlowElementListItem flowElementListItem) {
        convertPlus2((VBViewHolder<ItemLeaveDetailProcessBinding>) vBViewHolder, flowElementListItem);
    }

    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
    public void convertPlus2(VBViewHolder<ItemLeaveDetailProcessBinding> holder, FlowElementListItem item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemLeaveDetailProcessBinding itemLeaveDetailProcessBinding = (ItemLeaveDetailProcessBinding) holder.getBinding();
        if (itemLeaveDetailProcessBinding != null) {
            if (getData().size() == 1) {
                View view = itemLeaveDetailProcessBinding.viewLineTop;
                Intrinsics.checkNotNullExpressionValue(view, "it.viewLineTop");
                SimpleUtilsKt.remove(view);
                View view2 = itemLeaveDetailProcessBinding.viewLineBottom;
                Intrinsics.checkNotNullExpressionValue(view2, "it.viewLineBottom");
                SimpleUtilsKt.remove(view2);
            } else {
                int layoutPosition = holder.getLayoutPosition();
                if (layoutPosition == 0) {
                    View view3 = itemLeaveDetailProcessBinding.viewLineTop;
                    Intrinsics.checkNotNullExpressionValue(view3, "it.viewLineTop");
                    SimpleUtilsKt.remove(view3);
                } else if (layoutPosition == getData().size() - 1) {
                    View view4 = itemLeaveDetailProcessBinding.viewLineBottom;
                    Intrinsics.checkNotNullExpressionValue(view4, "it.viewLineBottom");
                    SimpleUtilsKt.remove(view4);
                } else {
                    View view5 = itemLeaveDetailProcessBinding.viewLineTop;
                    Intrinsics.checkNotNullExpressionValue(view5, "it.viewLineTop");
                    SimpleUtilsKt.show(view5);
                    View view6 = itemLeaveDetailProcessBinding.viewLineBottom;
                    Intrinsics.checkNotNullExpressionValue(view6, "it.viewLineBottom");
                    SimpleUtilsKt.show(view6);
                }
            }
            itemLeaveDetailProcessBinding.tvItemLeaveDetailProcessNodeName.setText(item.getName());
            TextView textView = itemLeaveDetailProcessBinding.tvItemLeaveDetailProcessReason;
            Intrinsics.checkNotNullExpressionValue(textView, "it.tvItemLeaveDetailProcessReason");
            SimpleUtilsKt.remove(textView);
            RecyclerView recyclerView = itemLeaveDetailProcessBinding.rvItemLeaveDetailProcessPeople;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "it.rvItemLeaveDetailProcessPeople");
            SimpleUtilsKt.show(recyclerView);
            itemLeaveDetailProcessBinding.tvItemLeaveDetailProcessNodeTime.setText("");
            itemLeaveDetailProcessBinding.tvItemLeaveDetailProcessNameStatus.setText("");
            if (Intrinsics.areEqual(item.getFlowElementType(), "CC")) {
                GlideUtil.loadImage(getContext(), R.drawable.icon_leave_cc, itemLeaveDetailProcessBinding.ivItemLeaveDetailProcess);
                itemLeaveDetailProcessBinding.tvItemLeaveDetailProcessName.setText("共抄送" + item.getUserInfoList().size() + (char) 20154);
                BaseBindingAdapter<ItemPeopleBinding, UserInfoListItem> baseBindingAdapter = new BaseBindingAdapter<ItemPeopleBinding, UserInfoListItem>() { // from class: com.yd.android_brand_mvp.adapter.userspace.LeaveDetailProcessAdapter$convertPlus$1$ccPeopleAdapter$1
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
                itemLeaveDetailProcessBinding.rvItemLeaveDetailProcessPeople.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
                itemLeaveDetailProcessBinding.rvItemLeaveDetailProcessPeople.setAdapter(baseBindingAdapter);
                baseBindingAdapter.setList(item.getUserInfoList());
                return;
            }
            if (Intrinsics.areEqual(item.getFlowElementType(), Logger.ROOT_LOGGER_NAME)) {
                itemLeaveDetailProcessBinding.tvItemLeaveDetailProcessNodeName.setText("我");
            } else {
                itemLeaveDetailProcessBinding.tvItemLeaveDetailProcessNameStatus.setText(TransUtils.INSTANCE.getLeaveStatusSteByLeaveOutcome(item.getOutcome()));
            }
            Integer leaveNodeTipLogoByLeaveOutcome = TransUtils.INSTANCE.getLeaveNodeTipLogoByLeaveOutcome(item.getOutcome());
            if (leaveNodeTipLogoByLeaveOutcome == null) {
                ImageView imageView = itemLeaveDetailProcessBinding.ivItemLeaveDetailProcessStatusTip;
                Intrinsics.checkNotNullExpressionValue(imageView, "it.ivItemLeaveDetailProcessStatusTip");
                SimpleUtilsKt.remove(imageView);
            } else {
                ImageView imageView2 = itemLeaveDetailProcessBinding.ivItemLeaveDetailProcessStatusTip;
                Intrinsics.checkNotNullExpressionValue(imageView2, "it.ivItemLeaveDetailProcessStatusTip");
                SimpleUtilsKt.show(imageView2);
                GlideUtil.loadImage(getContext(), leaveNodeTipLogoByLeaveOutcome.intValue(), itemLeaveDetailProcessBinding.ivItemLeaveDetailProcessStatusTip);
            }
            if (item.getUserInfoList().size() > 1) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (UserInfoListItem userInfoListItem : item.getUserInfoList()) {
                    if (Intrinsics.areEqual(userInfoListItem.getOutcome(), "2") || Intrinsics.areEqual(userInfoListItem.getOutcome(), "0")) {
                        arrayList.add(new ArrangeUserInfoBean(2, null, userInfoListItem, 2, null));
                    } else {
                        arrayList2.add(userInfoListItem);
                    }
                }
                arrayList.add(new ArrangeUserInfoBean(1, arrayList2, null, 4, null));
                GlideUtil.loadImage(getContext(), R.drawable.icon_leave_more, itemLeaveDetailProcessBinding.ivItemLeaveDetailProcess);
                itemLeaveDetailProcessBinding.tvItemLeaveDetailProcessName.setText(item.getUserInfoList().size() + (char) 20154 + TransUtils.INSTANCE.getLeaveModeSteByLeaveMode(item.getMode()));
                LeaveDetailPeopleAdapter leaveDetailPeopleAdapter = new LeaveDetailPeopleAdapter(arrayList);
                itemLeaveDetailProcessBinding.rvItemLeaveDetailProcessPeople.setLayoutManager(new LinearLayoutManager(getContext()));
                itemLeaveDetailProcessBinding.rvItemLeaveDetailProcessPeople.setAdapter(leaveDetailPeopleAdapter);
                return;
            }
            if (!item.getUserInfoList().isEmpty()) {
                RecyclerView recyclerView2 = itemLeaveDetailProcessBinding.rvItemLeaveDetailProcessPeople;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "it.rvItemLeaveDetailProcessPeople");
                SimpleUtilsKt.remove(recyclerView2);
                UserInfoListItem userInfoListItem2 = (UserInfoListItem) CollectionsKt.first((List) item.getUserInfoList());
                itemLeaveDetailProcessBinding.tvItemLeaveDetailProcessName.setText(userInfoListItem2.getName());
                GlideUtil.loadRadiusHeadImage(getContext(), userInfoListItem2.getAvatar(), itemLeaveDetailProcessBinding.ivItemLeaveDetailProcess, SizeUtils.dp2px(5.0f));
                if (userInfoListItem2.getComment().length() > 0) {
                    TextView textView2 = itemLeaveDetailProcessBinding.tvItemLeaveDetailProcessReason;
                    Intrinsics.checkNotNullExpressionValue(textView2, "it.tvItemLeaveDetailProcessReason");
                    SimpleUtilsKt.show(textView2);
                    itemLeaveDetailProcessBinding.tvItemLeaveDetailProcessReason.setText(userInfoListItem2.getComment());
                }
                itemLeaveDetailProcessBinding.tvItemLeaveDetailProcessNodeTime.setText(userInfoListItem2.getApprTime());
            }
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public ItemLeaveDetailProcessBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemLeaveDetailProcessBinding itemLeaveDetailProcessBindingInflate = ItemLeaveDetailProcessBinding.inflate(inflater, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemLeaveDetailProcessBindingInflate, "inflate(inflater, parent, false)");
        return itemLeaveDetailProcessBindingInflate;
    }
}
