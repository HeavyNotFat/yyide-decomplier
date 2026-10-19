package com.yd.android_brand_mvp.activity.collect.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.collect.CollectFormDetailActivity;
import com.yd.android_brand_mvp.activity.collect.FormSituationActivity;
import com.yd.android_brand_mvp.activity.collect.viewmodel.CollectFormListViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentRecyclerViewBinding;
import com.yd.android_brand_mvp.databinding.ItemCollectFormListBinding;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.collect.CollectListBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: CollectFormListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u001a\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/CollectFormListFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentRecyclerViewBinding;", "()V", "clickItem", "Lcom/yd/android_brand_mvp/model/collect/CollectListBean;", "formListAdapter", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemCollectFormListBinding;", "isPortrait", "", "jumpActivityWithResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "viewModel", "Lcom/yd/android_brand_mvp/activity/collect/viewmodel/CollectFormListViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/collect/viewmodel/CollectFormListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "onDestroyView", "onEvent", "eventBean", "Lcom/yd/android_brand_mvp/model/EventBean;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parserLastActivityData", "result", "Landroidx/activity/result/ActivityResult;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CollectFormListFragment extends KTBaseFragment<FragmentRecyclerViewBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CollectListBean clickItem;
    private BaseBindingAdapter<ItemCollectFormListBinding, CollectListBean> formListAdapter;
    private boolean isPortrait;
    private final ActivityResultLauncher<Intent> jumpActivityWithResult;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.CollectFormListFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectFormListFragment.kt */
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

    public static final /* synthetic */ FragmentRecyclerViewBinding access$getBinding(CollectFormListFragment collectFormListFragment) {
        return collectFormListFragment.getBinding();
    }

    public CollectFormListFragment() {
        super(AnonymousClass1.INSTANCE);
        final CollectFormListFragment collectFormListFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.CollectFormListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return collectFormListFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.CollectFormListFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(collectFormListFragment, Reflection.getOrCreateKotlinClass(CollectFormListViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.CollectFormListFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.CollectFormListFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.CollectFormListFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = collectFormListFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$CollectFormListFragment$wpqXctLElPMjM3Z9dZDfHhKnoxE
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CollectFormListFragment.jumpActivityWithResult$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ityData(result)\n        }");
        this.jumpActivityWithResult = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: compiled from: CollectFormListFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/CollectFormListFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "id", "", "isPortrait", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String id, boolean isPortrait) {
            Intrinsics.checkNotNullParameter(id, "id");
            CollectFormListFragment collectFormListFragment = new CollectFormListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putBoolean("isPortrait", isPortrait);
            collectFormListFragment.setArguments(bundle);
            return collectFormListFragment;
        }
    }

    private final CollectFormListViewModel getViewModel() {
        return (CollectFormListViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpActivityWithResult$lambda$0(CollectFormListFragment this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.parserLastActivityData(result);
    }

    private final void parserLastActivityData(ActivityResult result) {
        Intent data;
        if (result.getResultCode() != -1 || (data = result.getData()) == null) {
            return;
        }
        String stringExtra = data.getStringExtra(ResultCodeStr.NORMAL_TYPE_CODE);
        if (stringExtra == null) {
            stringExtra = "";
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra, "resultData.getStringExtr…r.NORMAL_TYPE_CODE) ?: \"\"");
        if (!(stringExtra.length() == 0) && Intrinsics.areEqual(stringExtra, ResultCodeStr.COLLECT_UPDATE)) {
            request();
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        initView();
        request();
    }

    private final void initView() {
        getBinding().srlRecycler.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$CollectFormListFragment$Wl956p8DtNkQEdO01szVUUMI5gc
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                CollectFormListFragment.initView$lambda$2(this.f$0);
            }
        });
        getBinding().srlRecycler.setColorSchemeColors(SimpleUtilsKt.asColor(R.color.colorPrimary));
        Bundle arguments = getArguments();
        this.isPortrait = arguments != null ? arguments.getBoolean("isPortrait") : false;
        this.formListAdapter = new BaseBindingAdapter<ItemCollectFormListBinding, CollectListBean>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.CollectFormListFragment.initView.2
            {
                super(null, 1, null);
            }

            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, CollectListBean collectListBean) {
                convertPlus2((VBViewHolder<ItemCollectFormListBinding>) vBViewHolder, collectListBean);
            }

            /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
            public void convertPlus2(VBViewHolder<ItemCollectFormListBinding> holder, CollectListBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemCollectFormListBinding itemCollectFormListBinding = (ItemCollectFormListBinding) holder.getBinding();
                if (itemCollectFormListBinding != null) {
                    CollectFormListFragment collectFormListFragment = CollectFormListFragment.this;
                    itemCollectFormListBinding.tvItemCollectFormListTitle.setText(item.getTitle());
                    itemCollectFormListBinding.tvItemCollectFormListDesc.setText(item.getDescription());
                    int gonnaDoPersonCount = item.getGonnaDoPersonCount();
                    TextView textView = itemCollectFormListBinding.tvItemCollectFormListWatchTip;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = collectFormListFragment.getString(R.string.form_situation);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.form_situation)");
                    String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(item.getAlreadyDidPersonCount()), Integer.valueOf(gonnaDoPersonCount)}, 2));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                    textView.setText(str);
                    TextView textView2 = itemCollectFormListBinding.tvItemCollectFormListSponsor;
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String string2 = collectFormListFragment.getString(R.string.create_by);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.create_by)");
                    String str2 = String.format(string2, Arrays.copyOf(new Object[]{item.getCreator()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                    textView2.setText(str2);
                }
            }

            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public ItemCollectFormListBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                Intrinsics.checkNotNullParameter(parent, "parent");
                ItemCollectFormListBinding itemCollectFormListBindingInflate = ItemCollectFormListBinding.inflate(inflater, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemCollectFormListBindingInflate, "inflate(inflater, parent, false)");
                return itemCollectFormListBindingInflate;
            }
        };
        if (this.isPortrait) {
            getBinding().rvFragmentContent.setLayoutManager(new LinearLayoutManager(requireContext()));
        } else {
            getBinding().rvFragmentContent.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        }
        BaseBindingAdapter<ItemCollectFormListBinding, CollectListBean> baseBindingAdapter = this.formListAdapter;
        BaseBindingAdapter<ItemCollectFormListBinding, CollectListBean> baseBindingAdapter2 = null;
        if (baseBindingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formListAdapter");
            baseBindingAdapter = null;
        }
        baseBindingAdapter.addChildClickViewIds(R.id.tv_item_collect_form_list_watch);
        RecyclerView recyclerView = getBinding().rvFragmentContent;
        BaseBindingAdapter<ItemCollectFormListBinding, CollectListBean> baseBindingAdapter3 = this.formListAdapter;
        if (baseBindingAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formListAdapter");
            baseBindingAdapter3 = null;
        }
        recyclerView.setAdapter(baseBindingAdapter3);
        BaseBindingAdapter<ItemCollectFormListBinding, CollectListBean> baseBindingAdapter4 = this.formListAdapter;
        if (baseBindingAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formListAdapter");
            baseBindingAdapter4 = null;
        }
        baseBindingAdapter4.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$CollectFormListFragment$89qXQ6i_nKl5Ew-9D_FzWQ8TLbE
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CollectFormListFragment.initView$lambda$3(this.f$0, baseQuickAdapter, view, i);
            }
        });
        BaseBindingAdapter<ItemCollectFormListBinding, CollectListBean> baseBindingAdapter5 = this.formListAdapter;
        if (baseBindingAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formListAdapter");
        } else {
            baseBindingAdapter2 = baseBindingAdapter5;
        }
        baseBindingAdapter2.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$CollectFormListFragment$8xyQrOCezWq-OzJsWqHPAP_DrWU
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CollectFormListFragment.initView$lambda$4(this.f$0, baseQuickAdapter, view, i);
            }
        });
        LiveData<List<CollectListBean>> formList = getViewModel().getFormList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends CollectListBean>, Unit> function1 = new Function1<List<? extends CollectListBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.CollectFormListFragment.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends CollectListBean> list) {
                invoke2((List<CollectListBean>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<CollectListBean> list) {
                CollectFormListFragment.this.dismissProgressDialog();
                CollectFormListFragment.access$getBinding(CollectFormListFragment.this).srlRecycler.setRefreshing(false);
                BaseBindingAdapter baseBindingAdapter6 = CollectFormListFragment.this.formListAdapter;
                if (baseBindingAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("formListAdapter");
                    baseBindingAdapter6 = null;
                }
                baseBindingAdapter6.setList(list);
            }
        };
        formList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$CollectFormListFragment$nOo8eOZ6H3TZK_8pbaVGw7_KiRM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CollectFormListFragment.initView$lambda$5(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(CollectFormListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(CollectFormListFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        BaseBindingAdapter<ItemCollectFormListBinding, CollectListBean> baseBindingAdapter = this$0.formListAdapter;
        if (baseBindingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formListAdapter");
            baseBindingAdapter = null;
        }
        this$0.clickItem = baseBindingAdapter.getItem(i);
        Intent intent = new Intent(this$0.requireContext(), (Class<?>) CheackNomalActivity.class);
        intent.putExtra("type", BaseConstant.collectFormList);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(CollectFormListFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        BaseBindingAdapter<ItemCollectFormListBinding, CollectListBean> baseBindingAdapter = this$0.formListAdapter;
        if (baseBindingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formListAdapter");
            baseBindingAdapter = null;
        }
        CollectListBean item = baseBindingAdapter.getItem(i);
        FormSituationActivity.Companion companion = FormSituationActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext, item.getId(), this$0.isPortrait);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(EventBean eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        if (eventBean.type != BaseConstant.collectFormList || this.clickItem == null) {
            return;
        }
        if (!eventBean.isStudent) {
            toastShow("您不是学生");
            return;
        }
        CollectFormDetailActivity.Companion companion = CollectFormDetailActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String str = eventBean.id;
        Intrinsics.checkNotNullExpressionValue(str, "eventBean.id");
        CollectListBean collectListBean = this.clickItem;
        Intrinsics.checkNotNull(collectListBean);
        companion.startGo(contextRequireContext, str, collectListBean, this.jumpActivityWithResult);
    }

    private final void request() {
        showProgressDialog();
        getViewModel().m201getFormList();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
