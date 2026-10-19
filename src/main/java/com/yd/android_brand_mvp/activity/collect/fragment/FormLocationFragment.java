package com.yd.android_brand_mvp.activity.collect.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.activity.collect.viewmodel.FormItemViewModel;
import com.yd.android_brand_mvp.databinding.ViewCollectFormLocationBinding;
import com.yd.android_brand_mvp.dialog.collect.LocationPopup;
import com.yd.android_brand_mvp.listener.StringListener;
import com.yd.android_brand_mvp.model.AreaBean;
import com.yd.android_brand_mvp.model.AreaItem;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.collect.FormLocationBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FormLocationFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormLocationFragment;", "Lcom/yd/android_brand_mvp/activity/collect/fragment/BaseCollectFragment;", "Lcom/yd/android_brand_mvp/databinding/ViewCollectFormLocationBinding;", "()V", "areaInfoList", "", "Lcom/yd/android_brand_mvp/model/AreaItem;", "cityInfoList", "clickItem", "", "formItemData", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "providerInfoList", "Lcom/yd/android_brand_mvp/model/AreaBean;", "selectPopup", "Lcom/yd/android_brand_mvp/dialog/collect/LocationPopup;", "viewModel", "Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormItemViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormItemViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "readySubmit", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormLocationFragment extends BaseCollectFragment<ViewCollectFormLocationBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<AreaItem> areaInfoList;
    private final List<AreaItem> cityInfoList;
    private int clickItem;
    private FormBaseBean formItemData;
    private final List<AreaBean> providerInfoList;
    private LocationPopup selectPopup;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.FormLocationFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormLocationFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ViewCollectFormLocationBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ViewCollectFormLocationBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ViewCollectFormLocationBinding;", 0);
        }

        public final ViewCollectFormLocationBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ViewCollectFormLocationBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ViewCollectFormLocationBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ViewCollectFormLocationBinding access$getBinding(FormLocationFragment formLocationFragment) {
        return (ViewCollectFormLocationBinding) formLocationFragment.getBinding();
    }

    public FormLocationFragment() {
        super(AnonymousClass1.INSTANCE);
        final FormLocationFragment formLocationFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormLocationFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return formLocationFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormLocationFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(formLocationFragment, Reflection.getOrCreateKotlinClass(FormItemViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormLocationFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormLocationFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormLocationFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = formLocationFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.providerInfoList = new ArrayList();
        this.cityInfoList = new ArrayList();
        this.areaInfoList = new ArrayList();
    }

    /* JADX INFO: compiled from: FormLocationFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormLocationFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "dataBean", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(FormBaseBean dataBean) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            FormLocationFragment formLocationFragment = new FormLocationFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", GsonUtils.toJson(dataBean));
            formLocationFragment.setArguments(bundle);
            return formLocationFragment;
        }
    }

    private final FormItemViewModel getViewModel() {
        return (FormItemViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        showProgressDialog();
        getViewModel().getLocationInfo();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        Bundle arguments = getArguments();
        LocationPopup locationPopup = null;
        FormBaseBean formBaseBean = (FormBaseBean) GsonUtils.fromJson(arguments != null ? arguments.getString("data") : null, FormBaseBean.class);
        this.formItemData = formBaseBean;
        if (formBaseBean != null) {
            ((ViewCollectFormLocationBinding) getBinding()).tvViewCollectFormLocationName.setText(TransUtils.INSTANCE.transIntToString(formBaseBean.getSortNum()) + '.' + formBaseBean.getTitle());
            if (!formBaseBean.getProps().getRequired()) {
                TextView textView = ((ViewCollectFormLocationBinding) getBinding()).tvViewCollectFormLocationRequired;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvViewCollectFormLocationRequired");
                SimpleUtilsKt.remove(textView);
            }
            if (formBaseBean.getProps().getAutomaticPositioning()) {
                EditText editText = ((ViewCollectFormLocationBinding) getBinding()).etViewCollectFormLocationAddress;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.etViewCollectFormLocationAddress");
                SimpleUtilsKt.show(editText);
            } else {
                EditText editText2 = ((ViewCollectFormLocationBinding) getBinding()).etViewCollectFormLocationAddress;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.etViewCollectFormLocationAddress");
                SimpleUtilsKt.remove(editText2);
            }
            String value = formBaseBean.getValue();
            if (!(value == null || value.length() == 0)) {
                FormLocationBean formLocationBean = (FormLocationBean) GsonUtils.fromJson(formBaseBean.getValue(), FormLocationBean.class);
                ((ViewCollectFormLocationBinding) getBinding()).etViewCollectFormLocationAddress.setText(formLocationBean.getAddress());
                List listSplit$default = StringsKt.split$default((CharSequence) formLocationBean.getChain(), new String[]{Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null);
                if (listSplit$default.size() >= 3) {
                    ((ViewCollectFormLocationBinding) getBinding()).tvViewCollectFormLocationProvince.setText((CharSequence) listSplit$default.get(0));
                    ((ViewCollectFormLocationBinding) getBinding()).tvViewCollectFormLocationCity.setText((CharSequence) listSplit$default.get(1));
                    ((ViewCollectFormLocationBinding) getBinding()).tvViewCollectFormLocationArea.setText((CharSequence) listSplit$default.get(2));
                }
            }
        }
        LocationPopup locationPopup2 = new LocationPopup(this);
        this.selectPopup = locationPopup2;
        if (locationPopup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPopup");
            locationPopup2 = null;
        }
        locationPopup2.setCallBack(new StringListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormLocationFragment$3USjwEC3V_cuap6rI3xeK7RvO5k
            @Override // com.yd.android_brand_mvp.listener.StringListener
            public final void getStringData(String str) {
                FormLocationFragment.initView$lambda$1(this.f$0, str);
            }
        });
        ((ViewCollectFormLocationBinding) getBinding()).clViewCollectFormLocationProvince.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormLocationFragment$4J18CK3zwubR9PezHftYb-lrLtM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormLocationFragment.initView$lambda$3(this.f$0, view);
            }
        });
        ((ViewCollectFormLocationBinding) getBinding()).clViewCollectFormLocationCity.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormLocationFragment$mbWafdTPhot-Pv5ypCO3MyevoMI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormLocationFragment.initView$lambda$5(this.f$0, view);
            }
        });
        ((ViewCollectFormLocationBinding) getBinding()).clViewCollectFormLocationArea.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormLocationFragment$pSI3Qs10CyXqvUUSsSngUtpzytg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormLocationFragment.initView$lambda$8(this.f$0, view);
            }
        });
        LiveData<Result<List<AreaBean>>> areaInfo = getViewModel().getAreaInfo();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends AreaBean>>, Unit> function1 = new Function1<Result<? extends List<? extends AreaBean>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormLocationFragment.initView.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends AreaBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends AreaBean>> it2) {
                List<AreaItem> listEmptyList;
                Object next;
                List<AreaItem> listEmptyList2;
                FormLocationFragment.this.dismissProgressDialog();
                FormLocationFragment.this.providerInfoList.clear();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value2 = it2.getValue();
                Object obj = null;
                if (Result.m597isFailureimpl(value2)) {
                    value2 = null;
                }
                List list = (List) value2;
                if (list == null) {
                    return;
                }
                FormLocationFragment.this.providerInfoList.addAll(list);
                CharSequence text = FormLocationFragment.access$getBinding(FormLocationFragment.this).tvViewCollectFormLocationProvince.getText();
                Intrinsics.checkNotNullExpressionValue(text, "binding.tvViewCollectFormLocationProvince.text");
                if (text.length() > 0) {
                    CharSequence text2 = FormLocationFragment.access$getBinding(FormLocationFragment.this).tvViewCollectFormLocationProvince.getText();
                    Iterator it3 = FormLocationFragment.this.providerInfoList.iterator();
                    do {
                        if (!it3.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it3.next();
                    } while (!Intrinsics.areEqual(((AreaBean) next).getName(), text2));
                    AreaBean areaBean = (AreaBean) next;
                    FormLocationFragment.this.cityInfoList.clear();
                    List list2 = FormLocationFragment.this.cityInfoList;
                    if (areaBean == null || (listEmptyList2 = areaBean.getArea()) == null) {
                        listEmptyList2 = CollectionsKt.emptyList();
                    }
                    list2.addAll(listEmptyList2);
                }
                CharSequence text3 = FormLocationFragment.access$getBinding(FormLocationFragment.this).tvViewCollectFormLocationCity.getText();
                Intrinsics.checkNotNullExpressionValue(text3, "binding.tvViewCollectFormLocationCity.text");
                if (text3.length() > 0) {
                    CharSequence text4 = FormLocationFragment.access$getBinding(FormLocationFragment.this).tvViewCollectFormLocationCity.getText();
                    for (Object obj2 : FormLocationFragment.this.cityInfoList) {
                        if (Intrinsics.areEqual(((AreaItem) obj2).getName(), text4)) {
                            obj = obj2;
                            break;
                        }
                    }
                    AreaItem areaItem = (AreaItem) obj;
                    FormLocationFragment.this.areaInfoList.clear();
                    List list3 = FormLocationFragment.this.areaInfoList;
                    if (areaItem == null || (listEmptyList = areaItem.getArea()) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    list3.addAll(listEmptyList);
                }
            }
        };
        areaInfo.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormLocationFragment$JSSghHaVlKavj8OULp93M-hn2SQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FormLocationFragment.initView$lambda$9(function1, obj);
            }
        });
        LocationPopup locationPopup3 = this.selectPopup;
        if (locationPopup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPopup");
        } else {
            locationPopup = locationPopup3;
        }
        locationPopup.setCallBack(new StringListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormLocationFragment$ZL6MNCa0tGhihmPc2a7sajBpJZo
            @Override // com.yd.android_brand_mvp.listener.StringListener
            public final void getStringData(String str) {
                FormLocationFragment.initView$lambda$12(this.f$0, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$1(FormLocationFragment this$0, String it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it2, "it");
        int i = this$0.clickItem;
        if (i == 0) {
            ((ViewCollectFormLocationBinding) this$0.getBinding()).tvViewCollectFormLocationProvince.setText(it2);
        } else if (i == 1) {
            ((ViewCollectFormLocationBinding) this$0.getBinding()).tvViewCollectFormLocationCity.setText(it2);
        } else {
            if (i != 2) {
                return;
            }
            ((ViewCollectFormLocationBinding) this$0.getBinding()).tvViewCollectFormLocationArea.setText(it2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$3(FormLocationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clickItem = 0;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = this$0.providerInfoList.iterator();
        while (it2.hasNext()) {
            arrayList.add(((AreaBean) it2.next()).getName());
        }
        LocationPopup locationPopup = this$0.selectPopup;
        LocationPopup locationPopup2 = null;
        if (locationPopup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPopup");
            locationPopup = null;
        }
        locationPopup.setDataList(arrayList);
        LocationPopup locationPopup3 = this$0.selectPopup;
        if (locationPopup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPopup");
        } else {
            locationPopup2 = locationPopup3;
        }
        locationPopup2.showPopupWindow(((ViewCollectFormLocationBinding) this$0.getBinding()).clViewCollectFormLocationProvince);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$5(FormLocationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clickItem = 1;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = this$0.cityInfoList.iterator();
        while (it2.hasNext()) {
            arrayList.add(((AreaItem) it2.next()).getName());
        }
        LocationPopup locationPopup = this$0.selectPopup;
        LocationPopup locationPopup2 = null;
        if (locationPopup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPopup");
            locationPopup = null;
        }
        locationPopup.setDataList(arrayList);
        LocationPopup locationPopup3 = this$0.selectPopup;
        if (locationPopup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPopup");
        } else {
            locationPopup2 = locationPopup3;
        }
        locationPopup2.showPopupWindow(((ViewCollectFormLocationBinding) this$0.getBinding()).clViewCollectFormLocationCity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$8(FormLocationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clickItem = 2;
        ArrayList arrayList = new ArrayList();
        for (AreaItem areaItem : this$0.areaInfoList) {
            if (!Intrinsics.areEqual(areaItem.getName(), "市辖区")) {
                arrayList.add(areaItem.getName());
            } else {
                Iterator<T> it2 = areaItem.getArea().iterator();
                while (it2.hasNext()) {
                    arrayList.add(((AreaItem) it2.next()).getName());
                }
            }
        }
        LocationPopup locationPopup = this$0.selectPopup;
        LocationPopup locationPopup2 = null;
        if (locationPopup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPopup");
            locationPopup = null;
        }
        locationPopup.setDataList(arrayList);
        LocationPopup locationPopup3 = this$0.selectPopup;
        if (locationPopup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPopup");
        } else {
            locationPopup2 = locationPopup3;
        }
        locationPopup2.showPopupWindow(((ViewCollectFormLocationBinding) this$0.getBinding()).clViewCollectFormLocationArea);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$12(FormLocationFragment this$0, String it2) {
        List<AreaItem> listEmptyList;
        List<AreaItem> listEmptyList2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it2, "it");
        int i = this$0.clickItem;
        Object obj = null;
        if (i == 0) {
            for (Object obj2 : this$0.providerInfoList) {
                if (Intrinsics.areEqual(((AreaBean) obj2).getName(), it2)) {
                    obj = obj2;
                    break;
                }
            }
            AreaBean areaBean = (AreaBean) obj;
            this$0.cityInfoList.clear();
            List<AreaItem> list = this$0.cityInfoList;
            if (areaBean == null || (listEmptyList = areaBean.getArea()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            list.addAll(listEmptyList);
            ((ViewCollectFormLocationBinding) this$0.getBinding()).tvViewCollectFormLocationProvince.setText(it2);
            ((ViewCollectFormLocationBinding) this$0.getBinding()).tvViewCollectFormLocationCity.setText("");
            ((ViewCollectFormLocationBinding) this$0.getBinding()).tvViewCollectFormLocationArea.setText("");
            return;
        }
        if (i != 1) {
            if (i != 2) {
                return;
            }
            ((ViewCollectFormLocationBinding) this$0.getBinding()).tvViewCollectFormLocationArea.setText(it2);
            return;
        }
        for (Object obj3 : this$0.cityInfoList) {
            if (Intrinsics.areEqual(((AreaItem) obj3).getName(), it2)) {
                obj = obj3;
                break;
            }
        }
        AreaItem areaItem = (AreaItem) obj;
        this$0.areaInfoList.clear();
        List<AreaItem> list2 = this$0.areaInfoList;
        if (areaItem == null || (listEmptyList2 = areaItem.getArea()) == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        list2.addAll(listEmptyList2);
        ((ViewCollectFormLocationBinding) this$0.getBinding()).tvViewCollectFormLocationCity.setText(it2);
        ((ViewCollectFormLocationBinding) this$0.getBinding()).tvViewCollectFormLocationArea.setText("");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yd.android_brand_mvp.activity.collect.fragment.BaseCollectFragment
    public FormVerifyBean readySubmit() {
        FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
        FormBaseBean formBaseBean = this.formItemData;
        if (formBaseBean == null) {
            formVerifyBean.setStatus(false);
            formVerifyBean.setErrorMessage("数据为空");
            return formVerifyBean;
        }
        Intrinsics.checkNotNull(formBaseBean);
        if (formBaseBean.getProps().getRequired()) {
            CharSequence text = ((ViewCollectFormLocationBinding) getBinding()).tvViewCollectFormLocationProvince.getText();
            Intrinsics.checkNotNullExpressionValue(text, "binding.tvViewCollectFormLocationProvince.text");
            if (text.length() == 0) {
                CharSequence text2 = ((ViewCollectFormLocationBinding) getBinding()).tvViewCollectFormLocationCity.getText();
                Intrinsics.checkNotNullExpressionValue(text2, "binding.tvViewCollectFormLocationCity.text");
                if (text2.length() == 0) {
                    CharSequence text3 = ((ViewCollectFormLocationBinding) getBinding()).tvViewCollectFormLocationArea.getText();
                    Intrinsics.checkNotNullExpressionValue(text3, "binding.tvViewCollectFormLocationArea.text");
                    if (text3.length() == 0) {
                        formVerifyBean.setStatus(false);
                        formVerifyBean.setErrorMessage("定位必填项未填写");
                        return formVerifyBean;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) ((ViewCollectFormLocationBinding) getBinding()).tvViewCollectFormLocationProvince.getText());
        sb2.append(',');
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append((Object) ((ViewCollectFormLocationBinding) getBinding()).tvViewCollectFormLocationCity.getText());
        sb3.append(',');
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append((Object) ((ViewCollectFormLocationBinding) getBinding()).tvViewCollectFormLocationArea.getText());
        sb4.append(',');
        sb.append(sb4.toString());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "chainSb.toString()");
        String json = GsonUtils.toJson(new FormLocationBean(string, ((ViewCollectFormLocationBinding) getBinding()).etViewCollectFormLocationAddress.getText().toString(), null, null, 12, null));
        FormBaseBean formBaseBean2 = this.formItemData;
        Intrinsics.checkNotNull(formBaseBean2);
        formVerifyBean.setSort(formBaseBean2.getSort());
        formVerifyBean.setDataValue(json);
        return formVerifyBean;
    }
}
