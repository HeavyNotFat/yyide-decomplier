package com.yd.android_brand_mvp.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.databinding.DialogLibraryDetailsLayoutBinding;
import com.yd.android_brand_mvp.databinding.ItemLibraryBooksSituationBinding;
import com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel;
import com.yd.android_brand_mvp.model.library.LibraryCollectBookSituationBean;
import com.yd.android_brand_mvp.model.library.LibraryItemBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: LibraryDetailsDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0015J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\u001a\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/yd/android_brand_mvp/dialog/LibraryDetailsDialog;", "Landroidx/fragment/app/DialogFragment;", "data", "Lcom/yd/android_brand_mvp/model/library/LibraryItemBean;", "(Lcom/yd/android_brand_mvp/model/library/LibraryItemBean;)V", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogLibraryDetailsLayoutBinding;", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/DialogLibraryDetailsLayoutBinding;", "setBinding", "(Lcom/yd/android_brand_mvp/databinding/DialogLibraryDetailsLayoutBinding;)V", "mAdapter", "com/yd/android_brand_mvp/dialog/LibraryDetailsDialog$mAdapter$1", "Lcom/yd/android_brand_mvp/dialog/LibraryDetailsDialog$mAdapter$1;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/library/viewmodel/LibraryFragmentViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/library/viewmodel/LibraryFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "initViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LibraryDetailsDialog extends DialogFragment {
    public DialogLibraryDetailsLayoutBinding binding;
    private LibraryItemBean data;
    private final LibraryDetailsDialog$mAdapter$1 mAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public final DialogLibraryDetailsLayoutBinding getBinding() {
        DialogLibraryDetailsLayoutBinding dialogLibraryDetailsLayoutBinding = this.binding;
        if (dialogLibraryDetailsLayoutBinding != null) {
            return dialogLibraryDetailsLayoutBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogLibraryDetailsLayoutBinding dialogLibraryDetailsLayoutBinding) {
        Intrinsics.checkNotNullParameter(dialogLibraryDetailsLayoutBinding, "<set-?>");
        this.binding = dialogLibraryDetailsLayoutBinding;
    }

    private final LibraryFragmentViewModel getViewModel() {
        return (LibraryFragmentViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.yd.android_brand_mvp.dialog.LibraryDetailsDialog$mAdapter$1] */
    public LibraryDetailsDialog(LibraryItemBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        final LibraryDetailsDialog libraryDetailsDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.dialog.LibraryDetailsDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return libraryDetailsDialog;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.dialog.LibraryDetailsDialog$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(libraryDetailsDialog, Reflection.getOrCreateKotlinClass(LibraryFragmentViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.dialog.LibraryDetailsDialog$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.dialog.LibraryDetailsDialog$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.dialog.LibraryDetailsDialog$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = libraryDetailsDialog.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.mAdapter = new BaseQuickAdapter<LibraryCollectBookSituationBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.dialog.LibraryDetailsDialog$mAdapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, LibraryCollectBookSituationBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemLibraryBooksSituationBinding itemLibraryBooksSituationBindingBind = ItemLibraryBooksSituationBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemLibraryBooksSituationBindingBind, "bind(holder.itemView)");
                itemLibraryBooksSituationBindingBind.tvCollectionSite.setText(item.getLocationName());
                itemLibraryBooksSituationBindingBind.tvShelvingName.setText(item.getShelfName());
                itemLibraryBooksSituationBindingBind.tvCodeNumber.setText(item.getBarCode());
                itemLibraryBooksSituationBindingBind.tvLoanable.setText(item.getAvailability() == 0 ? "不可借" : "可借");
            }
        };
        this.data = data;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogLibraryDetailsLayoutBinding dialogLibraryDetailsLayoutBindingInflate = DialogLibraryDetailsLayoutBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogLibraryDetailsLayoutBindingInflate, "inflate(inflater, container, false)");
        setBinding(dialogLibraryDetailsLayoutBindingInflate);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void initViewModel() {
        String id;
        LiveData<List<LibraryCollectBookSituationBean>> libraryBookSituation = getViewModel().getLibraryBookSituation();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<LibraryCollectBookSituationBean>, Unit> function1 = new Function1<List<LibraryCollectBookSituationBean>, Unit>() { // from class: com.yd.android_brand_mvp.dialog.LibraryDetailsDialog.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<LibraryCollectBookSituationBean> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<LibraryCollectBookSituationBean> list) {
                setList(list);
            }
        };
        libraryBookSituation.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$LibraryDetailsDialog$R7c3JrRk7b7q6Buw3Rwqd4UG0GM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LibraryDetailsDialog.initViewModel$lambda$0(function1, obj);
            }
        });
        LibraryFragmentViewModel viewModel = getViewModel();
        LibraryItemBean libraryItemBean = this.data;
        if (libraryItemBean == null || (id = libraryItemBean.getId()) == null) {
            id = "";
        }
        viewModel.getLibraryBookSituationList(id);
    }

    private final void initView() {
        LibraryItemBean libraryItemBean = this.data;
        if (libraryItemBean != null) {
            GlideUtil.loadBook(requireContext(), libraryItemBean.getUrl(), getBinding().photoView);
            getBinding().bookname.setText(libraryItemBean.getTitle());
            getBinding().author.setText(libraryItemBean.getFirstAuthor());
            getBinding().ip.setText(libraryItemBean.getBookIsbn());
            getBinding().fl.setText(libraryItemBean.getCallNumber());
            getBinding().fx.setText(libraryItemBean.getPublisherName());
            getBinding().time.setText(libraryItemBean.getPublicationTime());
        }
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        Dialog dialog2 = getDialog();
        Window window = dialog2 != null ? dialog2.getWindow() : null;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkNotNullExpressionValue(attributes, "it.attributes");
            Intrinsics.checkNotNullExpressionValue(window.getWindowManager().getDefaultDisplay(), "it.windowManager.defaultDisplay");
            attributes.width = SizeUtils.dp2px(950.0f);
            attributes.height = SizeUtils.dp2px(750.0f);
            window.setAttributes(attributes);
        }
    }
}
