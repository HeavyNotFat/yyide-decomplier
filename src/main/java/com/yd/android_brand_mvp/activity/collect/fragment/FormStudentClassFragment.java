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
import com.yd.android_brand_mvp.activity.collect.viewmodel.FormStudentViewModel;
import com.yd.android_brand_mvp.databinding.FragmentFormStudentClassesBinding;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.collect.BaseArrayBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.collect.StudentClassesBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.utils.form.FormComponentUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
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

/* JADX INFO: compiled from: FormStudentClassFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormStudentClassFragment;", "Lcom/yd/android_brand_mvp/activity/collect/fragment/BaseCollectFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentFormStudentClassesBinding;", "()V", "formItemData", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "mStudentClassesBean", "Lcom/yd/android_brand_mvp/model/collect/StudentClassesBean;", "viewMode", "Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormStudentViewModel;", "getViewMode", "()Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormStudentViewModel;", "viewMode$delegate", "Lkotlin/Lazy;", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "readySubmit", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormStudentClassFragment extends BaseCollectFragment<FragmentFormStudentClassesBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FormBaseBean formItemData;
    private StudentClassesBean mStudentClassesBean;

    /* JADX INFO: renamed from: viewMode$delegate, reason: from kotlin metadata */
    private final Lazy viewMode;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.FormStudentClassFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormStudentClassFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentFormStudentClassesBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentFormStudentClassesBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentFormStudentClassesBinding;", 0);
        }

        public final FragmentFormStudentClassesBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentFormStudentClassesBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentFormStudentClassesBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public FormStudentClassFragment() {
        super(AnonymousClass1.INSTANCE);
        final FormStudentClassFragment formStudentClassFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormStudentClassFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return formStudentClassFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormStudentClassFragment$special$$inlined$viewModels$default$2
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
        this.viewMode = FragmentViewModelLazyKt.createViewModelLazy(formStudentClassFragment, Reflection.getOrCreateKotlinClass(FormStudentViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormStudentClassFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormStudentClassFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormStudentClassFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = formStudentClassFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentFormStudentClassesBinding access$getBinding(FormStudentClassFragment formStudentClassFragment) {
        return (FragmentFormStudentClassesBinding) formStudentClassFragment.getBinding();
    }

    /* JADX INFO: compiled from: FormStudentClassFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormStudentClassFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "dataBean", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "id", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(FormBaseBean dataBean, String id) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            Intrinsics.checkNotNullParameter(id, "id");
            FormStudentClassFragment formStudentClassFragment = new FormStudentClassFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", GsonUtils.toJson(dataBean));
            bundle.putString("id", id);
            formStudentClassFragment.setArguments(bundle);
            return formStudentClassFragment;
        }
    }

    private final FormStudentViewModel getViewMode() {
        return (FormStudentViewModel) this.viewMode.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        String string;
        Bundle arguments = getArguments();
        this.formItemData = (FormBaseBean) GsonUtils.fromJson(arguments != null ? arguments.getString("data") : null, FormBaseBean.class);
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string = arguments2.getString("id")) == null) {
            string = "-1";
        }
        FormBaseBean formBaseBean = this.formItemData;
        if (formBaseBean != null) {
            ((FragmentFormStudentClassesBinding) getBinding()).tvStudentClassesTitle.setText(TransUtils.INSTANCE.transIntToString(formBaseBean.getSortNum()) + '.' + formBaseBean.getTitle());
            if (!formBaseBean.getProps().getRequired()) {
                TextView textView = ((FragmentFormStudentClassesBinding) getBinding()).tvViewCollectFormDateRequired;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvViewCollectFormDateRequired");
                SimpleUtilsKt.remove(textView);
            }
            String value = formBaseBean.getValue();
            if (!(value == null || value.length() == 0)) {
                FormComponentUtil formComponentUtil = FormComponentUtil.INSTANCE;
                String name = formBaseBean.getName();
                String value2 = formBaseBean.getValue();
                Intrinsics.checkNotNull(value2);
                ((FragmentFormStudentClassesBinding) getBinding()).tvStudentClassesValue.setText(formComponentUtil.parseDataValueToShowValue(name, value2));
            }
        }
        LiveData<Result<StudentClassesBean>> studentClasses = getViewMode().getStudentClasses();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends StudentClassesBean>, Unit> function1 = new Function1<Result<? extends StudentClassesBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormStudentClassFragment.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends StudentClassesBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends StudentClassesBean> it2) {
                String name2;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    FormStudentClassFragment formStudentClassFragment = FormStudentClassFragment.this;
                    Object value3 = it2.getValue();
                    if (Result.m597isFailureimpl(value3)) {
                        value3 = null;
                    }
                    formStudentClassFragment.mStudentClassesBean = (StudentClassesBean) value3;
                    TextView textView2 = FormStudentClassFragment.access$getBinding(FormStudentClassFragment.this).tvStudentClassesValue;
                    StudentClassesBean studentClassesBean = FormStudentClassFragment.this.mStudentClassesBean;
                    if (studentClassesBean == null || (name2 = studentClassesBean.getName()) == null) {
                        name2 = "";
                    }
                    textView2.setText(name2);
                }
            }
        };
        studentClasses.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormStudentClassFragment$EdwbRFSZrje4pmpYa6J69TmI45A
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FormStudentClassFragment.initView$lambda$1(function1, obj);
            }
        });
        getViewMode().getStudentClasses(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.yd.android_brand_mvp.activity.collect.fragment.BaseCollectFragment
    public FormVerifyBean readySubmit() {
        FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
        if (this.formItemData == null) {
            formVerifyBean.setStatus(false);
            formVerifyBean.setErrorMessage("数据为空");
            return formVerifyBean;
        }
        ArrayList arrayList = new ArrayList();
        StudentClassesBean studentClassesBean = this.mStudentClassesBean;
        if (studentClassesBean != null) {
            arrayList.add(new BaseArrayBean(studentClassesBean.getId(), studentClassesBean.getName(), true));
        }
        String json = GsonUtils.toJson(arrayList);
        formVerifyBean.setDataValueBean(arrayList);
        FormBaseBean formBaseBean = this.formItemData;
        Intrinsics.checkNotNull(formBaseBean);
        formVerifyBean.setSort(formBaseBean.getSort());
        formVerifyBean.setDataValue(json);
        return formVerifyBean;
    }
}
