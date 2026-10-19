package com.yd.android_brand_mvp.dialog.chemistry;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.databinding.DialogSiteInfoBinding;
import com.yd.android_brand_mvp.model.SiteInfoBean;
import com.yd.android_brand_mvp.model.SiteTeacherBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SiteInfoDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/chemistry/SiteInfoDialog;", "Landroidx/fragment/app/DialogFragment;", "data", "Lcom/yd/android_brand_mvp/model/SiteInfoBean;", "(Lcom/yd/android_brand_mvp/model/SiteInfoBean;)V", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogSiteInfoBinding;", "siteInfo", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SiteInfoDialog extends DialogFragment {
    private DialogSiteInfoBinding binding;
    private SiteInfoBean siteInfo;

    public SiteInfoDialog(SiteInfoBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.siteInfo = data;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogSiteInfoBinding dialogSiteInfoBindingInflate = DialogSiteInfoBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogSiteInfoBindingInflate, "inflate(inflater, container, false)");
        this.binding = dialogSiteInfoBindingInflate;
        if (dialogSiteInfoBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogSiteInfoBindingInflate = null;
        }
        ConstraintLayout root = dialogSiteInfoBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SiteInfoBean siteInfoBean = this.siteInfo;
        if (siteInfoBean != null) {
            DialogSiteInfoBinding dialogSiteInfoBinding = this.binding;
            DialogSiteInfoBinding dialogSiteInfoBinding2 = null;
            if (dialogSiteInfoBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogSiteInfoBinding = null;
            }
            dialogSiteInfoBinding.tvDialogSiteInfoName.setText(siteInfoBean.getName());
            DialogSiteInfoBinding dialogSiteInfoBinding3 = this.binding;
            if (dialogSiteInfoBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogSiteInfoBinding3 = null;
            }
            dialogSiteInfoBinding3.tvDialogSiteInfoTypeContent.setText(siteInfoBean.getSiteTypeName());
            DialogSiteInfoBinding dialogSiteInfoBinding4 = this.binding;
            if (dialogSiteInfoBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogSiteInfoBinding4 = null;
            }
            dialogSiteInfoBinding4.tvDialogSiteInfoRoomNumContent.setText(siteInfoBean.getRoomNum());
            if (!siteInfoBean.getList().isEmpty()) {
                DialogSiteInfoBinding dialogSiteInfoBinding5 = this.binding;
                if (dialogSiteInfoBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogSiteInfoBinding5 = null;
                }
                dialogSiteInfoBinding5.tvDialogSiteInfoManagerContent.setText(((SiteTeacherBean) CollectionsKt.first((List) siteInfoBean.getList())).getName());
            }
            DialogSiteInfoBinding dialogSiteInfoBinding6 = this.binding;
            if (dialogSiteInfoBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogSiteInfoBinding6 = null;
            }
            TextView textView = dialogSiteInfoBinding6.tvDialogSiteInfoFloorContent;
            StringBuilder sb = new StringBuilder();
            sb.append(siteInfoBean.getFloor());
            sb.append((char) 27004);
            textView.setText(sb.toString());
            DialogSiteInfoBinding dialogSiteInfoBinding7 = this.binding;
            if (dialogSiteInfoBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogSiteInfoBinding7 = null;
            }
            TextView textView2 = dialogSiteInfoBinding7.tvDialogSiteInfoCapacityContent;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(siteInfoBean.getPeppleNum());
            sb2.append((char) 20154);
            textView2.setText(sb2.toString());
            DialogSiteInfoBinding dialogSiteInfoBinding8 = this.binding;
            if (dialogSiteInfoBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogSiteInfoBinding2 = dialogSiteInfoBinding8;
            }
            dialogSiteInfoBinding2.tvDialogSiteInfoSizeContent.setText(String.valueOf(siteInfoBean.getSpace()));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        Dialog dialog2 = getDialog();
        Window window = dialog2 != null ? dialog2.getWindow() : null;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkNotNullExpressionValue(attributes, "it.attributes");
            Display defaultDisplay = window.getWindowManager().getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "it.windowManager.defaultDisplay");
            attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.27d);
            attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.52d);
            window.setAttributes(attributes);
        }
    }
}
