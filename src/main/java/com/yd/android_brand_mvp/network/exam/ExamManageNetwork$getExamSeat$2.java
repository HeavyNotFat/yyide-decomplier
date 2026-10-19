package com.yd.android_brand_mvp.network.exam;

import com.yd.android_brand_mvp.model.exam.ExamPersonSeatBean;
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

/* JADX INFO: compiled from: ExamManageNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "", "Lcom/yd/android_brand_mvp/model/exam/ExamPersonSeatBean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.exam.ExamManageNetwork$getExamSeat$2", f = "ExamManageNetwork.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
final class ExamManageNetwork$getExamSeat$2 extends SuspendLambda implements Function1<Continuation<? super BaseResponse<List<? extends ExamPersonSeatBean>>>, Object> {
    final /* synthetic */ RequestBody $requestBody;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExamManageNetwork$getExamSeat$2(RequestBody requestBody, Continuation<? super ExamManageNetwork$getExamSeat$2> continuation) {
        super(1, continuation);
        this.$requestBody = requestBody;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ExamManageNetwork$getExamSeat$2(this.$requestBody, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super BaseResponse<List<? extends ExamPersonSeatBean>>> continuation) {
        return invoke2((Continuation<? super BaseResponse<List<ExamPersonSeatBean>>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super BaseResponse<List<ExamPersonSeatBean>>> continuation) {
        return ((ExamManageNetwork$getExamSeat$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ExamManageNetwork.INSTANCE.getService().requestExamPersonSeat(this.$requestBody, this);
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
