package com.yd.android_brand_mvp.network.patrol;

import com.yd.android_brand_mvp.model.VerifyPeopleBean;
import com.yd.android_brand_mvp.model.patrol.PatrolDetailBean;
import com.yd.android_brand_mvp.model.patrol.PatrolListBean;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: PatrolNetWork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ6\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f0\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0015\u0010\nJ*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0018\u0010\u0012J*\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001a\u0010\u0012J*\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001c\u0010\u0012\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/network/patrol/PatrolNetWork;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/patrol/IPatrolService;", "()V", "getPatrolDetail", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/patrol/PatrolDetailBean;", "id", "", "getPatrolDetail-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPatrolList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/patrol/PatrolListBean;", "requestBody", "Lokhttp3/RequestBody;", "getPatrolList-gIAlu-s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScanQrCodeResult", "Lcom/yd/android_brand_mvp/model/VerifyPeopleBean;", "getScanQrCodeResult-gIAlu-s", "patrolPunch", "", "patrolPunch-gIAlu-s", "submitPatrolTask", "submitPatrolTask-gIAlu-s", "updatePatrolPunch", "updatePatrolPunch-gIAlu-s", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PatrolNetWork extends BaseNetworkApi<IPatrolService> {
    public static final PatrolNetWork INSTANCE = new PatrolNetWork();

    private PatrolNetWork() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getScanQrCodeResult-gIAlu-s, reason: not valid java name */
    public final Object m522getScanQrCodeResultgIAlus(String str, Continuation<? super Result<VerifyPeopleBean>> continuation) {
        PatrolNetWork$getScanQrCodeResult$1 patrolNetWork$getScanQrCodeResult$1;
        if (continuation instanceof PatrolNetWork$getScanQrCodeResult$1) {
            patrolNetWork$getScanQrCodeResult$1 = (PatrolNetWork$getScanQrCodeResult$1) continuation;
            if ((patrolNetWork$getScanQrCodeResult$1.label & Integer.MIN_VALUE) != 0) {
                patrolNetWork$getScanQrCodeResult$1.label -= Integer.MIN_VALUE;
            } else {
                patrolNetWork$getScanQrCodeResult$1 = new PatrolNetWork$getScanQrCodeResult$1(this, continuation);
            }
        } else {
            patrolNetWork$getScanQrCodeResult$1 = new PatrolNetWork$getScanQrCodeResult$1(this, continuation);
        }
        Object obj = patrolNetWork$getScanQrCodeResult$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = patrolNetWork$getScanQrCodeResult$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        PatrolNetWork$getScanQrCodeResult$2 patrolNetWork$getScanQrCodeResult$2 = new PatrolNetWork$getScanQrCodeResult$2(str, null);
        patrolNetWork$getScanQrCodeResult$1.label = 1;
        Object obj2 = m485getResultgIAlus(patrolNetWork$getScanQrCodeResult$2, patrolNetWork$getScanQrCodeResult$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getPatrolList-gIAlu-s, reason: not valid java name */
    public final Object m521getPatrolListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<PatrolListBean>>>> continuation) {
        PatrolNetWork$getPatrolList$1 patrolNetWork$getPatrolList$1;
        if (continuation instanceof PatrolNetWork$getPatrolList$1) {
            patrolNetWork$getPatrolList$1 = (PatrolNetWork$getPatrolList$1) continuation;
            if ((patrolNetWork$getPatrolList$1.label & Integer.MIN_VALUE) != 0) {
                patrolNetWork$getPatrolList$1.label -= Integer.MIN_VALUE;
            } else {
                patrolNetWork$getPatrolList$1 = new PatrolNetWork$getPatrolList$1(this, continuation);
            }
        } else {
            patrolNetWork$getPatrolList$1 = new PatrolNetWork$getPatrolList$1(this, continuation);
        }
        Object obj = patrolNetWork$getPatrolList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = patrolNetWork$getPatrolList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        PatrolNetWork$getPatrolList$2 patrolNetWork$getPatrolList$2 = new PatrolNetWork$getPatrolList$2(requestBody, null);
        patrolNetWork$getPatrolList$1.label = 1;
        Object obj2 = m485getResultgIAlus(patrolNetWork$getPatrolList$2, patrolNetWork$getPatrolList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getPatrolDetail-gIAlu-s, reason: not valid java name */
    public final Object m520getPatrolDetailgIAlus(String str, Continuation<? super Result<PatrolDetailBean>> continuation) {
        PatrolNetWork$getPatrolDetail$1 patrolNetWork$getPatrolDetail$1;
        if (continuation instanceof PatrolNetWork$getPatrolDetail$1) {
            patrolNetWork$getPatrolDetail$1 = (PatrolNetWork$getPatrolDetail$1) continuation;
            if ((patrolNetWork$getPatrolDetail$1.label & Integer.MIN_VALUE) != 0) {
                patrolNetWork$getPatrolDetail$1.label -= Integer.MIN_VALUE;
            } else {
                patrolNetWork$getPatrolDetail$1 = new PatrolNetWork$getPatrolDetail$1(this, continuation);
            }
        } else {
            patrolNetWork$getPatrolDetail$1 = new PatrolNetWork$getPatrolDetail$1(this, continuation);
        }
        Object obj = patrolNetWork$getPatrolDetail$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = patrolNetWork$getPatrolDetail$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        PatrolNetWork$getPatrolDetail$2 patrolNetWork$getPatrolDetail$2 = new PatrolNetWork$getPatrolDetail$2(str, null);
        patrolNetWork$getPatrolDetail$1.label = 1;
        Object obj2 = m485getResultgIAlus(patrolNetWork$getPatrolDetail$2, patrolNetWork$getPatrolDetail$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: updatePatrolPunch-gIAlu-s, reason: not valid java name */
    public final Object m525updatePatrolPunchgIAlus(RequestBody requestBody, Continuation<? super Result<Boolean>> continuation) {
        PatrolNetWork$updatePatrolPunch$1 patrolNetWork$updatePatrolPunch$1;
        if (continuation instanceof PatrolNetWork$updatePatrolPunch$1) {
            patrolNetWork$updatePatrolPunch$1 = (PatrolNetWork$updatePatrolPunch$1) continuation;
            if ((patrolNetWork$updatePatrolPunch$1.label & Integer.MIN_VALUE) != 0) {
                patrolNetWork$updatePatrolPunch$1.label -= Integer.MIN_VALUE;
            } else {
                patrolNetWork$updatePatrolPunch$1 = new PatrolNetWork$updatePatrolPunch$1(this, continuation);
            }
        } else {
            patrolNetWork$updatePatrolPunch$1 = new PatrolNetWork$updatePatrolPunch$1(this, continuation);
        }
        Object obj = patrolNetWork$updatePatrolPunch$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = patrolNetWork$updatePatrolPunch$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        PatrolNetWork$updatePatrolPunch$2 patrolNetWork$updatePatrolPunch$2 = new PatrolNetWork$updatePatrolPunch$2(requestBody, null);
        patrolNetWork$updatePatrolPunch$1.label = 1;
        Object obj2 = m485getResultgIAlus(patrolNetWork$updatePatrolPunch$2, patrolNetWork$updatePatrolPunch$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: submitPatrolTask-gIAlu-s, reason: not valid java name */
    public final Object m524submitPatrolTaskgIAlus(RequestBody requestBody, Continuation<? super Result<Boolean>> continuation) {
        PatrolNetWork$submitPatrolTask$1 patrolNetWork$submitPatrolTask$1;
        if (continuation instanceof PatrolNetWork$submitPatrolTask$1) {
            patrolNetWork$submitPatrolTask$1 = (PatrolNetWork$submitPatrolTask$1) continuation;
            if ((patrolNetWork$submitPatrolTask$1.label & Integer.MIN_VALUE) != 0) {
                patrolNetWork$submitPatrolTask$1.label -= Integer.MIN_VALUE;
            } else {
                patrolNetWork$submitPatrolTask$1 = new PatrolNetWork$submitPatrolTask$1(this, continuation);
            }
        } else {
            patrolNetWork$submitPatrolTask$1 = new PatrolNetWork$submitPatrolTask$1(this, continuation);
        }
        Object obj = patrolNetWork$submitPatrolTask$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = patrolNetWork$submitPatrolTask$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        PatrolNetWork$submitPatrolTask$2 patrolNetWork$submitPatrolTask$2 = new PatrolNetWork$submitPatrolTask$2(requestBody, null);
        patrolNetWork$submitPatrolTask$1.label = 1;
        Object obj2 = m485getResultgIAlus(patrolNetWork$submitPatrolTask$2, patrolNetWork$submitPatrolTask$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: patrolPunch-gIAlu-s, reason: not valid java name */
    public final Object m523patrolPunchgIAlus(RequestBody requestBody, Continuation<? super Result<Boolean>> continuation) {
        PatrolNetWork$patrolPunch$1 patrolNetWork$patrolPunch$1;
        if (continuation instanceof PatrolNetWork$patrolPunch$1) {
            patrolNetWork$patrolPunch$1 = (PatrolNetWork$patrolPunch$1) continuation;
            if ((patrolNetWork$patrolPunch$1.label & Integer.MIN_VALUE) != 0) {
                patrolNetWork$patrolPunch$1.label -= Integer.MIN_VALUE;
            } else {
                patrolNetWork$patrolPunch$1 = new PatrolNetWork$patrolPunch$1(this, continuation);
            }
        } else {
            patrolNetWork$patrolPunch$1 = new PatrolNetWork$patrolPunch$1(this, continuation);
        }
        Object obj = patrolNetWork$patrolPunch$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = patrolNetWork$patrolPunch$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        PatrolNetWork$patrolPunch$2 patrolNetWork$patrolPunch$2 = new PatrolNetWork$patrolPunch$2(requestBody, null);
        patrolNetWork$patrolPunch$1.label = 1;
        Object obj2 = m485getResultgIAlus(patrolNetWork$patrolPunch$2, patrolNetWork$patrolPunch$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
