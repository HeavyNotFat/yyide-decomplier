package com.yd.android_brand_mvp.activity.collect.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.reflect.TypeToken;
import com.tencent.qcloud.tim.uikit.utils.FileUtil;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.collect.viewmodel.FormItemViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ItemFormImageBinding;
import com.yd.android_brand_mvp.databinding.ViewCollectFormImageBinding;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.UploadFileBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.collect.UpFileBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

/* JADX INFO: compiled from: FormImageFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000b\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u001a\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0016\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J\b\u0010%\u001a\u00020&H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormImageFragment;", "Lcom/yd/android_brand_mvp/activity/collect/fragment/BaseCollectFragment;", "Lcom/yd/android_brand_mvp/databinding/ViewCollectFormImageBinding;", "()V", "formItemData", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "imageActivityWithResult", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "imageAdapter", "com/yd/android_brand_mvp/activity/collect/fragment/FormImageFragment$imageAdapter$2$1", "getImageAdapter", "()Lcom/yd/android_brand_mvp/activity/collect/fragment/FormImageFragment$imageAdapter$2$1;", "imageAdapter$delegate", "Lkotlin/Lazy;", "imageList", "", "Lcom/yd/android_brand_mvp/model/UploadFileBean;", "limitImageCount", "", "viewModel", "Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormItemViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormItemViewModel;", "viewModel$delegate", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parseUriList", "uris", "", "Landroid/net/Uri;", "readySubmit", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormImageFragment extends BaseCollectFragment<ViewCollectFormImageBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FormBaseBean formItemData;
    private final ActivityResultLauncher<String> imageActivityWithResult;

    /* JADX INFO: renamed from: imageAdapter$delegate, reason: from kotlin metadata */
    private final Lazy imageAdapter;
    private final List<UploadFileBean> imageList;
    private final int limitImageCount;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.FormImageFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormImageFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ViewCollectFormImageBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ViewCollectFormImageBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ViewCollectFormImageBinding;", 0);
        }

        public final ViewCollectFormImageBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ViewCollectFormImageBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ViewCollectFormImageBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public FormImageFragment() {
        super(AnonymousClass1.INSTANCE);
        final FormImageFragment formImageFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormImageFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return formImageFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormImageFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(formImageFragment, Reflection.getOrCreateKotlinClass(FormItemViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormImageFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormImageFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormImageFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = formImageFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.limitImageCount = 10;
        this.imageAdapter = LazyKt.lazy(new Function0<FormImageFragment$imageAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormImageFragment$imageAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.collect.fragment.FormImageFragment$imageAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new BaseBindingAdapter<ItemFormImageBinding, UpFileBean>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormImageFragment$imageAdapter$2.1
                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, UpFileBean upFileBean) {
                        convertPlus2((VBViewHolder<ItemFormImageBinding>) vBViewHolder, upFileBean);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemFormImageBinding> holder, UpFileBean item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemFormImageBinding itemFormImageBinding = (ItemFormImageBinding) holder.getBinding();
                        if (itemFormImageBinding != null) {
                            if (item.getFilePath().length() == 0) {
                                itemFormImageBinding.ivItemFormImage.setImageResource(R.drawable.default_image_up);
                                ImageView imageView = itemFormImageBinding.ivItemFormImageDel;
                                Intrinsics.checkNotNullExpressionValue(imageView, "it.ivItemFormImageDel");
                                SimpleUtilsKt.remove(imageView);
                                return;
                            }
                            GlideUtil.loadImage(getContext(), item.getFilePath(), itemFormImageBinding.ivItemFormImage);
                            ImageView imageView2 = itemFormImageBinding.ivItemFormImageDel;
                            Intrinsics.checkNotNullExpressionValue(imageView2, "it.ivItemFormImageDel");
                            SimpleUtilsKt.show(imageView2);
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemFormImageBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemFormImageBinding itemFormImageBindingInflate = ItemFormImageBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemFormImageBindingInflate, "inflate(inflater, parent, false)");
                        return itemFormImageBindingInflate;
                    }
                };
            }
        });
        this.imageList = new ArrayList();
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.GetMultipleContents(), new ActivityResultCallback() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormImageFragment$80rsKNVkiqDAULGPNBtXkicCg7s
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) throws Throwable {
                FormImageFragment.imageActivityWithResult$lambda$0(this.f$0, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…arseUriList(it)\n        }");
        this.imageActivityWithResult = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: compiled from: FormImageFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormImageFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "dataBean", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(FormBaseBean dataBean) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            FormImageFragment formImageFragment = new FormImageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", GsonUtils.toJson(dataBean));
            formImageFragment.setArguments(bundle);
            return formImageFragment;
        }
    }

    private final FormItemViewModel getViewModel() {
        return (FormItemViewModel) this.viewModel.getValue();
    }

    private final FormImageFragment$imageAdapter$2.AnonymousClass1 getImageAdapter() {
        return (FormImageFragment$imageAdapter$2.AnonymousClass1) this.imageAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void imageActivityWithResult$lambda$0(FormImageFragment this$0, List it2) throws Throwable {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it2, "it");
        this$0.parseUriList(it2);
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
        boolean z = true;
        getImageAdapter().addChildClickViewIds(R.id.iv_item_form_image_del);
        ((ViewCollectFormImageBinding) getBinding()).rvViewCollectFormImage.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        ((ViewCollectFormImageBinding) getBinding()).rvViewCollectFormImage.setAdapter(getImageAdapter());
        getImageAdapter().addData(new UpFileBean(null, null, null, 7, null));
        FormBaseBean formBaseBean = this.formItemData;
        if (formBaseBean != null) {
            ((ViewCollectFormImageBinding) getBinding()).tvViewCollectFormImageName.setText(TransUtils.INSTANCE.transIntToString(formBaseBean.getSortNum()) + '.' + formBaseBean.getTitle());
            if (!formBaseBean.getProps().getRequired()) {
                TextView textView = ((ViewCollectFormImageBinding) getBinding()).tvViewCollectFormImageRequired;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvViewCollectFormImageRequired");
                SimpleUtilsKt.remove(textView);
            }
            String value = formBaseBean.getValue();
            if (value != null && value.length() != 0) {
                z = false;
            }
            if (!z) {
                List<UploadFileBean> valueList = (List) GsonUtils.fromJson(formBaseBean.getValue(), new TypeToken<List<? extends UploadFileBean>>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormImageFragment$initView$1$valueList$1
                }.getType());
                ArrayList arrayList = new ArrayList();
                Intrinsics.checkNotNullExpressionValue(valueList, "valueList");
                for (UploadFileBean uploadFileBean : valueList) {
                    String url = uploadFileBean.getUrl();
                    String name = uploadFileBean.getName();
                    arrayList.add(new UpFileBean(url, name, TransUtils.INSTANCE.getFileTypeByName(name)));
                }
                getImageAdapter().addData((Collection) arrayList);
            }
        }
        getImageAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormImageFragment$2yrCcLn71xy04Xnot4TY6GI6ZKY
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FormImageFragment.initView$lambda$3(baseQuickAdapter, view, i);
            }
        });
        getImageAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormImageFragment$g-OTNAMGE0bq-2RgH8ouX_-X3ko
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FormImageFragment.initView$lambda$4(this.f$0, baseQuickAdapter, view, i);
            }
        });
        LiveData<Result<List<UploadFileBean>>> uploadFile = getViewModel().getUploadFile();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends UploadFileBean>>, Unit> function1 = new Function1<Result<? extends List<? extends UploadFileBean>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormImageFragment.initView.4
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
                FormImageFragment.this.dismissProgressDialog();
                FormImageFragment.this.imageList.clear();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value2 = it2.getValue();
                if (Result.m597isFailureimpl(value2)) {
                    value2 = null;
                }
                List list = (List) value2;
                if (list == null) {
                    return;
                }
                List list2 = list;
                if (!list2.isEmpty()) {
                    FormImageFragment.this.imageList.addAll(list2);
                }
            }
        };
        uploadFile.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormImageFragment$ZFJizrg19crAE1blCNz3neaA4Nc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FormImageFragment.initView$lambda$5(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        adapter.removeAt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(FormImageFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (i == 0) {
            this$0.imageActivityWithResult.launch(TransUtils.MIME_IMAGE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void parseUriList(List<? extends Uri> uris) throws Throwable {
        ArrayList arrayList = new ArrayList();
        for (Uri uri : uris) {
            String filePath = FileUtil.getPathFromUri(uri);
            String fileName = FileUtil.getFileName(requireContext(), uri);
            TransUtils transUtils = TransUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
            String fileTypeByName = transUtils.getFileTypeByName(fileName);
            Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
            arrayList.add(new UpFileBean(filePath, fileName, fileTypeByName));
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            int size = this.limitImageCount - (getImageAdapter().getData().size() - 1);
            if (arrayList.size() >= size) {
                getImageAdapter().addData((Collection) arrayList.subList(0, size));
            } else {
                getImageAdapter().addData((Collection) arrayList2);
            }
            showProgressDialog();
            ArrayList arrayList3 = new ArrayList();
            for (UpFileBean upFileBean : getImageAdapter().getData()) {
                if (upFileBean.getFilePath().length() > 0) {
                    arrayList3.add(upFileBean.getFilePath());
                }
            }
            getViewModel().uploadFile(arrayList3);
        }
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
        if (formBaseBean.getProps().getRequired() && this.imageList.isEmpty()) {
            formVerifyBean.setStatus(false);
            formVerifyBean.setErrorMessage("图片必填项未选");
            return formVerifyBean;
        }
        FormBaseBean formBaseBean2 = this.formItemData;
        Intrinsics.checkNotNull(formBaseBean2);
        formVerifyBean.setSort(formBaseBean2.getSort());
        formVerifyBean.setDataValue(GsonUtils.toJson(this.imageList));
        return formVerifyBean;
    }
}
