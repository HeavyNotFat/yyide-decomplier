package com.yd.android_brand_mvp.activity.exam.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.exam.viewmodel.ExamArrangeViewModel;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.databinding.FragmentSimpleFullScreenExamBinding;
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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: SimpleFullScreenFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/fragment/SimpleFullScreenFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentSimpleFullScreenExamBinding;", "()V", "dataBean", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "jumpActivityWithResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "viewModel", "Lcom/yd/android_brand_mvp/activity/exam/viewmodel/ExamArrangeViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/exam/viewmodel/ExamArrangeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parserLastActivityData", "result", "Landroidx/activity/result/ActivityResult;", "request", "setUiData", "data", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SimpleFullScreenFragment extends KTBaseFragment<FragmentSimpleFullScreenExamBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ExamPlanItem dataBean;
    private final ActivityResultLauncher<Intent> jumpActivityWithResult;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.exam.fragment.SimpleFullScreenFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: SimpleFullScreenFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentSimpleFullScreenExamBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentSimpleFullScreenExamBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentSimpleFullScreenExamBinding;", 0);
        }

        public final FragmentSimpleFullScreenExamBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentSimpleFullScreenExamBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentSimpleFullScreenExamBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public SimpleFullScreenFragment() {
        super(AnonymousClass1.INSTANCE);
        final SimpleFullScreenFragment simpleFullScreenFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.SimpleFullScreenFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return simpleFullScreenFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.SimpleFullScreenFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function1 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(simpleFullScreenFragment, Reflection.getOrCreateKotlinClass(ExamArrangeViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.SimpleFullScreenFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.SimpleFullScreenFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function2 = function1;
                if (function2 != null && (creationExtras = (CreationExtras) function2.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM19viewModels$lambda1 = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM19viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM19viewModels$lambda1 : null;
                CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.SimpleFullScreenFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                ViewModelStoreOwner viewModelStoreOwnerM19viewModels$lambda1 = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM19viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM19viewModels$lambda1 : null;
                if (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) {
                    defaultViewModelProviderFactory = simpleFullScreenFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$SimpleFullScreenFragment$6cl11WB-pD7apEcG23Ufhw5fK8I
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SimpleFullScreenFragment.jumpActivityWithResult$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ityData(result)\n        }");
        this.jumpActivityWithResult = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: compiled from: SimpleFullScreenFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/fragment/SimpleFullScreenFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "data", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(ExamPlanItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
            SimpleFullScreenFragment simpleFullScreenFragment = new SimpleFullScreenFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("data", data);
            simpleFullScreenFragment.setArguments(bundle);
            return simpleFullScreenFragment;
        }
    }

    private final ExamArrangeViewModel getViewModel() {
        return (ExamArrangeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpActivityWithResult$lambda$0(SimpleFullScreenFragment this$0, ActivityResult result) {
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
        Intrinsics.checkNotNullExpressionValue(taskVerifyBean, "resultData.getParcelable…                ?: return");
        AppExtKt.logd(this, "验证成功");
        ExamArrangeViewModel viewModel = getViewModel();
        String userId = taskVerifyBean.getUserId();
        ExamPlanItem examPlanItem = this.dataBean;
        ExamPlanItem examPlanItem2 = null;
        if (examPlanItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem = null;
        }
        String siteId = examPlanItem.getSiteId();
        ExamPlanItem examPlanItem3 = this.dataBean;
        if (examPlanItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem3 = null;
        }
        String subjectId = examPlanItem3.getSubjectId();
        ExamPlanItem examPlanItem4 = this.dataBean;
        if (examPlanItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
        } else {
            examPlanItem2 = examPlanItem4;
        }
        viewModel.signInExam(userId, siteId, subjectId, examPlanItem2.getExaminationId());
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        ExamPlanItem examPlanItem = arguments != null ? (ExamPlanItem) arguments.getParcelable("data") : null;
        if (examPlanItem == null) {
            examPlanItem = new ExamPlanItem(null, null, 0, null, 0, null, 0, null, 0, null, false, false, null, 0, null, 0, null, null, null, null, 0, 0, 0, false, 16777215, null);
        }
        this.dataBean = examPlanItem;
        getBinding().btnFragmentFullExamSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$SimpleFullScreenFragment$l9ssl8N8NqpI1JDOyTuXKzcctwE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SimpleFullScreenFragment.onViewCreated$lambda$2(this.f$0, view2);
            }
        });
        LiveData<Result<ExamPlanItem>> examDetail = getViewModel().getExamDetail();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends ExamPlanItem>, Unit> function1 = new Function1<Result<? extends ExamPlanItem>, Unit>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.SimpleFullScreenFragment.onViewCreated.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends ExamPlanItem> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends ExamPlanItem> it2) {
                SimpleFullScreenFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                ExamPlanItem examPlanItem2 = null;
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                ExamPlanItem examPlanItem3 = (ExamPlanItem) value;
                if (examPlanItem3 == null) {
                    return;
                }
                SimpleFullScreenFragment.this.dataBean = examPlanItem3;
                SimpleFullScreenFragment simpleFullScreenFragment = SimpleFullScreenFragment.this;
                ExamPlanItem examPlanItem4 = simpleFullScreenFragment.dataBean;
                if (examPlanItem4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                } else {
                    examPlanItem2 = examPlanItem4;
                }
                simpleFullScreenFragment.setUiData(examPlanItem2);
            }
        };
        examDetail.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$SimpleFullScreenFragment$NOOe8BQc4hrI4R2iDOW6Bt-Qbj8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SimpleFullScreenFragment.onViewCreated$lambda$3(function1, obj);
            }
        });
        LiveData<Result<Boolean>> signInExam = getViewModel().getSignInExam();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function2 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.SimpleFullScreenFragment.onViewCreated.3
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
                ToastUtil.showBottomView((Activity) SimpleFullScreenFragment.this.requireActivity(), "签到成功");
                SimpleFullScreenFragment.this.request();
                MinaEventManager.getInstance().notifyObserver(MinaConstants.CODE_EXAM);
            }
        };
        signInExam.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$SimpleFullScreenFragment$6MoPpF0tya1kUjxUg84_Z0liggk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SimpleFullScreenFragment.onViewCreated$lambda$4(function2, obj);
            }
        });
        request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(SimpleFullScreenFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExamPlanItem examPlanItem = this$0.dataBean;
        if (examPlanItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem = null;
        }
        if (examPlanItem.getSignIn()) {
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
    public static final void onViewCreated$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUiData(ExamPlanItem data) {
        if (!data.getGroup().isEmpty()) {
            getBinding().tvFragmentFullExamTarget.setText(((ExamGroupItem) CollectionsKt.first((List) data.getGroup())).getObjectName());
        } else {
            getBinding().tvFragmentFullExamTarget.setText("");
        }
        getBinding().tvFragmentFullExamAddress.setText(data.getExaminationRoomName());
        int signInPerson = data.getTotalPerson() == 0 ? 0 : (data.getSignInPerson() * 100) / data.getTotalPerson();
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.exam_rate));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.rate);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.rate)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(signInPerson);
        sb2.append('%');
        String str = String.format(string, Arrays.copyOf(new Object[]{sb2.toString(), Integer.valueOf(data.getSignInPerson()), Integer.valueOf(data.getTotalPerson())}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        sb.append(str);
        getBinding().tvFragmentSimpleFullScreenExamRate.setText(sb.toString());
        StringBuilder sb3 = new StringBuilder();
        int i = 0;
        for (Object obj : data.getInvigilators()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            sb3.append(((ExamInvigilatorBean) obj).getPersonName());
            if (i != CollectionsKt.getLastIndex(data.getInvigilators())) {
                sb3.append("、");
            }
            i = i2;
        }
        if (sb3.length() == 0) {
            sb3.append("无");
        }
        getBinding().tvFragmentSimpleFullScreenExamTeacher.setText(getString(R.string.exam_invigilation_teacher) + ((Object) sb3));
        getBinding().tvFragmentSimpleFullScreenExamCourse.setText(data.getSubjectName() + '(' + TimeUtil.formatTime(data.getExamStartTime(), TimeUtil.allTimeFormat, TimeUtil.hoursMinuteTimeFormat) + '-' + TimeUtil.formatTime(data.getExamEndTime(), TimeUtil.allTimeFormat, TimeUtil.hoursMinuteTimeFormat) + ')');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void request() {
        showProgressDialog();
        ExamArrangeViewModel viewModel = getViewModel();
        ExamPlanItem examPlanItem = this.dataBean;
        ExamPlanItem examPlanItem2 = null;
        if (examPlanItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem = null;
        }
        String siteId = examPlanItem.getSiteId();
        ExamPlanItem examPlanItem3 = this.dataBean;
        if (examPlanItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem3 = null;
        }
        String subjectId = examPlanItem3.getSubjectId();
        ExamPlanItem examPlanItem4 = this.dataBean;
        if (examPlanItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
        } else {
            examPlanItem2 = examPlanItem4;
        }
        viewModel.getExamDetail(siteId, subjectId, examPlanItem2.getExaminationId());
    }
}
