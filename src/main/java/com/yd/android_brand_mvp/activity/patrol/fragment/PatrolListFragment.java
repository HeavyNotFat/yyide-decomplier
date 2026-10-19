package com.yd.android_brand_mvp.activity.patrol.fragment;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.patrol.PatrolDetailActivity;
import com.yd.android_brand_mvp.activity.patrol.PatrolEditActivity;
import com.yd.android_brand_mvp.activity.patrol.viewmodel.PatrolListViewModel;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.SpacesItemDecoration;
import com.yd.android_brand_mvp.databinding.ActivityPatrolListBinding;
import com.yd.android_brand_mvp.dialog.CommonTipDialog;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.SiteInfoBean;
import com.yd.android_brand_mvp.model.patrol.PatrolListBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.view.GridSpacingItemDecoration;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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

/* JADX INFO: compiled from: PatrolListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000e\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u001a\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/yd/android_brand_mvp/activity/patrol/fragment/PatrolListFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/ActivityPatrolListBinding;", "()V", "currentPage", "", "currentSelectList", "jumpActivityWithResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "pageSize", "patrolType", "recordAdapter", "com/yd/android_brand_mvp/activity/patrol/fragment/PatrolListFragment$recordAdapter$1", "Lcom/yd/android_brand_mvp/activity/patrol/fragment/PatrolListFragment$recordAdapter$1;", "siteId", "", "userId", "userName", "viewModel", "Lcom/yd/android_brand_mvp/activity/patrol/viewmodel/PatrolListViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/patrol/viewmodel/PatrolListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parserReturnActivityData", "result", "Landroidx/activity/result/ActivityResult;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PatrolListFragment extends KTBaseFragment<ActivityPatrolListBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int currentPage;
    private int currentSelectList;
    private final ActivityResultLauncher<Intent> jumpActivityWithResult;
    private final int pageSize;
    private int patrolType;
    private final PatrolListFragment$recordAdapter$1 recordAdapter;
    private String siteId;
    private String userId;
    private String userName;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    private final void parserReturnActivityData(ActivityResult result) {
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolListFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: PatrolListFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ActivityPatrolListBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ActivityPatrolListBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ActivityPatrolListBinding;", 0);
        }

        public final ActivityPatrolListBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityPatrolListBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ActivityPatrolListBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ ActivityPatrolListBinding access$getBinding(PatrolListFragment patrolListFragment) {
        return patrolListFragment.getBinding();
    }

    public PatrolListFragment() {
        super(AnonymousClass1.INSTANCE);
        this.userId = "-1";
        this.userName = "";
        this.siteId = "-1";
        this.patrolType = 1;
        this.currentPage = 1;
        this.pageSize = 20;
        final PatrolListFragment patrolListFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return patrolListFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolListFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(patrolListFragment, Reflection.getOrCreateKotlinClass(PatrolListViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolListFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolListFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolListFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = patrolListFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.-$$Lambda$PatrolListFragment$NUfX6g0BtccDh6X7ngjfwO35beo
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PatrolListFragment.jumpActivityWithResult$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ityData(result)\n        }");
        this.jumpActivityWithResult = activityResultLauncherRegisterForActivityResult;
        this.recordAdapter = new PatrolListFragment$recordAdapter$1(this);
    }

    /* JADX INFO: compiled from: PatrolListFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/activity/patrol/fragment/PatrolListFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/patrol/fragment/PatrolListFragment;", "id", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "patrolType", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PatrolListFragment newInstance(String id, String name, int patrolType) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, name);
            bundle.putInt("patrolType", patrolType);
            PatrolListFragment patrolListFragment = new PatrolListFragment();
            patrolListFragment.setArguments(bundle);
            return patrolListFragment;
        }
    }

    private final PatrolListViewModel getViewModel() {
        return (PatrolListViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpActivityWithResult$lambda$0(PatrolListFragment this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.parserReturnActivityData(result);
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("id") : null;
        if (string == null) {
            string = "-1";
        }
        this.userId = string;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME) : null;
        if (string2 == null) {
            string2 = "";
        }
        this.userName = string2;
        Bundle arguments3 = getArguments();
        boolean z = true;
        this.patrolType = arguments3 != null ? arguments3.getInt("patrolType") : 1;
        initView();
        NewBrandLoginRsp.DataBean dataBean = SpData.NewUser().data;
        if (dataBean != null) {
            String str = dataBean.siteId;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (!z) {
                String str2 = dataBean.siteId;
                Intrinsics.checkNotNullExpressionValue(str2, "userData.siteId");
                this.siteId = str2;
                getViewModel().getSiteInfo(this.siteId);
            }
        }
        request();
    }

    private final void initView() {
        getBinding().tvActivityPatrolListUser.setText("当前用户: " + this.userName);
        this.recordAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.-$$Lambda$PatrolListFragment$wXGMze7BriSOXTERiY7wuu8gPjo
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                PatrolListFragment.initView$lambda$1(this.f$0);
            }
        });
        this.recordAdapter.getLoadMoreModule().setAutoLoadMore(true);
        this.recordAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
        getBinding().rvActivityPatrolList.setAdapter(this.recordAdapter);
        if (ScreenUtils.isPortrait()) {
            getBinding().rvActivityPatrolList.setLayoutManager(new LinearLayoutManager(requireContext()));
            getBinding().rvActivityPatrolList.addItemDecoration(new SpacesItemDecoration(SizeUtils.dp2px(30.0f)));
        } else {
            getBinding().rvActivityPatrolList.setLayoutManager(new GridLayoutManager(requireContext(), 2));
            getBinding().rvActivityPatrolList.addItemDecoration(new GridSpacingItemDecoration(2, SizeUtils.dp2px(30.0f), false));
        }
        this.recordAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.-$$Lambda$PatrolListFragment$uSADm0UfGVZry677h6-PUYvOmVs
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PatrolListFragment.initView$lambda$2(this.f$0, baseQuickAdapter, view, i);
            }
        });
        getBinding().tvActivityPatrolListIng.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.-$$Lambda$PatrolListFragment$Aa5u44GhVt9kZNwQuloJEFir0Hs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PatrolListFragment.initView$lambda$3(this.f$0, view);
            }
        });
        getBinding().tvActivityPatrolListEnd.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.-$$Lambda$PatrolListFragment$qExi04v4nzeQrOcPAxfK4zJS8BE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PatrolListFragment.initView$lambda$4(this.f$0, view);
            }
        });
        getBinding().tvActivityPatrolListOver.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.-$$Lambda$PatrolListFragment$Qvcjy2KqfEGksPwnwGPCkKvukJ0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PatrolListFragment.initView$lambda$5(this.f$0, view);
            }
        });
        LiveData<Result<SiteInfoBean>> siteInfo = getViewModel().getSiteInfo();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends SiteInfoBean>, Unit> function1 = new Function1<Result<? extends SiteInfoBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolListFragment.initView.6
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
                StringBuilder sb = new StringBuilder();
                sb.append(siteInfoBean.getBuildingName());
                if (siteInfoBean.getFloor() != 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb.append(siteInfoBean.getFloor());
                }
                if (!Intrinsics.areEqual(siteInfoBean.getRoomNum(), "")) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb.append(siteInfoBean.getRoomNum());
                }
                sb.append(' ' + siteInfoBean.getName());
                PatrolListFragment.access$getBinding(PatrolListFragment.this).tvActivityPatrolListSite.setText(sb);
            }
        };
        siteInfo.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.-$$Lambda$PatrolListFragment$7h4I7LKztEzZwHwI4JBkCGEAJG8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PatrolListFragment.initView$lambda$6(function1, obj);
            }
        });
        LiveData<Result<BasePageResponse<List<PatrolListBean>>>> patrolList = getViewModel().getPatrolList();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<? extends PatrolListBean>>>, Unit> function2 = new Function1<Result<? extends BasePageResponse<List<? extends PatrolListBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolListFragment.initView.7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<? extends PatrolListBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<? extends PatrolListBean>>> it2) {
                PatrolListFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                BasePageResponse basePageResponse = (BasePageResponse) value;
                if (basePageResponse == null) {
                    return;
                }
                if (basePageResponse.getList() == null) {
                    PatrolListFragment.this.recordAdapter.setList(null);
                    return;
                }
                if (basePageResponse.getPageNo() == 1) {
                    PatrolListFragment.this.recordAdapter.setList((Collection) basePageResponse.getList());
                } else {
                    PatrolListFragment.this.recordAdapter.addData((Collection) basePageResponse.getList());
                }
                if (((List) basePageResponse.getList()).size() < PatrolListFragment.this.pageSize) {
                    BaseLoadMoreModule.loadMoreEnd$default(PatrolListFragment.this.recordAdapter.getLoadMoreModule(), false, 1, null);
                } else {
                    PatrolListFragment.this.recordAdapter.getLoadMoreModule().loadMoreComplete();
                }
            }
        };
        patrolList.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.-$$Lambda$PatrolListFragment$lO-JP1MGtyq4cJy12Yg8iynI0u4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PatrolListFragment.initView$lambda$7(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(PatrolListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.recordAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.currentPage++;
        this$0.getViewModel().getPatrolList(this$0.userId, this$0.siteId, this$0.currentSelectList, this$0.patrolType, this$0.currentPage, this$0.pageSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(PatrolListFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        PatrolListBean item = this$0.recordAdapter.getItem(i);
        int i2 = this$0.currentSelectList;
        if (i2 == 0 || i2 == 4) {
            if (item.getClockIn() == 2) {
                new CommonTipDialog("当前任务未打卡，无法完成任务，请先打卡。", "知道了", false).show(this$0.getChildFragmentManager(), "tipDialog");
                return;
            }
            Date timeDate = DateUtils.getTimeDate(item.getStartTime(), TimeUtil.notSecondFormat);
            DateUtils.getTimeDate(item.getEndTime(), TimeUtil.notSecondFormat);
            Date date = new Date();
            if (timeDate == null) {
                return;
            }
            if (date.before(timeDate)) {
                new CommonTipDialog("当前任务未到巡查时间，无法完成任务，请等待。", "知道了", false).show(this$0.getChildFragmentManager(), "tipDialog");
                return;
            }
            PatrolEditActivity.Companion companion = PatrolEditActivity.INSTANCE;
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.startGo(contextRequireContext, item.getId(), this$0.userId, this$0.jumpActivityWithResult);
            return;
        }
        PatrolDetailActivity.Companion companion2 = PatrolDetailActivity.INSTANCE;
        Context contextRequireContext2 = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        companion2.startGo(contextRequireContext2, item.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(PatrolListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentSelectList = 0;
        this$0.getBinding().tvActivityPatrolListIng.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().tvActivityPatrolListIng.setBackgroundResource(R.drawable.bg_purple23);
        this$0.getBinding().tvActivityPatrolListEnd.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvActivityPatrolListEnd.setBackground(null);
        this$0.getBinding().tvActivityPatrolListOver.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvActivityPatrolListOver.setBackground(null);
        this$0.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(PatrolListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentSelectList = 1;
        this$0.getBinding().tvActivityPatrolListEnd.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().tvActivityPatrolListEnd.setBackgroundResource(R.drawable.bg_purple23);
        this$0.getBinding().tvActivityPatrolListIng.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvActivityPatrolListIng.setBackground(null);
        this$0.getBinding().tvActivityPatrolListOver.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvActivityPatrolListOver.setBackground(null);
        this$0.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(PatrolListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentSelectList = 4;
        this$0.getBinding().tvActivityPatrolListOver.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().tvActivityPatrolListOver.setBackgroundResource(R.drawable.bg_purple23);
        this$0.getBinding().tvActivityPatrolListIng.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvActivityPatrolListIng.setBackground(null);
        this$0.getBinding().tvActivityPatrolListEnd.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvActivityPatrolListEnd.setBackground(null);
        this$0.request();
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

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        request();
    }

    private final void request() {
        showProgressDialog();
        this.currentPage = 1;
        getViewModel().getPatrolList(this.userId, this.siteId, this.currentSelectList, this.patrolType, this.currentPage, this.pageSize);
    }
}
