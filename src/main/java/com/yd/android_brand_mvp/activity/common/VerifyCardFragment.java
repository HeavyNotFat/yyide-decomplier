package com.yd.android_brand_mvp.activity.common;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentVerifyCardBinding;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.model.VerifyEventBean;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
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

/* JADX INFO: compiled from: VerifyCardFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u001a\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/activity/common/VerifyCardFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentVerifyCardBinding;", "Lcom/yd/android_brand_mvp/observer/ObserverListener;", "()V", "postBean", "Lcom/yd/android_brand_mvp/model/VerifyEventBean;", "type", "", "viewModel", "Lcom/yd/android_brand_mvp/activity/common/viewmodel/VerifyViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/common/viewmodel/VerifyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "observerUpData", "cardNo", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VerifyCardFragment extends KTBaseFragment<FragmentVerifyCardBinding> implements ObserverListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final VerifyEventBean postBean;
    private String type;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.common.VerifyCardFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: VerifyCardFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentVerifyCardBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentVerifyCardBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentVerifyCardBinding;", 0);
        }

        public final FragmentVerifyCardBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentVerifyCardBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentVerifyCardBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public VerifyCardFragment() {
        super(AnonymousClass1.INSTANCE);
        this.type = "";
        final VerifyCardFragment verifyCardFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyCardFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return verifyCardFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyCardFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(verifyCardFragment, Reflection.getOrCreateKotlinClass(VerifyViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyCardFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyCardFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyCardFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = verifyCardFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.postBean = new VerifyEventBean(null, null, false, null, null, 31, null);
    }

    /* JADX INFO: compiled from: VerifyCardFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/common/VerifyCardFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/common/VerifyCardFragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VerifyCardFragment newInstance(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            VerifyCardFragment verifyCardFragment = new VerifyCardFragment();
            verifyCardFragment.setArguments(bundle);
            return verifyCardFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VerifyViewModel getViewModel() {
        return (VerifyViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObserverManager.getInstance().add(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ObserverManager.getInstance().remove(this);
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("type") : null;
        if (string == null) {
            string = "";
        }
        this.type = string;
        LiveData<Result<UserIcCardBean.DataBean>> userInfoByCard = getViewModel().getUserInfoByCard();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends UserIcCardBean.DataBean>, Unit> function1 = new Function1<Result<? extends UserIcCardBean.DataBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyCardFragment.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends UserIcCardBean.DataBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends UserIcCardBean.DataBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                UserIcCardBean.DataBean dataBean = (UserIcCardBean.DataBean) value;
                if (dataBean != null) {
                    VerifyEventBean verifyEventBean = VerifyCardFragment.this.postBean;
                    String str = dataBean.id;
                    Intrinsics.checkNotNullExpressionValue(str, "userData.id");
                    verifyEventBean.setId(str);
                    VerifyEventBean verifyEventBean2 = VerifyCardFragment.this.postBean;
                    String str2 = dataBean.userId;
                    Intrinsics.checkNotNullExpressionValue(str2, "userData.userId");
                    verifyEventBean2.setUserId(str2);
                    VerifyEventBean verifyEventBean3 = VerifyCardFragment.this.postBean;
                    String str3 = dataBean.name;
                    Intrinsics.checkNotNullExpressionValue(str3, "userData.name");
                    verifyEventBean3.setUserName(str3);
                    VerifyCardFragment.this.postBean.setStudent(dataBean.isStudent);
                    VerifyCardFragment.this.postBean.setSchoolId(dataBean.schoolId.toString());
                    if (dataBean.isStudent) {
                        VerifyViewModel viewModel = VerifyCardFragment.this.getViewModel();
                        String str4 = dataBean.userId;
                        Intrinsics.checkNotNullExpressionValue(str4, "userData.userId");
                        viewModel.patrolPunch(str4);
                        return;
                    }
                    EventBus.getDefault().post(VerifyCardFragment.this.postBean);
                    return;
                }
                Context contextRequireContext = VerifyCardFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                SimpleUtilsKt.showLongToast(contextRequireContext, "暂无人员");
            }
        };
        userInfoByCard.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.common.-$$Lambda$VerifyCardFragment$3N8vbAfxGInRto3xn1YcGQAKP4Y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerifyCardFragment.initView$lambda$0(function1, obj);
            }
        });
        LiveData<Result<Boolean>> patrolPunch = getViewModel().getPatrolPunch();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function2 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyCardFragment.initView.2
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
                    EventBus.getDefault().post(VerifyCardFragment.this.postBean);
                }
            }
        };
        patrolPunch.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.common.-$$Lambda$VerifyCardFragment$lZ1JQocLLAiXHSQP0wPpF-2BzV8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerifyCardFragment.initView$lambda$1(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.yd.android_brand_mvp.observer.ObserverListener
    public void observerUpData(String cardNo) {
        Intrinsics.checkNotNullParameter(cardNo, "cardNo");
        getViewModel().checkUserInfo(cardNo);
    }
}
