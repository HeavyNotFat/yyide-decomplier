package com.yd.android_brand_mvp.network.ai;

import com.yd.android_brand_mvp.model.ai.AICreateSessionBean;
import com.yd.android_brand_mvp.model.ai.AIIntellectHomeBean;
import com.yd.android_brand_mvp.model.ai.AIModelBean;
import com.yd.android_brand_mvp.model.ai.AIProblemBean;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: AINetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\r\u0010\nJ0\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\nJ0\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0014\u0010\n\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/network/ai/AINetwork;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/ai/IAIService;", "()V", "requestAICreateSession", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/ai/AICreateSessionBean;", "requestBody", "Lokhttp3/RequestBody;", "requestAICreateSession-gIAlu-s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestAIGetInfo", "Lcom/yd/android_brand_mvp/model/ai/AIProblemBean;", "requestAIGetInfo-gIAlu-s", "requestAIHomeList", "", "Lcom/yd/android_brand_mvp/model/ai/AIIntellectHomeBean;", "requestAIHomeList-gIAlu-s", "requestAIModelList", "Lcom/yd/android_brand_mvp/model/ai/AIModelBean;", "requestAIModelList-gIAlu-s", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AINetwork extends BaseNetworkApi<IAIService> {
    public static final AINetwork INSTANCE = new AINetwork();

    private AINetwork() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestAIHomeList-gIAlu-s, reason: not valid java name */
    public final Object m483requestAIHomeListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<AIIntellectHomeBean>>> continuation) {
        AINetwork$requestAIHomeList$1 aINetwork$requestAIHomeList$1;
        if (continuation instanceof AINetwork$requestAIHomeList$1) {
            aINetwork$requestAIHomeList$1 = (AINetwork$requestAIHomeList$1) continuation;
            if ((aINetwork$requestAIHomeList$1.label & Integer.MIN_VALUE) != 0) {
                aINetwork$requestAIHomeList$1.label -= Integer.MIN_VALUE;
            } else {
                aINetwork$requestAIHomeList$1 = new AINetwork$requestAIHomeList$1(this, continuation);
            }
        } else {
            aINetwork$requestAIHomeList$1 = new AINetwork$requestAIHomeList$1(this, continuation);
        }
        Object obj = aINetwork$requestAIHomeList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = aINetwork$requestAIHomeList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        AINetwork$requestAIHomeList$2 aINetwork$requestAIHomeList$2 = new AINetwork$requestAIHomeList$2(requestBody, null);
        aINetwork$requestAIHomeList$1.label = 1;
        Object obj2 = m485getResultgIAlus(aINetwork$requestAIHomeList$2, aINetwork$requestAIHomeList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestAIModelList-gIAlu-s, reason: not valid java name */
    public final Object m484requestAIModelListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<AIModelBean>>> continuation) {
        AINetwork$requestAIModelList$1 aINetwork$requestAIModelList$1;
        if (continuation instanceof AINetwork$requestAIModelList$1) {
            aINetwork$requestAIModelList$1 = (AINetwork$requestAIModelList$1) continuation;
            if ((aINetwork$requestAIModelList$1.label & Integer.MIN_VALUE) != 0) {
                aINetwork$requestAIModelList$1.label -= Integer.MIN_VALUE;
            } else {
                aINetwork$requestAIModelList$1 = new AINetwork$requestAIModelList$1(this, continuation);
            }
        } else {
            aINetwork$requestAIModelList$1 = new AINetwork$requestAIModelList$1(this, continuation);
        }
        Object obj = aINetwork$requestAIModelList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = aINetwork$requestAIModelList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        AINetwork$requestAIModelList$2 aINetwork$requestAIModelList$2 = new AINetwork$requestAIModelList$2(requestBody, null);
        aINetwork$requestAIModelList$1.label = 1;
        Object obj2 = m485getResultgIAlus(aINetwork$requestAIModelList$2, aINetwork$requestAIModelList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestAICreateSession-gIAlu-s, reason: not valid java name */
    public final Object m481requestAICreateSessiongIAlus(RequestBody requestBody, Continuation<? super Result<AICreateSessionBean>> continuation) {
        AINetwork$requestAICreateSession$1 aINetwork$requestAICreateSession$1;
        if (continuation instanceof AINetwork$requestAICreateSession$1) {
            aINetwork$requestAICreateSession$1 = (AINetwork$requestAICreateSession$1) continuation;
            if ((aINetwork$requestAICreateSession$1.label & Integer.MIN_VALUE) != 0) {
                aINetwork$requestAICreateSession$1.label -= Integer.MIN_VALUE;
            } else {
                aINetwork$requestAICreateSession$1 = new AINetwork$requestAICreateSession$1(this, continuation);
            }
        } else {
            aINetwork$requestAICreateSession$1 = new AINetwork$requestAICreateSession$1(this, continuation);
        }
        Object obj = aINetwork$requestAICreateSession$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = aINetwork$requestAICreateSession$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        AINetwork$requestAICreateSession$2 aINetwork$requestAICreateSession$2 = new AINetwork$requestAICreateSession$2(requestBody, null);
        aINetwork$requestAICreateSession$1.label = 1;
        Object obj2 = m485getResultgIAlus(aINetwork$requestAICreateSession$2, aINetwork$requestAICreateSession$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestAIGetInfo-gIAlu-s, reason: not valid java name */
    public final Object m482requestAIGetInfogIAlus(RequestBody requestBody, Continuation<? super Result<AIProblemBean>> continuation) {
        AINetwork$requestAIGetInfo$1 aINetwork$requestAIGetInfo$1;
        if (continuation instanceof AINetwork$requestAIGetInfo$1) {
            aINetwork$requestAIGetInfo$1 = (AINetwork$requestAIGetInfo$1) continuation;
            if ((aINetwork$requestAIGetInfo$1.label & Integer.MIN_VALUE) != 0) {
                aINetwork$requestAIGetInfo$1.label -= Integer.MIN_VALUE;
            } else {
                aINetwork$requestAIGetInfo$1 = new AINetwork$requestAIGetInfo$1(this, continuation);
            }
        } else {
            aINetwork$requestAIGetInfo$1 = new AINetwork$requestAIGetInfo$1(this, continuation);
        }
        Object obj = aINetwork$requestAIGetInfo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = aINetwork$requestAIGetInfo$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        AINetwork$requestAIGetInfo$2 aINetwork$requestAIGetInfo$2 = new AINetwork$requestAIGetInfo$2(requestBody, null);
        aINetwork$requestAIGetInfo$1.label = 1;
        Object obj2 = m485getResultgIAlus(aINetwork$requestAIGetInfo$2, aINetwork$requestAIGetInfo$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
