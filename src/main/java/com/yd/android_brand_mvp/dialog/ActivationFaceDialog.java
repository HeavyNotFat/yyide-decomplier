package com.yd.android_brand_mvp.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.ActivationDialogBinding;
import com.yd.android_brand_mvp.landscape.setting.SettingViewModel;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.getRegistrationCodeRsp;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.utils.SDcarfile;
import com.yd.android_brand_mvp.utils.SpData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivationFaceDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\u001a\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/dialog/ActivationFaceDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lcom/yd/android_brand_mvp/databinding/ActivationDialogBinding;", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/ActivationDialogBinding;", "setBinding", "(Lcom/yd/android_brand_mvp/databinding/ActivationDialogBinding;)V", "logoInfo", "Lcom/yd/android_brand_mvp/model/NewBrandLoginRsp$DataBean;", "kotlin.jvm.PlatformType", "getLogoInfo", "()Lcom/yd/android_brand_mvp/model/NewBrandLoginRsp$DataBean;", "logoInfo$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/setting/SettingViewModel;", "initListener", "", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActivationFaceDialog extends DialogFragment {
    public ActivationDialogBinding binding;

    /* JADX INFO: renamed from: logoInfo$delegate, reason: from kotlin metadata */
    private final Lazy logoInfo = LazyKt.lazy(new Function0<NewBrandLoginRsp.DataBean>() { // from class: com.yd.android_brand_mvp.dialog.ActivationFaceDialog$logoInfo$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NewBrandLoginRsp.DataBean invoke() {
            return SpData.NewUser().data;
        }
    });
    private SettingViewModel viewModel;

    public final ActivationDialogBinding getBinding() {
        ActivationDialogBinding activationDialogBinding = this.binding;
        if (activationDialogBinding != null) {
            return activationDialogBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivationDialogBinding activationDialogBinding) {
        Intrinsics.checkNotNullParameter(activationDialogBinding, "<set-?>");
        this.binding = activationDialogBinding;
    }

    private final NewBrandLoginRsp.DataBean getLogoInfo() {
        return (NewBrandLoginRsp.DataBean) this.logoInfo.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ActivationDialogBinding activationDialogBindingInflate = ActivationDialogBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(activationDialogBindingInflate, "inflate(inflater, container, false)");
        setBinding(activationDialogBindingInflate);
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
            attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.4d);
            attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.33d);
            window.setAttributes(attributes);
        }
    }

    private final void initListener() {
        getBinding().getActivationCode.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$ActivationFaceDialog$C1lyaoHiw369wWBLgR-K34psoI0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivationFaceDialog.initListener$lambda$1(this.f$0, view);
            }
        });
        getBinding().btnDialogActivationSubmit.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$ActivationFaceDialog$MFMbG0fwh2BAYF1haf4iH7Paj3o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivationFaceDialog.initListener$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(ActivationFaceDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SettingViewModel settingViewModel = this$0.viewModel;
        if (settingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingViewModel = null;
        }
        String mac = BaseApplication.getInstance().getMac();
        Intrinsics.checkNotNullExpressionValue(mac, "getInstance().mac");
        String str = this$0.getLogoInfo().schoolId;
        Intrinsics.checkNotNullExpressionValue(str, "logoInfo.schoolId");
        settingViewModel.getActivationCode(mac, "2", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$2(ActivationFaceDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void initView() {
        SettingViewModel settingViewModel = (SettingViewModel) new ViewModelProvider(this).get(SettingViewModel.class);
        this.viewModel = settingViewModel;
        if (settingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingViewModel = null;
        }
        final Function1<Result<? extends getRegistrationCodeRsp.RegistrationCode>, Unit> function1 = new Function1<Result<? extends getRegistrationCodeRsp.RegistrationCode>, Unit>() { // from class: com.yd.android_brand_mvp.dialog.ActivationFaceDialog.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends getRegistrationCodeRsp.RegistrationCode> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends getRegistrationCodeRsp.RegistrationCode> it2) {
                String authorizeCode;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m597isFailureimpl(it2.getValue())) {
                    ActivationFaceDialog.this.getBinding().noActivationCode.setVisibility(0);
                }
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                ActivationFaceDialog activationFaceDialog = ActivationFaceDialog.this;
                getRegistrationCodeRsp.RegistrationCode registrationCode = (getRegistrationCodeRsp.RegistrationCode) value;
                if (registrationCode == null || (authorizeCode = registrationCode.authorizeCode) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(authorizeCode, "authorizeCode");
                SDcarfile.save(SDcarfile.FACE_CODE, authorizeCode);
                SDcarfile.save(SDcarfile.FACE_CODE_TYPE, registrationCode.type);
                activationFaceDialog.getBinding().activationEdittext.setText(registrationCode.authorizeCode);
                MinaEventManager.getInstance().notifyObserver(MinaConstants.FACE_ACTIVE);
            }
        };
        settingViewModel.getCodeResult().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$ActivationFaceDialog$bdoyGdw3NIdRjswUTZkqgFUm7AM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActivationFaceDialog.initView$lambda$3(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
