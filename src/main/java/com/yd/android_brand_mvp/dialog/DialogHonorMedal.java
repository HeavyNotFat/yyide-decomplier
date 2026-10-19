package com.yd.android_brand_mvp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.DialogHonorMedalBinding;
import com.yd.android_brand_mvp.model.honor.HonorItemBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogHonorMedal.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/DialogHonorMedal;", "", "()V", "mDialogCallback", "Lcom/yd/android_brand_mvp/dialog/DialogHonorMedal$DialogCallback;", "setOnDialogCallback", "", "showDialog", "context", "Landroid/content/Context;", "item", "Lcom/yd/android_brand_mvp/model/honor/HonorItemBean;", "DialogCallback", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DialogHonorMedal {
    private DialogCallback mDialogCallback;

    /* JADX INFO: compiled from: DialogHonorMedal.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/DialogHonorMedal$DialogCallback;", "", "onDialogConfirm", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface DialogCallback {
        void onDialogConfirm();
    }

    public final void showDialog(Context context, HonorItemBean item) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        final Dialog dialog = new Dialog(context, R.style.DialogTheme);
        DialogHonorMedalBinding dialogHonorMedalBindingInflate = DialogHonorMedalBinding.inflate(dialog.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(dialogHonorMedalBindingInflate, "inflate(dialog.layoutInflater)");
        dialogHonorMedalBindingInflate.tvTitle.setText(item.getHonorTitle());
        GlideUtil.loadImage(context, item.getMedalUrl(), dialogHonorMedalBindingInflate.ivMedal);
        dialogHonorMedalBindingInflate.tvActiveTitle.setText(item.getActivityTitle());
        dialogHonorMedalBindingInflate.tvTimeClass.setText(item.getObtainTime() + "    " + item.getClassName());
        dialog.setContentView(dialogHonorMedalBindingInflate.getRoot());
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
            attributes.width = SizeUtils.dp2px(490.0f);
        }
        if (window != null) {
            window.setAttributes(attributes);
        }
        dialogHonorMedalBindingInflate.tvConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$DialogHonorMedal$UWDTGuP8UHqpgyI4d_2giXnFWFE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogHonorMedal.showDialog$lambda$0(this.f$0, dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$0(DialogHonorMedal this$0, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        DialogCallback dialogCallback = this$0.mDialogCallback;
        if (dialogCallback != null) {
            dialogCallback.onDialogConfirm();
        }
        dialog.dismiss();
    }

    public final void setOnDialogCallback(DialogCallback mDialogCallback) {
        this.mDialogCallback = mDialogCallback;
    }
}
