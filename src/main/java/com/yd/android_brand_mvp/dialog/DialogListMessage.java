package com.yd.android_brand_mvp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.DialogListMessageBinding;
import com.yd.android_brand_mvp.databinding.ItemTextBinding;
import com.yd.android_brand_mvp.utils.StringUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogListMessage.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002*\u0001\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00142\b\u0010\b\u001a\u0004\u0018\u00010\tR\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/DialogListMessage;", "", "()V", "mAdapter", "com/yd/android_brand_mvp/dialog/DialogListMessage$mAdapter$1", "Lcom/yd/android_brand_mvp/dialog/DialogListMessage$mAdapter$1;", "mDialogCallback", "Lcom/yd/android_brand_mvp/dialog/DialogListMessage$DialogCallback;", "select", "Lcom/yd/android_brand_mvp/dialog/DialogBean;", "getSelect", "()Lcom/yd/android_brand_mvp/dialog/DialogBean;", "setSelect", "(Lcom/yd/android_brand_mvp/dialog/DialogBean;)V", "setOnDialogCallback", "", "showDialog", "context", "Landroid/content/Context;", TUIKitConstants.Selection.LIST, "", "DialogCallback", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DialogListMessage {
    private final DialogListMessage$mAdapter$1 mAdapter = new BaseQuickAdapter<DialogBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.dialog.DialogListMessage$mAdapter$1
        {
            super(R.layout.item_text, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder holder, DialogBean item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            ItemTextBinding itemTextBindingBind = ItemTextBinding.bind(holder.itemView);
            Intrinsics.checkNotNullExpressionValue(itemTextBindingBind, "bind(holder.itemView)");
            itemTextBindingBind.tvName.setText(StringUtils.subZeroAndDot(String.valueOf(item.getMesasge())) + (char) 20998);
            DialogBean select = this.this$0.getSelect();
            if (Intrinsics.areEqual(select != null ? select.getMesasge() : null, item.getMesasge())) {
                itemTextBindingBind.tvName.setTextColor(getContext().getResources().getColor(R.color.text_333333));
                itemTextBindingBind.tvName.setBackgroundColor(getContext().getResources().getColor(R.color.white));
            } else {
                itemTextBindingBind.tvName.setTextColor(getContext().getResources().getColor(R.color.text_333333));
                itemTextBindingBind.tvName.setBackgroundColor(0);
            }
        }
    };
    private DialogCallback mDialogCallback;
    private DialogBean select;

    /* JADX INFO: compiled from: DialogListMessage.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/DialogListMessage$DialogCallback;", "", "onDialogCancel", "", "onDialogConfirm", "select", "Lcom/yd/android_brand_mvp/dialog/DialogBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface DialogCallback {
        void onDialogCancel();

        void onDialogConfirm(DialogBean select);
    }

    public final DialogBean getSelect() {
        return this.select;
    }

    public final void setSelect(DialogBean dialogBean) {
        this.select = dialogBean;
    }

    public final void showDialog(Context context, List<DialogBean> list, DialogBean select) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "list");
        final Dialog dialog = new Dialog(context, R.style.DialogTheme);
        DialogListMessageBinding dialogListMessageBindingInflate = DialogListMessageBinding.inflate(dialog.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(dialogListMessageBindingInflate, "inflate(dialog.layoutInflater)");
        dialog.setContentView(dialogListMessageBindingInflate.getRoot());
        this.select = select;
        dialogListMessageBindingInflate.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        dialogListMessageBindingInflate.recyclerView.setAdapter(this.mAdapter);
        setList(list);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (window != null) {
            window.setGravity(17);
        }
        WindowManager windowManager = window != null ? window.getWindowManager() : null;
        if (windowManager != null) {
            windowManager.getDefaultDisplay();
        }
        if (attributes != null) {
            attributes.height = SizeUtils.dp2px(304.0f);
        }
        if (attributes != null) {
            attributes.width = SizeUtils.dp2px(490.0f);
        }
        if (window != null) {
            window.setAttributes(attributes);
        }
        dialogListMessageBindingInflate.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$DialogListMessage$xHkZvF8fVqXD7EBdpbaRvOpgtOc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogListMessage.showDialog$lambda$0(this.f$0, dialog, view);
            }
        });
        dialogListMessageBindingInflate.btnConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$DialogListMessage$weaJwC6wdFUi-uwWTFIvbejJNzI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogListMessage.showDialog$lambda$1(this.f$0, dialog, view);
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$DialogListMessage$ULwIbYNi11K1gDwo2ftnIRB0c18
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogListMessage.showDialog$lambda$2(this.f$0, dialogInterface);
            }
        });
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$DialogListMessage$W114vZ4v6P3dAjh_QyboCH9e1-A
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DialogListMessage.showDialog$lambda$3(this.f$0, baseQuickAdapter, view, i);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$0(DialogListMessage this$0, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        DialogCallback dialogCallback = this$0.mDialogCallback;
        if (dialogCallback != null) {
            dialogCallback.onDialogCancel();
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$1(DialogListMessage this$0, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        DialogCallback dialogCallback = this$0.mDialogCallback;
        if (dialogCallback != null) {
            dialogCallback.onDialogConfirm(this$0.select);
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$2(DialogListMessage this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setOnDialogCallback(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$3(DialogListMessage this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.select = this$0.mAdapter.getItem(i);
        this$0.mAdapter.notifyDataSetChanged();
    }

    public final void setOnDialogCallback(DialogCallback mDialogCallback) {
        this.mDialogCallback = mDialogCallback;
    }
}
