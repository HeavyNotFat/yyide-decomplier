package com.yd.android_brand_mvp.activity.repair;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel;
import com.yd.android_brand_mvp.adapter.repair.RepairListAdapter;
import com.yd.android_brand_mvp.base.BaseActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentRecyclerViewBinding;
import com.yd.android_brand_mvp.dialog.FormDetailDialog;
import com.yd.android_brand_mvp.dialog.FormRevokeDialog;
import com.yd.android_brand_mvp.listener.StringListener;
import com.yd.android_brand_mvp.model.collect.UserVerifyBean;
import com.yd.android_brand_mvp.model.userspace.LeaveDetailBean;
import com.yd.android_brand_mvp.model.userspace.LeaveRecordBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import java.util.Collection;
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
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: RepairListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/activity/repair/RepairListFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentRecyclerViewBinding;", "()V", "current", "", "dialog", "Lcom/yd/android_brand_mvp/dialog/FormDetailDialog;", "recordAdapter", "Lcom/yd/android_brand_mvp/adapter/repair/RepairListAdapter;", InnerConstant.Db.size, "verifyData", "Lcom/yd/android_brand_mvp/model/collect/UserVerifyBean;", "viewModel", "Lcom/yd/android_brand_mvp/activity/repair/viewmodel/RepairViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/repair/viewmodel/RepairViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "requestListData", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RepairListFragment extends KTBaseFragment<FragmentRecyclerViewBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int current;
    private FormDetailDialog dialog;
    private final RepairListAdapter recordAdapter;
    private final int size;
    private UserVerifyBean verifyData;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.repair.RepairListFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: RepairListFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentRecyclerViewBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentRecyclerViewBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentRecyclerViewBinding;", 0);
        }

        public final FragmentRecyclerViewBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentRecyclerViewBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentRecyclerViewBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public RepairListFragment() {
        super(AnonymousClass1.INSTANCE);
        this.recordAdapter = new RepairListAdapter();
        final RepairListFragment repairListFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.repair.RepairListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return repairListFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.repair.RepairListFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(repairListFragment, Reflection.getOrCreateKotlinClass(RepairViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.repair.RepairListFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.repair.RepairListFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.repair.RepairListFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = repairListFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.size = 20;
        this.current = 1;
    }

    public static final /* synthetic */ FragmentRecyclerViewBinding access$getBinding(RepairListFragment repairListFragment) {
        return repairListFragment.getBinding();
    }

    /* JADX INFO: compiled from: RepairListFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/repair/RepairListFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/repair/RepairListFragment;", "data", "Lcom/yd/android_brand_mvp/model/collect/UserVerifyBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RepairListFragment newInstance(UserVerifyBean data) {
            Intrinsics.checkNotNullParameter(data, "data");
            Bundle bundle = new Bundle();
            RepairListFragment repairListFragment = new RepairListFragment();
            bundle.putParcelable("verifyData", data);
            repairListFragment.setArguments(bundle);
            return repairListFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RepairViewModel getViewModel() {
        return (RepairViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        UserVerifyBean userVerifyBean;
        Bundle arguments = getArguments();
        if (arguments == null || (userVerifyBean = (UserVerifyBean) arguments.getParcelable("verifyData")) == null) {
            userVerifyBean = new UserVerifyBean(false, null, null, null, 15, null);
        }
        this.verifyData = userVerifyBean;
        getBinding().rvFragmentContent.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().rvFragmentContent.setAdapter(this.recordAdapter);
        getBinding().rvFragmentContent.setBackgroundColor(SimpleUtilsKt.asColor(R.color.white));
        this.recordAdapter.setEmptyView(R.layout.item_null_layout_4);
        this.recordAdapter.getLoadMoreModule().setAutoLoadMore(true);
        this.recordAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(true);
        this.recordAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$RepairListFragment$kSGO-McDZMo2bpCJrODmGxIXtL0
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                RepairListFragment.initView$lambda$0(this.f$0);
            }
        });
        this.recordAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$RepairListFragment$yHGX5W0UHqjHF3tCveIWs-2JpHI
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RepairListFragment.initView$lambda$1(this.f$0, baseQuickAdapter, view, i);
            }
        });
        getBinding().srlRecycler.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$RepairListFragment$9ofJwGw2BK1yW-eDtC-sKlN8FtY
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                RepairListFragment.initView$lambda$2(this.f$0);
            }
        });
        LiveData<Result<BasePageResponse<List<LeaveRecordBean>>>> recordList = getViewModel().getRecordList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<? extends LeaveRecordBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<? extends LeaveRecordBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.repair.RepairListFragment.initView.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<? extends LeaveRecordBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<? extends LeaveRecordBean>>> it2) {
                RepairListFragment.this.dismissProgressDialog();
                RepairListFragment.access$getBinding(RepairListFragment.this).srlRecycler.setRefreshing(false);
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
                    BaseLoadMoreModule.loadMoreEnd$default(RepairListFragment.this.recordAdapter.getLoadMoreModule(), false, 1, null);
                    return;
                }
                if (RepairListFragment.this.current == 1) {
                    RepairListFragment.this.recordAdapter.setList((Collection) basePageResponse.getList());
                } else {
                    RepairListFragment.this.recordAdapter.addData((Collection) basePageResponse.getList());
                }
                if (((List) basePageResponse.getList()).size() < RepairListFragment.this.size) {
                    BaseLoadMoreModule.loadMoreEnd$default(RepairListFragment.this.recordAdapter.getLoadMoreModule(), false, 1, null);
                } else {
                    RepairListFragment.this.recordAdapter.getLoadMoreModule().loadMoreComplete();
                }
            }
        };
        recordList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$RepairListFragment$W1Btb2ZyVcGp5dV8pzzebEGmWMc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RepairListFragment.initView$lambda$3(function1, obj);
            }
        });
        LiveData<Result<LeaveDetailBean>> repairDetail = getViewModel().getRepairDetail();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final AnonymousClass5 anonymousClass5 = new AnonymousClass5();
        repairDetail.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$RepairListFragment$1MkXVSv-_t3CXWhMA6IQBS6CSKY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RepairListFragment.initView$lambda$4(anonymousClass5, obj);
            }
        });
        LiveData<Result<Boolean>> revokeResult = getViewModel().getRevokeResult();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function2 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.repair.RepairListFragment.initView.6
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
                RepairListFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                Boolean bool = (Boolean) value;
                if (bool == null || !bool.booleanValue()) {
                    return;
                }
                FormDetailDialog formDetailDialog = RepairListFragment.this.dialog;
                if (formDetailDialog != null) {
                    formDetailDialog.dismiss();
                }
                ToastUtil.showBottomView(RepairListFragment.this.requireContext(), "已撤销");
                RepairListFragment.this.requestListData();
            }
        };
        revokeResult.observe(viewLifecycleOwner3, new Observer() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$RepairListFragment$pm5HUhWCZ8_Tx36jlm8faZueRFg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RepairListFragment.initView$lambda$5(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(RepairListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.current++;
        this$0.requestListData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(RepairListFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        LeaveRecordBean leaveRecordBean = this$0.recordAdapter.getData().get(i);
        this$0.showProgressDialog();
        this$0.getViewModel().getRepairDetail(leaveRecordBean.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(RepairListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.current = 1;
        this$0.requestListData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.repair.RepairListFragment$initView$5, reason: invalid class name */
    /* JADX INFO: compiled from: RepairListFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/userspace/LeaveDetailBean;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass5 extends Lambda implements Function1<Result<? extends LeaveDetailBean>, Unit> {
        AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Result<? extends LeaveDetailBean> result) {
            invoke2(result);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Result<? extends LeaveDetailBean> it2) {
            RepairListFragment.this.dismissProgressDialog();
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            Object value = it2.getValue();
            if (Result.m597isFailureimpl(value)) {
                value = null;
            }
            final LeaveDetailBean leaveDetailBean = (LeaveDetailBean) value;
            if (leaveDetailBean == null) {
                return;
            }
            RepairListFragment.this.dialog = new FormDetailDialog("设备保修", leaveDetailBean, false, 4, null);
            FormDetailDialog formDetailDialog = RepairListFragment.this.dialog;
            Intrinsics.checkNotNull(formDetailDialog);
            final RepairListFragment repairListFragment = RepairListFragment.this;
            formDetailDialog.setCallBack(new StringListener() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$RepairListFragment$initView$5$-CvQZKJC0WnZGG2O7GB6Rrl6XJo
                @Override // com.yd.android_brand_mvp.listener.StringListener
                public final void getStringData(String str) {
                    RepairListFragment.AnonymousClass5.invoke$lambda$2(repairListFragment, leaveDetailBean, str);
                }
            });
            FormDetailDialog formDetailDialog2 = RepairListFragment.this.dialog;
            Intrinsics.checkNotNull(formDetailDialog2);
            formDetailDialog2.show(RepairListFragment.this.getChildFragmentManager(), "leaveDetail");
            FragmentActivity fragmentActivityRequireActivity = RepairListFragment.this.requireActivity();
            BaseActivity baseActivity = fragmentActivityRequireActivity instanceof BaseActivity ? (BaseActivity) fragmentActivityRequireActivity : null;
            if (baseActivity != null) {
                baseActivity.setTempCountDownStatus(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(final RepairListFragment this$0, final LeaveDetailBean info, String detailStr) {
            String userName;
            String userId;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(info, "$info");
            Intrinsics.checkNotNullParameter(detailStr, "detailStr");
            int iHashCode = detailStr.hashCode();
            if (iHashCode == -1068795718) {
                if (detailStr.equals("modify")) {
                    FormRevokeDialog.Companion companion = FormRevokeDialog.INSTANCE;
                    String string = this$0.getString(R.string.repair_modify_title);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.repair_modify_title)");
                    String string2 = this$0.getString(R.string.repair_modify_remark);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.repair_modify_remark)");
                    String string3 = this$0.getString(R.string.repair_modify_tip);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.repair_modify_tip)");
                    FormRevokeDialog formRevokeDialogNewInstance = companion.newInstance(string, string2, string3);
                    formRevokeDialogNewInstance.setCallBack(new StringListener() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$RepairListFragment$initView$5$oJiHaVnJLXAF1LtmgUXTmnHdrrw
                        @Override // com.yd.android_brand_mvp.listener.StringListener
                        public final void getStringData(String str) {
                            RepairListFragment.AnonymousClass5.invoke$lambda$2$lambda$1(this$0, info, str);
                        }
                    });
                    formRevokeDialogNewInstance.show(this$0.getChildFragmentManager(), "reasonDialog");
                    return;
                }
                return;
            }
            if (iHashCode != -934343034) {
                if (iHashCode == 1671672458 && detailStr.equals("dismiss")) {
                    FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
                    BaseActivity baseActivity = fragmentActivityRequireActivity instanceof BaseActivity ? (BaseActivity) fragmentActivityRequireActivity : null;
                    if (baseActivity != null) {
                        baseActivity.setTempCountDownStatus(true);
                        return;
                    }
                    return;
                }
                return;
            }
            if (detailStr.equals("revoke")) {
                if (info.getStatus() == 2) {
                    FormRevokeDialog formRevokeDialogNewInstance2 = FormRevokeDialog.INSTANCE.newInstance();
                    formRevokeDialogNewInstance2.setCallBack(new StringListener() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$RepairListFragment$initView$5$msXm12OxBrDCO9Odys00TdDF48o
                        @Override // com.yd.android_brand_mvp.listener.StringListener
                        public final void getStringData(String str) {
                            RepairListFragment.AnonymousClass5.invoke$lambda$2$lambda$0(this$0, info, str);
                        }
                    });
                    formRevokeDialogNewInstance2.show(this$0.getChildFragmentManager(), "reasonDialog");
                    return;
                }
                this$0.showProgressDialog();
                RepairViewModel viewModel = this$0.getViewModel();
                String procInstId = info.getProcInstId();
                String schoolId = SpData.getSchoolId();
                Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
                UserVerifyBean userVerifyBean = this$0.verifyData;
                String str = (userVerifyBean == null || (userId = userVerifyBean.getUserId()) == null) ? "" : userId;
                UserVerifyBean userVerifyBean2 = this$0.verifyData;
                int i = 0;
                if (userVerifyBean2 != null && userVerifyBean2.isStudent()) {
                    i = 1;
                }
                int i2 = i ^ 1;
                UserVerifyBean userVerifyBean3 = this$0.verifyData;
                RepairViewModel.revokeLeave$default(viewModel, procInstId, schoolId, str, i2, (userVerifyBean3 == null || (userName = userVerifyBean3.getUserName()) == null) ? "" : userName, null, 32, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2$lambda$0(RepairListFragment this$0, LeaveDetailBean info, String str) {
            String userName;
            String userId;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(info, "$info");
            Intrinsics.checkNotNullParameter(str, "str");
            this$0.showProgressDialog();
            RepairViewModel viewModel = this$0.getViewModel();
            String procInstId = info.getProcInstId();
            String schoolId = SpData.getSchoolId();
            Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
            UserVerifyBean userVerifyBean = this$0.verifyData;
            String str2 = (userVerifyBean == null || (userId = userVerifyBean.getUserId()) == null) ? "" : userId;
            UserVerifyBean userVerifyBean2 = this$0.verifyData;
            int i = 0;
            if (userVerifyBean2 != null && userVerifyBean2.isStudent()) {
                i = 1;
            }
            int i2 = i ^ 1;
            UserVerifyBean userVerifyBean3 = this$0.verifyData;
            viewModel.revokeLeave(procInstId, schoolId, str2, i2, (userVerifyBean3 == null || (userName = userVerifyBean3.getUserName()) == null) ? "" : userName, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2$lambda$1(RepairListFragment this$0, LeaveDetailBean info, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(info, "$info");
            Intrinsics.checkNotNullParameter(str, "str");
            FormDetailDialog formDetailDialog = this$0.dialog;
            Intrinsics.checkNotNull(formDetailDialog);
            formDetailDialog.dismiss();
            RepairActivity.Companion companion = RepairActivity.INSTANCE;
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            UserVerifyBean userVerifyBean = this$0.verifyData;
            Intrinsics.checkNotNull(userVerifyBean);
            companion.startFromModify(contextRequireContext, userVerifyBean, info.getJsonData(), info.getFromKey(), info.getId(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.current = 1;
        requestListData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestListData() {
        if (this.verifyData != null) {
            showProgressDialog();
            String siteId = SpData.getSiteId();
            String schoolId = SpData.getSchoolId();
            RepairViewModel viewModel = getViewModel();
            Intrinsics.checkNotNullExpressionValue(siteId, "siteId");
            Intrinsics.checkNotNullExpressionValue(schoolId, "schoolId");
            viewModel.getRepairList(siteId, schoolId, this.current, this.size);
        }
    }
}
