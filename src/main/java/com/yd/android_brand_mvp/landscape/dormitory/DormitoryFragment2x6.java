package com.yd.android_brand_mvp.landscape.dormitory;

import android.os.Bundle;
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
import androidx.recyclerview.widget.GridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentDormitoryFragment2x6Binding;
import com.yd.android_brand_mvp.databinding.ItemDormitoryNumberBinding;
import com.yd.android_brand_mvp.landscape.dormitory.viewmodel.DormitoryViewModel;
import com.yd.android_brand_mvp.model.dormitory.DormitoryDetailsBean;
import com.yd.android_brand_mvp.model.dormitory.DormitoryEachStudent;
import com.yd.android_brand_mvp.mqtt.MQTTConstant;
import java.util.Arrays;
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
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: DormitoryFragment2x6.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0005\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u001a\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001e\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u001dR\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/dormitory/DormitoryFragment2x6;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentDormitoryFragment2x6Binding;", "()V", "adapter", "com/yd/android_brand_mvp/landscape/dormitory/DormitoryFragment2x6$adapter$1", "Lcom/yd/android_brand_mvp/landscape/dormitory/DormitoryFragment2x6$adapter$1;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/dormitory/viewmodel/DormitoryViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/dormitory/viewmodel/DormitoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "", "initView", "initViewModel", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setData", AdvanceSetting.NETWORK_TYPE, "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/dormitory/DormitoryDetailsBean;", "(Ljava/lang/Object;)V", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DormitoryFragment2x6 extends KTBaseFragment<FragmentDormitoryFragment2x6Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DormitoryFragment2x6$adapter$1 adapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.dormitory.DormitoryFragment2x6$1, reason: invalid class name */
    /* JADX INFO: compiled from: DormitoryFragment2x6.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentDormitoryFragment2x6Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentDormitoryFragment2x6Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentDormitoryFragment2x6Binding;", 0);
        }

        public final FragmentDormitoryFragment2x6Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentDormitoryFragment2x6Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentDormitoryFragment2x6Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.yd.android_brand_mvp.landscape.dormitory.DormitoryFragment2x6$adapter$1] */
    public DormitoryFragment2x6() {
        super(AnonymousClass1.INSTANCE);
        final DormitoryFragment2x6 dormitoryFragment2x6 = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.dormitory.DormitoryFragment2x6$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return dormitoryFragment2x6;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.dormitory.DormitoryFragment2x6$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(dormitoryFragment2x6, Reflection.getOrCreateKotlinClass(DormitoryViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.dormitory.DormitoryFragment2x6$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.dormitory.DormitoryFragment2x6$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.dormitory.DormitoryFragment2x6$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = dormitoryFragment2x6.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.adapter = new BaseQuickAdapter<DormitoryEachStudent, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.dormitory.DormitoryFragment2x6$adapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, DormitoryEachStudent item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemDormitoryNumberBinding itemDormitoryNumberBindingBind = ItemDormitoryNumberBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemDormitoryNumberBindingBind, "bind(holder.itemView)");
                if (Intrinsics.areEqual(item.getName(), Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    item.setName("");
                }
                if (Intrinsics.areEqual(item.getClassesName(), Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    item.setClassesName("");
                }
                itemDormitoryNumberBindingBind.tvNumber.setText(item.getBedNo());
                itemDormitoryNumberBindingBind.tvName.setText(item.getName());
                itemDormitoryNumberBindingBind.tvClasses.setText(item.getClassesName());
            }
        };
    }

    /* JADX INFO: compiled from: DormitoryFragment2x6.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/dormitory/DormitoryFragment2x6$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/dormitory/DormitoryFragment2x6;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DormitoryFragment2x6 newInstance() {
            return new DormitoryFragment2x6();
        }
    }

    private final DormitoryViewModel getViewModel() {
        return (DormitoryViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        getBinding().recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        getBinding().recyclerView.setAdapter(this.adapter);
        initViewModel();
    }

    private final void initViewModel() {
        MutableLiveData<Result<DormitoryDetailsBean>> details = getViewModel().getDetails();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends DormitoryDetailsBean>, Unit> function1 = new Function1<Result<? extends DormitoryDetailsBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.dormitory.DormitoryFragment2x6.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends DormitoryDetailsBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends DormitoryDetailsBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    DormitoryFragment2x6.this.setData(it2.getValue());
                }
            }
        };
        details.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.dormitory.-$$Lambda$DormitoryFragment2x6$-f_nVTtOumtgLCApiMDPtgR9LYQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DormitoryFragment2x6.initViewModel$lambda$0(function1, obj);
            }
        });
        getViewModel().getDormitoryDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (Integer.parseInt(MQTTConstant.Dormitory) == id) {
            getViewModel().getDormitoryDetail();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setData(Object it2) {
        if (Result.m597isFailureimpl(it2)) {
            it2 = null;
        }
        DormitoryDetailsBean dormitoryDetailsBean = (DormitoryDetailsBean) it2;
        if (dormitoryDetailsBean != null) {
            getBinding().tvRoundNumberName.setText(dormitoryDetailsBean.getRoomNo());
            getBinding().tvNumberName.setText(dormitoryDetailsBean.getRoomNo());
            getBinding().tvPeopleNumber.setText(dormitoryDetailsBean.getRoomType());
            getBinding().tvName.setText(dormitoryDetailsBean.getRoomName());
            if (dormitoryDetailsBean.getResidentsCount() <= 0) {
                getBinding().tvStatus.setText("空房");
                getBinding().tvStatus.setBackgroundResource(R.color.color_00B781);
            } else if (dormitoryDetailsBean.getResidentsCount() == dormitoryDetailsBean.getRoomTypeInt()) {
                getBinding().tvStatus.setText("满员");
                getBinding().tvStatus.setBackgroundResource(R.color.color_FFA645);
            } else {
                getBinding().tvStatus.setText("未满");
                getBinding().tvStatus.setBackgroundResource(R.drawable.border_1dp_white);
            }
            TextView textView = getBinding().tvLeader;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("寝室长：%s", Arrays.copyOf(new Object[]{dormitoryDetailsBean.getRoomAdministrator()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            textView.setText(str);
            setList(dormitoryDetailsBean.getEachStudent());
        }
    }
}
