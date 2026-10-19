package com.yd.android_brand_mvp.landscape.active;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.active.ActiveDetailsActivity;
import com.yd.android_brand_mvp.activity.active.ActiveListActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentActiveApplyFragment2x2Binding;
import com.yd.android_brand_mvp.databinding.ItemActiveApply2x2Binding;
import com.yd.android_brand_mvp.dialog.UpdateTitleDialog;
import com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel;
import com.yd.android_brand_mvp.model.active.ActiveRegistrationBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.MMKVUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
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

/* JADX INFO: compiled from: ActiveApplyFragment2x2.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u001a\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/active/ActiveApplyFragment2x2;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentActiveApplyFragment2x2Binding;", "()V", "mAdapter", "com/yd/android_brand_mvp/landscape/active/ActiveApplyFragment2x2$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/active/ActiveApplyFragment2x2$mAdapter$1;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/active/viewModel/ActiveApplyFragmentViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/active/viewModel/ActiveApplyFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "", "initView", "initViewModel", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActiveApplyFragment2x2 extends KTBaseFragment<FragmentActiveApplyFragment2x2Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LAYOUT_TAG = "layoutTag";
    private final ActiveApplyFragment2x2$mAdapter$1 mAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment2x2$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActiveApplyFragment2x2.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentActiveApplyFragment2x2Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentActiveApplyFragment2x2Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentActiveApplyFragment2x2Binding;", 0);
        }

        public final FragmentActiveApplyFragment2x2Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentActiveApplyFragment2x2Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentActiveApplyFragment2x2Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment2x2$mAdapter$1] */
    public ActiveApplyFragment2x2() {
        super(AnonymousClass1.INSTANCE);
        final ActiveApplyFragment2x2 activeApplyFragment2x2 = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment2x2$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return activeApplyFragment2x2;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment2x2$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(activeApplyFragment2x2, Reflection.getOrCreateKotlinClass(ActiveApplyFragmentViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment2x2$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment2x2$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment2x2$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = activeApplyFragment2x2.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.mAdapter = new BaseQuickAdapter<ActiveRegistrationBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment2x2$mAdapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, ActiveRegistrationBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemActiveApply2x2Binding itemActiveApply2x2BindingBind = ItemActiveApply2x2Binding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemActiveApply2x2BindingBind, "bind(holder.itemView)");
                itemActiveApply2x2BindingBind.tvActiveName.setText(item.getActivityName());
                itemActiveApply2x2BindingBind.tvActiveStatus.setText(item.getStatusName());
                String statusName = item.getStatusName();
                if (Intrinsics.areEqual(statusName, "未开始")) {
                    itemActiveApply2x2BindingBind.tvActiveStatus.setBackgroundResource(R.drawable.bg_ffac08_50);
                } else if (Intrinsics.areEqual(statusName, "已结束")) {
                    itemActiveApply2x2BindingBind.tvActiveStatus.setBackgroundResource(R.drawable.bg_3eaef3_50);
                } else {
                    itemActiveApply2x2BindingBind.tvActiveStatus.setBackgroundResource(R.drawable.bg_4cc89b_50);
                }
            }
        };
    }

    /* JADX INFO: compiled from: ActiveApplyFragment2x2.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/active/ActiveApplyFragment2x2$Companion;", "", "()V", "LAYOUT_TAG", "", "getLAYOUT_TAG", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/active/ActiveApplyFragment2x2;", "layoutTag", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLAYOUT_TAG() {
            return ActiveApplyFragment2x2.LAYOUT_TAG;
        }

        public final ActiveApplyFragment2x2 newInstance(String layoutTag) {
            Intrinsics.checkNotNullParameter(layoutTag, "layoutTag");
            ActiveApplyFragment2x2 activeApplyFragment2x2 = new ActiveApplyFragment2x2();
            Bundle bundle = new Bundle();
            bundle.putString(ActiveApplyFragment2x2.INSTANCE.getLAYOUT_TAG(), layoutTag);
            activeApplyFragment2x2.setArguments(bundle);
            return activeApplyFragment2x2;
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
        final String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(LAYOUT_TAG)) == null) {
            string = "";
        }
        if (Intrinsics.areEqual(string, "sbhdbm2x2")) {
            getBinding().clContent.getLayoutParams().width = SizeUtils.px2dp(320.0f);
            getBinding().clContent.getLayoutParams().height = SizeUtils.px2dp(424.0f);
        }
        String string2 = MMKVUtils.INSTANCE.getString(string);
        TextView textView = getBinding().top.title;
        String string3 = string2;
        if (TextUtils.isEmpty(string3)) {
            string3 = getString(R.string.active_apply_title);
        }
        textView.setText(string3);
        TextView textView2 = getBinding().top.tvLayoutHeadSubTitle;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.top.tvLayoutHeadSubTitle");
        SimpleUtilsKt.show(textView2);
        getBinding().top.tvLayoutHeadSubTitle.setText(getString(R.string.view_more_title));
        getBinding().top.tvLayoutHeadSubTitle.setTextColor(getResources().getColor(R.color.purple2));
        getBinding().top.tvLayoutHeadSubTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.active.-$$Lambda$ActiveApplyFragment2x2$AGrayxLIF60gtvWkvaLG6mYVoW4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveApplyFragment2x2.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().top.title.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.landscape.active.-$$Lambda$ActiveApplyFragment2x2$MP6RWlz2ZKE6okQhzcdx54hAwcQ
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return ActiveApplyFragment2x2.initView$lambda$1(string, this, view);
            }
        });
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        setEmptyView(R.layout.item_min_null_layout_2_2);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.active.-$$Lambda$ActiveApplyFragment2x2$2ew3oCxBChrDHdcJqAH_HN68gg4
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ActiveApplyFragment2x2.initView$lambda$2(this.f$0, baseQuickAdapter, view, i);
            }
        });
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ActiveApplyFragment2x2 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActiveListActivity.Companion companion = ActiveListActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext, this$0.getBinding().top.title.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$1(final String tagLayout, final ActiveApplyFragment2x2 this$0, View view) {
        Intrinsics.checkNotNullParameter(tagLayout, "$tagLayout");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UpdateTitleDialog updateTitleDialog = new UpdateTitleDialog(tagLayout, this$0.getBinding().top.title.getText().toString());
        updateTitleDialog.setCallBack(new UpdateTitleDialog.CallBack() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment2x2$initView$2$1
            @Override // com.yd.android_brand_mvp.dialog.UpdateTitleDialog.CallBack
            public void clickSubmit() {
                String string = MMKVUtils.INSTANCE.getString(tagLayout);
                TextView textView = this$0.getBinding().top.title;
                String string2 = string;
                if (TextUtils.isEmpty(string2)) {
                    string2 = this$0.getString(R.string.active_apply_title);
                }
                textView.setText(string2);
            }
        });
        updateTitleDialog.show(this$0.getParentFragmentManager(), "updateTitleDialog");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(ActiveApplyFragment2x2 this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this$0.secondaryPagePermissions()) {
            ActiveRegistrationBean item = this$0.mAdapter.getItem(i);
            ActiveDetailsActivity.Companion companion = ActiveDetailsActivity.INSTANCE;
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.startGo(contextRequireContext, item.getId());
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (2401 == id) {
            getViewModel().getActiveList(1, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void initViewModel() {
        MutableLiveData<Result<BasePageResponse<List<ActiveRegistrationBean>>>> activeList = getViewModel().getActiveList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<ActiveRegistrationBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<ActiveRegistrationBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment2x2.initViewModel.1
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
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("获取活动报名2x2：");
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                sb.append(GsonUtils.toJson(value));
                objArr[0] = sb.toString();
                LogUtils.i(objArr);
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value2 = it2.getValue();
                    BasePageResponse basePageResponse = (BasePageResponse) (Result.m597isFailureimpl(value2) ? null : value2);
                    if (basePageResponse != null) {
                        setList((Collection) basePageResponse.getList());
                    }
                }
            }
        };
        activeList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.active.-$$Lambda$ActiveApplyFragment2x2$JpgpsGHS6s6-RZAy4FRKJ_v9hsc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveApplyFragment2x2.initViewModel$lambda$3(function1, obj);
            }
        });
        getViewModel().getActiveList(1, 10);
    }
}
