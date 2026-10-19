package com.yd.android_brand_mvp.network;

import com.yd.android_brand_mvp.model.getUserSigByUserIdRsp;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NetworkApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "Lcom/yd/android_brand_mvp/model/getUserSigByUserIdRsp$DataBean;", "Lcom/yd/android_brand_mvp/model/getUserSigByUserIdRsp;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.NetworkApi$getUserSig$2", f = "NetworkApi.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
final class NetworkApi$getUserSig$2 extends SuspendLambda implements Function1<Continuation<? super BaseResponse<getUserSigByUserIdRsp.DataBean>>, Object> {
    final /* synthetic */ String $userId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NetworkApi$getUserSig$2(String str, Continuation<? super NetworkApi$getUserSig$2> continuation) {
        super(1, continuation);
        this.$userId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new NetworkApi$getUserSig$2(this.$userId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super BaseResponse<getUserSigByUserIdRsp.DataBean>> continuation) {
        return ((NetworkApi$getUserSig$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = NetworkApi.INSTANCE.getService().getUserSig(this.$userId, this);
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
