package com.yd.android_brand_mvp.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.FormFlowAdapter;
import com.yd.android_brand_mvp.adapter.userspace.FormDetailContentAdapter;
import com.yd.android_brand_mvp.databinding.DialogFormDetailBinding;
import com.yd.android_brand_mvp.listener.StringListener;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.collect.FormProps;
import com.yd.android_brand_mvp.model.userspace.LeaveDetailBean;
import com.yd.android_brand_mvp.model.userspace.LeaveTypeBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FormDetailDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\u001a\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0002J\u000e\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006+"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/FormDetailDialog;", "Landroidx/fragment/app/DialogFragment;", "title", "", "data", "Lcom/yd/android_brand_mvp/model/userspace/LeaveDetailBean;", "isCanUpdate", "", "(Ljava/lang/String;Lcom/yd/android_brand_mvp/model/userspace/LeaveDetailBean;Z)V", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogFormDetailBinding;", "contentAdapter", "Lcom/yd/android_brand_mvp/adapter/userspace/FormDetailContentAdapter;", "getData", "()Lcom/yd/android_brand_mvp/model/userspace/LeaveDetailBean;", "()Z", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yd/android_brand_mvp/listener/StringListener;", "nodeAdapter", "Lcom/yd/android_brand_mvp/adapter/FormFlowAdapter;", "getTitle", "()Ljava/lang/String;", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onStart", "onViewCreated", "view", "parseJsonData", "", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "setCallBack", "cb", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormDetailDialog extends DialogFragment {
    private DialogFormDetailBinding binding;
    private final FormDetailContentAdapter contentAdapter;
    private final LeaveDetailBean data;
    private final boolean isCanUpdate;
    private StringListener listener;
    private final FormFlowAdapter nodeAdapter;
    private final String title;

    public /* synthetic */ FormDetailDialog(String str, LeaveDetailBean leaveDetailBean, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, leaveDetailBean, (i & 4) != 0 ? true : z);
    }

    public final LeaveDetailBean getData() {
        return this.data;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: isCanUpdate, reason: from getter */
    public final boolean getIsCanUpdate() {
        return this.isCanUpdate;
    }

    public FormDetailDialog(String title, LeaveDetailBean data, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(data, "data");
        this.title = title;
        this.data = data;
        this.isCanUpdate = z;
        this.nodeAdapter = new FormFlowAdapter();
        this.contentAdapter = new FormDetailContentAdapter();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogFormDetailBinding dialogFormDetailBindingInflate = DialogFormDetailBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogFormDetailBindingInflate, "inflate(inflater, container, false)");
        this.binding = dialogFormDetailBindingInflate;
        if (dialogFormDetailBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFormDetailBindingInflate = null;
        }
        ConstraintLayout root = dialogFormDetailBindingInflate.getRoot();
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
        int oldStatus;
        DialogFormDetailBinding dialogFormDetailBinding;
        DialogFormDetailBinding dialogFormDetailBinding2 = this.binding;
        if (dialogFormDetailBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFormDetailBinding2 = null;
        }
        dialogFormDetailBinding2.tvDialogLeaveDetailTitle.setText(this.title);
        DialogFormDetailBinding dialogFormDetailBinding3 = this.binding;
        if (dialogFormDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFormDetailBinding3 = null;
        }
        dialogFormDetailBinding3.tvDialogLeaveDetailName.setText(this.data.getTitle());
        DialogFormDetailBinding dialogFormDetailBinding4 = this.binding;
        if (dialogFormDetailBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFormDetailBinding4 = null;
        }
        dialogFormDetailBinding4.tvDialogLeaveDetailSubmitTime.setText(this.data.getPromoterTime());
        DialogFormDetailBinding dialogFormDetailBinding5 = this.binding;
        if (dialogFormDetailBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFormDetailBinding5 = null;
        }
        dialogFormDetailBinding5.rvDialogLeaveDetailContent.setLayoutManager(new LinearLayoutManager(requireContext()));
        DialogFormDetailBinding dialogFormDetailBinding6 = this.binding;
        if (dialogFormDetailBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFormDetailBinding6 = null;
        }
        dialogFormDetailBinding6.rvDialogLeaveDetailContent.setAdapter(this.contentAdapter);
        this.contentAdapter.setList(parseJsonData());
        if (Intrinsics.areEqual(this.data.getNewProcType(), "3")) {
            DialogFormDetailBinding dialogFormDetailBinding7 = this.binding;
            if (dialogFormDetailBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding7 = null;
            }
            TextView textView = dialogFormDetailBinding7.tvDialogLeaveDetailNewStatus;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvDialogLeaveDetailNewStatus");
            SimpleUtilsKt.remove(textView);
            oldStatus = this.data.getStatus();
        } else {
            DialogFormDetailBinding dialogFormDetailBinding8 = this.binding;
            if (dialogFormDetailBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding8 = null;
            }
            dialogFormDetailBinding8.tvDialogLeaveDetailNewStatus.setText(this.data.getStatusCode());
            int oldStatus2 = this.data.getOldStatus();
            if (oldStatus2 == 0) {
                DialogFormDetailBinding dialogFormDetailBinding9 = this.binding;
                if (dialogFormDetailBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding9 = null;
                }
                dialogFormDetailBinding9.tvDialogLeaveDetailNewStatus.setTextColor(SimpleUtilsKt.asColor(R.color.red_FD4F45));
            } else if (oldStatus2 == 1) {
                DialogFormDetailBinding dialogFormDetailBinding10 = this.binding;
                if (dialogFormDetailBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding10 = null;
                }
                dialogFormDetailBinding10.tvDialogLeaveDetailNewStatus.setTextColor(SimpleUtilsKt.asColor(R.color.yellow5));
            } else if (oldStatus2 == 2) {
                DialogFormDetailBinding dialogFormDetailBinding11 = this.binding;
                if (dialogFormDetailBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding11 = null;
                }
                dialogFormDetailBinding11.tvDialogLeaveDetailNewStatus.setTextColor(SimpleUtilsKt.asColor(R.color.blue12));
            } else if (oldStatus2 == 3) {
                DialogFormDetailBinding dialogFormDetailBinding12 = this.binding;
                if (dialogFormDetailBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding12 = null;
                }
                dialogFormDetailBinding12.tvDialogLeaveDetailNewStatus.setTextColor(SimpleUtilsKt.asColor(R.color.color_999999));
            } else {
                DialogFormDetailBinding dialogFormDetailBinding13 = this.binding;
                if (dialogFormDetailBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding13 = null;
                }
                dialogFormDetailBinding13.tvDialogLeaveDetailNewStatus.setTextColor(SimpleUtilsKt.asColor(R.color.color_999999));
            }
            oldStatus = this.data.getOldStatus();
        }
        if (!this.isCanUpdate) {
            DialogFormDetailBinding dialogFormDetailBinding14 = this.binding;
            if (dialogFormDetailBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding14 = null;
            }
            Button button = dialogFormDetailBinding14.btnDialogLeaveDetailRevoke;
            Intrinsics.checkNotNullExpressionValue(button, "binding.btnDialogLeaveDetailRevoke");
            SimpleUtilsKt.show(button);
            DialogFormDetailBinding dialogFormDetailBinding15 = this.binding;
            if (dialogFormDetailBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding15 = null;
            }
            Group group = dialogFormDetailBinding15.groupButtonWithModify;
            Intrinsics.checkNotNullExpressionValue(group, "binding.groupButtonWithModify");
            SimpleUtilsKt.remove(group);
            if (oldStatus == 0) {
                DialogFormDetailBinding dialogFormDetailBinding16 = this.binding;
                if (dialogFormDetailBinding16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding16 = null;
                }
                dialogFormDetailBinding16.tvDialogLeaveDetailStatus.setText("审批拒绝");
                DialogFormDetailBinding dialogFormDetailBinding17 = this.binding;
                if (dialogFormDetailBinding17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding17 = null;
                }
                dialogFormDetailBinding17.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.bg_red_r20);
            } else if (oldStatus == 1) {
                DialogFormDetailBinding dialogFormDetailBinding18 = this.binding;
                if (dialogFormDetailBinding18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding18 = null;
                }
                dialogFormDetailBinding18.tvDialogLeaveDetailStatus.setText("处理中");
                DialogFormDetailBinding dialogFormDetailBinding19 = this.binding;
                if (dialogFormDetailBinding19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding19 = null;
                }
                dialogFormDetailBinding19.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.bg_yellow_c328_r20);
            } else if (oldStatus == 2) {
                DialogFormDetailBinding dialogFormDetailBinding20 = this.binding;
                if (dialogFormDetailBinding20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding20 = null;
                }
                dialogFormDetailBinding20.tvDialogLeaveDetailStatus.setText("审批通过");
                DialogFormDetailBinding dialogFormDetailBinding21 = this.binding;
                if (dialogFormDetailBinding21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding21 = null;
                }
                dialogFormDetailBinding21.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.bg_purple20);
            } else if (oldStatus == 3) {
                DialogFormDetailBinding dialogFormDetailBinding22 = this.binding;
                if (dialogFormDetailBinding22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding22 = null;
                }
                dialogFormDetailBinding22.tvDialogLeaveDetailStatus.setText("审批撤销");
                DialogFormDetailBinding dialogFormDetailBinding23 = this.binding;
                if (dialogFormDetailBinding23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding23 = null;
                }
                dialogFormDetailBinding23.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.ask_for_leave_status_gary_shape);
            } else {
                DialogFormDetailBinding dialogFormDetailBinding24 = this.binding;
                if (dialogFormDetailBinding24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding24 = null;
                }
                dialogFormDetailBinding24.tvDialogLeaveDetailStatus.setText("未知");
                DialogFormDetailBinding dialogFormDetailBinding25 = this.binding;
                if (dialogFormDetailBinding25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding25 = null;
                }
                dialogFormDetailBinding25.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_0);
            }
        } else if (oldStatus == 0) {
            DialogFormDetailBinding dialogFormDetailBinding26 = this.binding;
            if (dialogFormDetailBinding26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding26 = null;
            }
            dialogFormDetailBinding26.tvDialogLeaveDetailStatus.setText("审批拒绝");
            DialogFormDetailBinding dialogFormDetailBinding27 = this.binding;
            if (dialogFormDetailBinding27 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding27 = null;
            }
            dialogFormDetailBinding27.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.bg_red_r20);
            DialogFormDetailBinding dialogFormDetailBinding28 = this.binding;
            if (dialogFormDetailBinding28 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding28 = null;
            }
            Button button2 = dialogFormDetailBinding28.btnDialogLeaveDetailRevoke;
            Intrinsics.checkNotNullExpressionValue(button2, "binding.btnDialogLeaveDetailRevoke");
            SimpleUtilsKt.show(button2);
            DialogFormDetailBinding dialogFormDetailBinding29 = this.binding;
            if (dialogFormDetailBinding29 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding29 = null;
            }
            Group group2 = dialogFormDetailBinding29.groupButtonWithModify;
            Intrinsics.checkNotNullExpressionValue(group2, "binding.groupButtonWithModify");
            SimpleUtilsKt.remove(group2);
        } else if (oldStatus == 1) {
            DialogFormDetailBinding dialogFormDetailBinding30 = this.binding;
            if (dialogFormDetailBinding30 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding30 = null;
            }
            dialogFormDetailBinding30.tvDialogLeaveDetailStatus.setText("处理中");
            DialogFormDetailBinding dialogFormDetailBinding31 = this.binding;
            if (dialogFormDetailBinding31 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding31 = null;
            }
            dialogFormDetailBinding31.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.bg_yellow_c328_r20);
            DialogFormDetailBinding dialogFormDetailBinding32 = this.binding;
            if (dialogFormDetailBinding32 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding32 = null;
            }
            Button button3 = dialogFormDetailBinding32.btnDialogLeaveDetailRevoke;
            Intrinsics.checkNotNullExpressionValue(button3, "binding.btnDialogLeaveDetailRevoke");
            SimpleUtilsKt.show(button3);
            DialogFormDetailBinding dialogFormDetailBinding33 = this.binding;
            if (dialogFormDetailBinding33 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding33 = null;
            }
            Group group3 = dialogFormDetailBinding33.groupButtonWithModify;
            Intrinsics.checkNotNullExpressionValue(group3, "binding.groupButtonWithModify");
            SimpleUtilsKt.remove(group3);
        } else if (oldStatus == 2) {
            DialogFormDetailBinding dialogFormDetailBinding34 = this.binding;
            if (dialogFormDetailBinding34 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding34 = null;
            }
            dialogFormDetailBinding34.tvDialogLeaveDetailStatus.setText("审批通过");
            DialogFormDetailBinding dialogFormDetailBinding35 = this.binding;
            if (dialogFormDetailBinding35 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding35 = null;
            }
            dialogFormDetailBinding35.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.bg_purple20);
            if (this.data.getStatus() == 2 || this.data.getStatus() == 0) {
                DialogFormDetailBinding dialogFormDetailBinding36 = this.binding;
                if (dialogFormDetailBinding36 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding36 = null;
                }
                Button button4 = dialogFormDetailBinding36.btnDialogLeaveDetailRevoke;
                Intrinsics.checkNotNullExpressionValue(button4, "binding.btnDialogLeaveDetailRevoke");
                SimpleUtilsKt.remove(button4);
                DialogFormDetailBinding dialogFormDetailBinding37 = this.binding;
                if (dialogFormDetailBinding37 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding37 = null;
                }
                Group group4 = dialogFormDetailBinding37.groupButtonWithModify;
                Intrinsics.checkNotNullExpressionValue(group4, "binding.groupButtonWithModify");
                SimpleUtilsKt.show(group4);
            } else {
                DialogFormDetailBinding dialogFormDetailBinding38 = this.binding;
                if (dialogFormDetailBinding38 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding38 = null;
                }
                Button button5 = dialogFormDetailBinding38.btnDialogLeaveDetailRevoke;
                Intrinsics.checkNotNullExpressionValue(button5, "binding.btnDialogLeaveDetailRevoke");
                SimpleUtilsKt.show(button5);
                DialogFormDetailBinding dialogFormDetailBinding39 = this.binding;
                if (dialogFormDetailBinding39 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogFormDetailBinding39 = null;
                }
                Group group5 = dialogFormDetailBinding39.groupButtonWithModify;
                Intrinsics.checkNotNullExpressionValue(group5, "binding.groupButtonWithModify");
                SimpleUtilsKt.remove(group5);
            }
        } else if (oldStatus == 3) {
            DialogFormDetailBinding dialogFormDetailBinding40 = this.binding;
            if (dialogFormDetailBinding40 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding40 = null;
            }
            dialogFormDetailBinding40.tvDialogLeaveDetailStatus.setText("审批撤销");
            DialogFormDetailBinding dialogFormDetailBinding41 = this.binding;
            if (dialogFormDetailBinding41 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding41 = null;
            }
            dialogFormDetailBinding41.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.ask_for_leave_status_gary_shape);
            DialogFormDetailBinding dialogFormDetailBinding42 = this.binding;
            if (dialogFormDetailBinding42 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding42 = null;
            }
            Button button6 = dialogFormDetailBinding42.btnDialogLeaveDetailRevoke;
            Intrinsics.checkNotNullExpressionValue(button6, "binding.btnDialogLeaveDetailRevoke");
            SimpleUtilsKt.remove(button6);
            DialogFormDetailBinding dialogFormDetailBinding43 = this.binding;
            if (dialogFormDetailBinding43 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding43 = null;
            }
            Group group6 = dialogFormDetailBinding43.groupButtonWithModify;
            Intrinsics.checkNotNullExpressionValue(group6, "binding.groupButtonWithModify");
            SimpleUtilsKt.remove(group6);
        } else {
            DialogFormDetailBinding dialogFormDetailBinding44 = this.binding;
            if (dialogFormDetailBinding44 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding44 = null;
            }
            dialogFormDetailBinding44.tvDialogLeaveDetailStatus.setText("未知");
            DialogFormDetailBinding dialogFormDetailBinding45 = this.binding;
            if (dialogFormDetailBinding45 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding45 = null;
            }
            dialogFormDetailBinding45.tvDialogLeaveDetailStatus.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_0);
            DialogFormDetailBinding dialogFormDetailBinding46 = this.binding;
            if (dialogFormDetailBinding46 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding46 = null;
            }
            Button button7 = dialogFormDetailBinding46.btnDialogLeaveDetailRevoke;
            Intrinsics.checkNotNullExpressionValue(button7, "binding.btnDialogLeaveDetailRevoke");
            SimpleUtilsKt.remove(button7);
            DialogFormDetailBinding dialogFormDetailBinding47 = this.binding;
            if (dialogFormDetailBinding47 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFormDetailBinding47 = null;
            }
            Group group7 = dialogFormDetailBinding47.groupButtonWithModify;
            Intrinsics.checkNotNullExpressionValue(group7, "binding.groupButtonWithModify");
            SimpleUtilsKt.remove(group7);
        }
        DialogFormDetailBinding dialogFormDetailBinding48 = this.binding;
        if (dialogFormDetailBinding48 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFormDetailBinding48 = null;
        }
        dialogFormDetailBinding48.rvDialogLeaveDetailProcess.setLayoutManager(new LinearLayoutManager(requireContext()));
        DialogFormDetailBinding dialogFormDetailBinding49 = this.binding;
        if (dialogFormDetailBinding49 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFormDetailBinding49 = null;
        }
        dialogFormDetailBinding49.rvDialogLeaveDetailProcess.setAdapter(this.nodeAdapter);
        this.nodeAdapter.setList(this.data.getProcFlowElementList());
        DialogFormDetailBinding dialogFormDetailBinding50 = this.binding;
        if (dialogFormDetailBinding50 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFormDetailBinding50 = null;
        }
        dialogFormDetailBinding50.btnDialogLeaveDetailRevoke.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$FormDetailDialog$CUac6X0DkW0tpvcF72J8Phq8i94
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormDetailDialog.initView$lambda$0(this.f$0, view);
            }
        });
        DialogFormDetailBinding dialogFormDetailBinding51 = this.binding;
        if (dialogFormDetailBinding51 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFormDetailBinding51 = null;
        }
        dialogFormDetailBinding51.btnDialogFormDetailRevoke.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$FormDetailDialog$eU6xXpZg-pZTJno11veVD2BHN0M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormDetailDialog.initView$lambda$1(this.f$0, view);
            }
        });
        DialogFormDetailBinding dialogFormDetailBinding52 = this.binding;
        if (dialogFormDetailBinding52 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFormDetailBinding = null;
        } else {
            dialogFormDetailBinding = dialogFormDetailBinding52;
        }
        dialogFormDetailBinding.btnDialogFormDetailModify.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$FormDetailDialog$PxQTSe5Bk6RPe4S0_V_5y2Da5WU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormDetailDialog.initView$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(FormDetailDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringListener stringListener = this$0.listener;
        if (stringListener != null) {
            stringListener.getStringData("revoke");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(FormDetailDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringListener stringListener = this$0.listener;
        if (stringListener != null) {
            stringListener.getStringData("revoke");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(FormDetailDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringListener stringListener = this$0.listener;
        if (stringListener != null) {
            stringListener.getStringData("modify");
        }
    }

    private final List<FormBaseBean> parseJsonData() throws JSONException {
        JSONArray jSONArray;
        int i;
        int i2;
        FormDetailDialog formDetailDialog = this;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray2 = new JSONArray(formDetailDialog.data.getJsonData());
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
                                    AppExtKt.logd(formDetailDialog, sb.toString());
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
                                    formDetailDialog = this;
                                    jSONArrayOptJSONArray2 = jSONArray5;
                                    length3 = i9;
                                }
                                formProps.getOptions().addAll(arrayList2);
                            }
                        }
                        formBaseBean.setProps(formProps);
                        arrayList.add(formBaseBean);
                        i4++;
                        formDetailDialog = this;
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
            formDetailDialog = this;
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

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        StringListener stringListener = this.listener;
        if (stringListener != null) {
            stringListener.getStringData("dismiss");
        }
    }
}
