package com.yd.android_brand_mvp.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.databinding.DialogLayoutConsultDetailsBinding;
import com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel;
import com.yd.android_brand_mvp.model.consult.ConsultLabelBean;
import com.yd.android_brand_mvp.model.consult.ConsultTeacherBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ConsultDetailsDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/ConsultDetailsDialog;", "Landroidx/fragment/app/DialogFragment;", "userId", "", "(Ljava/lang/String;)V", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogLayoutConsultDetailsBinding;", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/DialogLayoutConsultDetailsBinding;", "setBinding", "(Lcom/yd/android_brand_mvp/databinding/DialogLayoutConsultDetailsBinding;)V", "cb", "Lcom/yd/android_brand_mvp/dialog/ConsultDetailsDialog$CallBack;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/reserve/viemodel/HomeReservationViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/reserve/viemodel/HomeReservationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initListener", "", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "setCallBack", "callBack", "CallBack", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConsultDetailsDialog extends DialogFragment {
    public DialogLayoutConsultDetailsBinding binding;
    private CallBack cb;
    private String userId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: ConsultDetailsDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/ConsultDetailsDialog$CallBack;", "", "clickSubmit", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void clickSubmit();
    }

    private final void initListener() {
    }

    public final DialogLayoutConsultDetailsBinding getBinding() {
        DialogLayoutConsultDetailsBinding dialogLayoutConsultDetailsBinding = this.binding;
        if (dialogLayoutConsultDetailsBinding != null) {
            return dialogLayoutConsultDetailsBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogLayoutConsultDetailsBinding dialogLayoutConsultDetailsBinding) {
        Intrinsics.checkNotNullParameter(dialogLayoutConsultDetailsBinding, "<set-?>");
        this.binding = dialogLayoutConsultDetailsBinding;
    }

    private final HomeReservationViewModel getViewModel() {
        return (HomeReservationViewModel) this.viewModel.getValue();
    }

    public ConsultDetailsDialog(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        final ConsultDetailsDialog consultDetailsDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.dialog.ConsultDetailsDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return consultDetailsDialog;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.dialog.ConsultDetailsDialog$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(consultDetailsDialog, Reflection.getOrCreateKotlinClass(HomeReservationViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.dialog.ConsultDetailsDialog$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.dialog.ConsultDetailsDialog$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.dialog.ConsultDetailsDialog$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = consultDetailsDialog.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.userId = userId;
    }

    public final void setCallBack(CallBack callBack) {
        this.cb = callBack;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogLayoutConsultDetailsBinding dialogLayoutConsultDetailsBindingInflate = DialogLayoutConsultDetailsBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogLayoutConsultDetailsBindingInflate, "inflate(inflater, container, false)");
        setBinding(dialogLayoutConsultDetailsBindingInflate);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }

    private final void initView() {
        getBinding().ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$ConsultDetailsDialog$7y1EBETH5qNYaF52RCNlvly4eOA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConsultDetailsDialog.initView$lambda$0(this.f$0, view);
            }
        });
        final Function1<Result<? extends ConsultTeacherBean>, Unit> function1 = new Function1<Result<? extends ConsultTeacherBean>, Unit>() { // from class: com.yd.android_brand_mvp.dialog.ConsultDetailsDialog.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends ConsultTeacherBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends ConsultTeacherBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    ConsultTeacherBean consultTeacherBean = (ConsultTeacherBean) value;
                    if (consultTeacherBean != null) {
                        ConsultDetailsDialog consultDetailsDialog = ConsultDetailsDialog.this;
                        consultDetailsDialog.getBinding().tvHeadName.setText(consultTeacherBean.getName());
                        if (!TextUtils.isEmpty(consultTeacherBean.getAvatar())) {
                            TextView textView = consultDetailsDialog.getBinding().tvHeadTitle;
                            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvHeadTitle");
                            SimpleUtilsKt.remove(textView);
                            GlideUtil.loadCircleImage(consultDetailsDialog.getContext(), consultTeacherBean.getAvatar(), consultDetailsDialog.getBinding().ivHead);
                        } else {
                            consultDetailsDialog.getBinding().tvHeadTitle.setText(consultTeacherBean.getName());
                        }
                        List<ConsultLabelBean> labelList = consultTeacherBean.getLabelList();
                        if (labelList == null || labelList.isEmpty()) {
                            return;
                        }
                        ConsultLabelBean consultLabelBean = (ConsultLabelBean) CollectionsKt.first((List) consultTeacherBean.getLabelList());
                        consultDetailsDialog.getBinding().tvIntro.setText(consultLabelBean.getBriefIntroduction());
                        consultDetailsDialog.getBinding().tvSendWord.setText(consultLabelBean.getSendWord());
                    }
                }
            }
        };
        getViewModel().getConsultDetails().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$ConsultDetailsDialog$xqur3J9Ofq8BAZqxhoX5vziepXQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ConsultDetailsDialog.initView$lambda$1(function1, obj);
            }
        });
        String str = this.userId;
        if (str != null) {
            getViewModel().getConsultTeacherDetails(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ConsultDetailsDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        Dialog dialog2 = getDialog();
        Window window = dialog2 != null ? dialog2.getWindow() : null;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkNotNullExpressionValue(attributes, "it.attributes");
            Display defaultDisplay = window.getWindowManager().getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "it.windowManager.defaultDisplay");
            if (ScreenUtils.isLandscape()) {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.4d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.6d);
            } else {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.7d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.4d);
            }
            window.setAttributes(attributes);
        }
    }
}
