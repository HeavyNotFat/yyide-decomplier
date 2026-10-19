package com.yd.android_brand_mvp.dialog.evaluation;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.DialogEvaluationPointDetailsBinding;
import com.yd.android_brand_mvp.model.evaluation.EvaluationPointCardBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: EvaluationPointDetailDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u001a\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/evaluation/EvaluationPointDetailDialog;", "Landroidx/fragment/app/DialogFragment;", "data", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationPointCardBean;", "(Lcom/yd/android_brand_mvp/model/evaluation/EvaluationPointCardBean;)V", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogEvaluationPointDetailsBinding;", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/DialogEvaluationPointDetailsBinding;", "setBinding", "(Lcom/yd/android_brand_mvp/databinding/DialogEvaluationPointDetailsBinding;)V", "cb", "Lcom/yd/android_brand_mvp/dialog/evaluation/EvaluationPointDetailDialog$CallBack;", "initListener", "", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "setCallBack", "callBack", "CallBack", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EvaluationPointDetailDialog extends DialogFragment {
    public DialogEvaluationPointDetailsBinding binding;
    private CallBack cb;
    private EvaluationPointCardBean data;

    /* JADX INFO: compiled from: EvaluationPointDetailDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/evaluation/EvaluationPointDetailDialog$CallBack;", "", "clickSubmit", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void clickSubmit();
    }

    public final DialogEvaluationPointDetailsBinding getBinding() {
        DialogEvaluationPointDetailsBinding dialogEvaluationPointDetailsBinding = this.binding;
        if (dialogEvaluationPointDetailsBinding != null) {
            return dialogEvaluationPointDetailsBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogEvaluationPointDetailsBinding dialogEvaluationPointDetailsBinding) {
        Intrinsics.checkNotNullParameter(dialogEvaluationPointDetailsBinding, "<set-?>");
        this.binding = dialogEvaluationPointDetailsBinding;
    }

    public EvaluationPointDetailDialog(EvaluationPointCardBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public final void setCallBack(CallBack callBack) {
        this.cb = callBack;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogEvaluationPointDetailsBinding dialogEvaluationPointDetailsBindingInflate = DialogEvaluationPointDetailsBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogEvaluationPointDetailsBindingInflate, "inflate(inflater, container, false)");
        setBinding(dialogEvaluationPointDetailsBindingInflate);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }

    private final void initView() {
        EvaluationPointCardBean evaluationPointCardBean = this.data;
        if (evaluationPointCardBean != null) {
            getBinding().tvTitle.setText(evaluationPointCardBean.getScoreCardName());
            TextView textView = getBinding().tvPoint;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%s积分", Arrays.copyOf(new Object[]{evaluationPointCardBean.getScore()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            textView.setText(str);
            getBinding().tvStudentName.setText(evaluationPointCardBean.getPersonName());
            getBinding().tvClassesName.setText(evaluationPointCardBean.getGroupNameList().isEmpty() ^ true ? evaluationPointCardBean.getGroupNameList().get(0) : "");
            getBinding().tvRelease.setText(evaluationPointCardBean.getWriteOffStatus() == 1 ? "已核销" : "未核销");
            getBinding().tvGrantDate.setText(evaluationPointCardBean.getIssuanceTime());
            getBinding().tvDate.setText(evaluationPointCardBean.getWriteOffTime());
            GlideUtil.loadRadiusImage(getContext(), evaluationPointCardBean.getScoreCardIconUrl(), getBinding().ivIcon, R.drawable.bg_f0f2f5_30, 10);
        }
    }

    private final void initListener() {
        getBinding().tvConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.evaluation.-$$Lambda$EvaluationPointDetailDialog$_gM4Mmubk2RHjAZ4F4JLgM_2f8Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EvaluationPointDetailDialog.initListener$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(EvaluationPointDetailDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CallBack callBack = this$0.cb;
        if (callBack != null) {
            callBack.clickSubmit();
        }
        this$0.setCallBack(null);
        this$0.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
    }
}
