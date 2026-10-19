package com.yd.android_brand_mvp.dialog.reservation;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.databinding.DialogReservationDetailBinding;
import com.yd.android_brand_mvp.model.reservation.ReservationDetailBean;
import com.yd.android_brand_mvp.model.reservation.ReservationSignListItemBean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReservationDetailDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/reservation/ReservationDetailDialog;", "Landroidx/fragment/app/DialogFragment;", "data", "Lcom/yd/android_brand_mvp/model/reservation/ReservationDetailBean;", "portrait", "", "(Lcom/yd/android_brand_mvp/model/reservation/ReservationDetailBean;Z)V", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogReservationDetailBinding;", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/DialogReservationDetailBinding;", "setBinding", "(Lcom/yd/android_brand_mvp/databinding/DialogReservationDetailBinding;)V", "isPortrait", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReservationDetailDialog extends DialogFragment {
    public DialogReservationDetailBinding binding;
    private ReservationDetailBean data;
    private boolean isPortrait;

    public final DialogReservationDetailBinding getBinding() {
        DialogReservationDetailBinding dialogReservationDetailBinding = this.binding;
        if (dialogReservationDetailBinding != null) {
            return dialogReservationDetailBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogReservationDetailBinding dialogReservationDetailBinding) {
        Intrinsics.checkNotNullParameter(dialogReservationDetailBinding, "<set-?>");
        this.binding = dialogReservationDetailBinding;
    }

    public ReservationDetailDialog(ReservationDetailBean data, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.isPortrait = z;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogReservationDetailBinding dialogReservationDetailBindingInflate = DialogReservationDetailBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogReservationDetailBindingInflate, "inflate(inflater, container, false)");
        setBinding(dialogReservationDetailBindingInflate);
        NestedScrollView root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        ReservationDetailBean reservationDetailBean = this.data;
        if (reservationDetailBean != null) {
            getBinding().tvDialogReservationDetailTheme.setText(reservationDetailBean.getName());
            getBinding().tvDialogReservationDetailSignStatus.setText(reservationDetailBean.getSignIn() ? "需签到" : "无需签到");
            getBinding().tvDialogReservationDetailTime.setText(reservationDetailBean.getBookingTime());
            getBinding().tvDialogReservationDetailPeople.setText(reservationDetailBean.getSponsorName());
            StringBuilder sb = new StringBuilder();
            sb.append("(应到人数:" + reservationDetailBean.getSignList().size() + "人)");
            int i = 0;
            for (Object obj : reservationDetailBean.getSignList()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                sb.append(((ReservationSignListItemBean) obj).getUserName());
                if (i != CollectionsKt.getLastIndex(reservationDetailBean.getSignList())) {
                    sb.append("、");
                }
                i = i2;
            }
            getBinding().tvDialogReservationDetailParticipant.setText(sb);
            getBinding().tvDialogReservationDetailRemark.setText(reservationDetailBean.getDescribe());
            getBinding().tvDialogReservationDetailSiteName.setText(reservationDetailBean.getSiteInfo().getName());
            getBinding().tvDialogReservationDetailSiteType.setText(reservationDetailBean.getSiteInfo().getSiteTypeName());
            getBinding().tvDialogReservationDetailSiteLocation.setText(reservationDetailBean.getSiteInfo().getBuildingName());
            getBinding().tvDialogReservationDetailSiteCapacity.setText(reservationDetailBean.getSiteInfo().getPeppleNum());
            getBinding().tvDialogReservationDetailSiteDevice.setText("");
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
            if (this.isPortrait) {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.74d);
            } else {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.42d);
            }
            window.setAttributes(attributes);
        }
    }
}
