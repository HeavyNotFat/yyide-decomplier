package com.yd.android_brand_mvp.landscape.areover;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentClassesOverBinding;
import com.yd.android_brand_mvp.model.ClassesOverInfoBean;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.verfity.TeacherCheackActivity;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: ClassesOverFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u001a\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/areover/ClassesOverFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentClassesOverBinding;", "()V", "task", "Ljava/util/TimerTask;", "getTask", "()Ljava/util/TimerTask;", "timer", "Ljava/util/Timer;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/areover/ClassesOverViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/areover/ClassesOverViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "initViewModel", "onDestroy", "onEvent", "eventBean", "Lcom/yd/android_brand_mvp/model/EventBean;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassesOverFragment extends KTBaseFragment<FragmentClassesOverBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final TimerTask task;
    private final Timer timer;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.areover.ClassesOverFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClassesOverFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentClassesOverBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentClassesOverBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentClassesOverBinding;", 0);
        }

        public final FragmentClassesOverBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentClassesOverBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentClassesOverBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public ClassesOverFragment() {
        super(AnonymousClass1.INSTANCE);
        final ClassesOverFragment classesOverFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.areover.ClassesOverFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return classesOverFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.areover.ClassesOverFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(classesOverFragment, Reflection.getOrCreateKotlinClass(ClassesOverViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.areover.ClassesOverFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.areover.ClassesOverFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.areover.ClassesOverFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = classesOverFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.timer = new Timer();
        this.task = new TimerTask() { // from class: com.yd.android_brand_mvp.landscape.areover.ClassesOverFragment$task$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.this$0.getViewModel().requestClassesOverInfo();
            }
        };
    }

    public static final /* synthetic */ FragmentClassesOverBinding access$getBinding(ClassesOverFragment classesOverFragment) {
        return classesOverFragment.getBinding();
    }

    /* JADX INFO: compiled from: ClassesOverFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/areover/ClassesOverFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/areover/ClassesOverFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClassesOverFragment newInstance() {
            return new ClassesOverFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassesOverViewModel getViewModel() {
        return (ClassesOverViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initViewModel();
    }

    public final TimerTask getTask() {
        return this.task;
    }

    private final void initView() {
        EventBus.getDefault().register(this);
        Button button = getBinding().btnOver;
        Intrinsics.checkNotNullExpressionValue(button, "binding.btnOver");
        SimpleUtilsKt.hide(button);
        getBinding().btnOver.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.areover.-$$Lambda$ClassesOverFragment$hM6uW3LvMGLjpo9ARQWbfDrcbk4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClassesOverFragment.initView$lambda$0(this.f$0, view);
            }
        });
        this.timer.schedule(this.task, 5000L, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ClassesOverFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.mActivity, (Class<?>) TeacherCheackActivity.class);
        intent.putExtra("type", BaseConstant.homeOver);
        this$0.startActivity(intent);
    }

    private final void initViewModel() {
        SingleLiveEvent<Result<ClassesOverInfoBean>> infoLiveData = getViewModel().getInfoLiveData();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        final Function1<Result<? extends ClassesOverInfoBean>, Unit> function1 = new Function1<Result<? extends ClassesOverInfoBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.areover.ClassesOverFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends ClassesOverInfoBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends ClassesOverInfoBean> it2) {
                ClassesOverFragment.access$getBinding(ClassesOverFragment.this).btnOver.setEnabled(true);
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    ClassesOverInfoBean classesOverInfoBean = (ClassesOverInfoBean) value;
                    if (classesOverInfoBean != null) {
                        ClassesOverFragment classesOverFragment = ClassesOverFragment.this;
                        Button button = ClassesOverFragment.access$getBinding(classesOverFragment).btnOver;
                        Intrinsics.checkNotNullExpressionValue(button, "binding.btnOver");
                        SimpleUtilsKt.hide(button);
                        ClassesOverFragment.access$getBinding(classesOverFragment).tvClassName.setText(classesOverInfoBean.getClassesName());
                        int status = classesOverInfoBean.getStatus();
                        if (status == 0) {
                            ClassesOverFragment.access$getBinding(classesOverFragment).tvDesc.setText("未放学");
                            Button button2 = ClassesOverFragment.access$getBinding(classesOverFragment).btnOver;
                            Intrinsics.checkNotNullExpressionValue(button2, "binding.btnOver");
                            SimpleUtilsKt.show(button2);
                            return;
                        }
                        if (status == 1) {
                            ClassesOverFragment.access$getBinding(classesOverFragment).tvDesc.setText("放学中");
                        } else if (status == 2) {
                            ClassesOverFragment.access$getBinding(classesOverFragment).tvDesc.setText("已放学");
                        } else {
                            if (status != 3) {
                                return;
                            }
                            ClassesOverFragment.access$getBinding(classesOverFragment).tvDesc.setText("暂未到放学时间");
                        }
                    }
                }
            }
        };
        infoLiveData.observe(fragmentActivityRequireActivity, new Observer() { // from class: com.yd.android_brand_mvp.landscape.areover.-$$Lambda$ClassesOverFragment$37Xi4TxI0aUszp2EkVf7D58h7vY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClassesOverFragment.initViewModel$lambda$1(function1, obj);
            }
        });
        SingleLiveEvent<Result<Boolean>> overSchool = getViewModel().getOverSchool();
        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
        final Function1<Result<? extends Boolean>, Unit> function2 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.areover.ClassesOverFragment.initViewModel.2
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
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    ClassesOverFragment.access$getBinding(ClassesOverFragment.this).progressBar.hide();
                    ClassesOverFragment.this.getViewModel().requestClassesOverInfo();
                }
            }
        };
        overSchool.observe(fragmentActivityRequireActivity2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.areover.-$$Lambda$ClassesOverFragment$Bc1Z6gM3Q_R-T4IQk6l5qg3nCdI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClassesOverFragment.initViewModel$lambda$2(function2, obj);
            }
        });
        getViewModel().requestClassesOverInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(EventBean eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        Log.d("onEvent", "onEvent = " + GsonUtils.toJson(eventBean));
        if (eventBean.Event != BaseConstant.homeOver) {
            return;
        }
        Button button = getBinding().btnOver;
        Intrinsics.checkNotNullExpressionValue(button, "binding.btnOver");
        SimpleUtilsKt.hide(button);
        getBinding().progressBar.show();
        ClassesOverViewModel viewModel = getViewModel();
        String str = eventBean.id;
        Intrinsics.checkNotNullExpressionValue(str, "eventBean.id");
        String str2 = eventBean.name;
        Intrinsics.checkNotNullExpressionValue(str2, "eventBean.name");
        viewModel.requestOver(str, str2);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
