package com.yd.android_brand_mvp.landscape.active;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentMyRegisterationFragmentBinding;
import com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel;
import com.yd.android_brand_mvp.model.active.ActiveMyRegistrationBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
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
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MyRegistrationFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0005\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\u001a\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/active/MyRegistrationFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentMyRegisterationFragmentBinding;", "()V", "mAdapter", "com/yd/android_brand_mvp/landscape/active/MyRegistrationFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/active/MyRegistrationFragment$mAdapter$1;", "pageNo", "", "pageSize", "searchStr", "", "userId", "viewModel", "Lcom/yd/android_brand_mvp/landscape/active/viewModel/ActiveApplyFragmentViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/active/viewModel/ActiveApplyFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initLoadMore", "", "initView", "initViewModel", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MyRegistrationFragment extends KTBaseFragment<FragmentMyRegisterationFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MyRegistrationFragment$mAdapter$1 mAdapter;
    private int pageNo;
    private int pageSize;
    private String searchStr;
    private String userId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.active.MyRegistrationFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: MyRegistrationFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentMyRegisterationFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentMyRegisterationFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentMyRegisterationFragmentBinding;", 0);
        }

        public final FragmentMyRegisterationFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentMyRegisterationFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentMyRegisterationFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public MyRegistrationFragment() {
        super(AnonymousClass1.INSTANCE);
        final MyRegistrationFragment myRegistrationFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.active.MyRegistrationFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return myRegistrationFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.active.MyRegistrationFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(myRegistrationFragment, Reflection.getOrCreateKotlinClass(ActiveApplyFragmentViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.active.MyRegistrationFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.active.MyRegistrationFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.active.MyRegistrationFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = myRegistrationFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.userId = "";
        this.searchStr = "";
        this.pageSize = 10;
        this.pageNo = 1;
        this.mAdapter = new MyRegistrationFragment$mAdapter$1();
    }

    /* JADX INFO: compiled from: MyRegistrationFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/active/MyRegistrationFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/active/MyRegistrationFragment;", "id", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MyRegistrationFragment newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            MyRegistrationFragment myRegistrationFragment = new MyRegistrationFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            myRegistrationFragment.setArguments(bundle);
            return myRegistrationFragment;
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
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setEmptyView(R.layout.item_min_null_layout_2);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("id");
            if (string == null) {
                string = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(\"id\") ?: \"\"");
            }
            this.userId = string;
        }
        getBinding().llReset.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.active.-$$Lambda$MyRegistrationFragment$3meilI1NFyS7mqzvlkMsw7_UbNc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRegistrationFragment.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().llQuery.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.active.-$$Lambda$MyRegistrationFragment$S45AQZek_uXjwGf6ZZUeukPfrrc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRegistrationFragment.initView$lambda$2(this.f$0, view);
            }
        });
        initViewModel();
        initLoadMore();
        request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(MyRegistrationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().etSearch.setText("");
        this$0.searchStr = "";
        this$0.pageNo = 1;
        this$0.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(MyRegistrationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = StringsKt.trim((CharSequence) this$0.getBinding().etSearch.getText().toString()).toString();
        this$0.searchStr = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this$0.pageNo = 1;
        this$0.showProgressDialog();
        this$0.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void initViewModel() {
        MutableLiveData<Result<BasePageResponse<List<ActiveMyRegistrationBean>>>> myRegistrationList = getViewModel().getMyRegistrationList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<ActiveMyRegistrationBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<ActiveMyRegistrationBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.active.MyRegistrationFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<ActiveMyRegistrationBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<ActiveMyRegistrationBean>>> it2) {
                MyRegistrationFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    if (basePageResponse != null) {
                        MyRegistrationFragment myRegistrationFragment = MyRegistrationFragment.this;
                        if (myRegistrationFragment.pageNo == 1) {
                            myRegistrationFragment.mAdapter.setList((Collection) basePageResponse.getList());
                        } else {
                            List list = (List) basePageResponse.getList();
                            if (list != null) {
                                myRegistrationFragment.mAdapter.addData((Collection) list);
                            }
                        }
                        if (basePageResponse.getList() == null || ((List) basePageResponse.getList()).size() >= myRegistrationFragment.pageSize) {
                            myRegistrationFragment.mAdapter.getLoadMoreModule().loadMoreComplete();
                        } else {
                            BaseLoadMoreModule.loadMoreEnd$default(myRegistrationFragment.mAdapter.getLoadMoreModule(), false, 1, null);
                        }
                    }
                }
            }
        };
        myRegistrationList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.active.-$$Lambda$MyRegistrationFragment$kuv0gWE4NNKZ92zcMI7ytzHJQ20
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyRegistrationFragment.initViewModel$lambda$3(function1, obj);
            }
        });
    }

    private final void initLoadMore() {
        this.mAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.landscape.active.-$$Lambda$MyRegistrationFragment$zSJi1gqGtNi6G5Txfo3DH_g-6yM
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                MyRegistrationFragment.initLoadMore$lambda$4(this.f$0);
            }
        });
        this.mAdapter.getLoadMoreModule().setAutoLoadMore(true);
        this.mAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLoadMore$lambda$4(MyRegistrationFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.pageNo++;
        this$0.request();
    }

    private final void request() {
        showProgressDialog();
        getViewModel().getMyRegistrationList(this.pageNo, this.pageSize, this.searchStr, this.userId);
    }
}
