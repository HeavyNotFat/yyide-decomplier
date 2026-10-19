package com.yd.android_brand_mvp.activity.exam.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.exam.viewmodel.ExamArrangeViewModel;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentExamCourseDetailBinding;
import com.yd.android_brand_mvp.model.exam.ExamGroupItem;
import com.yd.android_brand_mvp.model.exam.ExamInvigilatorBean;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.utils.TimeUtil;
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

/* JADX INFO: compiled from: ExamCourseDetailFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/fragment/ExamCourseDetailFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentExamCourseDetailBinding;", "()V", "dataBean", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "sourceTimeFormat", "", "targetTimeFormat", "viewModel", "Lcom/yd/android_brand_mvp/activity/exam/viewmodel/ExamArrangeViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/exam/viewmodel/ExamArrangeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamCourseDetailFragment extends KTBaseFragment<FragmentExamCourseDetailBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ExamPlanItem dataBean;
    private final String sourceTimeFormat;
    private final String targetTimeFormat;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.exam.fragment.ExamCourseDetailFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExamCourseDetailFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentExamCourseDetailBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentExamCourseDetailBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentExamCourseDetailBinding;", 0);
        }

        public final FragmentExamCourseDetailBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentExamCourseDetailBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentExamCourseDetailBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentExamCourseDetailBinding access$getBinding(ExamCourseDetailFragment examCourseDetailFragment) {
        return examCourseDetailFragment.getBinding();
    }

    public ExamCourseDetailFragment() {
        super(AnonymousClass1.INSTANCE);
        final ExamCourseDetailFragment examCourseDetailFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamCourseDetailFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return examCourseDetailFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamCourseDetailFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(examCourseDetailFragment, Reflection.getOrCreateKotlinClass(ExamArrangeViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamCourseDetailFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamCourseDetailFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamCourseDetailFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = examCourseDetailFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.sourceTimeFormat = "yyyy-MM-dd HH:mm:ss";
        this.targetTimeFormat = "HH:mm";
    }

    /* JADX INFO: compiled from: ExamCourseDetailFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/fragment/ExamCourseDetailFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "data", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(ExamPlanItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
            ExamCourseDetailFragment examCourseDetailFragment = new ExamCourseDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("data", data);
            examCourseDetailFragment.setArguments(bundle);
            return examCourseDetailFragment;
        }
    }

    private final ExamArrangeViewModel getViewModel() {
        return (ExamArrangeViewModel) this.viewModel.getValue();
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
        LiveData<Result<ExamPlanItem>> examDetail = getViewModel().getExamDetail();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends ExamPlanItem>, Unit> function1 = new Function1<Result<? extends ExamPlanItem>, Unit>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamCourseDetailFragment.onViewCreated.1
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
                ExamCourseDetailFragment.this.dismissProgressDialog();
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
                ExamCourseDetailFragment.access$getBinding(ExamCourseDetailFragment.this).tvFragmentExamCourseDetailName.setText(examPlanItem3.getSubjectName());
                String str = TimeUtil.formatTime(examPlanItem3.getExamStartTime(), ExamCourseDetailFragment.this.sourceTimeFormat, "yyyy-MM-dd HH:mm") + '-' + TimeUtil.formatTime(examPlanItem3.getExamEndTime(), ExamCourseDetailFragment.this.sourceTimeFormat, ExamCourseDetailFragment.this.targetTimeFormat);
                if (Intrinsics.areEqual(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    ExamCourseDetailFragment.access$getBinding(ExamCourseDetailFragment.this).tvFragmentExamArrangementTime.setText("");
                } else {
                    ExamCourseDetailFragment.access$getBinding(ExamCourseDetailFragment.this).tvFragmentExamArrangementTime.setText(str);
                }
                ExamCourseDetailFragment.access$getBinding(ExamCourseDetailFragment.this).tvFragmentExamArrangementAddress.setText(examPlanItem3.getExaminationRoomName() + '-' + examPlanItem3.getBuildingName() + '-' + examPlanItem3.getSiteName());
                if (!examPlanItem3.getGroup().isEmpty()) {
                    TextView textView = ExamCourseDetailFragment.access$getBinding(ExamCourseDetailFragment.this).tvFragmentExamArrangementTarget;
                    ExamPlanItem examPlanItem4 = ExamCourseDetailFragment.this.dataBean;
                    if (examPlanItem4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                    } else {
                        examPlanItem2 = examPlanItem4;
                    }
                    textView.setText(((ExamGroupItem) CollectionsKt.first((List) examPlanItem2.getGroup())).getObjectName());
                } else {
                    ExamCourseDetailFragment.access$getBinding(ExamCourseDetailFragment.this).tvFragmentExamArrangementTarget.setText("");
                }
                ExamCourseDetailFragment.access$getBinding(ExamCourseDetailFragment.this).tvFragmentExamArrangementNumber.setText(String.valueOf(examPlanItem3.getExaminationPersonCount()));
                StringBuilder sb = new StringBuilder();
                int i = 0;
                for (Object obj : examPlanItem3.getInvigilators()) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    sb.append(((ExamInvigilatorBean) obj).getPersonName());
                    if (i != CollectionsKt.getLastIndex(examPlanItem3.getInvigilators())) {
                        sb.append("、");
                    }
                    i = i2;
                }
                StringBuilder sb2 = sb;
                if (sb2.length() == 0) {
                    sb.append("无");
                }
                ExamCourseDetailFragment.access$getBinding(ExamCourseDetailFragment.this).tvFragmentExamArrangementTeacher.setText(sb2);
                int signInPerson = examPlanItem3.getTotalPerson() == 0 ? 0 : (examPlanItem3.getSignInPerson() * 100) / examPlanItem3.getTotalPerson();
                TextView textView2 = ExamCourseDetailFragment.access$getBinding(ExamCourseDetailFragment.this).tvFragmentExamArrangementRate;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = ExamCourseDetailFragment.this.getString(R.string.rate);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.rate)");
                StringBuilder sb3 = new StringBuilder();
                sb3.append(signInPerson);
                sb3.append('%');
                String str2 = String.format(string, Arrays.copyOf(new Object[]{sb3.toString(), String.valueOf(examPlanItem3.getSignInPerson()), String.valueOf(examPlanItem3.getTotalPerson())}, 3));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                textView2.setText(str2);
            }
        };
        examDetail.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$ExamCourseDetailFragment$_K8yrZzbzae-WgjlZJNu4p51Pb4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamCourseDetailFragment.onViewCreated$lambda$0(function1, obj);
            }
        });
        request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void request() {
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
