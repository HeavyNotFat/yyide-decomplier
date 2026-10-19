package com.yd.android_brand_mvp.activity.active.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.active.ActiveDetailsActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentActiveApplyListBinding;
import com.yd.android_brand_mvp.databinding.ItemActiveApplyListBinding;
import com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel;
import com.yd.android_brand_mvp.model.active.ActiveRegistrationBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.ArrayList;
import java.util.Arrays;
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
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ActiveListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u001a\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/activity/active/fragment/ActiveListFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentActiveApplyListBinding;", "()V", "dataList", "", "", "mAdapter", "com/yd/android_brand_mvp/activity/active/fragment/ActiveListFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/activity/active/fragment/ActiveListFragment$mAdapter$1;", "pageNo", "", "viewModel", "Lcom/yd/android_brand_mvp/landscape/active/viewModel/ActiveApplyFragmentViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/active/viewModel/ActiveApplyFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "initViewModel", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActiveListFragment extends KTBaseFragment<FragmentActiveApplyListBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private List<String> dataList;
    private final ActiveListFragment$mAdapter$1 mAdapter;
    private int pageNo;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.active.fragment.ActiveListFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActiveListFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentActiveApplyListBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentActiveApplyListBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentActiveApplyListBinding;", 0);
        }

        public final FragmentActiveApplyListBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentActiveApplyListBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentActiveApplyListBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.yd.android_brand_mvp.activity.active.fragment.ActiveListFragment$mAdapter$1] */
    public ActiveListFragment() {
        super(AnonymousClass1.INSTANCE);
        final ActiveListFragment activeListFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.active.fragment.ActiveListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return activeListFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.active.fragment.ActiveListFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(activeListFragment, Reflection.getOrCreateKotlinClass(ActiveApplyFragmentViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.active.fragment.ActiveListFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.active.fragment.ActiveListFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.active.fragment.ActiveListFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = activeListFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.dataList = new ArrayList();
        this.pageNo = 1;
        this.mAdapter = new BaseQuickAdapter<ActiveRegistrationBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.activity.active.fragment.ActiveListFragment$mAdapter$1
            {
                super(R.layout.item_active_apply_list, null, 2, null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, ActiveRegistrationBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemActiveApplyListBinding itemActiveApplyListBindingBind = ItemActiveApplyListBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemActiveApplyListBindingBind, "bind(holder.itemView)");
                itemActiveApplyListBindingBind.tvActiveTitle.setText(item.getActivityName());
                TextView textView = itemActiveApplyListBindingBind.tvActiveObject;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("报名对象：%s", Arrays.copyOf(new Object[]{item.getRangeNames()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                textView.setText(str);
                TextView textView2 = itemActiveApplyListBindingBind.tvActiveDate;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str2 = String.format("活动时间：%s 至 %s", Arrays.copyOf(new Object[]{item.getActivityStartTime(), item.getActivityEndTime()}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                textView2.setText(str2);
                TextView textView3 = itemActiveApplyListBindingBind.tvActiveApplyDate;
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String str3 = String.format("报名时间：%s 至 %s", Arrays.copyOf(new Object[]{item.getRegisterStartTime(), item.getRegisterEndTime()}, 2));
                Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
                textView3.setText(str3);
                if (item.getTotal() == 0) {
                    TextView textView4 = itemActiveApplyListBindingBind.tvActiveTotalNumber;
                    StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                    String str4 = String.format("总报名额度：%s", Arrays.copyOf(new Object[]{"不限制"}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(format, *args)");
                    textView4.setText(str4);
                } else {
                    TextView textView5 = itemActiveApplyListBindingBind.tvActiveTotalNumber;
                    StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                    String str5 = String.format("总报名额度：%s", Arrays.copyOf(new Object[]{Integer.valueOf(item.getTotal())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str5, "format(format, *args)");
                    textView5.setText(str5);
                }
                TextView textView6 = itemActiveApplyListBindingBind.tvActivePeopleNumber;
                StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
                String str6 = String.format("已报名：%s", Arrays.copyOf(new Object[]{Integer.valueOf(item.getEnrollCount())}, 1));
                Intrinsics.checkNotNullExpressionValue(str6, "format(format, *args)");
                textView6.setText(str6);
                if (ScreenUtils.isPortrait()) {
                    GlideUtil.loadRadiusImage(this.this$0.requireContext(), item.getCoverImg(), itemActiveApplyListBindingBind.ivCover, R.drawable.icon_active_default_bg, SizeUtils.dp2px(10.0f));
                }
                itemActiveApplyListBindingBind.tvActiveStatus.setText(item.getStatusName());
                String statusName = item.getStatusName();
                if (Intrinsics.areEqual(statusName, "未开始")) {
                    itemActiveApplyListBindingBind.tvActiveStatus.setBackgroundResource(R.drawable.bg_ffac08_50);
                } else if (Intrinsics.areEqual(statusName, "已结束")) {
                    itemActiveApplyListBindingBind.tvActiveStatus.setBackgroundResource(R.drawable.bg_3eaef3_50);
                } else {
                    itemActiveApplyListBindingBind.tvActiveStatus.setBackgroundResource(R.drawable.bg_4cc89b_50);
                }
            }
        };
    }

    public static final /* synthetic */ FragmentActiveApplyListBinding access$getBinding(ActiveListFragment activeListFragment) {
        return activeListFragment.getBinding();
    }

    /* JADX INFO: compiled from: ActiveListFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/activity/active/fragment/ActiveListFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/active/fragment/ActiveListFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ActiveListFragment newInstance() {
            return new ActiveListFragment();
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
        initViewModel();
    }

    public final void initView() {
        if (ScreenUtils.isPortrait()) {
            getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        } else {
            getBinding().recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        }
        getBinding().recyclerView.setAdapter(this.mAdapter);
        setEmptyView(R.layout.item_null_layout_4);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.active.fragment.-$$Lambda$ActiveListFragment$bfERQITLvcNNDCLDGWQtS3M5YOw
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ActiveListFragment.initView$lambda$0(this.f$0, baseQuickAdapter, view, i);
            }
        });
        getBinding().tvPrevious.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.active.fragment.-$$Lambda$ActiveListFragment$BZXogFz5BO-IOAUSZXl_Udxbdh4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveListFragment.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().tvNextPage.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.active.fragment.-$$Lambda$ActiveListFragment$5UjsRnmDO5uNBPrqvStLh5t-zK4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveListFragment.initView$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ActiveListFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        ActiveRegistrationBean item = this$0.mAdapter.getItem(i);
        ActiveDetailsActivity.Companion companion = ActiveDetailsActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext, item.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(ActiveListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showProgressDialog();
        int i = this$0.pageNo;
        if (i > 1) {
            int i2 = i - 1;
            this$0.pageNo = i2;
            if (i2 == 1) {
                this$0.getBinding().tvPrevious.setTextColor(this$0.getResources().getColor(R.color.black11));
            }
            this$0.getViewModel().getActiveList(this$0.pageNo, 9);
            return;
        }
        this$0.getBinding().tvPrevious.setTextColor(this$0.getResources().getColor(R.color.black11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(ActiveListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showProgressDialog();
        this$0.pageNo++;
        this$0.getBinding().tvPrevious.setTextColor(this$0.getResources().getColor(R.color.colorPrimaryDark));
        this$0.getViewModel().getActiveList(this$0.pageNo, 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void initViewModel() {
        MutableLiveData<Result<BasePageResponse<List<ActiveRegistrationBean>>>> activeList = getViewModel().getActiveList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<ActiveRegistrationBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<ActiveRegistrationBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.active.fragment.ActiveListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<ActiveRegistrationBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<ActiveRegistrationBean>>> it2) {
                ActiveListFragment.this.dismissProgressDialog();
                ActiveListFragment.access$getBinding(ActiveListFragment.this).tvNextPage.setEnabled(true);
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    if (basePageResponse != null) {
                        ActiveListFragment activeListFragment = ActiveListFragment.this;
                        activeListFragment.mAdapter.setList((Collection) basePageResponse.getList());
                        if (basePageResponse.getList() != null && ((List) basePageResponse.getList()).size() >= 9) {
                            ActiveListFragment.access$getBinding(activeListFragment).tvNextPage.setTextColor(activeListFragment.getResources().getColor(R.color.colorPrimaryDark));
                        } else {
                            ActiveListFragment.access$getBinding(activeListFragment).tvNextPage.setTextColor(activeListFragment.getResources().getColor(R.color.black11));
                            ActiveListFragment.access$getBinding(activeListFragment).tvNextPage.setEnabled(false);
                        }
                    }
                }
            }
        };
        activeList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.active.fragment.-$$Lambda$ActiveListFragment$vCbT0VYUWQkSyMZ7pIKrj7kKV0Q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveListFragment.initViewModel$lambda$3(function1, obj);
            }
        });
        getViewModel().getActiveList(this.pageNo, 9);
    }
}
