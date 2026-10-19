package com.yd.android_brand_mvp.adapter.common;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.userspace.LeavePeopleAdapter;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ItemUserLeaveNodeBinding;
import com.yd.android_brand_mvp.model.userspace.FlowElementListItem;
import com.yd.android_brand_mvp.model.userspace.UserInfoListItem;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: FlowAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/common/FlowAdapter;", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemUserLeaveNodeBinding;", "Lcom/yd/android_brand_mvp/model/userspace/FlowElementListItem;", "()V", "convertPlus", "", "holder", "Lcom/yd/android_brand_mvp/base/VBViewHolder;", "item", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlowAdapter extends BaseBindingAdapter<ItemUserLeaveNodeBinding, FlowElementListItem> {
    public FlowAdapter() {
        super(null, 1, null);
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, FlowElementListItem flowElementListItem) {
        convertPlus2((VBViewHolder<ItemUserLeaveNodeBinding>) vBViewHolder, flowElementListItem);
    }

    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
    public void convertPlus2(VBViewHolder<ItemUserLeaveNodeBinding> holder, FlowElementListItem item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemUserLeaveNodeBinding itemUserLeaveNodeBinding = (ItemUserLeaveNodeBinding) holder.getBinding();
        if (itemUserLeaveNodeBinding != null) {
            if (getData().size() == 1) {
                View view = itemUserLeaveNodeBinding.viewTopLine;
                Intrinsics.checkNotNullExpressionValue(view, "it.viewTopLine");
                SimpleUtilsKt.remove(view);
                View view2 = itemUserLeaveNodeBinding.viewTopBottom;
                Intrinsics.checkNotNullExpressionValue(view2, "it.viewTopBottom");
                SimpleUtilsKt.remove(view2);
            } else {
                int layoutPosition = holder.getLayoutPosition();
                if (layoutPosition == 0) {
                    View view3 = itemUserLeaveNodeBinding.viewTopLine;
                    Intrinsics.checkNotNullExpressionValue(view3, "it.viewTopLine");
                    SimpleUtilsKt.remove(view3);
                } else if (layoutPosition == getData().size() - 1) {
                    View view4 = itemUserLeaveNodeBinding.viewTopBottom;
                    Intrinsics.checkNotNullExpressionValue(view4, "it.viewTopBottom");
                    SimpleUtilsKt.remove(view4);
                } else {
                    View view5 = itemUserLeaveNodeBinding.viewTopLine;
                    Intrinsics.checkNotNullExpressionValue(view5, "it.viewTopLine");
                    SimpleUtilsKt.show(view5);
                    View view6 = itemUserLeaveNodeBinding.viewTopBottom;
                    Intrinsics.checkNotNullExpressionValue(view6, "it.viewTopBottom");
                    SimpleUtilsKt.show(view6);
                }
            }
            itemUserLeaveNodeBinding.tvItemUserLeaveNodeName.setText(item.getName());
            LeavePeopleAdapter leavePeopleAdapter = new LeavePeopleAdapter();
            if (item.getUserSelectType() == 1) {
                ImageView imageView = itemUserLeaveNodeBinding.ivItemUserLeaveNodeAdd;
                Intrinsics.checkNotNullExpressionValue(imageView, "it.ivItemUserLeaveNodeAdd");
                SimpleUtilsKt.remove(imageView);
            } else {
                ImageView imageView2 = itemUserLeaveNodeBinding.ivItemUserLeaveNodeAdd;
                Intrinsics.checkNotNullExpressionValue(imageView2, "it.ivItemUserLeaveNodeAdd");
                SimpleUtilsKt.show(imageView2);
            }
            if (!Intrinsics.areEqual(item.getFlowElementType(), "CC")) {
                Iterator<T> it2 = item.getUserInfoList().iterator();
                while (it2.hasNext()) {
                    ((UserInfoListItem) it2.next()).setMode(item.getMode());
                }
            }
            List<UserInfoListItem> userInfoList = item.getUserInfoList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : userInfoList) {
                if (((UserInfoListItem) obj).getSelected()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            itemUserLeaveNodeBinding.rvItemUserLeaveNodePeople.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            itemUserLeaveNodeBinding.rvItemUserLeaveNodePeople.setAdapter(leavePeopleAdapter);
            leavePeopleAdapter.setList(arrayList2);
            if (item.isNotUser()) {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SimpleUtilsKt.asColor(R.color.colorPrimaryDark));
                String handler = item.getHandler();
                int iHashCode = handler.hashCode();
                if (iHashCode == -407216299) {
                    if (handler.equals("TO_PASS")) {
                        SpannableString spannableString = new SpannableString(getContext().getString(R.string.leave_auto_pass));
                        spannableString.setSpan(foregroundColorSpan, 0, 6, 17);
                        itemUserLeaveNodeBinding.tvItemUserLeaveNodeDesc.setText(spannableString);
                        return;
                    }
                    return;
                }
                if (iHashCode == -407050481) {
                    if (handler.equals("TO_USER")) {
                        StringBuilder sb = new StringBuilder();
                        int i = 0;
                        for (Object obj2 : arrayList2) {
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            sb.append(((UserInfoListItem) obj2).getName());
                            if (i != CollectionsKt.getLastIndex(arrayList2)) {
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            }
                            i = i2;
                        }
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String string = getContext().getString(R.string.leave_go_specify);
                        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.leave_go_specify)");
                        String str = String.format(string, Arrays.copyOf(new Object[]{sb}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                        SpannableString spannableString2 = new SpannableString(str);
                        spannableString2.setSpan(foregroundColorSpan, 0, 6, 17);
                        itemUserLeaveNodeBinding.tvItemUserLeaveNodeDesc.setText(spannableString2);
                        return;
                    }
                    return;
                }
                if (iHashCode == 247427179 && handler.equals("TO_ADMIN")) {
                    StringBuilder sb2 = new StringBuilder();
                    int i3 = 0;
                    for (Object obj3 : arrayList2) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        sb2.append(((UserInfoListItem) obj3).getName());
                        if (i3 != CollectionsKt.getLastIndex(arrayList2)) {
                            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        i3 = i4;
                    }
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String string2 = getContext().getString(R.string.leave_to_manager);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.leave_to_manager)");
                    String str2 = String.format(string2, Arrays.copyOf(new Object[]{sb2}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                    SpannableString spannableString3 = new SpannableString(str2);
                    spannableString3.setSpan(foregroundColorSpan, 0, 6, 17);
                    itemUserLeaveNodeBinding.tvItemUserLeaveNodeDesc.setText(spannableString3);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(item.getFlowElementType(), "CC")) {
                itemUserLeaveNodeBinding.tvItemUserLeaveNodeDesc.setText(arrayList2.size() + "人抄送");
                return;
            }
            String mode = item.getMode();
            int iHashCode2 = mode.hashCode();
            if (iHashCode2 == 2531) {
                if (mode.equals("OR")) {
                    itemUserLeaveNodeBinding.tvItemUserLeaveNodeDesc.setText(arrayList2.size() + "人或签");
                    return;
                }
                return;
            }
            if (iHashCode2 == 64951) {
                if (mode.equals("AND")) {
                    itemUserLeaveNodeBinding.tvItemUserLeaveNodeDesc.setText(arrayList2.size() + "人会签");
                    return;
                }
                return;
            }
            if (iHashCode2 == 2392819 && mode.equals("NEXT")) {
                itemUserLeaveNodeBinding.tvItemUserLeaveNodeDesc.setText(arrayList2.size() + "人依次审批");
            }
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public ItemUserLeaveNodeBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemUserLeaveNodeBinding itemUserLeaveNodeBindingInflate = ItemUserLeaveNodeBinding.inflate(inflater, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemUserLeaveNodeBindingInflate, "inflate(inflater, parent, false)");
        return itemUserLeaveNodeBindingInflate;
    }
}
