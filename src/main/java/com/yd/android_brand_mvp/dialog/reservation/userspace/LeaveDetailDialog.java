package com.yd.android_brand_mvp.dialog.reservation.userspace;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.userspace.FormDetailContentAdapter;
import com.yd.android_brand_mvp.adapter.userspace.LeaveDetailProcessAdapter;
import com.yd.android_brand_mvp.databinding.DialogLeaveDetailBinding;
import com.yd.android_brand_mvp.listener.StringListener;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.collect.FormProps;
import com.yd.android_brand_mvp.model.userspace.FlowElementBean;
import com.yd.android_brand_mvp.model.userspace.LeaveDetailBean;
import com.yd.android_brand_mvp.model.userspace.LeaveTypeBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LeaveDetailDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/reservation/userspace/LeaveDetailDialog;", "Landroidx/fragment/app/DialogFragment;", "data", "Lcom/yd/android_brand_mvp/model/userspace/LeaveDetailBean;", "(Lcom/yd/android_brand_mvp/model/userspace/LeaveDetailBean;)V", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogLeaveDetailBinding;", "contentAdapter", "Lcom/yd/android_brand_mvp/adapter/userspace/FormDetailContentAdapter;", "getData", "()Lcom/yd/android_brand_mvp/model/userspace/LeaveDetailBean;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yd/android_brand_mvp/listener/StringListener;", "nodeAdapter", "Lcom/yd/android_brand_mvp/adapter/userspace/LeaveDetailProcessAdapter;", "nodeCancelAdapter", "nodeUpdateAdapter", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "parseJsonData", "", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "setCallBack", "cb", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LeaveDetailDialog extends DialogFragment {
    private DialogLeaveDetailBinding binding;
    private final FormDetailContentAdapter contentAdapter;
    private final LeaveDetailBean data;
    private StringListener listener;
    private final LeaveDetailProcessAdapter nodeAdapter;
    private final LeaveDetailProcessAdapter nodeCancelAdapter;
    private final LeaveDetailProcessAdapter nodeUpdateAdapter;

    public LeaveDetailDialog(LeaveDetailBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.nodeAdapter = new LeaveDetailProcessAdapter();
        this.nodeUpdateAdapter = new LeaveDetailProcessAdapter();
        this.nodeCancelAdapter = new LeaveDetailProcessAdapter();
        this.contentAdapter = new FormDetailContentAdapter();
    }

    public final LeaveDetailBean getData() {
        return this.data;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogLeaveDetailBinding dialogLeaveDetailBindingInflate = DialogLeaveDetailBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogLeaveDetailBindingInflate, "inflate(inflater, container, false)");
        this.binding = dialogLeaveDetailBindingInflate;
        if (dialogLeaveDetailBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBindingInflate = null;
        }
        ConstraintLayout root = dialogLeaveDetailBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws JSONException {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() throws JSONException {
        DialogLeaveDetailBinding dialogLeaveDetailBinding = this.binding;
        DialogLeaveDetailBinding dialogLeaveDetailBinding2 = null;
        if (dialogLeaveDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding = null;
        }
        dialogLeaveDetailBinding.tvDialogLeaveDetailName.setText(this.data.getTitle());
        DialogLeaveDetailBinding dialogLeaveDetailBinding3 = this.binding;
        if (dialogLeaveDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding3 = null;
        }
        dialogLeaveDetailBinding3.tvDialogLeaveDetailSubmitTime.setText(this.data.getPromoterTime());
        DialogLeaveDetailBinding dialogLeaveDetailBinding4 = this.binding;
        if (dialogLeaveDetailBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding4 = null;
        }
        dialogLeaveDetailBinding4.rvDialogLeaveDetailContent.setLayoutManager(new LinearLayoutManager(requireContext()));
        DialogLeaveDetailBinding dialogLeaveDetailBinding5 = this.binding;
        if (dialogLeaveDetailBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding5 = null;
        }
        dialogLeaveDetailBinding5.rvDialogLeaveDetailContent.setAdapter(this.contentAdapter);
        this.contentAdapter.setList(parseJsonData());
        int status = this.data.getStatus();
        if (status == 0) {
            DialogLeaveDetailBinding dialogLeaveDetailBinding6 = this.binding;
            if (dialogLeaveDetailBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLeaveDetailBinding6 = null;
            }
            dialogLeaveDetailBinding6.tvDialogLeaveDetailStatus.setText("已拒绝");
            DialogLeaveDetailBinding dialogLeaveDetailBinding7 = this.binding;
            if (dialogLeaveDetailBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLeaveDetailBinding7 = null;
            }
            dialogLeaveDetailBinding7.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_0);
        } else if (status == 1) {
            DialogLeaveDetailBinding dialogLeaveDetailBinding8 = this.binding;
            if (dialogLeaveDetailBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLeaveDetailBinding8 = null;
            }
            dialogLeaveDetailBinding8.tvDialogLeaveDetailStatus.setText("审批中");
            DialogLeaveDetailBinding dialogLeaveDetailBinding9 = this.binding;
            if (dialogLeaveDetailBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLeaveDetailBinding9 = null;
            }
            dialogLeaveDetailBinding9.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_1);
        } else if (status == 2) {
            DialogLeaveDetailBinding dialogLeaveDetailBinding10 = this.binding;
            if (dialogLeaveDetailBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLeaveDetailBinding10 = null;
            }
            dialogLeaveDetailBinding10.tvDialogLeaveDetailStatus.setText("已通过");
            DialogLeaveDetailBinding dialogLeaveDetailBinding11 = this.binding;
            if (dialogLeaveDetailBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLeaveDetailBinding11 = null;
            }
            dialogLeaveDetailBinding11.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape);
        } else if (status == 3) {
            DialogLeaveDetailBinding dialogLeaveDetailBinding12 = this.binding;
            if (dialogLeaveDetailBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLeaveDetailBinding12 = null;
            }
            dialogLeaveDetailBinding12.tvDialogLeaveDetailStatus.setText("已撤销");
            DialogLeaveDetailBinding dialogLeaveDetailBinding13 = this.binding;
            if (dialogLeaveDetailBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLeaveDetailBinding13 = null;
            }
            dialogLeaveDetailBinding13.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.ask_for_leave_status_gary_shape);
            DialogLeaveDetailBinding dialogLeaveDetailBinding14 = this.binding;
            if (dialogLeaveDetailBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLeaveDetailBinding14 = null;
            }
            Button button = dialogLeaveDetailBinding14.btnDialogLeaveDetailRevoke;
            Intrinsics.checkNotNullExpressionValue(button, "binding.btnDialogLeaveDetailRevoke");
            SimpleUtilsKt.remove(button);
        } else {
            DialogLeaveDetailBinding dialogLeaveDetailBinding15 = this.binding;
            if (dialogLeaveDetailBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLeaveDetailBinding15 = null;
            }
            dialogLeaveDetailBinding15.tvDialogLeaveDetailStatus.setText("未知");
            DialogLeaveDetailBinding dialogLeaveDetailBinding16 = this.binding;
            if (dialogLeaveDetailBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLeaveDetailBinding16 = null;
            }
            dialogLeaveDetailBinding16.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_0);
        }
        DialogLeaveDetailBinding dialogLeaveDetailBinding17 = this.binding;
        if (dialogLeaveDetailBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding17 = null;
        }
        dialogLeaveDetailBinding17.rvDialogLeaveDetailProcess.setLayoutManager(new LinearLayoutManager(requireContext()));
        DialogLeaveDetailBinding dialogLeaveDetailBinding18 = this.binding;
        if (dialogLeaveDetailBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding18 = null;
        }
        dialogLeaveDetailBinding18.rvDialogLeaveDetailProcess.setAdapter(this.nodeAdapter);
        DialogLeaveDetailBinding dialogLeaveDetailBinding19 = this.binding;
        if (dialogLeaveDetailBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding19 = null;
        }
        dialogLeaveDetailBinding19.rvDialogLeaveUpdateDetailProcess.setLayoutManager(new LinearLayoutManager(requireContext()));
        DialogLeaveDetailBinding dialogLeaveDetailBinding20 = this.binding;
        if (dialogLeaveDetailBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding20 = null;
        }
        dialogLeaveDetailBinding20.rvDialogLeaveUpdateDetailProcess.setAdapter(this.nodeUpdateAdapter);
        DialogLeaveDetailBinding dialogLeaveDetailBinding21 = this.binding;
        if (dialogLeaveDetailBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding21 = null;
        }
        dialogLeaveDetailBinding21.rvDialogLeaveCancelDetailProcess.setLayoutManager(new LinearLayoutManager(requireContext()));
        DialogLeaveDetailBinding dialogLeaveDetailBinding22 = this.binding;
        if (dialogLeaveDetailBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding22 = null;
        }
        dialogLeaveDetailBinding22.rvDialogLeaveCancelDetailProcess.setAdapter(this.nodeCancelAdapter);
        DialogLeaveDetailBinding dialogLeaveDetailBinding23 = this.binding;
        if (dialogLeaveDetailBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding23 = null;
        }
        LinearLayoutCompat linearLayoutCompat = dialogLeaveDetailBinding23.llUpdateProcess;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "binding.llUpdateProcess");
        SimpleUtilsKt.remove(linearLayoutCompat);
        DialogLeaveDetailBinding dialogLeaveDetailBinding24 = this.binding;
        if (dialogLeaveDetailBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding24 = null;
        }
        LinearLayoutCompat linearLayoutCompat2 = dialogLeaveDetailBinding24.llCancelProcess;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat2, "binding.llCancelProcess");
        SimpleUtilsKt.remove(linearLayoutCompat2);
        DialogLeaveDetailBinding dialogLeaveDetailBinding25 = this.binding;
        if (dialogLeaveDetailBinding25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding25 = null;
        }
        RecyclerView recyclerView = dialogLeaveDetailBinding25.rvDialogLeaveUpdateDetailProcess;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.rvDialogLeaveUpdateDetailProcess");
        SimpleUtilsKt.remove(recyclerView);
        DialogLeaveDetailBinding dialogLeaveDetailBinding26 = this.binding;
        if (dialogLeaveDetailBinding26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding26 = null;
        }
        RecyclerView recyclerView2 = dialogLeaveDetailBinding26.rvDialogLeaveCancelDetailProcess;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.rvDialogLeaveCancelDetailProcess");
        SimpleUtilsKt.remove(recyclerView2);
        List<FlowElementBean> procFlowElementList = this.data.getProcFlowElementList();
        if (!procFlowElementList.isEmpty()) {
            for (FlowElementBean flowElementBean : procFlowElementList) {
                int procType = flowElementBean.getProcType();
                if (procType == 1) {
                    DialogLeaveDetailBinding dialogLeaveDetailBinding27 = this.binding;
                    if (dialogLeaveDetailBinding27 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogLeaveDetailBinding27 = null;
                    }
                    LinearLayoutCompat linearLayoutCompat3 = dialogLeaveDetailBinding27.llUpdateProcess;
                    Intrinsics.checkNotNullExpressionValue(linearLayoutCompat3, "binding.llUpdateProcess");
                    SimpleUtilsKt.show(linearLayoutCompat3);
                    this.nodeUpdateAdapter.setList(flowElementBean.getFlowElementList());
                } else if (procType == 2) {
                    DialogLeaveDetailBinding dialogLeaveDetailBinding28 = this.binding;
                    if (dialogLeaveDetailBinding28 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogLeaveDetailBinding28 = null;
                    }
                    LinearLayoutCompat linearLayoutCompat4 = dialogLeaveDetailBinding28.llCancelProcess;
                    Intrinsics.checkNotNullExpressionValue(linearLayoutCompat4, "binding.llCancelProcess");
                    SimpleUtilsKt.show(linearLayoutCompat4);
                    this.nodeCancelAdapter.setList(flowElementBean.getFlowElementList());
                } else {
                    this.nodeAdapter.setList(flowElementBean.getFlowElementList());
                }
            }
        }
        DialogLeaveDetailBinding dialogLeaveDetailBinding29 = this.binding;
        if (dialogLeaveDetailBinding29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding29 = null;
        }
        dialogLeaveDetailBinding29.llOriginalProcess.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.reservation.userspace.-$$Lambda$LeaveDetailDialog$7ZfpEuXl06BJX_gX6mdocsxnenY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LeaveDetailDialog.initView$lambda$2(this.f$0, view);
            }
        });
        DialogLeaveDetailBinding dialogLeaveDetailBinding30 = this.binding;
        if (dialogLeaveDetailBinding30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding30 = null;
        }
        dialogLeaveDetailBinding30.llUpdateProcess.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.reservation.userspace.-$$Lambda$LeaveDetailDialog$Vs_CmwvpCfJrSs2ZCINwHLVPOGU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LeaveDetailDialog.initView$lambda$3(this.f$0, view);
            }
        });
        DialogLeaveDetailBinding dialogLeaveDetailBinding31 = this.binding;
        if (dialogLeaveDetailBinding31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding31 = null;
        }
        dialogLeaveDetailBinding31.llCancelProcess.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.reservation.userspace.-$$Lambda$LeaveDetailDialog$4XHS7LP58qwKpVU9Ou4589eLdjg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LeaveDetailDialog.initView$lambda$4(this.f$0, view);
            }
        });
        DialogLeaveDetailBinding dialogLeaveDetailBinding32 = this.binding;
        if (dialogLeaveDetailBinding32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogLeaveDetailBinding2 = dialogLeaveDetailBinding32;
        }
        dialogLeaveDetailBinding2.btnDialogLeaveDetailRevoke.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.reservation.userspace.-$$Lambda$LeaveDetailDialog$2Yf5gq8qPaUPFPCu8ZGpo8vPjvE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LeaveDetailDialog.initView$lambda$5(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(LeaveDetailDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogLeaveDetailBinding dialogLeaveDetailBinding = this$0.binding;
        DialogLeaveDetailBinding dialogLeaveDetailBinding2 = null;
        if (dialogLeaveDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding = null;
        }
        if (!dialogLeaveDetailBinding.rvDialogLeaveDetailProcess.isShown()) {
            DialogLeaveDetailBinding dialogLeaveDetailBinding3 = this$0.binding;
            if (dialogLeaveDetailBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLeaveDetailBinding3 = null;
            }
            dialogLeaveDetailBinding3.ivOriginal.setImageResource(R.drawable.rl_up_btn);
            DialogLeaveDetailBinding dialogLeaveDetailBinding4 = this$0.binding;
            if (dialogLeaveDetailBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogLeaveDetailBinding2 = dialogLeaveDetailBinding4;
            }
            RecyclerView recyclerView = dialogLeaveDetailBinding2.rvDialogLeaveDetailProcess;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.rvDialogLeaveDetailProcess");
            SimpleUtilsKt.show(recyclerView);
            return;
        }
        DialogLeaveDetailBinding dialogLeaveDetailBinding5 = this$0.binding;
        if (dialogLeaveDetailBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding5 = null;
        }
        dialogLeaveDetailBinding5.ivOriginal.setImageResource(R.drawable.rl_next_btn);
        DialogLeaveDetailBinding dialogLeaveDetailBinding6 = this$0.binding;
        if (dialogLeaveDetailBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogLeaveDetailBinding2 = dialogLeaveDetailBinding6;
        }
        RecyclerView recyclerView2 = dialogLeaveDetailBinding2.rvDialogLeaveDetailProcess;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.rvDialogLeaveDetailProcess");
        SimpleUtilsKt.remove(recyclerView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(LeaveDetailDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogLeaveDetailBinding dialogLeaveDetailBinding = this$0.binding;
        DialogLeaveDetailBinding dialogLeaveDetailBinding2 = null;
        if (dialogLeaveDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding = null;
        }
        if (!dialogLeaveDetailBinding.rvDialogLeaveUpdateDetailProcess.isShown()) {
            DialogLeaveDetailBinding dialogLeaveDetailBinding3 = this$0.binding;
            if (dialogLeaveDetailBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLeaveDetailBinding3 = null;
            }
            dialogLeaveDetailBinding3.ivUpdate.setImageResource(R.drawable.rl_up_btn);
            DialogLeaveDetailBinding dialogLeaveDetailBinding4 = this$0.binding;
            if (dialogLeaveDetailBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogLeaveDetailBinding2 = dialogLeaveDetailBinding4;
            }
            RecyclerView recyclerView = dialogLeaveDetailBinding2.rvDialogLeaveUpdateDetailProcess;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.rvDialogLeaveUpdateDetailProcess");
            SimpleUtilsKt.show(recyclerView);
            return;
        }
        DialogLeaveDetailBinding dialogLeaveDetailBinding5 = this$0.binding;
        if (dialogLeaveDetailBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding5 = null;
        }
        dialogLeaveDetailBinding5.ivUpdate.setImageResource(R.drawable.rl_next_btn);
        DialogLeaveDetailBinding dialogLeaveDetailBinding6 = this$0.binding;
        if (dialogLeaveDetailBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogLeaveDetailBinding2 = dialogLeaveDetailBinding6;
        }
        RecyclerView recyclerView2 = dialogLeaveDetailBinding2.rvDialogLeaveUpdateDetailProcess;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.rvDialogLeaveUpdateDetailProcess");
        SimpleUtilsKt.remove(recyclerView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(LeaveDetailDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogLeaveDetailBinding dialogLeaveDetailBinding = this$0.binding;
        DialogLeaveDetailBinding dialogLeaveDetailBinding2 = null;
        if (dialogLeaveDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding = null;
        }
        if (!dialogLeaveDetailBinding.rvDialogLeaveCancelDetailProcess.isShown()) {
            DialogLeaveDetailBinding dialogLeaveDetailBinding3 = this$0.binding;
            if (dialogLeaveDetailBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLeaveDetailBinding3 = null;
            }
            dialogLeaveDetailBinding3.ivCancel.setImageResource(R.drawable.rl_up_btn);
            DialogLeaveDetailBinding dialogLeaveDetailBinding4 = this$0.binding;
            if (dialogLeaveDetailBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogLeaveDetailBinding2 = dialogLeaveDetailBinding4;
            }
            RecyclerView recyclerView = dialogLeaveDetailBinding2.rvDialogLeaveCancelDetailProcess;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.rvDialogLeaveCancelDetailProcess");
            SimpleUtilsKt.show(recyclerView);
            return;
        }
        DialogLeaveDetailBinding dialogLeaveDetailBinding5 = this$0.binding;
        if (dialogLeaveDetailBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLeaveDetailBinding5 = null;
        }
        dialogLeaveDetailBinding5.ivCancel.setImageResource(R.drawable.rl_next_btn);
        DialogLeaveDetailBinding dialogLeaveDetailBinding6 = this$0.binding;
        if (dialogLeaveDetailBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogLeaveDetailBinding2 = dialogLeaveDetailBinding6;
        }
        RecyclerView recyclerView2 = dialogLeaveDetailBinding2.rvDialogLeaveCancelDetailProcess;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.rvDialogLeaveCancelDetailProcess");
        SimpleUtilsKt.remove(recyclerView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(LeaveDetailDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringListener stringListener = this$0.listener;
        if (stringListener != null) {
            stringListener.getStringData("revoke");
        }
    }

    private final List<FormBaseBean> parseJsonData() throws JSONException {
        JSONArray jSONArray;
        int i;
        int i2;
        LeaveDetailDialog leaveDetailDialog = this;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray2 = new JSONArray(leaveDetailDialog.data.getJsonData());
        int length = jSONArray2.length();
        int i3 = 0;
        while (i3 < length) {
            JSONObject jSONObject = jSONArray2.getJSONObject(i3);
            if (jSONObject.optBoolean("isKit")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    int length2 = jSONArrayOptJSONArray.length();
                    int i4 = 0;
                    while (i4 < length2) {
                        FormBaseBean formBaseBean = new FormBaseBean(false, null, 0, null, null, null, null, null, null, null, null, 0, 0, null, null, false, null, 131071, null);
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                        JSONArray jSONArray3 = jSONArray2;
                        String childrenName = jSONObjectOptJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.NAME);
                        int i5 = length;
                        String childrenTitle = jSONObjectOptJSONObject.optString("title");
                        int i6 = length2;
                        String childrenId = jSONObjectOptJSONObject.optString("id");
                        JSONArray jSONArray4 = jSONArrayOptJSONArray;
                        String strOptString = jSONObjectOptJSONObject.optString("value");
                        int i7 = i3;
                        formBaseBean.setKit(true);
                        Intrinsics.checkNotNullExpressionValue(childrenName, "childrenName");
                        formBaseBean.setName(childrenName);
                        Intrinsics.checkNotNullExpressionValue(childrenTitle, "childrenTitle");
                        formBaseBean.setTitle(childrenTitle);
                        Intrinsics.checkNotNullExpressionValue(childrenId, "childrenId");
                        formBaseBean.setId(childrenId);
                        formBaseBean.setValue(strOptString);
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("props");
                        FormProps formProps = new FormProps(false, false, false, null, false, false, false, null, 0, false, false, false, false, 0, false, 0, 0, null, 0, null, null, 2097151, null);
                        if (jSONObjectOptJSONObject2 != null) {
                            ArrayList arrayList2 = new ArrayList();
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("options");
                            if (jSONArrayOptJSONArray2 != null) {
                                int length3 = jSONArrayOptJSONArray2.length();
                                int i8 = 0;
                                while (i8 < length3) {
                                    JSONObject itemOption = jSONArrayOptJSONArray2.optJSONObject(i8);
                                    JSONArray jSONArray5 = jSONArrayOptJSONArray2;
                                    StringBuilder sb = new StringBuilder();
                                    int i9 = length3;
                                    sb.append("itemOption = ");
                                    sb.append(itemOption);
                                    AppExtKt.logd(leaveDetailDialog, sb.toString());
                                    if (itemOption != null) {
                                        Intrinsics.checkNotNullExpressionValue(itemOption, "itemOption");
                                        LeaveTypeBean leaveTypeBean = new LeaveTypeBean(0, null, null, null, 0, null, 0, false, 255, null);
                                        String typeName = itemOption.optString(AppMeasurementSdk.ConditionalUserProperty.NAME);
                                        String typeId = itemOption.optString("id");
                                        Intrinsics.checkNotNullExpressionValue(typeName, "typeName");
                                        leaveTypeBean.setName(typeName);
                                        Intrinsics.checkNotNullExpressionValue(typeId, "typeId");
                                        leaveTypeBean.setId(typeId);
                                        arrayList2.add(leaveTypeBean);
                                    }
                                    i8++;
                                    leaveDetailDialog = this;
                                    jSONArrayOptJSONArray2 = jSONArray5;
                                    length3 = i9;
                                }
                                formProps.getOptions().addAll(arrayList2);
                            }
                        }
                        formBaseBean.setProps(formProps);
                        arrayList.add(formBaseBean);
                        i4++;
                        leaveDetailDialog = this;
                        jSONArray2 = jSONArray3;
                        length = i5;
                        length2 = i6;
                        jSONArrayOptJSONArray = jSONArray4;
                        i3 = i7;
                    }
                    jSONArray = jSONArray2;
                    i = length;
                    i2 = i3;
                } else {
                    jSONArray = jSONArray2;
                    i = length;
                    i2 = i3;
                    FormBaseBean formBaseBean2 = new FormBaseBean(false, null, 0, null, null, null, null, null, null, null, null, 0, 0, null, null, false, null, 131071, null);
                    String name = jSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.NAME);
                    String title = jSONObject.optString("title");
                    String id = jSONObject.optString("id");
                    String strOptString2 = jSONObject.optString("value");
                    formBaseBean2.setKit(true);
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    formBaseBean2.setName(name);
                    Intrinsics.checkNotNullExpressionValue(title, "title");
                    formBaseBean2.setTitle(title);
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    formBaseBean2.setId(id);
                    formBaseBean2.setValue(strOptString2);
                    JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("props");
                    FormProps formProps2 = new FormProps(false, false, false, null, false, false, false, null, 0, false, false, false, false, 0, false, 0, 0, null, 0, null, null, 2097151, null);
                    if (jSONObjectOptJSONObject3 != null) {
                        ArrayList arrayList3 = new ArrayList();
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject3.optJSONArray("options");
                        if (jSONArrayOptJSONArray3 != null) {
                            int length4 = jSONArrayOptJSONArray3.length();
                            for (int i10 = 0; i10 < length4; i10++) {
                                String itemOptionStr = jSONArrayOptJSONArray3.optString(i10, "");
                                Intrinsics.checkNotNullExpressionValue(itemOptionStr, "itemOptionStr");
                                arrayList3.add(itemOptionStr);
                            }
                            formProps2.getOptions().addAll(arrayList3);
                        }
                    }
                    formBaseBean2.setProps(formProps2);
                    arrayList.add(formBaseBean2);
                }
            } else {
                jSONArray = jSONArray2;
                i = length;
                i2 = i3;
                FormBaseBean formBaseBean3 = new FormBaseBean(false, null, 0, null, null, null, null, null, null, null, null, 0, 0, null, null, false, null, 131071, null);
                String name2 = jSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.NAME);
                String title2 = jSONObject.optString("title");
                String id2 = jSONObject.optString("id");
                String strOptString3 = jSONObject.optString("value");
                formBaseBean3.setKit(false);
                Intrinsics.checkNotNullExpressionValue(name2, "name");
                formBaseBean3.setName(name2);
                Intrinsics.checkNotNullExpressionValue(title2, "title");
                formBaseBean3.setTitle(title2);
                Intrinsics.checkNotNullExpressionValue(id2, "id");
                formBaseBean3.setId(id2);
                formBaseBean3.setValue(strOptString3);
                JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("props");
                FormProps formProps3 = new FormProps(false, false, false, null, false, false, false, null, 0, false, false, false, false, 0, false, 0, 0, null, 0, null, null, 2097151, null);
                if (jSONObjectOptJSONObject4 != null) {
                    ArrayList arrayList4 = new ArrayList();
                    JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject4.optJSONArray("options");
                    if (jSONArrayOptJSONArray4 != null) {
                        int length5 = jSONArrayOptJSONArray4.length();
                        for (int i11 = 0; i11 < length5; i11++) {
                            String itemOptionStr2 = jSONArrayOptJSONArray4.optString(i11, "");
                            Intrinsics.checkNotNullExpressionValue(itemOptionStr2, "itemOptionStr");
                            arrayList4.add(itemOptionStr2);
                        }
                        formProps3.getOptions().addAll(arrayList4);
                    }
                }
                formBaseBean3.setProps(formProps3);
                arrayList.add(formBaseBean3);
            }
            i3 = i2 + 1;
            leaveDetailDialog = this;
            jSONArray2 = jSONArray;
            length = i;
        }
        return arrayList;
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
            if (ScreenUtils.isPortrait()) {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.46d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.45d);
            } else {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.3d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.8d);
            }
            window.setAttributes(attributes);
        }
    }

    public final void setCallBack(StringListener cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.listener = cb;
    }
}
