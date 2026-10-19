package com.yd.android_brand_mvp.network.setting;

import com.yd.android_brand_mvp.model.getRegistrationCodeRsp;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: SettingActivationNetWork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/network/setting/SettingActivationNetWork;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/setting/ISettingActivationService;", "()V", "getActivationCode", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/getRegistrationCodeRsp$RegistrationCode;", "requestBody", "Lokhttp3/RequestBody;", "getActivationCode-gIAlu-s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SettingActivationNetWork extends BaseNetworkApi<ISettingActivationService> {
    public static final SettingActivationNetWork INSTANCE = new SettingActivationNetWork();

    private SettingActivationNetWork() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getActivationCode-gIAlu-s, reason: not valid java name */
    public final Object m532getActivationCodegIAlus(RequestBody requestBody, Continuation<? super Result<? extends getRegistrationCodeRsp.RegistrationCode>> continuation) {
        SettingActivationNetWork$getActivationCode$1 settingActivationNetWork$getActivationCode$1;
        if (continuation instanceof SettingActivationNetWork$getActivationCode$1) {
            settingActivationNetWork$getActivationCode$1 = (SettingActivationNetWork$getActivationCode$1) continuation;
            if ((settingActivationNetWork$getActivationCode$1.label & Integer.MIN_VALUE) != 0) {
                settingActivationNetWork$getActivationCode$1.label -= Integer.MIN_VALUE;
            } else {
                settingActivationNetWork$getActivationCode$1 = new SettingActivationNetWork$getActivationCode$1(this, continuation);
            }
        } else {
            settingActivationNetWork$getActivationCode$1 = new SettingActivationNetWork$getActivationCode$1(this, continuation);
        }
        Object obj = settingActivationNetWork$getActivationCode$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = settingActivationNetWork$getActivationCode$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        SettingActivationNetWork$getActivationCode$2 settingActivationNetWork$getActivationCode$2 = new SettingActivationNetWork$getActivationCode$2(requestBody, null);
        settingActivationNetWork$getActivationCode$1.label = 1;
        Object obj2 = m485getResultgIAlus(settingActivationNetWork$getActivationCode$2, settingActivationNetWork$getActivationCode$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
