package com.yd.android_brand_mvp.verfity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.exoplayer2.C;
import com.yd.android_brand_mvp.SettingActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentScanCodeLoginBinding;
import com.yd.android_brand_mvp.model.ScanQrCodeBean;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.portrait.activity.SettingPActivity;
import com.yd.android_brand_mvp.user.UserCenterActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.Tool;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ScanCodeLoginFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0017J\u0006\u0010\u0016\u001a\u00020\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/verfity/fragment/ScanCodeLoginFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentScanCodeLoginBinding;", "()V", "mTimer", "Ljava/util/Timer;", "getMTimer", "()Ljava/util/Timer;", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "viewModel", "Lcom/yd/android_brand_mvp/verfity/fragment/ScanCodeLoginViewModel;", "initView", "", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "startAc", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScanCodeLoginFragment extends KTBaseFragment<FragmentScanCodeLoginBinding> {
    private final Timer mTimer;
    private String type;
    private ScanCodeLoginViewModel viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TYPE_STUDENT = "2";
    private static final String TYPE_SETTING = "3";

    @JvmStatic
    public static final ScanCodeLoginFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.verfity.fragment.ScanCodeLoginFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScanCodeLoginFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentScanCodeLoginBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentScanCodeLoginBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentScanCodeLoginBinding;", 0);
        }

        public final FragmentScanCodeLoginBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentScanCodeLoginBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentScanCodeLoginBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public ScanCodeLoginFragment() {
        super(AnonymousClass1.INSTANCE);
        this.type = "";
        this.mTimer = new Timer();
    }

    public static final /* synthetic */ FragmentScanCodeLoginBinding access$getBinding(ScanCodeLoginFragment scanCodeLoginFragment) {
        return scanCodeLoginFragment.getBinding();
    }

    /* JADX INFO: compiled from: ScanCodeLoginFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/verfity/fragment/ScanCodeLoginFragment$Companion;", "", "()V", "TYPE_SETTING", "", "getTYPE_SETTING", "()Ljava/lang/String;", "TYPE_STUDENT", "getTYPE_STUDENT", "newInstance", "Lcom/yd/android_brand_mvp/verfity/fragment/ScanCodeLoginFragment;", "type", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTYPE_STUDENT() {
            return ScanCodeLoginFragment.TYPE_STUDENT;
        }

        public final String getTYPE_SETTING() {
            return ScanCodeLoginFragment.TYPE_SETTING;
        }

        @JvmStatic
        public final ScanCodeLoginFragment newInstance(String type) {
            ScanCodeLoginFragment scanCodeLoginFragment = new ScanCodeLoginFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            scanCodeLoginFragment.setArguments(bundle);
            return scanCodeLoginFragment;
        }
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final Timer getMTimer() {
        return this.mTimer;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (ScanCodeLoginViewModel) new ViewModelProvider(this).get(ScanCodeLoginViewModel.class);
        initView();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        ScanCodeLoginViewModel scanCodeLoginViewModel = null;
        String string = arguments != null ? arguments.getString("type") : null;
        if (Intrinsics.areEqual(string, TYPE_STUDENT)) {
            this.type = TYPE_STUDENT;
        } else if (Intrinsics.areEqual(string, TYPE_SETTING)) {
            this.type = TYPE_SETTING;
        }
        initViewModel();
        ScanCodeLoginViewModel scanCodeLoginViewModel2 = this.viewModel;
        if (scanCodeLoginViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            scanCodeLoginViewModel = scanCodeLoginViewModel2;
        }
        String str = this.type;
        String schoolId = SpData.getSchoolId();
        Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
        scanCodeLoginViewModel.requestQrCode(str, schoolId);
        getBinding().qrcode.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.verfity.fragment.-$$Lambda$ScanCodeLoginFragment$qajG0_AsVUg2Yz8-wSFeUqwhPjE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScanCodeLoginFragment.initView$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ScanCodeLoginFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().qrcode.setEnabled(false);
        ScanCodeLoginViewModel scanCodeLoginViewModel = this$0.viewModel;
        if (scanCodeLoginViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            scanCodeLoginViewModel = null;
        }
        String str = this$0.type;
        String schoolId = SpData.getSchoolId();
        Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
        scanCodeLoginViewModel.requestQrCode(str, schoolId);
    }

    public final void startAc() {
        startActivity(ScreenUtils.isLandscape() ? new Intent(this.mActivity, (Class<?>) SettingActivity.class) : new Intent(this.mActivity, (Class<?>) SettingPActivity.class));
    }

    private final void initViewModel() {
        ScanCodeLoginViewModel scanCodeLoginViewModel = this.viewModel;
        ScanCodeLoginViewModel scanCodeLoginViewModel2 = null;
        if (scanCodeLoginViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            scanCodeLoginViewModel = null;
        }
        SingleLiveEvent<Result<ScanQrCodeBean>> qrCodeLiveData = scanCodeLoginViewModel.getQrCodeLiveData();
        ScanCodeLoginFragment scanCodeLoginFragment = this;
        final Function1<Result<? extends ScanQrCodeBean>, Unit> function1 = new Function1<Result<? extends ScanQrCodeBean>, Unit>() { // from class: com.yd.android_brand_mvp.verfity.fragment.ScanCodeLoginFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends ScanQrCodeBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends ScanQrCodeBean> it2) {
                ScanCodeLoginFragment.access$getBinding(ScanCodeLoginFragment.this).qrcode.setEnabled(true);
                ScanCodeLoginFragment.access$getBinding(ScanCodeLoginFragment.this).tvMsg.setVisibility(4);
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    final ScanQrCodeBean scanQrCodeBean = (ScanQrCodeBean) value;
                    if (scanQrCodeBean != null) {
                        final ScanCodeLoginFragment scanCodeLoginFragment2 = ScanCodeLoginFragment.this;
                        ScanCodeLoginFragment.access$getBinding(scanCodeLoginFragment2).qrcode.setImageBitmap(Tool.stringtoBitmap(StringsKt.replace$default(scanQrCodeBean.getQrcode(), "data:image/png;base64,", "", false, 4, (Object) null)));
                        scanCodeLoginFragment2.getMTimer().schedule(new TimerTask() { // from class: com.yd.android_brand_mvp.verfity.fragment.ScanCodeLoginFragment$initViewModel$1$1$1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                ScanCodeLoginViewModel scanCodeLoginViewModel3 = scanCodeLoginFragment2.viewModel;
                                if (scanCodeLoginViewModel3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    scanCodeLoginViewModel3 = null;
                                }
                                scanCodeLoginViewModel3.requestQrCodeCheck(scanQrCodeBean.getRandom());
                            }
                        }, new Date(), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                        return;
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        qrCodeLiveData.observe(scanCodeLoginFragment, new Observer() { // from class: com.yd.android_brand_mvp.verfity.fragment.-$$Lambda$ScanCodeLoginFragment$JDLesfT_KTHnIrp3K3gx408FyQE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ScanCodeLoginFragment.initViewModel$lambda$1(function1, obj);
            }
        });
        ScanCodeLoginViewModel scanCodeLoginViewModel3 = this.viewModel;
        if (scanCodeLoginViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            scanCodeLoginViewModel2 = scanCodeLoginViewModel3;
        }
        SingleLiveEvent<Result<ScanQrCodeBean>> qrCodeCheckLiveData = scanCodeLoginViewModel2.getQrCodeCheckLiveData();
        final Function1<Result<? extends ScanQrCodeBean>, Unit> function2 = new Function1<Result<? extends ScanQrCodeBean>, Unit>() { // from class: com.yd.android_brand_mvp.verfity.fragment.ScanCodeLoginFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends ScanQrCodeBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends ScanQrCodeBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    ScanCodeLoginViewModel scanCodeLoginViewModel4 = null;
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    ScanQrCodeBean scanQrCodeBean = (ScanQrCodeBean) value;
                    if (scanQrCodeBean != null) {
                        ScanCodeLoginFragment scanCodeLoginFragment2 = ScanCodeLoginFragment.this;
                        int status = scanQrCodeBean.getStatus();
                        if (status == 0) {
                            ScanCodeLoginFragment.access$getBinding(scanCodeLoginFragment2).tvMsg.setVisibility(4);
                            return;
                        }
                        if (status == 1) {
                            ScanCodeLoginFragment.access$getBinding(scanCodeLoginFragment2).tvMsg.setVisibility(4);
                            return;
                        }
                        if (status == 2) {
                            scanCodeLoginFragment2.getMTimer().cancel();
                            ScanCodeLoginFragment.access$getBinding(scanCodeLoginFragment2).qrcode.setEnabled(false);
                            ScanCodeLoginFragment.access$getBinding(scanCodeLoginFragment2).qrcode.setEnabled(false);
                            ScanCodeLoginViewModel scanCodeLoginViewModel5 = scanCodeLoginFragment2.viewModel;
                            if (scanCodeLoginViewModel5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            } else {
                                scanCodeLoginViewModel4 = scanCodeLoginViewModel5;
                            }
                            String type = scanCodeLoginFragment2.getType();
                            String schoolId = SpData.getSchoolId();
                            Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
                            scanCodeLoginViewModel4.requestQrCode(type, schoolId);
                            return;
                        }
                        if (status != 3) {
                            if (status != 4) {
                                return;
                            }
                            ScanCodeLoginFragment.access$getBinding(scanCodeLoginFragment2).tvMsg.setVisibility(0);
                            ScanCodeLoginFragment.access$getBinding(scanCodeLoginFragment2).tvMsg.setText("取消授权,请刷新重试");
                            scanCodeLoginFragment2.getMTimer().cancel();
                            return;
                        }
                        ScanCodeLoginFragment.access$getBinding(scanCodeLoginFragment2).tvMsg.setVisibility(4);
                        if (Intrinsics.areEqual(ScanCodeLoginFragment.INSTANCE.getTYPE_STUDENT(), scanCodeLoginFragment2.getType())) {
                            scanCodeLoginFragment2.startActivity(new Intent(scanCodeLoginFragment2.mActivity, (Class<?>) UserCenterActivity.class));
                            scanCodeLoginFragment2.requireActivity().finish();
                            return;
                        } else {
                            if (Intrinsics.areEqual(ScanCodeLoginFragment.INSTANCE.getTYPE_SETTING(), scanCodeLoginFragment2.getType())) {
                                scanCodeLoginFragment2.startAc();
                                scanCodeLoginFragment2.requireActivity().finish();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        qrCodeCheckLiveData.observe(scanCodeLoginFragment, new Observer() { // from class: com.yd.android_brand_mvp.verfity.fragment.-$$Lambda$ScanCodeLoginFragment$ueh3yfySoomKR1zshe4EcIH72fc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ScanCodeLoginFragment.initViewModel$lambda$2(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
