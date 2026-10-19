package com.yd.android_brand_mvp.brand.device;

import android.util.Log;
import cn.huidu.toolkit.HuiduTech;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: HuiDuDevices.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0006J\u0014\u0010\u000e\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00100\u0010J\u0006\u0010\u0015\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/brand/device/HuiDuDevices;", "", "()V", "helper", "Lcn/huidu/toolkit/HuiduTech;", "initUtil", "", "installApk", "filePath", "", "navigationBarStatus", "status", "", "reboot", "setPowerDay", "times", "", "setPowerOff", "timeSecond", "", "setPowerWeek", "shutDown", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HuiDuDevices {
    public static final HuiDuDevices INSTANCE = new HuiDuDevices();
    private static HuiduTech helper;

    private HuiDuDevices() {
    }

    public final void initUtil() {
        LogUtils.i("初始化灰度工具包");
        HuiduTech huiduTech = new HuiduTech(Utils.getApp());
        helper = huiduTech;
        if (huiduTech == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
            huiduTech = null;
        }
        huiduTech.setCompleteConnectionListener(new HuiduTech.CompleteConnection() { // from class: com.yd.android_brand_mvp.brand.device.-$$Lambda$HuiDuDevices$INI2kYFAJIwpXp8R-H60EUBUi8s
            @Override // cn.huidu.toolkit.HuiduTech.CompleteConnection
            public final void completeConnectionCallback(boolean z) {
                HuiDuDevices.initUtil$lambda$0(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initUtil$lambda$0(boolean z) {
        LogUtils.i("huidu sdk setCompleteConnectionListener: " + z);
        HuiduTech huiduTech = helper;
        if (huiduTech == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
            huiduTech = null;
        }
        huiduTech.powerOnAutoStart(AppUtils.getAppPackageName());
    }

    public final void reboot() {
        HuiduTech huiduTech = helper;
        if (huiduTech == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
            huiduTech = null;
        }
        huiduTech.reboot();
    }

    public final void shutDown() {
        HuiduTech huiduTech = helper;
        if (huiduTech == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
            huiduTech = null;
        }
        huiduTech.shutdown();
    }

    public final void navigationBarStatus(boolean status) {
        HuiduTech huiduTech = helper;
        HuiduTech huiduTech2 = null;
        if (huiduTech == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
            huiduTech = null;
        }
        huiduTech.showNavigationBar(status);
        HuiduTech huiduTech3 = helper;
        if (huiduTech3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
        } else {
            huiduTech2 = huiduTech3;
        }
        huiduTech2.showStatusBar(status);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.brand.device.HuiDuDevices$installApk$1, reason: invalid class name */
    /* JADX INFO: compiled from: HuiDuDevices.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.brand.device.HuiDuDevices$installApk$1", f = "HuiDuDevices.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $filePath;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$filePath = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$filePath, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                HuiduTech huiduTech = HuiDuDevices.helper;
                if (huiduTech == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("helper");
                    huiduTech = null;
                }
                if (!huiduTech.installAndStart(this.$filePath, AppUtils.getAppPackageName(), "WelcomeActivity")) {
                    LogUtils.e("静默安装失败");
                    ToastUtils.showShort("静默安装失败", new Object[0]);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void installApk(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(filePath, null), 3, null);
    }

    public final void setPowerOff(int timeSecond) {
        HuiduTech huiduTech = helper;
        if (huiduTech == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
            huiduTech = null;
        }
        if (huiduTech.alarmPowerOn(timeSecond)) {
            return;
        }
        LogUtils.e("设置定时开机失败");
    }

    public final void setPowerDay(List<String> times) {
        Intrinsics.checkNotNullParameter(times, "times");
        LogUtils.i("setPowerDay", "灰度定时开关times: " + times);
        HuiduTech huiduTech = helper;
        if (huiduTech == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
            huiduTech = null;
        }
        if (huiduTech.setPowerOnOff(times)) {
            return;
        }
        LogUtils.e("设置定时开机失败");
    }

    public final void setPowerWeek(List<List<String>> times) {
        HuiduTech huiduTech;
        Intrinsics.checkNotNullParameter(times, "times");
        ArrayList arrayList = new ArrayList();
        List<String> list = arrayList;
        List<String> list2 = null;
        List<String> list3 = null;
        List<String> list4 = null;
        List<String> list5 = null;
        List<String> list6 = null;
        List<String> list7 = null;
        int i = 0;
        for (Object obj : times) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            List<String> list8 = (List) obj;
            switch (i) {
                case 0:
                    if (!list8.isEmpty()) {
                        list2 = list8;
                    }
                    break;
                case 1:
                    if (!list8.isEmpty()) {
                        list3 = list8;
                    }
                    break;
                case 2:
                    if (!list8.isEmpty()) {
                        list4 = list8;
                    }
                    break;
                case 3:
                    if (!list8.isEmpty()) {
                        list5 = list8;
                    }
                    break;
                case 4:
                    if (!list8.isEmpty()) {
                        list6 = list8;
                    }
                    break;
                case 5:
                    if (!list8.isEmpty()) {
                        list = list8;
                    }
                    break;
                case 6:
                    if (!list8.isEmpty()) {
                        list7 = list8;
                    }
                    break;
            }
            i = i2;
        }
        Log.i("setPowerWeek", "灰度定时按周开关times: " + list2 + ' ' + list3 + ' ' + list4 + ' ' + list5 + ' ' + list6 + ' ' + list + ' ' + list7);
        HuiduTech huiduTech2 = helper;
        if (huiduTech2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
            huiduTech = null;
        } else {
            huiduTech = huiduTech2;
        }
        if (huiduTech.setPowerOnOffByWeek(list2, list3, list4, list5, list6, list, list7)) {
            return;
        }
        LogUtils.e("设置定时开机失败");
    }
}
