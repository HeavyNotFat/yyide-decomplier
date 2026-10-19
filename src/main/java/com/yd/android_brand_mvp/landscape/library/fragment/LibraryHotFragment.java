package com.yd.android_brand_mvp.landscape.library.fragment;

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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.databinding.FragmentLibraryHotBinding;
import com.yd.android_brand_mvp.databinding.ItemLibraryListBinding;
import com.yd.android_brand_mvp.dialog.LibraryDetailsDialog;
import com.yd.android_brand_mvp.dialog.SelectMenuListener;
import com.yd.android_brand_mvp.dialog.SelectMenuPopup;
import com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel;
import com.yd.android_brand_mvp.model.SelectMenuBean;
import com.yd.android_brand_mvp.model.library.LibraryBean;
import com.yd.android_brand_mvp.model.library.LibraryItemBean;
import com.yd.android_brand_mvp.model.library.LibraryTypeBean;
import com.yd.android_brand_mvp.mqtt.MQTTConstant;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.GlideUtil;
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

/* JADX INFO: compiled from: LibraryHotFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0012\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/landscape/library/fragment/LibraryHotFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentLibraryHotBinding;", "()V", "categoryID", "", "categoryPopup", "Lcom/yd/android_brand_mvp/dialog/SelectMenuPopup;", "conditionPopup", "date", "library", "Lcom/yd/android_brand_mvp/model/library/LibraryBean;", "kotlin.jvm.PlatformType", "getLibrary", "()Lcom/yd/android_brand_mvp/model/library/LibraryBean;", "library$delegate", "Lkotlin/Lazy;", "mAdapter", "com/yd/android_brand_mvp/landscape/library/fragment/LibraryHotFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/library/fragment/LibraryHotFragment$mAdapter$1;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/library/viewmodel/LibraryFragmentViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/library/viewmodel/LibraryFragmentViewModel;", "viewModel$delegate", "initView", "", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LibraryHotFragment extends KTBaseFragment<FragmentLibraryHotBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String categoryID;
    private SelectMenuPopup categoryPopup;
    private SelectMenuPopup conditionPopup;
    private String date;

    /* JADX INFO: renamed from: library$delegate, reason: from kotlin metadata */
    private final Lazy library;
    private final LibraryHotFragment$mAdapter$1 mAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.library.fragment.LibraryHotFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryHotFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentLibraryHotBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentLibraryHotBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentLibraryHotBinding;", 0);
        }

        public final FragmentLibraryHotBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentLibraryHotBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentLibraryHotBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.yd.android_brand_mvp.landscape.library.fragment.LibraryHotFragment$mAdapter$1] */
    public LibraryHotFragment() {
        super(AnonymousClass1.INSTANCE);
        final LibraryHotFragment libraryHotFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibraryHotFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return libraryHotFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibraryHotFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(libraryHotFragment, Reflection.getOrCreateKotlinClass(LibraryFragmentViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibraryHotFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibraryHotFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibraryHotFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = libraryHotFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.library = LazyKt.lazy(new Function0<LibraryBean>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibraryHotFragment$library$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LibraryBean invoke() {
                return (LibraryBean) MMKV.defaultMMKV().decodeParcelable(MMKVConstant.LIBRARY_KEY, LibraryBean.class);
            }
        });
        this.categoryID = "";
        this.date = ConversionUtil.conditionWithBookType;
        this.mAdapter = new BaseQuickAdapter<LibraryItemBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibraryHotFragment$mAdapter$1
            {
                super(R.layout.item_library_list, null, 2, null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, LibraryItemBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemLibraryListBinding itemLibraryListBindingBind = ItemLibraryListBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemLibraryListBindingBind, "bind(holder.itemView)");
                itemLibraryListBindingBind.tvLibraryTitle.setText(item.getTitle());
                GlideUtil.loadBook2(this.this$0.requireContext(), item.getUrl(), itemLibraryListBindingBind.ivCover);
                TextView textView = itemLibraryListBindingBind.tvLibraryLoanable;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("馆藏 %d 可借 %d", Arrays.copyOf(new Object[]{Integer.valueOf(item.getItemCount()), Integer.valueOf(item.getBorrowableCount())}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                textView.setText(str);
                TextView textView2 = itemLibraryListBindingBind.tvLibraryAuthor;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str2 = String.format("%s | %s | %s", Arrays.copyOf(new Object[]{item.getFirstAuthor(), item.getPublisherName(), item.getPublicationTime()}, 3));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                textView2.setText(str2);
                itemLibraryListBindingBind.tvLibraryNumber.setText(item.getCallNumber());
            }
        };
    }

    /* JADX INFO: compiled from: LibraryHotFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/library/fragment/LibraryHotFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/library/fragment/LibraryHotFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LibraryHotFragment newInstance() {
            LibraryHotFragment libraryHotFragment = new LibraryHotFragment();
            libraryHotFragment.setArguments(new Bundle());
            return libraryHotFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LibraryFragmentViewModel getViewModel() {
        return (LibraryFragmentViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LibraryBean getLibrary() {
        return (LibraryBean) this.library.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
        setEmptyView(R.layout.layout_library_null);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibraryHotFragment$hJjOf3tGsuK0d_NR6iMN7ROmixY
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LibraryHotFragment.initView$lambda$0(this.f$0, baseQuickAdapter, view, i);
            }
        });
        LibraryHotFragment libraryHotFragment = this;
        SelectMenuPopup selectMenuPopup = new SelectMenuPopup(libraryHotFragment, 400, 0);
        selectMenuPopup.setCallBack(new SelectMenuListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibraryHotFragment$initView$2$1
            @Override // com.yd.android_brand_mvp.dialog.SelectMenuListener
            public void getSelectMenu(SelectMenuBean item) {
                String id;
                Intrinsics.checkNotNullParameter(item, "item");
                this.this$0.getBinding().tvCategory.setText(item.getName());
                this.this$0.categoryID = item.getId();
                LibraryFragmentViewModel viewModel = this.this$0.getViewModel();
                LibraryBean library = this.this$0.getLibrary();
                if (library == null || (id = library.getId()) == null) {
                    id = "";
                }
                viewModel.getHotList(id, this.this$0.date, this.this$0.categoryID);
            }
        });
        this.categoryPopup = selectMenuPopup;
        SelectMenuPopup selectMenuPopup2 = new SelectMenuPopup(libraryHotFragment, 400, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SelectMenuBean("一周", ConversionUtil.conditionWithBookType, true));
        arrayList.add(new SelectMenuBean("半月", "15", false, 4, null));
        arrayList.add(new SelectMenuBean("一季", MQTTConstant.photoAndvideo, false, 4, null));
        arrayList.add(new SelectMenuBean("半年", "180", false, 4, null));
        arrayList.add(new SelectMenuBean("一年", "360", false, 4, null));
        selectMenuPopup2.setDataList(arrayList);
        selectMenuPopup2.setCallBack(new SelectMenuListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibraryHotFragment$initView$3$1
            @Override // com.yd.android_brand_mvp.dialog.SelectMenuListener
            public void getSelectMenu(SelectMenuBean item) {
                String id;
                Intrinsics.checkNotNullParameter(item, "item");
                this.this$0.getBinding().tvTime.setText(item.getName());
                this.this$0.date = item.getId();
                LibraryFragmentViewModel viewModel = this.this$0.getViewModel();
                LibraryBean library = this.this$0.getLibrary();
                if (library == null || (id = library.getId()) == null) {
                    id = "";
                }
                viewModel.getHotList(id, this.this$0.date, this.this$0.categoryID);
            }
        });
        this.conditionPopup = selectMenuPopup2;
        getBinding().tvCategory.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibraryHotFragment$g--wGYDaBjwUTx0qdRis3SbDDyc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibraryHotFragment.initView$lambda$4(this.f$0, view);
            }
        });
        getBinding().tvTime.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibraryHotFragment$MtU7CH6n8uv-WZO9r6Nu-KiOpY8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibraryHotFragment.initView$lambda$6(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(LibraryHotFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        new LibraryDetailsDialog(this$0.mAdapter.getItem(i)).show(this$0.getParentFragmentManager(), "messageTip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(LibraryHotFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SelectMenuPopup selectMenuPopup = this$0.categoryPopup;
        if (selectMenuPopup == null || selectMenuPopup.isShowing()) {
            return;
        }
        selectMenuPopup.showPopupWindow(this$0.getBinding().tvCategory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(LibraryHotFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SelectMenuPopup selectMenuPopup = this$0.conditionPopup;
        if (selectMenuPopup == null || selectMenuPopup.isShowing()) {
            return;
        }
        selectMenuPopup.showPopupWindow(this$0.getBinding().tvTime);
    }

    private final void initViewModel() {
        String id;
        LiveData<List<LibraryItemBean>> libraryHotList = getViewModel().getLibraryHotList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<LibraryItemBean>, Unit> function1 = new Function1<List<LibraryItemBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibraryHotFragment.initViewModel.1
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
                LibraryHotFragment.this.dismissProgressDialog();
                setList(list);
            }
        };
        libraryHotList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibraryHotFragment$-WBuGgWMtJVqvnjOX-ls6csLD0c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LibraryHotFragment.initViewModel$lambda$7(function1, obj);
            }
        });
        LiveData<List<LibraryTypeBean>> libraryClassifyList = getViewModel().getLibraryClassifyList();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<List<LibraryTypeBean>, Unit> function2 = new Function1<List<LibraryTypeBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.LibraryHotFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<LibraryTypeBean> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<LibraryTypeBean> it2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new SelectMenuBean("全部分类", "", true));
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                for (LibraryTypeBean libraryTypeBean : it2) {
                    arrayList.add(new SelectMenuBean(libraryTypeBean.getName(), libraryTypeBean.getId(), false));
                }
                SelectMenuPopup selectMenuPopup = LibraryHotFragment.this.categoryPopup;
                if (selectMenuPopup != null) {
                    selectMenuPopup.setDataList(arrayList);
                }
            }
        };
        libraryClassifyList.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibraryHotFragment$ZHqgQ4nau7a2dCSDD0QaVEPX13c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LibraryHotFragment.initViewModel$lambda$8(function2, obj);
            }
        });
        showProgressDialog();
        getViewModel().m355getLibraryClassifyList();
        LibraryFragmentViewModel viewModel = getViewModel();
        LibraryBean library = getLibrary();
        if (library == null || (id = library.getId()) == null) {
            id = "";
        }
        LibraryFragmentViewModel.getHotList$default(viewModel, id, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
