package com.yd.android_brand_mvp;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.blankj.utilcode.util.SPUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.yd.android_brand_mvp.base.KTBaseActivity;
import com.yd.android_brand_mvp.databinding.ActivitySkyworthLoginBinding;
import com.yd.android_brand_mvp.utils.SpData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SkyworthLoginActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/SkyworthLoginActivity;", "Lcom/yd/android_brand_mvp/base/KTBaseActivity;", "Lcom/yd/android_brand_mvp/databinding/ActivitySkyworthLoginBinding;", "()V", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "", "initView", FirebaseAnalytics.Event.LOGIN, MiPushClient.COMMAND_REGISTER, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SkyworthLoginActivity extends KTBaseActivity<ActivitySkyworthLoginBinding> {

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.SkyworthLoginActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: SkyworthLoginActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<LayoutInflater, ActivitySkyworthLoginBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, ActivitySkyworthLoginBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/yd/android_brand_mvp/databinding/ActivitySkyworthLoginBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ActivitySkyworthLoginBinding invoke(LayoutInflater p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivitySkyworthLoginBinding.inflate(p0);
        }
    }

    public SkyworthLoginActivity() {
        super(AnonymousClass1.INSTANCE);
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseActivity
    protected void initView() {
        super.initView();
        getBinding().btnLogin.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$SkyworthLoginActivity$LjuUvegyPW5Y0dBpkl888HbG-4E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SkyworthLoginActivity.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().btnActive.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$SkyworthLoginActivity$ElMpsVgFgJgQWJSzKM0zP0snTJk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SkyworthLoginActivity.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().btnActive.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$SkyworthLoginActivity$KNAr0tWp5EeZcXiifV0_9Gf8iak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SkyworthLoginActivity.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().btnSkip.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$SkyworthLoginActivity$-tFwcho6P2WnzaoIWcNnmjseuQE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SkyworthLoginActivity.initView$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SkyworthLoginActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.login();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(SkyworthLoginActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.register();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(SkyworthLoginActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.active();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(SkyworthLoginActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SPUtils.getInstance().put(SpData.isFaceEnable, false);
        this$0.startActivity(new Intent(this$0.mActivity, (Class<?>) MainActivity.class));
        this$0.finish();
    }

    private final void login() {
        String string = StringsKt.trim((CharSequence) String.valueOf(getBinding().user.getText())).toString();
        String string2 = StringsKt.trim((CharSequence) String.valueOf(getBinding().pwd.getText())).toString();
        if (TextUtils.isEmpty(string)) {
            getBinding().error.setText("请输入帐号");
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            getBinding().error.setText("请输入密码");
            return;
        }
        getBinding().error.setText("");
        getBinding().clLogin.setVisibility(4);
        getBinding().clRegister.setVisibility(0);
        loading();
    }

    private final void register() {
        if (TextUtils.isEmpty(StringsKt.trim((CharSequence) String.valueOf(getBinding().register.getText())).toString())) {
            getBinding().registerError.setText("请输入激活码");
            return;
        }
        getBinding().registerError.setText("");
        getBinding().clRegister.setVisibility(4);
        getBinding().clActive.setVisibility(0);
        loading();
    }

    private final void active() {
        if (TextUtils.isEmpty(StringsKt.trim((CharSequence) String.valueOf(getBinding().active.getText())).toString())) {
            getBinding().activeError.setText("请输入激活码");
        } else {
            getBinding().activeError.setText("");
            loading();
        }
    }
}
