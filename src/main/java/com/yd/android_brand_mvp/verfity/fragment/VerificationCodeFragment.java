package com.yd.android_brand_mvp.verfity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.huawei.hms.api.ConnectionResult;
import com.tencent.qcloud.tim.uikit.utils.SoftKeyBoardUtil;
import com.yd.android_brand_mvp.SettingActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentVerificationCodeBinding;
import com.yd.android_brand_mvp.portrait.activity.SettingPActivity;
import com.yd.android_brand_mvp.utils.DesCipherUtils;
import com.yd.android_brand_mvp.utils.QRCodeUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.verfity.RestoreVerificationRouter;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yyide.facepass.AppExtKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: VerificationCodeFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0005\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yd/android_brand_mvp/verfity/fragment/VerificationCodeFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentVerificationCodeBinding;", "()V", "mCountDownTimer", "com/yd/android_brand_mvp/verfity/fragment/VerificationCodeFragment$mCountDownTimer$1", "Lcom/yd/android_brand_mvp/verfity/fragment/VerificationCodeFragment$mCountDownTimer$1;", "qrcode", "", "initView", "", "onDestroy", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "random", "startAc", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VerificationCodeFragment extends KTBaseFragment<FragmentVerificationCodeBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CountDownTimer mCountDownTimer;
    private String qrcode;

    @JvmStatic
    public static final VerificationCodeFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.yd.android_brand_mvp.verfity.fragment.VerificationCodeFragment$mCountDownTimer$1] */
    public VerificationCodeFragment() {
        super((Function3<LayoutInflater, ViewGroup, Boolean, FragmentVerificationCodeBinding>) (layoutInflater, viewGroup, z) -> FragmentVerificationCodeBinding.inflate(layoutInflater, viewGroup, z.booleanValue()));
        this.qrcode = "";
        this.mCountDownTimer = new CountDownTimer(60000L, 1000L) {
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                TextView textView = VerificationCodeFragment.this.getBinding().tvCountdown;
                StringBuilder sb = new StringBuilder();
                sb.append(millisUntilFinished / ((long) 1000));
                sb.append('s');
                textView.setText(sb.toString());
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                VerificationCodeFragment.this.getBinding().ivQrcode.setImageBitmap(QRCodeUtils.createQRCode(VerificationCodeFragment.this.random(), TypedValues.AttributesType.TYPE_PATH_ROTATE, TypedValues.AttributesType.TYPE_PATH_ROTATE, null));
                cancel();
                start();
            }
        };
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        getBinding().btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerificationCodeFragment.initView$lambda$0(VerificationCodeFragment.this, view);
            }
        });
        getBinding().ivQrcode.setImageBitmap(QRCodeUtils.createQRCode(random(), SizeUtils.dp2px(316.0f), SizeUtils.dp2px(316.0f), null));
        this.mCountDownTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(VerificationCodeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = StringsKt.trim((CharSequence) this$0.getBinding().editText.getText().toString()).toString();
        SoftKeyBoardUtil.hideKeyBoard(this$0.getBinding().editText);
        // 还原版：1145 进教师端，1024 进学生空间；其余仍走原随机码校验。
        if (RestoreVerificationRouter.handleOfflineCode(this$0.mActivity, string)) {
            return;
        }
        if (TextUtils.isEmpty(string)) {
            ToastUtil.showBottomView(this$0.requireContext(), "请输入验证码！");
        } else if (!Intrinsics.areEqual(this$0.qrcode, string)) {
            ToastUtil.showBottomView(this$0.requireContext(), "验证码有误,请使用一加壹扫码获取！");
        } else {
            this$0.startAc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String random() {
        this.qrcode = String.valueOf((int) ((Math.random() * ((double) ConnectionResult.NETWORK_ERROR)) + ((double) 1000)));
        AppExtKt.logd(this, "离线验证密码：" + this.qrcode);
        String strEncryptPassword = DesCipherUtils.INSTANCE.encryptPassword(this.qrcode);
        if (strEncryptPassword == null) {
            strEncryptPassword = "";
        }
        AppExtKt.logd(this, "加密后：" + strEncryptPassword);
        AppExtKt.logd(this, "解密后：" + DesCipherUtils.INSTANCE.decryptPassword(strEncryptPassword));
        String str = "https://mcloud.yyide.com/#/verify?yideQrCode=yide_bp_pwd:" + strEncryptPassword + ':' + SpData.getSiteId();
        AppExtKt.logd(this, "二维码字符 = " + str);
        return str;
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        SoftKeyBoardUtil.hideKeyBoard(getBinding().editText);
        super.onDestroy();
    }

    private final void startAc() {
        startActivity(ScreenUtils.isLandscape() ? new Intent(this.mActivity, (Class<?>) SettingActivity.class) : new Intent(this.mActivity, (Class<?>) SettingPActivity.class));
        this.mActivity.finish();
    }

    /* JADX INFO: compiled from: VerificationCodeFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/verfity/fragment/VerificationCodeFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/verfity/fragment/VerificationCodeFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final VerificationCodeFragment newInstance() {
            return new VerificationCodeFragment();
        }
    }
}
