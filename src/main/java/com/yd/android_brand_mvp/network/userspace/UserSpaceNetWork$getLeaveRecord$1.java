package com.yd.android_brand_mvp.network.userspace;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: UserSpaceNetWork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.userspace.UserSpaceNetWork", f = "UserSpaceNetWork.kt", i = {}, l = {28}, m = "getLeaveRecord-gIAlu-s", n = {}, s = {})
final class UserSpaceNetWork$getLeaveRecord$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserSpaceNetWork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UserSpaceNetWork$getLeaveRecord$1(UserSpaceNetWork userSpaceNetWork, Continuation<? super UserSpaceNetWork$getLeaveRecord$1> continuation) {
        super(continuation);
        this.this$0 = userSpaceNetWork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM543getLeaveRecordgIAlus = this.this$0.m543getLeaveRecordgIAlus(null, this);
        return objM543getLeaveRecordgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM543getLeaveRecordgIAlus : Result.m590boximpl(objM543getLeaveRecordgIAlus);
    }
}
