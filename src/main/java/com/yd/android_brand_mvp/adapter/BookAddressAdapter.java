package com.yd.android_brand_mvp.adapter;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.AddressBookItemLayoutBinding;
import com.yd.android_brand_mvp.databinding.ItemLabsTextBinding;
import com.yd.android_brand_mvp.model.task.AddressBookBean;
import com.yd.android_brand_mvp.model.task.BookLabsBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BookAddressAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0015¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/BookAddressAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/task/AddressBookBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BookAddressAdapter extends BaseQuickAdapter<AddressBookBean, BaseViewHolder> {
    public BookAddressAdapter() {
        super(R.layout.address_book_item_layout, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(final BaseViewHolder holder, AddressBookBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        AddressBookItemLayoutBinding addressBookItemLayoutBindingBind = AddressBookItemLayoutBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(addressBookItemLayoutBindingBind, "bind(holder.itemView)");
        addressBookItemLayoutBindingBind.itemNameTv.setText(item.getName());
        if (item.getLabels() != null && item.getLabels().size() > 0) {
            BaseQuickAdapter<BookLabsBean, BaseViewHolder> baseQuickAdapter = new BaseQuickAdapter<BookLabsBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.adapter.BookAddressAdapter$convert$mAdapter$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.chad.library.adapter.base.BaseQuickAdapter
                public void convert(BaseViewHolder holder2, BookLabsBean item2) {
                    Intrinsics.checkNotNullParameter(holder2, "holder");
                    Intrinsics.checkNotNullParameter(item2, "item");
                    ItemLabsTextBinding itemLabsTextBindingBind = ItemLabsTextBinding.bind(holder2.itemView);
                    Intrinsics.checkNotNullExpressionValue(itemLabsTextBindingBind, "bind(holder.itemView)");
                    itemLabsTextBindingBind.tvLab.setText(item2.getName());
                    if (Intrinsics.areEqual(item2.getColor(), "orange")) {
                        itemLabsTextBindingBind.tvLab.setBackgroundResource(R.drawable.item_adress_book_f47f3e);
                    } else {
                        itemLabsTextBindingBind.tvLab.setBackgroundResource(R.drawable.item_adress_book_8568e3);
                    }
                }
            };
            addressBookItemLayoutBindingBind.recyclerViewLabs.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            addressBookItemLayoutBindingBind.recyclerViewLabs.setAdapter(baseQuickAdapter);
            addressBookItemLayoutBindingBind.recyclerViewLabs.setOnTouchListener(new View.OnTouchListener() { // from class: com.yd.android_brand_mvp.adapter.-$$Lambda$BookAddressAdapter$6Xk0c9LTr5i6khle2OVbMMEzTa4
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return BookAddressAdapter.convert$lambda$0(holder, view, motionEvent);
                }
            });
            baseQuickAdapter.setList(item.getLabels());
        }
        if (TextUtils.isEmpty(item.getPhoto())) {
            return;
        }
        GlideUtil.loadImageRadius(getContext(), item.getPhoto(), addressBookItemLayoutBindingBind.itemIconImg, R.drawable.icon_bp_message_nes_bg, SizeUtils.dp2px(20.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean convert$lambda$0(BaseViewHolder holder, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        if (motionEvent.getAction() != 1) {
            return false;
        }
        holder.itemView.performClick();
        return false;
    }
}
