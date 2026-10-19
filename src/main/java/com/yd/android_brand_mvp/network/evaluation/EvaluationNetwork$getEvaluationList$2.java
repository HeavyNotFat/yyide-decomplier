package com.yd.android_brand_mvp.network.evaluation;

import com.yd.android_brand_mvp.model.evaluation.EvaluationBean;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: EvaluationNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationBean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.evaluation.EvaluationNetwork$getEvaluationList$2", f = "EvaluationNetwork.kt", i = {}, l = {17}, m = "invokeSuspend", n = {}, s = {})
final class EvaluationNetwork$getEvaluationList$2 extends SuspendLambda implements Function1<Continuation<? super BaseResponse<List<EvaluationBean>>>, Object> {
    final /* synthetic */ RequestBody $requestBody;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EvaluationNetwork$getEvaluationList$2(RequestBody requestBody, Continuation<? super EvaluationNetwork$getEvaluationList$2> continuation) {
        super(1, continuation);
        this.$requestBody = requestBody;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new EvaluationNetwork$getEvaluationList$2(this.$requestBody, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super BaseResponse<List<EvaluationBean>>> continuation) {
        return ((EvaluationNetwork$getEvaluationList$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = EvaluationNetwork.INSTANCE.getService().requestEvaluationList(this.$requestBody, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
