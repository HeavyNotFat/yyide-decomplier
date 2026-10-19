package com.yd.android_brand_mvp.network.customized;

import com.yd.android_brand_mvp.model.customized.CustomSensorBean;
import com.yd.android_brand_mvp.model.customized.CustomSiteInfoBean;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: CustomizedNetWork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\r\u0010\nJ*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\n\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/network/customized/CustomizedNetWork;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/customized/ICustomizedService;", "()V", "requestSensorInfoList", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/customized/CustomSensorBean;", "requestBody", "Lokhttp3/RequestBody;", "requestSensorInfoList-gIAlu-s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestSiteInfo", "Lcom/yd/android_brand_mvp/model/customized/CustomSiteInfoBean;", "requestSiteInfo-gIAlu-s", "requestWarningInfoList", "requestWarningInfoList-gIAlu-s", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomizedNetWork extends BaseNetworkApi<ICustomizedService> {
    public static final CustomizedNetWork INSTANCE = new CustomizedNetWork();

    private CustomizedNetWork() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestSiteInfo-gIAlu-s, reason: not valid java name */
    public final Object m494requestSiteInfogIAlus(RequestBody requestBody, Continuation<? super Result<CustomSiteInfoBean>> continuation) {
        CustomizedNetWork$requestSiteInfo$1 customizedNetWork$requestSiteInfo$1;
        if (continuation instanceof CustomizedNetWork$requestSiteInfo$1) {
            customizedNetWork$requestSiteInfo$1 = (CustomizedNetWork$requestSiteInfo$1) continuation;
            if ((customizedNetWork$requestSiteInfo$1.label & Integer.MIN_VALUE) != 0) {
                customizedNetWork$requestSiteInfo$1.label -= Integer.MIN_VALUE;
            } else {
                customizedNetWork$requestSiteInfo$1 = new CustomizedNetWork$requestSiteInfo$1(this, continuation);
            }
        } else {
            customizedNetWork$requestSiteInfo$1 = new CustomizedNetWork$requestSiteInfo$1(this, continuation);
        }
        Object obj = customizedNetWork$requestSiteInfo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = customizedNetWork$requestSiteInfo$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        CustomizedNetWork$requestSiteInfo$2 customizedNetWork$requestSiteInfo$2 = new CustomizedNetWork$requestSiteInfo$2(requestBody, null);
        customizedNetWork$requestSiteInfo$1.label = 1;
        Object obj2 = m485getResultgIAlus(customizedNetWork$requestSiteInfo$2, customizedNetWork$requestSiteInfo$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestWarningInfoList-gIAlu-s, reason: not valid java name */
    public final Object m495requestWarningInfoListgIAlus(RequestBody requestBody, Continuation<? super Result<CustomSiteInfoBean>> continuation) {
        CustomizedNetWork$requestWarningInfoList$1 customizedNetWork$requestWarningInfoList$1;
        if (continuation instanceof CustomizedNetWork$requestWarningInfoList$1) {
            customizedNetWork$requestWarningInfoList$1 = (CustomizedNetWork$requestWarningInfoList$1) continuation;
            if ((customizedNetWork$requestWarningInfoList$1.label & Integer.MIN_VALUE) != 0) {
                customizedNetWork$requestWarningInfoList$1.label -= Integer.MIN_VALUE;
            } else {
                customizedNetWork$requestWarningInfoList$1 = new CustomizedNetWork$requestWarningInfoList$1(this, continuation);
            }
        } else {
            customizedNetWork$requestWarningInfoList$1 = new CustomizedNetWork$requestWarningInfoList$1(this, continuation);
        }
        Object obj = customizedNetWork$requestWarningInfoList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = customizedNetWork$requestWarningInfoList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        CustomizedNetWork$requestWarningInfoList$2 customizedNetWork$requestWarningInfoList$2 = new CustomizedNetWork$requestWarningInfoList$2(requestBody, null);
        customizedNetWork$requestWarningInfoList$1.label = 1;
        Object obj2 = m485getResultgIAlus(customizedNetWork$requestWarningInfoList$2, customizedNetWork$requestWarningInfoList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestSensorInfoList-gIAlu-s, reason: not valid java name */
    public final Object m493requestSensorInfoListgIAlus(RequestBody requestBody, Continuation<? super Result<CustomSensorBean>> continuation) {
        CustomizedNetWork$requestSensorInfoList$1 customizedNetWork$requestSensorInfoList$1;
        if (continuation instanceof CustomizedNetWork$requestSensorInfoList$1) {
            customizedNetWork$requestSensorInfoList$1 = (CustomizedNetWork$requestSensorInfoList$1) continuation;
            if ((customizedNetWork$requestSensorInfoList$1.label & Integer.MIN_VALUE) != 0) {
                customizedNetWork$requestSensorInfoList$1.label -= Integer.MIN_VALUE;
            } else {
                customizedNetWork$requestSensorInfoList$1 = new CustomizedNetWork$requestSensorInfoList$1(this, continuation);
            }
        } else {
            customizedNetWork$requestSensorInfoList$1 = new CustomizedNetWork$requestSensorInfoList$1(this, continuation);
        }
        Object obj = customizedNetWork$requestSensorInfoList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = customizedNetWork$requestSensorInfoList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        CustomizedNetWork$requestSensorInfoList$2 customizedNetWork$requestSensorInfoList$2 = new CustomizedNetWork$requestSensorInfoList$2(requestBody, null);
        customizedNetWork$requestSensorInfoList$1.label = 1;
        Object obj2 = m485getResultgIAlus(customizedNetWork$requestSensorInfoList$2, customizedNetWork$requestSensorInfoList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
