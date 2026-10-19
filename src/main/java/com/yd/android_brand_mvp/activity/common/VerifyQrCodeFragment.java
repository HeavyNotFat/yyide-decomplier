package com.yd.android_brand_mvp.activity.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bumptech.glide.Glide;
import com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentVerifyQrcodeBinding;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.SiteInfoBean;
import com.yd.android_brand_mvp.model.VerifyEventBean;
import com.yd.android_brand_mvp.model.VerifyPeopleBean;
import com.yd.android_brand_mvp.utils.SpData;
import com.yyide.facepass.AppExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: compiled from: VerifyQrCodeFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u001a\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/yd/android_brand_mvp/activity/common/VerifyQrCodeFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentVerifyQrcodeBinding;", "()V", "type", "", "userData", "Lcom/yd/android_brand_mvp/model/NewBrandLoginRsp$DataBean;", "kotlin.jvm.PlatformType", "getUserData", "()Lcom/yd/android_brand_mvp/model/NewBrandLoginRsp$DataBean;", "userData$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/yd/android_brand_mvp/activity/common/viewmodel/VerifyViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/common/viewmodel/VerifyViewModel;", "viewModel$delegate", "initView", "", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VerifyQrCodeFragment extends KTBaseFragment<FragmentVerifyQrcodeBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String type;

    /* JADX INFO: renamed from: userData$delegate, reason: from kotlin metadata */
    private final Lazy userData;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.common.VerifyQrCodeFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: VerifyQrCodeFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentVerifyQrcodeBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentVerifyQrcodeBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentVerifyQrcodeBinding;", 0);
        }

        public final FragmentVerifyQrcodeBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentVerifyQrcodeBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentVerifyQrcodeBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentVerifyQrcodeBinding access$getBinding(VerifyQrCodeFragment verifyQrCodeFragment) {
        return verifyQrCodeFragment.getBinding();
    }

    public VerifyQrCodeFragment() {
        super(AnonymousClass1.INSTANCE);
        this.type = "";
        final VerifyQrCodeFragment verifyQrCodeFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyQrCodeFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return verifyQrCodeFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyQrCodeFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(verifyQrCodeFragment, Reflection.getOrCreateKotlinClass(VerifyViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyQrCodeFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyQrCodeFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyQrCodeFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = verifyQrCodeFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.userData = LazyKt.lazy(new Function0<NewBrandLoginRsp.DataBean>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyQrCodeFragment$userData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NewBrandLoginRsp.DataBean invoke() {
                return SpData.NewUser().data;
            }
        });
    }

    /* JADX INFO: compiled from: VerifyQrCodeFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/common/VerifyQrCodeFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/common/VerifyQrCodeFragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VerifyQrCodeFragment newInstance(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            VerifyQrCodeFragment verifyQrCodeFragment = new VerifyQrCodeFragment();
            verifyQrCodeFragment.setArguments(bundle);
            return verifyQrCodeFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VerifyViewModel getViewModel() {
        return (VerifyViewModel) this.viewModel.getValue();
    }

    private final NewBrandLoginRsp.DataBean getUserData() {
        return (NewBrandLoginRsp.DataBean) this.userData.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        request();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("type") : null;
        if (string == null) {
            string = "";
        }
        this.type = string;
        LiveData<Result<SiteInfoBean>> siteInfo = getViewModel().getSiteInfo();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends SiteInfoBean>, Unit> function1 = new Function1<Result<? extends SiteInfoBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyQrCodeFragment.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends SiteInfoBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends SiteInfoBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                SiteInfoBean siteInfoBean = (SiteInfoBean) value;
                if (siteInfoBean == null) {
                    return;
                }
                Glide.with(VerifyQrCodeFragment.this.requireContext()).load(siteInfoBean.getQrCode()).into(VerifyQrCodeFragment.access$getBinding(VerifyQrCodeFragment.this).ivFragmentVerifyQrCode);
                LifecycleOwner viewLifecycleOwner2 = VerifyQrCodeFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new C01651(VerifyQrCodeFragment.this, siteInfoBean, null), 3, null);
            }

            /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.common.VerifyQrCodeFragment$initView$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: VerifyQrCodeFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.yd.android_brand_mvp.activity.common.VerifyQrCodeFragment$initView$1$1", f = "VerifyQrCodeFragment.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
            static final class C01651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ SiteInfoBean $data;
                int label;
                final /* synthetic */ VerifyQrCodeFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01651(VerifyQrCodeFragment verifyQrCodeFragment, SiteInfoBean siteInfoBean, Continuation<? super C01651> continuation) {
                    super(2, continuation);
                    this.this$0 = verifyQrCodeFragment;
                    this.$data = siteInfoBean;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C01651(this.this$0, this.$data, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C01651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.this$0.getViewModel().startRequestQrCodeResult(this.$data.getId(), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        siteInfo.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.common.-$$Lambda$VerifyQrCodeFragment$_9qGzglMt8Ut--6-odqZyKjOvQk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerifyQrCodeFragment.initView$lambda$0(function1, obj);
            }
        });
        LiveData<Result<VerifyPeopleBean>> scanQrCodeResult = getViewModel().getScanQrCodeResult();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends VerifyPeopleBean>, Unit> function2 = new Function1<Result<? extends VerifyPeopleBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyQrCodeFragment.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends VerifyPeopleBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends VerifyPeopleBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                VerifyPeopleBean verifyPeopleBean = (VerifyPeopleBean) value;
                if (verifyPeopleBean == null) {
                    return;
                }
                AppExtKt.logd(VerifyQrCodeFragment.this, "data = " + verifyPeopleBean);
                VerifyEventBean verifyEventBean = new VerifyEventBean(null, null, false, null, null, 31, null);
                verifyEventBean.setId(verifyPeopleBean.getIdentityUserId());
                verifyEventBean.setUserId(verifyPeopleBean.getUserId());
                verifyEventBean.setUserName(verifyPeopleBean.getUserName());
                verifyEventBean.setSchoolId(verifyPeopleBean.getSchoolId());
                EventBus.getDefault().post(verifyEventBean);
            }
        };
        scanQrCodeResult.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.common.-$$Lambda$VerifyQrCodeFragment$spmqxd4UIt5r0DknhL-3Ga80_GQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerifyQrCodeFragment.initView$lambda$1(function2, obj);
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

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getViewModel().clearRequestQrResult();
    }

    private final void request() {
        if (getUserData() != null) {
            String str = getUserData().siteId;
            if (str == null || str.length() == 0) {
                return;
            }
            VerifyViewModel viewModel = getViewModel();
            String str2 = getUserData().siteId;
            Intrinsics.checkNotNullExpressionValue(str2, "userData.siteId");
            viewModel.getSiteInfo(str2);
        }
    }
}
