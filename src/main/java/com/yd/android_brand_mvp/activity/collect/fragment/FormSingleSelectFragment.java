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
import com.yd.android_brand_mvp.activity.collect.viewmodel.FormItemViewModel;
import com.yd.android_brand_mvp.databinding.ViewCollectFormSingleSelectBinding;
import com.yd.android_brand_mvp.dialog.collect.SingleSelectPopup;
import com.yd.android_brand_mvp.listener.BaseSelectListener;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.collect.BaseArrayBean;
import com.yd.android_brand_mvp.model.collect.DeptListBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.utils.form.FormComponentUtil;
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

/* JADX INFO: compiled from: FormSingleSelectFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormSingleSelectFragment;", "Lcom/yd/android_brand_mvp/activity/collect/fragment/BaseCollectFragment;", "Lcom/yd/android_brand_mvp/databinding/ViewCollectFormSingleSelectBinding;", "()V", "formItemData", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "peopleId", "", "selectPopup", "Lcom/yd/android_brand_mvp/dialog/collect/SingleSelectPopup;", "typeStr", "viewModel", "Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormItemViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormItemViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "readySubmit", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormSingleSelectFragment extends BaseCollectFragment<ViewCollectFormSingleSelectBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FormBaseBean formItemData;
    private String peopleId;
    private SingleSelectPopup selectPopup;
    private String typeStr;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.FormSingleSelectFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormSingleSelectFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ViewCollectFormSingleSelectBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ViewCollectFormSingleSelectBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ViewCollectFormSingleSelectBinding;", 0);
        }

        public final ViewCollectFormSingleSelectBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ViewCollectFormSingleSelectBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ViewCollectFormSingleSelectBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ViewCollectFormSingleSelectBinding access$getBinding(FormSingleSelectFragment formSingleSelectFragment) {
        return (ViewCollectFormSingleSelectBinding) formSingleSelectFragment.getBinding();
    }

    public FormSingleSelectFragment() {
        super(AnonymousClass1.INSTANCE);
        final FormSingleSelectFragment formSingleSelectFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSingleSelectFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return formSingleSelectFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSingleSelectFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(formSingleSelectFragment, Reflection.getOrCreateKotlinClass(FormItemViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSingleSelectFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSingleSelectFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSingleSelectFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = formSingleSelectFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.peopleId = "";
        this.typeStr = "";
    }

    /* JADX INFO: compiled from: FormSingleSelectFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormSingleSelectFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "dataBean", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "typeStr", "", "peopleId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(FormBaseBean dataBean, String typeStr, String peopleId) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            Intrinsics.checkNotNullParameter(typeStr, "typeStr");
            Intrinsics.checkNotNullParameter(peopleId, "peopleId");
            FormSingleSelectFragment formSingleSelectFragment = new FormSingleSelectFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", GsonUtils.toJson(dataBean));
            bundle.putString("type", typeStr);
            bundle.putString("peopleId", peopleId);
            formSingleSelectFragment.setArguments(bundle);
            return formSingleSelectFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FormItemViewModel getViewModel() {
        return (FormItemViewModel) this.viewModel.getValue();
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
        SingleSelectPopup singleSelectPopup = null;
        this.formItemData = (FormBaseBean) GsonUtils.fromJson(arguments != null ? arguments.getString("data") : null, FormBaseBean.class);
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("type", "") : null;
        if (string == null) {
            string = "";
        }
        this.typeStr = string;
        Bundle arguments3 = getArguments();
        String string2 = arguments3 != null ? arguments3.getString("peopleId", "") : null;
        this.peopleId = string2 != null ? string2 : "";
        FormBaseBean formBaseBean = this.formItemData;
        if (formBaseBean != null) {
            ((ViewCollectFormSingleSelectBinding) getBinding()).tvViewCollectFormSelectName.setText(TransUtils.INSTANCE.transIntToString(formBaseBean.getSortNum()) + '.' + formBaseBean.getTitle());
            if (!formBaseBean.getProps().getRequired()) {
                TextView textView = ((ViewCollectFormSingleSelectBinding) getBinding()).tvViewCollectFormSelectRequired;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvViewCollectFormSelectRequired");
                SimpleUtilsKt.remove(textView);
            }
            String value = formBaseBean.getValue();
            if (!(value == null || value.length() == 0)) {
                FormComponentUtil formComponentUtil = FormComponentUtil.INSTANCE;
                String name = formBaseBean.getName();
                String value2 = formBaseBean.getValue();
                Intrinsics.checkNotNull(value2);
                ((ViewCollectFormSingleSelectBinding) getBinding()).tvViewCollectFormSelect.setText(formComponentUtil.parseDataValueToShowValue(name, value2));
            }
        }
        SingleSelectPopup singleSelectPopup2 = new SingleSelectPopup(this);
        this.selectPopup = singleSelectPopup2;
        if (singleSelectPopup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPopup");
        } else {
            singleSelectPopup = singleSelectPopup2;
        }
        singleSelectPopup.setCallBack(new BaseSelectListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormSingleSelectFragment$oQrKX6CV9uEgyEwRObhTstUgjGs
            @Override // com.yd.android_brand_mvp.listener.BaseSelectListener
            public final void onSelect(BaseArrayBean baseArrayBean) {
                FormSingleSelectFragment.initView$lambda$2(this.f$0, baseArrayBean);
            }
        });
        ((ViewCollectFormSingleSelectBinding) getBinding()).tvViewCollectFormSelect.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormSingleSelectFragment$caCEoj9QkBeV2Jx4CxWOyky5xkY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormSingleSelectFragment.initView$lambda$3(this.f$0, view);
            }
        });
        if (Intrinsics.areEqual(this.typeStr, FormComponentUtil.DeptPicker)) {
            showProgressDialog();
            String schoolId = SpData.getSchoolId();
            FormItemViewModel viewModel = getViewModel();
            Intrinsics.checkNotNullExpressionValue(schoolId, "schoolId");
            viewModel.getTeacherDeptList(schoolId, this.peopleId);
        }
        LiveData<Result<List<DeptListBean>>> deptList = getViewModel().getDeptList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends DeptListBean>>, Unit> function1 = new Function1<Result<? extends List<? extends DeptListBean>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSingleSelectFragment.initView.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends DeptListBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends DeptListBean>> it2) {
                FormSingleSelectFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value3 = it2.getValue();
                SingleSelectPopup singleSelectPopup3 = null;
                if (Result.m597isFailureimpl(value3)) {
                    value3 = null;
                }
                List<DeptListBean> list = (List) value3;
                List list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (DeptListBean deptListBean : list) {
                    arrayList.add(new BaseArrayBean(deptListBean.getDeptId(), deptListBean.getDeptName(), false, 4, null));
                }
                SingleSelectPopup singleSelectPopup4 = FormSingleSelectFragment.this.selectPopup;
                if (singleSelectPopup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectPopup");
                } else {
                    singleSelectPopup3 = singleSelectPopup4;
                }
                singleSelectPopup3.setDataList(arrayList);
                DeptListBean deptListBean2 = (DeptListBean) CollectionsKt.first(list);
                FormSingleSelectFragment.this.getViewModel().setSelectDeptData(new BaseArrayBean(deptListBean2.getDeptId(), deptListBean2.getDeptName(), false, 4, null));
                FormSingleSelectFragment.access$getBinding(FormSingleSelectFragment.this).tvViewCollectFormSelect.setText(FormSingleSelectFragment.this.getViewModel().getSelectDeptData().getName());
            }
        };
        deptList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormSingleSelectFragment$ojjY9SGYF4lKaR1OXXp2yU_jYbc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FormSingleSelectFragment.initView$lambda$4(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$2(FormSingleSelectFragment this$0, BaseArrayBean it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it2, "it");
        this$0.getViewModel().setSelectDeptData(it2);
        ((ViewCollectFormSingleSelectBinding) this$0.getBinding()).tvViewCollectFormSelect.setText(this$0.getViewModel().getSelectDeptData().getName());
        FormBaseBean formBaseBean = this$0.formItemData;
        if (formBaseBean == null || !formBaseBean.getProps().getRequired()) {
            return;
        }
        FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
        List<BaseArrayBean> listMutableListOf = CollectionsKt.mutableListOf(this$0.getViewModel().getSelectDeptData());
        String json = GsonUtils.toJson(listMutableListOf);
        formVerifyBean.setDataValueBean(listMutableListOf);
        formVerifyBean.setStatus(true);
        FormBaseBean formBaseBean2 = this$0.formItemData;
        Intrinsics.checkNotNull(formBaseBean2);
        formVerifyBean.setSort(formBaseBean2.getSort());
        formVerifyBean.setDataValue(json);
        EventBus.getDefault().post(formVerifyBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$3(FormSingleSelectFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SingleSelectPopup singleSelectPopup = this$0.selectPopup;
        SingleSelectPopup singleSelectPopup2 = null;
        if (singleSelectPopup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPopup");
            singleSelectPopup = null;
        }
        if (singleSelectPopup.isShowing()) {
            return;
        }
        SingleSelectPopup singleSelectPopup3 = this$0.selectPopup;
        if (singleSelectPopup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPopup");
        } else {
            singleSelectPopup2 = singleSelectPopup3;
        }
        singleSelectPopup2.showPopupWindow(((ViewCollectFormSingleSelectBinding) this$0.getBinding()).tvViewCollectFormSelect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yd.android_brand_mvp.activity.collect.fragment.BaseCollectFragment
    public FormVerifyBean readySubmit() {
        String json;
        FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
        FormBaseBean formBaseBean = this.formItemData;
        if (formBaseBean == null) {
            formVerifyBean.setStatus(false);
            formVerifyBean.setErrorMessage("数据为空");
            return formVerifyBean;
        }
        Intrinsics.checkNotNull(formBaseBean);
        if (formBaseBean.getProps().getRequired()) {
            CharSequence text = ((ViewCollectFormSingleSelectBinding) getBinding()).tvViewCollectFormSelect.getText();
            Intrinsics.checkNotNullExpressionValue(text, "binding.tvViewCollectFormSelect.text");
            if (text.length() == 0) {
                formVerifyBean.setStatus(false);
                formVerifyBean.setErrorMessage("必填项未填写");
                return formVerifyBean;
            }
        }
        if (Intrinsics.areEqual(this.typeStr, FormComponentUtil.DeptPicker)) {
            List<BaseArrayBean> listMutableListOf = CollectionsKt.mutableListOf(getViewModel().getSelectDeptData());
            json = GsonUtils.toJson(listMutableListOf);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(valuePostListBean)");
            formVerifyBean.setDataValueBean(listMutableListOf);
        } else {
            json = "";
        }
        formVerifyBean.setDataValue(json);
        FormBaseBean formBaseBean2 = this.formItemData;
        Intrinsics.checkNotNull(formBaseBean2);
        formVerifyBean.setSort(formBaseBean2.getSort());
        return formVerifyBean;
    }
}
