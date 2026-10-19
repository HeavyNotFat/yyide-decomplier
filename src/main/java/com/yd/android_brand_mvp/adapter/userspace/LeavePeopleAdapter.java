package com.yd.android_brand_mvp.adapter.userspace;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ItemLeaveCcBinding;
import com.yd.android_brand_mvp.model.userspace.UserInfoListItem;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LeavePeopleAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/userspace/LeavePeopleAdapter;", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemLeaveCcBinding;", "Lcom/yd/android_brand_mvp/model/userspace/UserInfoListItem;", "()V", "convertPlus", "", "holder", "Lcom/yd/android_brand_mvp/base/VBViewHolder;", "item", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LeavePeopleAdapter extends BaseBindingAdapter<ItemLeaveCcBinding, UserInfoListItem> {
    public LeavePeopleAdapter() {
        super(null, 1, null);
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, UserInfoListItem userInfoListItem) {
        convertPlus2((VBViewHolder<ItemLeaveCcBinding>) vBViewHolder, userInfoListItem);
    }

    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
    public void convertPlus2(VBViewHolder<ItemLeaveCcBinding> holder, UserInfoListItem item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemLeaveCcBinding itemLeaveCcBinding = (ItemLeaveCcBinding) holder.getBinding();
        if (itemLeaveCcBinding != null) {
            ImageView imageView = itemLeaveCcBinding.ivDel;
            Intrinsics.checkNotNullExpressionValue(imageView, "peopleBinding.ivDel");
            SimpleUtilsKt.remove(imageView);
            GlideUtil.loadRadiusHeadImage(getContext(), item.getAvatar(), itemLeaveCcBinding.ivHead, SizeUtils.dp2px(5.0f));
            itemLeaveCcBinding.tvName.setText(item.getName());
            if (holder.getLayoutPosition() == getData().size() - 1) {
                ImageView imageView2 = itemLeaveCcBinding.ivItemLeaveCcProcess;
                Intrinsics.checkNotNullExpressionValue(imageView2, "peopleBinding.ivItemLeaveCcProcess");
                SimpleUtilsKt.remove(imageView2);
                return;
            }
            ImageView imageView3 = itemLeaveCcBinding.ivItemLeaveCcProcess;
            Intrinsics.checkNotNullExpressionValue(imageView3, "peopleBinding.ivItemLeaveCcProcess");
            SimpleUtilsKt.show(imageView3);
            String mode = item.getMode();
            int iHashCode = mode.hashCode();
            if (iHashCode == 0) {
                if (mode.equals("")) {
                    ImageView imageView4 = itemLeaveCcBinding.ivItemLeaveCcProcess;
                    Intrinsics.checkNotNullExpressionValue(imageView4, "peopleBinding.ivItemLeaveCcProcess");
                    SimpleUtilsKt.remove(imageView4);
                    return;
                }
                return;
            }
            if (iHashCode == 2531) {
                if (mode.equals("OR")) {
                    itemLeaveCcBinding.ivItemLeaveCcProcess.setImageDrawable(SimpleUtilsKt.asDrawable(R.drawable.icon_or));
                }
            } else if (iHashCode == 64951) {
                if (mode.equals("AND")) {
                    itemLeaveCcBinding.ivItemLeaveCcProcess.setImageDrawable(SimpleUtilsKt.asDrawable(R.drawable.icon_and));
                }
            } else if (iHashCode == 2392819 && mode.equals("NEXT")) {
                itemLeaveCcBinding.ivItemLeaveCcProcess.setImageDrawable(SimpleUtilsKt.asDrawable(R.drawable.icon_right));
            }
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public ItemLeaveCcBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemLeaveCcBinding itemLeaveCcBindingInflate = ItemLeaveCcBinding.inflate(inflater, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemLeaveCcBindingInflate, "inflate(inflater, parent, false)");
        return itemLeaveCcBindingInflate;
    }
}
