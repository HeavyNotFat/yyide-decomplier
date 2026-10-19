package com.yd.android_brand_mvp.network;

import com.yd.android_brand_mvp.model.home.DominateCustomBean;
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

/* JADX INFO: compiled from: NetworkApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "", "Lcom/yd/android_brand_mvp/model/home/DominateCustomBean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.NetworkApi$getDominateCustomList$2", f = "NetworkApi.kt", i = {}, l = {338}, m = "invokeSuspend", n = {}, s = {})
final class NetworkApi$getDominateCustomList$2 extends SuspendLambda implements Function1<Continuation<? super BaseResponse<List<? extends DominateCustomBean>>>, Object> {
    final /* synthetic */ String $id;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NetworkApi$getDominateCustomList$2(String str, Continuation<? super NetworkApi$getDominateCustomList$2> continuation) {
        super(1, continuation);
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new NetworkApi$getDominateCustomList$2(this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super BaseResponse<List<? extends DominateCustomBean>>> continuation) {
        return invoke2((Continuation<? super BaseResponse<List<DominateCustomBean>>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super BaseResponse<List<DominateCustomBean>>> continuation) {
        return ((NetworkApi$getDominateCustomList$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = NetworkApi.INSTANCE.getService().requestCustomDominateScreenList(this.$id, this);
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
