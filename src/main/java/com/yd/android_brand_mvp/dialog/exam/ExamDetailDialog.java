package com.yd.android_brand_mvp.dialog.exam;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.databinding.DialogExamDetailBinding;
import com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel;
import com.yd.android_brand_mvp.model.exam.ExamGroupItem;
import com.yd.android_brand_mvp.model.exam.ExamInvigilatorBean;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.model.task.TaskVerifyBean;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity;
import com.yyide.facepass.AppExtKt;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ExamDetailDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0002J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\u001a\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&H\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/exam/ExamDetailDialog;", "Landroidx/fragment/app/DialogFragment;", "data", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "portrait", "", "(Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;Z)V", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogExamDetailBinding;", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/DialogExamDetailBinding;", "setBinding", "(Lcom/yd/android_brand_mvp/databinding/DialogExamDetailBinding;)V", "isPortrait", "jumpActivityWithResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "sourceTimeFormat", "", "targetTimeFormat", "viewModel", "Lcom/yd/android_brand_mvp/landscape/exam/viewmodel/ExamArrangementViewModel;", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "parserLastActivityData", "result", "Landroidx/activity/result/ActivityResult;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamDetailDialog extends DialogFragment {
    public DialogExamDetailBinding binding;
    private ExamPlanItem data;
    private boolean isPortrait;
    private final ActivityResultLauncher<Intent> jumpActivityWithResult;
    private final String sourceTimeFormat;
    private final String targetTimeFormat;
    private ExamArrangementViewModel viewModel;

    public final DialogExamDetailBinding getBinding() {
        DialogExamDetailBinding dialogExamDetailBinding = this.binding;
        if (dialogExamDetailBinding != null) {
            return dialogExamDetailBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogExamDetailBinding dialogExamDetailBinding) {
        Intrinsics.checkNotNullParameter(dialogExamDetailBinding, "<set-?>");
        this.binding = dialogExamDetailBinding;
    }

    public ExamDetailDialog(ExamPlanItem data, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.sourceTimeFormat = "yyyy-MM-dd HH:mm:ss";
        this.targetTimeFormat = "HH:mm";
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.yd.android_brand_mvp.dialog.exam.-$$Lambda$ExamDetailDialog$GOZtuFZYuq5ei07syK3srsk6hB8
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ExamDetailDialog.jumpActivityWithResult$lambda$3(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ityData(result)\n        }");
        this.jumpActivityWithResult = activityResultLauncherRegisterForActivityResult;
        this.data = data;
        this.isPortrait = z;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogExamDetailBinding dialogExamDetailBindingInflate = DialogExamDetailBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogExamDetailBindingInflate, "inflate(inflater, container, false)");
        setBinding(dialogExamDetailBindingInflate);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.viewModel = (ExamArrangementViewModel) new ViewModelProvider(this).get(ExamArrangementViewModel.class);
        initView();
    }

    private final void initView() {
        getBinding().tvDialogExamDetailSubject.setText(this.data.getSubjectName());
        String str = TimeUtil.formatTime(this.data.getExamStartTime(), this.sourceTimeFormat, "yyyy-MM-dd HH:mm") + '-' + TimeUtil.formatTime(this.data.getExamEndTime(), this.sourceTimeFormat, this.targetTimeFormat);
        if (Intrinsics.areEqual(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            getBinding().tvDialogExamDetailTime.setText("");
        } else {
            getBinding().tvDialogExamDetailTime.setText(str);
        }
        getBinding().tvDialogExamDetailAddress.setText(this.data.getExaminationRoomName());
        if (!this.data.getGroup().isEmpty()) {
            getBinding().tvDialogExamDetailTarget.setText(((ExamGroupItem) CollectionsKt.first((List) this.data.getGroup())).getObjectName());
        } else {
            getBinding().tvDialogExamDetailTarget.setText("");
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : this.data.getInvigilators()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            sb.append(((ExamInvigilatorBean) obj).getPersonName());
            if (i != CollectionsKt.getLastIndex(this.data.getInvigilators())) {
                sb.append("、");
            }
            i = i2;
        }
        StringBuilder sb2 = sb;
        if (sb2.length() == 0) {
            sb.append("无");
        }
        getBinding().tvDialogExamDetailTeacher.setText(sb2);
        int signInPerson = this.data.getTotalPerson() == 0 ? 0 : (this.data.getSignInPerson() * 100) / this.data.getTotalPerson();
        TextView textView = getBinding().tvDialogExamDetailRate;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.rate);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.rate)");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(signInPerson);
        sb3.append('%');
        String str2 = String.format(string, Arrays.copyOf(new Object[]{sb3.toString(), Integer.valueOf(this.data.getSignInPerson()), Integer.valueOf(this.data.getTotalPerson())}, 3));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        textView.setText(str2);
        getBinding().btnFragmentExamSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.exam.-$$Lambda$ExamDetailDialog$Cz9pjALLrB73raf2DdE8uZxmlnk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamDetailDialog.initView$lambda$1(this.f$0, view);
            }
        });
        ExamArrangementViewModel examArrangementViewModel = this.viewModel;
        if (examArrangementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            examArrangementViewModel = null;
        }
        LiveData<Result<Boolean>> signInExam = examArrangementViewModel.getSignInExam();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function1 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.dialog.exam.ExamDetailDialog.initView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Boolean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends Boolean> it2) {
                ExamDetailDialog.this.dismiss();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                Boolean bool = (Boolean) value;
                if (bool == null || !bool.booleanValue()) {
                    return;
                }
                ToastUtil.showBottomView((Activity) ExamDetailDialog.this.requireActivity(), "签到成功");
                MinaEventManager.getInstance().notifyObserver(MinaConstants.CODE_EXAM);
            }
        };
        signInExam.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.dialog.exam.-$$Lambda$ExamDetailDialog$LY4pdZzTh51ZvTIVyISSjXZnH9I
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj2) {
                ExamDetailDialog.initView$lambda$2(function1, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(ExamDetailDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.data.getSignIn()) {
            StudentCheackActivity.startGo(this$0.requireContext(), this$0.jumpActivityWithResult);
            return;
        }
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String string = this$0.getString(R.string.not_need_sign_in);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.not_need_sign_in)");
        SimpleUtilsKt.showShotToast(contextRequireContext, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpActivityWithResult$lambda$3(ExamDetailDialog this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.parserLastActivityData(result);
    }

    private final void parserLastActivityData(ActivityResult result) {
        Intent data;
        if (result.getResultCode() != -1 || (data = result.getData()) == null) {
            return;
        }
        String stringExtra = data.getStringExtra(ResultCodeStr.NORMAL_TYPE_CODE);
        if (stringExtra == null) {
            stringExtra = "";
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra, "resultData.getStringExtr…r.NORMAL_TYPE_CODE) ?: \"\"");
        if (!(stringExtra.length() == 0) && Intrinsics.areEqual(stringExtra, ResultCodeStr.TASK_SIGN_VERIFY)) {
            Intent data2 = result.getData();
            ExamArrangementViewModel examArrangementViewModel = null;
            TaskVerifyBean taskVerifyBean = data2 != null ? (TaskVerifyBean) data2.getParcelableExtra(ResultCodeStr.TASK_SIGN_VERIFY_SUCCESS) : null;
            if (taskVerifyBean == null) {
                dismiss();
                return;
            }
            AppExtKt.logd(this, "验证成功");
            ExamArrangementViewModel examArrangementViewModel2 = this.viewModel;
            if (examArrangementViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                examArrangementViewModel = examArrangementViewModel2;
            }
            examArrangementViewModel.signInExam(taskVerifyBean.getUserId(), this.data.getSiteId(), this.data.getSubjectId(), this.data.getExaminationId());
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
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.46d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.32d);
            } else {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.26d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.56d);
            }
            window.setAttributes(attributes);
        }
    }
}
