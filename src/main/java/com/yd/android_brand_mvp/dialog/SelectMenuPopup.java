package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.SelectMenuAdapter;
import com.yd.android_brand_mvp.databinding.PopupSelectMenuBinding;
import com.yd.android_brand_mvp.model.SelectMenuBean;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import razerdp.basepopup.BasePopupWindow;

/* JADX INFO: compiled from: SelectMenuPopup.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0011J\u0014\u0010\u001d\u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/SelectMenuPopup;", "Lrazerdp/basepopup/BasePopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "width", "", "height", "(Landroidx/fragment/app/Fragment;II)V", "adapter", "Lcom/yd/android_brand_mvp/adapter/SelectMenuAdapter;", "binding", "Lcom/yd/android_brand_mvp/databinding/PopupSelectMenuBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yd/android_brand_mvp/dialog/SelectMenuListener;", "getDataList", "", "Lcom/yd/android_brand_mvp/model/SelectMenuBean;", "getSelectData", "initView", "", "onViewCreated", "contentView", "Landroid/view/View;", "setCallBack", "cb", "setDataList", TUIKitConstants.Selection.LIST, "setSelectData", "select", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectMenuPopup extends BasePopupWindow {
    private final SelectMenuAdapter adapter;
    private PopupSelectMenuBinding binding;
    private SelectMenuListener listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectMenuPopup(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.adapter = new SelectMenuAdapter();
        setBackground(R.color.A90_transparent);
        setPopupGravity(80);
        setContentView(createPopupById(R.layout.popup_select_menu));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectMenuPopup(Fragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.adapter = new SelectMenuAdapter();
        setBackground(R.color.A90_transparent);
        setPopupGravity(80);
        setContentView(createPopupById(R.layout.popup_select_menu));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectMenuPopup(Fragment fragment, int i, int i2) {
        super(fragment, i, i2);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.adapter = new SelectMenuAdapter();
        setBackground(R.color.A90_transparent);
        setPopupGravity(80);
        setContentView(createPopupById(R.layout.popup_select_menu));
    }

    @Override // razerdp.basepopup.BasePopupWindow
    public void onViewCreated(View contentView) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreated(contentView);
        PopupSelectMenuBinding popupSelectMenuBindingBind = PopupSelectMenuBinding.bind(contentView);
        Intrinsics.checkNotNullExpressionValue(popupSelectMenuBindingBind, "bind(contentView)");
        this.binding = popupSelectMenuBindingBind;
        initView();
    }

    private final void initView() {
        PopupSelectMenuBinding popupSelectMenuBinding = this.binding;
        PopupSelectMenuBinding popupSelectMenuBinding2 = null;
        if (popupSelectMenuBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            popupSelectMenuBinding = null;
        }
        popupSelectMenuBinding.rvPopupSelectMenu.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupSelectMenuBinding popupSelectMenuBinding3 = this.binding;
        if (popupSelectMenuBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            popupSelectMenuBinding2 = popupSelectMenuBinding3;
        }
        popupSelectMenuBinding2.rvPopupSelectMenu.setAdapter(this.adapter);
        this.adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$SelectMenuPopup$7UTSZe4HSllaq3tFe48IBCdfu0Y
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SelectMenuPopup.initView$lambda$1(this.f$0, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(SelectMenuPopup this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        SelectMenuBean item = this$0.adapter.getItem(i);
        if (item == null) {
            return;
        }
        Iterator<T> it2 = this$0.adapter.getData().iterator();
        while (it2.hasNext()) {
            ((SelectMenuBean) it2.next()).setSelect(false);
        }
        item.setSelect(true);
        this$0.adapter.notifyDataSetChanged();
        SelectMenuListener selectMenuListener = this$0.listener;
        if (selectMenuListener != null) {
            selectMenuListener.getSelectMenu(item);
        }
        this$0.dismiss();
    }

    public final void setDataList(List<SelectMenuBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.adapter.setList(list);
    }

    public final List<SelectMenuBean> getDataList() {
        return this.adapter.getData();
    }

    public final SelectMenuBean getSelectData() {
        Object next;
        Iterator<T> it2 = this.adapter.getData().iterator();
        while (it2.hasNext()) {
            next = it2.next();
            if (((SelectMenuBean) next).isSelect()) {
                return (SelectMenuBean) next;
            }
        }
        next = null;
        return (SelectMenuBean) next;
    }

    public final void setSelectData(SelectMenuBean select) {
        Object next;
        Intrinsics.checkNotNullParameter(select, "select");
        Iterator<T> it2 = this.adapter.getData().iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!Intrinsics.areEqual(((SelectMenuBean) next).getId(), select.getId()));
        SelectMenuBean selectMenuBean = (SelectMenuBean) next;
        if (selectMenuBean == null) {
            return;
        }
        Iterator<T> it3 = this.adapter.getData().iterator();
        while (it3.hasNext()) {
            ((SelectMenuBean) it3.next()).setSelect(false);
        }
        selectMenuBean.setSelect(true);
        this.adapter.notifyDataSetChanged();
    }

    public final void setCallBack(SelectMenuListener cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.listener = cb;
    }
}
