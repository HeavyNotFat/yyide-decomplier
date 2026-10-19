package com.yd.android_brand_mvp.network.evaluation;

import com.yd.android_brand_mvp.model.evaluation.EvaluationBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationMedalBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationMedalTypeBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationPointBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationPointCardBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationPointCardCancelBean;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: EvaluationNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\b\u001a\u00020\tH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ6\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u00100\u00052\u0006\u0010\b\u001a\u00020\tH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\u000bJ(\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00060\u0005H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0014\u0010\u0015J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\b\u001a\u00020\tH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0018\u0010\u000bJ6\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00060\u00100\u00052\u0006\u0010\b\u001a\u00020\tH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001b\u0010\u000bJ2\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b!\u0010\"J6\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00060\u00100\u00052\u0006\u0010\b\u001a\u00020\tH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b$\u0010\u000b\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/network/evaluation/EvaluationNetwork;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/evaluation/IEvaluationService;", "()V", "getEvaluationList", "Lkotlin/Result;", "", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationBean;", "requestBody", "Lokhttp3/RequestBody;", "getEvaluationList-gIAlu-s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEvaluationMedalDetails", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationMedalBean;", "getEvaluationMedalDetails-gIAlu-s", "getEvaluationMedalList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "getEvaluationMedalList-gIAlu-s", "getEvaluationMedalTypeList", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationMedalTypeBean;", "getEvaluationMedalTypeList-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEvaluationPointCardDetails", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationPointCardCancelBean;", "getEvaluationPointCardDetails-gIAlu-s", "getEvaluationPointCardPageList", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationPointCardBean;", "getEvaluationPointCardPageList-gIAlu-s", "getEvaluationPointDetails", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationPointBean;", "personId", "", "identity", "getEvaluationPointDetails-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEvaluationPointPageList", "getEvaluationPointPageList-gIAlu-s", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EvaluationNetwork extends BaseNetworkApi<IEvaluationService> {
    public static final EvaluationNetwork INSTANCE = new EvaluationNetwork();

    private EvaluationNetwork() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getEvaluationList-gIAlu-s, reason: not valid java name */
    public final Object m498getEvaluationListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<EvaluationBean>>> continuation) {
        EvaluationNetwork$getEvaluationList$1 evaluationNetwork$getEvaluationList$1;
        if (continuation instanceof EvaluationNetwork$getEvaluationList$1) {
            evaluationNetwork$getEvaluationList$1 = (EvaluationNetwork$getEvaluationList$1) continuation;
            if ((evaluationNetwork$getEvaluationList$1.label & Integer.MIN_VALUE) != 0) {
                evaluationNetwork$getEvaluationList$1.label -= Integer.MIN_VALUE;
            } else {
                evaluationNetwork$getEvaluationList$1 = new EvaluationNetwork$getEvaluationList$1(this, continuation);
            }
        } else {
            evaluationNetwork$getEvaluationList$1 = new EvaluationNetwork$getEvaluationList$1(this, continuation);
        }
        Object obj = evaluationNetwork$getEvaluationList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = evaluationNetwork$getEvaluationList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        EvaluationNetwork$getEvaluationList$2 evaluationNetwork$getEvaluationList$2 = new EvaluationNetwork$getEvaluationList$2(requestBody, null);
        evaluationNetwork$getEvaluationList$1.label = 1;
        Object obj2 = m485getResultgIAlus(evaluationNetwork$getEvaluationList$2, evaluationNetwork$getEvaluationList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getEvaluationMedalList-gIAlu-s, reason: not valid java name */
    public final Object m500getEvaluationMedalListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<EvaluationMedalBean>>>> continuation) {
        EvaluationNetwork$getEvaluationMedalList$1 evaluationNetwork$getEvaluationMedalList$1;
        if (continuation instanceof EvaluationNetwork$getEvaluationMedalList$1) {
            evaluationNetwork$getEvaluationMedalList$1 = (EvaluationNetwork$getEvaluationMedalList$1) continuation;
            if ((evaluationNetwork$getEvaluationMedalList$1.label & Integer.MIN_VALUE) != 0) {
                evaluationNetwork$getEvaluationMedalList$1.label -= Integer.MIN_VALUE;
            } else {
                evaluationNetwork$getEvaluationMedalList$1 = new EvaluationNetwork$getEvaluationMedalList$1(this, continuation);
            }
        } else {
            evaluationNetwork$getEvaluationMedalList$1 = new EvaluationNetwork$getEvaluationMedalList$1(this, continuation);
        }
        Object obj = evaluationNetwork$getEvaluationMedalList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = evaluationNetwork$getEvaluationMedalList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        EvaluationNetwork$getEvaluationMedalList$2 evaluationNetwork$getEvaluationMedalList$2 = new EvaluationNetwork$getEvaluationMedalList$2(requestBody, null);
        evaluationNetwork$getEvaluationMedalList$1.label = 1;
        Object obj2 = m485getResultgIAlus(evaluationNetwork$getEvaluationMedalList$2, evaluationNetwork$getEvaluationMedalList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getEvaluationMedalDetails-gIAlu-s, reason: not valid java name */
    public final Object m499getEvaluationMedalDetailsgIAlus(RequestBody requestBody, Continuation<? super Result<EvaluationMedalBean>> continuation) {
        EvaluationNetwork$getEvaluationMedalDetails$1 evaluationNetwork$getEvaluationMedalDetails$1;
        if (continuation instanceof EvaluationNetwork$getEvaluationMedalDetails$1) {
            evaluationNetwork$getEvaluationMedalDetails$1 = (EvaluationNetwork$getEvaluationMedalDetails$1) continuation;
            if ((evaluationNetwork$getEvaluationMedalDetails$1.label & Integer.MIN_VALUE) != 0) {
                evaluationNetwork$getEvaluationMedalDetails$1.label -= Integer.MIN_VALUE;
            } else {
                evaluationNetwork$getEvaluationMedalDetails$1 = new EvaluationNetwork$getEvaluationMedalDetails$1(this, continuation);
            }
        } else {
            evaluationNetwork$getEvaluationMedalDetails$1 = new EvaluationNetwork$getEvaluationMedalDetails$1(this, continuation);
        }
        Object obj = evaluationNetwork$getEvaluationMedalDetails$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = evaluationNetwork$getEvaluationMedalDetails$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        EvaluationNetwork$getEvaluationMedalDetails$2 evaluationNetwork$getEvaluationMedalDetails$2 = new EvaluationNetwork$getEvaluationMedalDetails$2(requestBody, null);
        evaluationNetwork$getEvaluationMedalDetails$1.label = 1;
        Object obj2 = m485getResultgIAlus(evaluationNetwork$getEvaluationMedalDetails$2, evaluationNetwork$getEvaluationMedalDetails$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getEvaluationPointCardPageList-gIAlu-s, reason: not valid java name */
    public final Object m503getEvaluationPointCardPageListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<EvaluationPointCardBean>>>> continuation) {
        EvaluationNetwork$getEvaluationPointCardPageList$1 evaluationNetwork$getEvaluationPointCardPageList$1;
        if (continuation instanceof EvaluationNetwork$getEvaluationPointCardPageList$1) {
            evaluationNetwork$getEvaluationPointCardPageList$1 = (EvaluationNetwork$getEvaluationPointCardPageList$1) continuation;
            if ((evaluationNetwork$getEvaluationPointCardPageList$1.label & Integer.MIN_VALUE) != 0) {
                evaluationNetwork$getEvaluationPointCardPageList$1.label -= Integer.MIN_VALUE;
            } else {
                evaluationNetwork$getEvaluationPointCardPageList$1 = new EvaluationNetwork$getEvaluationPointCardPageList$1(this, continuation);
            }
        } else {
            evaluationNetwork$getEvaluationPointCardPageList$1 = new EvaluationNetwork$getEvaluationPointCardPageList$1(this, continuation);
        }
        Object obj = evaluationNetwork$getEvaluationPointCardPageList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = evaluationNetwork$getEvaluationPointCardPageList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        EvaluationNetwork$getEvaluationPointCardPageList$2 evaluationNetwork$getEvaluationPointCardPageList$2 = new EvaluationNetwork$getEvaluationPointCardPageList$2(requestBody, null);
        evaluationNetwork$getEvaluationPointCardPageList$1.label = 1;
        Object obj2 = m485getResultgIAlus(evaluationNetwork$getEvaluationPointCardPageList$2, evaluationNetwork$getEvaluationPointCardPageList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getEvaluationPointCardDetails-gIAlu-s, reason: not valid java name */
    public final Object m502getEvaluationPointCardDetailsgIAlus(RequestBody requestBody, Continuation<? super Result<EvaluationPointCardCancelBean>> continuation) {
        EvaluationNetwork$getEvaluationPointCardDetails$1 evaluationNetwork$getEvaluationPointCardDetails$1;
        if (continuation instanceof EvaluationNetwork$getEvaluationPointCardDetails$1) {
            evaluationNetwork$getEvaluationPointCardDetails$1 = (EvaluationNetwork$getEvaluationPointCardDetails$1) continuation;
            if ((evaluationNetwork$getEvaluationPointCardDetails$1.label & Integer.MIN_VALUE) != 0) {
                evaluationNetwork$getEvaluationPointCardDetails$1.label -= Integer.MIN_VALUE;
            } else {
                evaluationNetwork$getEvaluationPointCardDetails$1 = new EvaluationNetwork$getEvaluationPointCardDetails$1(this, continuation);
            }
        } else {
            evaluationNetwork$getEvaluationPointCardDetails$1 = new EvaluationNetwork$getEvaluationPointCardDetails$1(this, continuation);
        }
        Object obj = evaluationNetwork$getEvaluationPointCardDetails$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = evaluationNetwork$getEvaluationPointCardDetails$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        EvaluationNetwork$getEvaluationPointCardDetails$2 evaluationNetwork$getEvaluationPointCardDetails$2 = new EvaluationNetwork$getEvaluationPointCardDetails$2(requestBody, null);
        evaluationNetwork$getEvaluationPointCardDetails$1.label = 1;
        Object obj2 = m485getResultgIAlus(evaluationNetwork$getEvaluationPointCardDetails$2, evaluationNetwork$getEvaluationPointCardDetails$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getEvaluationPointPageList-gIAlu-s, reason: not valid java name */
    public final Object m505getEvaluationPointPageListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<EvaluationPointBean>>>> continuation) {
        EvaluationNetwork$getEvaluationPointPageList$1 evaluationNetwork$getEvaluationPointPageList$1;
        if (continuation instanceof EvaluationNetwork$getEvaluationPointPageList$1) {
            evaluationNetwork$getEvaluationPointPageList$1 = (EvaluationNetwork$getEvaluationPointPageList$1) continuation;
            if ((evaluationNetwork$getEvaluationPointPageList$1.label & Integer.MIN_VALUE) != 0) {
                evaluationNetwork$getEvaluationPointPageList$1.label -= Integer.MIN_VALUE;
            } else {
                evaluationNetwork$getEvaluationPointPageList$1 = new EvaluationNetwork$getEvaluationPointPageList$1(this, continuation);
            }
        } else {
            evaluationNetwork$getEvaluationPointPageList$1 = new EvaluationNetwork$getEvaluationPointPageList$1(this, continuation);
        }
        Object obj = evaluationNetwork$getEvaluationPointPageList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = evaluationNetwork$getEvaluationPointPageList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        EvaluationNetwork$getEvaluationPointPageList$2 evaluationNetwork$getEvaluationPointPageList$2 = new EvaluationNetwork$getEvaluationPointPageList$2(requestBody, null);
        evaluationNetwork$getEvaluationPointPageList$1.label = 1;
        Object obj2 = m485getResultgIAlus(evaluationNetwork$getEvaluationPointPageList$2, evaluationNetwork$getEvaluationPointPageList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getEvaluationPointDetails-0E7RQCE, reason: not valid java name */
    public final Object m504getEvaluationPointDetails0E7RQCE(String str, String str2, Continuation<? super Result<EvaluationPointBean>> continuation) {
        EvaluationNetwork$getEvaluationPointDetails$1 evaluationNetwork$getEvaluationPointDetails$1;
        if (continuation instanceof EvaluationNetwork$getEvaluationPointDetails$1) {
            evaluationNetwork$getEvaluationPointDetails$1 = (EvaluationNetwork$getEvaluationPointDetails$1) continuation;
            if ((evaluationNetwork$getEvaluationPointDetails$1.label & Integer.MIN_VALUE) != 0) {
                evaluationNetwork$getEvaluationPointDetails$1.label -= Integer.MIN_VALUE;
            } else {
                evaluationNetwork$getEvaluationPointDetails$1 = new EvaluationNetwork$getEvaluationPointDetails$1(this, continuation);
            }
        } else {
            evaluationNetwork$getEvaluationPointDetails$1 = new EvaluationNetwork$getEvaluationPointDetails$1(this, continuation);
        }
        Object obj = evaluationNetwork$getEvaluationPointDetails$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = evaluationNetwork$getEvaluationPointDetails$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        EvaluationNetwork$getEvaluationPointDetails$2 evaluationNetwork$getEvaluationPointDetails$2 = new EvaluationNetwork$getEvaluationPointDetails$2(str, str2, null);
        evaluationNetwork$getEvaluationPointDetails$1.label = 1;
        Object obj2 = m485getResultgIAlus(evaluationNetwork$getEvaluationPointDetails$2, evaluationNetwork$getEvaluationPointDetails$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getEvaluationMedalTypeList-IoAF18A, reason: not valid java name */
    public final Object m501getEvaluationMedalTypeListIoAF18A(Continuation<? super Result<? extends List<EvaluationMedalTypeBean>>> continuation) {
        EvaluationNetwork$getEvaluationMedalTypeList$1 evaluationNetwork$getEvaluationMedalTypeList$1;
        if (continuation instanceof EvaluationNetwork$getEvaluationMedalTypeList$1) {
            evaluationNetwork$getEvaluationMedalTypeList$1 = (EvaluationNetwork$getEvaluationMedalTypeList$1) continuation;
            if ((evaluationNetwork$getEvaluationMedalTypeList$1.label & Integer.MIN_VALUE) != 0) {
                evaluationNetwork$getEvaluationMedalTypeList$1.label -= Integer.MIN_VALUE;
            } else {
                evaluationNetwork$getEvaluationMedalTypeList$1 = new EvaluationNetwork$getEvaluationMedalTypeList$1(this, continuation);
            }
        } else {
            evaluationNetwork$getEvaluationMedalTypeList$1 = new EvaluationNetwork$getEvaluationMedalTypeList$1(this, continuation);
        }
        Object obj = evaluationNetwork$getEvaluationMedalTypeList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = evaluationNetwork$getEvaluationMedalTypeList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        EvaluationNetwork$getEvaluationMedalTypeList$2 evaluationNetwork$getEvaluationMedalTypeList$2 = new EvaluationNetwork$getEvaluationMedalTypeList$2(null);
        evaluationNetwork$getEvaluationMedalTypeList$1.label = 1;
        Object obj2 = m485getResultgIAlus(evaluationNetwork$getEvaluationMedalTypeList$2, evaluationNetwork$getEvaluationMedalTypeList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
