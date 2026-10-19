package com.yd.android_brand_mvp.activity.fragment.honor;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.honor.HonorScoreDetailActivity;
import com.yd.android_brand_mvp.activity.honor.viewmodel.HonorScoreListViewModel;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentHonorScoreListBinding;
import com.yd.android_brand_mvp.dialog.SelectPopUp;
import com.yd.android_brand_mvp.model.SelectPopBean;
import com.yd.android_brand_mvp.model.honor.HonorScoreCycleBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yyide.chatim_pro.model.honor.HonorScoreDetailBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: HonorScoreListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000b\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\u001a\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorScoreListFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHonorScoreListBinding;", "()V", "activeId", "", "dataSelect", "", "Lcom/yd/android_brand_mvp/model/SelectPopBean;", "identityId", "mAdapter", "com/yd/android_brand_mvp/activity/fragment/honor/HonorScoreListFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorScoreListFragment$mAdapter$1;", "pageNo", "", "pageSize", "selectInfo", "studentPopUp", "Lcom/yd/android_brand_mvp/dialog/SelectPopUp;", "viewModel", "Lcom/yd/android_brand_mvp/activity/honor/viewmodel/HonorScoreListViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/honor/viewmodel/HonorScoreListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initLoadMore", "", "initView", "initViewModel", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "requestDetails", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorScoreListFragment extends KTBaseFragment<FragmentHonorScoreListBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String activeId;
    private List<SelectPopBean> dataSelect;
    private String identityId;
    private final HonorScoreListFragment$mAdapter$1 mAdapter;
    private int pageNo;
    private final int pageSize;
    private SelectPopBean selectInfo;
    private SelectPopUp studentPopUp;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @JvmStatic
    public static final HonorScoreListFragment newInstance(String str, String str2) {
        return INSTANCE.newInstance(str, str2);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.honor.HonorScoreListFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorScoreListFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHonorScoreListBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHonorScoreListBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHonorScoreListBinding;", 0);
        }

        public final FragmentHonorScoreListBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHonorScoreListBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHonorScoreListBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentHonorScoreListBinding access$getBinding(HonorScoreListFragment honorScoreListFragment) {
        return honorScoreListFragment.getBinding();
    }

    public HonorScoreListFragment() {
        super(AnonymousClass1.INSTANCE);
        final HonorScoreListFragment honorScoreListFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorScoreListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return honorScoreListFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorScoreListFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(honorScoreListFragment, Reflection.getOrCreateKotlinClass(HonorScoreListViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorScoreListFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorScoreListFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorScoreListFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = honorScoreListFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.selectInfo = new SelectPopBean("", "");
        this.dataSelect = new ArrayList();
        this.pageNo = 1;
        this.pageSize = 20;
        this.mAdapter = new HonorScoreListFragment$mAdapter$1();
    }

    private final HonorScoreListViewModel getViewModel() {
        return (HonorScoreListViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: compiled from: HonorScoreListFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorScoreListFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorScoreListFragment;", "activeId", "", "identityId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HonorScoreListFragment newInstance(String activeId, String identityId) {
            Intrinsics.checkNotNullParameter(activeId, "activeId");
            Intrinsics.checkNotNullParameter(identityId, "identityId");
            HonorScoreListFragment honorScoreListFragment = new HonorScoreListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("activeId", activeId);
            bundle.putString("identityId", identityId);
            honorScoreListFragment.setArguments(bundle);
            return honorScoreListFragment;
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.activeId = arguments.getString("activeId");
            this.identityId = arguments.getString("identityId");
        }
        initViewModel();
        initLoadMore();
        initView();
    }

    private final void initView() {
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setEmptyView(R.layout.layout_empty);
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorScoreListFragment$kCPTS12kEDV6uS43eU90eGQA6VQ
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HonorScoreListFragment.initView$lambda$1(this.f$0, baseQuickAdapter, view, i);
            }
        });
        HonorScoreListViewModel viewModel = getViewModel();
        String str = this.activeId;
        Intrinsics.checkNotNull(str);
        viewModel.requestActivityCycle(str);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        SelectPopUp selectPopUp = new SelectPopUp(contextRequireContext);
        this.studentPopUp = selectPopUp;
        Intrinsics.checkNotNull(selectPopUp);
        selectPopUp.setPopupGravity(80);
        SelectPopUp selectPopUp2 = this.studentPopUp;
        Intrinsics.checkNotNull(selectPopUp2);
        selectPopUp2.setSubmitCallBack(new SelectPopUp.SubmitCallBack() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorScoreListFragment.initView.2
            @Override // com.yd.android_brand_mvp.dialog.SelectPopUp.SubmitCallBack
            public void getSubmitData(SelectPopBean data) {
                Intrinsics.checkNotNullParameter(data, "data");
                HonorScoreListFragment.access$getBinding(HonorScoreListFragment.this).tvWeek.setText(data.getName());
                HonorScoreListFragment.this.selectInfo = data;
                HonorScoreListFragment.this.pageNo = 1;
                HonorScoreListFragment.this.mAdapter.setList(null);
                HonorScoreListFragment.this.requestDetails();
            }
        });
        getBinding().tvWeek.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorScoreListFragment$znyuhyT0QMHntPeS-Zkq-oPzde8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HonorScoreListFragment.initView$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(HonorScoreListFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        HonorScoreDetailActivity.Companion companion = HonorScoreDetailActivity.INSTANCE;
        Activity mActivity = this$0.mActivity;
        Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
        companion.start(mActivity, this$0.mAdapter.getItem(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(HonorScoreListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SelectPopUp selectPopUp = this$0.studentPopUp;
        if (selectPopUp != null) {
            selectPopUp.setData(this$0.dataSelect, this$0.selectInfo);
        }
        SelectPopUp selectPopUp2 = this$0.studentPopUp;
        Intrinsics.checkNotNull(selectPopUp2);
        if (selectPopUp2.isShowing()) {
            SelectPopUp selectPopUp3 = this$0.studentPopUp;
            Intrinsics.checkNotNull(selectPopUp3);
            selectPopUp3.dismiss();
        } else {
            SelectPopUp selectPopUp4 = this$0.studentPopUp;
            Intrinsics.checkNotNull(selectPopUp4);
            selectPopUp4.showPopupWindow(this$0.getBinding().tvWeek);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestDetails() {
        HonorScoreListViewModel viewModel = getViewModel();
        String str = this.activeId;
        Intrinsics.checkNotNull(str);
        String id = this.selectInfo.getId();
        String str2 = this.identityId;
        Intrinsics.checkNotNull(str2);
        viewModel.requestIdentityDetail(str, id, str2, this.pageNo, this.pageSize);
    }

    private final void initLoadMore() {
        this.mAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorScoreListFragment$WGXQjpKL64iqDk5Fu35CQuWmE3I
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                HonorScoreListFragment.initLoadMore$lambda$3(this.f$0);
            }
        });
        this.mAdapter.getLoadMoreModule().setAutoLoadMore(true);
        this.mAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLoadMore$lambda$3(HonorScoreListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.pageNo++;
        this$0.requestDetails();
    }

    private final void initViewModel() {
        SingleLiveEvent<Result<List<HonorScoreCycleBean>>> activityCycle = getViewModel().getActivityCycle();
        HonorScoreListFragment honorScoreListFragment = this;
        final Function1<Result<? extends List<HonorScoreCycleBean>>, Unit> function1 = new Function1<Result<? extends List<HonorScoreCycleBean>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorScoreListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<HonorScoreCycleBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<HonorScoreCycleBean>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    List<HonorScoreCycleBean> list = (List) value;
                    if (list != null) {
                        HonorScoreListFragment honorScoreListFragment2 = HonorScoreListFragment.this;
                        for (HonorScoreCycleBean honorScoreCycleBean : list) {
                            honorScoreListFragment2.dataSelect.add(new SelectPopBean(honorScoreCycleBean.getId(), honorScoreCycleBean.getSeq()));
                        }
                    }
                    if (!HonorScoreListFragment.this.dataSelect.isEmpty()) {
                        HonorScoreListFragment honorScoreListFragment3 = HonorScoreListFragment.this;
                        honorScoreListFragment3.selectInfo = (SelectPopBean) honorScoreListFragment3.dataSelect.get(HonorScoreListFragment.this.dataSelect.size() - 1);
                        HonorScoreListFragment.access$getBinding(HonorScoreListFragment.this).tvWeek.setText(HonorScoreListFragment.this.selectInfo.getName());
                        HonorScoreListFragment.this.requestDetails();
                        return;
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        activityCycle.observe(honorScoreListFragment, new Observer() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorScoreListFragment$QZw-ayrubd0vjCVqmtFgdM-xYwQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HonorScoreListFragment.initViewModel$lambda$4(function1, obj);
            }
        });
        SingleLiveEvent<Result<BasePageResponse<List<HonorScoreDetailBean>>>> activeResultList = getViewModel().getActiveResultList();
        final Function1<Result<? extends BasePageResponse<List<HonorScoreDetailBean>>>, Unit> function2 = new Function1<Result<? extends BasePageResponse<List<HonorScoreDetailBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorScoreListFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<HonorScoreDetailBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<HonorScoreDetailBean>>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    if (basePageResponse != null) {
                        HonorScoreListFragment honorScoreListFragment2 = HonorScoreListFragment.this;
                        if (honorScoreListFragment2.pageNo == 1) {
                            honorScoreListFragment2.mAdapter.setList((Collection) basePageResponse.getList());
                        } else {
                            List list = (List) basePageResponse.getList();
                            if (list != null) {
                                honorScoreListFragment2.mAdapter.addData((Collection) list);
                            }
                        }
                        List list2 = (List) basePageResponse.getList();
                        Integer numValueOf = list2 != null ? Integer.valueOf(list2.size()) : null;
                        Intrinsics.checkNotNull(numValueOf);
                        if (numValueOf.intValue() < honorScoreListFragment2.pageSize) {
                            BaseLoadMoreModule.loadMoreEnd$default(honorScoreListFragment2.mAdapter.getLoadMoreModule(), false, 1, null);
                            return;
                        } else {
                            honorScoreListFragment2.mAdapter.getLoadMoreModule().loadMoreComplete();
                            return;
                        }
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        activeResultList.observe(honorScoreListFragment, new Observer() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorScoreListFragment$gznbOvHDr9wPaAU5GzKRvprvbU4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HonorScoreListFragment.initViewModel$lambda$5(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
