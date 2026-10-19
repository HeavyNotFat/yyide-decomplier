package com.yd.android_brand_mvp.landscape.collect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
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
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.collect.CollectFormActivity;
import com.yd.android_brand_mvp.activity.collect.CollectFormDetailActivity;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.FragmentHomeCollectForm23Binding;
import com.yd.android_brand_mvp.landscape.collect.viewmodel.HomeCollectViewModel;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.collect.CollectListBean;
import com.yd.android_brand_mvp.model.collect.HomeCollectBean;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import java.util.ArrayList;
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

/* JADX INFO: compiled from: HomeCollectForm23Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u001a\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0015H\u0002J\b\u0010\"\u001a\u00020\u0015H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/collect/HomeCollectForm23Fragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHomeCollectForm23Binding;", "()V", "clickItem", "Lcom/yd/android_brand_mvp/model/collect/CollectListBean;", "current", "", "dataList", "", "Lcom/yd/android_brand_mvp/model/collect/HomeCollectBean;", "totalCount", "type", "", "viewModel", "Lcom/yd/android_brand_mvp/landscape/collect/viewmodel/HomeCollectViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/collect/viewmodel/HomeCollectViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "initView", "onDestroyView", "onEvent", "eventBean", "Lcom/yd/android_brand_mvp/model/EventBean;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "setUiData", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomeCollectForm23Fragment extends KTBaseFragment<FragmentHomeCollectForm23Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CollectListBean clickItem;
    private int current;
    private final List<HomeCollectBean> dataList;
    private int totalCount;
    private String type;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.collect.HomeCollectForm23Fragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeCollectForm23Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHomeCollectForm23Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHomeCollectForm23Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHomeCollectForm23Binding;", 0);
        }

        public final FragmentHomeCollectForm23Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHomeCollectForm23Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHomeCollectForm23Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentHomeCollectForm23Binding access$getBinding(HomeCollectForm23Fragment homeCollectForm23Fragment) {
        return homeCollectForm23Fragment.getBinding();
    }

    public HomeCollectForm23Fragment() {
        super(AnonymousClass1.INSTANCE);
        this.totalCount = 1;
        this.current = 1;
        final HomeCollectForm23Fragment homeCollectForm23Fragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.collect.HomeCollectForm23Fragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return homeCollectForm23Fragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.collect.HomeCollectForm23Fragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(homeCollectForm23Fragment, Reflection.getOrCreateKotlinClass(HomeCollectViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.collect.HomeCollectForm23Fragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.collect.HomeCollectForm23Fragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.collect.HomeCollectForm23Fragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = homeCollectForm23Fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.dataList = new ArrayList();
    }

    /* JADX INFO: compiled from: HomeCollectForm23Fragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/collect/HomeCollectForm23Fragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type) {
            HomeCollectForm23Fragment homeCollectForm23Fragment = new HomeCollectForm23Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            homeCollectForm23Fragment.setArguments(bundle);
            return homeCollectForm23Fragment;
        }
    }

    private final HomeCollectViewModel getViewModel() {
        return (HomeCollectViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        Bundle arguments = getArguments();
        String str = null;
        String string = arguments != null ? arguments.getString("type") : null;
        if (string == null) {
            string = "hbsjb23";
        }
        this.type = string;
        if (string == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
        } else {
            str = string;
        }
        if (Intrinsics.areEqual(str, "hbsjb23")) {
            getBinding().clFragmentHomeCollectForm.getLayoutParams().width = SizeUtils.dp2px(444.0f);
            getBinding().clFragmentHomeCollectForm.getLayoutParams().height = SizeUtils.dp2px(448.0f);
        } else if (Intrinsics.areEqual(str, "sbsjb42")) {
            getBinding().clFragmentHomeCollectForm.getLayoutParams().width = SizeUtils.dp2px(660.0f);
            getBinding().clFragmentHomeCollectForm.getLayoutParams().height = SizeUtils.dp2px(424.0f);
        }
        initView();
        request();
    }

    private final void initView() {
        getBinding().topFragmentHomeCollectForm23.title.setText("收集表");
        getBinding().topFragmentHomeCollectForm23.llTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.collect.-$$Lambda$HomeCollectForm23Fragment$IedsvXlz0jatkcQAhP5fVubrbro
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeCollectForm23Fragment.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().tvFragmentHomeCollectForm23Next.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.collect.-$$Lambda$HomeCollectForm23Fragment$5LjLKDe1L2gQdZobQwPIHNr-zHQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeCollectForm23Fragment.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().tvFragmentHomeCollectForm23Pre.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.collect.-$$Lambda$HomeCollectForm23Fragment$HygjxtxXkZdNcLDTNSWFKcDZAWY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeCollectForm23Fragment.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().btnFragmentHomeCollectForm23.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.collect.-$$Lambda$HomeCollectForm23Fragment$-14obPgG593W59eukX-nU_Qreek
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeCollectForm23Fragment.initView$lambda$3(this.f$0, view);
            }
        });
        LiveData<List<HomeCollectBean>> homeCollectList = getViewModel().getHomeCollectList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends HomeCollectBean>, Unit> function1 = new Function1<List<? extends HomeCollectBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.collect.HomeCollectForm23Fragment.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends HomeCollectBean> list) {
                invoke2((List<HomeCollectBean>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<HomeCollectBean> it2) {
                HomeCollectForm23Fragment.this.dataList.clear();
                List list = HomeCollectForm23Fragment.this.dataList;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                list.addAll(it2);
                if (HomeCollectForm23Fragment.this.dataList.isEmpty()) {
                    ViewStub viewStub = HomeCollectForm23Fragment.access$getBinding(HomeCollectForm23Fragment.this).emptyView;
                    Intrinsics.checkNotNullExpressionValue(viewStub, "binding.emptyView");
                    viewStub.setVisibility(0);
                    return;
                }
                ViewStub viewStub2 = HomeCollectForm23Fragment.access$getBinding(HomeCollectForm23Fragment.this).emptyView;
                Intrinsics.checkNotNullExpressionValue(viewStub2, "binding.emptyView");
                viewStub2.setVisibility(8);
                HomeCollectForm23Fragment.this.current = 1;
                HomeCollectForm23Fragment homeCollectForm23Fragment = HomeCollectForm23Fragment.this;
                homeCollectForm23Fragment.totalCount = homeCollectForm23Fragment.dataList.size();
                HomeCollectForm23Fragment.this.setUiData();
            }
        };
        homeCollectList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.collect.-$$Lambda$HomeCollectForm23Fragment$ASFl2yfw1x2hsfZPpKpFlypU4mY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeCollectForm23Fragment.initView$lambda$4(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(HomeCollectForm23Fragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CollectFormActivity.Companion companion = CollectFormActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(HomeCollectForm23Fragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.current;
        if (i >= this$0.totalCount) {
            this$0.toastShow("没有下一条了");
        } else {
            this$0.current = i + 1;
            this$0.setUiData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(HomeCollectForm23Fragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.current;
        if (i == 1) {
            this$0.toastShow("没有上一条了");
            return;
        }
        if (i > 1) {
            this$0.current = i - 1;
        }
        this$0.setUiData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(HomeCollectForm23Fragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HomeCollectBean homeCollectBean = this$0.dataList.get(this$0.current - 1);
        this$0.clickItem = new CollectListBean(homeCollectBean.getFormId(), null, 0, null, homeCollectBean.getDescription(), homeCollectBean.getId(), homeCollectBean.getName(), 0, 142, null);
        Intent intent = new Intent(this$0.requireContext(), (Class<?>) CheackNomalActivity.class);
        intent.putExtra("type", BaseConstant.homeCollect23);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUiData() {
        TextView textView = getBinding().tvFragmentHomeCollectForm23Page;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.num_limit);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.num_limit)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.current), Integer.valueOf(this.totalCount)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
        getBinding().clFragmentHomeCollectFormContent.setBackgroundResource(TransUtils.INSTANCE.getCollectBackgroundImageByDataPosition2(this.current));
        getBinding().btnFragmentHomeCollectForm23.setBackgroundResource(TransUtils.INSTANCE.getCollectBtnColorByDataPosition(this.current, 2));
        int i = this.current - 1;
        if (i >= this.dataList.size()) {
            return;
        }
        getBinding().tvFragmentHomeCollectForm23FormName.setText(this.dataList.get(i).getName());
        getBinding().tvFragmentHomeCollectForm23SubmitCount.setText(String.valueOf(this.dataList.get(i).getTodayAlreadyDid()));
        getBinding().tvFragmentHomeCollectForm23UnSubmitCount.setText(String.valueOf(this.dataList.get(i).getTodayGonnaDo()));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(EventBean eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        if (eventBean.type != BaseConstant.homeCollect23) {
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
        companion.startGo(contextRequireContext, str, collectListBean);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (MinaConstants.CODE_COLLECT == id) {
            request();
        }
    }

    private final void request() {
        HomeCollectViewModel.getHomeCollectList$default(getViewModel(), 0, 1, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
