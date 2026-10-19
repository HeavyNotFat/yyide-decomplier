package com.yd.android_brand_mvp.landscape.customized.tianjin;

import android.os.Bundle;
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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentCustomSiteInfoBinding;
import com.yd.android_brand_mvp.databinding.ItemCustomTableBinding;
import com.yd.android_brand_mvp.model.customized.CustomExtInfoBean;
import com.yd.android_brand_mvp.model.customized.CustomSiteInfoBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: SiteInfoFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u001a\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/customized/tianjin/SiteInfoFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentCustomSiteInfoBinding;", "()V", "levelAdapter", "com/yd/android_brand_mvp/landscape/customized/tianjin/SiteInfoFragment$levelAdapter$1", "Lcom/yd/android_brand_mvp/landscape/customized/tianjin/SiteInfoFragment$levelAdapter$1;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/customized/tianjin/SiteInfoViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/customized/tianjin/SiteInfoViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "", "initView", "initViewModel", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SiteInfoFragment extends KTBaseFragment<FragmentCustomSiteInfoBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SiteInfoFragment$levelAdapter$1 levelAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: SiteInfoFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentCustomSiteInfoBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentCustomSiteInfoBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentCustomSiteInfoBinding;", 0);
        }

        public final FragmentCustomSiteInfoBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentCustomSiteInfoBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentCustomSiteInfoBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoFragment$levelAdapter$1] */
    public SiteInfoFragment() {
        super(AnonymousClass1.INSTANCE);
        final SiteInfoFragment siteInfoFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return siteInfoFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(siteInfoFragment, Reflection.getOrCreateKotlinClass(SiteInfoViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = siteInfoFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.levelAdapter = new BaseQuickAdapter<String, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoFragment$levelAdapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, String item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemCustomTableBinding itemCustomTableBindingBind = ItemCustomTableBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemCustomTableBindingBind, "bind(holder.itemView)");
                itemCustomTableBindingBind.tvGrade.setText(item);
            }
        };
    }

    public static final /* synthetic */ FragmentCustomSiteInfoBinding access$getBinding(SiteInfoFragment siteInfoFragment) {
        return siteInfoFragment.getBinding();
    }

    /* JADX INFO: compiled from: SiteInfoFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/customized/tianjin/SiteInfoFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/customized/tianjin/SiteInfoFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SiteInfoFragment newInstance() {
            return new SiteInfoFragment();
        }
    }

    private final SiteInfoViewModel getViewModel() {
        return (SiteInfoViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initViewModel();
    }

    private final void initView() {
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        getBinding().recyclerView.setAdapter(this.levelAdapter);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (1999 == id) {
            getViewModel().m319getCustomSiteInfo();
        }
    }

    private final void initViewModel() {
        MutableLiveData<Result<CustomSiteInfoBean>> customSiteInfo = getViewModel().getCustomSiteInfo();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends CustomSiteInfoBean>, Unit> function1 = new Function1<Result<? extends CustomSiteInfoBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends CustomSiteInfoBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code duplicated, block: B:26:0x00c6  */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends CustomSiteInfoBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    CustomSiteInfoBean customSiteInfoBean = (CustomSiteInfoBean) value;
                    if (customSiteInfoBean != null) {
                        SiteInfoFragment siteInfoFragment = SiteInfoFragment.this;
                        CustomExtInfoBean extInfo = customSiteInfoBean.getExtInfo();
                        if (extInfo != null) {
                            SiteInfoFragment.access$getBinding(siteInfoFragment).tvAffiliatedCollege.setText(extInfo.getBelongingCollege());
                            SiteInfoFragment.access$getBinding(siteInfoFragment).tvPersonCharge.setText(extInfo.getManagerName());
                            siteInfoFragment.levelAdapter.setList(extInfo.getBelongingCategories());
                            switch (extInfo.getSiteLevel()) {
                                case "1":
                                    SiteInfoFragment.access$getBinding(siteInfoFragment).tvGrade.setBackgroundResource(R.drawable.bg_ff4f4f_3);
                                    SiteInfoFragment.access$getBinding(siteInfoFragment).tvGrade.setText("一级");
                                    break;
                                case "2":
                                    SiteInfoFragment.access$getBinding(siteInfoFragment).tvGrade.setBackgroundResource(R.drawable.bg_ff6a0c_3);
                                    SiteInfoFragment.access$getBinding(siteInfoFragment).tvGrade.setText("二级");
                                    break;
                                case "3":
                                    SiteInfoFragment.access$getBinding(siteInfoFragment).tvGrade.setBackgroundResource(R.drawable.bg_ffd802_3);
                                    SiteInfoFragment.access$getBinding(siteInfoFragment).tvGrade.setText("三级");
                                    break;
                                default:
                                    SiteInfoFragment.access$getBinding(siteInfoFragment).tvGrade.setBackgroundResource(R.drawable.bg_4fa3ff_3);
                                    SiteInfoFragment.access$getBinding(siteInfoFragment).tvGrade.setText("四级");
                                    break;
                            }
                        }
                        SiteInfoFragment.access$getBinding(siteInfoFragment).tvSiteName.setText(customSiteInfoBean.getName());
                        SiteInfoFragment.access$getBinding(siteInfoFragment).tvRoomNumber.setText(customSiteInfoBean.getRoomNum());
                        List<String> images = customSiteInfoBean.getImages();
                        if (images != null) {
                            GlideUtil.loadImage(siteInfoFragment.getContext(), (String) CollectionsKt.first((List) images), SiteInfoFragment.access$getBinding(siteInfoFragment).ivQrCode);
                        }
                    }
                }
            }
        };
        customSiteInfo.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.-$$Lambda$SiteInfoFragment$uUWXhra2iC3TgOr8axeuAsKf7jM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SiteInfoFragment.initViewModel$lambda$0(function1, obj);
            }
        });
        getViewModel().m319getCustomSiteInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
