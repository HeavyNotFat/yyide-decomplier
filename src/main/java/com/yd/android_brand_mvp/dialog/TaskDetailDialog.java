package com.yd.android_brand_mvp.dialog;

import android.app.Activity;
import android.app.Dialog;
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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.databinding.GankDialogHomeTaskDetailBinding;
import com.yd.android_brand_mvp.landscape.task.viewmodel.TaskDetailViewModel;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.task.MyTaskListItem;
import com.yd.android_brand_mvp.model.task.PublishScopeObjListItem;
import com.yd.android_brand_mvp.model.task.TaskVerifyBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: TaskDetailDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u001dH\u0016J\u001a\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0005R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/TaskDetailDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "clickData", "Lcom/yd/android_brand_mvp/model/task/MyTaskListItem;", "(Lcom/yd/android_brand_mvp/model/task/MyTaskListItem;)V", "binding", "Lcom/yd/android_brand_mvp/databinding/GankDialogHomeTaskDetailBinding;", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/GankDialogHomeTaskDetailBinding;", "setBinding", "(Lcom/yd/android_brand_mvp/databinding/GankDialogHomeTaskDetailBinding;)V", "data", "getData", "()Lcom/yd/android_brand_mvp/model/task/MyTaskListItem;", "setData", "jumpActivityWithResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "logoInfo", "Lcom/yd/android_brand_mvp/model/NewBrandLoginRsp$DataBean;", "getLogoInfo", "()Lcom/yd/android_brand_mvp/model/NewBrandLoginRsp$DataBean;", "logoInfo$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/task/viewmodel/TaskDetailViewModel;", "initListener", "", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "parserLastActivityData", "result", "Landroidx/activity/result/ActivityResult;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TaskDetailDialog extends DialogFragment {
    public GankDialogHomeTaskDetailBinding binding;
    private MyTaskListItem data;
    private final ActivityResultLauncher<Intent> jumpActivityWithResult;

    /* JADX INFO: renamed from: logoInfo$delegate, reason: from kotlin metadata */
    private final Lazy logoInfo;
    private TaskDetailViewModel viewModel;

    public final GankDialogHomeTaskDetailBinding getBinding() {
        GankDialogHomeTaskDetailBinding gankDialogHomeTaskDetailBinding = this.binding;
        if (gankDialogHomeTaskDetailBinding != null) {
            return gankDialogHomeTaskDetailBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(GankDialogHomeTaskDetailBinding gankDialogHomeTaskDetailBinding) {
        Intrinsics.checkNotNullParameter(gankDialogHomeTaskDetailBinding, "<set-?>");
        this.binding = gankDialogHomeTaskDetailBinding;
    }

    public final MyTaskListItem getData() {
        return this.data;
    }

    public final void setData(MyTaskListItem myTaskListItem) {
        Intrinsics.checkNotNullParameter(myTaskListItem, "<set-?>");
        this.data = myTaskListItem;
    }

    private final NewBrandLoginRsp.DataBean getLogoInfo() {
        return (NewBrandLoginRsp.DataBean) this.logoInfo.getValue();
    }

    public TaskDetailDialog() {
        this.data = new MyTaskListItem(null, null, null, null, null, false, null, null, null, 0, 0, null, null, null, null, false, null, null, 262143, null);
        this.logoInfo = LazyKt.lazy(new Function0<NewBrandLoginRsp.DataBean>() { // from class: com.yd.android_brand_mvp.dialog.TaskDetailDialog$logoInfo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NewBrandLoginRsp.DataBean invoke() {
                return SpData.NewUser().data;
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$TaskDetailDialog$FJxUuKVFHNu5NNmtbkB3Y3HB6CM
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                TaskDetailDialog.jumpActivityWithResult$lambda$4(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ityData(result)\n        }");
        this.jumpActivityWithResult = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskDetailDialog(MyTaskListItem clickData) {
        this();
        Intrinsics.checkNotNullParameter(clickData, "clickData");
        this.data = clickData;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        GankDialogHomeTaskDetailBinding gankDialogHomeTaskDetailBindingInflate = GankDialogHomeTaskDetailBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(gankDialogHomeTaskDetailBindingInflate, "inflate(inflater, container, false)");
        setBinding(gankDialogHomeTaskDetailBindingInflate);
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
        TaskDetailViewModel taskDetailViewModel = (TaskDetailViewModel) new ViewModelProvider(this).get(TaskDetailViewModel.class);
        this.viewModel = taskDetailViewModel;
        Object obj = null;
        if (taskDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            taskDetailViewModel = null;
        }
        final Function1<Result<? extends String>, Unit> function1 = new Function1<Result<? extends String>, Unit>() { // from class: com.yd.android_brand_mvp.dialog.TaskDetailDialog.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends String> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends String> it2) {
                String message;
                TaskDetailDialog.this.dismiss();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m597isFailureimpl(it2.getValue())) {
                    Throwable thM594exceptionOrNullimpl = Result.m594exceptionOrNullimpl(it2.getValue());
                    if (thM594exceptionOrNullimpl == null || (message = thM594exceptionOrNullimpl.getMessage()) == null) {
                        message = "打卡失败";
                    }
                } else {
                    message = "打卡成功";
                }
                new MessageTipDialog(message).show(TaskDetailDialog.this.getParentFragmentManager(), "messageTip");
            }
        };
        taskDetailViewModel.getSignResult().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$TaskDetailDialog$e23J3x3bTHYjg8cohuptDk9kKPU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj2) {
                TaskDetailDialog.initView$lambda$0(function1, obj2);
            }
        });
        getBinding().tvDialogHomeTaskDetailTitle.setText(this.data.getTaskName());
        StringBuilder sb = new StringBuilder();
        if (!this.data.getSubjectList().isEmpty()) {
            for (Object obj2 : this.data.getSubjectList()) {
                if (Intrinsics.areEqual((String) obj2, "不限")) {
                    obj = obj2;
                    break;
                }
            }
            if (obj == null) {
                Iterator<T> it2 = this.data.getSubjectList().iterator();
                while (it2.hasNext()) {
                    sb.append((String) it2.next());
                    sb.append(" ");
                }
            }
        }
        TextView textView = getBinding().tvDialogHomeTaskDetailSubTitle;
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        sb2.append((Object) sb);
        sb2.append(')');
        textView.setText(sb2.toString());
        getBinding().tvDialogHomeTaskDetailDesc.setText(this.data.getTaskDescription());
        StringBuilder sb3 = new StringBuilder();
        int i = 0;
        for (Object obj3 : this.data.getPublishScopeObjList()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            PublishScopeObjListItem publishScopeObjListItem = (PublishScopeObjListItem) obj3;
            if (i == this.data.getPublishScopeObjList().size() - 1) {
                sb3.append(publishScopeObjListItem.getName());
            } else {
                sb3.append(publishScopeObjListItem.getName());
                sb3.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            }
            i = i2;
        }
        getBinding().tvDialogHomeTaskDetailRange.setText(sb3.toString());
        getBinding().tvDialogTaskDetailStartDate.setText(this.data.getPublishStart());
        getBinding().tvDialogTaskDetailEndDate.setText(this.data.getPublishEnd());
        getBinding().tvDialogTaskDetailRate.setText(this.data.getFrequency());
        if (!this.data.getRequirementList().isEmpty()) {
            getBinding().tvDialogTaskDetailRequire.setText("提交时必须包含图片");
            return;
        }
        TextView textView2 = getBinding().tvTaskDetailRequireTitle;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvTaskDetailRequireTitle");
        SimpleUtilsKt.remove(textView2);
        TextView textView3 = getBinding().tvDialogTaskDetailRequire;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvDialogTaskDetailRequire");
        SimpleUtilsKt.remove(textView3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpActivityWithResult$lambda$4(TaskDetailDialog this$0, ActivityResult result) {
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
        if (Intrinsics.areEqual(stringExtra, ResultCodeStr.TASK_SIGN_VERIFY)) {
            Intent data2 = result.getData();
            TaskDetailViewModel taskDetailViewModel = null;
            TaskVerifyBean taskVerifyBean = data2 != null ? (TaskVerifyBean) data2.getParcelableExtra(ResultCodeStr.TASK_SIGN_VERIFY_SUCCESS) : null;
            if (taskVerifyBean == null) {
                dismiss();
                return;
            }
            if (!Intrinsics.areEqual(taskVerifyBean.getClassesId(), getLogoInfo().classesId)) {
                ToastUtil.showBottomView((Activity) getActivity(), "不是本班学生");
                return;
            }
            TaskDetailViewModel taskDetailViewModel2 = this.viewModel;
            if (taskDetailViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                taskDetailViewModel = taskDetailViewModel2;
            }
            taskDetailViewModel.signTask(this.data.getId(), taskVerifyBean.getUserId(), taskVerifyBean.getSchoolId());
        }
    }

    private final void initListener() {
        getBinding().btnActivitySignTaskSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$TaskDetailDialog$vhPsPuDEXqDrZ9-bt8e4SNFu2oc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskDetailDialog.initListener$lambda$6(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$6(TaskDetailDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StudentCheackActivity.startGo(this$0.requireContext(), this$0.jumpActivityWithResult);
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
            attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.4d);
            attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.5d);
            window.setAttributes(attributes);
        }
    }
}
