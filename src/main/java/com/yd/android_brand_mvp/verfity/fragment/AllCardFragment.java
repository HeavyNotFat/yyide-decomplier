package com.yd.android_brand_mvp.verfity.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.databinding.FragmentCardBinding;
import com.yd.android_brand_mvp.model.AllstudentRsp;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.model.selectTeacherByClassesIdRsp;
import com.yd.android_brand_mvp.model.task.TaskVerifyBean;
import com.yd.android_brand_mvp.net.FragmentEventListener;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.utils.CardInputUtils;
import com.yd.android_brand_mvp.utils.SettingPermision;
import com.yd.android_brand_mvp.utils.StudentPermision;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.AllCheckActivity;
import com.yd.android_brand_mvp.verfity.AllCheckViewModel;
import com.yd.android_brand_mvp.verfity.CheckEnum;
import com.yyide.facepass.database.DatabaseUtil;
import com.yyide.facepass.database.FacePeople;
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

/* JADX INFO: compiled from: AllCardFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001&B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\u001aJ\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\u001aH\u0016J\u001a\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/yd/android_brand_mvp/verfity/fragment/AllCardFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentCardBinding;", "Lcom/yd/android_brand_mvp/observer/ObserverListener;", "Lcom/yd/android_brand_mvp/net/FragmentEventListener;", "()V", "asActivity", "Lcom/yd/android_brand_mvp/verfity/AllCheckActivity;", "getAsActivity", "()Lcom/yd/android_brand_mvp/verfity/AllCheckActivity;", "asActivity$delegate", "Lkotlin/Lazy;", "buffer", "Ljava/lang/StringBuffer;", "toDoType", "", "viewModel", "Lcom/yd/android_brand_mvp/verfity/AllCheckViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/verfity/AllCheckViewModel;", "viewModel$delegate", "OnFragmentEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "getUser", "", "cardNo", "", "initViewModel", "observerUpData", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AllCardFragment extends KTBaseFragment<FragmentCardBinding> implements ObserverListener, FragmentEventListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: asActivity$delegate, reason: from kotlin metadata */
    private final Lazy asActivity;
    private final StringBuffer buffer;
    private int toDoType;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.verfity.fragment.AllCardFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: AllCardFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentCardBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentCardBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentCardBinding;", 0);
        }

        public final FragmentCardBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentCardBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentCardBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public AllCardFragment() {
        super(AnonymousClass1.INSTANCE);
        this.asActivity = LazyKt.lazy(new Function0<AllCheckActivity>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllCardFragment$asActivity$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AllCheckActivity invoke() {
                return (AllCheckActivity) this.this$0.mActivity;
            }
        });
        final AllCardFragment allCardFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllCardFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return allCardFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllCardFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(allCardFragment, Reflection.getOrCreateKotlinClass(AllCheckViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllCardFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllCardFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllCardFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = allCardFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.toDoType = -1;
        this.buffer = new StringBuffer();
    }

    /* JADX INFO: compiled from: AllCardFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/verfity/fragment/AllCardFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "toDoType", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(int toDoType) {
            AllCardFragment allCardFragment = new AllCardFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("toDoType", toDoType);
            allCardFragment.setArguments(bundle);
            return allCardFragment;
        }
    }

    private final AllCheckActivity getAsActivity() {
        return (AllCheckActivity) this.asActivity.getValue();
    }

    private final AllCheckViewModel getViewModel() {
        return (AllCheckViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.toDoType = arguments.getInt("toDoType");
        }
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void initViewModel() {
        MutableLiveData<Result<String>> pauschCard = getViewModel().getPauschCard();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        final Function1<Result<? extends String>, Unit> function1 = new Function1<Result<? extends String>, Unit>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllCardFragment.initViewModel.1
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
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    ToastUtil.showBottomView(AllCardFragment.this.requireContext(), "签到成功");
                } else {
                    ToastUtil.showBottomView(AllCardFragment.this.requireContext(), "签到失败");
                }
            }
        };
        pauschCard.observe(fragmentActivityRequireActivity, new Observer() { // from class: com.yd.android_brand_mvp.verfity.fragment.-$$Lambda$AllCardFragment$_nVGaUTPJxPa17nRtqFZmpX_crI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AllCardFragment.initViewModel$lambda$1(function1, obj);
            }
        });
        MutableLiveData<Result<UserIcCardBean.DataBean>> selectUserRsp = getViewModel().getSelectUserRsp();
        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
        final Function1<Result<? extends UserIcCardBean.DataBean>, Unit> function2 = new Function1<Result<? extends UserIcCardBean.DataBean>, Unit>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllCardFragment.initViewModel.2
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
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    UserIcCardBean.DataBean dataBean = (UserIcCardBean.DataBean) value;
                    if (dataBean != null) {
                        AllCardFragment allCardFragment = AllCardFragment.this;
                        Intent intent = new Intent();
                        intent.putExtra(ResultCodeStr.NORMAL_TYPE_CODE, ResultCodeStr.ACTIVE_REGISTRATION_VERIFY);
                        String str = dataBean.id;
                        Intrinsics.checkNotNullExpressionValue(str, "it.id");
                        intent.putExtra(ResultCodeStr.TASK_SIGN_VERIFY_SUCCESS, new TaskVerifyBean(str, "", "", dataBean.isStudent ? "0" : "1"));
                        allCardFragment.requireActivity().setResult(-1, intent);
                        allCardFragment.requireActivity().finish();
                        return;
                    }
                    return;
                }
                ToastUtil.showBottomView(AllCardFragment.this.requireContext(), "未查询到人员");
            }
        };
        selectUserRsp.observe(fragmentActivityRequireActivity2, new Observer() { // from class: com.yd.android_brand_mvp.verfity.fragment.-$$Lambda$AllCardFragment$nHWNJgV9KtHZgn5KEPJffbJyNPI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AllCardFragment.initViewModel$lambda$2(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
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

    @Override // com.yd.android_brand_mvp.net.FragmentEventListener
    public boolean OnFragmentEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 0) {
            int keyCode = event.getKeyCode();
            if (keyCode >= 7 && keyCode <= 16) {
                this.buffer.append(keyCode - 7);
            } else if (keyCode >= 144 && keyCode <= 153) {
                this.buffer.append(keyCode - 144);
            } else if (keyCode == 66 || keyCode == 160) {
                if (this.buffer.length() == 10) {
                    String strCleanCardZero = CardInputUtils.cleanCardZero(this.buffer.toString());
                    Log.i("OnFragmentEvent", "USB 刷卡卡号 = " + strCleanCardZero);
                    getUser(strCleanCardZero);
                }
                this.buffer.setLength(0);
            }
        }
        return false;
    }

    @Override // com.yd.android_brand_mvp.observer.ObserverListener
    public void observerUpData(String cardNo) {
        AllCheckActivity asActivity = getAsActivity();
        boolean z = false;
        if (asActivity != null && asActivity.getIndex() == 0) {
            z = true;
        }
        if (z) {
            int i = this.toDoType;
            if (i == CheckEnum.THIRD_PARTY.getTodoType()) {
                getUser(cardNo);
            } else if (i == CheckEnum.ACTIVE_REGISTRATION.getTodoType()) {
                AllCheckViewModel viewModel = getViewModel();
                if (cardNo == null) {
                    cardNo = "";
                }
                viewModel.checkUser(cardNo);
            }
        }
    }

    private final void getUser(String cardNo) {
        DatabaseUtil databaseUtil = DatabaseUtil.INSTANCE;
        Activity mActivity = this.mActivity;
        Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
        FacePeople facePeopleCard = databaseUtil.getFacePeopleCard(mActivity, cardNo == null ? "" : cardNo);
        String userId = facePeopleCard != null ? facePeopleCard.getUserId() : "";
        selectTeacherByClassesIdRsp.DataDTO havePermission = SettingPermision.getInstance().getHavePermission(cardNo, "");
        if (havePermission != null) {
            userId = havePermission.userId;
            Intrinsics.checkNotNullExpressionValue(userId, "data.userId");
        }
        AllstudentRsp.DataDTO havePermission2 = StudentPermision.getInstance().getHavePermission(cardNo, "");
        if (havePermission2 != null) {
            userId = havePermission2.userId;
            Intrinsics.checkNotNullExpressionValue(userId, "data2.userId");
        }
        if (!TextUtils.isEmpty(userId)) {
            AllCheckViewModel viewModel = getViewModel();
            String str = havePermission2.userId;
            Intrinsics.checkNotNullExpressionValue(str, "data2.userId");
            viewModel.pauschCard(str);
            return;
        }
        ToastUtil.showBottomView(requireContext(), "非签到人员 " + cardNo);
    }
}
