package com.yd.android_brand_mvp.activity.collect.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
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
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.activity.collect.viewmodel.FormItemViewModel;
import com.yd.android_brand_mvp.databinding.ViewCollectFormSignBinding;
import com.yd.android_brand_mvp.dialog.collect.SignatureDialog;
import com.yd.android_brand_mvp.listener.BitmapListener;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.UploadFileBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
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

/* JADX INFO: compiled from: FormSignPadFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormSignPadFragment;", "Lcom/yd/android_brand_mvp/activity/collect/fragment/BaseCollectFragment;", "Lcom/yd/android_brand_mvp/databinding/ViewCollectFormSignBinding;", "()V", "formItemData", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "uploadFileUrl", "Lcom/yd/android_brand_mvp/model/UploadFileBean;", "viewModel", "Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormItemViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormItemViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "readySubmit", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormSignPadFragment extends BaseCollectFragment<ViewCollectFormSignBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FormBaseBean formItemData;
    private UploadFileBean uploadFileUrl;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.FormSignPadFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormSignPadFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ViewCollectFormSignBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ViewCollectFormSignBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ViewCollectFormSignBinding;", 0);
        }

        public final ViewCollectFormSignBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ViewCollectFormSignBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ViewCollectFormSignBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public FormSignPadFragment() {
        super(AnonymousClass1.INSTANCE);
        final FormSignPadFragment formSignPadFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSignPadFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return formSignPadFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSignPadFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(formSignPadFragment, Reflection.getOrCreateKotlinClass(FormItemViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSignPadFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSignPadFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSignPadFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = formSignPadFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ViewCollectFormSignBinding access$getBinding(FormSignPadFragment formSignPadFragment) {
        return (ViewCollectFormSignBinding) formSignPadFragment.getBinding();
    }

    /* JADX INFO: compiled from: FormSignPadFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormSignPadFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "dataBean", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(FormBaseBean dataBean) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            FormSignPadFragment formSignPadFragment = new FormSignPadFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", GsonUtils.toJson(dataBean));
            formSignPadFragment.setArguments(bundle);
            return formSignPadFragment;
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
        FormBaseBean formBaseBean = (FormBaseBean) GsonUtils.fromJson(arguments != null ? arguments.getString("data") : null, FormBaseBean.class);
        this.formItemData = formBaseBean;
        if (formBaseBean != null) {
            ((ViewCollectFormSignBinding) getBinding()).tvViewCollectFormSignName.setText(TransUtils.INSTANCE.transIntToString(formBaseBean.getSortNum()) + '.' + formBaseBean.getTitle());
            if (!formBaseBean.getProps().getRequired()) {
                TextView textView = ((ViewCollectFormSignBinding) getBinding()).tvViewCollectFormSignRequired;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvViewCollectFormSignRequired");
                SimpleUtilsKt.remove(textView);
            }
            String value = formBaseBean.getValue();
            if (!(value == null || value.length() == 0)) {
                UploadFileBean uploadFileBean = (UploadFileBean) GsonUtils.fromJson(formBaseBean.getValue(), UploadFileBean.class);
                this.uploadFileUrl = uploadFileBean;
                GlideUtil.loadImageCenterInsideType(requireContext(), uploadFileBean.getUrl(), ((ViewCollectFormSignBinding) getBinding()).ivViewCollectFormSign);
                ConstraintLayout constraintLayout = ((ViewCollectFormSignBinding) getBinding()).clViewCollectFormSign;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clViewCollectFormSign");
                SimpleUtilsKt.remove(constraintLayout);
                Group group = ((ViewCollectFormSignBinding) getBinding()).groupViewCollectFormSign;
                Intrinsics.checkNotNullExpressionValue(group, "binding.groupViewCollectFormSign");
                SimpleUtilsKt.show(group);
            }
        }
        ((ViewCollectFormSignBinding) getBinding()).clViewCollectFormSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormSignPadFragment$BzgYyEio8zB2ZEY6C3Ha2vmRkEs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormSignPadFragment.initView$lambda$1(this.f$0, view);
            }
        });
        ((ViewCollectFormSignBinding) getBinding()).ivViewCollectFormSignDelete.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormSignPadFragment$UNZUWfZGpakTdSgRiWuRCHXMnkI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormSignPadFragment.initView$lambda$2(this.f$0, view);
            }
        });
        LiveData<Result<List<UploadFileBean>>> uploadBitmapFile = getViewModel().getUploadBitmapFile();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends UploadFileBean>>, Unit> function1 = new Function1<Result<? extends List<? extends UploadFileBean>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSignPadFragment.initView.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends UploadFileBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends UploadFileBean>> it2) {
                FormSignPadFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value2 = it2.getValue();
                if (Result.m597isFailureimpl(value2)) {
                    value2 = null;
                }
                List list = (List) value2;
                if (list == null) {
                    FormSignPadFragment.this.uploadFileUrl = null;
                } else if (!list.isEmpty()) {
                    FormSignPadFragment.this.uploadFileUrl = (UploadFileBean) CollectionsKt.first(list);
                }
            }
        };
        uploadBitmapFile.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormSignPadFragment$lE9fbKgC1Wq0KDbznKDhY1-ClwE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FormSignPadFragment.initView$lambda$3(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(final FormSignPadFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SignatureDialog signatureDialog = new SignatureDialog(ScreenUtils.isPortrait());
        signatureDialog.setListener(new BitmapListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormSignPadFragment$initView$2$1
            @Override // com.yd.android_brand_mvp.listener.BitmapListener
            public void getBitmapData(Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                ConstraintLayout constraintLayout = FormSignPadFragment.access$getBinding(this.this$0).clViewCollectFormSign;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clViewCollectFormSign");
                SimpleUtilsKt.remove(constraintLayout);
                Group group = FormSignPadFragment.access$getBinding(this.this$0).groupViewCollectFormSign;
                Intrinsics.checkNotNullExpressionValue(group, "binding.groupViewCollectFormSign");
                SimpleUtilsKt.show(group);
                FormSignPadFragment.access$getBinding(this.this$0).ivViewCollectFormSign.setImageBitmap(bitmap);
                this.this$0.showProgressDialog();
                this.this$0.getViewModel().uploadFile(bitmap);
            }
        });
        signatureDialog.show(this$0.getChildFragmentManager(), "signDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$2(FormSignPadFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Group group = ((ViewCollectFormSignBinding) this$0.getBinding()).groupViewCollectFormSign;
        Intrinsics.checkNotNullExpressionValue(group, "binding.groupViewCollectFormSign");
        SimpleUtilsKt.remove(group);
        ConstraintLayout constraintLayout = ((ViewCollectFormSignBinding) this$0.getBinding()).clViewCollectFormSign;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clViewCollectFormSign");
        SimpleUtilsKt.show(constraintLayout);
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
            formVerifyBean.setStatus(false);
            formVerifyBean.setErrorMessage("数据为空");
            return formVerifyBean;
        }
        Intrinsics.checkNotNull(formBaseBean);
        if (formBaseBean.getProps().getRequired() && this.uploadFileUrl == null) {
            formVerifyBean.setStatus(false);
            formVerifyBean.setErrorMessage("签名板必填项未填写");
            return formVerifyBean;
        }
        if (this.uploadFileUrl != null) {
            FormBaseBean formBaseBean2 = this.formItemData;
            Intrinsics.checkNotNull(formBaseBean2);
            formVerifyBean.setSort(formBaseBean2.getSort());
            formVerifyBean.setDataValue(GsonUtils.toJson(this.uploadFileUrl));
        }
        return formVerifyBean;
    }
}
