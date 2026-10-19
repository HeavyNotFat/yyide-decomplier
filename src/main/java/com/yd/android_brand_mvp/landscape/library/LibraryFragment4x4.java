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
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.databinding.FragmentLibraryFragment4x4Binding;
import com.yd.android_brand_mvp.databinding.ItemLibraryFragment4x4Binding;
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

/* JADX INFO: compiled from: LibraryFragment4x4.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000b\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u001a\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/library/LibraryFragment4x4;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentLibraryFragment4x4Binding;", "()V", "libraryBean", "Lcom/yd/android_brand_mvp/model/library/LibraryBean;", "getLibraryBean", "()Lcom/yd/android_brand_mvp/model/library/LibraryBean;", "setLibraryBean", "(Lcom/yd/android_brand_mvp/model/library/LibraryBean;)V", "mAdapter", "com/yd/android_brand_mvp/landscape/library/LibraryFragment4x4$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/library/LibraryFragment4x4$mAdapter$1;", "pageIndex", "", "viewModel", "Lcom/yd/android_brand_mvp/landscape/library/viewmodel/LibraryFragmentViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/library/viewmodel/LibraryFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "initViewModel", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setCheck", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LibraryFragment4x4 extends KTBaseFragment<FragmentLibraryFragment4x4Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LAYOUT_TAG = "layoutTag";
    private LibraryBean libraryBean;
    private final LibraryFragment4x4$mAdapter$1 mAdapter;
    private int pageIndex;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.library.LibraryFragment4x4$1, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryFragment4x4.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentLibraryFragment4x4Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentLibraryFragment4x4Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentLibraryFragment4x4Binding;", 0);
        }

        public final FragmentLibraryFragment4x4Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentLibraryFragment4x4Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentLibraryFragment4x4Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.yd.android_brand_mvp.landscape.library.LibraryFragment4x4$mAdapter$1] */
    public LibraryFragment4x4() {
        super(AnonymousClass1.INSTANCE);
        final LibraryFragment4x4 libraryFragment4x4 = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment4x4$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return libraryFragment4x4;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment4x4$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(libraryFragment4x4, Reflection.getOrCreateKotlinClass(LibraryFragmentViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment4x4$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment4x4$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment4x4$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = libraryFragment4x4.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.pageIndex = 1;
        this.mAdapter = new BaseQuickAdapter<LibraryItemBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment4x4$mAdapter$1
            {
                super(R.layout.item_library_fragment4x4, null, 2, null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, LibraryItemBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemLibraryFragment4x4Binding itemLibraryFragment4x4BindingBind = ItemLibraryFragment4x4Binding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemLibraryFragment4x4BindingBind, "bind(holder.itemView)");
                itemLibraryFragment4x4BindingBind.tvLibraryTitle.setText(item.getTitle());
                GlideUtil.loadBook2(this.this$0.requireContext(), item.getUrl(), itemLibraryFragment4x4BindingBind.ivCover);
            }
        };
    }

    /* JADX INFO: compiled from: LibraryFragment4x4.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/library/LibraryFragment4x4$Companion;", "", "()V", "LAYOUT_TAG", "", "getLAYOUT_TAG", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/library/LibraryFragment4x4;", RemoteMessageConst.Notification.TAG, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLAYOUT_TAG() {
            return LibraryFragment4x4.LAYOUT_TAG;
        }

        public final LibraryFragment4x4 newInstance(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            LibraryFragment4x4 libraryFragment4x4 = new LibraryFragment4x4();
            Bundle bundle = new Bundle();
            bundle.putString(LibraryFragment4x4.INSTANCE.getLAYOUT_TAG(), tag);
            libraryFragment4x4.setArguments(bundle);
            return libraryFragment4x4;
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
        String string;
        getBinding().top.title.setText(getString(R.string.st_book_info));
        TextView textView = getBinding().top.tvLayoutHeadSubTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.top.tvLayoutHeadSubTitle");
        SimpleUtilsKt.show(textView);
        getBinding().top.tvLayoutHeadSubTitle.setText(" 高级检索");
        getBinding().top.tvLayoutHeadSubTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_library_searcher, 0, 0, 0);
        getBinding().top.tvLayoutHeadSubTitle.setTextColor(getResources().getColor(R.color.purple2));
        getBinding().clContent.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.-$$Lambda$LibraryFragment4x4$Bo1zya8_ulwdAHuBi8bs3KHho1Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibraryFragment4x4.initView$lambda$0(this.f$0, view);
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString(LAYOUT_TAG)) != null) {
            int iHashCode = string.hashCode();
            if (iHashCode != -41759791) {
                if (iHashCode != 1378150116) {
                    if (iHashCode == 1378150118 && string.equals("sblibrary4x6")) {
                        getBinding().getRoot().getLayoutParams().width = SizeUtils.dp2px(660.0f);
                        getBinding().getRoot().getLayoutParams().height = SizeUtils.dp2px(1312.0f);
                    }
                } else if (string.equals("sblibrary4x4")) {
                    getBinding().getRoot().getLayoutParams().width = SizeUtils.dp2px(660.0f);
                    getBinding().getRoot().getLayoutParams().height = SizeUtils.dp2px(868.0f);
                }
            } else if (string.equals("hblibrary4x6")) {
                getBinding().getRoot().getLayoutParams().width = SizeUtils.dp2px(908.0f);
                getBinding().getRoot().getLayoutParams().height = SizeUtils.dp2px(916.0f);
            }
        }
        getBinding().tvTab2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.-$$Lambda$LibraryFragment4x4$6PhbW8F3WwFHzJUhWLUvQ88IgVw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibraryFragment4x4.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().tvTab3.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.-$$Lambda$LibraryFragment4x4$8hhXrQl5T89CN5TlBv0YRrMpK-8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibraryFragment4x4.initView$lambda$3(this.f$0, view);
            }
        });
        getBinding().recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 5));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.-$$Lambda$LibraryFragment4x4$0fHP6sfXAkuarhmMcJTBS1f_vuA
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LibraryFragment4x4.initView$lambda$4(this.f$0, baseQuickAdapter, view, i);
            }
        });
        setEmptyView(R.layout.layout_library_null);
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(LibraryFragment4x4 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LibrarySearchListActivity.Companion companion = LibrarySearchListActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(LibraryFragment4x4 this$0, View view) {
        String id;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setCheck();
        this$0.mAdapter.setList(null);
        this$0.getBinding().tvTab2.setChecked(true);
        this$0.pageIndex = 1;
        LibraryFragmentViewModel viewModel = this$0.getViewModel();
        LibraryBean libraryBean = this$0.libraryBean;
        if (libraryBean == null || (id = libraryBean.getId()) == null) {
            id = "";
        }
        LibraryFragmentViewModel.getHotList$default(viewModel, id, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(LibraryFragment4x4 this$0, View view) {
        String id;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setCheck();
        this$0.mAdapter.setList(null);
        this$0.getBinding().tvTab3.setChecked(true);
        this$0.pageIndex = 2;
        LibraryFragmentViewModel viewModel = this$0.getViewModel();
        LibraryBean libraryBean = this$0.libraryBean;
        if (libraryBean == null || (id = libraryBean.getId()) == null) {
            id = "";
        }
        LibraryFragmentViewModel.getNewList$default(viewModel, id, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(LibraryFragment4x4 this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        LibrarySearchListActivity.Companion companion = LibrarySearchListActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext, this$0.pageIndex);
    }

    public final LibraryBean getLibraryBean() {
        return this.libraryBean;
    }

    public final void setLibraryBean(LibraryBean libraryBean) {
        this.libraryBean = libraryBean;
    }

    private final void initViewModel() {
        LiveData<List<LibraryBean>> libraryList = getViewModel().getLibraryList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<LibraryBean>, Unit> function1 = new Function1<List<LibraryBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment4x4.initViewModel.1
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
                LibraryFragment4x4.this.setLibraryBean(list != null ? (LibraryBean) CollectionsKt.first((List) list) : null);
                MMKV.defaultMMKV().encode(MMKVConstant.LIBRARY_KEY, LibraryFragment4x4.this.getLibraryBean());
                MMKV.defaultMMKV().encode(MMKVConstant.LIBRARY_LIST_KEY, GsonUtils.toJson(list));
                LibraryFragmentViewModel viewModel = LibraryFragment4x4.this.getViewModel();
                LibraryBean libraryBean = LibraryFragment4x4.this.getLibraryBean();
                if (libraryBean == null || (id = libraryBean.getId()) == null) {
                    id = "";
                }
                LibraryFragmentViewModel.getHotList$default(viewModel, id, null, null, 6, null);
            }
        };
        libraryList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.library.-$$Lambda$LibraryFragment4x4$qFPsR5l6hgl767kVsjyT-0Qd1hk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LibraryFragment4x4.initViewModel$lambda$5(function1, obj);
            }
        });
        LiveData<List<LibraryItemBean>> libraryRecommended = getViewModel().getLibraryRecommended();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<List<LibraryItemBean>, Unit> function2 = new Function1<List<LibraryItemBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment4x4.initViewModel.2
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
        libraryRecommended.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.library.-$$Lambda$LibraryFragment4x4$mywkMAPOBesSIPqIor99ffwtHlE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LibraryFragment4x4.initViewModel$lambda$6(function2, obj);
            }
        });
        LiveData<List<LibraryItemBean>> libraryHotList = getViewModel().getLibraryHotList();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<List<LibraryItemBean>, Unit> function3 = new Function1<List<LibraryItemBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.library.LibraryFragment4x4.initViewModel.3
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
        libraryHotList.observe(viewLifecycleOwner3, new Observer() { // from class: com.yd.android_brand_mvp.landscape.library.-$$Lambda$LibraryFragment4x4$VRSTtX51rZd7CFprx46TPE8_PWc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LibraryFragment4x4.initViewModel$lambda$7(function3, obj);
            }
        });
        getViewModel().m356getLibraryList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void setCheck() {
        getBinding().tvTab2.setChecked(false);
        getBinding().tvTab3.setChecked(false);
    }
}
