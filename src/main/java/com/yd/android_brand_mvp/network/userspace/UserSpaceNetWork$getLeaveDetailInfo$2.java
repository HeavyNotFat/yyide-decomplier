package com.yd.android_brand_mvp.network.userspace;

import com.yd.android_brand_mvp.model.userspace.LeaveDetailBean;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UserSpaceNetWork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "Lcom/yd/android_brand_mvp/model/userspace/LeaveDetailBean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.userspace.UserSpaceNetWork$getLeaveDetailInfo$2", f = "UserSpaceNetWork.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
final class UserSpaceNetWork$getLeaveDetailInfo$2 extends SuspendLambda implements Function1<Continuation<? super BaseResponse<LeaveDetailBean>>, Object> {
    final /* synthetic */ String $id;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UserSpaceNetWork$getLeaveDetailInfo$2(String str, Continuation<? super UserSpaceNetWork$getLeaveDetailInfo$2> continuation) {
        super(1, continuation);
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new UserSpaceNetWork$getLeaveDetailInfo$2(this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super BaseResponse<LeaveDetailBean>> continuation) {
        return ((UserSpaceNetWork$getLeaveDetailInfo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = UserSpaceNetWork.INSTANCE.getService().requestLeaveDetail(this.$id, this);
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
