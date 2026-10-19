package com.yd.android_brand_mvp.dialog.collect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ItemLocationNameBinding;
import com.yd.android_brand_mvp.databinding.PopupFormLocationBinding;
import com.yd.android_brand_mvp.listener.BaseSelectListener;
import com.yd.android_brand_mvp.model.collect.BaseArrayBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import razerdp.basepopup.BasePopupWindow;

/* JADX INFO: compiled from: SingleSelectPopup.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0013J\u0014\u0010\u001a\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001cR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/collect/SingleSelectPopup;", "Lrazerdp/basepopup/BasePopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "adapter", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemLocationNameBinding;", "Lcom/yd/android_brand_mvp/model/collect/BaseArrayBean;", "binding", "Lcom/yd/android_brand_mvp/databinding/PopupFormLocationBinding;", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/PopupFormLocationBinding;", "setBinding", "(Lcom/yd/android_brand_mvp/databinding/PopupFormLocationBinding;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yd/android_brand_mvp/listener/BaseSelectListener;", "onViewCreated", "", "contentView", "Landroid/view/View;", "setCallBack", "cb", "setDataList", "data", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SingleSelectPopup extends BasePopupWindow {
    private BaseBindingAdapter<ItemLocationNameBinding, BaseArrayBean> adapter;
    public PopupFormLocationBinding binding;
    private BaseSelectListener listener;

    public final PopupFormLocationBinding getBinding() {
        PopupFormLocationBinding popupFormLocationBinding = this.binding;
        if (popupFormLocationBinding != null) {
            return popupFormLocationBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(PopupFormLocationBinding popupFormLocationBinding) {
        Intrinsics.checkNotNullParameter(popupFormLocationBinding, "<set-?>");
        this.binding = popupFormLocationBinding;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleSelectPopup(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setBackground(0);
        setPopupGravity(80);
        this.adapter = new BaseBindingAdapter<ItemLocationNameBinding, BaseArrayBean>() { // from class: com.yd.android_brand_mvp.dialog.collect.SingleSelectPopup$adapter$1
            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, BaseArrayBean baseArrayBean) {
                convertPlus2((VBViewHolder<ItemLocationNameBinding>) vBViewHolder, baseArrayBean);
            }

            /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
            public void convertPlus2(VBViewHolder<ItemLocationNameBinding> holder, BaseArrayBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemLocationNameBinding itemLocationNameBinding = (ItemLocationNameBinding) holder.getBinding();
                if (itemLocationNameBinding != null) {
                    itemLocationNameBinding.tvItemLocationName.setText(item.getName());
                }
            }

            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public ItemLocationNameBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                Intrinsics.checkNotNullParameter(parent, "parent");
                ItemLocationNameBinding itemLocationNameBindingInflate = ItemLocationNameBinding.inflate(inflater, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemLocationNameBindingInflate, "inflate(inflater, parent, false)");
                return itemLocationNameBindingInflate;
            }
        };
        setContentView(R.layout.popup_form_location);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleSelectPopup(Fragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        setBackground(0);
        setPopupGravity(80);
        this.adapter = new BaseBindingAdapter<ItemLocationNameBinding, BaseArrayBean>() { // from class: com.yd.android_brand_mvp.dialog.collect.SingleSelectPopup$adapter$1
            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, BaseArrayBean baseArrayBean) {
                convertPlus2((VBViewHolder<ItemLocationNameBinding>) vBViewHolder, baseArrayBean);
            }

            /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
            public void convertPlus2(VBViewHolder<ItemLocationNameBinding> holder, BaseArrayBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemLocationNameBinding itemLocationNameBinding = (ItemLocationNameBinding) holder.getBinding();
                if (itemLocationNameBinding != null) {
                    itemLocationNameBinding.tvItemLocationName.setText(item.getName());
                }
            }

            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public ItemLocationNameBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                Intrinsics.checkNotNullParameter(parent, "parent");
                ItemLocationNameBinding itemLocationNameBindingInflate = ItemLocationNameBinding.inflate(inflater, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemLocationNameBindingInflate, "inflate(inflater, parent, false)");
                return itemLocationNameBindingInflate;
            }
        };
        setContentView(R.layout.popup_form_location);
    }

    @Override // razerdp.basepopup.BasePopupWindow
    public void onViewCreated(View contentView) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        PopupFormLocationBinding popupFormLocationBindingBind = PopupFormLocationBinding.bind(contentView);
        Intrinsics.checkNotNullExpressionValue(popupFormLocationBindingBind, "bind(contentView)");
        setBinding(popupFormLocationBindingBind);
        getBinding().rvPopupFormLocation.setLayoutManager(new LinearLayoutManager(getContext()));
        getBinding().rvPopupFormLocation.setAdapter(this.adapter);
        this.adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.dialog.collect.-$$Lambda$SingleSelectPopup$Yd6g4KCr8nTLe9J3XYYcjrD-1EY
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SingleSelectPopup.onViewCreated$lambda$0(this.f$0, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(SingleSelectPopup this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        BaseSelectListener baseSelectListener = this$0.listener;
        if (baseSelectListener != null) {
            baseSelectListener.onSelect(this$0.adapter.getItem(i));
        }
        this$0.dismiss();
    }

    public final void setCallBack(BaseSelectListener cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.listener = cb;
    }

    public final void setDataList(List<BaseArrayBean> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.adapter.setList(data);
        this.adapter.getRecyclerView().scrollToPosition(0);
    }
}
