package com.yd.android_brand_mvp.activity.collect.fragment;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ItemFormRadioBinding;
import com.yd.android_brand_mvp.databinding.ViewCollectFormCheckBinding;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.userspace.LeaveTypeBean;
import com.yd.android_brand_mvp.user.viewmodel.StudentApplyLeaveViewModel;
import com.yd.android_brand_mvp.utils.MMKVUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
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
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: compiled from: FormLeaveTypeFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\t\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u001a\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormLeaveTypeFragment;", "Lcom/yd/android_brand_mvp/activity/collect/fragment/BaseCollectFragment;", "Lcom/yd/android_brand_mvp/databinding/ViewCollectFormCheckBinding;", "()V", "currentSelectPosition", "", "formItemData", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "radioAdapter", "com/yd/android_brand_mvp/activity/collect/fragment/FormLeaveTypeFragment$radioAdapter$2$1", "getRadioAdapter", "()Lcom/yd/android_brand_mvp/activity/collect/fragment/FormLeaveTypeFragment$radioAdapter$2$1;", "radioAdapter$delegate", "Lkotlin/Lazy;", "typeList", "", "Lcom/yd/android_brand_mvp/model/userspace/LeaveTypeBean;", "viewModel", "Lcom/yd/android_brand_mvp/user/viewmodel/StudentApplyLeaveViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/user/viewmodel/StudentApplyLeaveViewModel;", "viewModel$delegate", "getSelectList", "", "", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "readySubmit", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormLeaveTypeFragment extends BaseCollectFragment<ViewCollectFormCheckBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int currentSelectPosition;
    private FormBaseBean formItemData;

    /* JADX INFO: renamed from: radioAdapter$delegate, reason: from kotlin metadata */
    private final Lazy radioAdapter;
    private final List<LeaveTypeBean> typeList;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.FormLeaveTypeFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormLeaveTypeFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ViewCollectFormCheckBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ViewCollectFormCheckBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ViewCollectFormCheckBinding;", 0);
        }

        public final ViewCollectFormCheckBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ViewCollectFormCheckBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ViewCollectFormCheckBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public FormLeaveTypeFragment() {
        super(AnonymousClass1.INSTANCE);
        final FormLeaveTypeFragment formLeaveTypeFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormLeaveTypeFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return formLeaveTypeFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormLeaveTypeFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(formLeaveTypeFragment, Reflection.getOrCreateKotlinClass(StudentApplyLeaveViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormLeaveTypeFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormLeaveTypeFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormLeaveTypeFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = formLeaveTypeFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.typeList = new ArrayList();
        this.currentSelectPosition = -1;
        this.radioAdapter = LazyKt.lazy(new Function0<FormLeaveTypeFragment$radioAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormLeaveTypeFragment$radioAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.collect.fragment.FormLeaveTypeFragment$radioAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new BaseBindingAdapter<ItemFormRadioBinding, LeaveTypeBean>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormLeaveTypeFragment$radioAdapter$2.1
                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, LeaveTypeBean leaveTypeBean) {
                        convertPlus2((VBViewHolder<ItemFormRadioBinding>) vBViewHolder, leaveTypeBean);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemFormRadioBinding> holder, LeaveTypeBean item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemFormRadioBinding itemFormRadioBinding = (ItemFormRadioBinding) holder.getBinding();
                        if (itemFormRadioBinding != null) {
                            if (item.isSelect()) {
                                itemFormRadioBinding.ivItemFormRadioSelect.setImageResource(R.drawable.icon_radio_select);
                            } else {
                                itemFormRadioBinding.ivItemFormRadioSelect.setImageResource(R.drawable.icon_radio_not_select);
                            }
                            itemFormRadioBinding.tvItemFormRadioName.setText(item.getName());
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemFormRadioBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemFormRadioBinding itemFormRadioBindingInflate = ItemFormRadioBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemFormRadioBindingInflate, "inflate(inflater, parent, false)");
                        return itemFormRadioBindingInflate;
                    }
                };
            }
        });
    }

    /* JADX INFO: compiled from: FormLeaveTypeFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormLeaveTypeFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "dataBean", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(FormBaseBean dataBean) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            FormLeaveTypeFragment formLeaveTypeFragment = new FormLeaveTypeFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", GsonUtils.toJson(dataBean));
            formLeaveTypeFragment.setArguments(bundle);
            return formLeaveTypeFragment;
        }
    }

    private final StudentApplyLeaveViewModel getViewModel() {
        return (StudentApplyLeaveViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FormLeaveTypeFragment$radioAdapter$2.AnonymousClass1 getRadioAdapter() {
        return (FormLeaveTypeFragment$radioAdapter$2.AnonymousClass1) this.radioAdapter.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        Bundle arguments = getArguments();
        this.formItemData = (FormBaseBean) GsonUtils.fromJson(arguments != null ? arguments.getString("data") : null, FormBaseBean.class);
        ((ViewCollectFormCheckBinding) getBinding()).rvViewCollectFormCheckOption.setLayoutManager(new LinearLayoutManager(requireContext()));
        ((ViewCollectFormCheckBinding) getBinding()).rvViewCollectFormCheckOption.setAdapter(getRadioAdapter());
        getRadioAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormLeaveTypeFragment$A6fWZr9JEJTYaK2rJRd0pCUFQCk
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FormLeaveTypeFragment.initView$lambda$1(this.f$0, baseQuickAdapter, view, i);
            }
        });
        FormBaseBean formBaseBean = this.formItemData;
        if (formBaseBean != null) {
            ((ViewCollectFormCheckBinding) getBinding()).tvViewCollectFormCheckName.setText(TransUtils.INSTANCE.transIntToString(formBaseBean.getSortNum()) + '.' + formBaseBean.getTitle());
            if (!formBaseBean.getProps().getRequired()) {
                TextView textView = ((ViewCollectFormCheckBinding) getBinding()).tvViewCollectFormCheckRequired;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvViewCollectFormCheckRequired");
                SimpleUtilsKt.remove(textView);
            }
            getViewModel().getLeaveTypeOption();
        }
        LiveData<Result<List<LeaveTypeBean>>> leaveTypeList = getViewModel().getLeaveTypeList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends LeaveTypeBean>>, Unit> function1 = new Function1<Result<? extends List<? extends LeaveTypeBean>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormLeaveTypeFragment.initView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends LeaveTypeBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends LeaveTypeBean>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                List list = (List) value;
                if (list == null) {
                    return;
                }
                FormLeaveTypeFragment.this.typeList.clear();
                FormLeaveTypeFragment.this.typeList.addAll(list);
                int i = 0;
                for (LeaveTypeBean leaveTypeBean : FormLeaveTypeFragment.this.typeList) {
                    int i2 = i + 1;
                    String id = leaveTypeBean.getId();
                    FormBaseBean formBaseBean2 = FormLeaveTypeFragment.this.formItemData;
                    Intrinsics.checkNotNull(formBaseBean2);
                    if (Intrinsics.areEqual(id, formBaseBean2.getValue())) {
                        FormLeaveTypeFragment.this.currentSelectPosition = i;
                        leaveTypeBean.setSelect(true);
                        break;
                    }
                    i = i2;
                }
                MMKVUtil.INSTANCE.saveLeaveTypeList(FormLeaveTypeFragment.this.typeList);
                if (FormLeaveTypeFragment.this.currentSelectPosition == -1 && (!FormLeaveTypeFragment.this.typeList.isEmpty())) {
                    FormLeaveTypeFragment.this.currentSelectPosition = 0;
                    LeaveTypeBean leaveTypeBean2 = (LeaveTypeBean) CollectionsKt.first(FormLeaveTypeFragment.this.typeList);
                    leaveTypeBean2.setSelect(true);
                    EventBus.getDefault().postSticky(leaveTypeBean2);
                    FormBaseBean formBaseBean3 = FormLeaveTypeFragment.this.formItemData;
                    Intrinsics.checkNotNull(formBaseBean3);
                    if (formBaseBean3.getProps().getRequired()) {
                        FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
                        formVerifyBean.setStatus(true);
                        FormBaseBean formBaseBean4 = FormLeaveTypeFragment.this.formItemData;
                        Intrinsics.checkNotNull(formBaseBean4);
                        formVerifyBean.setSort(formBaseBean4.getSort());
                        formVerifyBean.setDataValue(leaveTypeBean2.getId());
                        EventBus.getDefault().post(formVerifyBean);
                    }
                }
                FormLeaveTypeFragment.this.getRadioAdapter().setList(FormLeaveTypeFragment.this.typeList);
            }
        };
        leaveTypeList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormLeaveTypeFragment$Y-oyczGHQ40gXTSHf1-QgKj37Y8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FormLeaveTypeFragment.initView$lambda$3(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(FormLeaveTypeFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        int i2 = this$0.currentSelectPosition;
        if (i2 != -1 && i2 != i) {
            this$0.getRadioAdapter().getItem(this$0.currentSelectPosition).setSelect(false);
            adapter.notifyItemChanged(this$0.currentSelectPosition);
        }
        LeaveTypeBean item = this$0.getRadioAdapter().getItem(i);
        item.setSelect(!item.isSelect());
        this$0.currentSelectPosition = item.isSelect() ? i : -1;
        adapter.notifyItemChanged(i);
        EventBus.getDefault().post(this$0.typeList.get(i));
        FormBaseBean formBaseBean = this$0.formItemData;
        if (formBaseBean == null || !formBaseBean.getProps().getRequired()) {
            return;
        }
        FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
        String id = this$0.currentSelectPosition == -1 ? "" : item.getId();
        formVerifyBean.setStatus(true);
        FormBaseBean formBaseBean2 = this$0.formItemData;
        Intrinsics.checkNotNull(formBaseBean2);
        formVerifyBean.setSort(formBaseBean2.getSort());
        formVerifyBean.setDataValue(id);
        EventBus.getDefault().post(formVerifyBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.yd.android_brand_mvp.activity.collect.fragment.BaseCollectFragment
    public FormVerifyBean readySubmit() {
        FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
        FormBaseBean formBaseBean = this.formItemData;
        if (formBaseBean == null) {
            return formVerifyBean;
        }
        Intrinsics.checkNotNull(formBaseBean);
        if (formBaseBean.getProps().getRequired() && this.currentSelectPosition == -1) {
            formVerifyBean.setStatus(false);
            formVerifyBean.setErrorMessage("单选必填项未填写");
            return formVerifyBean;
        }
        if (this.currentSelectPosition != -1 && (!getRadioAdapter().getData().isEmpty())) {
            FormBaseBean formBaseBean2 = this.formItemData;
            Intrinsics.checkNotNull(formBaseBean2);
            formVerifyBean.setSort(formBaseBean2.getSort());
            formVerifyBean.setDataValue(getRadioAdapter().getData().get(this.currentSelectPosition).getId());
        }
        return formVerifyBean;
    }

    @Override // com.yd.android_brand_mvp.activity.collect.fragment.BaseCollectFragment
    public List<String> getSelectList() {
        ArrayList arrayList = new ArrayList();
        if (this.currentSelectPosition != -1) {
            arrayList.add(getRadioAdapter().getData().get(this.currentSelectPosition).getId());
        }
        return arrayList;
    }
}
