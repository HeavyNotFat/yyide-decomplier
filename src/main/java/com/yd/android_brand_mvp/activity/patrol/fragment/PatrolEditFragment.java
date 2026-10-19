package com.yd.android_brand_mvp.activity.patrol.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.gson.reflect.TypeToken;
import com.yd.android_brand_mvp.activity.collect.fragment.BaseCollectFragment;
import com.yd.android_brand_mvp.activity.patrol.viewmodel.PatrolEditViewModel;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.databinding.ActivityPatrolEditBinding;
import com.yd.android_brand_mvp.dialog.CommonTipDialog;
import com.yd.android_brand_mvp.listener.TipListener;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.patrol.PatrolDetailBean;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.form.FormComponentUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.Iterator;
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

/* JADX INFO: compiled from: PatrolEditFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/activity/patrol/fragment/PatrolEditFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/ActivityPatrolEditBinding;", "()V", "idPrefix", "", "taskId", "", "viewModel", "Lcom/yd/android_brand_mvp/activity/patrol/viewmodel/PatrolEditViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/patrol/viewmodel/PatrolEditViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addFormView", "", "initView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PatrolEditFragment extends KTBaseFragment<ActivityPatrolEditBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int idPrefix;
    private String taskId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolEditFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: PatrolEditFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ActivityPatrolEditBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ActivityPatrolEditBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ActivityPatrolEditBinding;", 0);
        }

        public final ActivityPatrolEditBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityPatrolEditBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ActivityPatrolEditBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public PatrolEditFragment() {
        super(AnonymousClass1.INSTANCE);
        final PatrolEditFragment patrolEditFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolEditFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return patrolEditFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolEditFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(patrolEditFragment, Reflection.getOrCreateKotlinClass(PatrolEditViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolEditFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolEditFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolEditFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = patrolEditFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.idPrefix = 4600;
        this.taskId = "-1";
    }

    public static final /* synthetic */ ActivityPatrolEditBinding access$getBinding(PatrolEditFragment patrolEditFragment) {
        return patrolEditFragment.getBinding();
    }

    /* JADX INFO: compiled from: PatrolEditFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/activity/patrol/fragment/PatrolEditFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/patrol/fragment/PatrolEditFragment;", "taskId", "", "teacherId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PatrolEditFragment newInstance(String taskId, String teacherId) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            Intrinsics.checkNotNullParameter(teacherId, "teacherId");
            Bundle bundle = new Bundle();
            bundle.putString("taskId", taskId);
            bundle.putString("teacherId", teacherId);
            PatrolEditFragment patrolEditFragment = new PatrolEditFragment();
            patrolEditFragment.setArguments(bundle);
            return patrolEditFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PatrolEditViewModel getViewModel() {
        return (PatrolEditViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        request();
    }

    private final void initView() {
        final String string;
        Bundle arguments = getArguments();
        String string2 = arguments != null ? arguments.getString("taskId") : null;
        if (string2 == null) {
            string2 = "-1";
        }
        this.taskId = string2;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string = arguments2.getString("teacherId")) == null) {
            string = "";
        }
        getBinding().btnActivityPatrolEdit.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.-$$Lambda$PatrolEditFragment$Q1wZIlPQJ80l6aM-UBPPbscxAgg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PatrolEditFragment.initView$lambda$0(this.f$0, string, view);
            }
        });
        LiveData<Result<PatrolDetailBean>> patrolDetail = getViewModel().getPatrolDetail();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends PatrolDetailBean>, Unit> function1 = new Function1<Result<? extends PatrolDetailBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolEditFragment.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends PatrolDetailBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends PatrolDetailBean> it2) {
                List<FormBaseBean> list;
                PatrolEditFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                PatrolDetailBean patrolDetailBean = (PatrolDetailBean) value;
                if (patrolDetailBean == null) {
                    return;
                }
                PatrolEditFragment.access$getBinding(PatrolEditFragment.this).viewActivityPatrolHead.tvViewPatrolBaseInfoTitle.setText(String.valueOf(patrolDetailBean.getProjectName()));
                PatrolEditFragment.access$getBinding(PatrolEditFragment.this).viewActivityPatrolHead.tvViewPatrolBaseInfoTime.setText("任务时间: " + patrolDetailBean.getStartTime() + " - " + patrolDetailBean.getEndTime());
                TextView textView = PatrolEditFragment.access$getBinding(PatrolEditFragment.this).viewActivityPatrolHead.tvViewPatrolBaseInfoPeople;
                StringBuilder sb = new StringBuilder();
                sb.append("执行人员: ");
                sb.append(patrolDetailBean.getExecuteNames());
                textView.setText(sb.toString());
                PatrolEditFragment.access$getBinding(PatrolEditFragment.this).viewActivityPatrolHead.tvViewPatrolBaseInfoDesc.setText("任务描述: ");
                if (!(patrolDetailBean.getFormJson().length() > 0) || (list = (List) GsonUtils.fromJson(patrolDetailBean.getFormJson(), new TypeToken<List<? extends FormBaseBean>>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolEditFragment$initView$2$formItemList$1
                }.getType())) == null) {
                    return;
                }
                PatrolEditFragment.this.getViewModel().setComponentData(list);
            }
        };
        patrolDetail.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.-$$Lambda$PatrolEditFragment$6Fny62YVHzIPxQj3AXAkebm7A04
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PatrolEditFragment.initView$lambda$1(function1, obj);
            }
        });
        LiveData<List<FormBaseBean>> componentList = getViewModel().getComponentList();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<List<? extends FormBaseBean>, Unit> function2 = new Function1<List<? extends FormBaseBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolEditFragment.initView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends FormBaseBean> list) {
                invoke2((List<FormBaseBean>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<FormBaseBean> list) {
                PatrolEditFragment.this.addFormView();
            }
        };
        componentList.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.-$$Lambda$PatrolEditFragment$vs8AkNWDcjLqj9BqfMsza7TAtao
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PatrolEditFragment.initView$lambda$2(function2, obj);
            }
        });
        LiveData<Result<Boolean>> submitResult = getViewModel().getSubmitResult();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function3 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolEditFragment.initView.4
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
                PatrolEditFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                Boolean bool = (Boolean) value;
                if (bool != null) {
                    bool.booleanValue();
                    CommonTipDialog commonTipDialog = new CommonTipDialog("提交成功", "知道了", false);
                    commonTipDialog.show(PatrolEditFragment.this.getChildFragmentManager(), "finishTip");
                    final PatrolEditFragment patrolEditFragment = PatrolEditFragment.this;
                    commonTipDialog.setCallBack(new TipListener() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolEditFragment.initView.4.1
                        @Override // com.yd.android_brand_mvp.listener.TipListener
                        public void setOnNegative(String value2) {
                            Intrinsics.checkNotNullParameter(value2, "value");
                        }

                        @Override // com.yd.android_brand_mvp.listener.TipListener
                        public void setOnPositive(String value2) {
                            Intrinsics.checkNotNullParameter(value2, "value");
                            FragmentActivity fragmentActivityRequireActivity = patrolEditFragment.requireActivity();
                            Intent intent = new Intent();
                            intent.putExtra(ResultCodeStr.NORMAL_TYPE_CODE, ResultCodeStr.PATROL_UPDATE);
                            Unit unit = Unit.INSTANCE;
                            fragmentActivityRequireActivity.setResult(-1, intent);
                            patrolEditFragment.requireActivity().finish();
                        }
                    });
                }
            }
        };
        submitResult.observe(viewLifecycleOwner3, new Observer() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.-$$Lambda$PatrolEditFragment$wCMf5ubYYlPepa_h4At7mJ7xY0k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PatrolEditFragment.initView$lambda$3(function3, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(final PatrolEditFragment this$0, final String userId, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(userId, "$userId");
        CommonTipDialog commonTipDialog = new CommonTipDialog("是否确定完成此场地巡查", "确定", true);
        commonTipDialog.show(this$0.getChildFragmentManager(), "submitTip");
        commonTipDialog.setCallBack(new TipListener() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolEditFragment$initView$1$1
            @Override // com.yd.android_brand_mvp.listener.TipListener
            public void setOnNegative(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
            }

            @Override // com.yd.android_brand_mvp.listener.TipListener
            public void setOnPositive(String value) {
                boolean z;
                FormVerifyBean formVerifyBean;
                Intrinsics.checkNotNullParameter(value, "value");
                this.this$0.showProgressDialog();
                Iterator<Fragment> it2 = this.this$0.getViewModel().getComponentFragmentList().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    }
                    Fragment next = it2.next();
                    BaseCollectFragment baseCollectFragment = next instanceof BaseCollectFragment ? (BaseCollectFragment) next : null;
                    if (baseCollectFragment == null || (formVerifyBean = baseCollectFragment.readySubmit()) == null) {
                        formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
                    }
                    if (formVerifyBean.getStatus()) {
                        FormBaseBean componentData = this.this$0.getViewModel().getComponentData(formVerifyBean.getSort());
                        if (componentData != null) {
                            componentData.setValue(formVerifyBean.getDataValue());
                        }
                    } else {
                        z = false;
                        ToastUtil.showBottomView(this.this$0.requireContext(), formVerifyBean.getErrorMessage());
                        break;
                    }
                }
                if (z) {
                    String jsonStr = GsonUtils.toJson(this.this$0.getViewModel().getComponentData());
                    PatrolEditViewModel viewModel = this.this$0.getViewModel();
                    String str = this.this$0.taskId;
                    Intrinsics.checkNotNullExpressionValue(jsonStr, "jsonStr");
                    viewModel.submitPatrolTask(str, jsonStr, userId);
                    return;
                }
                this.this$0.dismissProgressDialog();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFormView() {
        getViewModel().getComponentFrameView().clear();
        getViewModel().getComponentFragmentList().clear();
        if (!getViewModel().getComponentData().isEmpty()) {
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
            int i = 0;
            for (Object obj : getViewModel().getComponentData()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FormBaseBean formBaseBean = (FormBaseBean) obj;
                formBaseBean.setSort(i);
                formBaseBean.setSortNum(i2);
                Fragment componentFragment$default = FormComponentUtil.getComponentFragment$default(FormComponentUtil.INSTANCE, formBaseBean, null, 2, null);
                if (componentFragment$default != null) {
                    FrameLayout frameLayout = new FrameLayout(requireContext());
                    frameLayout.setId(this.idPrefix + i);
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                    fragmentTransactionBeginTransaction.replace(frameLayout.getId(), componentFragment$default);
                    getViewModel().getComponentFrameView().add(frameLayout);
                    getBinding().llActivityPatrolEditContainer.addView(frameLayout);
                    getViewModel().getComponentFragmentList().add(componentFragment$default);
                }
                i = i2;
            }
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        }
    }

    private final void request() {
        showProgressDialog();
        getViewModel().getPatrolDetail(this.taskId);
    }
}
