package com.yd.android_brand_mvp.activity.collect.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.collect.viewmodel.CollectFormDetailViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ItemFormRadioBinding;
import com.yd.android_brand_mvp.databinding.ViewCollectFormCheckBinding;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.collect.ItemSelectBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: compiled from: FormRadioFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000f\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormRadioFragment;", "Lcom/yd/android_brand_mvp/activity/collect/fragment/BaseCollectFragment;", "Lcom/yd/android_brand_mvp/databinding/ViewCollectFormCheckBinding;", "()V", "activityViewModel", "Lcom/yd/android_brand_mvp/activity/collect/viewmodel/CollectFormDetailViewModel;", "getActivityViewModel", "()Lcom/yd/android_brand_mvp/activity/collect/viewmodel/CollectFormDetailViewModel;", "activityViewModel$delegate", "Lkotlin/Lazy;", "currentSelectPosition", "", "formItemData", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "radioAdapter", "com/yd/android_brand_mvp/activity/collect/fragment/FormRadioFragment$radioAdapter$2$1", "getRadioAdapter", "()Lcom/yd/android_brand_mvp/activity/collect/fragment/FormRadioFragment$radioAdapter$2$1;", "radioAdapter$delegate", "getSelectList", "", "", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "readySubmit", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormRadioFragment extends BaseCollectFragment<ViewCollectFormCheckBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: activityViewModel$delegate, reason: from kotlin metadata */
    private final Lazy activityViewModel;
    private int currentSelectPosition;
    private FormBaseBean formItemData;

    /* JADX INFO: renamed from: radioAdapter$delegate, reason: from kotlin metadata */
    private final Lazy radioAdapter;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.FormRadioFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormRadioFragment.kt */
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

    public FormRadioFragment() {
        super(AnonymousClass1.INSTANCE);
        this.currentSelectPosition = -1;
        this.radioAdapter = LazyKt.lazy(new Function0<FormRadioFragment$radioAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormRadioFragment$radioAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.collect.fragment.FormRadioFragment$radioAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new BaseBindingAdapter<ItemFormRadioBinding, ItemSelectBean>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormRadioFragment$radioAdapter$2.1
                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ItemSelectBean itemSelectBean) {
                        convertPlus2((VBViewHolder<ItemFormRadioBinding>) vBViewHolder, itemSelectBean);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemFormRadioBinding> holder, ItemSelectBean item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemFormRadioBinding itemFormRadioBinding = (ItemFormRadioBinding) holder.getBinding();
                        if (itemFormRadioBinding != null) {
                            if (item.isSelect()) {
                                itemFormRadioBinding.ivItemFormRadioSelect.setImageResource(R.drawable.icon_radio_select);
                            } else {
                                itemFormRadioBinding.ivItemFormRadioSelect.setImageResource(R.drawable.icon_radio_not_select);
                            }
                            itemFormRadioBinding.tvItemFormRadioName.setText(item.getContent());
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
        final FormRadioFragment formRadioFragment = this;
        final Function0 function0 = null;
        this.activityViewModel = FragmentViewModelLazyKt.createViewModelLazy(formRadioFragment, Reflection.getOrCreateKotlinClass(CollectFormDetailViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormRadioFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = formRadioFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormRadioFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                if (function1 != null && (creationExtras = (CreationExtras) function1.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = formRadioFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormRadioFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = formRadioFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX INFO: compiled from: FormRadioFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormRadioFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "dataBean", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(FormBaseBean dataBean) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            FormRadioFragment formRadioFragment = new FormRadioFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", GsonUtils.toJson(dataBean));
            formRadioFragment.setArguments(bundle);
            return formRadioFragment;
        }
    }

    private final FormRadioFragment$radioAdapter$2.AnonymousClass1 getRadioAdapter() {
        return (FormRadioFragment$radioAdapter$2.AnonymousClass1) this.radioAdapter.getValue();
    }

    private final CollectFormDetailViewModel getActivityViewModel() {
        return (CollectFormDetailViewModel) this.activityViewModel.getValue();
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
        getRadioAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormRadioFragment$3yOz6qyz7GsCbdbKGJS4kkqMrh4
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FormRadioFragment.initView$lambda$1(this.f$0, baseQuickAdapter, view, i);
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
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj : formBaseBean.getProps().getOptions()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str = obj instanceof String ? (String) obj : null;
                if (str == null) {
                    return;
                }
                if (Intrinsics.areEqual(obj, formBaseBean.getValue())) {
                    this.currentSelectPosition = i;
                    arrayList.add(new ItemSelectBean(true, str, null, 4, null));
                } else {
                    arrayList.add(new ItemSelectBean(false, str, null, 4, null));
                }
                i = i2;
            }
            getRadioAdapter().setList(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(FormRadioFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        int i2 = this$0.currentSelectPosition;
        if (i2 != -1 && i2 != i) {
            this$0.getRadioAdapter().getItem(this$0.currentSelectPosition).setSelect(false);
            adapter.notifyItemChanged(this$0.currentSelectPosition);
        }
        ItemSelectBean item = this$0.getRadioAdapter().getItem(i);
        item.setSelect(!item.isSelect());
        this$0.currentSelectPosition = item.isSelect() ? i : -1;
        adapter.notifyItemChanged(i);
        this$0.getActivityViewModel().getUpdateComponentListStatus();
        FormBaseBean formBaseBean = this$0.formItemData;
        if (formBaseBean == null || !formBaseBean.getProps().getRequired()) {
            return;
        }
        FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
        String content = this$0.currentSelectPosition == -1 ? "" : item.getContent();
        formVerifyBean.setStatus(true);
        FormBaseBean formBaseBean2 = this$0.formItemData;
        Intrinsics.checkNotNull(formBaseBean2);
        formVerifyBean.setSort(formBaseBean2.getSort());
        formVerifyBean.setDataValue(content);
        EventBus.getDefault().post(formVerifyBean);
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
        if (this.currentSelectPosition != -1) {
            FormBaseBean formBaseBean2 = this.formItemData;
            Intrinsics.checkNotNull(formBaseBean2);
            formVerifyBean.setSort(formBaseBean2.getSort());
            formVerifyBean.setDataValue(getRadioAdapter().getData().get(this.currentSelectPosition).getContent());
        }
        return formVerifyBean;
    }

    @Override // com.yd.android_brand_mvp.activity.collect.fragment.BaseCollectFragment
    public List<String> getSelectList() {
        ArrayList arrayList = new ArrayList();
        if (this.currentSelectPosition != -1) {
            arrayList.add(getRadioAdapter().getData().get(this.currentSelectPosition).getContent());
        }
        return arrayList;
    }
}
