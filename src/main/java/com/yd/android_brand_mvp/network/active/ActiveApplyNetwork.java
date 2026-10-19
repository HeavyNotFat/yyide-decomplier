package com.yd.android_brand_mvp.network.active;

import com.yd.android_brand_mvp.model.active.ActiveDetailsBean;
import com.yd.android_brand_mvp.model.active.ActiveMyRegistrationBean;
import com.yd.android_brand_mvp.model.active.ActiveRegistrationBean;
import com.yd.android_brand_mvp.model.active.ActiveSuccessBean;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: ActiveApplyNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ6\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\nJ*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\nJ*\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0014\u0010\nJ6\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\r0\f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0017\u0010\n\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/network/active/ActiveApplyNetwork;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/active/IActiveService;", "()V", "requestActiveDetails", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/active/ActiveDetailsBean;", "requestBody", "Lokhttp3/RequestBody;", "requestActiveDetails-gIAlu-s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestActiveList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/active/ActiveRegistrationBean;", "requestActiveList-gIAlu-s", "requestActiveRegistration", "Lcom/yd/android_brand_mvp/model/active/ActiveSuccessBean;", "requestActiveRegistration-gIAlu-s", "requestLoginActiveDetails", "requestLoginActiveDetails-gIAlu-s", "requestMyRegistrationList", "Lcom/yd/android_brand_mvp/model/active/ActiveMyRegistrationBean;", "requestMyRegistrationList-gIAlu-s", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActiveApplyNetwork extends BaseNetworkApi<IActiveService> {
    public static final ActiveApplyNetwork INSTANCE = new ActiveApplyNetwork();

    private ActiveApplyNetwork() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestActiveList-gIAlu-s, reason: not valid java name */
    public final Object m477requestActiveListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<ActiveRegistrationBean>>>> continuation) {
        ActiveApplyNetwork$requestActiveList$1 activeApplyNetwork$requestActiveList$1;
        if (continuation instanceof ActiveApplyNetwork$requestActiveList$1) {
            activeApplyNetwork$requestActiveList$1 = (ActiveApplyNetwork$requestActiveList$1) continuation;
            if ((activeApplyNetwork$requestActiveList$1.label & Integer.MIN_VALUE) != 0) {
                activeApplyNetwork$requestActiveList$1.label -= Integer.MIN_VALUE;
            } else {
                activeApplyNetwork$requestActiveList$1 = new ActiveApplyNetwork$requestActiveList$1(this, continuation);
            }
        } else {
            activeApplyNetwork$requestActiveList$1 = new ActiveApplyNetwork$requestActiveList$1(this, continuation);
        }
        Object obj = activeApplyNetwork$requestActiveList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = activeApplyNetwork$requestActiveList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ActiveApplyNetwork$requestActiveList$2 activeApplyNetwork$requestActiveList$2 = new ActiveApplyNetwork$requestActiveList$2(requestBody, null);
        activeApplyNetwork$requestActiveList$1.label = 1;
        Object obj2 = m485getResultgIAlus(activeApplyNetwork$requestActiveList$2, activeApplyNetwork$requestActiveList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestActiveDetails-gIAlu-s, reason: not valid java name */
    public final Object m476requestActiveDetailsgIAlus(RequestBody requestBody, Continuation<? super Result<ActiveDetailsBean>> continuation) {
        ActiveApplyNetwork$requestActiveDetails$1 activeApplyNetwork$requestActiveDetails$1;
        if (continuation instanceof ActiveApplyNetwork$requestActiveDetails$1) {
            activeApplyNetwork$requestActiveDetails$1 = (ActiveApplyNetwork$requestActiveDetails$1) continuation;
            if ((activeApplyNetwork$requestActiveDetails$1.label & Integer.MIN_VALUE) != 0) {
                activeApplyNetwork$requestActiveDetails$1.label -= Integer.MIN_VALUE;
            } else {
                activeApplyNetwork$requestActiveDetails$1 = new ActiveApplyNetwork$requestActiveDetails$1(this, continuation);
            }
        } else {
            activeApplyNetwork$requestActiveDetails$1 = new ActiveApplyNetwork$requestActiveDetails$1(this, continuation);
        }
        Object obj = activeApplyNetwork$requestActiveDetails$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = activeApplyNetwork$requestActiveDetails$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ActiveApplyNetwork$requestActiveDetails$2 activeApplyNetwork$requestActiveDetails$2 = new ActiveApplyNetwork$requestActiveDetails$2(requestBody, null);
        activeApplyNetwork$requestActiveDetails$1.label = 1;
        Object obj2 = m485getResultgIAlus(activeApplyNetwork$requestActiveDetails$2, activeApplyNetwork$requestActiveDetails$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestMyRegistrationList-gIAlu-s, reason: not valid java name */
    public final Object m480requestMyRegistrationListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<ActiveMyRegistrationBean>>>> continuation) {
        ActiveApplyNetwork$requestMyRegistrationList$1 activeApplyNetwork$requestMyRegistrationList$1;
        if (continuation instanceof ActiveApplyNetwork$requestMyRegistrationList$1) {
            activeApplyNetwork$requestMyRegistrationList$1 = (ActiveApplyNetwork$requestMyRegistrationList$1) continuation;
            if ((activeApplyNetwork$requestMyRegistrationList$1.label & Integer.MIN_VALUE) != 0) {
                activeApplyNetwork$requestMyRegistrationList$1.label -= Integer.MIN_VALUE;
            } else {
                activeApplyNetwork$requestMyRegistrationList$1 = new ActiveApplyNetwork$requestMyRegistrationList$1(this, continuation);
            }
        } else {
            activeApplyNetwork$requestMyRegistrationList$1 = new ActiveApplyNetwork$requestMyRegistrationList$1(this, continuation);
        }
        Object obj = activeApplyNetwork$requestMyRegistrationList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = activeApplyNetwork$requestMyRegistrationList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ActiveApplyNetwork$requestMyRegistrationList$2 activeApplyNetwork$requestMyRegistrationList$2 = new ActiveApplyNetwork$requestMyRegistrationList$2(requestBody, null);
        activeApplyNetwork$requestMyRegistrationList$1.label = 1;
        Object obj2 = m485getResultgIAlus(activeApplyNetwork$requestMyRegistrationList$2, activeApplyNetwork$requestMyRegistrationList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestLoginActiveDetails-gIAlu-s, reason: not valid java name */
    public final Object m479requestLoginActiveDetailsgIAlus(RequestBody requestBody, Continuation<? super Result<ActiveDetailsBean>> continuation) {
        ActiveApplyNetwork$requestLoginActiveDetails$1 activeApplyNetwork$requestLoginActiveDetails$1;
        if (continuation instanceof ActiveApplyNetwork$requestLoginActiveDetails$1) {
            activeApplyNetwork$requestLoginActiveDetails$1 = (ActiveApplyNetwork$requestLoginActiveDetails$1) continuation;
            if ((activeApplyNetwork$requestLoginActiveDetails$1.label & Integer.MIN_VALUE) != 0) {
                activeApplyNetwork$requestLoginActiveDetails$1.label -= Integer.MIN_VALUE;
            } else {
                activeApplyNetwork$requestLoginActiveDetails$1 = new ActiveApplyNetwork$requestLoginActiveDetails$1(this, continuation);
            }
        } else {
            activeApplyNetwork$requestLoginActiveDetails$1 = new ActiveApplyNetwork$requestLoginActiveDetails$1(this, continuation);
        }
        Object obj = activeApplyNetwork$requestLoginActiveDetails$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = activeApplyNetwork$requestLoginActiveDetails$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ActiveApplyNetwork$requestLoginActiveDetails$2 activeApplyNetwork$requestLoginActiveDetails$2 = new ActiveApplyNetwork$requestLoginActiveDetails$2(requestBody, null);
        activeApplyNetwork$requestLoginActiveDetails$1.label = 1;
        Object obj2 = m485getResultgIAlus(activeApplyNetwork$requestLoginActiveDetails$2, activeApplyNetwork$requestLoginActiveDetails$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestActiveRegistration-gIAlu-s, reason: not valid java name */
    public final Object m478requestActiveRegistrationgIAlus(RequestBody requestBody, Continuation<? super Result<ActiveSuccessBean>> continuation) {
        ActiveApplyNetwork$requestActiveRegistration$1 activeApplyNetwork$requestActiveRegistration$1;
        if (continuation instanceof ActiveApplyNetwork$requestActiveRegistration$1) {
            activeApplyNetwork$requestActiveRegistration$1 = (ActiveApplyNetwork$requestActiveRegistration$1) continuation;
            if ((activeApplyNetwork$requestActiveRegistration$1.label & Integer.MIN_VALUE) != 0) {
                activeApplyNetwork$requestActiveRegistration$1.label -= Integer.MIN_VALUE;
            } else {
                activeApplyNetwork$requestActiveRegistration$1 = new ActiveApplyNetwork$requestActiveRegistration$1(this, continuation);
            }
        } else {
            activeApplyNetwork$requestActiveRegistration$1 = new ActiveApplyNetwork$requestActiveRegistration$1(this, continuation);
        }
        Object obj = activeApplyNetwork$requestActiveRegistration$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = activeApplyNetwork$requestActiveRegistration$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ActiveApplyNetwork$requestActiveRegistration$2 activeApplyNetwork$requestActiveRegistration$2 = new ActiveApplyNetwork$requestActiveRegistration$2(requestBody, null);
        activeApplyNetwork$requestActiveRegistration$1.label = 1;
        Object obj2 = m485getResultgIAlus(activeApplyNetwork$requestActiveRegistration$2, activeApplyNetwork$requestActiveRegistration$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
