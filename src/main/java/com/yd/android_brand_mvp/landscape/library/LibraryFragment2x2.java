package com.yd.android_brand_mvp.landscape.library;

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
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.databinding.FragmentLibraryFragment2x2Binding;
import com.yd.android_brand_mvp.databinding.ItemLibraryFragment2x2Binding;
import com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel;
import com.yd.android_brand_mvp.model.library.LibraryBean;
import com.yd.android_brand_mvp.model.library.LibraryItemBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: LibraryFragment2x2.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/library/LibraryFragment2x2;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentLibraryFragment2x2Binding;", "()V", "mAdapter", "com/yd/android_brand_mvp/landscape/library/LibraryFragment2x2$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/library/LibraryFragment2x2$mAdapter$1;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/library/viewmodel/LibraryFragmentViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/library/viewmodel/LibraryFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "initViewModel", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LibraryFragment2x2 extends KTBaseFragment<FragmentLibraryFragment2x2Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LAYOUT_TAG = "layoutTag";
    private final LibraryFragment2x2$mAdapter$1 mAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.library.LibraryFragment2x2$1, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryFragment2x2.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentLibraryFragment2x2Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentLibraryFragment2x2Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentLibraryFragment2x2Binding;", 0);
        }

        public final FragmentLibraryFragment2x2Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentLibraryFragment2x2Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentLibraryFragment2x2Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.yd.android_brand_mvp.landscape.library.LibraryFragment2x2$mAdapter$1] */
    public LibraryFragment2x2() {
        super(AnonymousClass1.INSTANCE);
        final LibraryFragment2x2 libraryFragment2x2 = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment2x2$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return libraryFragment2x2;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment2x2$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(libraryFragment2x2, Reflection.getOrCreateKotlinClass(LibraryFragmentViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment2x2$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment2x2$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment2x2$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = libraryFragment2x2.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.mAdapter = new BaseQuickAdapter<LibraryItemBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment2x2$mAdapter$1
            {
                super(R.layout.item_library_fragment2x2, null, 2, null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, LibraryItemBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemLibraryFragment2x2Binding itemLibraryFragment2x2BindingBind = ItemLibraryFragment2x2Binding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemLibraryFragment2x2BindingBind, "bind(holder.itemView)");
                itemLibraryFragment2x2BindingBind.tvLibraryTitle.setText(item.getTitle());
                GlideUtil.loadBook2(this.this$0.requireContext(), item.getUrl(), itemLibraryFragment2x2BindingBind.ivCover);
            }
        };
    }

    /* JADX INFO: compiled from: LibraryFragment2x2.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/library/LibraryFragment2x2$Companion;", "", "()V", "LAYOUT_TAG", "", "getLAYOUT_TAG", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/library/LibraryFragment2x2;", RemoteMessageConst.Notification.TAG, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLAYOUT_TAG() {
            return LibraryFragment2x2.LAYOUT_TAG;
        }

        public final LibraryFragment2x2 newInstance(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            LibraryFragment2x2 libraryFragment2x2 = new LibraryFragment2x2();
            Bundle bundle = new Bundle();
            bundle.putString(LibraryFragment2x2.INSTANCE.getLAYOUT_TAG(), tag);
            libraryFragment2x2.setArguments(bundle);
            return libraryFragment2x2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LibraryFragmentViewModel getViewModel() {
        return (LibraryFragmentViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        if (arguments != null && Intrinsics.areEqual(arguments.getString(LibraryFragment4x4.INSTANCE.getLAYOUT_TAG()), "sblibrary2x2")) {
            getBinding().getRoot().getLayoutParams().width = SizeUtils.dp2px(320.0f);
            getBinding().getRoot().getLayoutParams().height = SizeUtils.dp2px(424.0f);
        }
        getBinding().top.title.setText(getString(R.string.st_book_info));
        TextView textView = getBinding().top.tvLayoutHeadSubTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.top.tvLayoutHeadSubTitle");
        SimpleUtilsKt.show(textView);
        getBinding().top.tvLayoutHeadSubTitle.setText("更多 >");
        getBinding().top.tvLayoutHeadSubTitle.setTextColor(getResources().getColor(R.color.purple2));
        getBinding().top.tvLayoutHeadSubTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.-$$Lambda$LibraryFragment2x2$jU-BQQ-mw30-RYZUmoXTrL4N04k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibraryFragment2x2.initView$lambda$1(this.f$0, view);
            }
        });
        if (ScreenUtils.isPortrait()) {
            getBinding().recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
            getBinding().recyclerView.setAdapter(this.mAdapter);
        } else {
            getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
            getBinding().recyclerView.setAdapter(this.mAdapter);
        }
        setEmptyView(R.layout.layout_library_2x2_null);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.-$$Lambda$LibraryFragment2x2$YKb-S8mCsCgbuAEBekXbumHHuos
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LibraryFragment2x2.initView$lambda$2(this.f$0, baseQuickAdapter, view, i);
            }
        });
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(LibraryFragment2x2 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LibrarySearchListActivity.Companion companion = LibrarySearchListActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(LibraryFragment2x2 this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        LibrarySearchListActivity.Companion companion = LibrarySearchListActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext, 1);
    }

    private final void initViewModel() {
        LiveData<List<LibraryBean>> libraryList = getViewModel().getLibraryList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<LibraryBean>, Unit> function1 = new Function1<List<LibraryBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment2x2.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<LibraryBean> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<LibraryBean> list) {
                String id;
                LibraryBean libraryBean = list != null ? (LibraryBean) CollectionsKt.first((List) list) : null;
                LibraryFragmentViewModel viewModel = LibraryFragment2x2.this.getViewModel();
                if (libraryBean == null || (id = libraryBean.getId()) == null) {
                    id = "";
                }
                LibraryFragmentViewModel.getHotList$default(viewModel, id, null, null, 6, null);
                MMKV.defaultMMKV().encode(MMKVConstant.LIBRARY_KEY, libraryBean);
                MMKV.defaultMMKV().encode(MMKVConstant.LIBRARY_LIST_KEY, GsonUtils.toJson(list));
            }
        };
        libraryList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.library.-$$Lambda$LibraryFragment2x2$mdL2mHU-xZF1IEO9UCHciYYAGZs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LibraryFragment2x2.initViewModel$lambda$3(function1, obj);
            }
        });
        LiveData<List<LibraryItemBean>> libraryHotList = getViewModel().getLibraryHotList();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<List<LibraryItemBean>, Unit> function2 = new Function1<List<LibraryItemBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment2x2.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<LibraryItemBean> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<LibraryItemBean> list) {
                setList(list);
            }
        };
        libraryHotList.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.library.-$$Lambda$LibraryFragment2x2$WBDYZffZdMvATI2P8aXvXojjAZU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LibraryFragment2x2.initViewModel$lambda$4(function2, obj);
            }
        });
        getViewModel().m356getLibraryList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
