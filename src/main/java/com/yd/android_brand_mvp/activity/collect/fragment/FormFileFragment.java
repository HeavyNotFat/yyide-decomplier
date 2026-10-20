package com.yd.android_brand_mvp.activity.collect.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
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
import com.google.gson.reflect.TypeToken;
import com.tencent.qcloud.tim.uikit.utils.FileUtil;
import com.yd.android_brand_mvp.activity.collect.viewmodel.FormItemViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ItemFormFileBinding;
import com.yd.android_brand_mvp.databinding.ViewCollectFormFileBinding;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.UploadFileBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.collect.UpFileBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.ToastUtil;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: FormFileFragment.kt */
/* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\activity\collect\fragment\FormFileFragment.smali */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\t\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u001a\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0016\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J\b\u0010%\u001a\u00020&H\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormFileFragment;", "Lcom/yd/android_brand_mvp/activity/collect/fragment/BaseCollectFragment;", "Lcom/yd/android_brand_mvp/databinding/ViewCollectFormFileBinding;", "()V", "fileActivityWithResult", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "fileAdapter", "com/yd/android_brand_mvp/activity/collect/fragment/FormFileFragment$fileAdapter$2$1", "getFileAdapter", "()Lcom/yd/android_brand_mvp/activity/collect/fragment/FormFileFragment$fileAdapter$2$1;", "fileAdapter$delegate", "Lkotlin/Lazy;", "fileCount", "", "formItemData", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "uploadFileList", "", "Lcom/yd/android_brand_mvp/model/UploadFileBean;", "viewModel", "Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormItemViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormItemViewModel;", "viewModel$delegate", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parseUriList", "uris", "", "Landroid/net/Uri;", "readySubmit", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormFileFragment extends BaseCollectFragment<ViewCollectFormFileBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ActivityResultLauncher<String> fileActivityWithResult;

    /* JADX INFO: renamed from: fileAdapter$delegate, reason: from kotlin metadata */
    private final Lazy fileAdapter;
    private final int fileCount;
    private FormBaseBean formItemData;
    private final List<UploadFileBean> uploadFileList;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormFileFragment.kt */
    /* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\activity\collect\fragment\FormFileFragment$1.smali */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ViewCollectFormFileBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ViewCollectFormFileBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ViewCollectFormFileBinding;", 0);
        }

        public final ViewCollectFormFileBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(layoutInflater, "p0");
            return ViewCollectFormFileBinding.inflate(layoutInflater, viewGroup, z);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((LayoutInflater) obj, (ViewGroup) obj2, ((Boolean) obj3).booleanValue());
        }
    }

    public FormFileFragment() {
        super(AnonymousClass1.INSTANCE);
        this.fileCount = 10;
        final FormFileFragment formFileFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m58invoke() {
                return formFileFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelStoreOwner m59invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function1 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(formFileFragment, Reflection.getOrCreateKotlinClass(FormItemViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelStore m60invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.access$viewModels$lambda-1(lazy).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final CreationExtras m61invoke() {
                CreationExtras creationExtras;
                Function0 function2 = function1;
                if (function2 != null && (creationExtras = (CreationExtras) function2.invoke()) != null) {
                    return creationExtras;
                }
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory2 != null ? hasDefaultViewModelProviderFactory2.getDefaultViewModelCreationExtras() : null;
                return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelProvider.Factory m62invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                if (hasDefaultViewModelProviderFactory2 == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory2.getDefaultViewModelProviderFactory()) == null) {
                    defaultViewModelProviderFactory = formFileFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.uploadFileList = new ArrayList();
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.GetMultipleContents(), new ActivityResultCallback() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormFileFragment$BXJWj2fo0wzYn_b6RmrARHKkJxI
            public final void onActivityResult(Object obj) {
                FormFileFragment.fileActivityWithResult$lambda$0(this.f$0, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…arseUriList(it)\n        }");
        this.fileActivityWithResult = activityResultLauncherRegisterForActivityResult;
        this.fileAdapter = LazyKt.lazy(new Function0<FormFileFragment$fileAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$fileAdapter$2

            /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$fileAdapter$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: FormFileFragment.kt */
            /* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\activity\collect\fragment\FormFileFragment$fileAdapter$2$1.smali */
            @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u001e\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/yd/android_brand_mvp/activity/collect/fragment/FormFileFragment$fileAdapter$2$1", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemFormFileBinding;", "Lcom/yd/android_brand_mvp/model/collect/UpFileBean;", "convertPlus", "", "holder", "Lcom/yd/android_brand_mvp/base/VBViewHolder;", "item", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class AnonymousClass1 extends BaseBindingAdapter<ItemFormFileBinding, UpFileBean> {
                AnonymousClass1() {
                    super(null, 1, null);
                }

                @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, UpFileBean upFileBean) {
                    convertPlus2((VBViewHolder<ItemFormFileBinding>) vBViewHolder, upFileBean);
                }

                /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                public void convertPlus2(final VBViewHolder<ItemFormFileBinding> holder, UpFileBean item) {
                    Intrinsics.checkNotNullParameter(holder, "holder");
                    Intrinsics.checkNotNullParameter(item, "item");
                    ItemFormFileBinding itemFormFileBinding = (ItemFormFileBinding) holder.getBinding();
                    if (itemFormFileBinding != null) {
                        itemFormFileBinding.ivItemFormFile.setImageResource(TransUtils.INSTANCE.docStrToImageInt(item.getSuffix()));
                        itemFormFileBinding.tvItemFormFileName.setText(item.getName());
                        itemFormFileBinding.ivItemFormFileDel.setOnClickListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0033: INVOKE 
                              (wrap android.widget.ImageView:0x002c: IGET (r0v3 'itemFormFileBinding' com.yd.android_brand_mvp.databinding.ItemFormFileBinding) A[WRAPPED] (LINE:68) com.yd.android_brand_mvp.databinding.ItemFormFileBinding.ivItemFormFileDel android.widget.ImageView)
                              (wrap android.view.View$OnClickListener:0x0030: CONSTRUCTOR 
                              (r3v0 'this' com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$fileAdapter$2$1 A[DONT_INLINE, IMMUTABLE_TYPE, THIS])
                              (r4v0 'holder' com.yd.android_brand_mvp.base.VBViewHolder<com.yd.android_brand_mvp.databinding.ItemFormFileBinding> A[DONT_INLINE])
                             A[MD:(com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$fileAdapter$2$1, com.yd.android_brand_mvp.base.VBViewHolder):void (m), WRAPPED] call: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormFileFragment$fileAdapter$2$1$_KBf_yy0pqSwKBJaveAX7gMuCCI.<init>(com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$fileAdapter$2$1, com.yd.android_brand_mvp.base.VBViewHolder):void type: CONSTRUCTOR)
                             VIRTUAL call: android.widget.ImageView.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] (LINE:68) in method: com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$fileAdapter$2.1.convertPlus(com.yd.android_brand_mvp.base.VBViewHolder<com.yd.android_brand_mvp.databinding.ItemFormFileBinding>, com.yd.android_brand_mvp.model.collect.UpFileBean):void, file: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\activity\collect\fragment\FormFileFragment$fileAdapter$2$1.smali
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormFileFragment$fileAdapter$2$1$_KBf_yy0pqSwKBJaveAX7gMuCCI, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 23 more
                            */
                        /*
                            this = this;
                            java.lang.String r0 = "holder"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                            java.lang.String r0 = "item"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
                            com.yd.android_brand_mvp.databinding.ItemFormFileBinding r0 = (com.yd.android_brand_mvp.databinding.ItemFormFileBinding) r0
                            if (r0 == 0) goto L36
                            com.yd.android_brand_mvp.utils.TransUtils r1 = com.yd.android_brand_mvp.utils.TransUtils.INSTANCE
                            java.lang.String r2 = r5.getSuffix()
                            int r1 = r1.docStrToImageInt(r2)
                            android.widget.ImageView r2 = r0.ivItemFormFile
                            r2.setImageResource(r1)
                            android.widget.TextView r1 = r0.tvItemFormFileName
                            java.lang.String r5 = r5.getName()
                            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                            r1.setText(r5)
                            android.widget.ImageView r5 = r0.ivItemFormFileDel
                            com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormFileFragment$fileAdapter$2$1$_KBf_yy0pqSwKBJaveAX7gMuCCI r0 = new com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormFileFragment$fileAdapter$2$1$_KBf_yy0pqSwKBJaveAX7gMuCCI
                            r0.<init>(r3, r4)
                            r5.setOnClickListener(r0)
                        L36:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$fileAdapter$2.AnonymousClass1.convertPlus2(com.yd.android_brand_mvp.base.VBViewHolder, com.yd.android_brand_mvp.model.collect.UpFileBean):void");
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void convertPlus$lambda$1$lambda$0(AnonymousClass1 anonymousClass1, VBViewHolder vBViewHolder, View view) {
                        Intrinsics.checkNotNullParameter(anonymousClass1, "this$0");
                        Intrinsics.checkNotNullParameter(vBViewHolder, "$holder");
                        anonymousClass1.removeAt(vBViewHolder.getAdapterPosition());
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemFormFileBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemFormFileBinding itemFormFileBindingInflate = ItemFormFileBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemFormFileBindingInflate, "inflate(inflater, parent, false)");
                        return itemFormFileBindingInflate;
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final AnonymousClass1 m57invoke() {
                    return new AnonymousClass1();
                }
            });
        }

        /* JADX INFO: compiled from: FormFileFragment.kt */
        /* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\activity\collect\fragment\FormFileFragment$Companion.smali */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormFileFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "dataBean", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Fragment newInstance(FormBaseBean dataBean) {
                Intrinsics.checkNotNullParameter(dataBean, "dataBean");
                FormFileFragment formFileFragment = new FormFileFragment();
                Bundle bundle = new Bundle();
                bundle.putString("data", GsonUtils.toJson(dataBean));
                formFileFragment.setArguments(bundle);
                return formFileFragment;
            }
        }

        private final FormItemViewModel getViewModel() {
            return (FormItemViewModel) this.viewModel.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void fileActivityWithResult$lambda$0(FormFileFragment formFileFragment, List list) {
            Intrinsics.checkNotNullParameter(formFileFragment, "this$0");
            Intrinsics.checkNotNullExpressionValue(list, "it");
            formFileFragment.parseUriList(list);
        }

        private final FormFileFragment$fileAdapter$2.AnonymousClass1 getFileAdapter() {
            return (FormFileFragment$fileAdapter$2.AnonymousClass1) this.fileAdapter.getValue();
        }

        @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment
        public void onViewCreated(View view, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onViewCreated(view, savedInstanceState);
            initView();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v16, types: [com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$initView$1$valueList$1] */
        private final void initView() {
            Bundle arguments = getArguments();
            this.formItemData = (FormBaseBean) GsonUtils.fromJson(arguments != null ? arguments.getString("data") : null, FormBaseBean.class);
            ((ViewCollectFormFileBinding) getBinding()).rvViewCollectFormFile.setLayoutManager(new LinearLayoutManager(requireContext()));
            ((ViewCollectFormFileBinding) getBinding()).rvViewCollectFormFile.setAdapter(getFileAdapter());
            FormBaseBean formBaseBean = this.formItemData;
            if (formBaseBean != null) {
                ((ViewCollectFormFileBinding) getBinding()).tvViewCollectFormFileName.setText(TransUtils.INSTANCE.transIntToString(formBaseBean.getSortNum()) + '.' + formBaseBean.getTitle());
                if (!formBaseBean.getProps().getRequired()) {
                    TextView textView = ((ViewCollectFormFileBinding) getBinding()).tvViewCollectFormFileRequired;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.tvViewCollectFormFileRequired");
                    SimpleUtilsKt.remove(textView);
                }
                String value = formBaseBean.getValue();
                if (!(value == null || value.length() == 0)) {
                    List<UploadFileBean> list = (List) GsonUtils.fromJson(formBaseBean.getValue(), new TypeToken<List<? extends UploadFileBean>>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment$initView$1$valueList$1
                    }.getType());
                    ArrayList arrayList = new ArrayList();
                    Intrinsics.checkNotNullExpressionValue(list, "valueList");
                    for (UploadFileBean uploadFileBean : list) {
                        String url = uploadFileBean.getUrl();
                        String name = uploadFileBean.getName();
                        arrayList.add(new UpFileBean(url, name, TransUtils.INSTANCE.getFileTypeByName(name)));
                    }
                    getFileAdapter().setList(arrayList);
                }
            }
            ((ViewCollectFormFileBinding) getBinding()).clViewCollectForFileUp.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormFileFragment$q7peV0BwtyhD0QcIxe8FWNtj2y8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FormFileFragment.initView$lambda$3(this.f$0, view);
                }
            });
            LiveData<Result<List<UploadFileBean>>> uploadFile = getViewModel().getUploadFile();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<Result<? extends List<? extends UploadFileBean>>, Unit> function1 = new Function1<Result<? extends List<? extends UploadFileBean>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormFileFragment.initView.3
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Result<? extends List<? extends UploadFileBean>>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Result<? extends List<? extends UploadFileBean>> result) {
                    FormFileFragment.this.dismissProgressDialog();
                    FormFileFragment.this.uploadFileList.clear();
                    Intrinsics.checkNotNullExpressionValue(result, "it");
                    Object obj = result.unbox-impl();
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    List list2 = (List) obj;
                    if (list2 == null) {
                        return;
                    }
                    List list3 = list2;
                    if (!list3.isEmpty()) {
                        FormFileFragment.this.uploadFileList.addAll(list3);
                    }
                }
            };
            uploadFile.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormFileFragment$YiHcp4y7UKYyQL7wB_JN1QLk-hM
                public final void onChanged(Object obj) {
                    FormFileFragment.initView$lambda$4(function1, obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initView$lambda$3(FormFileFragment formFileFragment, View view) {
            Intrinsics.checkNotNullParameter(formFileFragment, "this$0");
            formFileFragment.fileActivityWithResult.launch(TransUtils.MIME_ALL);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initView$lambda$4(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "$tmp0");
            function1.invoke(obj);
        }

        private final void parseUriList(List<? extends Uri> uris) {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            for (Uri uri : uris) {
                String pathFromUri = FileUtil.getPathFromUri(uri);
                String fileName = FileUtil.getFileName(requireContext(), uri);
                if (FileUtil.getFileOrFilesSize(pathFromUri, 3) > 20.0d) {
                    sb.append(fileName);
                    sb.append(",");
                } else {
                    TransUtils transUtils = TransUtils.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
                    String fileTypeByName = transUtils.getFileTypeByName(fileName);
                    Intrinsics.checkNotNullExpressionValue(pathFromUri, "filePath");
                    arrayList.add(new UpFileBean(pathFromUri, fileName, fileTypeByName));
                }
            }
            if (sb.length() > 0) {
                ToastUtil.showBottomView(requireContext(), ((Object) sb) + "文件超过限制");
            }
            ArrayList arrayList2 = arrayList;
            if (!arrayList2.isEmpty()) {
                int size = this.fileCount - getFileAdapter().getData().size();
                if (arrayList.size() >= size) {
                    getFileAdapter().addData(arrayList.subList(0, size));
                } else {
                    getFileAdapter().addData(arrayList2);
                }
                showProgressDialog();
                ArrayList arrayList3 = new ArrayList();
                Iterator it = getFileAdapter().getData().iterator();
                while (it.hasNext()) {
                    arrayList3.add(((UpFileBean) it.next()).getFilePath());
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
            if (formBaseBean.getProps().getRequired() && this.uploadFileList.isEmpty()) {
                formVerifyBean.setStatus(false);
                formVerifyBean.setErrorMessage("文件必填项未选");
                return formVerifyBean;
            }
            FormBaseBean formBaseBean2 = this.formItemData;
            Intrinsics.checkNotNull(formBaseBean2);
            formVerifyBean.setSort(formBaseBean2.getSort());
            formVerifyBean.setDataValue(GsonUtils.toJson(this.uploadFileList));
            return formVerifyBean;
        }
    }
