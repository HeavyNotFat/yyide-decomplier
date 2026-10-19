package com.yd.android_brand_mvp.landscape.exam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.blankj.utilcode.util.SizeUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.exam.ExamArrangementActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.databinding.FragmentHomeExamArrangementBinding;
import com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel;
import com.yd.android_brand_mvp.model.exam.ExamInvigilatorBean;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.model.task.TaskVerifyBean;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ExamArrangement24Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u001a\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/ExamArrangement24Fragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHomeExamArrangementBinding;", "()V", "current", "", "examList", "", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "jumpActivityWithResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "sourceTimeFormat", "", "targetTimeFormat", "timerTimeSecond", "totalCount", "type", "viewModel", "Lcom/yd/android_brand_mvp/landscape/exam/viewmodel/ExamArrangementViewModel;", "UpdataEvent", "", "id", "initView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parserLastActivityData", "result", "Landroidx/activity/result/ActivityResult;", "request", "setUiData", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamArrangement24Fragment extends KTBaseFragment<FragmentHomeExamArrangementBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int current;
    private final List<ExamPlanItem> examList;
    private final ActivityResultLauncher<Intent> jumpActivityWithResult;
    private final String sourceTimeFormat;
    private final String targetTimeFormat;
    private final int timerTimeSecond;
    private int totalCount;
    private String type;
    private ExamArrangementViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.ExamArrangement24Fragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExamArrangement24Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHomeExamArrangementBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHomeExamArrangementBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHomeExamArrangementBinding;", 0);
        }

        public final FragmentHomeExamArrangementBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHomeExamArrangementBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHomeExamArrangementBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentHomeExamArrangementBinding access$getBinding(ExamArrangement24Fragment examArrangement24Fragment) {
        return examArrangement24Fragment.getBinding();
    }

    public ExamArrangement24Fragment() {
        super(AnonymousClass1.INSTANCE);
        this.examList = new ArrayList();
        this.totalCount = 1;
        this.current = 1;
        this.timerTimeSecond = 120;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement24Fragment$zPKyBbS2DEKbuS7aEIVoIpmb4Pw
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ExamArrangement24Fragment.jumpActivityWithResult$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ityData(result)\n        }");
        this.jumpActivityWithResult = activityResultLauncherRegisterForActivityResult;
        this.sourceTimeFormat = "yyyy-MM-dd HH:mm:ss";
        this.targetTimeFormat = "HH:mm";
    }

    /* JADX INFO: compiled from: ExamArrangement24Fragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/ExamArrangement24Fragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type) {
            ExamArrangement24Fragment examArrangement24Fragment = new ExamArrangement24Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            examArrangement24Fragment.setArguments(bundle);
            return examArrangement24Fragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpActivityWithResult$lambda$0(ExamArrangement24Fragment this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.parserLastActivityData(result);
    }

    private final void parserLastActivityData(ActivityResult result) {
        Intent data;
        TaskVerifyBean taskVerifyBean;
        if (result.getResultCode() != -1 || (data = result.getData()) == null) {
            return;
        }
        String stringExtra = data.getStringExtra(ResultCodeStr.NORMAL_TYPE_CODE);
        if (stringExtra == null) {
            stringExtra = "";
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra, "resultData.getStringExtr…r.NORMAL_TYPE_CODE) ?: \"\"");
        if ((stringExtra.length() == 0) || !Intrinsics.areEqual(stringExtra, ResultCodeStr.TASK_SIGN_VERIFY) || (taskVerifyBean = (TaskVerifyBean) data.getParcelableExtra(ResultCodeStr.TASK_SIGN_VERIFY_SUCCESS)) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(taskVerifyBean, "resultData.getParcelable…VERIFY_SUCCESS) ?: return");
        AppExtKt.logd(this, "验证成功");
        if (this.current > this.examList.size()) {
            return;
        }
        ExamPlanItem examPlanItem = this.examList.get(this.current - 1);
        AppExtKt.logd(this, "verify current = " + this.current);
        ExamArrangementViewModel examArrangementViewModel = this.viewModel;
        if (examArrangementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            examArrangementViewModel = null;
        }
        examArrangementViewModel.signInExam(taskVerifyBean.getUserId(), examPlanItem.getSiteId(), examPlanItem.getSubjectId(), examPlanItem.getExaminationId());
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.viewModel = (ExamArrangementViewModel) new ViewModelProvider(this).get(ExamArrangementViewModel.class);
        Bundle arguments = getArguments();
        String str = null;
        String string = arguments != null ? arguments.getString("type") : null;
        if (string == null) {
            string = "hbksgl24";
        }
        this.type = string;
        if (string == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
        } else {
            str = string;
        }
        if (Intrinsics.areEqual(str, "hbksgl24")) {
            getBinding().clFragmentExamArrangement.getLayoutParams().width = SizeUtils.dp2px(444.0f);
            getBinding().clFragmentExamArrangement.getLayoutParams().height = SizeUtils.dp2px(604.0f);
        } else if (Intrinsics.areEqual(str, "sbksgl43")) {
            getBinding().clFragmentExamArrangement.getLayoutParams().width = SizeUtils.dp2px(660.0f);
            getBinding().clFragmentExamArrangement.getLayoutParams().height = SizeUtils.dp2px(646.0f);
        }
        initView();
    }

    private final void initView() {
        getBinding().topFragmentExamArrangement.title.setText("考试安排");
        getBinding().topFragmentExamArrangement.llTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement24Fragment$0SPeP25eRjTSZ6SmhWlaQCJyVqY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamArrangement24Fragment.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().tvFragmentExamArrangementNext.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement24Fragment$-EU1mQtJXX66DjrQ4Dne5P7Zvmc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamArrangement24Fragment.initView$lambda$3(this.f$0, view);
            }
        });
        getBinding().tvFragmentExamArrangementPre.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement24Fragment$r2t7I5SnyEVmN0JQUoLneB5o4zg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamArrangement24Fragment.initView$lambda$4(this.f$0, view);
            }
        });
        getBinding().btnFragmentExamSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement24Fragment$eXELyGSGNp6PDRXaCbtGlyKzatU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamArrangement24Fragment.initView$lambda$5(this.f$0, view);
            }
        });
        ExamArrangementViewModel examArrangementViewModel = this.viewModel;
        ExamArrangementViewModel examArrangementViewModel2 = null;
        if (examArrangementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            examArrangementViewModel = null;
        }
        LiveData<Result<List<ExamPlanItem>>> bannerExam = examArrangementViewModel.getBannerExam();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends ExamPlanItem>>, Unit> function1 = new Function1<Result<? extends List<? extends ExamPlanItem>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement24Fragment.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends ExamPlanItem>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends ExamPlanItem>> it2) {
                ExamArrangement24Fragment.this.examList.clear();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                List list = (List) value;
                List list2 = list;
                if (!(list2 == null || list2.isEmpty())) {
                    ExamArrangement24Fragment.this.current = 1;
                    ViewStub viewStub = ExamArrangement24Fragment.access$getBinding(ExamArrangement24Fragment.this).emptyView;
                    Intrinsics.checkNotNullExpressionValue(viewStub, "binding.emptyView");
                    viewStub.setVisibility(8);
                    AppExtKt.logd(ExamArrangement24Fragment.this, "size = " + list.size());
                    ExamArrangement24Fragment.this.examList.addAll(list2);
                    ExamArrangement24Fragment.this.setUiData();
                    return;
                }
                ViewStub viewStub2 = ExamArrangement24Fragment.access$getBinding(ExamArrangement24Fragment.this).emptyView;
                Intrinsics.checkNotNullExpressionValue(viewStub2, "binding.emptyView");
                viewStub2.setVisibility(0);
            }
        };
        bannerExam.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement24Fragment$iMzVvU-Kp42snIoUVcHFMC8vWXQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamArrangement24Fragment.initView$lambda$6(function1, obj);
            }
        });
        ExamArrangementViewModel examArrangementViewModel3 = this.viewModel;
        if (examArrangementViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            examArrangementViewModel2 = examArrangementViewModel3;
        }
        LiveData<Result<Boolean>> signInExam = examArrangementViewModel2.getSignInExam();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function2 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement24Fragment.initView.6
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
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                Boolean bool = (Boolean) value;
                if (bool == null || !bool.booleanValue()) {
                    return;
                }
                ToastUtil.showBottomView((Activity) ExamArrangement24Fragment.this.requireActivity(), "签到成功");
                MinaEventManager.getInstance().notifyObserver(MinaConstants.CODE_EXAM);
            }
        };
        signInExam.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement24Fragment$9hVMXGo6qjvjP4ciMITYTthiDag
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamArrangement24Fragment.initView$lambda$7(function2, obj);
            }
        });
        request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(ExamArrangement24Fragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) ExamArrangementActivity.class);
        String str = this$0.type;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
            str = null;
        }
        intent.putExtra("isPortrait", StringsKt.startsWith$default(str, "sb", false, 2, (Object) null));
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ExamArrangement24Fragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.current;
        if (i >= this$0.totalCount) {
            this$0.toastShow("没有下一页了");
            return;
        }
        this$0.current = i + 1;
        TextView textView = this$0.getBinding().tvFragmentExamArrangementPage;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this$0.getString(R.string.num_limit);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.num_limit)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this$0.current), Integer.valueOf(this$0.totalCount)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
        this$0.setUiData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(ExamArrangement24Fragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.current;
        if (i == 1) {
            this$0.toastShow("没有上一页了");
            return;
        }
        if (i > 1) {
            this$0.current = i - 1;
        }
        TextView textView = this$0.getBinding().tvFragmentExamArrangementPage;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this$0.getString(R.string.num_limit);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.num_limit)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this$0.current), Integer.valueOf(this$0.totalCount)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
        this$0.setUiData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(ExamArrangement24Fragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppExtKt.logd(this$0, "current = " + this$0.current);
        if (!(!this$0.examList.isEmpty()) || this$0.current > this$0.examList.size()) {
            return;
        }
        if (this$0.examList.get(this$0.current - 1).getSignIn()) {
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
    public static final void initView$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUiData() {
        this.totalCount = this.examList.size();
        TextView textView = getBinding().tvFragmentExamArrangementPage;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.num_limit);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.num_limit)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.current), Integer.valueOf(this.totalCount)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
        if (this.examList.isEmpty() || this.current > this.examList.size()) {
            return;
        }
        ExamPlanItem examPlanItem = this.examList.get(this.current - 1);
        getBinding().tvFragmentExamArrangementSubject.setText(examPlanItem.getSubjectName());
        String str2 = TimeUtil.formatTime(examPlanItem.getExamStartTime(), this.sourceTimeFormat, "yyyy-MM-dd HH:mm") + '-' + TimeUtil.formatTime(examPlanItem.getExamEndTime(), this.sourceTimeFormat, this.targetTimeFormat);
        if (Intrinsics.areEqual(str2, Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            getBinding().tvFragmentExamArrangementTime.setText("");
        } else {
            getBinding().tvFragmentExamArrangementTime.setText(str2);
        }
        getBinding().tvFragmentExamArrangementAddress.setText(examPlanItem.getExaminationRoomName() + '-' + examPlanItem.getBuildingName() + '-' + examPlanItem.getSiteName());
        TextView textView2 = getBinding().tvFragmentExamArrangementNumber;
        StringBuilder sb = new StringBuilder();
        sb.append(examPlanItem.getExaminationPersonCount());
        sb.append((char) 20154);
        textView2.setText(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        for (Object obj : examPlanItem.getInvigilators()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            sb2.append(((ExamInvigilatorBean) obj).getPersonName());
            if (i != CollectionsKt.getLastIndex(examPlanItem.getInvigilators())) {
                sb2.append("、");
            }
            i = i2;
        }
        StringBuilder sb3 = sb2;
        if (sb3.length() == 0) {
            sb2.append("无");
        }
        getBinding().tvFragmentExamArrangementTeacher.setText(sb3);
    }

    private final void request() {
        this.current = 1;
        ExamArrangementViewModel examArrangementViewModel = this.viewModel;
        if (examArrangementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            examArrangementViewModel = null;
        }
        examArrangementViewModel.getBannerExamList();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (MinaConstants.CODE_EXAM == id) {
            request();
        }
    }
}
