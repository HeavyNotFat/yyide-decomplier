package com.yd.android_brand_mvp.activity.active.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.active.ActiveDetailsListAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.databinding.FragmentActiveApplyDetailsBinding;
import com.yd.android_brand_mvp.dialog.MessageTipDialog;
import com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel;
import com.yd.android_brand_mvp.model.active.ActiveDetailsBean;
import com.yd.android_brand_mvp.model.active.ActiveEnrollSubBean;
import com.yd.android_brand_mvp.model.active.ActiveRangeBean;
import com.yd.android_brand_mvp.model.active.ActiveSuccessBean;
import com.yd.android_brand_mvp.model.task.TaskVerifyBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.PageUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.verfity.AllCheckActivity;
import com.yd.android_brand_mvp.verfity.CheckEnum;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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

/* JADX INFO: compiled from: ActiveDetailsFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u001a\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/yd/android_brand_mvp/activity/active/fragment/ActiveDetailsFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentActiveApplyDetailsBinding;", "()V", "activityId", "", "adapter", "Lcom/yd/android_brand_mvp/adapter/active/ActiveDetailsListAdapter;", "jumpActivityWithResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "subType", "", "verifyBean", "Lcom/yd/android_brand_mvp/model/task/TaskVerifyBean;", "getVerifyBean", "()Lcom/yd/android_brand_mvp/model/task/TaskVerifyBean;", "setVerifyBean", "(Lcom/yd/android_brand_mvp/model/task/TaskVerifyBean;)V", "viewModel", "Lcom/yd/android_brand_mvp/landscape/active/viewModel/ActiveApplyFragmentViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/active/viewModel/ActiveApplyFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLoginDetails", "", "initView", "initViewModel", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parserLastActivityData", "result", "Landroidx/activity/result/ActivityResult;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActiveDetailsFragment extends KTBaseFragment<FragmentActiveApplyDetailsBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String activityId;
    private final ActiveDetailsListAdapter adapter;
    private final ActivityResultLauncher<Intent> jumpActivityWithResult;
    private int subType;
    private TaskVerifyBean verifyBean;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.active.fragment.ActiveDetailsFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActiveDetailsFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentActiveApplyDetailsBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentActiveApplyDetailsBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentActiveApplyDetailsBinding;", 0);
        }

        public final FragmentActiveApplyDetailsBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentActiveApplyDetailsBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentActiveApplyDetailsBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public ActiveDetailsFragment() {
        super(AnonymousClass1.INSTANCE);
        final ActiveDetailsFragment activeDetailsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.active.fragment.ActiveDetailsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return activeDetailsFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.active.fragment.ActiveDetailsFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(activeDetailsFragment, Reflection.getOrCreateKotlinClass(ActiveApplyFragmentViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.active.fragment.ActiveDetailsFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.active.fragment.ActiveDetailsFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.active.fragment.ActiveDetailsFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = activeDetailsFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.adapter = new ActiveDetailsListAdapter();
        this.activityId = "";
        this.subType = -1;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.yd.android_brand_mvp.activity.active.fragment.-$$Lambda$ActiveDetailsFragment$ZKHRgZ4H5BSPp_QxZjo2kWyDxfk
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ActiveDetailsFragment.jumpActivityWithResult$lambda$7(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ityData(result)\n        }");
        this.jumpActivityWithResult = activityResultLauncherRegisterForActivityResult;
    }

    public static final /* synthetic */ FragmentActiveApplyDetailsBinding access$getBinding(ActiveDetailsFragment activeDetailsFragment) {
        return activeDetailsFragment.getBinding();
    }

    /* JADX INFO: compiled from: ActiveDetailsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/activity/active/fragment/ActiveDetailsFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/active/fragment/ActiveDetailsFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ActiveDetailsFragment newInstance() {
            return new ActiveDetailsFragment();
        }
    }

    private final ActiveApplyFragmentViewModel getViewModel() {
        return (ActiveApplyFragmentViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    public final void initView() {
        Banner startPosition;
        Banner adapter;
        Banner bannerIsAutoLoop;
        Banner loopTime;
        Banner indicator;
        Banner indicatorGravity;
        Banner indicatorSpace;
        Banner indicatorNormalColor;
        Banner indicatorSelectedColor;
        Banner indicatorWidth;
        Banner bannerAddBannerLifecycleObserver = getBinding().banner.addBannerLifecycleObserver(this);
        if (bannerAddBannerLifecycleObserver != null && (startPosition = bannerAddBannerLifecycleObserver.setStartPosition(1)) != null && (adapter = startPosition.setAdapter(this.adapter)) != null && (bannerIsAutoLoop = adapter.isAutoLoop(false)) != null && (loopTime = bannerIsAutoLoop.setLoopTime(5000L)) != null && (indicator = loopTime.setIndicator(new CircleIndicator(requireContext()))) != null && (indicatorGravity = indicator.setIndicatorGravity(1)) != null && (indicatorSpace = indicatorGravity.setIndicatorSpace(BannerUtils.dp2px(10.0f))) != null && (indicatorNormalColor = indicatorSpace.setIndicatorNormalColor(SimpleUtilsKt.asColor(R.color.gray))) != null && (indicatorSelectedColor = indicatorNormalColor.setIndicatorSelectedColor(SimpleUtilsKt.asColor(R.color.blue12))) != null && (indicatorWidth = indicatorSelectedColor.setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f))) != null) {
            indicatorWidth.setIndicatorHeight(BannerUtils.dp2px(10.0f));
        }
        LinearLayoutCompat linearLayoutCompat = getBinding().llBottom;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "binding.llBottom");
        SimpleUtilsKt.hide(linearLayoutCompat);
        getBinding().btnActiveLogin.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.active.fragment.-$$Lambda$ActiveDetailsFragment$HckWBzX7xZ8pnKqEKm8T_3yAcFo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveDetailsFragment.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().btnOutLogin.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.active.fragment.-$$Lambda$ActiveDetailsFragment$NQBtfPiuDdU9N4We_cDb0jB4NZE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveDetailsFragment.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().btnActiveSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.active.fragment.-$$Lambda$ActiveDetailsFragment$ny4XsCadeo5JRKj01emPwujp1Ek
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveDetailsFragment.initView$lambda$4(this.f$0, view);
            }
        });
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ActiveDetailsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AllCheckActivity.INSTANCE.startGo(this$0.requireContext(), CheckEnum.ACTIVE_REGISTRATION.getTodoType(), this$0.jumpActivityWithResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(ActiveDetailsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayoutCompat linearLayoutCompat = this$0.getBinding().llBottom;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "binding.llBottom");
        SimpleUtilsKt.hide(linearLayoutCompat);
        TextView textView = this$0.getBinding().btnActiveLogin;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.btnActiveLogin");
        SimpleUtilsKt.show(textView);
        this$0.verifyBean = null;
        this$0.adapter.removeCheckBoxList();
        this$0.getViewModel().getActiveDetails(this$0.activityId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(ActiveDetailsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TaskVerifyBean taskVerifyBean = this$0.verifyBean;
        if (taskVerifyBean == null) {
            ToastUtils.showShort("请选择报名项目！", new Object[0]);
            return;
        }
        if (taskVerifyBean != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it2 = this$0.adapter.getCheckBoxList().iterator();
            while (it2.hasNext()) {
                arrayList.add(((ActiveEnrollSubBean) it2.next()).getId());
            }
            if (this$0.subType == 2 && arrayList.size() <= 0) {
                ToastUtils.showShort("请选择报名项目！", new Object[0]);
            } else {
                this$0.getViewModel().pushActivity(this$0.activityId, taskVerifyBean.getUserId(), taskVerifyBean.getType(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void initViewModel() {
        MutableLiveData<Result<ActiveSuccessBean>> activeRegistration = getViewModel().getActiveRegistration();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends ActiveSuccessBean>, Unit> function1 = new Function1<Result<? extends ActiveSuccessBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.active.fragment.ActiveDetailsFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends ActiveSuccessBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends ActiveSuccessBean> it2) {
                String str;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    ActiveDetailsFragment.this.setVerifyBean(null);
                    ActiveDetailsFragment.this.adapter.removeCheckBoxList();
                    Object value = it2.getValue();
                    ActiveSuccessBean activeSuccessBean = (ActiveSuccessBean) (Result.m597isFailureimpl(value) ? null : value);
                    if (activeSuccessBean != null) {
                        ActiveDetailsFragment activeDetailsFragment = ActiveDetailsFragment.this;
                        if (activeSuccessBean.getSubType() == 2) {
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            str = String.format("报名成功%s项，失败%s项", Arrays.copyOf(new Object[]{Integer.valueOf(activeSuccessBean.getSuccessCount()), Integer.valueOf(activeSuccessBean.getFailCount())}, 2));
                            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                        } else {
                            str = "你已成功报名本活动！";
                        }
                        new MessageTipDialog(str).show(activeDetailsFragment.getParentFragmentManager(), "messageTip");
                        activeDetailsFragment.getLoginDetails();
                        return;
                    }
                    return;
                }
                Throwable thM594exceptionOrNullimpl = Result.m594exceptionOrNullimpl(it2.getValue());
                if (thM594exceptionOrNullimpl != null) {
                    ToastUtils.showShort(thM594exceptionOrNullimpl.getMessage(), new Object[0]);
                }
            }
        };
        activeRegistration.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.active.fragment.-$$Lambda$ActiveDetailsFragment$dHZ6WiMcUV35TkRyElMpvQh3xx4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveDetailsFragment.initViewModel$lambda$5(function1, obj);
            }
        });
        MutableLiveData<Result<ActiveDetailsBean>> activeDetails = getViewModel().getActiveDetails();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends ActiveDetailsBean>, Unit> function2 = new Function1<Result<? extends ActiveDetailsBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.active.fragment.ActiveDetailsFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends ActiveDetailsBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends ActiveDetailsBean> it2) {
                ActiveDetailsFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    ActiveDetailsBean activeDetailsBean = (ActiveDetailsBean) value;
                    if (activeDetailsBean != null) {
                        ActiveDetailsFragment activeDetailsFragment = ActiveDetailsFragment.this;
                        activeDetailsFragment.activityId = activeDetailsBean.getId();
                        activeDetailsFragment.adapter.setDataDetails(activeDetailsBean);
                        activeDetailsFragment.subType = activeDetailsBean.getSubType();
                        ActiveDetailsFragment.access$getBinding(activeDetailsFragment).banner.setDatas(PageUtils.INSTANCE.splitList(activeDetailsBean.getEnrollSubList(), ScreenUtils.isPortrait() ? 18 : 8));
                        GlideUtil.loadImage(activeDetailsFragment.requireContext(), activeDetailsBean.getCoverImg(), ActiveDetailsFragment.access$getBinding(activeDetailsFragment).ivCover);
                        ActiveDetailsFragment.access$getBinding(activeDetailsFragment).tvActiveTitle.setText(activeDetailsBean.getActivityName());
                        ActiveDetailsFragment.access$getBinding(activeDetailsFragment).tvActiveStatus.setText(activeDetailsBean.getStatusName());
                        String statusName = activeDetailsBean.getStatusName();
                        if (Intrinsics.areEqual(statusName, "未开始")) {
                            ActiveDetailsFragment.access$getBinding(activeDetailsFragment).tvActiveStatus.setBackgroundResource(R.drawable.bg_ffac08_50);
                        } else if (Intrinsics.areEqual(statusName, "已结束")) {
                            ActiveDetailsFragment.access$getBinding(activeDetailsFragment).tvActiveStatus.setBackgroundResource(R.drawable.bg_3eaef3_50);
                        } else {
                            ActiveDetailsFragment.access$getBinding(activeDetailsFragment).tvActiveStatus.setBackgroundResource(R.drawable.bg_4cc89b_50);
                        }
                        ActiveDetailsFragment.access$getBinding(activeDetailsFragment).tvActiveCreateName.setText(activeDetailsBean.getCreateBy());
                        String time = TimeUtil.formatTime(activeDetailsBean.getCreateTime(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm");
                        TextView textView = ActiveDetailsFragment.access$getBinding(activeDetailsFragment).tvActiveCreateDate;
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String str = String.format("创建于%s", Arrays.copyOf(new Object[]{time}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                        textView.setText(str);
                        ActiveDetailsFragment.access$getBinding(activeDetailsFragment).tvActiveDescribe.setText(activeDetailsBean.getActivityIntroduction());
                        StringBuilder sb = new StringBuilder();
                        int i = 0;
                        for (Object obj : activeDetailsBean.getRangeList()) {
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            ActiveRangeBean activeRangeBean = (ActiveRangeBean) obj;
                            if (i < activeDetailsBean.getRangeList().size() - 1) {
                                sb.append(activeRangeBean.getRangeName());
                                sb.append("，");
                            } else {
                                sb.append(activeRangeBean.getRangeName());
                            }
                            i = i2;
                        }
                        ActiveDetailsFragment.access$getBinding(activeDetailsFragment).tvActiveObjectScope.setText(sb);
                        if (activeDetailsBean.getSubType() == 1) {
                            ActiveDetailsFragment.access$getBinding(activeDetailsFragment).tvActiveChildRegistration.setText("各子项不单独报名");
                        } else {
                            ActiveDetailsFragment.access$getBinding(activeDetailsFragment).tvActiveChildRegistration.setText("各子项单独报名");
                        }
                        TextView textView2 = ActiveDetailsFragment.access$getBinding(activeDetailsFragment).tvActiveDate;
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        String str2 = String.format("%s 至 %s", Arrays.copyOf(new Object[]{activeDetailsBean.getActivityStartTime(), activeDetailsBean.getActivityEndTime()}, 2));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                        textView2.setText(str2);
                        TextView textView3 = ActiveDetailsFragment.access$getBinding(activeDetailsFragment).tvActiveSignDate;
                        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                        String str3 = String.format("%s 至 %s", Arrays.copyOf(new Object[]{activeDetailsBean.getRegisterStartTime(), activeDetailsBean.getRegisterEndTime()}, 2));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
                        textView3.setText(str3);
                        ActiveDetailsFragment.access$getBinding(activeDetailsFragment).tvActiveRemark.setText(activeDetailsBean.getActivityRemarks());
                    }
                }
            }
        };
        activeDetails.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.active.fragment.-$$Lambda$ActiveDetailsFragment$5z6OBhXGwMgo_FtpnP-56ZjXeQQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveDetailsFragment.initViewModel$lambda$6(function2, obj);
            }
        });
        String stringExtra = this.mActivity.getIntent().getStringExtra("activityId");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.activityId = stringExtra;
        getViewModel().getActiveDetails(this.activityId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final TaskVerifyBean getVerifyBean() {
        return this.verifyBean;
    }

    public final void setVerifyBean(TaskVerifyBean taskVerifyBean) {
        this.verifyBean = taskVerifyBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpActivityWithResult$lambda$7(ActiveDetailsFragment this$0, ActivityResult result) {
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
        if ((stringExtra.length() == 0) || !Intrinsics.areEqual(stringExtra, ResultCodeStr.ACTIVE_REGISTRATION_VERIFY) || (taskVerifyBean = (TaskVerifyBean) data.getParcelableExtra(ResultCodeStr.TASK_SIGN_VERIFY_SUCCESS)) == null) {
            return;
        }
        this.verifyBean = taskVerifyBean;
        Log.i("FaceFragment", "活动人脸验证成功");
        LinearLayoutCompat linearLayoutCompat = getBinding().llBottom;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "binding.llBottom");
        SimpleUtilsKt.show(linearLayoutCompat);
        TextView textView = getBinding().btnActiveLogin;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.btnActiveLogin");
        SimpleUtilsKt.hide(textView);
        getLoginDetails();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getLoginDetails() {
        TaskVerifyBean taskVerifyBean = this.verifyBean;
        if (taskVerifyBean != null) {
            showProgressDialog();
            getViewModel().getLoginActiveDetails(this.activityId, taskVerifyBean.getUserId(), taskVerifyBean.getType());
        }
    }
}
