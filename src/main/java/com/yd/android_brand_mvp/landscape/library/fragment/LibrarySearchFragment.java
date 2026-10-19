package com.yd.android_brand_mvp.landscape.library.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.LinearLayoutCompat;
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
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.utils.LunarCalendar;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.databinding.FragmentLibrarySearchBinding;
import com.yd.android_brand_mvp.dialog.LibraryDetailsDialog;
import com.yd.android_brand_mvp.dialog.SelectMenuListener;
import com.yd.android_brand_mvp.dialog.SelectMenuPopup;
import com.yd.android_brand_mvp.landscape.library.adapter.LibraryTypeAdapter;
import com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel;
import com.yd.android_brand_mvp.model.SelectMenuBean;
import com.yd.android_brand_mvp.model.library.LibraryBean;
import com.yd.android_brand_mvp.model.library.LibraryItemBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.TransUtils;
import java.util.ArrayList;
import java.util.Calendar;
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
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LibrarySearchFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000b\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u001a\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/library/fragment/LibrarySearchFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentLibrarySearchBinding;", "()V", "ckAdapter", "Lcom/yd/android_brand_mvp/landscape/library/adapter/LibraryTypeAdapter;", "conditionPopup", "Lcom/yd/android_brand_mvp/dialog/SelectMenuPopup;", "currentClickType", "", "mAdapter", "com/yd/android_brand_mvp/landscape/library/fragment/LibrarySearchFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/library/fragment/LibrarySearchFragment$mAdapter$1;", "order", "", "orderPopup", "pageNo", "pageSize", "timeView", "Lcom/bigkoo/pickerview/view/TimePickerView;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/library/viewmodel/LibraryFragmentViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/library/viewmodel/LibraryFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initLoadMore", "", "initTime", "initView", "initViewModel", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LibrarySearchFragment extends KTBaseFragment<FragmentLibrarySearchBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LibraryTypeAdapter ckAdapter;
    private SelectMenuPopup conditionPopup;
    private int currentClickType;
    private final LibrarySearchFragment$mAdapter$1 mAdapter;
    private String order;
    private SelectMenuPopup orderPopup;
    private int pageNo;
    private int pageSize;
    private TimePickerView timeView;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.library.fragment.LibrarySearchFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: LibrarySearchFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentLibrarySearchBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentLibrarySearchBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentLibrarySearchBinding;", 0);
        }

        public final FragmentLibrarySearchBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentLibrarySearchBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentLibrarySearchBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public LibrarySearchFragment() {
        super(AnonymousClass1.INSTANCE);
        final LibrarySearchFragment librarySearchFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibrarySearchFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return librarySearchFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibrarySearchFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(librarySearchFragment, Reflection.getOrCreateKotlinClass(LibraryFragmentViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibrarySearchFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibrarySearchFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibrarySearchFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = librarySearchFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.pageNo = 1;
        this.pageSize = 20;
        this.ckAdapter = new LibraryTypeAdapter();
        this.order = "DESC";
        this.mAdapter = new LibrarySearchFragment$mAdapter$1(this);
    }

    /* JADX INFO: compiled from: LibrarySearchFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/library/fragment/LibrarySearchFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/library/fragment/LibrarySearchFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LibrarySearchFragment newInstance() {
            LibrarySearchFragment librarySearchFragment = new LibrarySearchFragment();
            librarySearchFragment.setArguments(new Bundle());
            return librarySearchFragment;
        }
    }

    private final LibraryFragmentViewModel getViewModel() {
        return (LibraryFragmentViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initViewModel();
    }

    private final void initView() {
        if (ScreenUtils.isPortrait()) {
            getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        } else {
            getBinding().recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        }
        getBinding().recyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setEmptyView(R.layout.layout_library_search_null);
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$yA3SBSUwumteHAw7RVbRedEMcuw
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LibrarySearchFragment.initView$lambda$0(this.f$0, baseQuickAdapter, view, i);
            }
        });
        initLoadMore();
        initTime();
        getBinding().layoutSearch.ckRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        getBinding().layoutSearch.ckRecyclerView.setAdapter(this.ckAdapter);
        getBinding().btnAdvancedSearch.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$gy4RcenlPBFyXXsF3GlcvaplF7A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibrarySearchFragment.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().btnSearch.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$FtukphErPNplZiQDdfhvffjl1rU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibrarySearchFragment.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().layoutSearch.btnSearch.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$IHtX0VTmM0SHZuCBtgVPlCfosQM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibrarySearchFragment.initView$lambda$3(this.f$0, view);
            }
        });
        getBinding().layoutSearch.btnReset.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$LBmwKvuPm0S43DyymfUUffWkgyo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibrarySearchFragment.initView$lambda$4(this.f$0, view);
            }
        });
        LibrarySearchFragment librarySearchFragment = this;
        SelectMenuPopup selectMenuPopup = new SelectMenuPopup(librarySearchFragment);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SelectMenuBean("任意字段", "0", true));
        arrayList.add(new SelectMenuBean("ISBN/ISSN", "1", false, 4, null));
        arrayList.add(new SelectMenuBean("书名", "2", false, 4, null));
        arrayList.add(new SelectMenuBean("作者", "3", false, 4, null));
        arrayList.add(new SelectMenuBean("出版社", "4", false, 4, null));
        arrayList.add(new SelectMenuBean("出版年", ConversionUtil.conditionWithYear, false, 4, null));
        arrayList.add(new SelectMenuBean("分类号", ConversionUtil.conditionWithSeriesName, false, 4, null));
        arrayList.add(new SelectMenuBean("索书号", ConversionUtil.conditionWithCallNumber, false, 4, null));
        selectMenuPopup.setDataList(arrayList);
        selectMenuPopup.setCallBack(new SelectMenuListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibrarySearchFragment$initView$6$1
            @Override // com.yd.android_brand_mvp.dialog.SelectMenuListener
            public void getSelectMenu(SelectMenuBean item) {
                Intrinsics.checkNotNullParameter(item, "item");
                this.this$0.getBinding().tvFields.setText(item.getName());
            }
        });
        this.conditionPopup = selectMenuPopup;
        SelectMenuPopup selectMenuPopup2 = new SelectMenuPopup(librarySearchFragment, 160, 0);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new SelectMenuBean("降序", "DESC", true));
        arrayList2.add(new SelectMenuBean("升序", "ASC", false, 4, null));
        selectMenuPopup2.setDataList(arrayList2);
        selectMenuPopup2.setCallBack(new SelectMenuListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibrarySearchFragment$initView$7$1
            @Override // com.yd.android_brand_mvp.dialog.SelectMenuListener
            public void getSelectMenu(SelectMenuBean item) {
                Intrinsics.checkNotNullParameter(item, "item");
                this.this$0.order = item.getId();
                this.this$0.getBinding().layoutSearch.tvOrder.setText(item.getName());
            }
        });
        this.orderPopup = selectMenuPopup2;
        getBinding().tvFields.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$rT5wpGwjMsj_RG48clwHacOkK6k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibrarySearchFragment.initView$lambda$8(this.f$0, view);
            }
        });
        getBinding().layoutSearch.tvOrder.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$B0cG7e7HmmsDjXc80UtlFzZW94Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibrarySearchFragment.initView$lambda$10(this.f$0, view);
            }
        });
        getBinding().etSearch.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$Nce211V5WD5wj83isQIvqrpeXn4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibrarySearchFragment.initView$lambda$11(this.f$0, view);
            }
        });
        getBinding().layoutSearch.tvYearStart.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$E76V_Dnk1wvVyu1Xwdv9lqD-Ddc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibrarySearchFragment.initView$lambda$12(this.f$0, view);
            }
        });
        getBinding().layoutSearch.tvYearEnd.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$iuqh9lw2YjVvuJgoi_cAsqsw7SI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibrarySearchFragment.initView$lambda$13(this.f$0, view);
            }
        });
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new SelectMenuBean("全部", null, false, 6, null));
        arrayList3.add(new SelectMenuBean("图书", "1", false, 4, null));
        arrayList3.add(new SelectMenuBean("期刊", "2", false, 4, null));
        this.ckAdapter.setList(arrayList3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(LibrarySearchFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        new LibraryDetailsDialog(this$0.mAdapter.getItem(i)).show(this$0.getParentFragmentManager(), "messageTip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(LibrarySearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getBinding().layoutSearch.getRoot().isShown()) {
            LinearLayoutCompat root = this$0.getBinding().layoutSearch.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.layoutSearch.root");
            SimpleUtilsKt.remove(root);
        } else {
            LinearLayoutCompat root2 = this$0.getBinding().layoutSearch.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.layoutSearch.root");
            SimpleUtilsKt.show(root2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(LibrarySearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayoutCompat root = this$0.getBinding().layoutSearch.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.layoutSearch.root");
        SimpleUtilsKt.remove(root);
        this$0.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(LibrarySearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayoutCompat root = this$0.getBinding().layoutSearch.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.layoutSearch.root");
        SimpleUtilsKt.remove(root);
        this$0.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(LibrarySearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().etSearch.setText("");
        this$0.getBinding().layoutSearch.etInscribe.setText("");
        this$0.getBinding().layoutSearch.etAuthor.setText("");
        this$0.getBinding().layoutSearch.etPublishingHours.setText("");
        this$0.getBinding().layoutSearch.tvYearStart.setText("");
        this$0.getBinding().layoutSearch.tvYearEnd.setText("");
        this$0.ckAdapter.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(LibrarySearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SelectMenuPopup selectMenuPopup = this$0.conditionPopup;
        if (selectMenuPopup == null || selectMenuPopup.isShowing()) {
            return;
        }
        selectMenuPopup.showPopupWindow(this$0.getBinding().llSearch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$10(LibrarySearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SelectMenuPopup selectMenuPopup = this$0.orderPopup;
        if (selectMenuPopup == null || selectMenuPopup.isShowing()) {
            return;
        }
        selectMenuPopup.showPopupWindow(this$0.getBinding().layoutSearch.tvOrder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$11(LibrarySearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getBinding().layoutSearch.getRoot().isShown()) {
            LinearLayoutCompat root = this$0.getBinding().layoutSearch.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.layoutSearch.root");
            SimpleUtilsKt.remove(root);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$12(LibrarySearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentClickType = 0;
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$13(LibrarySearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentClickType = 1;
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.show();
        }
    }

    private final void initTime() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.set(LunarCalendar.MIN_YEAR, 0, 1);
        calendar2.set(2119, 11, 31);
        TransUtils transUtils = TransUtils.INSTANCE;
        String dateYFormat = TimeUtil.dateYFormat;
        Intrinsics.checkNotNullExpressionValue(dateYFormat, "dateYFormat");
        final String str = "yyyy";
        this.timeView = new TimePickerBuilder(requireContext(), new OnTimeSelectListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$kqNh_rUpG_Ja16BaFwjib4HLlDc
            @Override // com.bigkoo.pickerview.listener.OnTimeSelectListener
            public final void onTimeSelect(Date date, View view) {
                LibrarySearchFragment.initTime$lambda$14(this.f$0, str, date, view);
            }
        }).setDate(Calendar.getInstance()).setType(transUtils.getShowTimeTypeArray(dateYFormat)).setRangDate(calendar, calendar2).setTextColorCenter(getResources().getColor(R.color.purple2)).setDividerColor(getResources().getColor(R.color.purple2)).setLabel("年", "月", "日", "时", "分", "秒").setLayoutRes(R.layout.time_select, new CustomListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$GJQsIRAavEFfDea2PWBJYaBKYPg
            @Override // com.bigkoo.pickerview.listener.CustomListener
            public final void customLayout(View view) {
                LibrarySearchFragment.initTime$lambda$17(this.f$0, view);
            }
        }).isCenterLabel(false).isDialog(true).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTime$lambda$14(LibrarySearchFragment this$0, String timeFormat, Date date, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(timeFormat, "$timeFormat");
        Intrinsics.checkNotNullParameter(date, "date");
        Calendar.getInstance().setTime(date);
        int i = this$0.currentClickType;
        if (i == 0) {
            this$0.getBinding().layoutSearch.tvYearStart.setText(DateUtils.getDate(date, timeFormat));
        } else if (i == 1) {
            this$0.getBinding().layoutSearch.tvYearEnd.setText(DateUtils.getDate(date, timeFormat));
        }
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTime$lambda$17(final LibrarySearchFragment this$0, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v, "v");
        Button button = (Button) v.findViewById(R.id.btnCancel);
        Button button2 = (Button) v.findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$X48K9YTZ4dnZrusG1k1M-5e5z8I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibrarySearchFragment.initTime$lambda$17$lambda$15(this.f$0, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$NCwMoVq4l8lF6F169v7gmhn0oNY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibrarySearchFragment.initTime$lambda$17$lambda$16(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTime$lambda$17$lambda$15(LibrarySearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTime$lambda$17$lambda$16(LibrarySearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.returnData();
        }
    }

    private final void initLoadMore() {
        this.mAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$8wtP3LJz_rYGYoBJRE6I-xaLGZQ
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                LibrarySearchFragment.initLoadMore$lambda$18(this.f$0);
            }
        });
        this.mAdapter.getLoadMoreModule().setAutoLoadMore(true);
        this.mAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLoadMore$lambda$18(LibrarySearchFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.pageNo++;
        this$0.request();
    }

    private final void request() {
        String id;
        LibraryBean libraryBean = (LibraryBean) MMKV.defaultMMKV().decodeParcelable(MMKVConstant.LIBRARY_KEY, LibraryBean.class);
        String string = StringsKt.trim((CharSequence) getBinding().etSearch.getText().toString()).toString();
        String string2 = StringsKt.trim((CharSequence) getBinding().layoutSearch.etInscribe.getText().toString()).toString();
        String string3 = StringsKt.trim((CharSequence) getBinding().layoutSearch.etAuthor.getText().toString()).toString();
        String string4 = StringsKt.trim((CharSequence) getBinding().layoutSearch.etPublishingHours.getText().toString()).toString();
        String string5 = StringsKt.trim((CharSequence) getBinding().layoutSearch.tvYearStart.getText().toString()).toString();
        String string6 = StringsKt.trim((CharSequence) getBinding().layoutSearch.tvYearEnd.getText().toString()).toString();
        this.pageNo = 1;
        showProgressDialog();
        LibraryFragmentViewModel viewModel = getViewModel();
        int i = this.pageNo;
        String selectCheckBoxId = this.ckAdapter.getSelectCheckBoxId();
        if (libraryBean == null || (id = libraryBean.getId()) == null) {
            id = "";
        }
        viewModel.search(i, string, selectCheckBoxId, string2, string3, string4, string5, string6, "DESC", id);
    }

    private final void initViewModel() {
        LiveData<Result<BasePageResponse<List<LibraryItemBean>>>> librarySearch = getViewModel().getLibrarySearch();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<LibraryItemBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<LibraryItemBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibrarySearchFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<LibraryItemBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<LibraryItemBean>>> it2) {
                LibrarySearchFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    if (basePageResponse != null) {
                        LibrarySearchFragment librarySearchFragment = LibrarySearchFragment.this;
                        if (librarySearchFragment.pageNo == 1) {
                            librarySearchFragment.mAdapter.setList((Collection) basePageResponse.getList());
                        } else {
                            List list = (List) basePageResponse.getList();
                            if (list != null) {
                                librarySearchFragment.mAdapter.addData((Collection) list);
                            }
                        }
                        List list2 = (List) basePageResponse.getList();
                        Integer numValueOf = list2 != null ? Integer.valueOf(list2.size()) : null;
                        Intrinsics.checkNotNull(numValueOf);
                        if (numValueOf.intValue() < librarySearchFragment.pageSize) {
                            BaseLoadMoreModule.loadMoreEnd$default(librarySearchFragment.mAdapter.getLoadMoreModule(), false, 1, null);
                            return;
                        } else {
                            librarySearchFragment.mAdapter.getLoadMoreModule().loadMoreComplete();
                            return;
                        }
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        librarySearch.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibrarySearchFragment$qj3RH7JGnGRU2fYvFXt3raRArgg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LibrarySearchFragment.initViewModel$lambda$19(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$19(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
