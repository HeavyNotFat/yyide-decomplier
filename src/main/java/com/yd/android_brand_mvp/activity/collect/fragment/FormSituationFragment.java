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
import androidx.recyclerview.widget.GridLayoutManager;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.collect.viewmodel.FormSituationViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentFormSituationBinding;
import com.yd.android_brand_mvp.databinding.ItemReservationSignBinding;
import com.yd.android_brand_mvp.model.collect.CollectSituationBean;
import com.yd.android_brand_mvp.model.collect.FormStudentListItem;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
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

/* JADX INFO: compiled from: FormSituationFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u000b\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormSituationFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentFormSituationBinding;", "()V", "clickItem", "", "id", "", "isPortrait", "", "peopleAdapter", "com/yd/android_brand_mvp/activity/collect/fragment/FormSituationFragment$peopleAdapter$2$1", "getPeopleAdapter", "()Lcom/yd/android_brand_mvp/activity/collect/fragment/FormSituationFragment$peopleAdapter$2$1;", "peopleAdapter$delegate", "Lkotlin/Lazy;", "responseData", "Lcom/yd/android_brand_mvp/model/collect/CollectSituationBean;", "viewMode", "Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormSituationViewModel;", "getViewMode", "()Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormSituationViewModel;", "viewMode$delegate", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "setUiData", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormSituationFragment extends KTBaseFragment<FragmentFormSituationBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int clickItem;
    private String id;
    private boolean isPortrait;

    /* JADX INFO: renamed from: peopleAdapter$delegate, reason: from kotlin metadata */
    private final Lazy peopleAdapter;
    private CollectSituationBean responseData;

    /* JADX INFO: renamed from: viewMode$delegate, reason: from kotlin metadata */
    private final Lazy viewMode;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.FormSituationFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormSituationFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentFormSituationBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentFormSituationBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentFormSituationBinding;", 0);
        }

        public final FragmentFormSituationBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentFormSituationBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentFormSituationBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public FormSituationFragment() {
        super(AnonymousClass1.INSTANCE);
        this.id = "-1";
        final FormSituationFragment formSituationFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSituationFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return formSituationFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSituationFragment$special$$inlined$viewModels$default$2
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
        this.viewMode = FragmentViewModelLazyKt.createViewModelLazy(formSituationFragment, Reflection.getOrCreateKotlinClass(FormSituationViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSituationFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSituationFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSituationFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = formSituationFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.peopleAdapter = LazyKt.lazy(new Function0<FormSituationFragment$peopleAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSituationFragment$peopleAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.collect.fragment.FormSituationFragment$peopleAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new BaseBindingAdapter<ItemReservationSignBinding, FormStudentListItem>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSituationFragment$peopleAdapter$2.1
                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, FormStudentListItem formStudentListItem) {
                        convertPlus2((VBViewHolder<ItemReservationSignBinding>) vBViewHolder, formStudentListItem);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemReservationSignBinding> holder, FormStudentListItem item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemReservationSignBinding itemReservationSignBinding = (ItemReservationSignBinding) holder.getBinding();
                        if (itemReservationSignBinding != null) {
                            GlideUtil.loadCircleImage(getContext(), item.getAvatar(), itemReservationSignBinding.ivItemReservationSignAvatar);
                            itemReservationSignBinding.tvItemReservationSignName.setText(item.getName());
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemReservationSignBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemReservationSignBinding itemReservationSignBindingInflate = ItemReservationSignBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemReservationSignBindingInflate, "inflate(inflater, parent, false)");
                        return itemReservationSignBindingInflate;
                    }
                };
            }
        });
    }

    /* JADX INFO: compiled from: FormSituationFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormSituationFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "id", "", "isPortrait", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String id, boolean isPortrait) {
            Intrinsics.checkNotNullParameter(id, "id");
            FormSituationFragment formSituationFragment = new FormSituationFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putBoolean("isPortrait", isPortrait);
            formSituationFragment.setArguments(bundle);
            return formSituationFragment;
        }
    }

    private final FormSituationViewModel getViewMode() {
        return (FormSituationViewModel) this.viewMode.getValue();
    }

    private final FormSituationFragment$peopleAdapter$2.AnonymousClass1 getPeopleAdapter() {
        return (FormSituationFragment$peopleAdapter$2.AnonymousClass1) this.peopleAdapter.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        request();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("id") : null;
        if (string == null) {
            string = "-1";
        }
        this.id = string;
        Bundle arguments2 = getArguments();
        boolean z = arguments2 != null ? arguments2.getBoolean("isPortrait") : false;
        this.isPortrait = z;
        getBinding().rvFragmentFormSituationList.setLayoutManager(new GridLayoutManager(requireContext(), z ? 6 : 11));
        getBinding().rvFragmentFormSituationList.setAdapter(getPeopleAdapter());
        getBinding().rvFragmentFormSituationList.setItemAnimator(null);
        getBinding().tvFragmentFormSituationSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormSituationFragment$IZs5p6GzDU0C2VheOZuxEVne-y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormSituationFragment.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().tvFragmentFormSituationNotSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormSituationFragment$LdSrYDLpN6Qp3QKMQlKx0glypJs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormSituationFragment.initView$lambda$1(this.f$0, view);
            }
        });
        LiveData<Result<CollectSituationBean>> reportSituation = getViewMode().getReportSituation();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends CollectSituationBean>, Unit> function1 = new Function1<Result<? extends CollectSituationBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSituationFragment.initView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends CollectSituationBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends CollectSituationBean> it2) {
                FormSituationFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                CollectSituationBean collectSituationBean = (CollectSituationBean) value;
                if (collectSituationBean == null) {
                    return;
                }
                FormSituationFragment.this.responseData = collectSituationBean;
                FormSituationFragment.this.setUiData();
            }
        };
        reportSituation.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormSituationFragment$PvHxSWpsZLuMCtxa2qk0Y6OQO0Y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FormSituationFragment.initView$lambda$2(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(FormSituationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().tvFragmentFormSituationSign.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().tvFragmentFormSituationSign.setBackgroundResource(R.drawable.bg_purple23);
        this$0.getBinding().tvFragmentFormSituationNotSign.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvFragmentFormSituationNotSign.setBackground(null);
        this$0.clickItem = 0;
        this$0.setUiData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(FormSituationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().tvFragmentFormSituationNotSign.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().tvFragmentFormSituationNotSign.setBackgroundResource(R.drawable.bg_purple23);
        this$0.getBinding().tvFragmentFormSituationSign.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvFragmentFormSituationSign.setBackground(null);
        this$0.clickItem = 1;
        this$0.setUiData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUiData() {
        if (this.responseData == null) {
            return;
        }
        if (this.clickItem == 0) {
            FormSituationFragment$peopleAdapter$2.AnonymousClass1 peopleAdapter = getPeopleAdapter();
            CollectSituationBean collectSituationBean = this.responseData;
            peopleAdapter.setList(collectSituationBean != null ? collectSituationBean.getAlreadyDidStudentList() : null);
        } else {
            FormSituationFragment$peopleAdapter$2.AnonymousClass1 peopleAdapter2 = getPeopleAdapter();
            CollectSituationBean collectSituationBean2 = this.responseData;
            peopleAdapter2.setList(collectSituationBean2 != null ? collectSituationBean2.getGonnaDoStudentList() : null);
        }
        TextView textView = getBinding().tvFragmentFormSituationCount;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.all_count_people);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.all_count_people)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(getPeopleAdapter().getData().size())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
    }

    private final void request() {
        if (Intrinsics.areEqual(this.id, "-1")) {
            return;
        }
        showProgressDialog();
        getViewMode().getReportSituation(this.id);
    }
}
